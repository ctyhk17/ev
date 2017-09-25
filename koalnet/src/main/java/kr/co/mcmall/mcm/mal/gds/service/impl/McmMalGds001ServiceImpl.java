package kr.co.mcmall.mcm.mal.gds.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.mal.gds.service.McmMalGds001Service;
import kr.co.mcmall.mcm.mal.gds.service.McmMalGds001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : McmMalGds001ServiceImpl.java
 * @Description : McmMalGds001ServiceImpl ServiceImpl Class
 *                McmMalGds001ServiceImpl ServiceImpl 클래스 ( 상품관리 )
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
@Service("mcmMalGds001Service")
public class McmMalGds001ServiceImpl extends EgovAbstractServiceImpl implements McmMalGds001Service{

	/** DAO 선언 */
	@Resource(name = "mcmMalGds001DAO")
	private McmMalGds001DAO mcmMalGds001DAO;

	/**
	 * 상품목록 조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001List(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001List(mcmMalGds001VO);
	}
	
	/**
	 * 상품 목록개수 조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmMalGds001TotCnt(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001TotCnt(mcmMalGds001VO);
	}
	
	/**
	 * 상품등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001Info(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001Info(mcmMalGds001VO);
	}
	
	/**
	 * 상품가격 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdPayInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001ProdPayInfo(mcmMalGds001VO);
	}
	
	/**
	 * 상품수량 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdCntInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001ProdCntInfo(mcmMalGds001VO);
	}
	
	/**
	 * 상세설명 등록1
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001ProdDetailSetInfo(
			McmMalGds001VO mcmMalGds001VO) throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001ProdDetailSetInfo(mcmMalGds001VO);
	}
	
	/**
	 * 상품키워드 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001KeySetInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001KeySetInfo(mcmMalGds001VO);
	}
	
	/**
	 * 상품키워드 목록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001KeyList(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001KeyList(mcmMalGds001VO);
	}

	public int deleteMcmMalGds001KeyInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.deleteMcmMalGds001KeyInfo(mcmMalGds001VO);
	}

	/**
	 * 상품수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updateMcmMalGds001ProdInfo(mcmMalGds001VO);
	}
	/**
	 * 상품가격수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001PayInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updateMcmMalGds001PayInfo(mcmMalGds001VO);
		
	}
	/**
	 * 상품개수수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001CntInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updateMcmMalGds001CntInfo(mcmMalGds001VO);
	}
	
	/**
	 * 상품상세설명 수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001DetailInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updateMcmMalGds001DetailInfo(mcmMalGds001VO);
	}
	
	/**
	 * 상품상세설명 정보
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001DetailListInfo(
			McmMalGds001VO mcmMalGds001VO) throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001DetailListInfo(mcmMalGds001VO);
	}
	
	/**
	 * 사업자ID조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?>selectMcmMalGds001LcsNoInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001LcsNoInfo(mcmMalGds001VO);
	}

	/**
	 * 키워드정보조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmMalGds001KeywordInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001KeywordInfo(mcmMalGds001VO);
	}
	/**
	 * 키워드수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001KeywordInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updateMcmMalGds001KeywordInfo(mcmMalGds001VO);
	}

	/**
	 * 상품사용여부
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdYnInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updateMcmMalGds001ProdYnInfo(mcmMalGds001VO);
	}

	/**
	 * 상품설정조회
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmMalGds001ProdSetInfo(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001ProdSetInfo(mcmMalGds001VO);
	}
	
	/**
	 * 이미지 다운로드
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?, ?> selectMcmMalGds001ImgInfo(Map<?, ?> param)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001ImgInfo(param);
		}

	/**
	 * 상세설명 이미지 다운로드
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?, ?> selectMcmMalGds001ImgDetailInfo(Map<?, ?> param)
			throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001ImgDetailInfo(param);
	}
	
	/**
	 * 상점등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMalGds001ProdIns(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.insertMalGds001ProdIns(mcmMalGds001VO);
	}
	
	/**
	 * 상품 올리기
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001ProdUp(McmMalGds001VO mcmMalGds001VO) throws Exception{
		mcmMalGds001DAO.updateMcmMalGds001ProdUp(mcmMalGds001VO);
	}
	
	/**
	 * 상품내리기
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updatemcmMalGds001ProdDown(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updatemcmMalGds001ProdDown(mcmMalGds001VO);
	}
	
	/**
	 * 할인판매여부
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdDcYn(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001InsertProdDcYn(mcmMalGds001VO);
	}

	/**
	 * 할인판매가
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdDcPrice(
			McmMalGds001VO mcmMalGds001VO) throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001InsertProdDcPrice(mcmMalGds001VO);
				
	}
	
	/**
	 * 일반판매가
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertProdGePrice(
			McmMalGds001VO mcmMalGds001VO) throws Exception {
		return mcmMalGds001DAO.insertMcmMalGds001InsertProdGePrice(mcmMalGds001VO);
	}
	
	/**
	 * 할인판매여부 수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdDcYn(McmMalGds001VO mcmMalGds001VO)
			throws Exception {
		mcmMalGds001DAO.updateMcmMalGds001UpdateProdDcYn(mcmMalGds001VO);;
	}
	
	/**
	 * 할인판매가 수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdDcPrice(
			McmMalGds001VO mcmMalGds001VO) throws Exception {
		
		mcmMalGds001DAO.updateMcmMalGds001UpdateProdDcPrice(mcmMalGds001VO);
	}
	
	/**
	 * 할인판매가 수정
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateProdGePrice(
			McmMalGds001VO mcmMalGds001VO) throws Exception {
		
		mcmMalGds001DAO.updateMcmMalGds001UpdateProdGePrice(mcmMalGds001VO);
	}
	
	/**
	 * 카테고리 등록
	 * @param mcmMalGds001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmMalGds001InsertCate(McmMalGds001VO mcmMalGds001VO) throws Exception{
		return mcmMalGds001DAO.insertMcmMalGds001InsertCate(mcmMalGds001VO);
	}
	
	/**
	 * 카테고리 수정
	 * @param mcmMalGds001VO
	 * @throws Exception
	 */
	public void updateMcmMalGds001UpdateCate(McmMalGds001VO mcmMalGds001VO) throws Exception{
		mcmMalGds001DAO.updateMcmMalGds001UpdateCate(mcmMalGds001VO);
	}

	public Map<?, ?> selectMcmMalGds001SelectKwdNmInfo(
			McmMalGds001VO mcmMalGds001VO) throws Exception {
		return mcmMalGds001DAO.selectMcmMalGds001SelectKwdNmInfo(mcmMalGds001VO);
	}
}