package kr.co.mcmall.mcm.shp.ord.service.impl;

import java.util.List;

import kr.co.mcmall.mcm.shp.ord.service.McmShpOrd004VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmShpOrd004DAO")
public class McmShpOrd004DAO extends EgovAbstractDAO {

	public List<?> selectShpOrdList(McmShpOrd004VO mcmShpOrd004VO) throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd004.selectShpOrdList", mcmShpOrd004VO);
	}
	
	public int selectShpOrdCnt(McmShpOrd004VO mcmShpOrd004VO) throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd004.selectShpOrdCnt" , mcmShpOrd004VO);
	}
	
	public List<?> selectShpOrdDetail(McmShpOrd004VO mcmShpOrd004VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.shp.ord.McmShpOrd004.selectShpOrdDetail", mcmShpOrd004VO);
	}

	public int selectShpOrdDetailCnt(McmShpOrd004VO mcmShpOrd004VO)
			throws Exception {
		// TODO Auto-generated method stub
		return (int) select("kr.co.mcmall.mcm.shp.ord.McmShpOrd004.selectShpOrdDetailCnt", mcmShpOrd004VO);
	}

}
