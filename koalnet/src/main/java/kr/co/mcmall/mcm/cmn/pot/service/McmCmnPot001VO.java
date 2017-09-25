package kr.co.mcmall.mcm.cmn.pot.service;

import kr.co.mcmall.cmn.service.CommonVO;

public class McmCmnPot001VO extends CommonVO {
	
	//포인트 상세
	private String strId;
	private String usrId;
	private String potNo;
	private String ordNo;
	private String potCd;
	private String potSv;
	private String potYn;
	private String potNm;
	private String scUsrId;
	private String scUsrNm;
	private String scStrId;
	
	

	//포인트 합계
	private int potTotSum;
	private String athCd;
	
	//상세페이지 검색
	private String scStLstUdtDt;
	private String scEdLstUdtDt;
	
	private String[] checkPotNo;
	

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getPotNo() {
		return potNo;
	}

	public void setPotNo(String potNo) {
		this.potNo = potNo;
	}

	public String getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	
	public String getPotNm() {
		return potNm;
	}

	public void setPotNm(String potNm) {
		this.potNm = potNm;
	}
	
	public String getPotCd() {
		return potCd;
	}

	public void setPotCd(String potCd) {
		this.potCd = potCd;
	}

	public String getPotSv() {
		return potSv;
	}

	public void setPotSv(String potSv) {
		this.potSv = potSv;
	}

	public String getPotYn() {
		return potYn;
	}

	public void setPotYn(String potYn) {
		this.potYn = potYn;
	}

	public int getPotTotSum() {
		return potTotSum;
	}

	public void setPotTotSum(int potTotSum) {
		this.potTotSum = potTotSum;
	}
	
	public String getAthCd() {
		return athCd;
	}

	public void setAthCd(String athCd) {
		this.athCd = athCd;
	}

	public String getScUsrId() {
		return scUsrId;
	}

	public void setScUsrId(String scUsrId) {
		this.scUsrId = scUsrId;
	}

	public String getScUsrNm() {
		return scUsrNm;
	}

	public void setScUsrNm(String scUsrNm) {
		this.scUsrNm = scUsrNm;
	}

	public String getScStrId() {
		return scStrId;
	}

	public void setScStrId(String scStrId) {
		this.scStrId = scStrId;
	}

	public String getScStLstUdtDt() {
		return scStLstUdtDt;
	}

	public void setScStLstUdtDt(String scStLstUdtDt) {
		this.scStLstUdtDt = scStLstUdtDt;
	}

	public String getScEdLstUdtDt() {
		return scEdLstUdtDt;
	}

	public void setScEdLstUdtDt(String scEdLstUdtDt) {
		this.scEdLstUdtDt = scEdLstUdtDt;
	}

	public String[] getCheckPotNo() {
		return checkPotNo;
	}

	public void setCheckPotNo(String[] checkPotNo) {
		this.checkPotNo = checkPotNo;
	}
	
	
	
	

}
