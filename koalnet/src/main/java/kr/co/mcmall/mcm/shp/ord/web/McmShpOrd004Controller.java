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
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd004Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd004VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


/**
 * @Class Name  : McmShpOrd004Controller.java
 * @Description : McmShpOrd004Controller Class
 *                주문관리 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.05.10                최초생성
 *
 * @author 
 * @since 2017.05.10
 * @version 1.0
 * @see
 *  
 */


@Controller
public class McmShpOrd004Controller {

	//로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
	@Resource(name = "commonService")
	protected CommonService commonService;
	
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "mcmShpOrd004Service")
	private McmShpOrd004Service mcmShpOrd004Service;
	
	@Resource(name = "mcmMalBiz002Service")
	private McmMalBiz002Service mcmMalBiz002Service;
	
	
	/**
	 * 주문관리 목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M01L.do")
	public String getViewMcmShpOrd004M01L(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
		
		
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		//select박스리스트
		model.addAttribute("selectStrList", selectStrList);
		// 목록 조회	
		List<?> resultList = mcmShpOrd004Service.selectShpOrdList(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
			
		//목록 카운트 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt", totCnt);
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M01L";
		
	}
	
	/**
	 * 주문별 상품목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M02R.do")
	public String getViewMcmShpOrd004M02R(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
			
		
		// 주문별 상품 목록 조회
		List<?> resultList = mcmShpOrd004Service.selectShpOrdDetail(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
		
		
		// 주문별 상품 목록 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdDetailCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M02R";
		
	}
	
	
	/**
	 * 취소관리 목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M21L.do")
	public String getViewMcmShpOrd004M21L(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
		
		//select박스리스트
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		model.addAttribute("selectStrList", selectStrList);
		
		// 목록 조회	
		List<?> resultList = mcmShpOrd004Service.selectShpOrdList(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
			
		//목록 카운트 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt", totCnt);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M21L";
		
	}
	
	/**
	 * 취소관리 목록  상품목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M22R.do")
	public String getViewMcmShpOrd004M22R(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
			
		
		// 주문별 상품 목록 조회
		List<?> resultList = mcmShpOrd004Service.selectShpOrdDetail(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
		
		
		// 주문별 상품 목록 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdDetailCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M22R";
		
	}
	
	
	/**
	 * 교환관리 목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M31L.do")
	public String getViewMcmShpOrd004M31L(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
		
		//select박스리스트
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		model.addAttribute("selectStrList", selectStrList);
		
		
		// 목록 조회	
		List<?> resultList = mcmShpOrd004Service.selectShpOrdList(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
			
		//목록 카운트 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt", totCnt);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M31L";
		
	}
	
	/**
	 * 교환관리 목록  상품목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M32R.do")
	public String getViewMcmShpOrd004M32R(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
			
		
		// 주문별 상품 목록 조회
		List<?> resultList = mcmShpOrd004Service.selectShpOrdDetail(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
		
		
		// 주문별 상품 목록 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdDetailCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M32R";
		
	}
	
	
	/**
	 * 반품관리 목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M41L.do")
	public String getViewMcmShpOrd004M41L(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
		
		//select박스리스트
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		model.addAttribute("selectStrList", selectStrList);
		
		// 목록 조회	
		List<?> resultList = mcmShpOrd004Service.selectShpOrdList(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
			
		//목록 카운트 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt", totCnt);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M41L";
		
	}
	
	/**
	 * 반품관리 목록  상품목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M42R.do")
	public String getViewMcmShpOrd004M42R(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
			
		
		// 주문별 상품 목록 조회
		List<?> resultList = mcmShpOrd004Service.selectShpOrdDetail(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
		
		
		// 주문별 상품 목록 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdDetailCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M42R";
		
	}
	
	
	
	/**
	 * 환불관리 목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M51L.do")
	public String getViewMcmShpOrd004M51L(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
		
		
		//select박스리스트
		McmMalBiz002VO mcmMalBiz002VO = new McmMalBiz002VO();
		List<?> selectStrList = mcmMalBiz002Service.selectMcmMalStr002M01List(mcmMalBiz002VO);
		model.addAttribute("selectStrList", selectStrList);
		
		// 목록 조회	
		List<?> resultList = mcmShpOrd004Service.selectShpOrdList(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
			
		//목록 카운트 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt", totCnt);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M51L";
		
	}
	
	/**
	 * 환불관리 목록  상품목록 조회
	 * @param mcmShpOrd004VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/McmShpOrd004M52R.do")
	public String getViewMcmShpOrd004M52R(
			@ModelAttribute("mcmShpOrd004VO") McmShpOrd004VO mcmShpOrd004VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001003,CMN001004,CMN001005");
		
		
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmShpOrd004VO.getPageIndex(), mcmShpOrd004VO.getRecordCountPerPage(), mcmShpOrd004VO);
			
		
		// 주문별 상품 목록 조회
		List<?> resultList = mcmShpOrd004Service.selectShpOrdDetail(mcmShpOrd004VO);
		model.addAttribute("resultList", resultList);
		
		
		// 주문별 상품 목록 조회
	    int totCnt = mcmShpOrd004Service.selectShpOrdDetailCnt(mcmShpOrd004VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	    model.addAttribute("paginationInfo", paginationInfo);
	    
		
		return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd004M52R";
		
	}
	
	
}
