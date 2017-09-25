package kr.co.mcmall.mcm.tpl.tpl.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mcmall.mcm.tpl.tpl.service.McmTplTpl001Service;
import kr.co.mcmall.mcm.tpl.tpl.service.McmTplTpl001VO;

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

@Service("mcmTplTpl001Service")
public class McmTplTpl001ServiceImpl extends EgovAbstractServiceImpl implements McmTplTpl001Service {

	/** DAO 선언 */
	@Resource(name = "mcmTplTpl001DAO")
	private McmTplTpl001DAO mcmTplTpl001DAO;

	
	
	/**
	 * 목록조회
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectTemplatetList(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return mcmTplTpl001DAO.selectTemplatetList(mcmTplTpl001VO);
	}

	/**
	 * 목록 갯수 조회 
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectTemplatetListTotCnt(McmTplTpl001VO mcmTplTpl001VO){
		return mcmTplTpl001DAO.selectTemplatetListTotCnt(mcmTplTpl001VO);
	}
	

	/**
	 * 상세내용을 조회한다.
	 * @param mcmTplTpl001VO - 조회할 정보가 담긴 mcmTplTpl001VO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return mcmTplTpl001DAO.selectTemplatetInfo(mcmTplTpl001VO);
	}

	
	/**
	 * 정보을 등록한다.
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	public String insertTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return mcmTplTpl001DAO.insertTemplatetInfo(mcmTplTpl001VO);
	}
	
	/**
	 * 정보를 수정한다.
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	public void updateTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		mcmTplTpl001DAO.updateTemplatetInfo(mcmTplTpl001VO);
	}
	
	/**
	 * 정보를 삭제한다.
	 * @param mcmTplTpl001VO
	 * @return
	 * @throws Exception
	 */
	public int deleteTemplatetInfo(McmTplTpl001VO mcmTplTpl001VO) throws Exception{
		return mcmTplTpl001DAO.deleteTemplatetInfo(mcmTplTpl001VO);
	}
	
	

}
