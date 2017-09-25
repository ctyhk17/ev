package kr.co.mcmall.mcm.mal.biz.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmMalBiz002DAO")
public class McmMalBiz002DAO extends EgovAbstractDAO  {

	// 홍보물 리스트 조회
	public List<?> selectMcmMalBiz002M01List(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.selectMcmMalBiz002M01List",mcmMalBiz002VO);
	}
	
	// 홍보물 상세보기
	public Map<?, ?> selectMcmMalBiz002M01Info(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.selectMcmMalBiz002M01Info",mcmMalBiz002VO);
	}
	
	// 홍보물 수정
	public void updateMcmMalBiz002M01InfoProc(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.updateMcmMalBiz002M01InfoProc",mcmMalBiz002VO);
	}
	
	// 페이징
	public int selectMcmMalBiz002M01Paging(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return (Integer) select("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.selectMcmMalBiz002M01Paging",mcmMalBiz002VO);
	}
	
	// 홍보물 삭제처리
	public int deleteMcmMalBiz002M04DP(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return delete("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.deleteMcmMalBiz002M04DP",mcmMalBiz002VO);
	}
	
	// 홍보물 등록
	public String insertMcmMalBiz002M03CP(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.insertMcmMalBiz002M03CP",mcmMalBiz002VO);
	}
	// 상품 리스트 조회
	public List<?> selectMcmMalStr002M01List(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.selectMcmMalStr002M01List",mcmMalBiz002VO);
	}
	// 상점 리스트 조회
	public List<?> selectMcmMalGds002M01List(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.selectMcmMalGds002M01List",mcmMalBiz002VO);
	}
	public Map<?,?> selectMcmMalBiz002lcsId(McmMalBiz002VO mcmMalBiz002VO) throws Exception{
		return (Map<?,?>)select("kr.co.mcmall.mcm.mal.biz.McmMalBiz002.selectMcmMalBiz002lcsId", mcmMalBiz002VO);
	}
	
}

