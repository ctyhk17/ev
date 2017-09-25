package kr.co.mcmall.mcm.mal.biz.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001VO;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("mcmMalBiz001DAO")
public class McmMalBiz001DAO extends EgovAbstractDAO  {

	// 사업자 관리 리스트 조회
	public List<?> selectMcmMalBiz001M01List(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001M01List",mcmMalBiz001VO);
	}
	
	// 사업자 관리 상세보기
	public Map<?, ?> selectMcmMalBiz001M02Info(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001M02Info",mcmMalBiz001VO);
	}
	
	// 팝업창 회원 리스트
	public List<?> selectMcmMalBiz001P03CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001P03CP",mcmMalBiz001VO);
	}
	
	// 페이징
	public int selectMcmMalBiz001P01Paging(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return (Integer) select("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001P01Paging",mcmMalBiz001VO);
	}
	
	// 팝업창 상점 리스트
	public List<?> selectMcmMalBiz001P04CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001P04CP",mcmMalBiz001VO);
	}
	
	// 상위사업자 리스트
	public List<?> selectMcmMalBiz001P05CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001P05CP",mcmMalBiz001VO);
	}	
	
	// 사업자 등록 처리
	public String insertMcmMalBiz001M03CP(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.insertMcmMalBiz001M03CP",mcmMalBiz001VO);
	}	
	
	// 사업자 등록시 권한넣기
	public String insertMcmMalBiz001M01Ath(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.insertMcmMalBiz001M01Ath",mcmMalBiz001VO);
	}
		
	// 상위사업자 등록시 권한넣기
	public String insertMcmMalBiz001M01upAth(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.insertMcmMalBiz001M01upAth",mcmMalBiz001VO);
	}
	
	// 상점 리스트 조회
	public List<?> selectMcmMalStr001M01List(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalStr001M01List",mcmMalBiz001VO);
	}
	
	// 회원찾기 리스트
	public List<?> selectMcmMalBiz001P03List(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001P03List",mcmMalBiz001VO);
	}
	
	public int selectMcmMalBiz001P03TotCnt(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return (Integer) select("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001P03TotCnt",mcmMalBiz001VO);
	}
	
	// 팀장등록
	public void updateMcmMalBiz001P03RP(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		update("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.updateMcmMalBiz001P03RP",mcmMalBiz001VO); 
	}
	
	//팀장 리스트
	public List<?> selectMcmMalBiz001M03RupList(McmMalBiz001VO mcmMalBiz001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.biz.McmMalBiz001.selectMcmMalBiz001M03RupList",mcmMalBiz001VO); 
	}
	

}
