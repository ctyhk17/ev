package kr.co.mcmall.mcm.cmn.ath.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.cmn.ath.service.McmCmnAth002VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : FundTpltDAO.java
 * @Description : FundTpltDAO DAO Class
 *                템플릿 DAO 클래스
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

@Repository("mcmCmnAth001DAO")
public class McmCmnAth001DAO extends EgovAbstractDAO {

	
	/**
	 *  권한코드를 조회한다.
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectMcmCmnAth002M01List(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return list("kr.co.mcmall.mcm.cmn.ath.McmCmnAth001.selectMcmCmnAth002M01List", mcmCmnAth002VO);
	}

	/**
	 *  목록 갯수를 조회한다. 
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectTemplatetListTotCnt(McmCmnAth002VO mcmCmnAth002VO){
		return (Integer)select("kr.co.mcmall.mcm.cmn.ath.McmCmnAth001.selectTemplatetListTotCnt", mcmCmnAth002VO);
	}
	

	/**
	 *  상세내용을 조회한다.
	 * @param mcmCmnAth002VO - 조회할 정보가 담긴 mcmCmnAth002VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return (Map<?, ?>)select("kr.co.mcmall.mcm.cmn.ath.McmCmnAth001.selectTemplatetInfo", mcmCmnAth002VO);
	}

	
	/**
	 *  정보을 등록한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public String insertTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.cmn.ath.McmCmnAth001.insertTemplatetInfo", mcmCmnAth002VO);
	}
	
	/**
	 *  정보를 수정한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public void updateTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		update("kr.co.mcmall.mcm.cmn.ath.McmCmnAth001.updateTemplatetInfo", mcmCmnAth002VO);
	}
	
	/**
	 *  정보를 삭제한다.
	 * @param mcmCmnAth002VO
	 * @return
	 * @throws Exception
	 */
	public int deleteTemplatetInfo(McmCmnAth002VO mcmCmnAth002VO) throws Exception{
		return delete("kr.co.mcmall.mcm.cmn.ath.McmCmnAth001.deleteTemplatetInfo", mcmCmnAth002VO);
	}
	
	
	

}
