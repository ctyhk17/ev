package kr.co.mcmall.mcm.cmn.ath.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : FundTpltService.java
 * @Description : FundTpltService Service Interface
 *                매칭펀드 서비스 인터페이스
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.12           최초생성
 *
 * @author 개발팀
 * @since 2017.05.18
 * @version 1.0
 * @see
 *  
 */

public interface McmCmnAth002Service {
	
	/**
	 * 목록조회
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectMcmCmnAth002M01List(McmCmnAth002VO mcmCmnAth002VO) throws Exception;

	/**
	 * 목록 갯수 조회 
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectMcmCmnAth002M01TotCnt(McmCmnAth002VO mcmCmnAth002VO);
	

	/**
	 * 상세내욕 조회
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 mcmCmnAth002VO
	 * @return  상세정보
	 * @exception Exception
	 */
	Map<?, ?> selectMcmCmnAth002M01Info(McmCmnAth002VO mcmCmnAth002VO) throws Exception;

	
	/**
	 * 등록
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	String insertMcmCmnAth002M01NewAthCd(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	
	/**
	 * 수정
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	void updateMcmCmnAth002M01Ath(McmCmnAth002VO mcmCmnAth002VO) throws Exception;

	// 권한 코드 조회
	List<?> selectMcmCmnAth002M01AthList(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	//팝업 페이징
	int selectMcmCmnAth002P01TotCnt(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	// 팝업 리스트
	
	List<?> selectMcmCmnAth002P01List(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	// 사용자 권한 조회 리스트
	List<?> selectMcmCmnAth002M01usrAthList(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	// 삭제 처리
	int deleteMcmCmnAth002M05Ath(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	// 권한정보수정
	void updateMcmCmnAth002M01AthModify(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	// 권한부여
	String insertMcmCmnAth002P01CP(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	// 사업자코드넣기
	String insertMcmCmnAth002P02CP(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	// 사업자 중복 찾기
	int selectMcmCmnAth002FindLcsCd(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
}
