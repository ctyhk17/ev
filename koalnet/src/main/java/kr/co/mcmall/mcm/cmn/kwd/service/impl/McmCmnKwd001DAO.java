package kr.co.mcmall.mcm.cmn.kwd.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.cmn.kwd.service.McmCmnKwd001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmCmnKwd001DAO")
public class McmCmnKwd001DAO extends EgovAbstractDAO{

	public List<?> selectMcmCmnKwd001KwdList(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception{
		return list("kr.co.mcmall.mcm.cmn.kwd.McmCmnKwd001.selectKwdList",mcmCmnKwd001VO);
	}
	
	public int selectMcmCmnKwd001KwdCnt(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception{
		return (int) select("kr.co.mcmall.mcm.cmn.kwd.McmCmnKwd001.selectKwdCnt",mcmCmnKwd001VO);
	}
	
	public Map<?,?> selectMcmCmnKwd001KwdInfo(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.cmn.kwd.McmCmnKwd001.selectKwdInfo",mcmCmnKwd001VO);
	}
	
	public void updateMcmCmnKwd001KwdUpdate(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception{
		update("kr.co.mcmall.mcm.cmn.kwd.McmCmnKwd001.updateKwdInfo",mcmCmnKwd001VO);
	}
	
	public int deleteMcmCmnKwd001KwdDelete(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception{
		return delete("kr.co.mcmall.mcm.cmn.kwd.McmCmnKwd001.deleteKwdInfo",mcmCmnKwd001VO);
	}
	
}
