package kr.co.mcmall.mcm.cmn.kwd.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.cmn.kwd.service.McmCmnKwd001Service;
import kr.co.mcmall.mcm.cmn.kwd.service.McmCmnKwd001VO;
import kr.co.mcmall.mcm.mal.gds.service.McmMalGds001Service;

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
public class McmCmnKwd001Controller {

	// 로그
			private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
			
			/** 공통 서비스 선언 */
			@Resource(name = "commonService")
			protected CommonService commonService;
				
			/** 기본 프로퍼티 */
			@Resource(name = "propertiesService")
			protected EgovPropertyService propertiesService;
			
			/** 상품관리 서비스 */
			@Resource(name = "mcmMalGds001Service")
			protected McmMalGds001Service mcmMalGds001Service;
			
			@Resource(name = "mcmCmnKwd001Service")
			public McmCmnKwd001Service mcmCmnKwd001Service;
			
			
			
		@RequestMapping(value="/McmCmnKwd001M01L.do")
		public String getViewMcmCmnKwd001M01L(@ModelAttribute("McmCmnKwd001VO") McmCmnKwd001VO mcmCmnKwd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001005,CMN001006");
			
			PaginationInfo paginationInfo = new PaginationInfo();
			commonService.getPageInfo( paginationInfo, mcmCmnKwd001VO.getPageIndex(), mcmCmnKwd001VO.getRecordCountPerPage());
			
			mcmCmnKwd001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
			mcmCmnKwd001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
			mcmCmnKwd001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
			
			List<?> resultList = mcmCmnKwd001Service.selectMcmCmnKwd001KwdList(mcmCmnKwd001VO);
			model.addAttribute("resultList", resultList);
			
			int totCnt = mcmCmnKwd001Service.selectMcmCmnKwd001KwdCnt(mcmCmnKwd001VO);
			paginationInfo.setTotalRecordCount(totCnt);
			
			model.addAttribute("paginationInfo", paginationInfo);
			model.addAttribute("totCnt", totCnt);
			
			
			
			return commonService.getMcmPreFix()+"mcm/cmn/kwd/McmCmnKwd001M01L"; 
			
		}
		
		@RequestMapping(value="/McmCmnKwd001M02R.do")
		public String getViewMcmCmnKwd001M02R(@ModelAttribute("McmCmnKwd001VO") McmCmnKwd001VO mcmCmnKwd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001005,CMN001006");
			
			Map<?,?> resultMap = mcmCmnKwd001Service.selectMcmCmnKwd001KwdInfo(mcmCmnKwd001VO);
			model.addAttribute("resultMap", resultMap);
			
			
			return commonService.getMcmPreFix()+"mcm/cmn/kwd/McmCmnKwd001M02R";
		}
		
		@RequestMapping(value="/McmCmnKwd001M04U.do")
		public String getViewMcmCmnKwd001M04U(@ModelAttribute("McmCmnKwd001VO") McmCmnKwd001VO mcmCmnKwd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001005,CMN001006");
			
			Map<?,?> resultMap = mcmCmnKwd001Service.selectMcmCmnKwd001KwdInfo(mcmCmnKwd001VO);
			mcmCmnKwd001VO.setKwdNm((String) resultMap.get("kwdNm"));
			mcmCmnKwd001VO.setKwdRssUrl((String) resultMap.get("kwdRssUrl"));
			model.addAttribute("resultMap", resultMap);
			
			
			return commonService.getMcmPreFix()+"mcm/cmn/kwd/McmCmnKwd001M04U";
		}
		
		@RequestMapping(value="/McmCmnKwd001M04UP.do")
		public ModelAndView getViewMcmCmnKwd001M04UP(@ModelAttribute("McmCmnKwd001VO") McmCmnKwd001VO mcmCmnKwd001VO,
													ModelMap model,
													HttpSession session,
													HttpServletRequest request,
													HttpServletResponse response
													) throws Exception {
			
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001005,CMN001006");
			
			mcmCmnKwd001Service.updateMcmCmnKwd001KwdUpdate(mcmCmnKwd001VO);
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("jsonView");
			
			return modelAndView;
		}
		
		@RequestMapping(value="/McmCmnKwd001M05DP.do")
		public ModelAndView getViewMcmCmnKwd001M05DP(@ModelAttribute("McmCmnKwd001VO") McmCmnKwd001VO mcmCmnKwd001VO,
											ModelMap model,
											HttpSession session,
											HttpServletRequest request,
											HttpServletResponse response
											) throws Exception {
			
			//각페이지별 사용권한 유무 체크 
			commonService.checkAthCd(session, response, "CMN001005,CMN001006");

			mcmCmnKwd001Service.deleteMcmCmnKwd001KwdDelete(mcmCmnKwd001VO);
				
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("jsonView");
			
			return modelAndView;
		}
}
