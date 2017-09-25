package kr.co.mcmall.mcm.cmn.pot.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001Service;
import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001VO;
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



@Controller
public class McmCmnPot001Controller {
	
	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "mcmCmnPot001Service")
	private McmCmnPot001Service mcmCmnPot001Service;
	
	@Resource(name = "mcmMalBiz002Service")
	private McmMalBiz002Service mcmMalBiz002Service;
	
	
	
	/**
	 * 포인트 리스트화면
	 * 
	 * @param mcmCmnPot001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnPot001M01L.do")
	public String getListMcmCmnPot001M01L(
			@ModelAttribute("mcmCmnPot001VO") McmCmnPot001VO mcmCmnPot001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnPot001VO.getPageIndex(), mcmCmnPot001VO.getRecordCountPerPage());
		mcmCmnPot001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnPot001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnPot001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		List<?> resultList = mcmCmnPot001Service.selectMcmCmnPotList(mcmCmnPot001VO);
		
		int totCnt = mcmCmnPot001Service.selectMcmCmnPotCnt(mcmCmnPot001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		
		model.addAttribute("resultList", resultList);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    model.addAttribute("selectStrList",selectStrList);
		
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/pot/McmCmnPot001M01L";
	}
	
	
	@RequestMapping(value = "/McmCmnPot001M02R.do")
	public String getViewMcmCmnPot001M02R(
			@ModelAttribute("mcmCmnPot001VO") McmCmnPot001VO mcmCmnPot001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnPot001VO.getPageIndex1(), mcmCmnPot001VO.getRecordCountPerPage());
		mcmCmnPot001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnPot001VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnPot001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		List<?> resultList = mcmCmnPot001Service.selectMcmCmnPotRetrieve(mcmCmnPot001VO);
		
		int totCnt = mcmCmnPot001Service.selectMcmCmnPotRetrieveCnt(mcmCmnPot001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		
		int pointSum = mcmCmnPot001Service.selectMcmCmnPotRetrievePointSum(mcmCmnPot001VO);
		
		
		
		model.addAttribute("resultList", resultList);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    model.addAttribute("pointSum",pointSum);
		
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/pot/McmCmnPot001M02R";
	}
	
	@RequestMapping(value = "/McmCmnPot001M05DP.do")
	public ModelAndView getDeleteMcmCmnPot001M05D(
			@ModelAttribute("mcmCmnPot001VO") McmCmnPot001VO mcmCmnPot001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001002,CMN001003,CMN001004,CMN001005");
		
		
		//선택된 포인트 차감
		mcmCmnPot001Service.deleteMcmCmnPot(mcmCmnPot001VO);
		
		//포인트 점수 조회
		int totPoint = mcmCmnPot001Service.selectMcmCmnCurPot(mcmCmnPot001VO);
		
		mcmCmnPot001VO.setPotTotSum(totPoint);
		
		//포인트전체점수 tb_cmnpot001 update
		mcmCmnPot001Service.updateMcmCmnCurPot(mcmCmnPot001VO);
		
	
	    
	    ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	
	

}
