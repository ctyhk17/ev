package kr.co.mcmall.mcm.cmn.kwd.service;

import java.util.List;
import java.util.Map;

public interface McmCmnKwd001Service {

	public List<?> selectMcmCmnKwd001KwdList(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception;
	public int selectMcmCmnKwd001KwdCnt(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception;
	public Map<?,?> selectMcmCmnKwd001KwdInfo(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception;
	public void updateMcmCmnKwd001KwdUpdate(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception;
	public int deleteMcmCmnKwd001KwdDelete(McmCmnKwd001VO mcmCmnKwd001VO) throws  Exception;
}
