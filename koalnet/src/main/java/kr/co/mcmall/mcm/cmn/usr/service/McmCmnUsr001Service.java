package kr.co.mcmall.mcm.cmn.usr.service;

import java.util.Map;

/**
 * @Class Name : McmCmnUsr001Service.java
 * @Description : McmCmnUsr001Service Service Interface
 *                회원관리 서비스 인터페이스
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

public interface McmCmnUsr001Service {
	
	
	/**
	 * ID 중복확인
	 * @param fmsFndOrd001VO
	 * @return
	 * @throws Exception
	 */
	String selectExistsId(String usrId) throws Exception;
	
	
	/**
	 * 사용자 정보 등록
	 * @param mcmCmnUsr001VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;
	
	
	/**
	 * 회원정보 조회
	 * @param mcmCmnUsr001VO
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;
	
	Map<?,?> selectUsrInfoWithPassword(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;
	
	/**
	 * 회원정보 수정
	 * @param mcmCmnUsr001VO
	 * @throws Exception
	 */
	void updateUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;

	/**
	 * 회원탈퇴
	 * @param mcmCmnUsr001VO
	 * @throws Exception
	 */
	void stopUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;
	
	/**
	 * 상점별 사용자 등록
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrStrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;
	
	/**
	 * 사용자 주소 가져오기
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	
	Map<?, ?> getAddrInfo(String userId) throws Exception;
	
	// 회원정보 조회
	Map<?, ?> updateUsrPwd(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;
	
	// 비밀번호 변경처리
	void updateUsrPwdProc(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception;
	

}
