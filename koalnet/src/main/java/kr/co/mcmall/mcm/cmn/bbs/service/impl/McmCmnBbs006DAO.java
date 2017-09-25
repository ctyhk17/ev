package kr.co.mcmall.mcm.cmn.bbs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.bbs.service.McmCmnBbs006VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmCmnBbs006DAO")
public class McmCmnBbs006DAO extends EgovAbstractDAO {

	public List<?> selectBbsList(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsList",mcmCmnBbs006VO);
	}

	public int selectBbsCnt(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsCnt", mcmCmnBbs006VO);
	}
	
	public Map<?, ?> selectBbsRetrive(McmCmnBbs006VO mcmCmnBbs006VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<? , ?>) select("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsRetrive", mcmCmnBbs006VO);
	}
	
	public int selectBbsGrpId(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsGrpId", mcmCmnBbs006VO);
	}
	
	public Object insertBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return insert("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.insertBbsData", mcmCmnBbs006VO);
	}
	
	public Object updateBbsReCheck(McmCmnBbs006VO mcmCmnBbs006VO)
			throws Exception {
		// TODO Auto-generated method stub
		return update("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.updateBbsReCheck", mcmCmnBbs006VO);
	}
	
	public Object updateBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return update("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.updateBbsData", mcmCmnBbs006VO);
	}

	public Object deleteBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return update("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.deleteBbsData", mcmCmnBbs006VO);
	}
	
	public List<?> selectBbsFaqList(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsFaqList",mcmCmnBbs006VO);
	}
	
	public int selectBbsFaqCnt(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsFaqCnt", mcmCmnBbs006VO);
	}
	
	public Map<?, ?> selectBbsRetriveFaqCntsQ(McmCmnBbs006VO mcmCmnBbs006VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<? , ?>) select("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsRetriveFaqCntsQ", mcmCmnBbs006VO);
	}
	public List<?> selectBbsMain(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.cmn.bbs.McmCmnBbs006.selectBbsMain",param);
	}
	

}
