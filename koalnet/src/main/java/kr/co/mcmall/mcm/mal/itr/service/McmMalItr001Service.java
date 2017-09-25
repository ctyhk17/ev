package kr.co.mcmall.mcm.mal.itr.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : McmShpOrd001Service.java
 * @Description : McmShpOrd001Service Service Interface
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

public interface McmMalItr001Service {
	
	
	/**
	 * 상품목록 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectGdsList(McmMalItr001VO mcmMalItr001VO) throws Exception;
	
	
	/**
	 * 상품목록 건수 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	int selectGdsListTotCnt(McmMalItr001VO mcmMalItr001VO) throws Exception;
	
	
	/**
	 * 상점 설정 정보 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectStrInfo(McmMalItr001VO mcmMalItr001VO) throws Exception;

	
	/**
	 * 카테고리 목록 조회
	 * @return
	 * @throws Exception
	 */
	List<?> selectCtgrList()  throws Exception;
}
