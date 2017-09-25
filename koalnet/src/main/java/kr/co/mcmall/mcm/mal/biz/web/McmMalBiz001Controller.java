package kr.co.mcmall.mcm.mal.biz.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002Service;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002VO;
import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001VO;
import kr.co.mcmall.mcm.tpl.tpl.service.McmTplTpl001VO;
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
public class McmMalBiz001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmMalBiz001Service")
	private McmMalBiz001Service mcmMalBiz001Service;
	
	/** 서비스 */
	@Resource(name = "mcmCmnAth002Service")
	private McmCmnAth002Service mcmCmnAth002Service;


	
	
	/**
	 * @param mcmMalBiz001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 리스트 조회
	 */
	@RequestMapping(value = "/McmMalBiz001M01L.do")
	public String getViewMcmMalBiz001M01L(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
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
		commonService.getPageInfo( paginationInfo, mcmMalBiz001VO.getPageIndex(), mcmMalBiz001VO.getRecordCountPerPage());
		mcmMalBiz001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalBiz001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmMalBiz001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		

		List<?> selectResultList = mcmMalBiz001Service.selectMcmMalBiz001M01List(mcmMalBiz001VO);
		
		List<?> selectStrList = mcmMalBiz001Service.selectMcmMalStr001M01List(mcmMalBiz001VO);
		// 목록 카운트 조회
		int totCnt = mcmMalBiz001Service.selectMcmMalBiz001P01Paging(mcmMalBiz001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		
		// 사업자 관리 리스트 조회
		model.addAttribute("selectStrList",selectStrList);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt",totCnt);
		model.addAttribute("selectResultList",selectResultList);
		                   
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001M01L";
	}

	
	
	
	
	/**
	 * @param mcmMalBiz001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 상세보기
	 */
	@RequestMapping(value = "/McmMalBiz001M02R.do")
	public String getViewMcmMalBiz001M02R(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		// 사업자 상세보기
		Map<?,?> selectResultInfo = mcmMalBiz001Service.selectMcmMalBiz001M02Info(mcmMalBiz001VO);
		model.addAttribute("selectResultInfo",selectResultInfo);
//		Map<?,?> resultInfo = mcmMalBiz001Service.selectTemplatetInfo(mcmMalBiz001VO);
//		model.addAttribute("resultInfo", resultInfo);
		
		List<?> resultList = mcmMalBiz001Service.selectMcmMalBiz001M03RupList(mcmMalBiz001VO);
		model.addAttribute("resultList",resultList);
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001M02R";
	}
	
	@RequestMapping(value = "/McmMalBiz001M04U.do")
	public String getViewMcmMalBiz001M04U(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		Map<?,?> selectResultInfo = mcmMalBiz001Service.selectMcmMalBiz001M02Info(mcmMalBiz001VO);
		
		mcmMalBiz001VO.setLcsDivCd((String)selectResultInfo.get("lcsDivCd"));
		mcmMalBiz001VO.setTelNo((String)selectResultInfo.get("telNo"));
		mcmMalBiz001VO.setUsrId((String)selectResultInfo.get("usrId"));
		mcmMalBiz001VO.setUsrNm((String)selectResultInfo.get("usrNm"));
		                    
		model.addAttribute("selectResultInfo",selectResultInfo);
		 
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001M04U";
	}

	/**
	 * @param mcmMalBiz001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 홍보물 수정하기
	 */
	@RequestMapping(value="/McmMalBiz001M04UP.do")
	public ModelAndView getViewMcmMalBiz001M04UP(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
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
	 * @param mcmMalBiz001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalBiz001M03C.do")
	public String getViewmcmMalBiz001M03C(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001M03C";
	}
	
	@RequestMapping(value = "/McmMalBiz001P03C.do")
	public String getViewMcmMalBiz001P03C(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001P03C";
	}
	/**
	 * 등록처리
	 * @param mcmMalBiz001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalBiz001P03CP.do")
	public ModelAndView getViewMcmMalBiz001P03CP(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		
		// 저장
		/*String adsubMgntNo = mcmMalBiz001Service.insertTemplatetInfo(mcmMalBiz001VO);*/
		List<?> selectResultList = mcmMalBiz001Service.selectMcmMalBiz001P03CP(mcmMalBiz001VO);
		
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
	 * @param mcmMalBiz001VO
	 * @param model
	 * @param session
	 * @param response
	 * @return
	 * @throws Exception
	 *상점 찾기 팝업 
	 */
	@RequestMapping(value = "/McmMalBiz001P04C.do")
	public String getViewMcmMalBiz001P04C(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001P04C";
	}

	/**
	 * 등록처리
	 * @param mcmMalBiz001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalBiz001P04CP.do")
	public ModelAndView getViewmcmMalBiz001M04CP(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		// 저장
		/*String adsubMgntNo = mcmMalBiz001Service.insertTemplatetInfo(mcmMalBiz001VO);*/
		List<?> selectResultList = mcmMalBiz001Service.selectMcmMalBiz001P04CP(mcmMalBiz001VO);
		
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
	
	@RequestMapping(value = "/McmMalBiz001P05C.do")
	public String getViewMcmMalBiz001P05C(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001P05C";
	}
	
	@RequestMapping(value = "/McmMalBiz001P05CP.do")
	public ModelAndView getViewmcmMalBiz001M05CP(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		// 저장
		/*String adsubMgntNo = mcmMalBiz001Service.insertTemplatetInfo(mcmMalBiz001VO);*/
		List<?> selectResultList = mcmMalBiz001Service.selectMcmMalBiz001P05CP(mcmMalBiz001VO);
		
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
	
	@RequestMapping(value = "/McmMalBiz001M03CP.do")
	public ModelAndView getViewMcmMalBiz001M03CP(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		String upLcsCk   = mcmMalBiz001VO.getUpLcsCk();
		String insertAth = null;
	
		if(upLcsCk != null){
			mcmMalBiz001VO.setAthCd(upLcsCk);
			insertAth = mcmMalBiz001Service.insertMcmMalBiz001M01Ath(mcmMalBiz001VO);
			upLcsCk   = mcmMalBiz001Service.insertMcmMalBiz001M01upAth(mcmMalBiz001VO);
		}else if(upLcsCk == null){
			insertAth = mcmMalBiz001Service.insertMcmMalBiz001M01Ath(mcmMalBiz001VO);
		}else{
			ModelAndView mav = new ModelAndView("forward:/McmMalBiz001M01L.do");
			return mav;
		}
		if(insertAth == null){
			String selectResultList = mcmMalBiz001Service.insertMcmMalBiz001M03CP(mcmMalBiz001VO);
		}
		
		
		
		// 저장
		/*String adsubMgntNo = mcmMalBiz001Service.insertTemplatetInfo(mcmMalBiz001VO);*/
//		String insertAth = mcmMalBiz001Service.insertMcmMalBiz001M01Ath(mcmMalBiz001VO);
		
		
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	// 회원찾기 팝업
	@RequestMapping( value = "/McmMalBiz001P03R.do")
	public String getViewMcmMalBiz001P03R(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmMalBiz001VO.getPageIndex(), mcmMalBiz001VO.getRecordCountPerPage());
//		
		mcmMalBiz001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalBiz001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		mcmMalBiz001VO.setRecordCountPerPage( paginationInfo.getRecordCountPerPage() );
//		
		
		
		// 목록조회
		List<?> resultList = mcmMalBiz001Service.selectMcmMalBiz001P03List(mcmMalBiz001VO);
		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmMalBiz001Service.selectMcmMalBiz001P03TotCnt(mcmMalBiz001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		
		
		return commonService.getMcmPreFix()+"mcm/mal/biz/McmMalBiz001P03R";
	}
	
	@RequestMapping(value = "/McmMalBiz001P03RP.do")
	public ModelAndView getViewMcmMalBiz001P03RP(
			@ModelAttribute("mcmMalBiz001VO") McmMalBiz001VO mcmMalBiz001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		
		
		// 수정
		mcmMalBiz001Service.updateMcmMalBiz001P03RP(mcmMalBiz001VO);
				
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	
	
	
	
}
