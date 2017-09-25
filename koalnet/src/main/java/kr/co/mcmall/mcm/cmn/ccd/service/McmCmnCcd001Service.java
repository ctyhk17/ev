package kr.co.mcmall.mcm.cmn.ccd.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : McmCmnCcd001Service.java
 * @Description : McmCmnCcd001Service Service Class
 *                McmCmnCcd001Service Service 클래스 ( 코드그룹관리 )
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
public interface McmCmnCcd001Service {
	
	/**
	 * 코드그룹리스트
	 * @param mcmMalGds001VO
	 * @return 
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001CdGrpList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	
	/**
	 * 코드그룹리스트 개수조회
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CdGrpListCnt(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 코드그룹 상세정보
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmCmnCcd001CdGrpInfo(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 코드 사용여부
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CdGrpUseYn(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/** 코드 그룹 수정
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CdGrpUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 코드그룹 등록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmCmnCcd001CdGrpInsert(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 공통코드 목록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001CommonCdList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 공통코드목록 개수조회
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CommonCdListCnt(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 공통코드 상세정보
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectMcmCmnCcd001CommonCdInfo(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 공통코드 삭제(UseYn)
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CommonCdUseYnUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/** 공통코드 수정
	 * @param mcmCmnCcd001VO
	 * @throws Exception
	 */
	public void updateMcmCmnCcd001CommonCdUpdate(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 공통코드 등록
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmCmnCcd001CommonCdInsert(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 코드그룹 조회
	 * @param mcmCmnCcd001VO
	 * @return
	 */
	public List<?> selectMcmCmnCcd001CdGrpSelect(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception ;
	
	/**
	 * 코드 조회(상품등록 시)
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectMcmCmnCcd001SelectCdInfoList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	
	/**
	 * 그룹코드ID 중복체크
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CdExists(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	/**
	 * 공통코드ID 중복체크
	 * @param mcmCmnCcd001VO
	 * @return
	 * @throws Exception
	 */
	public int selectMcmCmnCcd001CommonCdExists(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
	
	
	public List<?> selectMcmCmnCcd001CdList(McmCmnCcd001VO mcmCmnCcd001VO) throws Exception;
		
}
