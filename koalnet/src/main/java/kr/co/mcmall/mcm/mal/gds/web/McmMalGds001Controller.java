package kr.co.mcmall.mcm.mal.gds.web;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.mcm.cmn.ccd.service.McmCmnCcd001Service;
import kr.co.mcmall.mcm.cmn.ccd.service.McmCmnCcd001VO;
import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.mal.gds.service.McmMalGds001Service;
import kr.co.mcmall.mcm.mal.gds.service.McmMalGds001VO;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : McmMalGds001Controller.java
 * @Description : McmMalGds001Controller Controller Class
 *                McmMalGds001Controller Controller 클래스 ( 상품관리 )
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017-06-20           최초생성
 *
 * @author 개발팀
 * @since 2017-06-20
 * @version 1.0
 * @see
 *  
 */
@Controller
public class McmMalGds001Controller {
 
		// 로그
		private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		
		/** 공통 서비스 선언 */
		@Resource(name = "commonService")
		protected CommonService commonService;
			
		/** 기본 프로퍼티 */
		@Resource(name = "propertiesService")
		protected EgovPropertyService propertiesService;
		
		/** 상품관리 서비스 */
		@Resource(name = "mcmMalGds001Service")
		protected McmMalGds001Service mcmMalGds001Service;
		
		/** 코드 서비스	 */
		@Resource(name = "mcmCmnCcd001Service")
		protected McmCmnCcd001Service mcmCmnCcd001Service;
		
		
		
		
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 
		 * 상품목록 조회 및 갯수 조회
		 */
		@RequestMapping(value="/McmMalGds001M01L.do")
		public String getViewMcmMalGds001M01L(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
			
			// 페이지 네비게이션 설정
			PaginationInfo paginationInfo = new PaginationInfo();
			commonService.getPageInfo( paginationInfo, mcmMalGds001VO.getPageIndex(), mcmMalGds001VO.getRecordCountPerPage());
			
			mcmMalGds001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
			mcmMalGds001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
			mcmMalGds001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
			
			List<?> resultList = mcmMalGds001Service.selectMcmMalGds001List(mcmMalGds001VO);
			
			int totCnt = mcmMalGds001Service.selectMcmMalGds001TotCnt(mcmMalGds001VO);
			paginationInfo.setTotalRecordCount(totCnt);
			
			model.addAttribute("resultList", resultList);
			model.addAttribute("paginationInfo", paginationInfo);
			model.addAttribute("totCnt", totCnt);
			
			return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M01L";
			
		}
		
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 상품등록 페이지 화면
		 */
		@RequestMapping(value="/McmMalGds001M03C.do")
		public String getViewMcmMalGds001M03C(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
			
			McmCmnCcd001VO mcmCmnCcd001VO = new McmCmnCcd001VO();
			mcmCmnCcd001VO.setCdGrpId("CTR001");
			
			UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
			mcmMalGds001VO.setUsrId(userInfoVO.getUsrId());		
			
			List<?> resultList = mcmMalGds001Service.selectMcmMalGds001LcsNoInfo(mcmMalGds001VO);
			model.addAttribute("resultList", resultList);
			
			List<?> cdResultList = mcmCmnCcd001Service.selectMcmCmnCcd001SelectCdInfoList(mcmCmnCcd001VO);
			model.addAttribute("cdResultList", cdResultList);
			
			return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M03C";
		}
		
		/**
		 * 이미지업로드 팝업
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/McmMalGds001P03C.do")
		public String getViewMcmMalGds001P03C(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");

			return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001P03C";
		}
		/**
		 * 이미지업로드 팝업
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/McmMalGds001P13C.do")
		public String getViewMcmMalGds001P13C(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");

			return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001P13C";
		}
		
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 상품등록 처리
		 */
		@RequestMapping(value="/McmMalGds001M03CP.do")
		public ModelAndView getViewMcmMalGds001M03CP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			
			
			
			// 상품등록
			String insertValue = mcmMalGds001Service.insertMcmMalGds001Info(mcmMalGds001VO);
			mcmMalGds001VO.setGdsId(insertValue);
			
