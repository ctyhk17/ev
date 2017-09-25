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
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003Service;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name  : McmCmnUsr003Controller.java
 * @Description : McmCmnUsr003Controller Class
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
public class McmCmnUsr003Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 조합원 관리 서비스 */
	@Resource(name = "mcmCmnUsr003Service")
	private McmCmnUsr003Service mcmCmnUsr003Service;
	
	/** 포인트 관리 서비스 */
	@Resource(name = "mcmCmnPot001Service")
	private McmCmnPot001Service mcmCmnPot001Service;

	
	/**
	 * 조합원 목록 조회
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M01L.do")
	public String getViewMcmCmnUsr003M01L(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnUsr003VO.getPageIndex(), mcmCmnUsr003VO);
		
		// 목록조회
		List<?> resultList = mcmCmnUsr003Service.selectUsrList(mcmCmnUsr003VO);
		model.addAttribute("resultList", resultList);
		
		String var = mcmCmnUsr003VO.getStrId();
		System.out.println(var+"#123");
		// 목록 카운트 조회
		int totCnt = mcmCmnUsr003Service.selectUsrListTotCnt(mcmCmnUsr003VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr003M01L";
	}
	
	
	
	
	
	/**
	 * 조합원 정보 상세 조회
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M02R.do")
	public String getViewMcmCmnUsr003M02R(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		Map<?,?> resultInfo = mcmCmnUsr003Service.selectUsrInfo(mcmCmnUsr003VO);
		model.addAttribute("resultInfo", resultInfo);

		
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr003M02R";
	}
	
	
	

	/**
	 * 조합원 등록
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M03C.do")
	public String getViewMcmCmnUsr003M03C(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr003M03C";
	}
	
	/**
	 * ID 중복확인
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003P03R.do")
	public ModelAndView getViewMcmCmnUsr003P03R(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		String isValid = mcmCmnUsr003Service.selectExistsId(mcmCmnUsr003VO.getUsrId());
		
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
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M03CP.do")
	public ModelAndView getViewMcmCmnUsr003M02CP(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		String isValid = mcmCmnUsr003Service.selectExistsId(mcmCmnUsr003VO.getUsrId());
		
		String rtnCode = "000";
		String rtnMsg = "";
		
		// 중복된 아이디가 있는 경우
		if("Y".equals(isValid)){
			rtnCode = "999";
			rtnMsg  = "중복된 아이디가 존재 합니다.";
		}else{
			
			
			
			commonService.setDefaultInfo(session, request, mcmCmnUsr003VO);
			
			// 회원가입 처리	
			mcmCmnUsr003Service.insertUsrInfo(mcmCmnUsr003VO);
			
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
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/McmCmnUsr003M04U.do")
	public String getViewMcmCmnUsr003M04U(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		// 회원정보 조회
		Map<?,?> resultInfo = mcmCmnUsr003Service.selectUsrInfo(mcmCmnUsr003VO);
		model.addAttribute("resultInfo", resultInfo);
		
		mcmCmnUsr003VO.setUsrId((String)resultInfo.get("usrId"));
		mcmCmnUsr003VO.setUsrPwd((String)resultInfo.get("usrPWd"));
		mcmCmnUsr003VO.setUsrNm((String)resultInfo.get("usrNm"));
		mcmCmnUsr003VO.setTelNo((String)resultInfo.get("telNo"));
		mcmCmnUsr003VO.setEmailAddr((String)resultInfo.get("emailAddr"));
		mcmCmnUsr003VO.setUseYn((String)resultInfo.get("useYn"));
		mcmCmnUsr003VO.setFeePayYn((String)resultInfo.get("feePayYn"));
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr003M04U";
	}
	
	
	
	
	
	
	
	
	/**
	 * 조합원 정보 수정 처리
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M04UP.do")
	public ModelAndView getViewMcmCmnUsr003M04UP(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		// 회원정보 수정	
		commonService.setDefaultInfo(session, request, mcmCmnUsr003VO);
		
		mcmCmnUsr003Service.updateUsrInfo(mcmCmnUsr003VO);
		
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
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M05DP.do")
	public ModelAndView getViewMcmCmnUsr003M05UP(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		// 회원정보 삭제 
		commonService.setDefaultInfo(session, request, mcmCmnUsr003VO);
		mcmCmnUsr003Service.deleteUsrInfo(mcmCmnUsr003VO);
		
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
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M11L.do")
	public String getViewMcmCmnUsr003M11L(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnUsr003VO.getPageIndex(), mcmCmnUsr003VO);
		
		// 목록조회
		List<?> resultList = mcmCmnUsr003Service.selectUsrAppList(mcmCmnUsr003VO);
		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmCmnUsr003Service.selectUsrAppListTotCnt(mcmCmnUsr003VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr003M11L";
	}
	
	
	
	
	
	/**
	 * 조합원가입신청 승인정보 상세 조회
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M12R.do")
	public String getViewMcmCmnUsr003M12R(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		Map<?,?> resultInfo = mcmCmnUsr003Service.selectUsrInfo(mcmCmnUsr003VO);
		model.addAttribute("resultInfo", resultInfo);

		
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr003M12R";
	}
	
	/**
	 * 조합원 가입신청 승인처리
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M12RP.do")
	public ModelAndView getViewMcmCmnUsr003M12RP(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		// 회원정보 수정	
		commonService.setDefaultInfo(session, request, mcmCmnUsr003VO);
		
		mcmCmnUsr003Service.updateUsAppInfo(mcmCmnUsr003VO);
		
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   

		returnJsonMap.put("rtnCode", "000");     
		returnJsonMap.put("rtnMsg", "승인되었습니다.");
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	/**
	 * 조합원 가입신청 승인처리
	 * @param mcmCmnUsr003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr003M13RP.do")
	public ModelAndView getViewMcmCmnUsr003M13RP(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		mcmCmnUsr003Service.insertUsrStrInfo(mcmCmnUsr003VO);
		mcmCmnUsr003Service.insertUsrDefaultAth(mcmCmnUsr003VO);
		
		
		
		McmCmnPot001VO mcmCmnPot001VO = new McmCmnPot001VO();
		
		
		mcmCmnPot001VO.setUsrId(mcmCmnUsr003VO.getUsrId());
		mcmCmnPot001VO.setPotCd("J");
		
		//가입포인트 정의
		mcmCmnPot001VO.setPotSv("1000");
		
		
		mcmCmnPot001VO.setPotYn("Y");
		mcmCmnPot001VO.setLstUdtId(mcmCmnUsr003VO.getLstUdtId());
		mcmCmnPot001VO.setLstUdtIp(mcmCmnUsr003VO.getLstUdtIp());
		
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
	@RequestMapping(value = "/McmCmnUsr003M06E.do")
	public ModelAndView getExcelMcmCmnUsr003M06E(
			@ModelAttribute("mcmCmnUsr003VO") McmCmnUsr003VO mcmCmnUsr003VO,
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
    			, "사용여부"
    			, "회비납부여부"
    			};
    	String[] columnList = {
    			  "rn"
    			, "usrId"
    			, "usrNm"
    			, "telNo"
    			, "emailAddr"
    			, "joinDt"
    			, "useYn"
    			, "feePayYn"
    			};
    	
    	
    	List<?> bodyList = mcmCmnUsr003Service.selectUsrExcelList(mcmCmnUsr003VO);
    	
    	
		
		Map map = new HashMap();
		
		map.put("excelFileName", "당당회원리스트");
		map.put("excelSheetName", "당당회원리스트");
		map.put("excelTitle", "당당회원리스트");
		
		map.put("headerList", headerList);
		map.put("columnList", columnList);
		map.put("bodyList", bodyList);
		
		return new ModelAndView("excelView", map);
		
	}
	
}

