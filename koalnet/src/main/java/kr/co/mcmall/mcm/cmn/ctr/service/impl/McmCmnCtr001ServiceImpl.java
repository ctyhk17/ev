package kr.co.mcmall.mcm.cmn.ctr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.ctr.service.McmCmnCtr001Service;
import kr.co.mcmall.mcm.cmn.ctr.service.McmCmnCtr001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("mcmCmnCtr001Service")
public class McmCmnCtr001ServiceImpl extends EgovAbstractServiceImpl implements McmCmnCtr001Service{

	@Resource(name="mcmCmnCtr001DAO")
	public McmCmnCtr001DAO mcmCmnCtr001DAO;

	public List<?> selectMcmCmnCtrList(McmCmnCtr001VO mcmCmnCtr001VO)
			throws Exception {
		return mcmCmnCtr001DAO.selectMcmCmnCtrList(mcmCmnCtr001VO);
	}

	public int selectMcmCmnCtrListCtn(McmCmnCtr001VO mcmCmnCtr001VO)
			throws Exception {
		return mcmCmnCtr001DAO.selectMcmCmnCtrListCtn(mcmCmnCtr001VO);
	}

	public Map<?, ?> selectMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO)
			throws Exception {
		return mcmCmnCtr001DAO.selectMcmCmnCtrInfo(mcmCmnCtr001VO);
	}

	public String insertMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO)
			throws Exception {
		return mcmCmnCtr001DAO.insertMcmCmnCtrInfo(mcmCmnCtr001VO);
	}

	public int selectMcmCmnCtrInfoExists(McmCmnCtr001VO mcmCmnCtr001VO)
			throws Exception {
		return mcmCmnCtr001DAO.selectMcmCmnCtrInfoExists(mcmCmnCtr001VO);
	}

	public void updateMcmCmnCtrInfo(McmCmnCtr001VO mcmCmnCtr001VO)
			throws Exception {
		mcmCmnCtr001DAO.updateMcmCmnCtrInfo(mcmCmnCtr001VO);
	}

	public void updateMcmCmnCtr(McmCmnCtr001VO mcmCmnCtr001VO) throws Exception {
		mcmCmnCtr001DAO.updateMcmCmnCtr(mcmCmnCtr001VO);
	}
}
