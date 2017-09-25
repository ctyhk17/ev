package kr.co.mcmall.mcm.shp.ord.web;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001Service;
import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001VO;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr001Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd001Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd001VO;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd003Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd003VO;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inicis.std.util.HttpUtil;
import com.inicis.std.util.ParseUtil;
import com.inicis.std.util.SignatureUtil;

import egovframework.rte.fdl.property.EgovPropertyService;



/**
 * @Class Name  : McmShpOrd001Controller.java
 * @Description : McmShpOrd001Controller Class
 *                주문 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.05.10                최초생성
 *
 * @author 
 * @since 2017.05.10
 * @version 1.0
 * @see
 *  
 */

@Controller
public class McmShpOrd001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 주문 서비스 */
	@Resource(name = "mcmShpOrd001Service")
	private McmShpOrd001Service mcmShpOrd001Service;
	
	
	/** 주문 서비스 */
	@Resource(name = "mcmShpOrd003Service")
	private McmShpOrd003Service mcmShpOrd003Service;
	
	
	/** 사용자정보 */
	@Resource(name = "mcmCmnUsr001Service")
	private McmCmnUsr001Service mcmCmnUsr001Service;
	
	/** 포인트 관리 서비스 */
	@Resource(name = "mcmCmnPot001Service")
	private McmCmnPot001Service mcmCmnPot001Service;
	
	/**
	 * 간편 URL를 해석한다.
	 * @param mcmShpOrd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmShpOrd001M00R.do")
	public String getViewMcmShpOrd001M00R(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

				
		// 홍보물 seq_no 넘버가 들어 오지 않는 경우
		if(mcmShpOrd001VO.getSeqNo() == null || "".equals(mcmShpOrd001VO.getSeqNo()))
		{
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('올바르지 않은 접근 입니다.');location.href='/McmMalItr001M01L.do';</script>");	        
	        out.flush(); 
	        
	        return null;
			
		// 홍보물 번호가 들어 왔지만 올바르지 않은 경우
		}else{

			String isValid = mcmShpOrd001Service.selectIsValidSeqNo(mcmShpOrd001VO.getSeqNo());
			if("N".equals(isValid))
			{
				response.setContentType("text/html; charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.println("<script>alert('올바르지 홍보 URL입니다.');location.href='/McmMalItr001M01L.do';</script>");	        
		        out.flush(); 
		        
		        return null;
		        
		    // 유효한 경우
			}else{
				
				
				// 상품번호, 사업자 번호 셋팅
				Map<?,?> resultInfo = mcmShpOrd001Service.selectPrInfo(mcmShpOrd001VO.getSeqNo());
				
				mcmShpOrd001VO.setLcsId((String)resultInfo.get("lcsId"));
				mcmShpOrd001VO.setGdsId((String)resultInfo.get("gdsId"));
				mcmShpOrd001VO.setGdsId((String)resultInfo.get("gdsId"));
			}
				
		}
		
		return "redirect:/McmShpOrd001M01R.do?lcsId="+mcmShpOrd001VO.getLcsId()
				+ "&gdsId="+mcmShpOrd001VO.getGdsId()
				+ "&seqNo="+mcmShpOrd001VO.getSeqNo()
				;
		
	}
	
	/**
	 * 주문 화면 조회(STEP1) 
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmShpOrd001M01R.do")
	public String getViewMcmShpOrd001M01R(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		String gdsId = (String)request.getParameter("gdsId");
		
		System.out.println("gdsId : --------> " + gdsId);
		System.out.println("mcmShpOrd001VO.getGdsId() : " + mcmShpOrd001VO.getGdsId());
		
		// 상품정보 조회
		Map<?,?> resultInfo = mcmShpOrd001Service.selectGdsInfo(mcmShpOrd001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		mcmShpOrd001VO.setGdsAmt((String)resultInfo.get("gdsAmt")); 
		mcmShpOrd001VO.setLcsId((String)resultInfo.get("lcsId")); 
		
		
		// 상품상세 설명 조회
		List<?> gdsCntsList = mcmShpOrd001Service.selectGdsCntsList(mcmShpOrd001VO);
		model.addAttribute("gdsCntsList", gdsCntsList);
		
		
		
		// 상품키워드 조회
		List<?> keywordList = mcmShpOrd001Service.selectKeywordList(mcmShpOrd001VO);
		model.addAttribute("keywordList", keywordList);
		
		
		
		
		// 홍보물 아이디가 있는 경우 인사말 조회
		if(mcmShpOrd001VO.getSeqNo() != null && !"".equals(mcmShpOrd001VO.getSeqNo())){
		
			
			System.out.println("==================================  홍보물 조회");
			Map<?,?> prInfo = mcmShpOrd001Service.selectPrInfo(mcmShpOrd001VO.getSeqNo());
			model.addAttribute("prInfo", prInfo);
			
		}
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd001M01R";
	}
	
	
	/**
	 * 수량 선택화면으로 이동 
	 * @param pjtFnerAdsubMgntVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmShpOrd001M02R.do")
	public String getViewMcmShpOrd001M02R(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		/**
		 * dir : 바로구매
		 * cart : 장바구니
		 */
		
		String rtnUrl = commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd001M02R";
		
		// 로그인 여부 체크
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
	
		if(userInfoVO == null){
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('로그인이 필요한 서비스 입니다.');");
	        out.println("location.href='/McmCmnLgn001M01R.do';</script>");
	        out.println("</script>");	        
	        out.flush();
	        
	        
	        rtnUrl = "redirect:/McmCmnLgn001M01R.do?returnUrl=/McmShpOrd001M02R.do&gdsId="+mcmShpOrd001VO.getGdsId();
		
	        
		}else{
			Map<?,?> addrInfo = mcmCmnUsr001Service.getAddrInfo(userInfoVO.getUsrId()); 
			
			if("dir".equals(mcmShpOrd001VO.getOrdDiv())) {
				//상품정보 조회
				
				Map<?,?> resultInfo = mcmShpOrd001Service.selectGdsInfo(mcmShpOrd001VO);
				
				mcmShpOrd001VO.setGdsAmt((String)resultInfo.get("gdsAmt"));
				mcmShpOrd001VO.setUsrNm(userInfoVO.getUsrNm());
				mcmShpOrd001VO.setUsrId(userInfoVO.getUsrId());
				
				int gdsAmt = Integer.parseInt(mcmShpOrd001VO.getOrdCnt()) * Integer.parseInt((String) resultInfo.get("gdsAmt"));
				
				model.addAttribute("gdsAmt", Integer.toString(gdsAmt));				
				model.addAttribute("resultInfo", resultInfo);

				
				
			}else{
				
				McmShpOrd003VO mcmShpOrd003VO = new McmShpOrd003VO();
				mcmShpOrd003VO.setUsrId(userInfoVO.getUsrId());
				
				mcmShpOrd003VO.setCheckCrtId(mcmShpOrd001VO.getCrtId());
				
				List<?> resultList = mcmShpOrd003Service.selectShpOrdWishList(mcmShpOrd003VO);
				
				Map<?, ?> orderMap = mcmShpOrd003Service.selectShpOrdWishTot(mcmShpOrd003VO);
				
				
				model.addAttribute("resultList", resultList);
				model.addAttribute("orderMap", orderMap);
				model.addAttribute("gdsAmt", orderMap.get("ordAmtSum").toString());
				mcmShpOrd001VO.setUsrNm((String) orderMap.get("usrNm"));
				
				
			}
			model.addAttribute("addrInfo", addrInfo);
			
		}
		
		/*
		//*** 위변조 방지체크를 signature 생성 ***

			oid, price, timestamp 3개의 키와 값을

			key=value 형식으로 하여 '&'로 연결한 하여 SHA-256 Hash로 생성 된값

			ex) oid=INIpayTest_1432813606995&price=819000&timestamp=2012-02-01 09:19:04.004
				

			 * key기준 알파벳 정렬

			 * timestamp는 반드시 signature생성에 사용한 timestamp 값을 timestamp input에 그대로 사용하여야함
	*/

		//############################################
		// 1.전문 필드 값 설정(***가맹점 개발수정***)
		//############################################
	
		// 여기에 설정된 값은 Form 필드에 동일한 값으로 설정
		String mid					= "INIpayTest";		// 가맹점 ID(가맹점 수정후 고정)					
		
		//인증
		String signKey			    = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";	// 가맹점에 제공된 웹 표준 사인키(가맹점 수정후 고정)
		String timestamp			= SignatureUtil.getTimestamp();			// util에 의해서 자동생성
	
		
		
		String oid					= mid+"_"+SignatureUtil.getTimestamp();	// 가맹점 주문번호(가맹점에서 직접 설정)
		String price				= "1000";							// 상품가격(특수기호 제외, 가맹점에서 직접 설정)
	
		String cardNoInterestQuota	= "11-2:3:,34-5:12,14-6:12:24,12-12:36,06-9:12,01-3:4";		// 카드 무이자 여부 설정(가맹점에서 직접 설정)
		//String cardQuotaBase		= "2:3:4:5:6:11:12:24:36";		// 가맹점에서 사용할 할부 개월수 설정
		String cardQuotaBase		= "2:3";		// 가맹점에서 사용할 할부 개월수 설정
	
		//###############################################
		// 2. 가맹점 확인을 위한 signKey를 해시값으로 변경 (SHA-256방식 사용)
		//###############################################
		String mKey = SignatureUtil.hash(signKey, "SHA-256");
		
		//###############################################
		// 2.signature 생성
		//###############################################
		Map<String, String> signParam = new HashMap<String, String>();
	
		signParam.put("oid",		oid); 			// 필수
		signParam.put("price", 		price);			// 필수
		signParam.put("timestamp",	timestamp);		// 필수
	
		// signature 데이터 생성 (모듈에서 자동으로 signParam을 알파벳 순으로 정렬후 NVP 방식으로 나열해 hash)
		String signature = SignatureUtil.makeSignature(signParam);
		
		
		/* 기타 */
