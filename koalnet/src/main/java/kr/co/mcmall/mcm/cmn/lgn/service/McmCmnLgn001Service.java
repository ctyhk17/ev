package kr.co.mcmall.mcm.cmn.lgn.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * @Class Name : FmsFndOrd001Service.java
 * @Description : FmsFndOrd001Service Service Interface
 *                주문 서비스 인터페이스
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

public interface McmCmnLgn001Service {
	
	
	/**
	 * 로그인 정보 조회
	 * @param mcmCmnLgn001VO
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectUsrInfo(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception;
	
	
	/**
	 * 로그인 처리
	 * @param session
	 * @param loginInfoMap
	 * @throws Exception
	 */
	void procLoginInfo(HttpSession session, Map loginInfoMap) throws Exception;
	
	
	/**
	 * ID 중복확인
	 * @param fmsFndOrd001VO
	 * @return
	 * @throws Exception
	 */
	String selectExistsId(String usrId) throws Exception;
	
	
	
	/**
	 * 권한 목록 조회
	 * @param usrId
	 * @return
	 * @throws Exception
	 */
	List<?> selectAthCdList(String usrId) throws Exception;
	
	
	
	/**
	 * 사용자 ID 목록 조회
	 * @param mcmCmnLgn001VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectUsrIdList(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception;
	
	
	/**
	 * 임시비밀번호 업데이트 
	 * @param value
	 * @throws Exception
	 */
	void updateTmpUsrPwd(Map<?,?> paramMap) throws Exception;
	
	
	Map <?,?> selectUsrInfoForPwd(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception;
	
	
	
	
	

	
	
	
	
	
	

}
