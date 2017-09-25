package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd004Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd004VO;

import org.springframework.stereotype.Service;

@Service("mcmShpOrd004Service")
public class McmShpOrd004ServiceImpl implements McmShpOrd004Service {
	
	@Resource(name="mcmShpOrd004DAO")
	private McmShpOrd004DAO mcmShpOrd004DAO ;

	@Override
	public List<?> selectShpOrdList(McmShpOrd004VO mcmShpOrd004VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd004DAO.selectShpOrdList(mcmShpOrd004VO);
	}

	@Override
	public int selectShpOrdCnt(McmShpOrd004VO mcmShpOrd004VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd004DAO.selectShpOrdCnt(mcmShpOrd004VO);
	}

	@Override
	public List<?> selectShpOrdDetail(McmShpOrd004VO mcmShpOrd004VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd004DAO.selectShpOrdDetail(mcmShpOrd004VO);
	}

	@Override
	public int selectShpOrdDetailCnt(McmShpOrd004VO mcmShpOrd004VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd004DAO.selectShpOrdDetailCnt(mcmShpOrd004VO);
	}

	
	
	

}
