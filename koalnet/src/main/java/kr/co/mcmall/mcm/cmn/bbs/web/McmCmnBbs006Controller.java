package kr.co.mcmall.mcm.cmn.bbs.web;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.mcm.cmn.bbs.service.McmCmnBbs006Service;
import kr.co.mcmall.mcm.cmn.bbs.service.McmCmnBbs006VO;
import kr.co.mcmall.mcm.cmn.ccd.service.McmCmnCcd001Service;
import kr.co.mcmall.mcm.cmn.ccd.service.McmCmnCcd001VO;
import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;

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
public class McmCmnBbs006Controller {

	//로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
	@Resource(name = "commonService")
	protected CommonService commonService;
	
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "mcmCmnBbs006Service")
	private McmCmnBbs006Service mcmCmnBbs006Service;
	
	/** 서비스 */
	@Resource(name = "mcmCmnCcd001Service")
	private McmCmnCcd001Service mcmCmnCcd001Service;
	
	
	@RequestMapping(value="/McmCmnBbs006M01L.do")
	public String getListMcmCmnBbs006M01L(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
	
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		mcmCmnBbs006VO.setBbsCd("BBS001001");
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
		//현재 사용자가 관리자
		commonService.checkAthCdForAdmPg(session, mcmCmnBbs006VO, "CMN001005");
		
		System.out.println("mcmCmnBbs006VO.isAthCheck()==>"+mcmCmnBbs006VO.isAthCheck());
		
		if(!mcmCmnBbs006VO.isAthCheck()){
			mcmCmnBbs006VO.setUsrId(userInfoVO.getUsrId());
		}
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnBbs006VO.getPageIndex(), mcmCmnBbs006VO.getRecordCountPerPage());
		mcmCmnBbs006VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnBbs006VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnBbs006VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
			
		List<?> resultList = mcmCmnBbs006Service.selectBbsList(mcmCmnBbs006VO);
			
		//목록 카운트 조회
	    int totCnt = mcmCmnBbs006Service.selectBbsCnt(mcmCmnBbs006VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	      
	    model.addAttribute("resultList", resultList);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M01L";
		
	}
	
	@RequestMapping(value="/McmCmnBbs006M02R.do")
	public String getRetriveMcmCmnBbs006M02R(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		mcmCmnBbs006VO.setBbsCd("BBS001001");
		System.out.println("mcmCmnBbs006VO.getUsrId()==========>"+mcmCmnBbs006VO.getUsrId());
		
		//1:1문의 혹은 고객후기 작성자와 접속자가 같은지 확인 
		commonService.checkWriter(session, mcmCmnBbs006VO, mcmCmnBbs006VO.getUsrId());
		
		//현재 사용자가 관리자
		commonService.checkAthCdForAdmPg(session, mcmCmnBbs006VO, "CMN001005");

		
		Map<?,?> resultMap = mcmCmnBbs006Service.selectBbsRetrive(mcmCmnBbs006VO);
		
	    model.addAttribute("resultMap", resultMap);
	    model.addAttribute("checkWrt", mcmCmnBbs006VO.isWrtCheck());
	    model.addAttribute("checkAth",mcmCmnBbs006VO.isAthCheck());
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M02R";
	}
	
	//1:1상담 입력
	@RequestMapping(value="/McmCmnBbs006M03C.do")
	public String getInsertMcmCmnBbs006M03C(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M03C";
	}
	
	//1:1상담 등록처리
	@RequestMapping(value="/McmCmnBbs006M03CP.do")
	public ModelAndView getInsertMcmCmnBbs006M03CP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		commonService.setDefaultInfo(session, request, mcmCmnBbs006VO);
		
		mcmCmnBbs006VO.setBbsCd("BBS001001");
		
		
		//삭제여부
		mcmCmnBbs006VO.setBbsDelYn("N");
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnBbs006VO.setLstUdtId(userInfoVO.getUsrId());
		
		
		if("N".equals(mcmCmnBbs006VO.getBbsReYn())){
			//작성자ID
			mcmCmnBbs006VO.setUsrId(userInfoVO.getUsrId());
			//작성자 이름
			mcmCmnBbs006VO.setUsrNm(userInfoVO.getUsrNm());
			
			//게시판 그룹번호 세팅(답글전용)
			int grpNo = mcmCmnBbs006Service.selectBbsGrpId(mcmCmnBbs006VO);
			mcmCmnBbs006VO.setBbsGrpId(grpNo);
			//게시판 그룹순서
			mcmCmnBbs006VO.setBbsGrpDep(1);
			//게시판 답글순서
			mcmCmnBbs006VO.setBbsGrpOrd(1);
			mcmCmnBbs006VO.setBbsReStt("N");
			
			mcmCmnBbs006Service.insertBbsData(mcmCmnBbs006VO);
			
		}else{
			String parentBbsId = mcmCmnBbs006VO.getBbsId();
		
			//작성자ID
			mcmCmnBbs006VO.setUsrId(mcmCmnBbs006VO.getUsrId());
			//작성자 이름
			mcmCmnBbs006VO.setUsrNm(mcmCmnBbs006VO.getUsrNm());
			//게시판 그룹순서(답글전용)
			mcmCmnBbs006VO.setBbsGrpDep(2);
			//게시판 답글순서(답글전용)
			mcmCmnBbs006VO.setBbsGrpOrd(2);
			mcmCmnBbs006VO.setBbsReStt("Y");
			
			mcmCmnBbs006Service.insertBbsData(mcmCmnBbs006VO);
			
			mcmCmnBbs006VO.setBbsId(parentBbsId);
			
			mcmCmnBbs006Service.updateBbsReCheck(mcmCmnBbs006VO);
		}
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	
	//1:1상담 수정화면
	@RequestMapping(value="/McmCmnBbs006M04U.do")
	public String getUpdateMcmCmnBbs006M04U(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		mcmCmnBbs006VO.setBbsCd("BBS001001");
		
		Map<?,?> resultMap = mcmCmnBbs006Service.selectBbsRetrive(mcmCmnBbs006VO);
	    model.addAttribute("resultMap", resultMap);
	    
	    
		
		
	    return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M04U";
	}
	//1:1상담 수정처리
	@RequestMapping(value="/McmCmnBbs006M04UP.do")
	public ModelAndView getUpdateMcmCmnBbs006M04UP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		mcmCmnBbs006VO.setBbsCd("BBS001001");
			
		mcmCmnBbs006Service.updateBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	//1:1상담 삭제처리
	@RequestMapping(value="/McmCmnBbs006M05DP.do")
	public ModelAndView getUpdateMcmCmnBbs006M05D(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		mcmCmnBbs006VO.setBbsCd("BBS001001");
			
		mcmCmnBbs006Service.deleteBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
	}
	//FAQ
	@RequestMapping(value="/McmCmnBbs006M11L.do")
	public String getListMcmCmnBbs006M11L(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
		commonService.checkAthCdForAdmPg(session, mcmCmnBbs006VO, "CMN001005");
		
		mcmCmnBbs006VO.setUsrId(userInfoVO.getUsrId());
		mcmCmnBbs006VO.setBbsCd("BBS001003");
		
		if("".equals(mcmCmnBbs006VO.getBbsOpn()) || mcmCmnBbs006VO.getBbsOpn() == null) {
			
			mcmCmnBbs006VO.setBbsOpn("FAQ001001");
		}
					
		List<?> resultList = mcmCmnBbs006Service.selectBbsFaqList(mcmCmnBbs006VO);
			
		//목록 카운트 조회
	    int totCnt = mcmCmnBbs006Service.selectBbsFaqCnt(mcmCmnBbs006VO);
//	    paginationInfo.setTotalRecordCount(totCnt);
	      
	    model.addAttribute("resultList", resultList);
//	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    model.addAttribute("bbsOpn",mcmCmnBbs006VO.getBbsOpn());
	    model.addAttribute("checkAth",mcmCmnBbs006VO.isAthCheck());
	    
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M11L";
		
	}
	
	@RequestMapping(value="/McmCmnBbs006M13C.do")
	public String getInsertMcmCmnBbs006M13C(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		// 권한체크
		commonService.checkAthCd(session, response, "CMN001005");
		
		
		McmCmnCcd001VO vo = new McmCmnCcd001VO(); 
		vo.setCdGrpId("FAQ001");
		
		List<?> cdList = mcmCmnCcd001Service.selectMcmCmnCcd001CdList(vo); 
		
		model.addAttribute("cdList", cdList);
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M13C";
	}
	@RequestMapping(value="/McmCmnBbs006M13CP.do")
	public ModelAndView getInsertMcmCmnBbs006M13CP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");
		
		commonService.setDefaultInfo(session, request, mcmCmnBbs006VO);
		mcmCmnBbs006VO.setBbsCd("BBS001003");
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnBbs006VO.setLstUdtId(userInfoVO.getUsrId());
		
		mcmCmnBbs006VO.setUsrId(userInfoVO.getUsrId());
		
		mcmCmnBbs006VO.setBbsReStt("Y");
		mcmCmnBbs006VO.setBbsReYn("N");
		mcmCmnBbs006VO.setBbsDelYn("N");
		
		mcmCmnBbs006VO.setBbsGrpDep(1);
		mcmCmnBbs006VO.setBbsGrpOrd(1);
		
		mcmCmnBbs006VO.setBbsCnts(mcmCmnBbs006VO.getBbsFaqCnts1());
		
		int grpNo = mcmCmnBbs006Service.selectBbsGrpId(mcmCmnBbs006VO);
		mcmCmnBbs006VO.setBbsGrpId(grpNo);
		
		
		mcmCmnBbs006Service.insertBbsData(mcmCmnBbs006VO);
		
		
		mcmCmnBbs006VO.setBbsReStt("Y");
		mcmCmnBbs006VO.setBbsReYn("Y");
		mcmCmnBbs006VO.setBbsDelYn("N");
		
		mcmCmnBbs006VO.setBbsGrpDep(2);
		mcmCmnBbs006VO.setBbsGrpOrd(2);
		
		
		
		mcmCmnBbs006VO.setBbsCnts(mcmCmnBbs006VO.getBbsFaqCnts2());
		
		mcmCmnBbs006Service.insertBbsData(mcmCmnBbs006VO);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	@RequestMapping(value="/McmCmnBbs006M14U.do")
	public String getUpdateMcmCmnBbs006M14U(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		// 권한체크
		commonService.checkAthCd(session, response, "CMN001005");
		
		
		McmCmnCcd001VO vo = new McmCmnCcd001VO(); 
		vo.setCdGrpId("FAQ001");
		
		List<?> cdList = mcmCmnCcd001Service.selectMcmCmnCcd001CdList(vo); 
		
		
		mcmCmnBbs006VO.setBbsCd("BBS001003");
		
		mcmCmnBbs006VO.setBbsGrpDep(1);
		Map<?,?> resultMapQ = mcmCmnBbs006Service.selectBbsRetriveFaqCntsQ(mcmCmnBbs006VO);
		mcmCmnBbs006VO.setBbsGrpDep(2);
		Map<?,?> resultMapA = mcmCmnBbs006Service.selectBbsRetriveFaqCntsQ(mcmCmnBbs006VO);
		
		System.out.println("ResultMapQ============>>"+resultMapQ.get("bbsCnts"));
		System.out.println("ResultMapA============>>"+resultMapA.get("bbsCnts"));
		System.out.println("ResultMapA============>>"+resultMapA.get("bbsOpn"));
		
		mcmCmnBbs006VO.setBbsOpn((String)resultMapA.get("bbsOpn"));
		
//		mcmCmnBbs006VO.setBbsFaqSeq1((String)resultMapQ.get("bbsId"));
//		mcmCmnBbs006VO.setBbsFaqSeq2((String)resultMapA.get("bbsId"));
		
	    model.addAttribute("resultMapQ", resultMapQ);
	    model.addAttribute("resultMapA", resultMapA);
	    model.addAttribute("cdList", cdList);
	    
	    
		
		
	    return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M14U";
	}
	//1:1상담 수정처리
	@RequestMapping(value="/McmCmnBbs006M14UP.do")
	public ModelAndView getUpdateMcmCmnBbs006M14UP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		mcmCmnBbs006VO.setBbsCd("BBS001003");
		
		mcmCmnBbs006VO.setBbsReStt("Y");
		mcmCmnBbs006VO.setBbsReYn("N");
		mcmCmnBbs006VO.setBbsDelYn("N");
		
		mcmCmnBbs006VO.setBbsGrpDep(1);
		mcmCmnBbs006VO.setBbsGrpOrd(1);
		mcmCmnBbs006VO.setBbsId(mcmCmnBbs006VO.getBbsFaqSeq1());
		mcmCmnBbs006VO.setBbsCnts(mcmCmnBbs006VO.getBbsFaqCnts1());
		mcmCmnBbs006Service.updateBbsData(mcmCmnBbs006VO);
		
		mcmCmnBbs006VO.setBbsReStt("Y");
		mcmCmnBbs006VO.setBbsReYn("Y");
		mcmCmnBbs006VO.setBbsDelYn("N");
		
		mcmCmnBbs006VO.setBbsGrpDep(2);
		mcmCmnBbs006VO.setBbsGrpOrd(2);
		mcmCmnBbs006VO.setBbsId(mcmCmnBbs006VO.getBbsFaqSeq2());
		mcmCmnBbs006VO.setBbsCnts(mcmCmnBbs006VO.getBbsFaqCnts2());
		
		mcmCmnBbs006Service.updateBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	//1:1상담 삭제처리
	@RequestMapping(value="/McmCmnBbs006M15DP.do")
	public ModelAndView getUpdateMcmCmnBbs006M15D(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		mcmCmnBbs006VO.setBbsCd("BBS001003");
			
		mcmCmnBbs006VO.setBbsId(mcmCmnBbs006VO.getBbsFaqSeq1());
		mcmCmnBbs006Service.deleteBbsData(mcmCmnBbs006VO);
		
		mcmCmnBbs006VO.setBbsId(mcmCmnBbs006VO.getBbsFaqSeq2());
		mcmCmnBbs006Service.deleteBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
	}
	
	
	//공지사항
	@RequestMapping(value="/McmCmnBbs006M21L.do")
	public String getListMcmCmnBbs006M21L(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		
		mcmCmnBbs006VO.setBbsCd("BBS001002");
		
		//현재 사용자가 관리자
		commonService.checkAthCdForAdmPg(session, mcmCmnBbs006VO, "CMN001005");
		
		
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnBbs006VO.getPageIndex(), mcmCmnBbs006VO.getRecordCountPerPage());
		mcmCmnBbs006VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnBbs006VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnBbs006VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
			
		List<?> resultList = mcmCmnBbs006Service.selectBbsList(mcmCmnBbs006VO);
			
		//목록 카운트 조회
	    int totCnt = mcmCmnBbs006Service.selectBbsCnt(mcmCmnBbs006VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	      
	    model.addAttribute("resultList", resultList);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    model.addAttribute("checkAth",mcmCmnBbs006VO.isAthCheck());
	    
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M21L";
		
	}
	
	@RequestMapping(value="/McmCmnBbs006M22R.do")
	public String getRetriveMcmCmnBbs006M22R(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		mcmCmnBbs006VO.setBbsCd("BBS001002");
		
		Map<?,?> resultMap = mcmCmnBbs006Service.selectBbsRetrive(mcmCmnBbs006VO);
	    model.addAttribute("resultMap", resultMap);
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M22R";
	}
	
	@RequestMapping(value="/McmCmnBbs006M23C.do")
	public String getInsertMcmCmnBbs006M23C(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
				
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M23C";
	}
	
	@RequestMapping(value="/McmCmnBbs006M23CP.do")
	public ModelAndView getInsertMcmCmnBbs006M23CP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		commonService.setDefaultInfo(session, request, mcmCmnBbs006VO);
		mcmCmnBbs006VO.setBbsCd("BBS001002");
		//삭제여부
		mcmCmnBbs006VO.setBbsDelYn("N");
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnBbs006VO.setLstUdtId(userInfoVO.getUsrId());
		
		
		//작성자ID
		mcmCmnBbs006VO.setUsrId(userInfoVO.getUsrId());
		//작성자 이름
		mcmCmnBbs006VO.setUsrNm(userInfoVO.getUsrNm());
		
		int grpNo = mcmCmnBbs006Service.selectBbsGrpId(mcmCmnBbs006VO);
		mcmCmnBbs006VO.setBbsGrpId(grpNo);
		//게시판 그룹순서
		mcmCmnBbs006VO.setBbsGrpDep(1);
		//게시판 답글순서
		mcmCmnBbs006VO.setBbsGrpOrd(1);
		mcmCmnBbs006VO.setBbsReStt("N");
		mcmCmnBbs006VO.setBbsReYn("N");
		
		mcmCmnBbs006Service.insertBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	@RequestMapping(value="/McmCmnBbs006M24U.do")
	public String getUpdateMcmCmnBbs006M24U(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005");
		
		mcmCmnBbs006VO.setBbsCd("BBS001002");
		
		Map<?,?> resultMap = mcmCmnBbs006Service.selectBbsRetrive(mcmCmnBbs006VO);
	    model.addAttribute("resultMap", resultMap);
		
	    return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M24U";
	}
	@RequestMapping(value="/McmCmnBbs006M24UP.do")
	public ModelAndView getUpdateMcmCmnBbs006M24UP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		mcmCmnBbs006VO.setBbsCd("BBS001002");
			
		mcmCmnBbs006Service.updateBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	//1:1상담 삭제처리
	@RequestMapping(value="/McmCmnBbs006M25DP.do")
	public ModelAndView getUpdateMcmCmnBbs006M25D(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		mcmCmnBbs006VO.setBbsCd("BBS001002");
			
		mcmCmnBbs006Service.deleteBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
	}
	
	
	
	//고객후기
	@RequestMapping(value="/McmCmnBbs006M31L.do")
	public String getListMcmCmnBbs006M31L(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
				
		mcmCmnBbs006VO.setBbsCd("BBS001004");
		//페이지 네비게이션 설정
		PaginationInfo paginationInfo = new PaginationInfo();
		commonService.getPageInfo( paginationInfo, mcmCmnBbs006VO.getPageIndex(), mcmCmnBbs006VO.getRecordCountPerPage());
		mcmCmnBbs006VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmCmnBbs006VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		mcmCmnBbs006VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		
		
			
		List<?> resultList = mcmCmnBbs006Service.selectBbsList(mcmCmnBbs006VO);
			
		//목록 카운트 조회
	    int totCnt = mcmCmnBbs006Service.selectBbsCnt(mcmCmnBbs006VO);
	    paginationInfo.setTotalRecordCount(totCnt);
	      
	    model.addAttribute("resultList", resultList);
	    model.addAttribute("paginationInfo", paginationInfo);
	    model.addAttribute("totCnt",totCnt);
	    model.addAttribute("checkAth",mcmCmnBbs006VO.isAthCheck());
	    
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M31L";
		
	}
	
	@RequestMapping(value="/McmCmnBbs006M32R.do")
	public String getRetriveMcmCmnBbs006M32R(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001001,CMN001002,CMN001003,CMN001004,CMN001005");
		
		
		commonService.checkWriter(session, mcmCmnBbs006VO, mcmCmnBbs006VO.getUsrId());
		
		
		mcmCmnBbs006VO.setBbsCd("BBS001004");
		
		Map<?,?> resultMap = mcmCmnBbs006Service.selectBbsRetrive(mcmCmnBbs006VO);
	    model.addAttribute("resultMap", resultMap);
	    model.addAttribute("checkWrt", mcmCmnBbs006VO.isWrtCheck());
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M32R";
	}
	
	@RequestMapping(value="/McmCmnBbs006M33C.do")
	public String getInsertMcmCmnBbs006M33C(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M33C";
	}
	
	@RequestMapping(value="/McmCmnBbs006M33CP.do")
	public ModelAndView getInsertMcmCmnBbs006M33CP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		commonService.setDefaultInfo(session, request, mcmCmnBbs006VO);
		mcmCmnBbs006VO.setBbsCd("BBS001004");
		
		
		
		
		//삭제여부
		mcmCmnBbs006VO.setBbsDelYn("N");
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnBbs006VO.setLstUdtId(userInfoVO.getUsrId());
		
		
		//작성자ID
		mcmCmnBbs006VO.setUsrId(userInfoVO.getUsrId());
		//작성자 이름
		mcmCmnBbs006VO.setUsrNm(userInfoVO.getUsrNm());
		
		int grpNo = mcmCmnBbs006Service.selectBbsGrpId(mcmCmnBbs006VO);
		mcmCmnBbs006VO.setBbsGrpId(grpNo);
		//게시판 그룹순서
		mcmCmnBbs006VO.setBbsGrpDep(1);
		//게시판 답글순서
		mcmCmnBbs006VO.setBbsGrpOrd(1);
		mcmCmnBbs006VO.setBbsReStt("N");
		mcmCmnBbs006VO.setBbsReYn("N");
		
		mcmCmnBbs006Service.insertBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	@RequestMapping(value="/McmCmnBbs006M34U.do")
	public String getUpdateMcmCmnBbs006M34U(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		mcmCmnBbs006VO.setBbsCd("BBS001004");
		
		Map<?,?> resultMap = mcmCmnBbs006Service.selectBbsRetrive(mcmCmnBbs006VO);
		
	    model.addAttribute("resultMap", resultMap);
	    
	    
		
		
	    return commonService.getMcmPreFix()+"mcm/cmn/bbs/McmCmnBbs006M34U";
	}
	@RequestMapping(value="/McmCmnBbs006M34UP.do")
	public ModelAndView getUpdateMcmCmnBbs006M34UP(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		mcmCmnBbs006VO.setBbsCd("BBS001004");
			
		mcmCmnBbs006Service.updateBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
		
	}
	@RequestMapping(value="/McmCmnBbs006M35DP.do")
	public ModelAndView getUpdateMcmCmnBbs006M35D(
			@ModelAttribute("mcmCmnBbs006VO") McmCmnBbs006VO mcmCmnBbs006VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		mcmCmnBbs006VO.setBbsCd("BBS001004");
			
		mcmCmnBbs006Service.deleteBbsData(mcmCmnBbs006VO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
		
	}
	
	
	
	
}
