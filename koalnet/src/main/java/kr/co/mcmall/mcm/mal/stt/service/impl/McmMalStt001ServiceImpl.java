package kr.co.mcmall.mcm.mal.stt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.mal.stt.service.McmMalStt001Service;
import kr.co.mcmall.mcm.mal.stt.service.McmMalStt001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("mcmMalStt001Service")
public class McmMalStt001ServiceImpl extends EgovAbstractServiceImpl implements McmMalStt001Service  {

	
	/** DAO 선언 */
	@Resource(name = "mcmMalStt001DAO")
	private McmMalStt001DAO mcmMalStt001DAO;

	// 상품별 매출현황 리스트
	public List<?> selectMcmMalStt001M01L(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		return mcmMalStt001DAO.selectMcmMalStt001M01L(mcmMalStt001VO);
	}

	// 상품 리스트 조회
	public List<?> selectMcmMalGds002M01List(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		return mcmMalStt001DAO.selectMcmMalGds002M01List(mcmMalStt001VO);
	}

	// 일자별 매출현황 리스트
	public List<?> selectMcmMalStt002M01L(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		return mcmMalStt001DAO.selectMcmMalStt002M01L(mcmMalStt001VO);
	}

	// 사업자별 매출현황
	public List<?> selectMcmMalStt003M01L(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		return mcmMalStt001DAO.selectMcmMalStt003M01L(mcmMalStt001VO);
	}

	// 사업자 아이디 찾기
	public List<?> selectMcmMalStt001P03RP(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		return mcmMalStt001DAO.selectMcmMalStt001P03RP(mcmMalStt001VO);
	}

	// 페이징
	public int selectMcmMalStt001M01LtotCnt(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		return mcmMalStt001DAO.selectMcmMalStt001M01LtotCnt(mcmMalStt001VO);
	}

	@Override
	public int selectMcmMalStt002M01LtotCnt(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmMalStt001DAO.selectMcmMalStt002M01LtotCnt(mcmMalStt001VO);
	}

	@Override
	public int selectMcmMalStt003M01LtotCnt(McmMalStt001VO mcmMalStt001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmMalStt001DAO.selectMcmMalStt003M01LtotCnt(mcmMalStt001VO);
	}


	
	
}