//		String siteDomain = "http://127.0.0.1:8080/INIpayStdSample"; //가맹점 도메인 입력
		
		// 페이지 URL에서 고정된 부분을 적는다. 
		// Ex) returnURL이 http://localhost:8080INIpayStdSample/INIStdPayReturn.jsp 라면
		// http://localhost:8080/INIpayStdSample 까지만 기입한다.
		
		//서버
//		String siteDomain = request.getScheme()+"://" + request.getServerName()";
		
		//로컬
		String siteDomain = "http://127.0.0.1:8080";
		
		model.addAttribute("mid", mid);
		model.addAttribute("signKey", signKey);
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("oid", oid);
		model.addAttribute("cardNoInterestQuota", cardNoInterestQuota);
		model.addAttribute("cardQuotaBase", cardQuotaBase);
		model.addAttribute("mKey", mKey);
		model.addAttribute("signature", signature);
		model.addAttribute("siteDomain", siteDomain);
		
		
		return rtnUrl;
	}
	
	
	/**
	 * 주문 처리(카드, 가상계좌, 계좌이체)
	 * @param mcmShpOrd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping(value = "/McmShpOrd001M02RP.do")
	public ModelAndView getViewMcmShpOrd001M02RP(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		commonService.setDefaultInfo(session, request, mcmShpOrd001VO);
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmShpOrd001VO.setUsrId(userInfoVO.getUsrId());
		
		// 주문내역 처리
		int ordDataCnt =  mcmShpOrd001Service.selectOrdCnt(mcmShpOrd001VO);
 		
 		if(ordDataCnt == 0) {
 			
 			McmCmnPot001VO mcmCmnPot001VO = new McmCmnPot001VO();
 			mcmShpOrd001Service.insertOrderInfo(mcmShpOrd001VO);
 			
 			if("dir".equals(mcmShpOrd001VO.getOrdDiv())){
 				//바로구매
 				mcmShpOrd001Service.insertOrderDetailInfo(mcmShpOrd001VO);
 					
 			}else{
 				//장바구니 구매
 				McmShpOrd003VO mcmShpOrd003VO = new McmShpOrd003VO();
 				
 				mcmShpOrd001Service.insertOrderDetailInfos(mcmShpOrd001VO);
 				
 				mcmShpOrd003VO.setCheckCrtId(mcmShpOrd001VO.getCrtId());
 				
 				//구매여부 완료로 변경
 				mcmShpOrd003Service.updateShpOrdCplt(mcmShpOrd003VO);
 				
 				/*for(String gdsId : mcmShpOrd001VO.getGdsIds()){
 					
 					mcmShpOrd001VO.setGdsId(gdsId);
 					
 					Map<?, ?> gdsMap = mcmShpOrd001Service.selectForGdsSelCnt(mcmShpOrd001VO);
 					
 					int selCnt = Integer.parseInt(gdsMap.get("selCnt").toString());
 					
 					Map<?, ?> ordMap = mcmShpOrd001Service.selectForGdsSale(mcmShpOrd001VO);
 					
 					int ordCnt = Integer.parseInt(ordMap.get("ordCnt").toString());
 					
 					selCnt = selCnt + ordCnt;
 					
 					mcmShpOrd001VO.setSelCnt(Integer.toString(selCnt));
 					
 					mcmShpOrd001Service.updateGdsSaleCnt(mcmShpOrd001VO);
 					
 				}*/
 			}
 		}
 		
		
		
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("jsonView");    
    	
    	
    	return modelAndView;
		
		
		
