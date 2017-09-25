package kr.co.mcmall.mcm.cmn.pot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001Service;
import kr.co.mcmall.mcm.cmn.pot.service.McmCmnPot001VO;

import org.springframework.stereotype.Service;


@Service("mcmCmnPot001Service")
public class McmCmnPot001ServiceImpl implements McmCmnPot001Service {

	@Resource(name="mcmCmnPot001DAO")
	private McmCmnPot001DAO mcmCmnPot001DAO;

	@Override
	public List<?> selectMcmCmnPotList(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.selectMcmCmnPotList(mcmCmnPot001VO);
	}

	@Override
	public int selectMcmCmnPotCnt(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.selectMcmCmnPotCnt(mcmCmnPot001VO);
	}

	@Override
	public List<?> selectMcmCmnPotRetrieve(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.selectMcmCmnPotRetrieve(mcmCmnPot001VO);
	}

	@Override
	public int selectMcmCmnPotRetrieveCnt(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.selectMcmCmnPotRetrieveCnt(mcmCmnPot001VO);
	}

	@Override
	public int selectMcmCmnPotRetrievePointSum(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.selectMcmCmnPotRetrievePointSum(mcmCmnPot001VO);
	}

	@Override
	public Object deleteMcmCmnPot(McmCmnPot001VO mcmCmnPot001VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.deleteMcmCmnPot(mcmCmnPot001VO);
	}

	@Override
	public int selectMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.selectMcmCmnCurPot(mcmCmnPot001VO);
	}

	@Override
	public Object updateMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		insertMcmCmnCurPot(mcmCmnPot001VO);
		int totPot = selectMcmCmnCurPot(mcmCmnPot001VO);
		System.out.println("totPot=================>"+totPot);
		mcmCmnPot001VO.setPotTotSum(totPot);
		
		return mcmCmnPot001DAO.updateMcmCmnCurPot(mcmCmnPot001VO);
	}
	
	@Override
	public Object insertMcmCmnPotSv(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnPot001DAO.insertMcmCmnPotSv(mcmCmnPot001VO);
	}

	@Override
	public Object insertMcmCmnCurPot(McmCmnPot001VO mcmCmnPot001VO)
			throws Exception {
		// TODO Auto-generated method stub
		
		return mcmCmnPot001DAO.insertMcmCmnCurPot(mcmCmnPot001VO);
	}


	
	
	
}
