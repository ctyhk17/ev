package kr.co.mcmall.mcm.mal.stt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002Service;
import kr.co.mcmall.mcm.mal.stt.service.McmMalStt001Service;
import kr.co.mcmall.mcm.mal.stt.service.McmMalStt001VO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
 * @Class Name : McmMalSttController.java
 * @Description : McmMalSttController Controller Class
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
public class McmMalStt001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;

	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmMalStt001Service")
	private McmMalStt001Service mcmMalStt001Service;
	/** 서비스 */
	@Resource(name = "mcmMalBiz002Service")
	private McmMalBiz002Service mcmMalBiz002Service;


	
	/**
	 * 상품별 매출현황 통계 조회
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M01L.do")
	public String getViewMcMalStt001M01L(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		List<?> selectResultListGds = mcmMalStt001Service.selectMcmMalStt001M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListGds",selectResultListGds);
		
		List<?> selectGdsList = mcmMalStt001Service.selectMcmMalGds002M01List(mcmMalStt001VO);
		model.addAttribute("selectGdsList",selectGdsList);
		
		List<?> selectResultListDay = mcmMalStt001Service.selectMcmMalStt002M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListDay",selectResultListDay);
		
		List<?> selectResultListLcs = mcmMalStt001Service.selectMcmMalStt003M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListLcs",selectResultListLcs);
		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmMalStt001VO.getPageIndex(), mcmMalStt001VO.getRecordCountPerPage());
//		
		mcmMalStt001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalStt001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		mcmMalStt001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//		
		
		// 목록조회
//		List<?> resultList = mcmMalStt001Service.selectTemplatetList(mcmMalStt001VO);
//		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmMalStt001Service.selectMcmMalStt001M01LtotCnt(mcmMalStt001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt",totCnt);

		                   
		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt001M01L";
	}
	
	
	/**
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 일자별 매출현황
	 */
	@RequestMapping(value = "/McmMalStt002M01L.do")
	public String getViewMcMalStt002M01L(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		
		List<?> selectResultListGds = mcmMalStt001Service.selectMcmMalStt001M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListGds",selectResultListGds);
		
		List<?> selectGdsList = mcmMalStt001Service.selectMcmMalGds002M01List(mcmMalStt001VO);
		model.addAttribute("selectGdsList",selectGdsList);
				
		List<?> selectResultListDay = mcmMalStt001Service.selectMcmMalStt002M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListDay",selectResultListDay);
		
		List<?> selectResultListLcs = mcmMalStt001Service.selectMcmMalStt003M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListLcs",selectResultListLcs);
		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmMalStt001VO.getPageIndex(), mcmMalStt001VO.getRecordCountPerPage());
//		
		mcmMalStt001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalStt001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		mcmMalStt001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//		
		
		// 목록조회
//		List<?> resultList = mcmMalStt001Service.selectTemplatetList(mcmMalStt001VO);
//		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmMalStt001Service.selectMcmMalStt002M01LtotCnt(mcmMalStt001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt",totCnt);

		                   
		
		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt002M01L";
	}
	/**
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 사업자별 매출현황
	 */
	@RequestMapping(value = "/McmMalStt003M01L.do")
	public String getViewMcMalStt003M01L(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		
		List<?> selectResultListGds = mcmMalStt001Service.selectMcmMalStt001M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListGds",selectResultListGds);
		
		List<?> selectGdsList = mcmMalStt001Service.selectMcmMalGds002M01List(mcmMalStt001VO);
		model.addAttribute("selectGdsList",selectGdsList);
		
		List<?> selectResultListDay = mcmMalStt001Service.selectMcmMalStt002M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListDay",selectResultListDay);
		
		List<?> selectResultListLcs = mcmMalStt001Service.selectMcmMalStt003M01L(mcmMalStt001VO);
		model.addAttribute("selectResultListLcs",selectResultListLcs);
		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmMalStt001VO.getPageIndex(), mcmMalStt001VO.getRecordCountPerPage());
//		
		mcmMalStt001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalStt001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		mcmMalStt001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//		
		
		// 목록조회
//		List<?> resultList = mcmMalStt001Service.selectTemplatetList(mcmMalStt001VO);
//		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmMalStt001Service.selectMcmMalStt003M01LtotCnt(mcmMalStt001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt",totCnt);

		                   
		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt003M01L";
	}

	
	
	
	/**
	 * 상세조회
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M02R.do")
	public String getViewMcmMalStt001M02R(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");

		
//		Map<?,?> resultInfo = mcmMalStt001Service.selectTemplatetInfo(mcmMalStt001VO);
//		model.addAttribute("resultInfo", resultInfo);
		
		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt001M02R";
	}
	
	/**
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 사업자 아이디 찾기
	 */
	@RequestMapping(value = "/McmMalStt001P03R.do")
	public String getViewMcmMalStt001P03R(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
//		Map<?,?> resultInfo = mcmMalStt001Service.selectTemplatetInfo(mcmMalStt001VO);
//		model.addAttribute("resultInfo", resultInfo);
		
		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt001P03R";
	}
	
	 
	@RequestMapping(value = "/McmMalStt001P03RP.do")
	public ModelAndView getViewMcmMalStt001P03RP(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");

		
		// 저장
		/*String adsubMgntNo = mcmMalBiz001Service.insertTemplatetInfo(mcmMalBiz001VO);*/
		List<?> selectResultList = mcmMalStt001Service.selectMcmMalStt001P03RP(mcmMalStt001VO);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.addAll(selectResultList);
		
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("list", jsonArray);  
		
		JSONObject jsonObject = JSONObject.fromObject(resultMap);		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
		modelAndView.setViewName("jsonView");      
   	
   	return modelAndView;
	}
	
	
	/**
	 * 등록화면
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M03C.do")
	public String getViewMcmMalStt001M03C(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");

		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt001M03C";
	}
	
	/**
	 * 등록처리
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M03CP.do")
	public ModelAndView getViewMcmMalStt001M03CP(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		// 저장
		/*String adsubMgntNo = mcmMalStt001Service.insertTemplatetInfo(mcmMalStt001VO);*/
		
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}


	/**
	 * 수정화면
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M04U.do")
	public String getViewMcmMalStt001M04U(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt001M04U";
	}
	
	/**
	 * 수정처리
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M04UP.do")
	public ModelAndView getViewMcmMalStt001M04UP(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		// 수정
		/*mcmMalStt001Service.updateTemplatetInfo(mcmMalStt001VO);*/
				
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	/**
	 * 삭제화면
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M05D.do")
	public String getViewMcmMalStt001M05D(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		return commonService.getMcmPreFix()+"mcm/mal/stt/McmMalStt001M05D";
	}
	
	
	
	/**
	 * 삭제처리
	 * @param mcmMalStt001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStt001M05DP.do")
	public ModelAndView getViewMcmMalStt001M05DP(
			@ModelAttribute("mcmMalStt001VO") McmMalStt001VO mcmMalStt001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		/*mcmMalStt001Service.deleteTemplatetInfo(mcmMalStt001VO);*/
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
	}
	
	
	
	
}
