package kr.co.mcmall.mcm.shp.ord.service;

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

public interface McmShpOrd001Service {
	
	
	/**
	 * 상품 주문현황 조회
	 * @param mcmShpOrd001VO - 조회할 정보가 담긴 mcmShpOrd001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	Map<?, ?> selectGdsInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
	/**
	 * 상품설명 목록 조회
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectGdsCntsList(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
	/**
	 * 키워드 목록 조회
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectKeywordList(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
	/**
	 * 주문 저장
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	String insertOrderInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
	/**
	 * 주문정보 조회
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectOrderInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
	/**
	 * 홍보물 번호 유효성 확인
	 * @param value
	 * @return
	 * @throws Exception
	 */
	String selectIsValidSeqNo(String value) throws Exception;
	
	
	/**
	 * 홍보물 정보 조회 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectPrInfo(String value) throws Exception;
	
	
	/**
	 * 제품판매 갯수 조회 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectForGdsSelCnt(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
	/**
	 * 제품주문 갯수 조회 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Map<?,?> selectForGdsSale(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
	/**
	 * 제품판매갯수 업데이트 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	void updateGdsSaleCnt(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	/**
	 * 주문 상세
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	void insertOrderDetailInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	/**
	 * 주문 상세 장바구니용
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	void insertOrderDetailInfos(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	/**
	 * 카드를 통한 주문 완료페이지에 보여줄 주문제품 목록 정보
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	List<?> selectOrdInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	/**
	 * 카드를 통한 주문 완료페이지에 보여줄 사용자 주문 정보
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	
	Map<?, ?> selectUsrOrdInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	/**
	 * 결제테이블 등록
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	void insertshpPayInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	/**
	 * 주문테이블 결제완료 
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	void updateOrdPaySuccess(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	/**
	 * 주문테이블 결제완료 
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	int selectOrdCnt(McmShpOrd001VO mcmShpOrd001VO) throws Exception;
	
	
}