//			
//			
//			Device device = DeviceUtils.getCurrentDevice(request);
//			
//			
//	        if (device.isMobile()) {
//	        	rtnUrl = "redirect:/McmShpOrd001M04R.do";
//	            
//	        } else if (device.isTablet()) {
//	        	rtnUrl = "redirect:/McmShpOrd001M05R.do";
//	        }
			
		
		
	}
	
	
	/**
	 * 주문처리(직접계좌이체)
	 * @param mcmShpOrd001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	
	@Transactional
	@RequestMapping(value = "/McmShpOrd001M22RP.do")
	public String getViewMcmShpOrd001M22RP(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		commonService.setDefaultInfo(session, request, mcmShpOrd001VO);
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmShpOrd001VO.setUsrId(userInfoVO.getUsrId());
		
		// 주문내역 처리
		
 	    String rtnVal = mcmShpOrd001Service.insertOrderInfo(mcmShpOrd001VO);
// 	    mcmShpOrd001Service.insertOrderInfo(mcmShpOrd001VO);
 	    
 	    mcmShpOrd001VO.setOrdNo(rtnVal);
 	    
 	    
 		McmCmnPot001VO mcmCmnPot001VO = new McmCmnPot001VO();
 		
 		System.out.println("mcmShpOrd001VO.getOrdDiv()===>"+mcmShpOrd001VO.getOrdDiv());
 	    
		if("dir".equals(mcmShpOrd001VO.getOrdDiv())){
			//바로구매
			
			mcmShpOrd001Service.insertOrderDetailInfo(mcmShpOrd001VO);
			
			
			
			//구매갯수 추가
			Map<?, ?> gdsMap = mcmShpOrd001Service.selectForGdsSelCnt(mcmShpOrd001VO);
			
			int selCnt = Integer.parseInt(gdsMap.get("selCnt").toString());
			
			Map<?, ?> ordMap = mcmShpOrd001Service.selectForGdsSale(mcmShpOrd001VO);
			
			int ordCnt = Integer.parseInt(ordMap.get("ordCnt").toString());
			
			selCnt = selCnt + ordCnt;
			
			mcmShpOrd001VO.setSelCnt(Integer.toString(selCnt));
			
			
			
			mcmShpOrd001Service.updateGdsSaleCnt(mcmShpOrd001VO);
			
			
		/*	//홍보자에게 포인트 
			if(ordMap.get("lcsId") != null ) {
				
//				System.out.println("lcsId=============>>"+ordMap.get("lcsId").toString());
//				
//				mcmCmnPot001VO.setLcsId((String) ordMap.get("lcsId"));
//				
//				mcmCmnPot001Service.selectUsrIdAboutLcsId(mcmCmnPot001VO);
				
			}*/
			
			
		}else{
			//장바구니 구매
			McmShpOrd003VO mcmShpOrd003VO = new McmShpOrd003VO();
			
			mcmShpOrd001Service.insertOrderDetailInfos(mcmShpOrd001VO);
			
			mcmShpOrd003VO.setCheckCrtId(mcmShpOrd001VO.getCrtId());
			
			mcmShpOrd003Service.updateShpOrdCplt(mcmShpOrd003VO);
			
			for(String gdsId : mcmShpOrd001VO.getGdsIds()){
				
				mcmShpOrd001VO.setGdsId(gdsId);
				
				Map<?, ?> gdsMap = mcmShpOrd001Service.selectForGdsSelCnt(mcmShpOrd001VO);
				
				int selCnt = Integer.parseInt(gdsMap.get("selCnt").toString());
				
				Map<?, ?> ordMap = mcmShpOrd001Service.selectForGdsSale(mcmShpOrd001VO);
				
				int ordCnt = Integer.parseInt(ordMap.get("ordCnt").toString());
				
				selCnt = selCnt + ordCnt;
				
				mcmShpOrd001VO.setSelCnt(Integer.toString(selCnt));
				
				mcmShpOrd001Service.updateGdsSaleCnt(mcmShpOrd001VO);
				
			}
		}
		
		//구매 포인트 등록
		int ordPot = 300;
		
		int ordCnt = "dir".equals(mcmShpOrd001VO.getOrdDiv()) ? 1 : mcmShpOrd001VO.getGdsIds().length;
		
		ordPot = ordPot * ordCnt ;
		
		
		mcmCmnPot001VO.setUsrId(userInfoVO.getUsrId());
		mcmCmnPot001VO.setPotCd("B");
		mcmCmnPot001VO.setPotSv(Integer.toString(ordPot));
		mcmCmnPot001VO.setOrdNo(mcmShpOrd001VO.getOrdNo());
		
		mcmCmnPot001Service.updateMcmCmnCurPot(mcmCmnPot001VO);
		
		
		String rtnUrl = "redirect:/McmShpOrd001M03R.do?ordNo="+rtnVal;
		
