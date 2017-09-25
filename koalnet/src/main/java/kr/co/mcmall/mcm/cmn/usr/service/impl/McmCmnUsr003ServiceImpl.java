package kr.co.mcmall.mcm.cmn.usr.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003Service;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : McmCmnUsr003ServiceImpl.java
 * @Description : McmCmnUsr003ServiceImpl Service Implements Class
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

@Service("mcmCmnUsr003Service")
public class McmCmnUsr003ServiceImpl extends EgovAbstractServiceImpl implements McmCmnUsr003Service {

	/** DAO 선언 */
	@Resource(name = "mcmCmnUsr003DAO")
	private McmCmnUsr003DAO mcmCmnUsr003DAO;

	
	/**
	 * 조합원 목록 조회
	 */
	public List<?> selectUsrList(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return mcmCmnUsr003DAO.selectUsrList(mcmCmnUsr003VO);
	}
	
	
	/**
	 * 조합원 목록 조회 건수
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrListTotCnt(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return mcmCmnUsr003DAO.selectUsrListTotCnt(mcmCmnUsr003VO);
	}
	
	/**
	 * 조합원정보 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return mcmCmnUsr003DAO.selectUsrInfo(mcmCmnUsr003VO); 
	}
	
	/**
	 * 사용자 정보 등록
	 */
	public String insertUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return mcmCmnUsr003DAO.insertUsrInfo(mcmCmnUsr003VO);
	}
	
	/**
	 * 조합원정보 수정
	 */
	public void updateUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		mcmCmnUsr003DAO.updateUsrInfo(mcmCmnUsr003VO);
	}
	
	
	/**
	 * 조합원 정보 삭제
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	public void deleteUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		mcmCmnUsr003DAO.deleteUsrInfo(mcmCmnUsr003VO);
	}
	

	/**
	 * ID 중복확인
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return mcmCmnUsr003DAO.selectExistsId(usrId);
	}
	
	
	
	/**
	 * 조합원가입신청 목록 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectUsrAppList(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return mcmCmnUsr003DAO.selectUsrAppList(mcmCmnUsr003VO);
	}
	
	/**
	 * 조합원가입신청 목록 조회 건수
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrAppListTotCnt(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return mcmCmnUsr003DAO.selectUsrAppListTotCnt(mcmCmnUsr003VO);
	}
	
	

	/**
	 * 조합원 가입신청 승인
	 */
	public void updateUsAppInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		mcmCmnUsr003DAO.updateUsAppInfo(mcmCmnUsr003VO);
	}


	
	// 상점별 사용자 등록
	public String insertUsrStrInfo(McmCmnUsr003VO mcmCmnUsr003VO)
			throws Exception {
		return mcmCmnUsr003DAO.insertUsrStrInfo(mcmCmnUsr003VO);
	}


	// 사용자 권한 부여
	public String insertUsrDefaultAth(McmCmnUsr003VO mcmCmnUsr003VO)
			throws Exception {
		return mcmCmnUsr003DAO.insertUsrDefaultAth(mcmCmnUsr003VO);
	}


	@Override
	public List<?> selectUsrExcelList(McmCmnUsr003VO mcmCmnUsr003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnUsr003DAO.selectUsrExcelList(mcmCmnUsr003VO);
	}
	
	
	
	
	
	
	
	

}
