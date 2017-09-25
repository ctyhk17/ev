package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : McmShpOrd001DAO.java
 * @Description : McmShpOrd001DAO DAO Class
 *                주문 DAO 클래스
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

@Repository("mcmShpOrd001DAO")
public class McmShpOrd001DAO extends EgovAbstractDAO {

	
	/**
	 * 상품 주문현황 조회
	 * @param mcmShpOrd001VO - 조회할 정보가 담긴 mcmShpOrd001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectGdsInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return (Map<?, ?>)select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectGdsInfo", mcmShpOrd001VO);
	}
	
	/**
	 * 상품설명 목록 조회
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectGdsCntsList(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectGdsCntsList", mcmShpOrd001VO);
	}
	
	/**
	 * 키워드 목록 조회
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectKeywordList(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectKeywordList", mcmShpOrd001VO);
	}
	
	
	/**
	 * 주문내역 저장
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	public String insertOrderInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		
		// 주문내역 인서트
		String ordNo = (String)insert("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.insertOrderInfo", mcmShpOrd001VO);
		
/*		// 주문별 상품 내역 인서트
		mcmShpOrd001VO.setOrdNo(ordNo);
		insert("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.insertOrderDetailInfo", mcmShpOrd001VO);
		
		// 총주문금액 업데이트
		update("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.updatTOrderTotAmt", mcmShpOrd001VO);*/
		
		return ordNo; 
	}
	
	public void insertOrderDetailInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
	
		insert("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.insertOrderDetailInfo", mcmShpOrd001VO);
	}
	
	public void insertOrderDetailInfos(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		
		insert("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.insertOrderDetailInfos", mcmShpOrd001VO);
	}
	
	
	/**
	 * 주문정보 조회
	 * @param mcmShpOrd001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectOrderInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return (Map<?, ?>)select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectOrderInfo", mcmShpOrd001VO);
	}
	
	
	/**
	 * 홍보물 번호 유효성 확인
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String selectIsValidSeqNo(String value) throws Exception{
		return (String)select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectIsValidSeqNo", value);
	}
	
	
	
	
	public Map<?,?> selectPrInfo(String value) throws Exception{
		return (Map<?, ?>)select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectPrInfo", value);
	}
	
	
	public Map<?, ?> selectForGdsSelCnt(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>)select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectForGdsSelCnt", mcmShpOrd001VO);
	}

	public Map<?, ?> selectForGdsSale(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>)select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectForGdsSale", mcmShpOrd001VO);
	}

	public void updateGdsSaleCnt(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		update("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.updateGdsSaleCnt", mcmShpOrd001VO);
	}
	
	public List<?> selectOrdInfo(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectOrdInfo", mcmShpOrd001VO);
	}

	public Map<?, ?> selectUsrOrdInfo(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectUsrOrdInfo", mcmShpOrd001VO);
	}
	
	public void insertshpPayInfo(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		insert("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.insertshpPayInfo",mcmShpOrd001VO);
	}
	
	public void updateOrdPaySuccess(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		update("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.updateOrdPaySuccess",mcmShpOrd001VO);
		
	}
	
	public int selectOrdCnt(McmShpOrd001VO mcmShpOrd001VO) throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd001.selectOrdCnt",mcmShpOrd001VO);
	}

}
