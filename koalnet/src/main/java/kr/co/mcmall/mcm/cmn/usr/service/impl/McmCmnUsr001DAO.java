package kr.co.mcmall.mcm.cmn.usr.service.impl;

import java.util.Map;

import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : McmCmnUsr001DAO.java
 * @Description : McmCmnUsr001DAO DAO Class
 *                회원관리 DAO 클래스
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

@Repository("mcmCmnUsr001DAO")
public class McmCmnUsr001DAO extends EgovAbstractDAO {

	
	/**
	 * 중복아이디 확인
	 * @param usrId
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return (String)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.selectExistsId", usrId);
	}
	
	/**
	 * 사용자 정보 등록
	 * @param mcmCmnUsr001VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.insertUsrInfo", mcmCmnUsr001VO);
	}
	
	/**
	 * 회원정보 조회
	 * @param mcmCmnUsr001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return (Map)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.selectUsrInfo", mcmCmnUsr001VO); 
	}
	
	public Map<?,?> selectUsrInfoWithPassword(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return (Map)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.selectUsrInfoWithPassword", mcmCmnUsr001VO);
	}
	
	/**
	 * 회원정보 수정
	 * @param mcmCmnUsr001VO
	 * @throws Exception
	 */
	public void updateUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.updateUsrInfo", mcmCmnUsr001VO);
	}
	
	/**
	 * 회원탈퇴
	 * @param mcmCmnUsr001VO
	 * @throws Exception
	 */
	public void stopUsrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.stopUsrInfo", mcmCmnUsr001VO);
	}
	
	
	/**
	 * 상점별 사용자 등록
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrStrInfo(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.insertUsrStrInfo", mcmCmnUsr001VO);
	}
	
	public Map<?, ?> getAddrInfo(String userId) throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>) select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.getAddrInfo", userId);
	}
	
	// 회원정보 조회
	public Map<?, ?> updateUsrPwd(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		return (Map<?,?>) select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.updateUsrPwd", mcmCmnUsr001VO);
	}
	
	// 비밀번호 변경처리
	public void updateUsrPwdProc(McmCmnUsr001VO mcmCmnUsr001VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr001.updateUsrPwdProc", mcmCmnUsr001VO);
	}

}
