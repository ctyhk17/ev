package kr.co.mcmall.mcm.cmn.usr.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : McmCmnUsr003DAO.java
 * @Description : McmCmnUsr003DAO DAO Class
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

@Repository("mcmCmnUsr003DAO")
public class McmCmnUsr003DAO extends EgovAbstractDAO {

	
	/**
	 * 회원 목록 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectUsrList(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.selectUsrList", mcmCmnUsr003VO);
	}
	
	/**
	 * 조합웝 목록 건수 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrListTotCnt(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return (Integer)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.selectUsrListTotCnt", mcmCmnUsr003VO);
	}
	
	/**
	 * 회원 정보 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return (Map)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.selectUsrInfo", mcmCmnUsr003VO); 
	}
	
	/**
	 * 사용자 정보 등록
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.insertUsrInfo", mcmCmnUsr003VO);
	}
	
	/**
	 * 사용자 권한 등록
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrDefaultAth(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.insertUsrDefaultAth", mcmCmnUsr003VO);
	}
	
	/**
	 * 상점별 사용자 등록
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrStrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.insertUsrStrInfo", mcmCmnUsr003VO);
	}
	
	
	/**
	 * 회원정보 수정
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	public void updateUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.updateUsrInfo", mcmCmnUsr003VO);
	}
	
	
	/**
	 * 회원 정보 삭제
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	public void deleteUsrInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.deleteUsrInfo", mcmCmnUsr003VO);
	}

	/**
	 * 중복아이디 확인
	 * @param usrId
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return (String)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.selectExistsId", usrId);
	}
	
	/**
	 * 회원가입신청 목록 조회
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectUsrAppList(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.selectUsrAppList", mcmCmnUsr003VO);
	}
	
	/**
	 * 회원가입신청 목록 조회 건수
	 * @param mcmCmnUsr003VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrAppListTotCnt(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		return (Integer)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.selectUsrAppListTotCnt", mcmCmnUsr003VO);
	}
	
	/**
	 * 회원 가입신청 승인
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	public void updateUsAppInfo(McmCmnUsr003VO mcmCmnUsr003VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.updateUsAppInfo", mcmCmnUsr003VO);
	}
	
	/**
	 * 회원 엑셀다운로드
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	public List<?> selectUsrExcelList(McmCmnUsr003VO mcmCmnUsr003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr003.selectUsrExcelList",mcmCmnUsr003VO);
	}
	

}
