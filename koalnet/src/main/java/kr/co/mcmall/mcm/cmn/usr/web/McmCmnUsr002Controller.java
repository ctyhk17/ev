package kr.co.mcmall.mcm.cmn.usr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001Service;
import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001VO;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr002Service;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr002VO;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name  : McmCmnUsr002Controller.java
 * @Description : McmCmnUsr002Controller Class
 *                조합원관리 컨트롤러
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
public class McmCmnUsr002Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 조합원 관리 서비스 */
	@Resource(name = "mcmCmnUsr002Service")
	private McmCmnUsr002Service mcmCmnUsr002Service;
	
	/** 포인트 관리 서비스 */
	@Resource(name = "mcmCmnPot001Service")
	private McmCmnPot001Service mcmCmnPot001Service;

	
	/**
	 * 조합원 목록 조회
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M01L.do")
	public String getViewMcmCmnUsr002M01L(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnUsr002VO.getPageIndex(), mcmCmnUsr002VO);
		
		// 목록조회
		List<?> resultList = mcmCmnUsr002Service.selectUsrList(mcmCmnUsr002VO);
		model.addAttribute("resultList", resultList);
		
		// 회원코드 분류 
		List<?> resultAthList = mcmCmnUsr002Service.selectAthCdList(mcmCmnUsr002VO);
		model.addAttribute("resultAthList",resultAthList);
		
		String var = mcmCmnUsr002VO.getStrId();
		System.out.println(var+"#123");
		// 목록 카운트 조회
		int totCnt = mcmCmnUsr002Service.selectUsrListTotCnt(mcmCmnUsr002VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr002M01L";
	}
	
	
	
	
	
	/**
	 * 조합원 정보 상세 조회
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M02R.do")
	public String getViewMcmCmnUsr002M02R(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");
		
		Map<?,?> resultInfo = mcmCmnUsr002Service.selectUsrInfo(mcmCmnUsr002VO);
		model.addAttribute("resultInfo", resultInfo);

		
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr002M02R";
	}
	
	
	

	/**
	 * 조합원 등록
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M03C.do")
	public String getViewMcmCmnUsr002M03C(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr002M03C";
	}
	
	/**
	 * ID 중복확인
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002P03R.do")
	public ModelAndView getViewMcmCmnUsr002P03R(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");

		
		String isValid = mcmCmnUsr002Service.selectExistsId(mcmCmnUsr002VO.getUsrId());
		
		String rtnCode = "000";
		
		// 중복된 아이디가 있는 경우
		if("Y".equals(isValid))
			rtnCode = "999";
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   
		returnJsonMap.put("rtnCode", rtnCode);     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	/**
	 * 회원가입처리
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M03CP.do")
	public ModelAndView getViewMcmCmnUsr002M02CP(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");

		String isValid = mcmCmnUsr002Service.selectExistsId(mcmCmnUsr002VO.getUsrId());
		
		String rtnCode = "000";
		String rtnMsg = "";
		
		// 중복된 아이디가 있는 경우
		if("Y".equals(isValid)){
			rtnCode = "999";
			rtnMsg  = "중복된 아이디가 존재 합니다.";
		}else{
			
			
			
			commonService.setDefaultInfo(session, request, mcmCmnUsr002VO);
			
			// 회원가입 처리	
			mcmCmnUsr002Service.insertUsrInfo(mcmCmnUsr002VO);
			
			rtnCode = "000";
			rtnMsg  = "정상적으로 등록되었습니다.";
		}
			
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   
		returnJsonMap.put("rtnCode", rtnCode);     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	
	
	
	
	/**
	 * 조합원 정보 수정화면
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/McmCmnUsr002M04U.do")
	public String getViewMcmCmnUsr002M04U(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");

		
		// 회원정보 조회
		Map<?,?> resultInfo = mcmCmnUsr002Service.selectUsrInfo(mcmCmnUsr002VO);
		model.addAttribute("resultInfo", resultInfo);
		
		mcmCmnUsr002VO.setUsrId((String)resultInfo.get("usrId"));
		mcmCmnUsr002VO.setUsrPwd((String)resultInfo.get("usrPWd"));
		mcmCmnUsr002VO.setUsrNm((String)resultInfo.get("usrNm"));
		mcmCmnUsr002VO.setTelNo((String)resultInfo.get("telNo"));
		mcmCmnUsr002VO.setEmailAddr((String)resultInfo.get("emailAddr"));
		mcmCmnUsr002VO.setUseYn((String)resultInfo.get("useYn"));
		mcmCmnUsr002VO.setFeePayYn((String)resultInfo.get("feePayYn"));
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr002M04U";
	}
	
	
	
	
	
	
	
	
	/**
	 * 조합원 정보 수정 처리
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M04UP.do")
	public ModelAndView getViewMcmCmnUsr002M04UP(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");

		// 회원정보 수정	
		commonService.setDefaultInfo(session, request, mcmCmnUsr002VO);
		
		mcmCmnUsr002Service.updateUsrInfo(mcmCmnUsr002VO);
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   
		returnJsonMap.put("rtnCode", "000");     
		returnJsonMap.put("rtnMsg", "정상적으로 수정되었습니다.");
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	/**
	 * 조합원 정보 삭제 처리
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M05DP.do")
	public ModelAndView getViewMcmCmnUsr002M05UP(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");

		// 회원정보 삭제 
		commonService.setDefaultInfo(session, request, mcmCmnUsr002VO);
		mcmCmnUsr002Service.deleteUsrInfo(mcmCmnUsr002VO);
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   
		returnJsonMap.put("rtnCode", "000");     
		returnJsonMap.put("rtnMsg", "정상적으로 수정되었습니다.");
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	
	
	
	/**
	 * 조합원가입신청 목록 조회
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M11L.do")
	public String getViewMcmCmnUsr002M11L(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");

		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnUsr002VO.getPageIndex(), mcmCmnUsr002VO);
		
		// 목록조회
		List<?> resultList = mcmCmnUsr002Service.selectUsrAppList(mcmCmnUsr002VO);
		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmCmnUsr002Service.selectUsrAppListTotCnt(mcmCmnUsr002VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr002M11L";
	}
	
	
	
	
	
	/**
	 * 조합원가입신청 승인정보 상세 조회
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr002M12R.do")
	public String getViewMcmCmnUsr002M12R(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");

		
		Map<?,?> resultInfo = mcmCmnUsr002Service.selectUsrInfo(mcmCmnUsr002VO);
		model.addAttribute("resultInfo", resultInfo);

		
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr002M12R";
	}
	
	/**
	 * 조합원 가입신청 승인처리
	 * @param mcmCmnUsr002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@RequestMapping(value = "/McmCmnUsr002M12RP.do")
	public ModelAndView getViewMcmCmnUsr002M12RP(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");
		
		// 회원정보 수정	
		commonService.setDefaultInfo(session, request, mcmCmnUsr002VO);
		
		mcmCmnUsr002Service.updateUsAppInfo(mcmCmnUsr002VO);
		
//		mcmCmnUsr002Service.insertUsrStrInfo(mcmCmnUsr002VO);
		
		mcmCmnUsr002Service.insertUsrDefaultAth(mcmCmnUsr002VO);
		
		mcmCmnUsr002Service.insertUsrAth(mcmCmnUsr002VO);
		
		McmCmnPot001VO mcmCmnPot001VO = new McmCmnPot001VO();
		
		
		mcmCmnPot001VO.setUsrId(mcmCmnUsr002VO.getUsrId());
		mcmCmnPot001VO.setPotCd("J");
		
		//가입포인트 정의
		mcmCmnPot001VO.setPotSv("1000");
		
		
		mcmCmnPot001VO.setPotYn("Y");
		mcmCmnPot001VO.setLstUdtId(mcmCmnUsr002VO.getLstUdtId());
		mcmCmnPot001VO.setLstUdtIp(mcmCmnUsr002VO.getLstUdtIp());
		
		//포인트 등록
		mcmCmnPot001Service.insertMcmCmnPotSv(mcmCmnPot001VO);
		
		mcmCmnPot001Service.updateMcmCmnCurPot(mcmCmnPot001VO);
		
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "000");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
//	/**
//	 * 조합원 가입신청 승인처리
//	 * @param mcmCmnUsr002VO
//	 * @param model
//	 * @param session
//	 * @param request
//	 * @param response
//	 * @return
//	 * @throws Exception
//	 */
//	
//	@Transactional
//	@RequestMapping(value = "/McmCmnUsr002M13RP.do")
//	public ModelAndView getViewMcmCmnUsr002M13RP(
//			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
//			ModelMap model,
//			HttpSession session,
//			HttpServletRequest request,
//			HttpServletResponse response
//			) throws Exception {
//		
//		//각페이지별 사용권한 유무 체크 
//		mcmCommonService.checkAthCd(session, response, "CMN001005");
//		
//		mcmCmnUsr002Service.insertUsrStrInfo(mcmCmnUsr002VO);
//		mcmCmnUsr002Service.insertUsrDefaultAth(mcmCmnUsr002VO);
//		mcmCmnUsr002Service.insertUsrAth(mcmCmnUsr002VO);
//		
//		
//		McmCmnPot001VO mcmCmnPot001VO = new McmCmnPot001VO();
//		
//		
//		mcmCmnPot001VO.setUsrId(mcmCmnUsr002VO.getUsrId());
//		mcmCmnPot001VO.setStrId(mcmCmnUsr002VO.getStrId());
//		mcmCmnPot001VO.setPotCd("J");
//		
//		//가입포인트 정의
//		mcmCmnPot001VO.setPotSv("1000");
//		
//		
//		mcmCmnPot001VO.setPotYn("Y");
//		mcmCmnPot001VO.setLstUdtId(mcmCmnUsr002VO.getLstUdtId());
//		mcmCmnPot001VO.setLstUdtIp(mcmCmnUsr002VO.getLstUdtIp());
//		
//		//포인트 등록
//		mcmCmnPot001Service.insertMcmCmnPotSv(mcmCmnPot001VO);
//		
//
//		
//		mcmCmnPot001Service.updateMcmCmnCurPot(mcmCmnPot001VO);
//		
//		
//		Map resultMap = new HashMap();   
//    	resultMap.put("rtnMsg", "000");     
//		
//    	ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addAllObjects(resultMap); 
//    	modelAndView.setViewName("jsonView");      
//    	
//    	return modelAndView;
//	}
	
	
	@RequestMapping(value = "/McmCmnUsr002M06E.do")
	public ModelAndView getExcelMcmCmnUsr002M06E(
			@ModelAttribute("mcmCmnUsr002VO") McmCmnUsr002VO mcmCmnUsr002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		// 세션    	 
    	String[] headerList = {
    			  "순번"
    			, "아이디"
    			, "이름"
    			, "전화번호"
    			, "이메일"
    			, "가입일자"    			
    			};
    	String[] columnList = {
    			  "rn"
    			, "usrId"
    			, "usrNm"
    			, "telNo"
    			, "emailAddr"
    			, "joinDt"    			
    			};
    	
    	
    	List<?> bodyList = mcmCmnUsr002Service.selectUsrExcelList(mcmCmnUsr002VO);
    	
    	
		
		Map map = new HashMap();
		
		map.put("excelFileName", "당당조합원 리스트");
		map.put("excelSheetName", "당당조합원 리스트");
		map.put("excelTitle", "당당조합원 리스트");
		
		map.put("headerList", headerList);
		map.put("columnList", columnList);
		map.put("bodyList", bodyList);
		
		return new ModelAndView("excelView", map);
		
	}
	
	
	
	
}

