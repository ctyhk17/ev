package kr.co.mcmall.mcm.cmn.usr.service;

import java.util.List;
import java.util.Map;


/**
 * @Class Name : McmCmnUsr002Service.java
 * @Description : McmCmnUsr002Service Service Interface
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

public interface McmCmnUsr002Service {
	
	
	/**
	 * 조합원 목록 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectUsrList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	/**
	 * 조합원 목록 조회 건수
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	int selectUsrListTotCnt(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	
	/**
	 * 조합원정보 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	
	/**
	 * 사용자 정보 등록
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	/**
	 * 조합원정보 수정
	 * @param mcmCmnUsr002VO
	 * @throws Exception
	 */
	void updateUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	
	/**
	 * 조합원 정보 삭제
	 * @param mcmCmnUsr002VO
	 * @throws Exception
	 */
	void deleteUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	
	/**
	 * ID 중복확인
	 * @param fmsFndOrd002VO
	 * @return
	 * @throws Exception
	 */
	String selectExistsId(String usrId) throws Exception;
	
	
	
	/**
	 * 조합원가입신청 목록 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectUsrAppList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	/**
	 * 조합원가입신청 목록 조회 건수
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	int selectUsrAppListTotCnt(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	
	/**
	 * 조합원 가입신청 승인
	 * @param mcmCmnUsr002VO
	 * @throws Exception
	 */
	void updateUsAppInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	
	/**
	 * 상점별 사용자 등록
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrStrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;

	
	/**
	 * 사용자 권한 부여
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	String insertUsrDefaultAth(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	/**
	 * 조합원코드 분류
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectAthCdList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	/**
	 * 조합원코드 분류
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectUsrExcelList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception;
	
	// 승인시 권한코드 부여
	String insertUsrAth(McmCmnUsr002VO mcmCmnUsr003VO) throws Exception ;
}
