package kr.co.mcmall.mcm.shp.ord.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.UserInfoVO;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd003Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd003VO;

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
public class McmShpOrd003Controller {

	//로그
		private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
		
		
		@Resource(name = "commonService")
		protected CommonService commonService;
		
		
		@Resource(name = "propertiesService")
		protected EgovPropertyService propertiesService;
		
		@Resource(name = "mcmShpOrd003Service")
		private McmShpOrd003Service mcmShpOrd003Service;
		
		
		@RequestMapping(value="/McmShpOrd003M01L.do")
		public String getListMcmShpOrd003M01L(
				@ModelAttribute("mcmShpOrd003VO") McmShpOrd003VO mcmShpOrd003VO,
				ModelMap model,
				HttpSession session,
				HttpServletRequest request,
				HttpServletResponse response
				) throws Exception {
			
			
			UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
			mcmShpOrd003VO.setUsrId(userInfoVO.getUsrId());
			
			
			//페이지 네비게이션 설정
			PaginationInfo paginationInfo = new PaginationInfo();
			commonService.getPageInfo( paginationInfo, mcmShpOrd003VO.getPageIndex(), mcmShpOrd003VO.getRecordCountPerPage());
			mcmShpOrd003VO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
			mcmShpOrd003VO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
			mcmShpOrd003VO.setLastIndex( paginationInfo.getLastRecordIndex() );
				
				
			List<?> resultList = mcmShpOrd003Service.selectShpOrdWishList(mcmShpOrd003VO);
				
			//목록 카운트 조회
		    int totCnt = mcmShpOrd003Service.selectShpOrdWishCnt(mcmShpOrd003VO);
		    paginationInfo.setTotalRecordCount(totCnt);
		      
		    model.addAttribute("resultList", resultList);
		    model.addAttribute("paginationInfo", paginationInfo);
		    model.addAttribute("totCnt",totCnt);
		    
			
			return commonService.getMcmPreFix()+"mcm/shp/ord/McmShpOrd003M01L";
			
		}
		
		@RequestMapping(value="/McmShpOrd003M03C.do")
		public ModelAndView insertMcmShpOrd003M03C(
				@ModelAttribute("mcmShpOrd003VO") McmShpOrd003VO mcmShpOrd003VO,
				ModelMap model,
				HttpSession session,
				HttpServletRequest request,
				HttpServletResponse response
				) throws Exception {
			
			
			
			// 회원정보 수정	
			commonService.setDefaultInfo(session, request, mcmShpOrd003VO);
			UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
			
			mcmShpOrd003VO.setUsrId(userInfoVO.getUsrId());
			
			
			
			
			//사용자가 장바구니에 등록하려는 상품이 이미 장바구니에 존재하는 상품일경우
			Map<?, ?> crtMap = mcmShpOrd003Service.selectShpOrdWishExists(mcmShpOrd003VO);
			
			
			if(crtMap == null) {
				
				//존재하지 않을경우 장바구니에 insert한다
				mcmShpOrd003Service.insertShpOrdWishGoods(mcmShpOrd003VO);
				
			}else{
				//그전에 장바구니에 등록한 상품과 합친다.
				
				int exOrdCnt = Integer.parseInt(crtMap.get("ordCnt").toString());
				
				int ordCnt = Integer.parseInt(mcmShpOrd003VO.getOrdCnt());
				
				mcmShpOrd003VO.setOrdCnt(Integer.toString(exOrdCnt + ordCnt));
				mcmShpOrd003VO.setCrtId((String) crtMap.get("crtId"));
				
				
				mcmShpOrd003Service.updateShpOrdWishGoods(mcmShpOrd003VO);
			}
			
			
			
			ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("jsonView");    
	    	
	    	
	    	return modelAndView;
		}
		

		@RequestMapping(value="/McmShpOrd003M05D.do")
		public ModelAndView deleteMcmShpOrd003M03C(
				@ModelAttribute("mcmShpOrd003VO") McmShpOrd003VO mcmShpOrd003VO,
				ModelMap model,
				HttpSession session,
				HttpServletRequest request,
				HttpServletResponse response
				) throws Exception {
			
			
			
			mcmShpOrd003Service.deleteShpOrdWishGoods(mcmShpOrd003VO);
			
			
			ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.setViewName("jsonView");    
	    	
	    	
	    	return modelAndView;
			
		}
	
}
