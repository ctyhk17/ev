package kr.co.mcmall.cmn.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.UserInfoVO;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Service
public class AuthrtyChckInterceptor extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		
		HttpSession session =  request.getSession ();
		
		// Session
		UserInfoVO userInfoVO = (UserInfoVO) session.getAttribute("userInfoVO");

		String reqUrl      = (String)request.getRequestURI();
		
		
		//System.out.println("------------>reqUrl : " + reqUrl);
		
		// 세션체크에서 제외한 URL 추가
		if(
				   reqUrl.matches(".*/.*")	//모두 허용
//				   reqUrl.matches(".*/index.*")
//				|| reqUrl.matches(".*/images/.*")
//				|| reqUrl.matches(".*/img/.*")
//				|| reqUrl.matches(".*/html/.*")
//				|| reqUrl.matches(".*/css/.*")
//				|| reqUrl.matches(".*/js/.*")
//				
//				|| reqUrl.matches("/PR.*")							// 홍보물 주소 접근
//				|| reqUrl.matches("/pr.*")							// 홍보물 주소 접근
//				|| reqUrl.matches(".*/McmCmnLgn001.*")				// 로그인 관련 컨트롤러
//				
//				|| reqUrl.matches(".*/cmn.*")
//				
//				
//				|| reqUrl.matches(".*/McmCmnUsr001M01C.*")	// 회원가입
//				|| reqUrl.matches(".*/McmCmnUsr001P01R.*")	// 회원가입
//				|| reqUrl.matches(".*/McmCmnUsr001M01CP.*")	// 회원가입
//				|| reqUrl.matches(".*/McmCmnUsr001M02R.*")	// 회원가입
//				
//				
//				|| reqUrl.matches(".*/McmMalItr001M01L.*")	// 쇼핑몰 초기화면
//				|| reqUrl.matches(".*/McmMalItr001M02R.*")	// 쇼핑몰 초기화면
//				
//				
//				|| reqUrl.matches(".*/McmShpOrd001M00R.*")	// 회원가입
//				|| reqUrl.matches(".*/McmShpOrd001M01R.*")	// 회원가입
//				|| reqUrl.matches(".*/McmShpOrd001M02R.*")	// 회원가입
//				
//				
//				|| reqUrl.matches(".*/DdCmtImg.*")	    // 이미지 다운 컨트롤러
//				|| reqUrl.matches(".*/McmGdsMnImg.*")	// 이미지 다운 컨트롤러
//				|| reqUrl.matches(".*/McmGdsDtlImg.*")	// 이미지 다운 컨트롤러
//				
//				|| reqUrl.matches(".*/vr/.*")			// vrData 
//				|| reqUrl.matches(".*/vrHtml/.*")			// vrData 
//				
//				
//				
				
		)
		{
			
			if(reqUrl.toUpperCase().matches("/PR.*")){
				
				String seqNo = reqUrl.substring(reqUrl.toUpperCase().indexOf("/PR")+1).toUpperCase();
				
				response.sendRedirect("/McmShpOrd001M00R.do?seqNo="+ seqNo);
		        
				return false;
			} 
			
			return true; 
		}
		
		
//		String userId = "";
//		
//		
		// 세션 체크
		if(userInfoVO == null){
			
		    session.invalidate();
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('로그인이 필요한 서비스 입니다.');location.href='/cmn/itr/DdCmnItr000R.do';</script>");	        
	        out.flush(); 
	        
	        return false;
		}
		
		
		return true;
		
	}
	
}
