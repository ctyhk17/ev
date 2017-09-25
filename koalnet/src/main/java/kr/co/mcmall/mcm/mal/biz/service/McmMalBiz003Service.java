package kr.co.mcmall.mcm.mal.biz.service;

import java.util.List;
import java.util.Map;


public interface McmMalBiz003Service {

	
	// 사업자 리스트 조회
	List<?> selectMcmMalBiz003M01List(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 사업자 상세보기
	Map<?, ?> selectMcmMalBiz003M02Info(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 사업자등록 ID찾기
	List<?> selectMcmMalBiz003P03CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 페이징
	int selectMcmMalBiz003P01Paging(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 상점찾기
	List<?> selectMcmMalBiz003P04CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 상위사업자 리스트
	List<?> selectMcmMalBiz003P05CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 사업자 등록 처리
	String insertMcmMalBiz003M03CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 하위사업자 등록 처리
	void updateMcmMalBiz00302CP(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 하위사업자 리스트 조회
	List<?> selectMcmMalBiz003M03RR(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 상점 리스트 조회
	List<?> selectMcmMalStr003M01List(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
	
	// 하위사업자 삭제
	int deleteMcmMalBiz003M01DP(McmMalBiz003VO mcmMalBiz003VO) throws Exception;
}
