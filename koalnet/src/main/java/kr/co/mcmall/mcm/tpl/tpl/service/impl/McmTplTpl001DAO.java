package kr.co.mcmall.mcm.tpl.tpl.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.tpl.tpl.service.McmTplTpl001VO;

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

@Repository("mcmTplTpl001DAO")
public class McmTplTpl001DAO extends EgovAbstractDAO {

	
	/**
	 *  목록을 조회한다.
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectTemplatetList(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return list("kr.co.mcmall.mcm.tpl.tpl.McmTplTpl001.selectTemplatetList", mcmTplTpl001VO);
	}

	/**
	 *  목록 갯수를 조회한다. 
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectTemplatetListTotCnt(McmTplTpl001VO mcmTplTpl001VO){
		return (Integer)select("kr.co.mcmall.mcm.tpl.tpl.McmTplTpl001.selectTemplatetListTotCnt", mcmTplTpl001VO);
	}
	

	/**
	 *  상세내용을 조회한다.
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 mcmTplTpl001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return (Map<?, ?>)select("kr.co.mcmall.mcm.tpl.tpl.McmTplTpl001.selectTemplatetInfo", mcmTplTpl001VO);
	}

	
	/**
	 *  정보을 등록한다.
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	public String insertTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return (String)insert("kr.co.mcmall.mcm.tpl.tpl.McmTplTpl001.insertTemplatetInfo", mcmTplTpl001VO);
	}
	
	/**
	 *  정보를 수정한다.
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	public void updateTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		update("kr.co.mcmall.mcm.tpl.tpl.McmTplTpl001.updateTemplatetInfo", mcmTplTpl001VO);
	}
	
	/**
	 *  정보를 삭제한다.
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	public int deleteTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return delete("kr.co.mcmall.mcm.tpl.tpl.McmTplTpl001.deleteTemplatetInfo", mcmTplTpl001VO);
	}
	
	
	

}