//			
//			
//			Device device = DeviceUtils.getCurrentDevice(request);
//			
//			
//	        if (device.isMobile()) {
//	        	rtnUrl = "redirect:/McmShpOrd001M04R.do";
//	            
//	        } else if (device.isTablet()) {
//	        	rtnUrl = "redirect:/McmShpOrd001M05R.do";
//	        }
			
		
		
		
		return rtnUrl;
		
		
		
		
	}

	
	/**
	 * 주문완료 (카드, 가상계좌입금, 계좌이체)
	 * @param mcmShpOrd001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmShpOrd001M32RP.do")
	public String getViewMcmShpOrd001M12R(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			@RequestParam(value="ordDiv", required = false) String ordDiv,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		/**
		 * 더 필요한 값이 있으실 경우
		 *  /INIpay/INIStdPayReturn.jsp를 확인하세요^^.
		 * 
		 */
		
		
		// 로그인 여부 체크
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
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
			
			
			
			//#####################
			// 인증이 성공일 경우만
			//#####################
			if("0000".equals(paramMap.get("resultCode"))){

				System.out.println("####인증성공/승인요청####");

				//############################################
				// 1.전문 필드 값 설정(***가맹점 개발수정***)
				//############################################
				
				String mid 		= paramMap.get("mid");					// 가맹점 ID 수신 받은 데이터로 설정
				String signKey	= "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";	// 가맹점에 제공된 키(이니라이트키) (가맹점 수정후 고정) !!!절대!! 전문 데이터로 설정금지
				String timestamp= SignatureUtil.getTimestamp();			// util에 의해서 자동생성
				String charset 	= "UTF-8";								// 리턴형식[UTF-8,EUC-KR](가맹점 수정후 고정)
				String format 	= "JSON";								// 리턴형식[XML,JSON,NVP](가맹점 수정후 고정)
				String authToken= paramMap.get("authToken");			// 취소 요청 tid에 따라서 유동적(가맹점 수정후 고정)
				String authUrl	= paramMap.get("authUrl");				// 승인요청 API url(수신 받은 값으로 설정, 임의 세팅 금지)
				String netCancel= paramMap.get("netCancelUrl");			// 망취소 API url(수신 받은 값으로 설정, 임의 세팅 금지)

			
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
					
					String test = authResultString.replace(",", "&").replace(":", "=").replace("\"", "").replace(" ","").replace("\n", "").replace("}", "").replace("{", "");
					
					//out.println("<pre>"+authResultString.replaceAll("<", "&lt;").replaceAll(">", "&gt;")+"</pre>");
					
					Map<String, String> resultMap = new HashMap<String, String>();
					
					resultMap = ParseUtil.parseStringToMap(test); //문자열을 MAP형식으로 파싱
									
					System.out.println("resultMap == " + resultMap);
					
					/*************************  결제보안 강화 2016-05-18 START ****************************/ 
					Map<String , String> secureMap = new HashMap<String, String>();
					secureMap.put("mid"			, mid);								//mid
					secureMap.put("tstamp"		, timestamp);						//timestemp
					secureMap.put("MOID"		, resultMap.get("MOID"));			//MOID
					secureMap.put("TotPrice"	, resultMap.get("TotPrice"));		//TotPrice
					
					
					
					
					// signature 데이터 생성 
					String secureSignature = SignatureUtil.makeSignatureAuth(secureMap);
					/*************************  결제보안 강화 2016-05-18 END ****************************/
					
					/*System.out.println("##################결제공통######################");
					System.out.println("INIPAY 구매번호=======>>"+resultMap.get("MOID"));
					System.out.println("모듈 TID=======>>"+resultMap.get("tid"));
					System.out.println("결제구분========>"+resultMap.get("payMethod"));
					
					System.out.println("##################가상계좌입급시######################");
					System.out.println("입금 계좌번호========>"+resultMap.get("VACT_Num"));
					System.out.println("은행코드========>"+resultMap.get("VACT_BankCode"));
					System.out.println("은행명========>"+resultMap.get("vactBankName"));
					System.out.println("예금주========>"+resultMap.get("VACT_Name"));
					System.out.println("송금자========>"+resultMap.get("VACT_InputName"));
					System.out.println("송금 일자========>"+resultMap.get("VACT_Date"));
					System.out.println("송금 시간========>"+resultMap.get("VACT_Time"));
					
					System.out.println("##################카드결제시######################");
					System.out.println("카드번호========>"+resultMap.get("CARD_Num"));
					System.out.println("승인번호========>"+resultMap.get("applNum"));
					
					System.out.println("##################계좌이체시######################");
					
					System.out.println("은행코드========>"+resultMap.get("ACCT_BankCode"));*/
					
					
					mcmShpOrd001VO.setOrdNo(resultMap.get("MOID"));
					mcmShpOrd001VO.setIniTid(resultMap.get("tid").toString());
					mcmShpOrd001VO.setUsrId(userInfoVO.getUsrId());
					mcmShpOrd001VO.setPayDivCd(resultMap.get("payMethod").toString());
					
					List<?> resultList = mcmShpOrd001Service.selectOrdInfo(mcmShpOrd001VO);
					
					Map<?, ?> usrMap = mcmShpOrd001Service.selectUsrOrdInfo(mcmShpOrd001VO);
					
					mcmShpOrd001VO.setPayAmt(usrMap.get("ordTotAmt").toString());
					
					
					
					//결제완료	
					mcmShpOrd001Service.insertshpPayInfo(mcmShpOrd001VO);
					mcmShpOrd001Service.updateOrdPaySuccess(mcmShpOrd001VO);
					
					//포인트 등록
					int ordPot = 300; //300점이라고 잡아놨으나 추후 바꿔야함
					
					int ordCnt = resultList.size() > 0 ? resultList.size() : 1; //한개이상 구매인지 여부 확인
					
					ordPot = ordPot * ordCnt ; //한개이상일경우 물건갯수만큼의 포인트 합산
					
					McmCmnPot001VO mcmCmnPot001VO = new McmCmnPot001VO();
					
					mcmCmnPot001VO.setUsrId(userInfoVO.getUsrId());
					mcmCmnPot001VO.setPotCd("B"); 
					mcmCmnPot001VO.setPotSv(Integer.toString(ordPot));
					mcmCmnPot001VO.setOrdNo(mcmShpOrd001VO.getOrdNo());
					
					mcmCmnPot001Service.updateMcmCmnCurPot(mcmCmnPot001VO);
					
					
					model.addAttribute("resultList", resultList);
					model.addAttribute("usrMap", usrMap);
					model.addAttribute("resultMap", resultMap);
					
					
					//제품구매갯수 추가
					
					
					

					
				} catch (Exception ex) {

					//####################################
					// 실패시 처리(***가맹점 개발수정***)
					//####################################

					//---- db 저장 실패시 등 예외처리----//
					System.out.println("test=========>>"+ex);
					
					ex.printStackTrace();

					//#####################
					// 망취소 API
					//#####################
					String netcancelResultString = httpUtil.processHTTP(authMap, netCancel);	// 망취소 요청 API url(고정, 임의 세팅 금지)


					// 취소 결과 확인
				}

			}else{
				System.out.println("###인증실패###");
				System.out.println(paramMap.toString());
			}

		}catch(Exception e){

			System.out.println(e);
		}
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd001M04R";
		
	}
	
	
	
	/**
	 * 주문완료(직접계좌이체)
	 * @param mcmShpOrd001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmShpOrd001M03R.do")
	public String getViewMcmShpOrd001M03R(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO"); 
		
		
		mcmShpOrd001VO.setUsrId(userInfoVO.getUsrId());
		
		// 주문내역 조회
		Map<?,?> resultInfo = mcmShpOrd001Service.selectOrderInfo(mcmShpOrd001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd001M03R";
	}
//	
//	
//	
	/**
	 * 예매완료 (STEP1-3)  Mobile_WEB
	 * @param mcmShpOrd001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmShpOrd001M04R.do")
	public String selectDdFndOrd001R131(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO"); 
		
		
		mcmShpOrd001VO.setUsrId(userInfoVO.getUsrId());
		
		// 주문내역 조회
		Map<?,?> resultInfo = mcmShpOrd001Service.selectOrderInfo(mcmShpOrd001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		
		
//		String P_MID					= propertiesService.getString("mid");
//		String P_OID                = (String)resultInfo.get("ordNo");
//		String P_AMT				= (String)resultInfo.get("payAmt");
//		String siteDomain = request.getScheme()+"://" + request.getServerName()+"/INIpay";
//		
//		model.addAttribute("P_MID",  P_MID);
//		model.addAttribute("P_OID",  P_OID);
//		model.addAttribute("P_AMT",  P_AMT);
//		
//		model.addAttribute("siteDomain",  siteDomain);
		
		
			
		
		
		
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd001M04R";
	}

	
	
	
	/**
	 * 결제완료 
	 * @param mcmShpOrd001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmShpOrd001M05R.do")
	public String getViewMcmShpOrd001M05R(
			@ModelAttribute("mcmShpOrd001VO") McmShpOrd001VO mcmShpOrd001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO"); 
		mcmShpOrd001VO.setUsrId(userInfoVO.getUsrId());
		
		// 결제내역 주문내역 조회
		Map<?,?> resultInfo = mcmShpOrd001Service.selectOrderInfo(mcmShpOrd001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		
		return "fnd/ord/DdFndOrd001R14";
	}
	
	
	
	
}
