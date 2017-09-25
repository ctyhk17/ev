package kr.co.mcmall.mcm.mal.biz.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002Service;
import kr.co.mcmall.mcm.mal.biz.service.McmMalBiz002VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("mcmMalBiz002Service")
public class McmMalBiz002ServiceImpl extends EgovAbstractServiceImpl implements McmMalBiz002Service  {

	
	/** DAO 선언 */
	@Resource(name = "mcmMalBiz002DAO")
	private McmMalBiz002DAO mcmMalBiz002DAO;

	// 홍보물 리스트 조회
	public List<?> selectMcmMalBiz002M01List(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.selectMcmMalBiz002M01List(mcmMalBiz002VO);
	}

	// 홍보물 상세보기
	public Map<?, ?> selectMcmMalBiz002M01Info(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.selectMcmMalBiz002M01Info(mcmMalBiz002VO);
	}

	// 홍보물 수정
	public void updateMcmMalBiz002M01InfoProc(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		mcmMalBiz002DAO.updateMcmMalBiz002M01InfoProc(mcmMalBiz002VO);
	}

	// 페이징
	public int selectMcmMalBiz002M01Paging(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.selectMcmMalBiz002M01Paging(mcmMalBiz002VO);
	}

	// 홍보물 삭제하기
	public int deleteMcmMalBiz002M04DP(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.deleteMcmMalBiz002M04DP(mcmMalBiz002VO);
	}

	// 홍보물 등록하기
	public String insertMcmMalBiz002M03CP(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.insertMcmMalBiz002M03CP(mcmMalBiz002VO);
	}

	// 상점 리스트
	public List<?> selectMcmMalStr002M01List(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.selectMcmMalStr002M01List(mcmMalBiz002VO);
	}

	// 상품 리스트
	public List<?> selectMcmMalGds002M01List(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.selectMcmMalGds002M01List(mcmMalBiz002VO);
	}

	public Map<?,?> selectMcmMalBiz002lcsId(McmMalBiz002VO mcmMalBiz002VO)
			throws Exception {
		return mcmMalBiz002DAO.selectMcmMalBiz002lcsId(mcmMalBiz002VO);
	}
	
}
