package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd001Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : McmShpOrd001ServiceImpl.java
 * @Description : McmShpOrd001ServiceImpl Service Implements Class
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

@Service("mcmShpOrd001Service")
public class McmShpOrd001ServiceImpl extends EgovAbstractServiceImpl implements McmShpOrd001Service {

	/** DAO 선언 */
	@Resource(name = "mcmShpOrd001DAO")
	private McmShpOrd001DAO mcmShpOrd001DAO;


	
	/**
	 * 상품 주문현황 조회
	 * @param mcmShpOrd001VO - 조회할 정보가 담긴 mcmShpOrd001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectGdsInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return mcmShpOrd001DAO.selectGdsInfo(mcmShpOrd001VO);
	}
	
	/**
	 * 상품 설명 목록 조회
	 */
	public List<?> selectGdsCntsList(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return mcmShpOrd001DAO.selectGdsCntsList(mcmShpOrd001VO);
	}
	
	
	/**
	 * 키워드 목록 조회
	 */
	public List<?> selectKeywordList(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return mcmShpOrd001DAO.selectKeywordList(mcmShpOrd001VO);
	}
	
	/**
	 * 주문 저장
	 */
	public String insertOrderInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return mcmShpOrd001DAO.insertOrderInfo(mcmShpOrd001VO);
	}
	
	/**
	 * 주문 상세
	 */
	public void insertOrderDetailInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		mcmShpOrd001DAO.insertOrderDetailInfo(mcmShpOrd001VO);
	}
	
	/**
	 * 주문 상세 장바구니용
	 */
	public void insertOrderDetailInfos(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		mcmShpOrd001DAO.insertOrderDetailInfos(mcmShpOrd001VO);
	}
	
	/**
	 * 주문정보 조회
	 */
	public Map<?,?> selectOrderInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
		return mcmShpOrd001DAO.selectOrderInfo(mcmShpOrd001VO);
	}
	
	
	/**
	 * 홍보물 번호 유효성 확인
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String selectIsValidSeqNo(String value) throws Exception{
		return mcmShpOrd001DAO.selectIsValidSeqNo(value);
	}
	
	
	public Map<?,?> selectPrInfo(String value) throws Exception{
		return mcmShpOrd001DAO.selectPrInfo(value);
	}

	@Override
	public Map<?, ?> selectForGdsSelCnt(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd001DAO.selectForGdsSelCnt(mcmShpOrd001VO);
	}

	@Override
	public Map<?, ?> selectForGdsSale(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd001DAO.selectForGdsSale(mcmShpOrd001VO);
	}

	@Override
	public void updateGdsSaleCnt(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		mcmShpOrd001DAO.updateGdsSaleCnt(mcmShpOrd001VO);
	}
//	
//	public Map<?, ?> selectDdFndOrd001R00(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
//		return ddFndOrd001DAO.selectDdFndOrd001R00(mcmShpOrd001VO);
//	}

	@Override
	public List<?> selectOrdInfo(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd001DAO.selectOrdInfo(mcmShpOrd001VO);
	}

	@Override
	public Map<?, ?> selectUsrOrdInfo(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd001DAO.selectUsrOrdInfo(mcmShpOrd001VO);
	}

	@Override
	public void insertshpPayInfo(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		mcmShpOrd001DAO.insertshpPayInfo(mcmShpOrd001VO);
		
	}
	
	@Override
	public void updateOrdPaySuccess(McmShpOrd001VO mcmShpOrd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		mcmShpOrd001DAO.updateOrdPaySuccess(mcmShpOrd001VO);
		
	}

	@Override
	public int selectOrdCnt(McmShpOrd001VO mcmShpOrd001VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd001DAO.selectOrdCnt(mcmShpOrd001VO);
	}




//	public Map<?, ?> selectDdFndOrd001R00(McmShpOrd001VO mcmShpOrd001VO)
//			throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

//	
//	/**
//	 * 예매티켈 구입하기(STEP11) 
//	 * @param mcmShpOrd001VO - 조회할 정보가 담긴 mcmShpOrd001VO
//	 * @return  상세정보
//	 * @exception Exception
//	 */
//	public Map<?, ?> selectDdFndOrd001R11(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
//		return ddFndOrd001DAO.selectDdFndOrd001R11(mcmShpOrd001VO);
//	}
//	
//	
//	
//	public String insertDdFndOrd001R121Proc(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
//		return ddFndOrd001DAO.insertDdFndOrd001R121Proc(mcmShpOrd001VO);
//	}
//	
//	
//	public String insertDdFndOrd001R22Proc(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
//		return ddFndOrd001DAO.insertDdFndOrd001R22Proc(mcmShpOrd001VO);
//	}
//	
//	public String selectIsValidLcsNo(String lcsNo) throws Exception{
//		return ddFndOrd001DAO.selectIsValidLcsNo(lcsNo);
//	}
//	
//	
//	public Map<?,?> selectOrdInfo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
//		return ddFndOrd001DAO.selectOrdInfo(mcmShpOrd001VO);
//	}
//	
//	public String selectGvaNo(McmShpOrd001VO mcmShpOrd001VO) throws Exception{
//		return ddFndOrd001DAO.selectGvaNo(mcmShpOrd001VO);
//	}
//	
//	public int updatePayInfo(Map paramMap) throws Exception{
//		return ddFndOrd001DAO.updatePayInfo(paramMap);
//	}
//	
//	public String insertAccRcvInfoProc(Map paramMap) throws Exception{
//		return ddFndOrd001DAO.insertAccRcvInfoProc(paramMap);
//	}
	

}

