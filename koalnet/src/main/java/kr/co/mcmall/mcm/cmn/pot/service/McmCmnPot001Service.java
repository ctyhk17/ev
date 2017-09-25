package kr.co.mcmall.mcm.cmn.pot.service;

import java.util.List;

public interface McmCmnPot001Service  {
	
	public List<?> selectMcmCmnPotList(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	public int selectMcmCmnPotCnt(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	public List<?> selectMcmCmnPotRetrieve(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	public int selectMcmCmnPotRetrieveCnt(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	public int selectMcmCmnPotRetrievePointSum(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	public Object deleteMcmCmnPot(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	public int selectMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO) throws Exception; 
	
	public Object updateMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	
	public Object insertMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	
	public Object insertMcmCmnPotSv(McmCmnPot001VO mcmCmnPot001VO) throws Exception;
	

}
