package kr.co.mcmall.mcm.mal.biz.service;

import java.util.List;
import java.util.Map;


public interface McmMalBiz001Service {

	
	// 사업자 리스트 조회
	List<?> selectMcmMalBiz001M01List(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 사업자 상세보기
	Map<?, ?> selectMcmMalBiz001M02Info(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 사업자등록 ID찾기
	List<?> selectMcmMalBiz001P03CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 페이징
	int selectMcmMalBiz001P01Paging(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 상점찾기
	List<?> selectMcmMalBiz001P04CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 상위사업자 리스트
	List<?> selectMcmMalBiz001P05CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 사업자 등록 처리
	String insertMcmMalBiz001M03CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 사업자 등록시 권한넣기
	String insertMcmMalBiz001M01Ath(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 상위사업자 등록시 권한넣기
	String insertMcmMalBiz001M01upAth(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 상점 리스트 조회
	List<?> selectMcmMalStr001M01List(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 회원찾기 팝업
	List<?> selectMcmMalBiz001P03List(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 회원찾기 팝업 카운트
	public int selectMcmMalBiz001P03TotCnt(McmMalBiz001VO mcmMalBiz001VO) throws Exception;

	// 팀장등록
	void updateMcmMalBiz001P03RP(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
	
	// 팀장 리스트
	List<?> selectMcmMalBiz001M03RupList(McmMalBiz001VO mcmMalBiz001VO) throws Exception;
}
