package kr.co.mcmall.mcm.cmn.ath.web;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth001Service;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002Service;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002VO;
import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001VO;

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
 * @Class Name : McmCmnAthController.java
 * @Description : McmCmnAthController Controller Class
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
public class McmCmnAth002Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmCmnAth002Service")
	private McmCmnAth002Service mcmCmnAth002Service;

	@Resource(name = "mcmCmnAth001Service")
	private McmCmnAth001Service mcmCmnAth001Service;
	

	
	/**
	 * 목록조회
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M01L.do")
	public String getViewMcmCmnAth002M01L(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
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
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnAth002VO.getPageIndex(), mcmCmnAth002VO.getRecordCountPerPage());
//		
		mcmCmnAth002VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnAth002VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		mcmCmnAth002VO.setRecordCountPerPage( paginationInfo.getRecordCountPerPage() );
//		
		
		
		// 목록조회
		List<?> resultList = mcmCmnAth002Service.selectMcmCmnAth002M01List(mcmCmnAth002VO);

		List<?> resultList2 = mcmCmnAth001Service.selectMcmCmnAth002M01List(mcmCmnAth002VO);
		
		
		// 목록 카운트 조회
		int totCnt = mcmCmnAth002Service.selectMcmCmnAth002M01TotCnt(mcmCmnAth002VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("resultList", resultList);
		model.addAttribute("resultList2", resultList2);
		model.addAttribute("paginationInfo", paginationInfo);

		                   
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth002M01L";
	}

	
	
	
	/**
	 * 상세조회
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M02R.do")
	public String getViewMcmCmnAth002M02R(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		
		Map<?,?> resultInfo = mcmCmnAth002Service.selectMcmCmnAth002M01Info(mcmCmnAth002VO);
		model.addAttribute("resultInfo", resultInfo);
		
		List<?> resultList = mcmCmnAth002Service.selectMcmCmnAth002M01AthList(mcmCmnAth002VO);
		model.addAttribute("resultList",resultList);
		
		List<?> resultUsrList = mcmCmnAth002Service.selectMcmCmnAth002M01usrAthList(mcmCmnAth002VO);
		model.addAttribute("resultUsrList",resultUsrList);
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth002M02R";
	}
	
	
	/**
	 * 등록화면
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M03C.do")
	public String getViewMcmCmnAth002M03C(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth002M03C";
	}
	
	/**
	 * 등록처리
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M03CP.do")
	public ModelAndView getViewMcmCmnAth002M03CP(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		// 저장
		String adsubMgntNo = mcmCmnAth002Service.insertMcmCmnAth002M01NewAthCd(mcmCmnAth002VO);
		
		
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	/**
	 * 코드부여등록처리
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002P01CP.do")
	public ModelAndView getViewMcmCmnAth002P01CP(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		List list = new ArrayList();
		
		for(int i=0; i<mcmCmnAth002VO.getUsrIdArray().length; i++){
			Map map = new HashMap();
			map.put("strId",mcmCmnAth002VO.getStrId());
			map.put("athCd",mcmCmnAth002VO.getAthCd());
			map.put("usrId",mcmCmnAth002VO.getUsrIdArray()[i]);
			
			list.add(map);
		}
		
		mcmCmnAth002VO.setUsrIdList(list);
		mcmCmnAth002Service.insertMcmCmnAth002P01CP(mcmCmnAth002VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");      
		
		return modelAndView;
	}

	// 회원찾기 팝업
	@RequestMapping( value = "/McmCmnAth002P03R.do")
	public String getViewMcmCmnAth002P03R(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnAth002VO.getPageIndex(), mcmCmnAth002VO.getRecordCountPerPage());
//		
		mcmCmnAth002VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnAth002VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		mcmCmnAth002VO.setRecordCountPerPage( paginationInfo.getRecordCountPerPage() );
//		
		
		
		
		// 목록조회
		List<?> resultList = mcmCmnAth002Service.selectMcmCmnAth002P01List(mcmCmnAth002VO);
		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
		int totCnt = mcmCmnAth002Service.selectMcmCmnAth002P01TotCnt(mcmCmnAth002VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth002P03R";
	}

	
	/**
	 * 수정화면
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M04U.do")
	public String getViewMcmCmnAth002M04U(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth002M04U";
	}
	
	/**
	 * 수정처리
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M04UP.do")
	public ModelAndView getViewMcmCmnAth002M04UP(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		String athCd = mcmCmnAth002VO.getAthCd();
		String strId = mcmCmnAth002VO.getStrId();
		System.out.println(athCd+strId+"######");
		
		// 수정
		mcmCmnAth002Service.updateMcmCmnAth002M01Ath(mcmCmnAth002VO);
				
		
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
	@RequestMapping(value = "/McmCmnAth002M05UP.do")
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
	
	
	
	
	/**
	 * 삭제화면
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M05D.do")
	public String getViewMcmCmnAth002M05D(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		return commonService.getMcmPreFix()+"mcm/cmn/ath/McmCmnAth002M05D";
	}
	
	
	
	/**
	 * 삭제처리
	 * @param mcmCmnAth002VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnAth002M05DP.do")
	public ModelAndView getViewMcmCmnAth002M05DP(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		
		mcmCmnAth002Service.deleteMcmCmnAth002M05Ath(mcmCmnAth002VO);
		
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
	}
	@RequestMapping(value = "/McmCmnAth002M02CP.do")
	public ModelAndView getViewMcmCmnAth002M02CP(
			@ModelAttribute("mcmCmnAth002VO") McmCmnAth002VO mcmCmnAth002VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		
			int exist = mcmCmnAth002Service.selectMcmCmnAth002FindLcsCd(mcmCmnAth002VO);
			ModelAndView modelAndView = new ModelAndView();
			
			Map resultMap = new HashMap();
			if(exist >0){
				resultMap.put("rtnMsg",2);
			}else{
				
				List list = new ArrayList();
				
				for(int i=0; i<mcmCmnAth002VO.getUsrIdArray().length; i++){
					Map map = new HashMap();
					map.put("strId",mcmCmnAth002VO.getStrId());
					map.put("usrId",mcmCmnAth002VO.getUsrIdArray()[i]);
					
					list.add(map);
				}
				
				mcmCmnAth002VO.setUsrIdList(list);
				
				String selectResultList = mcmCmnAth002Service.insertMcmCmnAth002P02CP(mcmCmnAth002VO);
				resultMap.put("rtnMsg",1);
			}
	
    	
    	modelAndView.setViewName("jsonView");      
    	modelAndView.addAllObjects(resultMap);
    	
    	return modelAndView;
	}
	
	
	
	
}
