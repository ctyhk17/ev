package kr.co.mcmall.mcm.mal.biz.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001VO;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002VO;

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
public class McmMalBiz002Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmMalBiz002Service")
	private McmMalBiz002Service mcmMalBiz002Service;
	
	/** 서비스 */
	@Resource(name = "mcmMalBiz001Service")
	private McmMalBiz001Service mcmMalBiz001Service;

	

	
	
	/**
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 리스트 조회
	 */
	@RequestMapping(value = "/McmMalBiz002M01L.do")
	public String getViewMcmMalBiz002M01L(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");


		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmMalBiz002VO.setUsrId(userInfoVO.getUsrId());		
		
		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		/*List<?> selectResultMap = mcmMalBiz002Service.selectMcmMalBiz002lcsId(mcmMalBiz002VO);
		model.addAttribute("selectResultMap",selectResultMap);*/
		
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmMalBiz002VO.getPageIndex(), mcmMalBiz002VO.getRecordCountPerPage());

		McmMalBiz001VO mcmMalBiz001VO = new McmMalBiz001VO();
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		model.addAttribute("selectStrList",selectStrList);
		List<?> selectGdsList = mcmMalBiz002Service.selectMcmMalGds002M01List(mcmMalBiz002VO);
		model.addAttribute("selectGdsList",selectGdsList);
		
		
		mcmMalBiz002VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmMalBiz002VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalBiz002VO.setLastIndex( paginationInfo.getLastRecordIndex() );
//		
		
		// 목록조회
//		List<?> resultList = mcmMalBiz002Service.selectTemplatetList(mcmMalBiz002VO);
//		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmMalBiz002Service.selectMcmMalBiz002M01Paging(mcmMalBiz002VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		// 홍보물 리스트 조회
		List<?> selectResultList = mcmMalBiz002Service.selectMcmMalBiz002M01List(mcmMalBiz002VO);
		
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("selectResultList",selectResultList);
		model.addAttribute("totCnt",totCnt);
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz002M01L";
	}

	
	
	
	
	/**
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 상세보기
	 */
	@RequestMapping(value = "/McmMalBiz002M01R.do")
	public String getViewMcmMalBiz002M01R(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		// 홍보물 상세보기
		Map<?,?> selectResultInfo = mcmMalBiz002Service.selectMcmMalBiz002M01Info(mcmMalBiz002VO);
		
		mcmMalBiz002VO.setItrCnts( null ==  selectResultInfo ?  "" : ((String)selectResultInfo.get("itrCnts")));
		mcmMalBiz002VO.setNote( null ==  selectResultInfo ?  "" : ((String)selectResultInfo.get("note")));
		
		model.addAttribute("selectResultInfo",selectResultInfo);
		
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz002M01R";
	}
	

	/**
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 수정하기
	 */
	@RequestMapping(value="/McmMalBiz002M01UProc.do")
	public ModelAndView getViewMcmMalBiz002M01UP(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response			
			) throws Exception {
		String gdsid = mcmMalBiz002VO.getGdsId();
		String lcsid = mcmMalBiz002VO.getLcsId();
		String seqno = mcmMalBiz002VO.getSeqNo();
				
		
		
		mcmMalBiz002Service.updateMcmMalBiz002M01InfoProc(mcmMalBiz002VO);
		
		Map resultMap = new HashMap();
		resultMap.put("rtnMsg",1);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap);
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	/**
	 * 등록화면
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalBiz002M02C.do")
	public String getViewMcmMalBiz002M03C(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmMalBiz002VO.setUsrId(userInfoVO.getUsrId());
		
		List<?> selectGdsList = mcmMalBiz002Service.selectMcmMalGds002M01List(mcmMalBiz002VO);
		model.addAttribute("selectGdsList",selectGdsList);
		
		Map<?,?> selectResultInfo2 = mcmMalBiz002Service.selectMcmMalBiz002lcsId(mcmMalBiz002VO);
		mcmMalBiz002VO.setLcsId((String)selectResultInfo2.get("lcsId"));
		model.addAttribute("selectResultInfo2",selectResultInfo2);
		
		
		
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz002M02C";
	}
	



	/**
	 * 수정화면
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mcmMalBiz002M04U.do")
	public String getViewmcmMalBiz002M04U(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");

		return commonService.getMcmPreFix()+"mcm/mal/biz/mcmMalBiz002M04U";
	}
	
	/**
	 * 수정처리
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mcmMalBiz002M04UP.do")
	public ModelAndView getViewmcmMalBiz002M04UP(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		
		// 수정
		/*mcmMalBiz002Service.updateTemplatetInfo(mcmMalBiz002VO);*/
				
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	/**
	 * 삭제화면
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mcmMalBiz002M05D.do")
	public String getViewmcmMalBiz002M05D(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/mcmMalBiz002M05D";
	}
	
	
	
	/**
	 * 삭제처리
	 * @param mcmMalBiz002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mcmMalBiz002M05DP.do")
	public ModelAndView getViewmcmMalBiz002M05DP(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		/*mcmMalBiz002Service.deleteTemplatetInfo(mcmMalBiz002VO);*/
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
    	
	}
	
	@RequestMapping(value = "/McmMalBiz002M04DP.do")
	public ModelAndView getViewMcmMalBiz002M04DP(
	@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
	ModelMap model,
	HttpSession session,
	HttpServletResponse response) throws Exception{
		
		mcmMalBiz002Service.deleteMcmMalBiz002M04DP(mcmMalBiz002VO);
		
    	
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
	}
	@RequestMapping(value="/McmMalBiz002M03CP.do")
	public ModelAndView getViewMcmMalBiz002M03CP(
			@ModelAttribute("mcmMalBiz002VO") McmMalBiz002VO mcmMalBiz002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response) throws Exception{
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmMalBiz002VO.setUsrId(userInfoVO.getUsrId());
		
		
		mcmMalBiz002Service.insertMcmMalBiz002M03CP(mcmMalBiz002VO);
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
	}
	
	
	
	
	
}
