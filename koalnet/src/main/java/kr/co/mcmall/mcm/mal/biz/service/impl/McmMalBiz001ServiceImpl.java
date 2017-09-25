package kr.co.mcmall.mcm.mal.biz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("mcmMalBiz001Service")
public class McmMalBiz001ServiceImpl extends EgovAbstractServiceImpl implements McmMalBiz001Service  {

	
	/** DAO 선언 */
	@Resource(name = "mcmMalBiz001DAO")
	private McmMalBiz001DAO mcmMalBiz001DAO;

	// 사업자 관리 리스트 조회
	public List<?> selectMcmMalBiz001M01List(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001M01List(mcmMalBiz001VO);
	}

	// 사업자 관리 상세보기
	public Map<?, ?> selectMcmMalBiz001M02Info(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001M02Info(mcmMalBiz001VO);
	}

	// 사업자 등록 ID찾기
	public List<?> selectMcmMalBiz001P03CP(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001P03CP(mcmMalBiz001VO);
	}

	// 페이징
	public int selectMcmMalBiz001P01Paging(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001P01Paging(mcmMalBiz001VO);
	}

	// 상점찾기 팝업
	public List<?> selectMcmMalBiz001P04CP(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001P04CP(mcmMalBiz001VO);
	}

	// 상위사업자 찾기 팝업
	public List<?> selectMcmMalBiz001P05CP(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001P05CP(mcmMalBiz001VO);
	}

	// 사업자 등록 처리
	public String insertMcmMalBiz001M03CP(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.insertMcmMalBiz001M03CP(mcmMalBiz001VO);
	}

	// 사업자 등록시 권한넣기
	public String insertMcmMalBiz001M01Ath(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.insertMcmMalBiz001M01Ath(mcmMalBiz001VO);
	}

	// 상위사업자 등록시 권한넣기
	public String insertMcmMalBiz001M01upAth(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.insertMcmMalBiz001M01upAth(mcmMalBiz001VO);
	}

	// 상점 리스트 조회
	public List<?> selectMcmMalStr001M01List(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalStr001M01List(mcmMalBiz001VO);
	}

	// 회원찾기 팝업
	public List<?> selectMcmMalBiz001P03List(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001P03List(mcmMalBiz001VO);
	}

	// 회원찾기 팝업 카운트
	public int selectMcmMalBiz001P03TotCnt(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001P03TotCnt(mcmMalBiz001VO);
	}

	// 팀장등록
	public void updateMcmMalBiz001P03RP(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		mcmMalBiz001DAO.updateMcmMalBiz001P03RP(mcmMalBiz001VO);
		
	}

	// 팀장 리스트
	public List<?> selectMcmMalBiz001M03RupList(McmMalBiz001VO mcmMalBiz001VO)
			throws Exception {
		return mcmMalBiz001DAO.selectMcmMalBiz001M03RupList(mcmMalBiz001VO);
	}



	
	
}
