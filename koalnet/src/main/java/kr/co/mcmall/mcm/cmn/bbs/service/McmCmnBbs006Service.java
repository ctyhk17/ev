package kr.co.mcmall.mcm.cmn.bbs.service;

import java.util.List;
import java.util.Map;

public interface McmCmnBbs006Service {
	
	
	public List<?> selectBbsList(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	public int selectBbsCnt(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;

	public Map<?, ?> selectBbsRetrive(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	public int selectBbsGrpId(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	public Object insertBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	public Object updateBbsReCheck(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	
	public Object updateBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	
	public Object deleteBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	
	public List<?> selectBbsFaqList(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	public int selectBbsFaqCnt(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	public Map<?, ?> selectBbsRetriveFaqCntsQ(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception;
	
	public List<?> selectBbsMain(Map<String, Object> param) throws Exception;

}
