
package kr.co.mcmall.mcm.mal.itr.service;

import kr.co.mcmall.cmn.service.CommonVO;



/**
 * @Class Name : McmShpOrd001VO.java
 * @Description : McmShpOrd001VO Class
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
public class McmMalItr001VO extends CommonVO {
	

	private String gdsId;
	private String ordDivCd = "BEST";
	private String searchKeyword;
	
	private String searchCtgrCd;
	
	
	
	
	
	
	

	public String getSearchCtgrCd() {
		return searchCtgrCd;
	}

	public void setSearchCtgrCd(String searchCtgrCd) {
		this.searchCtgrCd = searchCtgrCd;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getOrdDivCd() {
		return ordDivCd;
	}

	public void setOrdDivCd(String ordDivCd) {
		this.ordDivCd = ordDivCd;
	}

	public String getGdsId() {
		return gdsId;
	}

	public void setGdsId(String gdsId) {
		this.gdsId = gdsId;
	}
	
	
	
		
}