			// 상품가격등록
			String insertProdPay = mcmMalGds001Service.insertMcmMalGds001ProdPayInfo(mcmMalGds001VO);
			
			// 상품수량등록
			String insertProdCnt = mcmMalGds001Service.insertMcmMalGds001ProdCntInfo(mcmMalGds001VO);
			
			// 할인판매여부
			String insertProdDcYn = mcmMalGds001Service.insertMcmMalGds001InsertProdDcYn(mcmMalGds001VO);
			
			// 할인판매가
			String insertProdDcPrice = mcmMalGds001Service.insertMcmMalGds001InsertProdDcPrice(mcmMalGds001VO);
			
			// 일반판매가
			String insertProdGePrice = mcmMalGds001Service.insertMcmMalGds001InsertProdGePrice(mcmMalGds001VO);
			
			// 카테고리
			String insertCate = mcmMalGds001Service.insertMcmMalGds001InsertCate(mcmMalGds001VO);
			
			// 상점등록
			String insertStr = mcmMalGds001Service.insertMalGds001ProdIns(mcmMalGds001VO);
			
			ModelAndView modelAndView =  new ModelAndView();
			modelAndView.addObject(insertValue);
			modelAndView.setViewName("jsonView");
			
			return modelAndView; 
		}
		
		
		/**
		 * 상품이미지 업로드
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/McmMalGds001P03CP.do")
		public @ResponseBody void getViewcmMalGds001P03CP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			
			MultipartFile multiFile = mcmMalGds001VO.getFileNm();
			String tempNm = "";
			String realPath = "";
			String filePath = "";
			String fileName = "";
			if(multiFile != null){
				fileName = multiFile.getOriginalFilename();
				
				   if(fileName.toLowerCase().endsWith(".jpg") ||
						fileName.toLowerCase().endsWith(".jpeg") ||
		            	  fileName.toLowerCase().endsWith(".png") ||
		                    fileName.toLowerCase().endsWith(".gif") ||
			                  fileName.toLowerCase().endsWith(".bmp")) {	
					   
					   filePath = "/data/wasapp_upload_file/koalnet/gds/";
					   SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					   String today = format.format(new Date());
					   tempNm = "prodSnImg_0_"+today+fileName.substring(fileName.lastIndexOf("."));
					   
					   
					   realPath = propertiesService.getString("gdsAttImgPath");
					   mcmMalGds001VO.setGdsAttSnImg(fileName);
					   mcmMalGds001VO.setGdsAttSnImgPath(filePath+tempNm);
					   
					   File dir = new File(realPath);
					   File realFile = new File(realPath +"/"+tempNm);
					   
					   if(!dir.isDirectory()){
						   dir.mkdirs();
					   }
					   multiFile.transferTo(realFile);
				   }else{
						response.setContentType("text/html; charset=UTF-8");
				        PrintWriter out = response.getWriter();
				        out.println("<script>alert('이미지파일을 선택하여 주십시오.'); return false; </script>");	        
				        out.flush(); 
				   }
			}
			
			Map<String, Object> map = new HashMap();
			map.put("tempNm", tempNm);
			map.put("fileName", fileName);
			map.put("filePath", filePath);
			
			JSONObject jsonObject = JSONObject.fromObject(map);
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonObject);
			
		}
		
		/**
		 * 상품이미지 업로드
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping(value="/McmMalGds001P13CP.do")
		public @ResponseBody void getViewcmMalGds001P13CP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			
			MultipartFile multiFile = mcmMalGds001VO.getFileNm();
			String tempNm = "";
			String realPath = "";
			String filePath = "";
			String fileName = "";
			if(multiFile != null){
				fileName = multiFile.getOriginalFilename();
				
				   if(fileName.toLowerCase().endsWith(".jpg") ||
						fileName.toLowerCase().endsWith(".jpeg") ||
		            	  fileName.toLowerCase().endsWith(".png") ||
		                    fileName.toLowerCase().endsWith(".gif") ||
			                  fileName.toLowerCase().endsWith(".bmp")) {	
					   
					   filePath = "/data/wasapp_upload_file/koalnet/gds/";
					   SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					   String today = format.format(new Date());
					   tempNm = "prodMnImg_0_"+today+fileName.substring(fileName.lastIndexOf("."));
					   
					   
					   realPath = propertiesService.getString("gdsAttImgPath");
					   mcmMalGds001VO.setGdsAttSnImg(fileName);
					   mcmMalGds001VO.setGdsAttSnImgPath(filePath+tempNm);
					   
					   File dir = new File(realPath);
					   File realFile = new File(realPath +"/"+tempNm);
					   
					   if(!dir.isDirectory()){
						   dir.mkdirs();
					   }
					   multiFile.transferTo(realFile);
				   }else{
						response.setContentType("text/html; charset=UTF-8");
				        PrintWriter out = response.getWriter();
				        out.println("<script>alert('이미지파일을 선택하여 주십시오.'); return false; </script>");	        
				        out.flush(); 
				   }
			}
			
			Map<String, Object> map = new HashMap();
			map.put("tempNm", tempNm);
			map.put("fileName", fileName);
			map.put("filePath", filePath);
			
			JSONObject jsonObject = JSONObject.fromObject(map);
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonObject);
			
		}
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 상세설명등록 페이지
		 */
		@RequestMapping(value="/McmMalGds001M13C.do")
		public String getViewMcmMalGds001M13C(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
							ModelMap model,
							HttpSession session,
							HttpServletRequest request,
							HttpServletResponse response
							) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
			
			return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M13C";
		}
		
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 상세설명등록 처리
		 */
		@RequestMapping(value="/McmMalGds001M13CP.do")
		public @ResponseBody void getViewMcmMalGds001M13CP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
															ModelMap model,
															@RequestParam(value="fileImg1", required = false) MultipartFile fileImg1,
															@RequestParam(value="fileImg2", required = false) MultipartFile fileImg2,
															@RequestParam(value="fileImg3", required = false) MultipartFile fileImg3,
															@RequestParam(value="fileImg4", required = false) MultipartFile fileImg4,
															@RequestParam(value="fileImg5", required = false) MultipartFile fileImg5,
															HttpSession session,
															HttpServletRequest request,
															HttpServletResponse response
															) throws Exception {
			
			String gdsCnts1 = mcmMalGds001VO.getGdsCnts1();
			String gdsCnts2 = mcmMalGds001VO.getGdsCnts2();
			String gdsCnts3 = mcmMalGds001VO.getGdsCnts3();
			String gdsCnts4 = mcmMalGds001VO.getGdsCnts4();
			String gdsCnts5 = mcmMalGds001VO.getGdsCnts5();
			
			
			List<Map> multi = new ArrayList();
			
			Map map1 = new HashMap();
			Map map2 = new HashMap();
			Map map3 = new HashMap();
			Map map4 = new HashMap();
			Map map5 = new HashMap();
			
			map1.put("fileNm0", fileImg1);
			map1.put("gdsCnts0", gdsCnts1);
			
			map2.put("fileNm0", fileImg2);
			map2.put("gdsCnts0", gdsCnts2);
			
			map3.put("fileNm0", fileImg3);
			map3.put("gdsCnts0", gdsCnts3);
			
			map4.put("fileNm0", fileImg4);
			map4.put("gdsCnts0", gdsCnts4);
			
			map5.put("fileNm0", fileImg5);
			map5.put("gdsCnts0", gdsCnts5);
			
			
			multi.add(map1);
			multi.add(map2);
			multi.add(map3);
			multi.add(map4);
			multi.add(map5);
			
			String tempName = "";
			String  fileName = "";
			String realPath = "";
			for(int i=0 ; i< multi.size() ; i++) 
			{
				Map map = (Map)multi.get(i);
				
				MultipartFile fileNm = (MultipartFile) map.get("fileNm0");
				
				
				if(fileNm != null) {
					String gdsCnts = (String) map.get("gdsCnts0");
					MultipartFile file = fileNm;
					fileName = file.getOriginalFilename();
					if(fileName.toLowerCase().endsWith(".jpg") ||
						fileName.toLowerCase().endsWith(".jpeg") ||
		            	  fileName.toLowerCase().endsWith(".png") ||
		                    fileName.toLowerCase().endsWith(".gif") ||
			                  fileName.toLowerCase().endsWith(".bmp")) {
						
							SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
							String today = format.format(new Date());
							tempName = "prod_detail_0_"+i+ today + fileName.substring(fileName.lastIndexOf("."));
							realPath = propertiesService.getString("gdsAttImgPath");
							File dir = new File(realPath);
							File realFile = new File(realPath +"/"+tempName);
							
							if(!dir.isDirectory()){
								dir.mkdirs();
							}
							
							file.transferTo(realFile);
							mcmMalGds001VO.setGdsAttImgPath(realPath+"/"+tempName);
							mcmMalGds001VO.setGdsAttImg(fileName);
							mcmMalGds001VO.setGdsCnts(gdsCnts);
							
							//insert
							String insertValue = mcmMalGds001Service.insertMcmMalGds001ProdDetailSetInfo(mcmMalGds001VO);
							
						}else{
							response.setContentType("text/html; charset=UTF-8");
					        PrintWriter out = response.getWriter();
					        out.println("<script>alert('이미지파일을 선택하여 주십시오.'); return false; </script>");	        
					        out.flush(); 
						}
							
					}
			}
			
			Map<String, Object> map8 = new HashMap();
			map8.put("tempName", tempName);
			
			JSONObject jsonObject = JSONObject.fromObject(map8);
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter printWriter = response.getWriter();
			printWriter.print(jsonObject);
		}
		
		
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 키워드 목록
		 */
		@RequestMapping(value="/McmMalGds001M02L.do")
		public String getViewMcmMalGds001M02L(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
							ModelMap model,
							HttpSession session,
							HttpServletRequest request,
							HttpServletResponse response
							) throws Exception {
			
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
			
			List<?> keyList = mcmMalGds001Service.selectMcmMalGds001KeyList(mcmMalGds001VO);
			
			model.addAttribute("keyList", keyList);
			
			
			return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M02L";
		}
		
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 키워드 등록화면
		 */
		@RequestMapping(value="/McmMalGds001M23C.do")
		public String getViewMcmMalGds001M23C(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
							ModelMap model,
							HttpSession session,
							HttpServletRequest request,
							HttpServletResponse response
							) throws Exception {
			
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
			
			return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M23C";
		}
		
		/**
		 * @param mcmMalGds001VO
		 * @param model
		 * @param session
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * 키워드 등록처리
		 */
		@RequestMapping(value="/McmMalGds001M23CP.do")
		public ModelAndView getViewMcmMalGds001M23CP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
							ModelMap model,
							HttpSession session,
							HttpServletRequest request,
							HttpServletResponse response
							) throws Exception {
			
				//각페이지별 사용권한 유무 체크 
				commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
			
				List<String> kwdNmList = new ArrayList();
				List<Map> kwdNmList1 = new ArrayList();
				
				Map<String,Object> map1 = new HashMap();
				Map<String,Object> map2 = new HashMap();
				Map<String,Object> map3 = new HashMap();
				Map<String,Object> map4 = new HashMap();
				Map<String,Object> map5 = new HashMap();
				
				
				map1.put("kwdNm", mcmMalGds001VO.getKwdNm1());
				map2.put("kwdNm", mcmMalGds001VO.getKwdNm2());
				map3.put("kwdNm", mcmMalGds001VO.getKwdNm3());
				map4.put("kwdNm", mcmMalGds001VO.getKwdNm4());
				map5.put("kwdNm", mcmMalGds001VO.getKwdNm5());
				
				kwdNmList1.add(map1);
				kwdNmList1.add(map2);
				kwdNmList1.add(map3);
				kwdNmList1.add(map4);
				kwdNmList1.add(map5);
				
				String kwdNm = "";
				for(int i=0; i<kwdNmList1.size(); i++){
					Map kwdNmMap = kwdNmList1.get(i);
					
					kwdNm = (String) kwdNmMap.get("kwdNm");
					if(!kwdNm.equals("")){
						mcmMalGds001VO.setKwdNm(kwdNm);
						String insertValue = mcmMalGds001Service.insertMcmMalGds001KeySetInfo(mcmMalGds001VO);
					}
				}
				ModelAndView modelAndView = new ModelAndView();
				modelAndView.setViewName("jsonView");
				return modelAndView;
				
		}
		
	/**
	 * 기본설정 페이지 수정
	 * @param mcmMalGds001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M04U.do")
	public String getViewMcmMalGds001M04U(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
										ModelMap model,
										HttpSession session,
										HttpServletRequest request,
										HttpServletResponse response
										) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		McmCmnCcd001VO mcmCmnCcd001VO = new McmCmnCcd001VO();
		mcmCmnCcd001VO.setCdGrpId("CTR001");
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmMalGds001VO.setUsrId(userInfoVO.getUsrId());		
		
		List<?> resultList = mcmMalGds001Service.selectMcmMalGds001LcsNoInfo(mcmMalGds001VO);
		model.addAttribute("resultList", resultList);
		
		List<?> cdResultList = mcmCmnCcd001Service.selectMcmCmnCcd001SelectCdInfoList(mcmCmnCcd001VO);
		model.addAttribute("cdResultList", cdResultList);
		
		Map<String,Object> resultMap =  (Map<String, Object>) mcmMalGds001Service.selectMcmMalGds001ProdSetInfo(mcmMalGds001VO);

		System.out.println("resultMap======>"+resultMap);
		mcmMalGds001VO.setGdsNm((String)resultMap.get("gdsNm"));
		mcmMalGds001VO.setGds001001((String)resultMap.get("gdsPay"));
		mcmMalGds001VO.setGds001002((String)resultMap.get("gdsCnt"));
		
		mcmMalGds001VO.setGdsAttSnImg((String)resultMap.get("gdsAttSnImg"));
		mcmMalGds001VO.setGdsAttSnImgPath((String)resultMap.get("gdsAttSnImgPath"));
		
		mcmMalGds001VO.setGdsAttMnImg((String)resultMap.get("gdsAttMnImg"));
		mcmMalGds001VO.setGdsAttImgPath((String)resultMap.get("gdsAttImgPath"));
		
		mcmMalGds001VO.setGds001003((String)resultMap.get("gdsGePrice"));
		mcmMalGds001VO.setGds001004((String)resultMap.get("gdsDcYn"));
		mcmMalGds001VO.setGds001005((String)resultMap.get("gdsDcPrice"));
		mcmMalGds001VO.setLcsId((String)resultMap.get("lcsId"));
		mcmMalGds001VO.setCd((String)resultMap.get("gdsCtgrId"));
		
		model.addAttribute("resultMap", resultMap);
		
		return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M04U";
	}
	
	/**
	 * 기본설정 수정
	 * @param mcmMalGds001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M04UP.do")
	public ModelAndView getViewMcmMalGds001M04UP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
										ModelMap model,
										HttpSession session,
										HttpServletRequest request,
										HttpServletResponse response
										) throws Exception {
		
		mcmMalGds001Service.updateMcmMalGds001ProdInfo(mcmMalGds001VO);
		mcmMalGds001Service.updateMcmMalGds001PayInfo(mcmMalGds001VO);
		mcmMalGds001Service.updateMcmMalGds001CntInfo(mcmMalGds001VO);
		mcmMalGds001Service.updateMcmMalGds001UpdateProdDcYn(mcmMalGds001VO);
		mcmMalGds001Service.updateMcmMalGds001UpdateProdDcPrice(mcmMalGds001VO);
		mcmMalGds001Service.updateMcmMalGds001UpdateProdGePrice(mcmMalGds001VO);
		mcmMalGds001Service.updateMcmMalGds001UpdateCate(mcmMalGds001VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	/**
	 * 상세설명 페이지
	 * @param mcmMalGds001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M14U.do")
	public String getViewMcmMalGds001M14U(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
										ModelMap model,
										HttpSession session,
										HttpServletRequest request,
										HttpServletResponse response
										) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		List<?> detailListInfo = mcmMalGds001Service.selectMcmMalGds001DetailListInfo(mcmMalGds001VO);
		model.addAttribute("detailListInfo", detailListInfo);
		
		return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M14U";
	}
	/**
	 * 상세설명 수정
	 * @param mcmMalGds001VO
	 * @param model
	 * @param fileImg1
	 * @param fileImg2
	 * @param fileImg3
	 * @param fileImg4
	 * @param fileImg5
	 * @param session
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M14UP.do")
	public @ResponseBody void getViewMcmMalGds001M14UP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
														ModelMap model,
														@RequestParam(value="fileImg1", required = false) MultipartFile fileImg1,
														@RequestParam(value="fileImg2", required = false) MultipartFile fileImg2,
														@RequestParam(value="fileImg3", required = false) MultipartFile fileImg3,
														@RequestParam(value="fileImg4", required = false) MultipartFile fileImg4,
														@RequestParam(value="fileImg5", required = false) MultipartFile fileImg5,
														HttpSession session,
														HttpServletRequest request,
														HttpServletResponse response
														) throws Exception {
		
		
		
		String gdsCnts1 = mcmMalGds001VO.getGdsCnts1();
		String gdsCnts2 = mcmMalGds001VO.getGdsCnts2();
		String gdsCnts3 = mcmMalGds001VO.getGdsCnts3();
		String gdsCnts4 = mcmMalGds001VO.getGdsCnts4();
		String gdsCnts5 = mcmMalGds001VO.getGdsCnts5();
		
		List<Map> multi = new ArrayList();
		
		Map map1 = new HashMap();
		Map map2 = new HashMap();
		Map map3 = new HashMap();
		Map map4 = new HashMap();
		Map map5 = new HashMap();
		
		map1.put("fileNm0", fileImg1);
		map1.put("gdsCnts0", gdsCnts1);
		map1.put("seqNo0", mcmMalGds001VO.getSeqNo1());
		
		map2.put("fileNm0", fileImg2);
		map2.put("gdsCnts0", gdsCnts2);
		map2.put("seqNo0", mcmMalGds001VO.getSeqNo2());
		
		map3.put("fileNm0", fileImg3);
		map3.put("gdsCnts0", gdsCnts3);
		map3.put("seqNo0", mcmMalGds001VO.getSeqNo3());
		
		map4.put("fileNm0", fileImg4);
		map4.put("gdsCnts0", gdsCnts4);
		map4.put("seqNo0", mcmMalGds001VO.getSeqNo4());
		
		map5.put("fileNm0", fileImg5);
		map5.put("gdsCnts0", gdsCnts5);
		map5.put("seqNo0", mcmMalGds001VO.getSeqNo5());
		
		
		multi.add(map1);
		multi.add(map2);
		multi.add(map3);
		multi.add(map4);
		multi.add(map5);
		
		String tempName = "";
		String  fileName = "";
		String realPath = "";
		for(int i=0 ; i< multi.size() ; i++) 
		{
			Map map = (Map)multi.get(i);
			
			MultipartFile fileNm = (MultipartFile) map.get("fileNm0");
			String gdsCnts = (String) map.get("gdsCnts0");
			String seqNo = (String) map.get("seqNo0");
			System.out.println("seqNo=====================>"+seqNo);
			
			Map<String,Object> paramMap = new HashMap();
			paramMap.put("gdsId", mcmMalGds001VO.getGdsId());
			paramMap.put("seqNo", seqNo);
			
			mcmMalGds001VO.setGdsCnts(gdsCnts);
			mcmMalGds001VO.setSeqNo(seqNo);
			
			
			
			if(fileNm != null) {
				
				MultipartFile file = fileNm;
				fileName = file.getOriginalFilename();
				if(fileName.toLowerCase().endsWith(".jpg") ||
					fileName.toLowerCase().endsWith(".jpeg") ||
	            	  fileName.toLowerCase().endsWith(".png") ||
	                    fileName.toLowerCase().endsWith(".gif") ||
		                  fileName.toLowerCase().endsWith(".bmp")) {
					
						SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
						String today = format.format(new Date());
						tempName = "prod_detail_0_"+i+ today + fileName.substring(fileName.lastIndexOf("."));
						realPath = propertiesService.getString("gdsAttImgPath");
						File dir = new File(realPath);
						File realFile = new File(realPath +"/"+tempName);
						
						if(!dir.isDirectory()){
							dir.mkdirs();
						}
						mcmMalGds001VO.setGdsAttImgPath(realPath+"/"+tempName);
						mcmMalGds001VO.setGdsAttImg(fileName);
						
						
						file.transferTo(realFile);
						if(seqNo != null){
							//update
							mcmMalGds001Service.updateMcmMalGds001DetailInfo(mcmMalGds001VO);
						}else{
							String insertValue = mcmMalGds001Service.insertMcmMalGds001ProdDetailSetInfo(mcmMalGds001VO);
						}
						
						
					}else{
						response.setContentType("text/html; charset=UTF-8");
				        PrintWriter out = response.getWriter();
				        out.println("<script>alert('이미지파일을 선택하여 주십시오.'); return false; </script>");	        
				        out.flush(); 
					}
						
				}else{
					if(seqNo != null){
						Map fileInfoMap = mcmMalGds001Service.selectMcmMalGds001ImgDetailInfo(paramMap);
						
						
						String saveFileNm = (String) fileInfoMap.get("gdsAttImgPath");
						String orgFileNm = (String) fileInfoMap.get("gdsAttImg");
						mcmMalGds001VO.setGdsAttImgPath(saveFileNm);
						mcmMalGds001VO.setGdsAttImg(orgFileNm);
						
						mcmMalGds001Service.updateMcmMalGds001DetailInfo(mcmMalGds001VO);
					}
				}
		}
		
		Map<String, Object> map8 = new HashMap();
		map8.put("tempName", tempName);
		
		JSONObject jsonObject = JSONObject.fromObject(map8);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		printWriter.print(jsonObject);
	}
	
	
	/**
	 * 키워드 수정페이지
	 * @param mcmMalGds001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M24U.do")
	public String getViewMcmMalGds001M24U(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		List<?> resultList = mcmMalGds001Service.selectMcmMalGds001KeywordInfo(mcmMalGds001VO);
		model.addAttribute("resultList", resultList);
		
		
		
		return commonService.getMcmPreFix()+"mcm/mal/gds/McmMalGds001M24U";
	}
	
	/**
	 * 키워드 수정
	 * @param mcmMalGds001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M24UP.do")
	public ModelAndView getViewMcmMalGds001M24UP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
						ModelMap model,
						HttpSession session,
						HttpServletRequest request,
						HttpServletResponse response
						) throws Exception {
		
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
			List<String> kwdNmList = new ArrayList();
			List<Map> kwdNmList1 = new ArrayList();
			
			Map<String,Object> map1 = new HashMap();
			Map<String,Object> map2 = new HashMap();
			Map<String,Object> map3 = new HashMap();
			Map<String,Object> map4 = new HashMap();
			Map<String,Object> map5 = new HashMap();
			
			map1.put("kwdNm", mcmMalGds001VO.getKwdNm1());
			map1.put("seqNo", mcmMalGds001VO.getSeqNo1());
			map1.put("kwdRssUrl", mcmMalGds001VO.getKwdRssUrl1());
			
			map2.put("kwdNm", mcmMalGds001VO.getKwdNm2());
			map2.put("seqNo", mcmMalGds001VO.getSeqNo2());
			map2.put("kwdRssUrl", mcmMalGds001VO.getKwdRssUrl2());
			
			map3.put("kwdNm", mcmMalGds001VO.getKwdNm3());
			map3.put("seqNo", mcmMalGds001VO.getSeqNo3());
			map3.put("kwdRssUrl", mcmMalGds001VO.getKwdRssUrl3());
			
			map4.put("kwdNm", mcmMalGds001VO.getKwdNm4());
			map4.put("seqNo", mcmMalGds001VO.getSeqNo4());
			map4.put("kwdRssUrl", mcmMalGds001VO.getKwdRssUrl4());
			
			map5.put("kwdNm", mcmMalGds001VO.getKwdNm5());
			map5.put("seqNo", mcmMalGds001VO.getSeqNo5());
			map5.put("kwdRssUrl", mcmMalGds001VO.getKwdRssUrl5());
			
			kwdNmList1.add(map1);
			kwdNmList1.add(map2);
			kwdNmList1.add(map3);
			kwdNmList1.add(map4);
			kwdNmList1.add(map5);
			
			String kwdNm = "";
			String seqNo = "";
			String kwdRssUrl = "";
			
			String compareKwd = "";
			
			for(int i=0; i<kwdNmList1.size(); i++){
				Map kwdNmMap = kwdNmList1.get(i);
				
				kwdNm = (String) kwdNmMap.get("kwdNm");
				seqNo = (String) kwdNmMap.get("seqNo");
				kwdRssUrl = (String) kwdNmMap.get("kwdRssUrl");
				
//				List<?> resultList = mcmMalGds001Service.selectMcmMalGds001KeywordInfo(mcmMalGds001VO);
//				Map<String,Object> compareMap = new HashMap();
//				for(int j=0; j<resultList.size();j++){
//					compareMap = (Map<String, Object>) resultList.get(j);
//					System.out.println("compareMap=====>"+compareMap);
//					compareKwd = (String) compareMap.get("kwdNm");
//					
//					if(!compareKwd.equals(kwdNm)){
//						
//						
//						System.out.println("@@@@@@@@@");
//					}/*else{
//						System.out.println("3333");
//					}*/
//				}
				
				
				
				if(seqNo == null) {
					if(!"".equals(kwdNm)){
						mcmMalGds001VO.setSeqNo(seqNo);
						mcmMalGds001VO.setKwdNm(kwdNm);
						mcmMalGds001VO.setKwdRssUrl(kwdRssUrl);
						String insertValue = mcmMalGds001Service.insertMcmMalGds001KeySetInfo(mcmMalGds001VO);
					}
				}else{
					mcmMalGds001VO.setSeqNo(seqNo);
					mcmMalGds001VO.setKwdNm(kwdNm);
					mcmMalGds001VO.setKwdRssUrl(kwdRssUrl);
					
					Map<?,?> resultMap = mcmMalGds001Service.selectMcmMalGds001SelectKwdNmInfo(mcmMalGds001VO);
					compareKwd = (String) resultMap.get("kwdNm");
					
					if(!compareKwd.equals(kwdNm)) {
						mcmMalGds001Service.updateMcmMalGds001KeywordInfo(mcmMalGds001VO);
					}
					
				}
				
			}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
			
	}
	
	/**
	 * 상품사용여부(삭제)
	 * @param mcmMalGds001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M05DP.do")
	public ModelAndView McmMalGds001M05DP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		mcmMalGds001VO.setGdsUseYn("N");
		mcmMalGds001Service.updateMcmMalGds001ProdYnInfo(mcmMalGds001VO);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	/**
	 * 상품올리기
	 * @param mcmMalGds001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmMalGds001M33CP.do")
	public ModelAndView getViewMcmMalGds001M33CP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		
		mcmMalGds001Service.updateMcmMalGds001ProdUp(mcmMalGds001VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	@RequestMapping(value="/McmMalGds001M34UP.do")
	public ModelAndView getViewMcmMalGds001M34UP(@ModelAttribute("McmMalGds001VO") McmMalGds001VO mcmMalGds001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		
		mcmMalGds001Service.updatemcmMalGds001ProdDown(mcmMalGds001VO);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
}
