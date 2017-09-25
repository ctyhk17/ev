package kr.co.mcmall.mcm.cmn.kwd.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.mcmall.mcm.cmn.kwd.service.McmCmnKwd001Service;
import kr.co.mcmall.mcm.cmn.kwd.service.McmCmnKwd001VO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("mcmCmnKwd001Service")
public class McmCmnKwd001ServiceImpl extends EgovAbstractServiceImpl implements McmCmnKwd001Service{

	@Resource(name="mcmCmnKwd001DAO")
	public McmCmnKwd001DAO mcmCmnKwd001DAO;

	public List<?> selectMcmCmnKwd001KwdList(McmCmnKwd001VO mcmCmnKwd001VO)
			throws Exception {
		return mcmCmnKwd001DAO.selectMcmCmnKwd001KwdList(mcmCmnKwd001VO);
	}

	public int selectMcmCmnKwd001KwdCnt(McmCmnKwd001VO mcmCmnKwd001VO)
			throws Exception {
		return mcmCmnKwd001DAO.selectMcmCmnKwd001KwdCnt(mcmCmnKwd001VO);
	}

	public Map<?, ?> selectMcmCmnKwd001KwdInfo(McmCmnKwd001VO mcmCmnKwd001VO)
			throws Exception {
		return mcmCmnKwd001DAO.selectMcmCmnKwd001KwdInfo(mcmCmnKwd001VO);
	}

	public void updateMcmCmnKwd001KwdUpdate(McmCmnKwd001VO mcmCmnKwd001VO)
			throws Exception {
		mcmCmnKwd001DAO.updateMcmCmnKwd001KwdUpdate(mcmCmnKwd001VO);
	}

	public int deleteMcmCmnKwd001KwdDelete(McmCmnKwd001VO mcmCmnKwd001VO)
			throws Exception {
		return mcmCmnKwd001DAO.deleteMcmCmnKwd001KwdDelete(mcmCmnKwd001VO);
	}
}
