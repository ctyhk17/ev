package kr.co.mcmall.mcm.mal.gds.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.mal.gds.service.McmMalGds001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

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

@Repository("mcmMalGds001DAO")
public class McmMalGds001DAO extends EgovAbstractDAO  {

	/**
	 * @param mcmMalGds001VO
	 * @return 상품목록조회
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001List(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.gds.McmMallGds001.selectGdsList",mcmMalGds001VO);
	}
	
	/**
	 * 상품목록 갯수조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmMalGds001TotCnt(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (int) select("kr.co.mcmall.mcm.mal.gds.McmMallGds001.selectGdsPaging",mcmMalGds001VO);
	}
	
	/**
	 * 상품등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001Info(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertProd",mcmMalGds001VO);
	}
	
	/**
	 * 상품가격 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdPayInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertProdPaySet",mcmMalGds001VO);
	}

	/**
	 * 상품수량 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdCntInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertProdCntSet",mcmMalGds001VO);
	}
	
	/**
	 * 상품상세설명 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdDetailSetInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertProdDetailSet",mcmMalGds001VO);
	}
	
	/**
	 * 상품키워드 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001KeySetInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertKeywordSet",mcmMalGds001VO);
	}
	
	/**
	 * 상품키워드 목록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001KeyList(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.gds.McmMallGds001.selectKeywordList",mcmMalGds001VO);
	}
	
	/**
	 * 상품키워드 삭제
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public int deleteMcmMalGds001KeyInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return delete("kr.co.mcmall.mcm.mal.gds.McmMallGds001.deleteKeyword",mcmMalGds001VO);
	}
	
	/**
	 * 상품수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updateProd",mcmMalGds001VO);
	}
	
	/**
	 * 상품가격수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001PayInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updatePay",mcmMalGds001VO);
	}
	
	/**
	 * 상품개수수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001CntInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updateCnt",mcmMalGds001VO);
	}
	
	/**
	 * 상품 상세설명 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001DetailInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updateDetail",mcmMalGds001VO);
	}
	
	/**
	 * 상세설명 정보
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001DetailListInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.gds.McmMallGds001.selectDetail",mcmMalGds001VO);
	}
	
	/**
	 * 사업자Id 조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001LcsNoInfo (McmMalGds001VO mcmMalGds001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.gds.McmMallGds001.selectLcsId",mcmMalGds001VO);
	}
	
	/**
	 * 키워드 정보 조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001KeywordInfo (McmMalGds001VO mcmMalGds001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.selectKeywordInfo",mcmMalGds001VO);
	}
	
	/**
	 * 키워드 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001KeywordInfo (McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.updateKeyword",mcmMalGds001VO);
	}
	
	/**
	 * 상품사용여부
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdYnInfo (McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.updateProdYnInfo",mcmMalGds001VO);
	}
	
	/**
	 * 상품설정조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmMalGds001ProdSetInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.selectProdSetInfo",mcmMalGds001VO);
	}
	
	/**
	 * 이미지 다운로드
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmMalGds001ImgInfo(Map<?,?> param) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.selectImgInfo",param);
	}
	
	/**
	 * 상세설명 이미지 다운로드
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmMalGds001ImgDetailInfo(Map<?,?> param) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.selectImgDetailInfo",param);
	}
	
	/**
	 * 상점 등록
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	
	public String insertMalGds001ProdIns(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.insertMalGds001Prod",mcmMalGds001VO);
	}
	
	
	/**
	 * 상품 올리기
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdUp(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.updateProdUp",mcmMalGds001VO);
	}
	
	/**
	 * 상품내리기
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updatemcmMalGds001ProdDown(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gdsMcmMallGds001.updateProdDown",mcmMalGds001VO);
	}
	
	
	/**
	 * 할인판매여부
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdDcYn(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertProdDcYn",mcmMalGds001VO);
	}
	
	/**
	 * 할인판매가
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdDcPrice(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertProdDcPrice",mcmMalGds001VO);
	}
	
	/**
	 * 할인판매가
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdGePrice(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertProdGePrice",mcmMalGds001VO);
	}
	
	/**
	 * 할인판매여부수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdDcYn(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updateProdDcYn",mcmMalGds001VO);
	}
	
	/**
	 * 할인판매여부수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdDcPrice(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updateProdDcPrice",mcmMalGds001VO);
	}
	
	/**
	 * 일반판매가 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdGePrice(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updateProdGePrice",mcmMalGds001VO);
	}
	
	/**
	 * 카테고리 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertCate(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.gds.McmMallGds001.insertCate",mcmMalGds001VO);
	}
	
	/**
	 * 카테고리 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateCate(McmMalGds001VO mcmMalGds001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.gds.McmMallGds001.updateCate",mcmMalGds001VO);
	}
	
	public Map<?,?> selectMcmMalGds001SelectKwdNmInfo(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.mal.gds.McmMallGds001.selectKwdNmInfo",mcmMalGds001VO);
	}
}