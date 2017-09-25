package kr.co.mcmall.mcm.tpl.tpl.service;

import kr.co.mcmall.cmn.service.CommonVO;


/**
 * @Class Name : FundTpltVO.java
 * @Description : FundTpltVO VO Class
 *                매칭펀드 템플릿 VO
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

public class McmTplTpl001VO extends CommonVO {

	private String[] searchValArr = null;  // 검색조건_배열
	
	
	private String[] valArr           = null  ;    // 대상
	
	private String id;
	private String name;
	private String cnts;
	
	
	

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnts() {
		return cnts;
	}

	public void setCnts(String cnts) {
		this.cnts = cnts;
	}

	public String[] getSearchValArr() {
		
		String[] ret = null; 
		
		if ( this.searchValArr != null ) { 
			
			ret = new String[searchValArr.length]; 
		    for (int i = 0; i < searchValArr.length; i++) 
		    { 
		    	ret[i] = this.searchValArr[i]; 
		    } 
		} 

		return ret;
		  
	}

	public void setSearchValArr(String[] searchValArr) {
		
		this.searchValArr = new String[searchValArr.length]; 
		for (int i = 0; i < searchValArr.length; ++i)
		{
			this.searchValArr[i] = searchValArr[i]; 
		}

	}

	public String[] getValArr() {
		String[] ret = null; 
		
		if ( this.valArr != null ) { 
			
			ret = new String[valArr.length]; 
		    for (int i = 0; i < valArr.length; i++) 
		    { 
		    	ret[i] = this.valArr[i]; 
		    } 
		} 

		return ret;
	}

	public void setValArr(String[] valArr) {
		this.valArr = new String[valArr.length]; 
		for (int i = 0; i < valArr.length; ++i)
		{
			this.valArr[i] = valArr[i]; 
		}
	}
	
	
	
	
}
