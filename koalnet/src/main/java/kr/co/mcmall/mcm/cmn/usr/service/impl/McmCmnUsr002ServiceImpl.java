package kr.co.mcmall.mcm.cmn.usr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr002Service;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr002VO;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : McmCmnUsr002ServiceImpl.java
 * @Description : McmCmnUsr002ServiceImpl Service Implements Class
 *                조합원관리 인터페이스
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

@Service("mcmCmnUsr002Service")
public class McmCmnUsr002ServiceImpl extends EgovAbstractServiceImpl implements McmCmnUsr002Service {

	/** DAO 선언 */
	@Resource(name = "mcmCmnUsr002DAO")
	private McmCmnUsr002DAO mcmCmnUsr002DAO;

	
	/**
	 * 조합원 목록 조회
	 */
	public List<?> selectUsrList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return mcmCmnUsr002DAO.selectUsrList(mcmCmnUsr002VO);
	}
	
	
	/**
	 * 조합원 목록 조회 건수
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrListTotCnt(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return mcmCmnUsr002DAO.selectUsrListTotCnt(mcmCmnUsr002VO);
	}
	
	/**
	 * 조합원정보 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return mcmCmnUsr002DAO.selectUsrInfo(mcmCmnUsr002VO); 
	}
	
	/**
	 * 사용자 정보 등록
	 */
	public String insertUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return mcmCmnUsr002DAO.insertUsrInfo(mcmCmnUsr002VO);
	}
	
	/**
	 * 조합원정보 수정
	 */
	public void updateUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		mcmCmnUsr002DAO.updateUsrInfo(mcmCmnUsr002VO);
	}
	
	
	/**
	 * 조합원 정보 삭제
	 * @param mcmCmnUsr002VO
	 * @throws Exception
	 */
	public void deleteUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		mcmCmnUsr002DAO.deleteUsrInfo(mcmCmnUsr002VO);
	}
	

	/**
	 * ID 중복확인
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return mcmCmnUsr002DAO.selectExistsId(usrId);
	}
	
	
	
	/**
	 * 조합원가입신청 목록 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectUsrAppList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return mcmCmnUsr002DAO.selectUsrAppList(mcmCmnUsr002VO);
	}
	
	/**
	 * 조합원가입신청 목록 조회 건수
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrAppListTotCnt(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return mcmCmnUsr002DAO.selectUsrAppListTotCnt(mcmCmnUsr002VO);
	}
	
	

	/**
	 * 조합원 가입신청 승인
	 */
	public void updateUsAppInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		mcmCmnUsr002DAO.updateUsAppInfo(mcmCmnUsr002VO);
	}


	
	// 상점별 사용자 등록
	public String insertUsrStrInfo(McmCmnUsr002VO mcmCmnUsr002VO)
			throws Exception {
		return mcmCmnUsr002DAO.insertUsrStrInfo(mcmCmnUsr002VO);
	}


	// 사용자 권한 부여
	public String insertUsrDefaultAth(McmCmnUsr002VO mcmCmnUsr002VO)
			throws Exception {
		return mcmCmnUsr002DAO.insertUsrDefaultAth(mcmCmnUsr002VO);
	}


	// 회원 코드 분류
	public List<?> selectAthCdList(McmCmnUsr002VO mcmCmnUsr002VO)
			throws Exception {
		return mcmCmnUsr002DAO.selectAthCdList(mcmCmnUsr002VO);
	}
	
	@Override
	public List<?> selectUsrExcelList(McmCmnUsr002VO mcmCmnUsr002VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnUsr002DAO.selectUsrExcelList(mcmCmnUsr002VO);
	}
	// 승인시 코드 부여
	public String insertUsrAth(McmCmnUsr002VO mcmCmnUsr003VO) throws Exception {
		return mcmCmnUsr002DAO.insertUsrAth(mcmCmnUsr003VO);
	}
	
	
	
	
	
	
	

}
