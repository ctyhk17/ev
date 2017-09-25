package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd002VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmShpOrd002DAO")
public class McmShpOrd002DAO extends EgovAbstractDAO {

	public List<?> selectShpOrdList(McmShpOrd002VO mcmShpOrd002VO) throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd002.selectShpOrdList", mcmShpOrd002VO);
	}
	
	public int selectShpOrdCnt(McmShpOrd002VO mcmShpOrd002VO) throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd002.selectShpOrdCnt" , mcmShpOrd002VO);
	}
	
	public List<?> selectShpOrdDetail(McmShpOrd002VO mcmShpOrd002VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd002.selectShpOrdDetail", mcmShpOrd002VO);
	}

	public int selectShpOrdDetailCnt(McmShpOrd002VO mcmShpOrd002VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd002.selectShpOrdDetailCnt", mcmShpOrd002VO);
	}

}
