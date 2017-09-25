package kr.co.mcmall.pay.ini.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inicis.std.util.HttpUtil;
import com.inicis.std.util.ParseUtil;
import com.inicis.std.util.SignatureUtil;

import egovframework.rte.fdl.property.EgovPropertyService;



@Controller
public class IniPayController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 주문 서비스 */
//	@Resource(name = "ddFndOrd001Service")
//	private DdFndOrd001Service ddFndOrd001Service;
	
	
	
	
	@RequestMapping(value = "/INIStdPayWebReturn.do")
	public String selectINIStdPayWebReturn(
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		String isSucc = "N";
		String ordNo = "";
		
		try{

			//#############################
			// 인증결과 파라미터 일괄 수신
			//#############################
			request.setCharacterEncoding("UTF-8");

			Map<String,String> paramMap = new Hashtable<String,String>();

			Enumeration elems = request.getParameterNames();

			String temp = "";

			while(elems.hasMoreElements())
			{
				temp = (String) elems.nextElement();
				paramMap.put(temp, request.getParameter(temp));
			}
			
			//System.out.println("paramMap : "+ paramMap.toString());
			
			
	        
	        
			//#####################
			// 인증이 성공일 경우만
			//#####################
			if("0000".equals(paramMap.get("resultCode"))){

				//out.println("####인증성공/승인요청####");
				//out.println("<br/>");
				System.out.println("####인증성공/승인요청####");

				//############################################
				// 1.전문 필드 값 설정(***가맹점 개발수정***)
				//############################################
				
				String mid 		= (String)paramMap.get("mid");					// 가맹점 ID 수신 받은 데이터로 설정
				
				String signKey	= propertiesService.getString("signKey");	// 가맹점에 제공된 키(이니라이트키) (가맹점 수정후 고정) !!!절대!! 전문 데이터로 설정금지
				
				String timestamp= SignatureUtil.getTimestamp();			// util에 의해서 자동생성

				String charset 	= "UTF-8";								// 리턴형식[UTF-8,EUC-KR](가맹점 수정후 고정)
				
				String format 	= "JSON";								// 리턴형식[XML,JSON,NVP](가맹점 수정후 고정)
				
				String authToken= (String)paramMap.get("authToken");			// 취소 요청 tid에 따라서 유동적(가맹점 수정후 고정)

				String authUrl	= (String)paramMap.get("authUrl");				// 승인요청 API url(수신 받은 값으로 설정, 임의 세팅 금지)

				String netCancel= (String)paramMap.get("netCancelUrl");			// 망취소 API url(수신 받은 값으로 설정, 임의 세팅 금지)

			
				//#####################
				// 2.signature 생성
				//#####################
				Map<String, String> signParam = new HashMap<String, String>();

				signParam.put("authToken",	authToken);		// 필수
				signParam.put("timestamp",	timestamp);		// 필수

				// signature 데이터 생성 (모듈에서 자동으로 signParam을 알파벳 순으로 정렬후 NVP 방식으로 나열해 hash)
				String signature = SignatureUtil.makeSignature(signParam);
	      
				String price = "";  // 가맹점에서 최종 결제 가격 표기 (필수입력아님)
	            
				//#####################
				// 3.API 요청 전문 생성
				//#####################
				Map<String, String> authMap = new Hashtable<String, String>();

				authMap.put("mid"			,mid);			// 필수
				authMap.put("authToken"		,authToken);	// 필수
				authMap.put("signature"		,signature);	// 필수
				authMap.put("timestamp"		,timestamp);	// 필수
				authMap.put("charset"		,charset);		// default=UTF-8
				authMap.put("format"		,format);		// default=XML
				//authMap.put("price" 		,price);		// 가격위변조체크기능 (선택사용)
	      
				System.out.println("##승인요청 API 요청##");

				HttpUtil httpUtil = new HttpUtil();

				try{
					//#####################
					// 4.API 통신 시작
					//#####################

					String authResultString = "";

					authResultString = httpUtil.processHTTP(authMap, authUrl);
					
					//############################################################
					//5.API 통신결과 처리(***가맹점 개발수정***)
					//############################################################
					System.out.println("## 승인 API 결과 ##");
					
					String test = authResultString.replace(",", "&").replace(":", "=").replace("\"", "").replace(" ","").replace("\n", "").replace("}", "").replace("{", "");
					
					Map<String, String> resultMap = new HashMap<String, String>();
					
					resultMap = ParseUtil.parseStringToMap(test); //문자열을 MAP형식으로 파싱
									
					model.addAttribute("resultMap", resultMap);
					
					
					/*************************  결제보안 강화 2016-05-18 START ****************************/ 
					Map<String , String> secureMap = new HashMap<String, String>();
					secureMap.put("mid"			, mid);								//mid
					secureMap.put("tstamp"		, timestamp);						//timestemp
					secureMap.put("MOID"		, resultMap.get("MOID"));			//MOID
					secureMap.put("TotPrice"	, resultMap.get("TotPrice"));		//TotPrice
					
					// signature 데이터 생성 
					String secureSignature = SignatureUtil.makeSignatureAuth(secureMap);
					/*************************  결제보안 강화 2016-05-18 END ****************************/

					
					// 내용 표기
					if("0000".equals(resultMap.get("resultCode")) && secureSignature.equals(resultMap.get("authSignature")) ){	//결제보안 강화 2016-05-18
					   /*****************************************************************************
				       * 여기에 가맹점 내부 DB에 결제 결과를 반영하는 관련 프로그램 코드를 구현한다.  
					   
						 [중요!] 승인내용에 이상이 없음을 확인한 뒤 가맹점 DB에 해당건이 정상처리 되었음을 반영함
								  처리중 에러 발생시 망취소를 한다.
				       ******************************************************************************/
						
						//DB update 처리
						
						UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO"); 
						
						Map<String,String> saveParamMap = new HashMap<String,String>();
//						saveParamMap.put("ordNo", (String)resultMap.get("MOID"));
//						saveParamMap.put("usrId", userInfoVO.getUsrId());
//						
						
						
						saveParamMap.put("dpstAmt", (String)resultMap.get("TotPrice"));
						saveParamMap.put("tid", (String)resultMap.get("tid"));
						saveParamMap.put("applNum", (String)resultMap.get("applNum"));
						saveParamMap.put("payDivCd", "ACC001002");
						saveParamMap.put("payMthCd", (String)resultMap.get("payMethod"));
						
						
						saveParamMap.put("vactBnkCd", 	(String)resultMap.get("VACT_BankCode"));
						saveParamMap.put("vactNo", 		(String)resultMap.get("VACT_Num"));
						saveParamMap.put("vactNm", 		(String)resultMap.get("VACT_Name"));
						saveParamMap.put("vactDt", 		(String)resultMap.get("VACT_Date"));
						saveParamMap.put("vactTm", 		(String)resultMap.get("VACT_Time"));
						
						
						
						// 주문 테이블 업데이트
//						ddFndOrd001Service.updatePayInfo(saveParamMap);
						
						// 입급내역 저장
//						ddFndOrd001Service.insertAccRcvInfoProc(saveParamMap);
						
						isSucc = "Y";
						ordNo = (String)resultMap.get("MOID");
							  
					} else {
						//결제보안키가 다른 경우
						if (!secureSignature.equals(resultMap.get("authSignature"))) {
							//결과정보
							//망취소
							if ("0000".equals(resultMap.get("resultCode"))) {
								throw new Exception("데이터 위변조 체크 실패");
							}
						}
						
					}
						
						
					
					//throw new Exception("강제 Exception");
					
					
				} catch (Exception ex) {

					//####################################
					// 실패시 처리(***가맹점 개발수정***)
					//####################################

					//---- db 저장 실패시 등 예외처리----//
					System.out.println("####################################################");
					System.out.println(ex);

					//#####################
					// 망취소 API
					//#####################
					String netcancelResultString = httpUtil.processHTTP(authMap, netCancel);	// 망취소 요청 API url(고정, 임의 세팅 금지)

					System.out.println("## 망취소 API 결과 ##");

					// 취소 결과 확인
					
					System.out.println("<p>"+netcancelResultString.replaceAll("<", "&lt;").replaceAll(">", "&gt;")+"</p>");
					
					
				}

			}else{

				//#############
				// 인증 실패시
				//#############
				//System.out.println("<br/>");
				//System.out.println("####인증실패####");

				System.out.println("<p>"+paramMap.toString()+"</p>");
			}

		}catch(Exception e){

			//System.out.println(e);
		}
		
		model.addAttribute("isSucc", isSucc);
		
		
		return "redirect:/fnd/ord/DdFndOrd001R14.do?ordNo="+ordNo+"&isSucc="+isSucc;
	}
	
	
	
		
}
