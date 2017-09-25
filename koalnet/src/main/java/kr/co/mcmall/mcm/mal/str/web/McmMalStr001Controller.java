package kr.co.mcmall.mcm.mal.str.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002VO;
import kr.co.mcmall.mcm.mal.str.service.McmMalStr001Service;
import kr.co.mcmall.mcm.mal.str.service.McmMalStr001VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : McmMalStrController.java
 * @Description : McmMalStrController Controller Class
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
public class McmMalStr001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmMalStr001Service")
	private McmMalStr001Service mcmMalStr001Service;

	/** 서비스 */
	@Resource(name = "mcmMalBiz002Service")
	private McmMalBiz002Service mcmMalBiz002Service;
	

	
	/**
	 * 목록조회
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M01L.do")
	public String getViewMcMalStr001M01L(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
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
		commonService.getPageInfo( paginationInfo, mcmMalStr001VO.getPageIndex(), mcmMalStr001VO.getRecordCountPerPage());
//		
		mcmMalStr001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
		mcmMalStr001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
		mcmMalStr001VO.setRecordCountPerPage( paginationInfo.getRecordCountPerPage() );
//		
		
		// 목록조회
		List<?> resultList = mcmMalStr001Service.selectMcmMalStr001M01List(mcmMalStr001VO);
		model.addAttribute("resultList", resultList);

		
		//상점목록조회
		List<?> selectStrList = mcmMalStr001Service.selectMcmMalStr001M01StrList(mcmMalStr001VO);
		model.addAttribute("selectStrList",selectStrList);
		
		// 목록 카운트 조회
		int totCnt = mcmMalStr001Service.selectMcmMalStr001M01Paging(mcmMalStr001VO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("totCnt",totCnt);
		                   
		return commonService.getMcmPreFix()+"mcm/mal/str/McmMalStr001M01L";
	}

	
	
	
	/**
	 * 상세조회
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M02R.do")
	public String getViewMcmMalStr001M02R(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		
		Map<?,?> resultInfo = mcmMalStr001Service.selectMcmMalStr001M02Info(mcmMalStr001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		return commonService.getMcmPreFix()+"mcm/mal/str/McmMalStr001M02R";
	}
	
	
	/**
	 * 등록화면
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M03C.do")
	public String getViewMcmMalStr001M03C(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		return commonService.getMcmPreFix()+"mcm/mal/str/McmMalStr001M03C";
	}
	
	/**
	 * 등록처리
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M03CP.do")
	public ModelAndView getViewMcmMalStr001M03CP(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		// 저장
		//String adsubMgntNo = mcmMalStr001Service.insertTemplatetInfo(mcmMalStr001VO);
		
		
		
		
		// ---------------------------------------------------------
		// 파일 등록 시작
		// ---------------------------------------------------------
		
		Map paramMap = new HashMap();
		
		
		final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		
		Calendar cal = Calendar.getInstance();	//현재날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String timeFormat = sdf.format(cal.getTime());
		
		String uploadPath = propertiesService.getString("gdsAttImgPath");
		
		
		File saveFolder = new File(uploadPath);

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		
		
		int fileCnt = 0;
		
		
		if(files != null && files.size() > 0)
		{
			
			// 파일 확장자 오류 체크 시작
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			
			String orgFileNm = "";
			String orgFileExt   = "";
			
			String saveFileNm  = "";
			
			
			while (itr.hasNext()) 
			{
				Entry<String, MultipartFile> entry = itr.next();
				
				file = entry.getValue();
				
				
				// file form 이름 : jsp 에서 지정한 이름
				System.out.println("===================");
				System.out.println("file.getName(); : " + file.getName());
				
				
				
				if (!"".equals(file.getOriginalFilename())) {
					
					orgFileNm   = file.getOriginalFilename();
					orgFileExt  = orgFileNm.substring(orgFileNm.lastIndexOf("."));
					
					// 파일 확장자 체크 로직
					if(orgFileExt != null && (".JSP".equals(orgFileExt.toUpperCase()) || ".EXE".equals(orgFileExt.toUpperCase()) || ".BAT".equals(orgFileExt.toUpperCase()) ) )
					{
						// 에러처리
					}
					
					orgFileNm           = file.getOriginalFilename();
					orgFileExt          = orgFileNm.substring(orgFileNm.lastIndexOf("."));

					
					// 서버에 저장할 파일 이름 명 지정 (상품 아이디 + 파일순번 + 시간 + 확장자
					saveFileNm = uploadPath + "/" + "gdsId" + "_" + fileCnt + "_" + timeFormat + orgFileExt;
					
					
					System.out.println("===================");
					System.out.println("serverFileNm : " + saveFileNm);
					
					
					// 첨부파일 전송
					file.transferTo(new File(saveFileNm));
					
					// 첨부파일 이름 및 경로 DB에 저장  
					
					
					
					
//					paramMap.put("gdsAttImg",      orgFileNm);       // 서버에 저장되는 파일 이름
//					paramMap.put("gdsAttImgPath",  serverFilePath);  // 파일 원래 이름
					
					
//					
//					cmnBbsQna001M01Service.insertAttFile(paramMap);
					
					
				}
				
				fileCnt++;
				
			}
			
		}
			
		// 첨부파일 등록 끝
					
					
					
					
					
					
		
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}


	/**
	 * 수정화면
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M03U.do")
	public String getViewMcmMalStr001M03U(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		Map<?,?> resultInfo = mcmMalStr001Service.selectMcmMalStr001M02Info(mcmMalStr001VO);
		
		mcmMalStr001VO.setStrPhnVal((String)resultInfo.get("strPhnVal"));
		mcmMalStr001VO.setStrEmailVal((String)resultInfo.get("strEmailVal"));
		mcmMalStr001VO.setStrFaxVal((String)resultInfo.get("strFaxVal"));
		mcmMalStr001VO.setStrBankVal((String)resultInfo.get("strBankVal"));
		mcmMalStr001VO.setStrAccVal((String)resultInfo.get("strAccVal"));
		mcmMalStr001VO.setStrAccnmVal((String)resultInfo.get("strAccnmVal"));
		mcmMalStr001VO.setStrCnts((String)resultInfo.get("strCnts"));
		mcmMalStr001VO.setStrNm((String)resultInfo.get("strNm"));
		model.addAttribute("resultInfo", resultInfo);
		
		return commonService.getMcmPreFix()+"mcm/mal/str/McmMalStr001M03U";
	}
	
	/**
	 * 수정처리
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M03UP.do")
	public ModelAndView getViewMcmMalStr001M04UP(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		
		// 수정
		mcmMalStr001Service.updateMcmMalStr001M03UP(mcmMalStr001VO);      
		mcmMalStr001Service.updateMcmMalStr001M04UP(mcmMalStr001VO);  // 대표전화번호
		mcmMalStr001Service.updateMcmMalStr001M05UP(mcmMalStr001VO);  // 팩스
		mcmMalStr001Service.updateMcmMalStr001M06UP(mcmMalStr001VO);  // 은행
		mcmMalStr001Service.updateMcmMalStr001M07UP(mcmMalStr001VO);  // 계좌
		mcmMalStr001Service.updateMcmMalStr001M08UP(mcmMalStr001VO);  // 예금주
		mcmMalStr001Service.updateMcmMalStr001M09UP(mcmMalStr001VO);  // 이메일
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	/**
	 * 삭제화면
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M05D.do")
	public String getViewMcmMalStr001M05D(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");

		
		return commonService.getMcmPreFix()+"mcm/mal/str/McmMalStr001M05D";
	}
	
	
	
	/**
	 * 삭제처리
	 * @param mcmMalStr001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmMalStr001M05DP.do")
	public ModelAndView getViewMcmMalStr001M05DP(
			@ModelAttribute("mcmMalStr001VO") McmMalStr001VO mcmMalStr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {
		
		//각페이지별 사용권한 유무 체크 
		commonService.checkAthCd(session, response, "CMN001005,CMN001006");
		
		mcmMalStr001Service.deleteTemplatetInfo(mcmMalStr001VO);
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
	}
	
	
	
	
}
