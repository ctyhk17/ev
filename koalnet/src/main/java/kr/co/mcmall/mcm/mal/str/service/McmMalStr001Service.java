package kr.co.mcmall.mcm.mal.str.service;

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

public interface McmMalStr001Service {
	
	/**
	 * 목록조회
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectMcmMalStr001M01List(McmMalStr001VO mcmMalStr001VO) throws Exception;

	/**
	 * 목록 갯수 조회 
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectMcmMalStr001M01Paging(McmMalStr001VO mcmMalStr001VO);
	

	/**
	 * 상세내욕 조회
	 * @param mcmMalStr001VO - 조회할 정보가 담긴 mcmMalStr001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	Map<?, ?> selectMcmMalStr001M02Info(McmMalStr001VO mcmMalStr001VO) throws Exception;

	
	/**
	 * 등록
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	String insertTemplatetInfo(McmMalStr001VO mcmMalStr001VO) throws Exception;
	
	
	/**
	 * 수정
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	void updateMcmMalStr001M03UP(McmMalStr001VO mcmMalStr001VO) throws Exception;
	
	/**
	 * 삭제
	 * @param mcmMalStr001VO
	 * @return
	 * @throws Exception
	 */
	int deleteTemplatetInfo(McmMalStr001VO mcmMalStr001VO) throws Exception;
	

	// 상점리스트조회
	List<?> selectMcmMalStr001M01StrList(McmMalStr001VO mcmMalStr001VO) throws Exception;
	
	// 상점설정 변경
	void updateMcmMalStr001M04UP(McmMalStr001VO mcmMalStr001VO) throws Exception;
	void updateMcmMalStr001M05UP(McmMalStr001VO mcmMalStr001VO) throws Exception;
	void updateMcmMalStr001M06UP(McmMalStr001VO mcmMalStr001VO) throws Exception;
	void updateMcmMalStr001M07UP(McmMalStr001VO mcmMalStr001VO) throws Exception;
	void updateMcmMalStr001M08UP(McmMalStr001VO mcmMalStr001VO) throws Exception;
	void updateMcmMalStr001M09UP(McmMalStr001VO mcmMalStr001VO) throws Exception;
}
