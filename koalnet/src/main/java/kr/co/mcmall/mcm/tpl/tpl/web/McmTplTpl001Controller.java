package kr.co.mcmall.mcm.tpl.tpl.web;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.tpl.tpl.service.McmTplTpl001Service;
import kr.co.mcmall.mcm.tpl.tpl.service.McmTplTpl001VO;

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

/**
 * @Class Name : McmTplTplController.java
 * @Description : McmTplTplController Controller Class
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
public class McmTplTpl001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 서비스 */
	@Resource(name = "mcmTplTpl001Service")
	private McmTplTpl001Service mcmTplTpl001Service;


	
	/**
	 * 목록조회
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M01L.do")
	public String getViewMcTplTpl001M01L(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		// MCM 공통코드 조회
//		List<?> xxxCdList = commonService.selectCommonCdList("");
//		model.addAttribute("xxxCdList", xxxCdList);
		
		
		// 페이지 네비게이션 설정
//		PaginationInfo paginationInfo = new PaginationInfo();
//		commonService.getPageInfo( paginationInfo, mcmTplTpl001VO.getPageIndex(), mcmTplTpl001VO.getRecordCountPerPage());
//		
//		mcmTplTpl001VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
//		mcmTplTpl001VO.setLastIndex( paginationInfo.getLastRecordIndex() );
//		
		
		// 목록조회
//		List<?> resultList = mcmTplTpl001Service.selectTemplatetList(mcmTplTpl001VO);
//		model.addAttribute("resultList", resultList);

		
		// 목록 카운트 조회
//		int totCnt = mcmTplTpl001Service.selectTemplatetListTotCnt(mcmTplTpl001VO);
//		paginationInfo.setTotalRecordCount(totCnt);
//		model.addAttribute("paginationInfo", paginationInfo);

		                   
		return commonService.getMcmPreFix()+"mcm/tpl/tpl/McmTplTpl001M01L";
	}

	
	
	
	/**
	 * 상세조회
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M02R.do")
	public String getViewMcmTplTpl001M02R(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
//		Map<?,?> resultInfo = mcmTplTpl001Service.selectTemplatetInfo(mcmTplTpl001VO);
//		model.addAttribute("resultInfo", resultInfo);
		
		return commonService.getMcmPreFix()+"mcm/tpl/tpl/McmTplTpl001M02R";
	}
	
	
	/**
	 * 등록화면
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M03C.do")
	public String getViewMcmTplTpl001M03C(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		return commonService.getMcmPreFix()+"mcm/tpl/tpl/McmTplTpl001M03C";
	}
	
	/**
	 * 등록처리
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M03CP.do")
	public ModelAndView getViewMcmTplTpl001M03CP(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		// 저장
		//String adsubMgntNo = mcmTplTpl001Service.insertTemplatetInfo(mcmTplTpl001VO);
		
		
		
		
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
		
		System.out.println("======================");
		System.out.println("uploadPath : " + uploadPath);
		
		File saveFolder = new File(uploadPath);

		if (!saveFolder.exists() || saveFolder.isFile()) {
			saveFolder.mkdirs();
		}
		
		
		int fileCnt = 0;
		
		System.out.println("======================");
		System.out.println("files.size() : " + files.size());
		
		
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
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M04U.do")
	public String getViewMcmTplTpl001M04U(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		return commonService.getMcmPreFix()+"mcm/tpl/tpl/McmTplTpl001M04U";
	}
	
	/**
	 * 수정처리
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M04UP.do")
	public ModelAndView getViewMcmTplTpl001M04UP(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		
		
		// 수정
		mcmTplTpl001Service.updateTemplatetInfo(mcmTplTpl001VO);
				
		
		Map resultMap = new HashMap();   
    	resultMap.put("rtnMsg", "1");     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
	
	/**
	 * 삭제화면
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M05D.do")
	public String getViewMcmTplTpl001M05D(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		return commonService.getMcmPreFix()+"mcm/tpl/tpl/McmTplTpl001M05D";
	}
	
	
	
	/**
	 * 삭제처리
	 * @param mcmTplTpl001VO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmTplTpl001M05DP.do")
	public ModelAndView getViewMcmTplTpl001M05DP(
			@ModelAttribute("mcmTplTpl001VO") McmTplTpl001VO mcmTplTpl001VO,
			ModelMap model,
			HttpSession session,
			HttpServletResponse response
			) throws Exception {

		
		mcmTplTpl001Service.deleteTemplatetInfo(mcmTplTpl001VO);
		
		Map resultMap = new HashMap();   
		resultMap.put("rtnMsg", "1");      
    	
    	
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addAllObjects(resultMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
	}
	
	
	
	
}
