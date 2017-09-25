package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd003VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmShpOrd003DAO")
public class McmShpOrd003DAO extends EgovAbstractDAO {

	public List<?> selectShpOrdWishList(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.selectShpOrdWishList", mcmShpOrd003VO);
	}
	
	public Map<?, ?> selectShpOrdWishTot(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>)select("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.selectShpOrdWishTot",mcmShpOrd003VO);
	}

	public int selectShpOrdWishCnt(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return(int) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.selectShpOrdWishCnt", mcmShpOrd003VO);
	}
	
	public void insertShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		
		insert("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.insertShpOrdWishGoods",mcmShpOrd003VO);
		
	}
	
	public Map<?, ?> selectShpOrdWishExists(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.selectShpOrdWishExists",mcmShpOrd003VO);
	}
	
	public void updateShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		update("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.updateShpOrdWishGoods",mcmShpOrd003VO);
	}
	
	public void deleteShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		update("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.deleteShpOrdWishGoods",mcmShpOrd003VO);
	}
	
	public void updateShpOrdCplt(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		update("kr.co.mcmall.mcm.shp.ord.McmShpOrd003.updateShpOrdCplt",mcmShpOrd003VO);
	}

}
