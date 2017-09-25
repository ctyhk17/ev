package kr.co.mcmall.mcm.mal.biz.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz003VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmMalBiz003DAO")
public class McmMalBiz003DAO extends EgovAbstractDAO  {

	// 사업자 관리 리스트 조회
	public List<?> selectMcmMalBiz003M01List(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalBiz003M01List",mcmMalBiz003VO);
	}
	
	// 사업자 관리 상세보기
	public Map<?, ?> selectMcmMalBiz003M02Info(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalBiz003M02Info",mcmMalBiz003VO);
	}
	
	// 팝업창 회원 리스트
	public List<?> selectMcmMalBiz003P03CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalBiz003P03CP",mcmMalBiz003VO);
	}
	
	// 페이징
	public int selectMcmMalBiz003P01Paging(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return (Integer) select("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalBiz003P01Paging",mcmMalBiz003VO);
	}
	
	// 팝업창 상점 리스트
	public List<?> selectMcmMalBiz003P04CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalBiz003P04CP",mcmMalBiz003VO);
	}
	
	// 상위사업자 리스트
	public List<?> selectMcmMalBiz003P05CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalBiz003P05CP",mcmMalBiz003VO);
	}	
	
	// 사업자 등록 처리
	public String insertMcmMalBiz003M03CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.insertMcmMalBiz003M03CP",mcmMalBiz003VO);
	}	
	
	// 하위사업자 등록 처리
	public void updateMcmMalBiz00302CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.updateMcmMalBiz00302CP",mcmMalBiz003VO);
	}

	// 하위사업자 리스트 조회
	public List<?> selectMcmMalBiz003M03RR(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalBiz003M03RR",mcmMalBiz003VO);
	}
	
	// 상점 리스트 조회
	public List<?> selectMcmMalStr003M01List(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.selectMcmMalStr003M01List",mcmMalBiz003VO);
	}
	
	// 하위사업자 삭제
	public int deleteMcmMalBiz003M01DP(McmMalBiz003VO mcmMalBiz003VO) throws Exception{
		return delete("kr.co.mcmall.mcm.mal.biz.McmMalBiz003.deleteMcmMalBiz003M01DP",mcmMalBiz003VO);
	}
		
}
