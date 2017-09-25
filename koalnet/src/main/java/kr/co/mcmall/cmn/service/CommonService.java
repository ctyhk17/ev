package kr.co.mcmall.cmn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public interface CommonService {
	 
	
    String getStDt(int interval) throws Exception;
    
    List getCommCd(String value) throws Exception;
    
    // 페이징 정보 설정
 // 	페이징 정보 설정
    void getPageInfo(PaginationInfo paginationInfo, int pageIndex) throws Exception;
    
    void getPageInfo(PaginationInfo paginationInfo, int pageIndex, CommonVO commonVO) throws Exception;
    
    void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage) throws Exception;
    
    void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage, CommonVO commonVO) throws Exception;
    
    void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage, int pageSize) throws Exception;
    
    /**
     * mcm 패키지 jsp 경로를 조회
     * @return
     * @throws Exception
     */
    String getMcmPreFix() throws Exception;
     
    
    void setDefaultInfo(HttpSession session, HttpServletRequest request, CommonVO commonVO) throws Exception;
    
    //권한체크
    void checkAthCd(HttpSession session, HttpServletResponse response, String athCd) throws Exception;
    
    void checkAthCdForAdmPg(HttpSession session, CommonVO commonVO, String athCd ) throws Exception;
    
    void checkWriter(HttpSession session, CommonVO commonVO, String writer) throws Exception;
    
}