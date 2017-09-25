package kr.co.mcmall.cmn.service.impl;

import java.io.PrintWriter;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mcmall.cmn.service.CommonService;
import kr.co.mcmall.cmn.service.CommonVO;
import kr.co.mcmall.cmn.service.UserInfoVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : TmpTempTemplate.java
 * @Description : TmpTempTemplate Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.12           최초생성
 *
 * @author 개발팀
 * @since 2016.07.12
 * @version 1.0
 * @see
 *  
 */

@Service("commonService")
public class CommonServiceImpl extends EgovAbstractServiceImpl implements CommonService {
	
	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	/** SampleDAO */
    @Resource(name="commonDAO")
    private CommonDAO commonDAO;
    
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	public String getStDt(int interval) throws Exception {
		// TODO Auto-generated method stub

		Calendar cal = Calendar.getInstance ( );
		cal.add(cal.MONTH, interval ); 
		String yyyy  = String.valueOf(cal.get(cal.YEAR ));
		String mm = String.valueOf(cal.get(cal.MONTH) + 1);
		if(mm.length() < 2)
			mm = "0"+mm;
		String dd   = String.valueOf(cal.get(cal.DATE ));
		if(dd.length() < 2)
			dd = "0"+dd;
		
		return yyyy+"-"+mm+"-"+dd;
	}

	// 페이지 정보 설정
	public void getPageInfo(PaginationInfo paginationInfo, int pageIndex) throws Exception {
		// TODO Auto-generated method stub
        
        paginationInfo.setCurrentPageNo(pageIndex);
        paginationInfo.setPageSize(propertiesService.getInt("pageSize"));
        paginationInfo.setRecordCountPerPage(propertiesService.getInt("recordCountPerPage"));
		
	}
	
	public void getPageInfo(PaginationInfo paginationInfo, int pageIndex, CommonVO commonVO) throws Exception{
		paginationInfo.setCurrentPageNo(pageIndex);
        paginationInfo.setPageSize(propertiesService.getInt("pageSize"));
        paginationInfo.setRecordCountPerPage(propertiesService.getInt("recordCountPerPage"));
        
        commonVO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
        commonVO.setRecordCountPerPage( paginationInfo.getRecordCountPerPage() );
	}
	
	
	public void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage, CommonVO commonVO) throws Exception{
		paginationInfo.setCurrentPageNo(pageIndex);
        paginationInfo.setPageSize(propertiesService.getInt("pageSize"));
        paginationInfo.setRecordCountPerPage(recordCountPerPage);
        
        commonVO.setFirstIndex( paginationInfo.getFirstRecordIndex() );
        commonVO.setRecordCountPerPage( paginationInfo.getRecordCountPerPage() );
	}
	
	
	public void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage) throws Exception{
		// TODO Auto-generated method stub
        
        paginationInfo.setCurrentPageNo(pageIndex);
        paginationInfo.setPageSize(propertiesService.getInt("pageSize"));
        paginationInfo.setRecordCountPerPage(recordCountPerPage);
		
	}
	
	public void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage, int pageSize) throws Exception{
		// TODO Auto-generated method stub
        
        paginationInfo.setCurrentPageNo(pageIndex);
        paginationInfo.setPageSize(pageSize);
        paginationInfo.setRecordCountPerPage(recordCountPerPage);
		
	}

	@Override
	public List getCommCd(String value) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String getMcmPreFix() throws Exception{
		return propertiesService.getString("mcmPreFix");
	}
	
	public void setDefaultInfo(HttpSession session, HttpServletRequest request, CommonVO commonVO) throws Exception{
		
		String remoteAddr = request.getRemoteAddr();
		String usrId = null;
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
		
		if(userInfoVO != null)
			usrId = userInfoVO.getUsrId();
		
		
		
		commonVO.setLstUdtIp(remoteAddr);
		commonVO.setLstUdtId(usrId);
		
	}
	
	
	@Override
	public void checkAthCd(HttpSession session, HttpServletResponse response,
			String athCd) throws Exception {
		// TODO Auto-generated method stub
		
		int matchCnt = 0;
		
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
		if(userInfoVO == null){
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('로그인이 필요한 서비스 입니다.');location.href='/McmCmnLgn001M01R.do';</script>");	        
	        out.flush(); 
	        
		}else{
			Map athMap = userInfoVO.getAthCdMap();
			System.out.println(athMap.toString());
			
			String[] athCdArr = athCd.split(",");
			
			for(int i=0; i<athCdArr.length; i++){
				
				System.out.println("athCdArr["+i+"] : " + athCdArr[i]);
				
				if(athMap.containsValue(athCdArr[i].trim()))
					matchCnt++;
				
				System.out.println("matchCnt : " + matchCnt);
			}
			
			if(matchCnt == 0)
			{
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('잘못된 접근입니다.');location.href='/McmMalItr001M01L.do';</script>");	        
				out.flush(); 
			
			}
		}
		
	}
	
	//현재 사용자가 페이지버튼의 사용 권한이 존재하는지 boolean check
	@Override
	public void checkAthCdForAdmPg(HttpSession session, CommonVO commonVO, String athCd) throws Exception {
		// TODO Auto-generated method stub
		boolean check = true;
		int matchCnt = 0;
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
		Map athMap = userInfoVO.getAthCdMap();
		System.out.println(athMap.toString());
		
		String[] athCdArr = athCd.split(",");
		
		for(int i=0; i<athCdArr.length; i++){
			
			System.out.println("athCdArr["+i+"] : " + athCdArr[i]);
			
			if(athMap.containsValue(athCdArr[i].trim()))
				matchCnt++;
			
			System.out.println("matchCnt : " + matchCnt);
		}
		check = matchCnt > 0 ? true : false;
		
		
		commonVO.setAthCheck(check); 
		
	}
	
	
	//1:1문의 혹은 고객후기 작성자와 접속자가 같은지 확인 
	@Override
	public void checkWriter(HttpSession session, CommonVO commonVO,  String writer) throws Exception {
		// TODO Auto-generated method stub
		boolean check = true;
		
		UserInfoVO userInfoVO = (UserInfoVO)session.getAttribute("userInfoVO");
		
		System.out.println(writer);
		
		/*if(writer.contains(",")){
			writer = writer.replace(",", "");
		}*/
		
		
		String lgnUsrId = userInfoVO.getUsrId();
		
		if(!writer.equals(lgnUsrId)){
			if(userInfoVO.getAthCdMap().containsValue("CMN001005") || userInfoVO.getAthCdMap().containsValue("CMN001006")){
				
				check = true;
				
			}else{
				check = false;
			}
			
		}
		commonVO.setWrtCheck(check);
		
	}
	   
}
