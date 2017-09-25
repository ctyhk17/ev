package kr.co.mcmall.mcm.cmn.usr.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr001Service;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr001VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name  : McmCmnUsr001Controller.java
 * @Description : McmCmnUsr001Controller Class
 *                회원관리 컨트롤러
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
public class McmCmnUsr001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 회원가입 서비스 */
	@Resource(name = "mcmCmnUsr001Service")
	private McmCmnUsr001Service mcmCmnUsr001Service;

	
	/**
	 * 회원가입
	 * @param mcmCmnUsr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr001M01C.do")
	public String getViewMcmCmnUsr001M02C(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr001M01C";
	}
	
	/**
	 * ID 중복확인
	 * @param mcmCmnUsr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr001P01R.do")
	public ModelAndView getViewMcmCmnUsr001P02R(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		String isValid = mcmCmnUsr001Service.selectExistsId(mcmCmnUsr001VO.getUsrId());
		
		String rtnCode = "000";
		
		// 중복된 아이디가 있는 경우
		if("Y".equals(isValid))
			rtnCode = "999";
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   
		returnJsonMap.put("rtnCode", rtnCode);     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	/**
	 * 회원가입처리
	 * @param mcmCmnUsr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr001M01CP.do")
	public ModelAndView getViewMcmCmnUsr001M02CP(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		String isValid = mcmCmnUsr001Service.selectExistsId(mcmCmnUsr001VO.getUsrId());
		
		String rtnCode = "000";
		String rtnMsg = "";
		
		// 중복된 아이디가 있는 경우
		if("Y".equals(isValid)){
			rtnCode = "999";
			rtnMsg  = "중복된 아이디가 존재 합니다.";
		}else{
			rtnCode = "000";
			
			
			commonService.setDefaultInfo(session, request, mcmCmnUsr001VO);
			
			// 회원가입 처리	
			mcmCmnUsr001Service.insertUsrInfo(mcmCmnUsr001VO);
			
			//상점별 회원 등록
			mcmCmnUsr001Service.insertUsrStrInfo(mcmCmnUsr001VO);
		}
			
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   
		returnJsonMap.put("rtnCode", rtnCode);     
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	

	
	
	

	/**
	 * 회원가입 결과 화면
	 * @param fmsCmnUsr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr001M02R.do")
	public String getViewMcmCmnUsr001M03R(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		
		// 회원정보 조회
		Map<?,?> resultInfo = mcmCmnUsr001Service.selectUsrInfo(mcmCmnUsr001VO);
		model.addAttribute("resultInfo", resultInfo);
				
        
        return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr001M02R";
	}
	
	
	/**
	 * 회원정보관리
	 * @param mcmCmnUsr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/McmCmnUsr001M03U.do")
	public String getViewMcmCmnUsr001M03U(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		
		// 세션 정보 조회
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnUsr001VO.setUsrId(userInfoVO.getUsrId());
		
		// 회원정보 조회
		Map<?,?> resultInfo = mcmCmnUsr001Service.selectUsrInfo(mcmCmnUsr001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		mcmCmnUsr001VO.setUsrId((String)resultInfo.get("usrId"));
		mcmCmnUsr001VO.setUsrPwd((String)resultInfo.get("usrPWd"));
		mcmCmnUsr001VO.setUsrNm((String)resultInfo.get("usrNm"));
		mcmCmnUsr001VO.setTelNo((String)resultInfo.get("telNo"));
		mcmCmnUsr001VO.setEmailAddr((String)resultInfo.get("emailAddr"));
		mcmCmnUsr001VO.setRdAddr((String)resultInfo.get("rdAddr"));
		mcmCmnUsr001VO.setRdAddrDtl((String)resultInfo.get("rdAddrDtl"));
		mcmCmnUsr001VO.setPstNo((String)resultInfo.get("pstNo"));
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr001M03U";
	}
	
	/**
	 * 회원정보관리 
	 * @param mcmCmnUsr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr001M03UP.do")
	public ModelAndView getViewMcmCmnUsr001M03UP(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		// 세션 정보 조회
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnUsr001VO.setUsrId(userInfoVO.getUsrId());
				
				
		// 회원정보 수정	
		mcmCmnUsr001Service.updateUsrInfo(mcmCmnUsr001VO);
		
		Map<String, String> returnJsonMap = new HashMap<String, String>();   
		returnJsonMap.put("rtnCode", "000");     
		returnJsonMap.put("rtnMsg", "정상적으로 수정되었습니다.");
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	/**
	 * 회원탈퇴
	 * @param mcmCmnUsr001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnUsr001M04R.do")
	public String getViewMcmCmnUsr001M04R(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		// 세션 정보 조회
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnUsr001VO.setUsrId(userInfoVO.getUsrId());
		
		// 회원정보 조회
		Map<?,?> resultInfo = mcmCmnUsr001Service.selectUsrInfo(mcmCmnUsr001VO);
		model.addAttribute("resultInfo", resultInfo);
		
		mcmCmnUsr001VO.setUsrId((String)resultInfo.get("usrId"));
		mcmCmnUsr001VO.setUsrPwd((String)resultInfo.get("usrPWd"));
		mcmCmnUsr001VO.setUsrNm((String)resultInfo.get("usrNm"));
		mcmCmnUsr001VO.setTelNo((String)resultInfo.get("telNo"));
		mcmCmnUsr001VO.setEmailAddr((String)resultInfo.get("emailAddr"));
		
		return commonService.getMcmPreFix()+"mcm/cmn/usr/McmCmnUsr001M04R";
	}
	
	
	@RequestMapping(value = "/McmCmnUsr001M04RP.do")
	public ModelAndView getViewMcmCmnUsr001M04RP(
			@ModelAttribute("mcmCmnUsr001VO") McmCmnUsr001VO mcmCmnUsr001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		Map<String, String> returnJsonMap = new HashMap<String, String>();
		

		// 세션 정보 조회
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		mcmCmnUsr001VO.setUsrId(userInfoVO.getUsrId());
		
		Map<?,?> resultInfo = mcmCmnUsr001Service.selectUsrInfoWithPassword(mcmCmnUsr001VO);

		if(resultInfo == null)
		{
			returnJsonMap.put("rtnCode", "999");     
			returnJsonMap.put("rtnMsg", "이름 또는 비밀번호가 일치하지 않습니다.");
			
			
		}else{
			
			// 회원정보 수정	
			mcmCmnUsr001Service.stopUsrInfo(mcmCmnUsr001VO);
			
			returnJsonMap.put("rtnCode", "000");     
			returnJsonMap.put("rtnMsg", "회원탈퇴가 정상적으로 처리되었습니다.");
		}
		
		
		
		// 로그아웃 처리
		session.removeAttribute("userInfoVO");

		session.invalidate();
				
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
	}
	
	
	
}

