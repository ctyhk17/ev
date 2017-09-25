package kr.co.mcmall.mcm.cmn.ctr.service;

import java.util.List;
import java.util.Map;

public interface McmCmnCtr001Service {

	public List<?> selectMcmCmnCtrList(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception;
	public int selectMcmCmnCtrListCtn(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception;
	public Map<?,?> selectMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception;
	public String insertMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception;
	public int selectMcmCmnCtrInfoExists(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception;
	public void updateMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception;
	public void updateMcmCmnCtr(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception;
}
