package kr.co.mcmall.mcm.shp.ord.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002VO;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd002Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd002VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class McmShpOrd002Controller {

	//로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
	@Resource(name = "commonService")
	protected CommonService commonService;
	
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "mcmShpOrd002Service")
	private McmShpOrd002Service mcmShpOrd002Service;
	
	
	@Resource(name = "mcmMalBiz002Service")
	private McmMalBiz002Service mcmMalBiz002Service;
	
	
	@RequestMapping(value="/McmShpOrd002M01L.do")
	public String getListMcmShpOrd002M01L(
			@ModelAttribute("mcmShpOrd002VO") McmShpOrd002VO mcmShpOrd002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmShpOrd002VO.setUsrId(userInfoVO.getUsrId());
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd002VO.getPageIndex(), mcmShpOrd002VO.getRecordCountPerPage());
		mcmShpOrd002VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmShpOrd002VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmShpOrd002VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		List<?> resultList = mcmShpOrd002Service.selectShpOrdList(mcmShpOrd002VO);
			
		//목록 카운트 조회
	    int totCnt = mcmShpOrd002Service.selectShpOrdCnt(mcmShpOrd002VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	      
	    model.addAttribute("resultList", resultList);
	    model.addAttribute("selectStrList", selectStrList);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd002M01L";
		
	}
	
	@RequestMapping(value="/McmShpOrd002M02R.do")
	public String getListMcmShpOrd002M02R(
			@ModelAttribute("mcmShpOrd002VO") McmShpOrd002VO mcmShpOrd002VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmShpOrd002VO.setUsrId(userInfoVO.getUsrId());
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd002VO.getPageIndex(), mcmShpOrd002VO.getRecordCountPerPage());
		mcmShpOrd002VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmShpOrd002VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmShpOrd002VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		List<?> selectGdsList = mcmMalBiz002Service.selectMcmMalGds002M01List(mcmMalBiz002VO);
		List<?> resultList = mcmShpOrd002Service.selectShpOrdDetail(mcmShpOrd002VO);
			
		//목록 카운트 조회
	    int totCnt = mcmShpOrd002Service.selectShpOrdDetailCnt(mcmShpOrd002VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	      
	    model.addAttribute("resultList", resultList);
	    model.addAttribute("selectGdsList", selectGdsList);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd002M02R";
		
	}
	
	
}
