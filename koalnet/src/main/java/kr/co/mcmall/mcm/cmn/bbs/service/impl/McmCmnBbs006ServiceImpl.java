package kr.co.mcmall.mcm.cmn.bbs.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.mcmall.mcm.cmn.bbs.service.McmCmnBbs006Service;
import kr.co.mcmall.mcm.cmn.bbs.service.McmCmnBbs006VO;

@Service("mcmCmnBbs006Service")
public class McmCmnBbs006ServiceImpl implements McmCmnBbs006Service {
	
	@Resource(name="mcmCmnBbs006DAO")
	private McmCmnBbs006DAO mcmCmnBbs006DAO ;

	@Override
	public List<?> selectBbsList(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsList(mcmCmnBbs006VO);
	}

	@Override
	public int selectBbsCnt(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsCnt(mcmCmnBbs006VO);
	}

	@Override
	public Map<?, ?> selectBbsRetrive(McmCmnBbs006VO mcmCmnBbs006VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsRetrive(mcmCmnBbs006VO);
	}

	@Override
	public int selectBbsGrpId(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsGrpId(mcmCmnBbs006VO);
	}

	@Override
	public Object insertBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return (String) mcmCmnBbs006DAO.insertBbsData(mcmCmnBbs006VO);
	}

	@Override
	public Object updateBbsReCheck(McmCmnBbs006VO mcmCmnBbs006VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.updateBbsReCheck(mcmCmnBbs006VO);
	}

	@Override
	public Object updateBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.updateBbsData(mcmCmnBbs006VO);
	}

	@Override
	public Object deleteBbsData(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.deleteBbsData(mcmCmnBbs006VO);
	}
	
	@Override
	public List<?> selectBbsFaqList(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsFaqList(mcmCmnBbs006VO);
	}
	
	@Override
	public int selectBbsFaqCnt(McmCmnBbs006VO mcmCmnBbs006VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsFaqCnt(mcmCmnBbs006VO);
	}

	@Override
	public Map<?, ?> selectBbsRetriveFaqCntsQ(McmCmnBbs006VO mcmCmnBbs006VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsRetriveFaqCntsQ(mcmCmnBbs006VO);
	}

	@Override
	public List<?> selectBbsMain(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnBbs006DAO.selectBbsMain(param);
	}

}
