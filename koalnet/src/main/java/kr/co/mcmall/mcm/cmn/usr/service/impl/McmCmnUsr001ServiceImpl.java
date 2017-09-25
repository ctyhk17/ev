package kr.co.mcmall.mcm.cmn.usr.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr001Service;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr001VO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : McmCmnUsr001ServiceImpl.java
 * @Description : McmCmnUsr001ServiceImpl Service Implements Class
 *                회원관리 인터페이스
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

@Service("mcmCmnUsr001Service")
public class McmCmnUsr001ServiceImpl extends EgovAbstractServiceImpl implements McmCmnUsr001Service {

	/** DAO 선언 */
	@Resource(name = "mcmCmnUsr001DAO")
	private McmCmnUsr001DAO mcmCmnUsr001DAO;

	
	
	/**
	 * ID 중복확인
	 * @param 
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return mcmCmnUsr001DAO.selectExistsId(usrId);
	}
	
	
	/**
	 * 사용자 정보 등록
	 */
	public String insertUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return mcmCmnUsr001DAO.insertUsrInfo(mcmCmnUsr001VO);
	}
	
	
	/**
	 * 회원정보 조회
	 * @param mcmCmnUsr001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return mcmCmnUsr001DAO.selectUsrInfo(mcmCmnUsr001VO); 
	}
	
	public Map<?,?> selectUsrInfoWithPassword(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return mcmCmnUsr001DAO.selectUsrInfoWithPassword(mcmCmnUsr001VO);
	}
	
	/**
	 * 회원정보 수정
	 */
	public void updateUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		mcmCmnUsr001DAO.updateUsrInfo(mcmCmnUsr001VO);
	}
	
	/**
	 * 회원탈퇴
	 * @param mcmCmnUsr001VO
	 * @throws Exception
	 */
	public void stopUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		mcmCmnUsr001DAO.stopUsrInfo(mcmCmnUsr001VO);
	}
	/**
	 * 상점별 사용자 등록
	 * @param mcmCmnUsr001VO
	 * @throws Exception
	 */
	public String insertUsrStrInfo(McmCmnUsr001VO mcmCmnUsr001VO)
			throws Exception {
		return mcmCmnUsr001DAO.insertUsrStrInfo(mcmCmnUsr001VO);
	}

	@Override
	public Map<?, ?> getAddrInfo(String userId) throws Exception {
		// TODO Auto-generated method stub
		return mcmCmnUsr001DAO.getAddrInfo(userId);
	}


	// 회원정보 조회
	public Map<?, ?> updateUsrPwd(McmCmnUsr001VO mcmCmnUsr001VO)
			throws Exception {
		return mcmCmnUsr001DAO.updateUsrPwd(mcmCmnUsr001VO);
	}


	// 비밀번호 변경처리
	public void updateUsrPwdProc(McmCmnUsr001VO mcmCmnUsr001VO)
			throws Exception {
		mcmCmnUsr001DAO.updateUsrPwdProc(mcmCmnUsr001VO);
		
	}


	
	

}
