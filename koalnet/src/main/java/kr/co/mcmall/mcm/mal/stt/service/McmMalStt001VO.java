package kr.co.mcmall.mcm.mal.stt.service;

import java.sql.Timestamp;

import kr.co.mcmall.cmn.service.CommonVO;

/**
 * @Class Name : McmMalBiz001VO.java
 * @author : 신현민
 * @since : 2017. 6. 20.
 * @Description : 사업자 관리 VO
 *
 */
public class McmMalStt001VO extends CommonVO  {

	   private String ordNo;
	   private String strId;
	   private String usrId;
	   private String lcsId;
	   private String gdsId;
	   private String ordTotAmt;
	   private String ordDt;
	   private String searchOrdDt; 
	   private String searchOrdDtTo;
	   private String gdsNm;
	   private String ordTotAmtNo;
	   private String cntNo;
	   private String ordTotAmtOk;
	   private String cntOk;
	   private String ordTotAmtall;
	   private String cntAll;
	   private String ordCnt;
	   private String ordAmt;
		private String seqNo;                // 홍보물순번
		private String itrCnts;              // 인사말
		private String brcUrlAddr;           // 홍보URL주소
		private String note;                 // 해당 홍보물에 대한 메모 
		private String lstUdtId;             // 최종수정자ID
	    private Timestamp lstUdtDt;          // 최종수정일자
	    private String lstUdtIp;             // 최종수정자IP
	    private String searchLcsId;
	    private String searchGdsId;
	    private String searchStrId;
	    private String searchUsrNm;
	    private String strCnts;
	    private String strDm;
	    private String strNm;
	    private String searchUsrId;
	   private String telNo;
	   private String emailAddr;
	   private String usrNm;
	   
	   
	   
	   
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getTelNo() {
		return telNo;
	}
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	public String getSeqNo() {
			return seqNo;
		}
		public void setSeqNo(String seqNo) {
			this.seqNo = seqNo;
		}
		public String getItrCnts() {
			return itrCnts;
		}
		public void setItrCnts(String itrCnts) {
			this.itrCnts = itrCnts;
		}
		public String getBrcUrlAddr() {
			return brcUrlAddr;
		}
		public void setBrcUrlAddr(String brcUrlAddr) {
			this.brcUrlAddr = brcUrlAddr;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public String getLstUdtId() {
			return lstUdtId;
		}
		public void setLstUdtId(String lstUdtId) {
			this.lstUdtId = lstUdtId;
		}
		public Timestamp getLstUdtDt() {
			return lstUdtDt;
		}
		public void setLstUdtDt(Timestamp lstUdtDt) {
			this.lstUdtDt = lstUdtDt;
		}
		public String getLstUdtIp() {
			return lstUdtIp;
		}
		public void setLstUdtIp(String lstUdtIp) {
			this.lstUdtIp = lstUdtIp;
		}
		public String getSearchLcsId() {
			return searchLcsId;
		}
		public void setSearchLcsId(String searchLcsId) {
			this.searchLcsId = searchLcsId;
		}
		public String getSearchGdsId() {
			return searchGdsId;
		}
		public void setSearchGdsId(String searchGdsId) {
			this.searchGdsId = searchGdsId;
		}
		public String getSearchStrId() {
			return searchStrId;
		}
		public void setSearchStrId(String searchStrId) {
			this.searchStrId = searchStrId;
		}
		public String getSearchUsrNm() {
			return searchUsrNm;
		}
		public void setSearchUsrNm(String searchUsrNm) {
			this.searchUsrNm = searchUsrNm;
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
		public String getSearchUsrId() {
			return searchUsrId;
		}
		public void setSearchUsrId(String searchUsrId) {
			this.searchUsrId = searchUsrId;
		}
	public String getGdsNm() {
		return gdsNm;
	}
	public void setGdsNm(String gdsNm) {
		this.gdsNm = gdsNm;
	}
	public String getOrdTotAmtNo() {
		return ordTotAmtNo;
	}
	public void setOrdTotAmtNo(String ordTotAmtNo) {
		this.ordTotAmtNo = ordTotAmtNo;
	}
	public String getCntNo() {
		return cntNo;
	}
	public void setCntNo(String cntNo) {
		this.cntNo = cntNo;
	}
	public String getOrdTotAmtOk() {
		return ordTotAmtOk;
	}
	public void setOrdTotAmtOk(String ordTotAmtOk) {
		this.ordTotAmtOk = ordTotAmtOk;
	}
	public String getCntOk() {
		return cntOk;
	}
	public void setCntOk(String cntOk) {
		this.cntOk = cntOk;
	}
	public String getOrdTotAmtall() {
		return ordTotAmtall;
	}
	public void setOrdTotAmtall(String ordTotAmtall) {
		this.ordTotAmtall = ordTotAmtall;
	}
	public String getCntAll() {
		return cntAll;
	}
	public void setCntAll(String cntAll) {
		this.cntAll = cntAll;
	}
	public String getOrdCnt() {
		return ordCnt;
	}
	public void setOrdCnt(String ordCnt) {
		this.ordCnt = ordCnt;
	}
	public String getOrdAmt() {
		return ordAmt;
	}
	public void setOrdAmt(String ordAmt) {
		this.ordAmt = ordAmt;
	}
	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getStrId() {
		return strId;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getLcsId() {
		return lcsId;
	}
	public void setLcsId(String lcsId) {
		this.lcsId = lcsId;
	}
	public String getGdsId() {
		return gdsId;
	}
	public void setGdsId(String gdsId) {
		this.gdsId = gdsId;
	}
	public String getOrdTotAmt() {
		return ordTotAmt;
	}
	public void setOrdTotAmt(String ordTotAmt) {
		this.ordTotAmt = ordTotAmt;
	}
	public String getOrdDt() {
		return ordDt;
	}
	public void setOrdDt(String ordDt) {
		this.ordDt = ordDt;
	}
	public String getSearchOrdDt() {
		return searchOrdDt;
	}
	public void setSearchOrdDt(String searchOrdDt) {
		this.searchOrdDt = searchOrdDt;
	}
	public String getSearchOrdDtTo() {
		return searchOrdDtTo;
	}
	public void setSearchOrdDtTo(String searchOrdDtTo) {
		this.searchOrdDtTo = searchOrdDtTo;
	}
	@Override
	public String toString() {
		return "McmMalStt001VO [ordNo=" + ordNo + ", strId=" + strId
				+ ", usrId=" + usrId + ", lcsId=" + lcsId + ", gdsId=" + gdsId
				+ ", ordTotAmt=" + ordTotAmt + ", ordDt=" + ordDt
				+ ", searchOrdDt=" + searchOrdDt + ", searchOrdDtTo="
				+ searchOrdDtTo + "]";
	}
	   
	   
	   
}
