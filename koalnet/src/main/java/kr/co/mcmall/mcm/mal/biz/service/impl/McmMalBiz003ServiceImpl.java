package kr.co.mcmall.mcm.mal.biz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz003Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz003VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("mcmMalBiz003Service")
public class McmMalBiz003ServiceImpl extends EgovAbstractServiceImpl implements McmMalBiz003Service  {

	
	/** DAO 선언 */
	@Resource(name = "mcmMalBiz003DAO")
	private McmMalBiz003DAO mcmMalBiz003DAO;

	// 사업자 관리 리스트 조회
	public List<?> selectMcmMalBiz003M01List(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalBiz003M01List(mcmMalBiz003VO);
	}

	// 사업자 관리 상세보기
	public Map<?, ?> selectMcmMalBiz003M02Info(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalBiz003M02Info(mcmMalBiz003VO);
	}

	// 사업자 등록 ID찾기
	public List<?> selectMcmMalBiz003P03CP(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalBiz003P03CP(mcmMalBiz003VO);
	}

	// 페이징
	public int selectMcmMalBiz003P01Paging(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalBiz003P01Paging(mcmMalBiz003VO);
	}

	// 상점찾기 팝업
	public List<?> selectMcmMalBiz003P04CP(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalBiz003P04CP(mcmMalBiz003VO);
	}

	// 상위사업자 찾기 팝업
	public List<?> selectMcmMalBiz003P05CP(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalBiz003P05CP(mcmMalBiz003VO);
	}

	// 사업자 등록 처리
	public String insertMcmMalBiz003M03CP(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.insertMcmMalBiz003M03CP(mcmMalBiz003VO);
	}

	// 하위사업자 등록 처리
	public void updateMcmMalBiz00302CP(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		mcmMalBiz003DAO.updateMcmMalBiz00302CP(mcmMalBiz003VO);
	}

	// 하위사업자 리스트 조회
	public List<?> selectMcmMalBiz003M03RR(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalBiz003M03RR(mcmMalBiz003VO);
	}

	// 상점 리스트 조회
	public List<?> selectMcmMalStr003M01List(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.selectMcmMalStr003M01List(mcmMalBiz003VO);
	}

	// 하위사업자 삭제
	public int deleteMcmMalBiz003M01DP(McmMalBiz003VO mcmMalBiz003VO)
			throws Exception {
		return mcmMalBiz003DAO.deleteMcmMalBiz003M01DP(mcmMalBiz003VO);
	}

	
	
}
