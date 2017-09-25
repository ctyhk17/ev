package kr.co.mcmall.mcm.mal.stt.service;

import java.util.List;


public interface McmMalStt001Service {

	
	// 상품별 매출현황 리스트
	List<?> selectMcmMalStt001M01L(McmMalStt001VO mcmMalStt001VO) throws Exception;
	
	// 일자별 매출현황 리스트
	List<?> selectMcmMalStt002M01L(McmMalStt001VO mcmMalStt001VO) throws Exception;
	
	// 상품 리스트 조회
	List<?> selectMcmMalGds002M01List(McmMalStt001VO mcmMalStt001VO) throws Exception;
	
	// 사업자별 매출현황
	List<?> selectMcmMalStt003M01L(McmMalStt001VO mcmMalStt001VO) throws Exception;
	
	// 사업자 아이디 찾기
	List<?> selectMcmMalStt001P03RP(McmMalStt001VO mcmMalStt001VO) throws Exception;
	
	// 페이징
	int selectMcmMalStt001M01LtotCnt(McmMalStt001VO mcmMalStt001VO) throws Exception;
	// 페이징
	int selectMcmMalStt002M01LtotCnt(McmMalStt001VO mcmMalStt001VO) throws Exception;
	// 페이징
	int selectMcmMalStt003M01LtotCnt(McmMalStt001VO mcmMalStt001VO) throws Exception;
}
