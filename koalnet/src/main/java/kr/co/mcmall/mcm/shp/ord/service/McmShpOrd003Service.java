package kr.co.mcmall.mcm.shp.ord.service;

import java.util.List;
import java.util.Map;

public interface McmShpOrd003Service {
	
	public List<?> selectShpOrdWishList(McmShpOrd003VO mcmShpOrd003VO) throws Exception;
	
	public Map<?, ?> selectShpOrdWishTot(McmShpOrd003VO mcmShpOrd003VO) throws Exception;
	
	public int selectShpOrdWishCnt(McmShpOrd003VO mcmShpOrd003VO) throws Exception;
	
	public void insertShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO) throws Exception;
	
	public Map<?, ?> selectShpOrdWishExists(McmShpOrd003VO mcmShpOrd003VO) throws Exception;
	
	public void updateShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO) throws Exception;
	
	public void deleteShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO) throws Exception;
	
	public void updateShpOrdCplt(McmShpOrd003VO mcmShpOrd003VO) throws Exception;

}
