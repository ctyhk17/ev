package kr.co.mcmall.mcm.shp.ord.service;

import java.util.List;
import java.util.Map;

public interface McmShpOrd004Service {
	
	
	public List<?> selectShpOrdList(McmShpOrd004VO mcmShpOrd004VO) throws Exception;
	
	public int selectShpOrdCnt(McmShpOrd004VO mcmShpOrd004VO) throws Exception;
	
	public List<?> selectShpOrdDetail(McmShpOrd004VO mcmShpOrd004VO) throws Exception;
	
	public int selectShpOrdDetailCnt(McmShpOrd004VO mcmShpOrd004VO) throws Exception;
	
	
	
	

}
