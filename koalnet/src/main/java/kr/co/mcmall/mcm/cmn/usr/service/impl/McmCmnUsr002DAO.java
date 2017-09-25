package kr.co.mcmall.mcm.cmn.usr.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr002VO;
import kr.co.mcmall.mcm.cmn.usr.service.McmCmnUsr003VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : McmCmnUsr002DAO.java
 * @Description : McmCmnUsr002DAO DAO Class
 *                조합원관리 DAO 클래스
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

@Repository("mcmCmnUsr002DAO")
public class McmCmnUsr002DAO extends EgovAbstractDAO {

	
	/**
	 * 조합원 목록 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectUsrList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectUsrList", mcmCmnUsr002VO);
	}
	
	/**
	 * 조합웝 목록 건수 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrListTotCnt(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return (Integer)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectUsrListTotCnt", mcmCmnUsr002VO);
	}
	
	/**
	 * 조합원 정보 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return (Map)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectUsrInfo", mcmCmnUsr002VO); 
	}
	
	/**
	 * 사용자 정보 등록
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.insertUsrInfo", mcmCmnUsr002VO);
	}
	
	/**
	 * 사용자 권한 등록
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrDefaultAth(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.insertUsrDefaultAth", mcmCmnUsr002VO);
	}
	
	/**
	 * 상점별 사용자 등록
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public String insertUsrStrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.insertUsrStrInfo", mcmCmnUsr002VO);
	}
	
	
	/**
	 * 조합원정보 수정
	 * @param mcmCmnUsr002VO
	 * @throws Exception
	 */
	public void updateUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.updateUsrInfo", mcmCmnUsr002VO);
	}
	
	
	/**
	 * 조합원 정보 삭제
	 * @param mcmCmnUsr002VO
	 * @throws Exception
	 */
	public void deleteUsrInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.deleteUsrInfo", mcmCmnUsr002VO);
	}

	/**
	 * 중복아이디 확인
	 * @param usrId
	 * @return
	 * @throws Exception
	 */
	public String selectExistsId(String usrId) throws Exception{
		return (String)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectExistsId", usrId);
	}
	
	/**
	 * 조합원가입신청 목록 조회
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectUsrAppList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectUsrAppList", mcmCmnUsr002VO);
	}
	
	/**
	 * 조합원가입신청 목록 조회 건수
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public int selectUsrAppListTotCnt(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return (Integer)select("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectUsrAppListTotCnt", mcmCmnUsr002VO);
	}
	
	/**
	 * 조합원 가입신청 승인
	 * @param mcmCmnUsr002VO
	 * @throws Exception
	 */
	public void updateUsAppInfo(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.updateUsAppInfo", mcmCmnUsr002VO);
	}
	
	/**
	 * 코드 분류
	 * @param mcmCmnUsr002VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAthCdList(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectAthCdList", mcmCmnUsr002VO);
	}
	
	/**
	 * 조합원 엑셀다운로드
	 * @param mcmCmnUsr003VO
	 * @throws Exception
	 */
	public List<?> selectUsrExcelList(McmCmnUsr002VO mcmCmnUsr003VO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.selectUsrExcelList",mcmCmnUsr003VO);
	}
	
	// 승인시 권한코드부여
	public String insertUsrAth(McmCmnUsr002VO mcmCmnUsr002VO) throws Exception {
		return (String) insert("kr.co.mcmall.mcm.cmn.usr.McmCmnUsr002.insertUsrAth",mcmCmnUsr002VO);
	}

	

}
