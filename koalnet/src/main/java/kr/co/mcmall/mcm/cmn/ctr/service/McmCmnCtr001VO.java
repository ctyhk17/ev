package kr.co.mcmall.mcm.cmn.ctr.service;

import kr.co.mcmall.cmn.service.CommonVO;

public class McmCmnCtr001VO extends CommonVO{

	private String cd;
	private String cdNm;
	private String cdGrpId;
	private String cdGrpNm;
	private String cdGrpCnts;
	private String cdEtc;
	private String lstUdtId;
	private String lstUdtIp;
	private String gdsCtgrId;
	
	
	private String stDtSearch;
	private String endDtSearch;
	private String ctrSearch;
	private String cdNmSearch;
	private String[] checkCtr;
	
	
	
	
	
	
	public String getGdsCtgrId() {
		return gdsCtgrId;
	}
	public void setGdsCtgrId(String gdsCtgrId) {
		this.gdsCtgrId = gdsCtgrId;
	}
	public String[] getCheckCtr() {
		return checkCtr;
	}
	public void setCheckCtr(String[] checkCtr) {
		this.checkCtr = checkCtr;
	}
	public String getLstUdtId() {
		return lstUdtId;
	}
	public void setLstUdtId(String lstUdtId) {
		this.lstUdtId = lstUdtId;
	}
	public String getLstUdtIp() {
		return lstUdtIp;
	}
	public void setLstUdtIp(String lstUdtIp) {
		this.lstUdtIp = lstUdtIp;
	}
	public String getCdEtc() {
		return cdEtc;
	}
	public void setCdEtc(String cdEtc) {
		this.cdEtc = cdEtc;
	}
	public String getCdGrpNm() {
		return cdGrpNm;
	}
	public void setCdGrpNm(String cdGrpNm) {
		this.cdGrpNm = cdGrpNm;
	}
	public String getCdGrpCnts() {
		return cdGrpCnts;
	}
	public void setCdGrpCnts(String cdGrpCnts) {
		this.cdGrpCnts = cdGrpCnts;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getCdNm() {
		return cdNm;
	}
	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}
	public String getCdGrpId() {
		return cdGrpId;
	}
	public void setCdGrpId(String cdGrpId) {
		this.cdGrpId = cdGrpId;
	}
	public String getCtrSearch() {
		return ctrSearch;
	}
	public void setCtrSearch(String ctrSearch) {
		this.ctrSearch = ctrSearch;
	}
	public String getCdNmSearch() {
		return cdNmSearch;
	}
	public void setCdNmSearch(String cdNmSearch) {
		this.cdNmSearch = cdNmSearch;
	}
	public String getStDtSearch() {
		return stDtSearch;
	}
	public void setStDtSearch(String stDtSearch) {
		this.stDtSearch = stDtSearch;
	}
	public String getEndDtSearch() {
		return endDtSearch;
	}
	public void setEndDtSearch(String endDtSearch) {
		this.endDtSearch = endDtSearch;
	}
	
}
