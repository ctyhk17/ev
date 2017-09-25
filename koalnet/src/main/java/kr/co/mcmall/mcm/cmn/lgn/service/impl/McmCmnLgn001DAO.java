package kr.co.mcmall.mcm.cmn.lgn.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.cmn.lgn.service.McmCmnLgn001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : FmsFndOrd001DAO.java
 * @Description : FmsFndOrd001DAO DAO Class
 *                주문 DAO 클래스
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

@Repository("mcmCmnLgn001DAO")
public class McmCmnLgn001DAO extends EgovAbstractDAO {

	/**
	 * 로그인 정보 조회
	 * @param mcmCmnLgn001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectUsrInfo(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception{
		return (Map<?,?>)select("kr.co.mcmall.mcm.cmn.lgn.McmCmnLgn001.selectUsrInfo", mcmCmnLgn001VO);
	}
	
	/**
	 * 권한목록 조회
	 * @param usrId
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAthCdList(String usrId) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.lgn.McmCmnLgn001.selectAthCdList", usrId);
	}
	
	
	/**
	 * 중복아이디 확인
	 * @param usrId
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return (String)select("kr.co.mcmall.mcm.cmn.lgn.McmCmnLgn001.selectExistsId", usrId);
	}
	
	
	/**
	 * 아이디 목록 조회
	 * @param mcmCmnLgn001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectUsrIdList(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.lgn.McmCmnLgn001.selectUsrIdList", mcmCmnLgn001VO);
	}
	
	
	/**
	 * 임시비밀번호 업데이트
	 * @param value
	 * @throws Exception
	 */
	public void updateTmpUsrPwd(Map<?,?> paramMap) throws Exception{
		update("kr.co.mcmall.mcm.cmn.lgn.McmCmnLgn001.updateTmpUsrPwd", paramMap);
	}
	
	/**
	 * 비밀번호 찾기
	 * @param mcmCmnLgn001VO
	 * @return
	 * @throws Exception
	 */
	public Map <?,?> selectUsrInfoForPwd(McmCmnLgn001VO mcmCmnLgn001VO) throws Exception{
		return (Map <?,?>)select("kr.co.mcmall.mcm.cmn.lgn.McmCmnLgn001.selectUsrInfoForPwd", mcmCmnLgn001VO);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
