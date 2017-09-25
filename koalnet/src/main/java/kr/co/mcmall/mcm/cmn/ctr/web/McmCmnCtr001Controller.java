package kr.co.mcmall.mcm.cmn.ctr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.cmn.ctr.service.McmCmnCtr001Service;
import kr.co.mcmall.mcm.cmn.ctr.service.McmCmnCtr001VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class McmCmnCtr001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "mcmCmnCtr001Service")
	public McmCmnCtr001Service mcmCmnCtr001Service;
	
	
	@RequestMapping(value="/McmCmnCtr001M01L.do")
	public String getViewMcmCmnCtr001M01L(@ModelAttribute("McmCmnCtr001VO") McmCmnCtr001VO mcmCmnCtr001VO,
														ModelMap model,
														HttpSession session,
														HttpServletRequest request,
														HttpServletResponse response
														) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnCtr001VO.getPageIndex(), mcmCmnCtr001VO.getRecordCountPerPage());
		
		mcmCmnCtr001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnCtr001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnCtr001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		List<?> resultList = mcmCmnCtr001Service.selectMcmCmnCtrList(mcmCmnCtr001VO);
		model.addAttribute("resultList", resultList);
		
		int totCnt = mcmCmnCtr001Service.selectMcmCmnCtrListCtn(mcmCmnCtr001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt", totCnt);
		
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/ctr/McmCmnCtr001M01L"; 
	}

	@RequestMapping(value="/McmCmnCtr001M03C.do")
	public String getViewMcmCmnCtr001M03C(@ModelAttribute("McmCmnCtr001VO") McmCmnCtr001VO mcmCmnCtr001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		Map<?,?> resultMap = mcmCmnCtr001Service.selectMcmCmnCtrInfo(mcmCmnCtr001VO);
		mcmCmnCtr001VO.setCdGrpId((String) resultMap.get("cdGrpId"));
		mcmCmnCtr001VO.setCdGrpNm((String) resultMap.get("cdGrpNm"));
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/ctr/McmCmnCtr001M03C";
	}
	
	@RequestMapping(value="/McmCmnCtr001M03CP.do")
	public ModelAndView getViewMcmCmnCtr001M03CP(@ModelAttribute("McmCmnCtr001VO") McmCmnCtr001VO mcmCmnCtr001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		int exists = mcmCmnCtr001Service.selectMcmCmnCtrInfoExists(mcmCmnCtr001VO);
		ModelAndView modelAndView = new ModelAndView();
		
		Map resultMap = new HashMap();
		if(exists > 0){
			resultMap.put("rtnMsg", 2);
		}else{
			String insertValue = mcmCmnCtr001Service.insertMcmCmnCtrInfo(mcmCmnCtr001VO);
			resultMap.put("rtnMsg", 1);
		}
		
		
		modelAndView.setViewName("jsonView");
		modelAndView.addAllObjects(resultMap);
		return modelAndView;
	}
	
	@RequestMapping("/McmCmnCtr001M05DP.do")
	public ModelAndView getViewMcmCmnCTr001M05DP(@ModelAttribute("McmCmnCtr001VO") McmCmnCtr001VO mcmCmnCtr001VO,
													ModelMap model,
													HttpSession session,
													HttpServletRequest request,
													HttpServletResponse response
													) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		mcmCmnCtr001Service.updateMcmCmnCtrInfo(mcmCmnCtr001VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/McmCmnCtr001M04U.do")
	public String getViewMcmCmnCtr001M04U(@ModelAttribute("McmCmnCtr001VO") McmCmnCtr001VO mcmCmnCtr001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		Map<?,?> resultMap = mcmCmnCtr001Service.selectMcmCmnCtrInfo(mcmCmnCtr001VO);
		mcmCmnCtr001VO.setCdGrpNm((String) resultMap.get("cdGrpNm"));
		
		return commonService.getMcmPreFix()+"mcm/cmn/ctr/McmCmnCtr001M04U";
	}
	
	@RequestMapping(value="/McmCmnCtr001M04UP.do")
	public ModelAndView getViewMcmCmnCtr001M04UP(@ModelAttribute("McmCmnCtr001VO") McmCmnCtr001VO mcmCmnCtr001VO,
												ModelMap model,
												HttpSession session,
												HttpServletRequest request,
												HttpServletResponse response
												) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		mcmCmnCtr001Service.updateMcmCmnCtr(mcmCmnCtr001VO);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}
		
}
