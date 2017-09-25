package kr.co.mcmall.mcm.cmn.usr.service;

import java.util.List;
import java.util.Map;


/**
 * @Class Name : McmCmnUsr003Service.java
 * @Description : McmCmnUsr003Service Service Interface
 *                조합원관리 서비스 인터페이스
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

public interface McmCmnUsr003Service {
	
	
	/**
	 * 조합원 목록 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectUsrList(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	/**
	 * 조합원 목록 조회 건수
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	int selectUsrListTotCnt(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	/**
	 * 조합원 목록 엑셀 다운로드
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectUsrExcelList(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	
	/**
	 * 조합원정보 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	
	/**
	 * 사용자 정보 등록
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	/**
	 * 조합원정보 수정
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	void updateUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	
	/**
	 * 조합원 정보 삭제
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	void deleteUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	
	/**
	 * ID 중복확인
	 * @param fmsFndOrd002VO
	 * @return
	 * @throws Exception
	 */
	String selectExistsId(String usrId) throws Exception;
	
	
	
	/**
	 * 조합원가입신청 목록 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectUsrAppList(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	/**
	 * 조합원가입신청 목록 조회 건수
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	int selectUsrAppListTotCnt(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	
	/**
	 * 조합원 가입신청 승인
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	void updateUsAppInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
	
	
	/**
	 * 상점별 사용자 등록
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrStrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;

	
	/**
	 * 사용자 권한 부여
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrDefaultAth(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception;
}
