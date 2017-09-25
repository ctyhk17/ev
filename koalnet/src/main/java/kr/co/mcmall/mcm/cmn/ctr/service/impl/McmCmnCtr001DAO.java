package kr.co.mcmall.mcm.cmn.ctr.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.cmn.ctr.service.McmCmnCtr001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmCmnCtr001DAO")
public class McmCmnCtr001DAO extends EgovAbstractDAO{

	
	public List<?> selectMcmCmnCtrList(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.ctr.McmCmnCtr001.selectCtrList",mcmCmnCtr001VO);
	}
	
	public int selectMcmCmnCtrListCtn(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception{
		return (int) select("kr.co.mcmall.mcm.cmn.ctr.McmCmnCtr001.selectCtrListCnt",mcmCmnCtr001VO);
	}
	
	public Map<?,?> selectMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.cmn.ctr.McmCmnCtr001.selectCtrInfo",mcmCmnCtr001VO);
	}
	
	public String insertMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception{
		return (String) insert("kr.co.mcmall.cmn.ctr.McmCmnCtr001.insertCtrInfo",mcmCmnCtr001VO);
	}
	
	public int selectMcmCmnCtrInfoExists(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception{
		return (int) select("kr.co.mcmall.cmn.ctr.McmCmnCtr001.selectCtrInfoExists",mcmCmnCtr001VO);
	}
	
	public void updateMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception{
		update("kr.co.mcmall.cmn.ctr.McmCmnCtr001.updateCtrInfo",mcmCmnCtr001VO);
	}
	
	public void updateMcmCmnCtr(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception{
		update("kr.co.mcmall.cmn.ctr.McmCmnCtr001.updateCtr",mcmCmnCtr001VO);
	}
	
	
}
