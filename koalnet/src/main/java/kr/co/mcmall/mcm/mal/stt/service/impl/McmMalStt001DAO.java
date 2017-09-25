package kr.co.mcmall.mcm.mal.stt.service.impl;

import java.util.List;

import kr.co.mcmall.mcm.mal.stt.service.McmMalStt001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmMalStt001DAO")
public class McmMalStt001DAO extends EgovAbstractDAO  {


	// 상품별 매출현황
	public List<?> selectMcmMalStt001M01L(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalStt001M01L",mcmMalStt001VO);
	}
	// 일자별 매출현황
	public List<?> selectMcmMalStt002M01L(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalStt002M01L",mcmMalStt001VO);
	}
	
	// 사업자별 매출현황
	public List<?> selectMcmMalStt003M01L(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalStt003M01L",mcmMalStt001VO);
	}
	
	// 상점 리스트 조회
	public List<?> selectMcmMalGds002M01List(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalGds002M01List",mcmMalStt001VO);
	}
	
	// 사업자 아이디 찾기
	public List<?> selectMcmMalStt001P03RP(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalStt001P03RP",mcmMalStt001VO);
	}
	
	// 페이징
	public int selectMcmMalStt001M01LtotCnt(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return (Integer) select("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalStt001M01LtotCnt",mcmMalStt001VO);
	}
	public int selectMcmMalStt002M01LtotCnt(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return (Integer) select("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalStt002M01LtotCnt",mcmMalStt001VO);
	}
	public int selectMcmMalStt003M01LtotCnt(McmMalStt001VO mcmMalStt001VO) throws Exception{
		return (Integer) select("kr.co.mcmall.mcm.mal.stt.McmMalStt001.selectMcmMalStt003M01LtotCnt",mcmMalStt001VO);
	}
}
