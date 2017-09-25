package kr.co.mcmall.mcm.mal.itr.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.mcm.cmn.bbs.service.McmCmnBbs006Service;
import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.mal.itr.service.McmMalItr001Service;
import kr.co.mcmall.mcm.mal.itr.service.McmMalItr001VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name  : McmMalItr001Controller.java
 * @Description : McmMalItr001Controller Class
 *                인트로 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017.06.02                최초생성
 *
 * @author 
 * @since 2017.06.02
 * @version 1.0
 * @see
 *  
 */


@Controller
public class McmMalItr001Controller {
	
	//공통 Service
	@Resource(name = "commonService")
	protected CommonService commonService;
	
	@Resource(name = "mcmMalItr001Service")
	protected McmMalItr001Service mcmMalItr001Service;
	
	//고객센터 서비스
	@Resource(name = "mcmCmnBbs006Service")
	protected McmCmnBbs006Service mcmCmnBbs006Service;
	
	
	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		
	/*
	 * 상점 메인화면 
	 */
	@RequestMapping(value = "/McmMalItr001M01L.do")
	public String getViewMcmMalItr001M01L(
			@ModelAttribute("mcmMalItr001VO") McmMalItr001VO mcmMalItr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		System.out.println("==============================");
		System.out.println(mcmMalItr001VO.getStrId());
		
		// 페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo(paginationInfo, mcmMalItr001VO.getPageIndex(), mcmMalItr001VO);
		
		// 상품 목록조회
		List<?> resultList = mcmMalItr001Service.selectGdsList(mcmMalItr001VO);
		model.addAttribute("resultList", resultList);

		
		// 상품 목록 카운트 조회
		int totCnt = mcmMalItr001Service.selectGdsListTotCnt(mcmMalItr001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		
		// 고객센터 정보 조회(상점설정 정보 조회)
		Map<?,?> resultInfo = mcmMalItr001Service.selectStrInfo(mcmMalItr001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		// 카테고리 목록 조회
		List<?> ctgrList = mcmMalItr001Service.selectCtgrList();
		model.addAttribute("ctgrList", ctgrList);
		
		Map bbsMap = new HashMap();
		
		bbsMap.put("bbsCd", "BBS001002");
		List<?> ntcList = mcmCmnBbs006Service.selectBbsMain(bbsMap);
		
		bbsMap.put("bbsCd", "BBS001004");
		List<?> useList = mcmCmnBbs006Service.selectBbsMain(bbsMap);
		
		model.addAttribute("ntcList", ntcList);
		model.addAttribute("useList", useList);
		
		// 공지사항 목록 조회
		
		// 고객 후기 목록 조회
		
		return commonService.getMcmPreFix()+"mcm/mal/itr/McmMalItr001M01L";
	}
	
	
	/**
	 * 조합 복지몰 소개
	 * @param mcmMalItr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalItr001M02R.do")
	public String getViewMcmMalItr001M02R(
			@ModelAttribute("mcmMalItr001VO") McmMalItr001VO mcmMalItr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		
		return commonService.getMcmPreFix()+"mcm/mal/itr/McmMalItr001M02R";
	}
	
	
	
		
}
