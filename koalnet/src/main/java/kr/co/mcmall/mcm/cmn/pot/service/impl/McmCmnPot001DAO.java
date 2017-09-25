package kr.co.mcmall.mcm.cmn.pot.service.impl;

import java.util.List;

import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("mcmCmnPot001DAO")
public class McmCmnPot001DAO extends EgovAbstractDAO {
	
	public List<?> selectMcmCmnPotList(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		return list("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.selectMcmCmnPotList",mcmCmnPot001VO);
	}

	public int selectMcmCmnPotCnt(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		return (int) select("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.selectMcmCmnPotCnt",mcmCmnPot001VO);
	}
	
	public List<?> selectMcmCmnPotRetrieve(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.selectMcmCmnPotRetrieve",mcmCmnPot001VO);
	}

	public int selectMcmCmnPotRetrieveCnt(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.selectMcmCmnPotRetrieveCnt",mcmCmnPot001VO);
	}
	
	public int selectMcmCmnPotRetrievePointSum(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.selectMcmCmnPotRetrievePointSum",mcmCmnPot001VO);
	}
	
	public Object deleteMcmCmnPot(McmCmnPot001VO mcmCmnPot001VO) throws Exception {
		// TODO Auto-generated method stub
		return update("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.deleteMcmCmnPot",mcmCmnPot001VO);
	}
	
	public int selectMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.selectMcmCmnCurPot",mcmCmnPot001VO);
	}

	public Object updateMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return update("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.updateMcmCmnCurPot",mcmCmnPot001VO);
	}
	
	public Object insertMcmCmnPotSv(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return insert("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.insertMcmCmnPotSv",mcmCmnPot001VO);
	}
	
	public Object insertMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return insert("kr.co.mcmall.mcm.cmn.pot.McmCmnPot001.insertMcmCmnCurPot",mcmCmnPot001VO);
	}
	

}
