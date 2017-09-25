package kr.co.mcmall.mcm.mal.gds.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : McmMalGds001DAO.java
 * @Description : McmMalGds001DAO DAO Class
 *                McmMalGds001DAO DAO 클래스 ( 상품관리 )
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017-06-20           최초생성
 *
 * @author 개발팀
 * @since 2017-06-20
 * @version 1.0
 * @see
 *  
 */

/**
 * @author Administrator
 *
 */
public interface McmMalGds001Service {

	/**
	 * @param mcmMalGds001VO
	 * @return 상품목록조회
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001List(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * @param mcmMalGds001VO
	 * @return 상품목록 갯수조회
	 * @throws Exception
	 */
	public int selectMcmMalGds001TotCnt(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001Info(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품가격 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdPayInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품수량 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdCntInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상세설명 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdDetailSetInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품키워드 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001KeySetInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품키워드 목록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001KeyList(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품키워드 삭제
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public int deleteMcmMalGds001KeyInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;

	/**
	 * 상품수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품가격수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001PayInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품개수수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001CntInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품상세설명수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001DetailInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상세설명 내용
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001DetailListInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 사업자ID조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001LcsNoInfo (McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 키워드정보 조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001KeywordInfo (McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 키워드 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001KeywordInfo (McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품사용여부
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdYnInfo (McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품설정 조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmMalGds001ProdSetInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 이미지 다운로드
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmMalGds001ImgInfo(Map<?,?> param) throws Exception;
	
	/**
	 * 상세설명 이미지 다운로드
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmMalGds001ImgDetailInfo(Map<?,?> param) throws Exception;
	
	/**
	 * 상점등록
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public String insertMalGds001ProdIns(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품 올리기
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdUp(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 상품내리기
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updatemcmMalGds001ProdDown(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 할인판매여부
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdDcYn(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 할인판매가
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdDcPrice(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 일반판매가 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdGePrice(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 할인판매여부 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdDcYn(McmMalGds001VO mcmMalGds001VO) throws Exception;

	/**
	 * 할인판매가 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdDcPrice(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 일반판매가 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdGePrice(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 카테고리 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertCate(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	/**
	 * 카테고리 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateCate(McmMalGds001VO mcmMalGds001VO) throws Exception;
	
	public Map<?,?> selectMcmMalGds001SelectKwdNmInfo(McmMalGds001VO mcmMalGds001VO) throws Exception;
}