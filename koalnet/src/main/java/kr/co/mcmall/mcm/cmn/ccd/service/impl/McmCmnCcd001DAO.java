package kr.co.mcmall.mcm.cmn.ccd.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.cmn.ccd.service.McmCmnCcd001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : McmCmnCcd001DAO.java
 * @Description : McmCmnCcd001DAO DAO Class
 *                McmCmnCcd001DAO DAO 클래스 ( 코드그룹관리 )
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

@Repository("mcmCmnCcd001DAO")
public class McmCmnCcd001DAO extends EgovAbstractDAO{
	
	/**
	 * 코드그룹리스트
	 * @param mcmMalGds001VO
	 * @return 
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001CdGrpList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.selectCdGrpList",mcmCmnCcd001VO);
	}
	
	/**
	 * 코드그룹리스트 개수조회
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CdGrpListCnt(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return (int) select("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.selectCdGrpListCnt",mcmCmnCcd001VO);
	}
	
	/**
	 * 코드그룹 상세정보
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmCmnCcd001CdGrpInfo(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.selectCdGrpInfo",mcmCmnCcd001VO);
	}
	
	/**
	 * 코드 사용여부
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CdGrpUseYn(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.updateCdGrpUseYn",mcmCmnCcd001VO);
	}
	
	
	/** 코드 그룹 수정
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CdGrpUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.updateCdGrp",mcmCmnCcd001VO);
	}

	/**
	 * 코드그룹 등록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmCmnCcd001CdGrpInsert(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return (String) insert("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.InsertCdGrp",mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드 목록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001CommonCdList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.CommonCdList",mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드목록 개수조회
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CommonCdListCnt(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return (int) select("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.CommonCdListCnt",mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드 상세정보
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmCmnCcd001CommonCdInfo(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		return (Map<?, ?>) select("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.CommonCdInfo",mcmCmnCcd001VO);
	}
	
	
	/**
	 * 공통코드 삭제(UseYn)
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CommonCdUseYnUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.CommonUseYnUpdate",mcmCmnCcd001VO);
	}
	
	
	/** 공통코드 수정
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CommonCdUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.CommonCdUpdate",mcmCmnCcd001VO);
	}
	
	/**
	 * 공통코드 등록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmCmnCcd001CommonCdInsert(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception {
		return (String) insert("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.CommonCdInsert",mcmCmnCcd001VO);
	}

	
	/**
	 * 코드그룹 조회
	 * @param mcmCmnCcd001VO
	 * @return
	 */
	public List<?> selectMcmCmnCcd001CdGrpSelect(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception {
		return list("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.CdGrpSelect",mcmCmnCcd001VO); 
				
	}
	
	
	/**
	 * 코드 조회(상품등록 시)
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001SelectCdInfoList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception {
		return list("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.selectCdInfoList",mcmCmnCcd001VO);
	}
	
	/**
	 * 그룹코드ID 중복체크
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CdExists(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception {
		return (int) select("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.selectMcmCmnCcd001CdGrpExists",mcmCmnCcd001VO);
	}
	
	
	/**
	 * 공통코드ID 중복체크
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CommonCdExists(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception {
		return (int) select("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.selectMcmCmnCcd001CommonCdExists",mcmCmnCcd001VO);
	}
	
	
	public List<?> selectMcmCmnCcd001CdList(McmCmnCcd001VO mcmCmnCcd001VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.cmn.ccd.McmCmnCcd001.selectMcmCmnCcd001CdList",mcmCmnCcd001VO);
	}
}
