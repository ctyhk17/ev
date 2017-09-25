package kr.co.mcmall.mcm.cmn.ath.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002Service;
import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : FundTpltServiceImpl.java
 * @Description : FundTplt Service Implements Class
 *                템플릿 인터페이스 구현 클래스
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2017-05-10           최초생성
 *
 * @author 개발팀
 * @since 2017-05-10
 * @version 1.0
 * @see
 *  
 */

@Service("mcmCmnAth002Service")
public class McmCmnAth002ServiceImpl extends EgovAbstractServiceImpl implements McmCmnAth002Service {

	/** DAO 선언 */
	@Resource(name = "mcmCmnAth002DAO")
	private McmCmnAth002DAO mcmCmnAth002DAO;

	
	
	/**
	 * 목록조회
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectMcmCmnAth002M01List(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth002DAO.selectMcmCmnAth002M01List(mcmCmnAth002VO);
	}

	/**
	 * 목록 갯수 조회 
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectMcmCmnAth002M01TotCnt(McmCmnAth002VO mcmCmnAth002VO){
		return mcmCmnAth002DAO.selectMcmCmnAth002M01TotCnt(mcmCmnAth002VO);
	}
	

	/**
	 * 상세내용을 조회한다.
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 mcmCmnAth002VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectMcmCmnAth002M01Info(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth002DAO.selectMcmCmnAth002M01Info(mcmCmnAth002VO);
	}

	
	/**
	 * 정보을 등록한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public String insertMcmCmnAth002M01NewAthCd(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth002DAO.insertMcmCmnAth002M01NewAthCd(mcmCmnAth002VO);
	}
	
	/**
	 * 정보를 수정한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public void updateMcmCmnAth002M01Ath(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		mcmCmnAth002DAO.updateMcmCmnAth002M01Ath(mcmCmnAth002VO);
	}
	
	/**
	 * 정보를 삭제한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public int deleteMcmCmnAth002M05Ath(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return mcmCmnAth002DAO.deleteMcmCmnAth002M05Ath(mcmCmnAth002VO);
	}


	// 권한 코드 조회
	public List<?> selectMcmCmnAth002M01AthList(McmCmnAth002VO mcmCmnAth002VO)
			throws Exception {
		return mcmCmnAth002DAO.selectMcmCmnAth002M01AthList(mcmCmnAth002VO);
	}

	// 사용자 권한 조회 리스트
	public List<?> selectMcmCmnAth002M01usrAthList(McmCmnAth002VO mcmCmnAth002VO)
			throws Exception {
		return mcmCmnAth002DAO.selectMcmCmnAth002M01usrAthList(mcmCmnAth002VO);
	}

	// 권한정보수정
	public void updateMcmCmnAth002M01AthModify(McmCmnAth002VO mcmCmnAth002VO)
			throws Exception {
		mcmCmnAth002DAO.updateMcmCmnAth002M01AthModify(mcmCmnAth002VO);
	}

	// 권한부여
	public String insertMcmCmnAth002P01CP(McmCmnAth002VO mcmCmnAth002VO)
			throws Exception {
		return mcmCmnAth002DAO.insertMcmCmnAth002P01CP(mcmCmnAth002VO);
	}

	// 팝업 리스트
	public List<?> selectMcmCmnAth002P01List(McmCmnAth002VO mcmCmnAth002VO)
			throws Exception {
		return mcmCmnAth002DAO.selectMcmCmnAth002P01List(mcmCmnAth002VO);
	}

	// 팝업 페이징
	public int selectMcmCmnAth002P01TotCnt(McmCmnAth002VO mcmCmnAth002VO) {
		return mcmCmnAth002DAO.selectMcmCmnAth002P01TotCnt(mcmCmnAth002VO);
	}

	// 사업자 코드 넣기
	public String insertMcmCmnAth002P02CP(McmCmnAth002VO mcmCmnAth002VO)
			throws Exception {
		return mcmCmnAth002DAO.insertMcmCmnAth002P02CP(mcmCmnAth002VO);
	}

	// 사업자 중복찾기
	public int selectMcmCmnAth002FindLcsCd(McmCmnAth002VO mcmCmnAth002VO)
			throws Exception {
		return mcmCmnAth002DAO.selectMcmCmnAth002FindLcsCd(mcmCmnAth002VO);
	}


	
	

}
