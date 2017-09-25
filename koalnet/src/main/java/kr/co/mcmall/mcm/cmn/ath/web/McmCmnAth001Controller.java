package kr.co.mcmall.mcm.cmn.ath.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth001Service;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth001VO;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002Service;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : McmTplTplController.java
 * @Description : McmTplTplController Controller Class
 *                MC몰 공통 템플릿
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017-05-10           최초생성
 *
 * @author 개발팀
 * @since 2017-05-10
 * @version 1.0
 * @see
 *  
 */

@Controller
public class McmCmnAth001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmCmnAth001Service")
	private McmCmnAth001Service mcmCmnAth001Service;

	/** 서비스 */
	@Resource(name = "mcmCmnAth002Service")
	private McmCmnAth002Service mcmCmnAth002Service;
	

	
	/**
	 * 목록조회
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M01L.do")
	public String getViewMcCmnAth001M01L(
			@ModelAttribute("mcmCmnAth001VO") McmCmnAth001VO mcmCmnAth001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		
		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
//		PaginationInfo paginationInfo = new PaginationInfo();
//		commonService.getPageInfo( paginationInfo, mcmCmnAth001VO.getPageIndex(), mcmCmnAth001VO.getRecordCountPerPage());
//		
//		mcmCmnAth001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
//		mcmCmnAth001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
//		
		McmCmnAth002VO mcmCmnAth002VO = new McmCmnAth002VO();
		
		// 목록조회
		List<?> resultList = mcmCmnAth001Service.selectMcmCmnAth002M01List(mcmCmnAth002VO);
		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
//		int totCnt = mcmCmnAth001Service.selectTemplatetListTotCnt(mcmCmnAth001VO);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);

		                   
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth001M01L";
	}
	
	

	
	
	/**
	 * 상세조회
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M02R.do")
	public String getViewMcmCmnAth001M02R(
			@ModelAttribute("mcmCmnAth001VO") McmCmnAth001VO mcmCmnAth001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		
//		Map<?,?> resultInfo = mcmCmnAth001Service.selectTemplatetInfo(mcmCmnAth001VO);
//		model.addAttribute("resultInfo", resultInfo);
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth001M02R";
	}
	
	
	/**
	 * 등록화면
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M03C.do")
	public String getViewMcmCmnAth001M03C(
			@ModelAttribute("mcmCmnAth001VO") McmCmnAth001VO mcmCmnAth001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth001M03C";
	}
	
	/**
	 * 등록처리
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M03CP.do")
	public ModelAndView getViewMcmCmnAth001M03CP(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		// 저장
		mcmCmnAth002Service.insertMcmCmnAth002M01NewAthCd(mcmCmnAth002VO);
		
		
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}


	/**
	 * 수정화면
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M04U.do")
	public String getViewMcmCmnAth001M04U(
			@ModelAttribute("mcmCmnAth001VO") McmCmnAth001VO mcmCmnAth001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth001M04U";
	}
	
	/**
	 * 수정처리
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M04UP.do")
	public ModelAndView getViewMcmCmnAth001M04UP(
			@ModelAttribute("mcmCmnAth001VO") McmCmnAth001VO mcmCmnAth001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		
		// 수정
		/*mcmCmnAth001Service.updateTemplatetInfo(mcmCmnAth002VO);*/
				
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	/**
	 * 삭제화면
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M05D.do")
	public String getViewMcmCmnAth001M05D(
			@ModelAttribute("mcmCmnAth001VO") McmCmnAth001VO mcmCmnAth001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth001M05D";
	}
	
	
	
	/**
	 * 삭제처리
	 * @param mcmCmnAth001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M05DP.do")
	public ModelAndView getViewMcmCmnAth001M05DP(
			@ModelAttribute("mcmCmnAth001VO") McmCmnAth001VO mcmCmnAth001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		/*mcmCmnAth001Service.deleteTemplatetInfo(mcmCmnAth001VO);*/
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
	}
	/**
	 * 권한정보수정처리
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth001M05UP.do")
	public ModelAndView getViewMcmCmnAth002M05UP(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		// 수정
		mcmCmnAth002Service.updateMcmCmnAth002M01AthModify(mcmCmnAth002VO);
		
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");     
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
		modelAndView.setViewName("jsonView");      
		
		return modelAndView;
	}
	
	
	
}
