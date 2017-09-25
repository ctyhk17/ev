package kr.co.mcmall.mcm.cmn.ccd.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.ccd.service.McmCmnCcd001Service;
import kr.co.mcmall.mcm.cmn.ccd.service.McmCmnCcd001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : McmCmnCcd001ServiceImpl.java
 * @Description : McmCmnCcd001ServiceImpl ServiceImpl Class
 *                McmCmnCcd001ServiceImpl ServiceImpl 클래스 ( 코드그룹관리 )
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017-06-20           최초생성
 *
 * @author 개발팀
 * @since 2017-06-20
 * @version 1.0
 * @see
 * 
 **/ 
@Service("mcmCmnCcd001Service")
public class McmCmnCcd001ServiceImpl extends EgovAbstractServiceImpl implements McmCmnCcd001Service{

	/** DAO 선언 */
	@Resource(name = "mcmCmnCcd001DAO")
	private McmCmnCcd001DAO mcmCmnCcd001DAO;
	
	/**
	 * 코드그룹리스트
	 * @param mcmMalGds001VO
	 * @return 
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001CdGrpList(McmCmnCcd001VO mcmCmnCcd001VO)
			throws Exception {
		
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CdGrpList(mcmCmnCcd001VO);
	}
	
	/**
	 * 코드그룹리스트 개수조회
	 * @param mcmMalGds001VO
	 * @return 
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CdGrpListCnt(McmCmnCcd001VO mcmCmnCcd001VO)
			throws Exception {
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CdGrpListCnt(mcmCmnCcd001VO);
	}
	
	/**
	 * 코드그룹 상세정보
	 * @param mcmMalGds001VO
	 * @return 
	 * @throws Exception
	 */
	public Map<?, ?> selectMcmCmnCcd001CdGrpInfo(McmCmnCcd001VO mcmCmnCcd001VO)
			throws Exception {
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CdGrpInfo(mcmCmnCcd001VO);
	}
	
	/**
	 * 코드 사용여부
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CdGrpUseYn(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		mcmCmnCcd001DAO.updateMcmCmnCcd001CdGrpUseYn(mcmCmnCcd001VO);
	}
	
	/** 코드 그룹 수정
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CdGrpUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		mcmCmnCcd001DAO.updateMcmCmnCcd001CdGrpUpdate(mcmCmnCcd001VO);
	}
	
	/** 코드 그룹 등록
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public String insertMcmCmnCcd001CdGrpInsert(McmCmnCcd001VO mcmCmnCcd001VO)
			throws Exception {
		return mcmCmnCcd001DAO.insertMcmCmnCcd001CdGrpInsert(mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드 목록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001CommonCdList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CommonCdList(mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드목록 개수조회
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CommonCdListCnt(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CommonCdListCnt(mcmCmnCcd001VO);
	}

	/**
	 * 공통코드 상세정보
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmCmnCcd001CommonCdInfo(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CommonCdInfo(mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드 삭제(UseYn)
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CommonCdUseYnUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		mcmCmnCcd001DAO.updateMcmCmnCcd001CommonCdUseYnUpdate(mcmCmnCcd001VO);
	}
	
	/** 공통코드 수정
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CommonCdUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		mcmCmnCcd001DAO.updateMcmCmnCcd001CommonCdUpdate(mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드 등록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmCmnCcd001CommonCdInsert(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return mcmCmnCcd001DAO.insertMcmCmnCcd001CommonCdInsert(mcmCmnCcd001VO);
	}
	
	/**
	 * 코드그룹 조회
	 * @param mcmCmnCcd001VO
	 * @return
	 */
	public List<?> selectMcmCmnCcd001CdGrpSelect(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception {
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CdGrpSelect(mcmCmnCcd001VO);
	}
	
	/**
	 * 코드 조회(상품등록 시)
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001SelectCdInfoList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return mcmCmnCcd001DAO.selectMcmCmnCcd001SelectCdInfoList(mcmCmnCcd001VO);
	}
	
	/**
	 * 그룹코드ID 중복체크
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CdExists(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception {
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CdExists(mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드ID 중복체크
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CommonCdExists(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CommonCdExists(mcmCmnCcd001VO);
	}

	@Override
	public List<?> selectMcmCmnCcd001CdList(McmCmnCcd001VO mcmCmnCcd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnCcd001DAO.selectMcmCmnCcd001CdList(mcmCmnCcd001VO);
	}
	
}
