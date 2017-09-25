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
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz003Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz003VO;
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
public class McmMalBiz003Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmMalBiz003Service")
	private McmMalBiz003Service mcmMalBiz003Service;


	
	
	/**
	 * @param mcmMalBiz003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 리스트 조회
	 */
	@RequestMapping(value = "/McmMalBiz003M01L.do")
	public String getViewMcmMalBiz003M01L(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
		/**/PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmMalBiz003VO.getPageIndex(), mcmMalBiz003VO.getRecordCountPerPage());
		mcmMalBiz003VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalBiz003VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmMalBiz003VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		List<?> selectStrList = mcmMalBiz003Service.selectMcmMalStr003M01List(mcmMalBiz003VO);
		model.addAttribute("selectStrList",selectStrList);

		
		// 목록 카운트 조회
		int totCnt = mcmMalBiz003Service.selectMcmMalBiz003P01Paging(mcmMalBiz003VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		/*
		// 사업자 관리 리스트 조회
		
		                   */
		List<?> selectResultList = mcmMalBiz003Service.selectMcmMalBiz003M01List(mcmMalBiz003VO);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt",totCnt);
		model.addAttribute("selectResultList",selectResultList);
		
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz003M01L";
	}

	
	
	
	
	/**
	 * @param mcmMalBiz003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 상세보기
	 */
	@RequestMapping(value = "/McmMalBiz003M02R.do")
	public String getViewMcmMalBiz003M02R(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		// 하위사업자 조회 리스트
		List<?> selectResultList = mcmMalBiz003Service.selectMcmMalBiz003M03RR(mcmMalBiz003VO);
		model.addAttribute("selectResultList",selectResultList);
		
		// 사업자 상세보기
		Map<?,?> selectResultInfo = mcmMalBiz003Service.selectMcmMalBiz003M02Info(mcmMalBiz003VO);
		model.addAttribute("selectResultInfo",selectResultInfo);
//		Map<?,?> resultInfo = mcmMalBiz003Service.selectTemplatetInfo(mcmMalBiz003VO);
//		model.addAttribute("resultInfo", resultInfo);
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz003M02R";
	}
	
	@RequestMapping(value = "/McmMalBiz003M04U.do")
	public String getViewMcmMalBiz003M04U(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		Map<?,?> selectResultInfo = mcmMalBiz003Service.selectMcmMalBiz003M02Info(mcmMalBiz003VO);
		
		mcmMalBiz003VO.setLcsDivCd((String)selectResultInfo.get("lcsDivCd"));
		mcmMalBiz003VO.setTelNo((String)selectResultInfo.get("telNo"));
		mcmMalBiz003VO.setUsrId((String)selectResultInfo.get("usrId"));
		mcmMalBiz003VO.setStrId((String)selectResultInfo.get("strId"));
		mcmMalBiz003VO.setUsrNm((String)selectResultInfo.get("usrNm"));
		                    
		model.addAttribute("selectResultInfo",selectResultInfo);
		 
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz003M04U";
	}

	/**
	 * @param mcmMalBiz003VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 수정하기
	 */
	@RequestMapping(value="/McmMalBiz003M04UP.do")
	public ModelAndView getViewMcmMalBiz003M04UP(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response			
			) throws Exception {
		Map resultMap = new HashMap();
		resultMap.put("rtnMsg",1);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap);
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	/**
	 * 등록화면
	 * @param mcmMalBiz003VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalBiz003M03C.do")
	public String getViewmcmMalBiz003M03C(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz003M03C";
	}
	
	@RequestMapping(value = "/McmMalBiz003P03C.do")
	public String getViewMcmMalBiz003P03C(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz003P03C";
	}
	
	
	/**
	 * @param mcmMalBiz003VO
	 * @param model
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 *하위사업자 찾기 팝업 
	 */
	@RequestMapping(value = "/McmMalBiz003P02R.do")
	public String getViewMcmMalBiz003P02R(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz003P02R";
	}

	/**
	 * 등록처리
	 * @param mcmMalBiz003VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalBiz003P03CP.do")
	public ModelAndView getViewmcmMalBiz003M03CP(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		// 저장
		/*String adsubMgntNo = mcmMalBiz003Service.insertTemplatetInfo(mcmMalBiz003VO);*/
		List<?> selectResultList = mcmMalBiz003Service.selectMcmMalBiz003P03CP(mcmMalBiz003VO);
		
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
	
	@RequestMapping(value = "/deleteMcmMalBiz003M01DP.do")
	public ModelAndView getViewMcmMalBiz003M01DP(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		System.out.println(mcmMalBiz003VO+"###!@#");
		mcmMalBiz003Service.deleteMcmMalBiz003M01DP(mcmMalBiz003VO);
		// 저장
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	@RequestMapping(value = "/McmMalBiz003P05C.do")
	public String getViewMcmMalBiz003P05C(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz003P05C";
	}
	
	@RequestMapping(value = "/McmMalBiz003P05CP.do")
	public ModelAndView getViewmcmMalBiz003M05CP(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		// 저장
		/*String adsubMgntNo = mcmMalBiz003Service.insertTemplatetInfo(mcmMalBiz003VO);*/
		List<?> selectResultList = mcmMalBiz003Service.selectMcmMalBiz003P05CP(mcmMalBiz003VO);
		
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
	
	@RequestMapping(value = "/McmMalBiz003P02CP.do")
	public ModelAndView getViewMcmMalBiz003M03CP(
			@ModelAttribute("mcmMalBiz003VO") McmMalBiz003VO mcmMalBiz003VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		// 저장
		/*String adsubMgntNo = mcmMalBiz003Service.insertTemplatetInfo(mcmMalBiz003VO);*/
		
		mcmMalBiz003Service.updateMcmMalBiz00302CP(mcmMalBiz003VO);
		
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	
	
}
