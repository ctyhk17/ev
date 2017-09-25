package kr.co.mcmall.mcm.cmn.lgn.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.mcm.cmn.lgn.service.McmCmnLgn001Service;
import kr.co.mcmall.mcm.cmn.lgn.service.McmCmnLgn001VO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name  : McmCmnLgn001Controller.java
 * @Description : McmCmnLgn001Controller Class
 *                로그인 컨트롤러
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
public class McmCmnLgn001Controller {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/** 로그인 서비스 */
	@Resource(name = "mcmCmnLgn001Service")
	private McmCmnLgn001Service mcmCmnLgn001Service;

	
	@Resource(name = "mailSender")
	private MailSender mailSender;
		
	/**
	 * 로그인 화면
	 * 
	 * @param fmsFndOrd001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnLgn001M01R.do")
	public String getViewMcmCmnLgn001M01R(
			@ModelAttribute("mcmCmnLgn001VO") McmCmnLgn001VO mcmCmnLgn001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		
		return commonService.getMcmPreFix()+"mcm/cmn/lgn/McmCmnLgn001M01R";
	}
	
	
	/**
	 * 로그인 처리
	 * @param fmsCmnLgn001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnLgn001M01RP.do")
	public ModelAndView getViewMcmCmnLgn001M01RP(
			@ModelAttribute("mcmCmnLgn001VO") McmCmnLgn001VO mcmCmnLgn001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
		Map<String,Object> returnJsonMap = new HashMap<String,Object>();
		
		
		// 회원정보 조회
		Map<?,?> resultInfo = mcmCmnLgn001Service.selectUsrInfo(mcmCmnLgn001VO);
		
		
		// 회원정보가 없는 경우
		if(resultInfo == null)
		{
			returnJsonMap.put("rtnCode", "999");
			returnJsonMap.put("rtnMsg",  "아이디 또는 비밀번호가 올바르지 않습니다.");
		
		// 회원탈퇴
		}else if("X".equals((String)resultInfo.get("useYn")))
		{
			returnJsonMap.put("rtnCode", "999");
			returnJsonMap.put("rtnMsg",  "탈퇴한 회원 아이디 입니다.");
		
		// 미승인회원
		}else if("N".equals((String)resultInfo.get("useYn")))
		{
			returnJsonMap.put("rtnCode", "001");
			returnJsonMap.put("rtnMsg",  "회원가입 승인중입니다.");
		}
		else{
			
			// 로그인 처리
			mcmCmnLgn001Service.procLoginInfo(session, resultInfo);
			
			returnJsonMap.put("rtnCode", "000");
		}
		
		
    	ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap); 
    	modelAndView.setViewName("jsonView");      
    	
    	return modelAndView;
		
	}
	
	/**
	 * 아이디/비밀번호 찾기
	 * @param fmsCmnLgn001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnLgn001M02R.do")
	public String getViewMcmCmnLgn001M04R(
			@ModelAttribute("mcmCmnLgn001VO") McmCmnLgn001VO mcmCmnLgn001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		
        
        return commonService.getMcmPreFix()+"mcm/cmn/lgn/McmCmnLgn001M02R";
	}
	
	
	
	/**
	 * ID찾기
	 * @param mcmCmnLgn001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnLgn001P02R.do")
	public ModelAndView fmsCmnLgn002Idsearch(
			@ModelAttribute("mcmCmnLgn001VO") McmCmnLgn001VO mcmCmnLgn001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		// 사용자 아이디 목록 조회
		List<?> resultList = mcmCmnLgn001Service.selectUsrIdList(mcmCmnLgn001VO);
		
		Map<String, Object> returnJsonMap = new HashMap<String, Object>();  
		returnJsonMap.put("rtnList", resultList);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap);
		modelAndView.setViewName("jsonView");
		
		
		return modelAndView;
	}
	
	/**
	 * PWD 찾기 ( 이메일발송 )
	 * @param mcmCmnLgn001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnLgn001P02RP.do")
	public ModelAndView fmsCmnLgn002Pwdsearch(
			@ModelAttribute("mcmCmnLgn001VO") McmCmnLgn001VO mcmCmnLgn001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		
		
		Map<String, Object> returnJsonMap = new HashMap<String, Object>();  
		
		
		// 사용자 정보 조회 
		// usrId로 조회
		Map<?,?> resultInfo = mcmCmnLgn001Service.selectUsrInfoForPwd(mcmCmnLgn001VO);
		
		if(resultInfo == null)
		{
			returnJsonMap.put("rtnCode", "999");
			returnJsonMap.put("rtnMsg", "아이디가 존재하지 않습니다.");
		
		
		}else{
			
			
			String emailAddr = (String) resultInfo.get("emailAddr");
			String usrId     = (String) resultInfo.get("usrId");
			
			
			if(emailAddr == null || "".equals(emailAddr))
			{
				returnJsonMap.put("rtnCode", "999");
				returnJsonMap.put("rtnMsg", "등록된 이메일주소가 없습니다.");
			
			}else{
				
				JavaMailSender jmailSender = (JavaMailSender) mailSender;
				MimeMessage message = ((JavaMailSender) mailSender).createMimeMessage();
				
				
				// 임시비밀번호 저장
				
				String tempPwd = "";
				
				for (int i = 0; i < 8; i++) {
					int rndVal = (int) (Math.random() * 62);
					if (rndVal < 10) {
						tempPwd += rndVal;
					} else if (rndVal > 35) {
						tempPwd += (char) (rndVal + 61);
					} else {
						tempPwd += (char) (rndVal + 55);
					}
				}
				
				Map<String, String> paramMap = new HashMap<String, String>();
				paramMap.put("usrId", usrId);
				paramMap.put("tempPwd", tempPwd);
				
				mcmCmnLgn001Service.updateTmpUsrPwd(paramMap);
				
				
				String content = "";
				content += "<strong>안녕하세요. MatchingFund 회원님</strong><br><strong>회원님의 임시 비밀번호는</strong> ";
				content += " [ <strong> " + tempPwd + " </strong> ] " +" &nbsp;<strong>입니다</strong>";
				
				if(emailAddr != null){
					MimeMessageHelper helper = new MimeMessageHelper(message, true,
							"UTF-8");
					helper.setSubject("[ 비밀번호 찾기 안내 ]");
					helper.setText(content, true);
					helper.setFrom("matchingchancebiz@gmail.com", "MatchingFund");
					helper.setTo(new InternetAddress(emailAddr));

					jmailSender.send(message);
				}
				
				returnJsonMap.put("rtnCode", "000");
				returnJsonMap.put("rtnMsg", "등록된 이메일로 임시 비밀번호를 발송하였습니다.");
			}
		}
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addAllObjects(returnJsonMap);
		modelAndView.setViewName("jsonView");
		
		return modelAndView;
	}
	
	

	
	
	
	
	/**
	 * 로그아웃 처리
	 * @param fmsCmnLgn001VO
	 * @param model
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/McmCmnLgn001M99RP.do")
	public String getViewMcmCmnLgn001M99RP(
			@ModelAttribute("mcmCmnLgn001VO") McmCmnLgn001VO mcmCmnLgn001VO,
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {

		// 로그아웃
		session.removeAttribute("userInfoVO");

		session.invalidate();
		
		
		return "redirect:/McmMalItr001M01L.do";
	}
	
	
}

