package kr.co.mcmall.mcm.shp.ord.service;

import java.util.List;
import java.util.Map;

public interface McmShpOrd002Service {
	
	
	public List<?> selectShpOrdList(McmShpOrd002VO mcmShpOrd002VO) throws Exception;
	
	public int selectShpOrdCnt(McmShpOrd002VO mcmShpOrd002VO) throws Exception;
	
	public List<?> selectShpOrdDetail(McmShpOrd002VO mcmShpOrd002VO) throws Exception;
	
	public int selectShpOrdDetailCnt(McmShpOrd002VO mcmShpOrd002VO) throws Exception;
	
	
	
	

}
