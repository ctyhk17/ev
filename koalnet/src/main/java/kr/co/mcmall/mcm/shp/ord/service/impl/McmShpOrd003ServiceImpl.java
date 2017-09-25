package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd003Service;
import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd003VO;

import org.springframework.stereotype.Service;

@Service("mcmShpOrd003Service")
public class McmShpOrd003ServiceImpl implements McmShpOrd003Service {
	
	@Resource(name="mcmShpOrd003DAO")
	private McmShpOrd003DAO mcmShpOrd003DAO ;

	@Override
	public List<?> selectShpOrdWishList(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd003DAO.selectShpOrdWishList(mcmShpOrd003VO);
	}

	@Override
	public int selectShpOrdWishCnt(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd003DAO.selectShpOrdWishCnt(mcmShpOrd003VO);
	}
	@Override
	public void insertShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		mcmShpOrd003DAO.insertShpOrdWishGoods(mcmShpOrd003VO);
		
	}

	@Override
	public Map<?, ?> selectShpOrdWishTot(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd003DAO.selectShpOrdWishTot(mcmShpOrd003VO);
	}

	@Override
	public Map<?, ?> selectShpOrdWishExists(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmShpOrd003DAO.selectShpOrdWishExists(mcmShpOrd003VO);
	}

	@Override
	public void updateShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		mcmShpOrd003DAO.updateShpOrdWishGoods(mcmShpOrd003VO);
	}

	@Override
	public void deleteShpOrdWishGoods(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		mcmShpOrd003DAO.deleteShpOrdWishGoods(mcmShpOrd003VO);
	}
	
	@Override
	public void updateShpOrdCplt(McmShpOrd003VO mcmShpOrd003VO)
			throws Exception {
		// TODO Auto-generated method stub
		mcmShpOrd003DAO.updateShpOrdCplt(mcmShpOrd003VO);
	}


	

	
	
	

}
