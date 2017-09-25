package kr.co.mcmall.mcm.mal.biz.service;

import java.util.List;
import java.util.Map;

public interface McmMalBiz002Service {

	
	// 홍보물 리스트 조회
	List<?> selectMcmMalBiz002M01List(McmMalBiz002VO mcmMalBiz002VO) throws Exception; 
	
	// 홍보물 상세보기
	Map<?, ?> selectMcmMalBiz002M01Info(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
	
	// 홍보물 수정
	void updateMcmMalBiz002M01InfoProc(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
	
	// 홍보물 페이징
	int selectMcmMalBiz002M01Paging(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
	
	// 홍보물 삭제하기
	int deleteMcmMalBiz002M04DP(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
	
	// 홍보물 등록하기
	String insertMcmMalBiz002M03CP(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
	
	// 상점 리스트
	List<?> selectMcmMalStr002M01List(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
	
	// 상품 리스트
	List<?> selectMcmMalGds002M01List(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
	
	Map<?,?> selectMcmMalBiz002lcsId(McmMalBiz002VO mcmMalBiz002VO) throws Exception;
}
