package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd002Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd002VO;

import org.springframework.stereotype.Service;

@Service("mcmShpOrd002Service")
public class McmShpOrd002ServiceImpl implements McmShpOrd002Service {
	
	@Resource(name="mcmShpOrd002DAO")
	private McmShpOrd002DAO mcmShpOrd002DAO ;

	@Override
	public List<?> selectShpOrdList(McmShpOrd002VO mcmShpOrd002VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd002DAO.selectShpOrdList(mcmShpOrd002VO);
	}

	@Override
	public int selectShpOrdCnt(McmShpOrd002VO mcmShpOrd002VO) throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd002DAO.selectShpOrdCnt(mcmShpOrd002VO);
	}

	@Override
	public List<?> selectShpOrdDetail(McmShpOrd002VO mcmShpOrd002VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd002DAO.selectShpOrdDetail(mcmShpOrd002VO);
	}

	@Override
	public int selectShpOrdDetailCnt(McmShpOrd002VO mcmShpOrd002VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd002DAO.selectShpOrdDetailCnt(mcmShpOrd002VO);
	}

	
	
	

}
