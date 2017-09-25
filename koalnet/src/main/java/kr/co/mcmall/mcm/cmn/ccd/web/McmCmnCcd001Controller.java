package kr.co.mcmall.mcm.cmn.ccd.web;

import java.io.PrintWriter;
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
 * @Class Name : McmCmnCcd001Controller.java
 * @Description : McmCmnCcd001Controller Controller Class
 *                McmCmnCcd001Controller Controller 클래스 ( 코드그룹관리 )
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
 **/
@Controller
public class McmCmnCcd001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmCmnCcd001Service")
	private McmCmnCcd001Service mcmCmnCcd001Service;
	
	
	/**
	 * 코드그룹 목록
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M01L.do")
	public String getViewMcmCmnCcd001M01L(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
										ModelMap model,
										HttpSession session,
										HttpServletRequest request,
										HttpServletResponse response
										) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnCcd001VO.getPageIndex(), mcmCmnCcd001VO.getRecordCountPerPage());
		
		mcmCmnCcd001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnCcd001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnCcd001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
		List<?> resultList = mcmCmnCcd001Service.selectMcmCmnCcd001CdGrpList(mcmCmnCcd001VO);
		model.addAttribute("resultList", resultList);
		
		int totCnt = mcmCmnCcd001Service.selectMcmCmnCcd001CdGrpListCnt(mcmCmnCcd001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt", totCnt);
		
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M01L";
	}

	/**
	 * 코드그룹 상세정보
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M02R.do")
	public String getViewMcmCmnCcd001M02R(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		Map<?,?> resultMap = mcmCmnCcd001Service.selectMcmCmnCcd001CdGrpInfo(mcmCmnCcd001VO);
		model.addAttribute("resultMap", resultMap);
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M02R";
	}
	
	/**
	 * 사용여부 update(삭제)
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M05DP.do")
	public ModelAndView getViewMcmCmnCcd001M05DP(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		mcmCmnCcd001Service.updateMcmCmnCcd001CdGrpUseYn(mcmCmnCcd001VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	/**
	 * 코드그룹 수정페이지
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M04U.do")
	public String getViewMcmCmnCcd001M04U(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		Map<?,?> resultMap = mcmCmnCcd001Service.selectMcmCmnCcd001CdGrpInfo(mcmCmnCcd001VO);
		
		mcmCmnCcd001VO.setCdGrpNm((String) resultMap.get("cdGrpNm"));
		mcmCmnCcd001VO.setCdGrpCnts((String) resultMap.get("cdGrpCnts"));
		
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M04U";
	}
	
	/**
	 * 코드그룹 수정
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M04UP.do")
	public ModelAndView getViewMcmCmnCcd001M04UP(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		mcmCmnCcd001Service.updateMcmCmnCcd001CdGrpUpdate(mcmCmnCcd001VO);
			
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	/**
	 * 코드그룹 등록 페이지
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M03C.do")
	public String getViewMcmCmnCcd001M03C(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M03C";
	}
	
	/**
	 * 코드그룹 등록처리
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M03CP.do")
	public ModelAndView getViewMcmCmnCcd001M03CP(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		int cnt = mcmCmnCcd001Service.selectMcmCmnCcd001CdExists(mcmCmnCcd001VO);
		ModelAndView modelAndView = new ModelAndView();
		
		Map resultMap = new HashMap();   
		if(cnt > 0){
	    	resultMap.put("rtnMsg", 2);  
	        
		}else{
			String  insertValue = mcmCmnCcd001Service.insertMcmCmnCcd001CdGrpInsert(mcmCmnCcd001VO);
			resultMap.put("rtnMsg", 1);  
		}
		
		
		modelAndView.addAllObjects(resultMap);
		modelAndView.setViewName("jsonView");
			
		
		
		
		
		
		
		return modelAndView;
	}
	
	
	/**
	 * 공통코드관리 목록
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M11L.do")
	public String getViewMcmCmnCcd001M11L(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnCcd001VO.getPageIndex(), mcmCmnCcd001VO.getRecordCountPerPage());
		
		mcmCmnCcd001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnCcd001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnCcd001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
		List<?> resultList = mcmCmnCcd001Service.selectMcmCmnCcd001CommonCdList(mcmCmnCcd001VO);
		model.addAttribute("resultList", resultList);
		
		List<?> resultCdGrpList = mcmCmnCcd001Service.selectMcmCmnCcd001CdGrpSelect(mcmCmnCcd001VO);
		model.addAttribute("resultCdGrpList", resultCdGrpList);
		
		int totCnt = mcmCmnCcd001Service.selectMcmCmnCcd001CommonCdListCnt(mcmCmnCcd001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt", totCnt);
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M11L";
	}
	
	/**
	 * 공통코드 상세정보
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M12R.do")
	public String getViewMcmCmnCcd001M12R(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		
		Map<?,?> resultMap = mcmCmnCcd001Service.selectMcmCmnCcd001CommonCdInfo(mcmCmnCcd001VO);
		model.addAttribute("resultMap", resultMap);
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M12R";
		
	}
	
	/**
	 * 공통코드 삭제(UseYn)
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M15DP.do")
	public ModelAndView getViewMcmCmnCcd001M15DP(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		mcmCmnCcd001Service.updateMcmCmnCcd001CommonCdUseYnUpdate(mcmCmnCcd001VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	/**
	 * 공통코드 수정페이지
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M14U.do")
	public String getViewMcmCmnCcd001M14U(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		Map<?,?> resultMap = mcmCmnCcd001Service.selectMcmCmnCcd001CommonCdInfo(mcmCmnCcd001VO);
		
		mcmCmnCcd001VO.setCdEtc((String) resultMap.get("cdEtc"));
		mcmCmnCcd001VO.setCdGrpCnts((String) resultMap.get("cdGrpCnts"));
		mcmCmnCcd001VO.setCdGrpNm((String) resultMap.get("cdGrpNm"));
		mcmCmnCcd001VO.setCdNm((String) resultMap.get("cdNm"));
	
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M14U";
	}
	
	/**
	 * 공통코드 수정처리
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M14UP.do")
	public ModelAndView getViewMcmCmnCcd001M14UP(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		mcmCmnCcd001Service.updateMcmCmnCcd001CommonCdUpdate(mcmCmnCcd001VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}

	/**
	 * 공통코드 등록페이지
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M13C.do")
	public String  getViewMcmCmnCcd001M13C(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		List<?> resultCdGrpList = mcmCmnCcd001Service.selectMcmCmnCcd001CdGrpSelect(mcmCmnCcd001VO);
		model.addAttribute("resultCdGrpList", resultCdGrpList);
	
		return commonService.getMcmPreFix()+"mcm/cmn/ccd/McmCmnCcd001M13C";
	}
	
	/**
	 * 공통코드 등록처리
	 * @param mcmCmnCcd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmCmnCcd001M13CP.do")
	public ModelAndView  getViewMcmCmnCcd001M13CP(@ModelAttribute("McmCmnCcd001VO") McmCmnCcd001VO mcmCmnCcd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		ModelAndView modelAndView = new ModelAndView();
		Map map = new HashMap();
		int cnt = mcmCmnCcd001Service.selectMcmCmnCcd001CommonCdExists(mcmCmnCcd001VO);
		
		if(cnt > 0 ){
			map.put("rtnMsg", 2);
		}else{
			String insertValue = mcmCmnCcd001Service.insertMcmCmnCcd001CommonCdInsert(mcmCmnCcd001VO);
			map.put("rtnMsg", 1);  
		}
		
		
		modelAndView.setViewName("jsonView");
		modelAndView.addAllObjects(map);
		
		return modelAndView;
	}
}
