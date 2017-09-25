package kr.co.mcmall.mcm.mal.itr.service.impl;

import java.util.List;
import java.util.Map;

import kr.co.mcmall.mcm.mal.itr.service.McmMalItr001VO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : McmShpOrd001DAO.java
 * @Description : McmShpOrd001DAO DAO Class
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

@Repository("mcmMalItr001DAO")
public class McmMalItr001DAO extends EgovAbstractDAO {

	
	
	/**
	 * 상품목록 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectGdsList(McmMalItr001VO mcmMalItr001VO) throws Exception{
		return list("kr.co.mcmall.mcm.mal.itr.McmMalItr001.selectGdsList", mcmMalItr001VO);
	}
	
	/**
	 * 
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	public int selectGdsListTotCnt(McmMalItr001VO mcmMalItr001VO) throws Exception{
		return (Integer)select("kr.co.mcmall.mcm.mal.itr.McmMalItr001.selectGdsListTotCnt", mcmMalItr001VO);
	}
	
	/**
	 * 상점 설정 정보 조회
	 * @param mcmMalItr001VO
	 * @return
	 * @throws Exception
	 */
	public Map<?,?> selectStrInfo(McmMalItr001VO mcmMalItr001VO) throws Exception{
		return (Map<?,?>)select("kr.co.mcmall.mcm.mal.itr.McmMalItr001.selectStrInfo", mcmMalItr001VO);
	}
	
	/**
	 * 카테고리 목록 조회
	 * @return
	 * @throws Exception
	 */
	public List<?> selectCtgrList()  throws Exception{
		return list("kr.co.mcmall.mcm.mal.itr.McmMalItr001.selectCtgrList");
	}
	

}
