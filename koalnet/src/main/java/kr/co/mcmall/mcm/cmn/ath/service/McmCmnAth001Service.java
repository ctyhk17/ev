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

public interface McmCmnAth001Service {
	
	/**
	 * 목록조회
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectMcmCmnAth002M01List(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	/**
	 * 목록 갯수 조회 
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectTemplatetListTotCnt(McmCmnAth002VO mcmCmnAth002VO);
	

	/**
	 * 상세내욕 조회
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 mcmTplTpl001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	Map<?, ?> selectTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception;

	
	/**
	 * 등록
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	String insertTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	
	/**
	 * 수정
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	void updateTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	
	/**
	 * 삭제
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	int deleteTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception;
	

	
	

}
