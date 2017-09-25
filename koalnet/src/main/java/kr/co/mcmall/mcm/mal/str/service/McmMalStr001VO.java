package kr.co.mcmall.mcm.mal.str.service;

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

public class McmMalStr001VO extends CommonVO {

	private String[] searchValArr = null;  // 검색조건_배열
	
	
	private String[] valArr           = null  ;    // 대상
	
	private String id;
	private String name;
	private String cnts;
	
	private String strCnts;
	private String strDm;
	private String strNm;
	
	private String strId2;
	
	private String searchStrId;
    private String strPhnCnts;
	private String strPhnVal;
	private String strEmailCnts;
	private String strEmailVal;
	private String strFaxCnts;
	private String strFaxVal;
	private String strBankCnts;
	private String strBankVal;
	private String strAccCnts;
	private String strAccVal;
    private String strAccnmCnts;
	private String strAccnmVal;
	
	
	
	public String getStrPhnCnts() {
		return strPhnCnts;
	}

	public void setStrPhnCnts(String strPhnCnts) {
		this.strPhnCnts = strPhnCnts;
	}

	public String getStrPhnVal() {
		return strPhnVal;
	}

	public void setStrPhnVal(String strPhnVal) {
		this.strPhnVal = strPhnVal;
	}

	public String getStrEmailCnts() {
		return strEmailCnts;
	}

	public void setStrEmailCnts(String strEmailCnts) {
		this.strEmailCnts = strEmailCnts;
	}

	public String getStrEmailVal() {
		return strEmailVal;
	}

	public void setStrEmailVal(String strEmailVal) {
		this.strEmailVal = strEmailVal;
	}

	public String getStrFaxCnts() {
		return strFaxCnts;
	}

	public void setStrFaxCnts(String strFaxCnts) {
		this.strFaxCnts = strFaxCnts;
	}

	public String getStrFaxVal() {
		return strFaxVal;
	}

	public void setStrFaxVal(String strFaxVal) {
		this.strFaxVal = strFaxVal;
	}

	public String getStrBankCnts() {
		return strBankCnts;
	}

	public void setStrBankCnts(String strBankCnts) {
		this.strBankCnts = strBankCnts;
	}

	public String getStrBankVal() {
		return strBankVal;
	}

	public void setStrBankVal(String strBankVal) {
		this.strBankVal = strBankVal;
	}

	public String getStrAccCnts() {
		return strAccCnts;
	}

	public void setStrAccCnts(String strAccCnts) {
		this.strAccCnts = strAccCnts;
	}

	public String getStrAccVal() {
		return strAccVal;
	}

	public void setStrAccVal(String strAccVal) {
		this.strAccVal = strAccVal;
	}

	public String getStrAccnmCnts() {
		return strAccnmCnts;
	}

	public void setStrAccnmCnts(String strAccnmCnts) {
		this.strAccnmCnts = strAccnmCnts;
	}

	public String getStrAccnmVal() {
		return strAccnmVal;
	}

	public void setStrAccnmVal(String strAccnmVal) {
		this.strAccnmVal = strAccnmVal;
	}

	public String getStrId2() {
		return strId2;
	}

	public void setStrId2(String strId2) {
		this.strId2 = strId2;
	}

	public String getSearchStrId() {
		return searchStrId;
	}

	public void setSearchStrId(String searchStrId) {
		this.searchStrId = searchStrId;
	}

	public String getStrCnts() {
		return strCnts;
	}

	public void setStrCnts(String strCnts) {
		this.strCnts = strCnts;
	}

	public String getStrDm() {
		return strDm;
	}

	public void setStrDm(String strDm) {
		this.strDm = strDm;
	}

	public String getStrNm() {
		return strNm;
	}

	public void setStrNm(String strNm) {
		this.strNm = strNm;
	}

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
