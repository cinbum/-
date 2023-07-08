package spring.camp.mall.namecard;


// VO(Value Object)
public class NameCardVO {
	private String ncrdId;
	private String ncrdTrgterId;
	private String ncrdNm;
	private String telNo;
	private String nationNo;
	private String areaNo;
	private String middleTelno;
	private String endTelno;
	private String mbtlNum;
	private String idntfcNo;
	private String middleMbtlNum;
	private String endMbtlNum;
	private String emailAdres;
	private String cmpnyNm;
	private String deptNm;
	private String adres;
	private String detailAdres;
	private String ofcpsNm;
	private String clsfNm;
	private String extrlUserAt;
	private String othbcAt;
	private String rm;
	private String frstRegistPnttm;
	private String frstRegisterId;
	private String lastUpdtPnttm;
	private String lastUpdusrId;
	
	// VO의 getter()와 setter() 메소드를 생성 
	public String getAreaNo() { 	return areaNo;    } 
	public String getClsfNm() { 	return clsfNm;    } 
	public String getCmpnyNm() {	return cmpnyNm;	}
	public String getDeptNm() {	return deptNm;	}
	public String getEmailAdres() { 	return emailAdres;    } 
	public String getEndMbtlNum() { 	return endMbtlNum;    } 
	public String getEndTelno() { 	return endTelno;    } 
	public String getExtrlUserAt() { 	return extrlUserAt;    } 
	public String getFrstRegisterId() {	return frstRegisterId;	}
	public String getFrstRegisterPnttm() {	return frstRegistPnttm;	}
	public String getIdntfcNo() { 	return idntfcNo;    } 
	public String getMiddleMbtlNum() { 	return middleMbtlNum;    } 
	public String getMiddleTelno() { 	return middleTelno;    } 
	public String getNcrdId() {	return ncrdId;    }
	public String getNcrdNm() {	return ncrdNm;	}
	public String getOfcpsNm() { 	return ofcpsNm;    } 
	public String getOthbcAt() { 	return othbcAt;    } 



	public void setAreaNo(String areaNo) {	this.areaNo = areaNo;    }
	public void setClsfNm(String clsfNm) {	this.clsfNm = clsfNm;    }
	public void setCmpnyNm(String cmpnyNm) {	this.cmpnyNm = cmpnyNm;	}
	public void setDeptNm(String deptNm) {	this.deptNm = deptNm;	}
	public void setEmailAdres(String emailAdres) {	this.emailAdres = emailAdres;    }
	public void setEndMbtlNum(String endMbtlNum) {	this.endMbtlNum = endMbtlNum;    }
	public void setEndTelno(String endTelno) {	this.endTelno = endTelno;    }
	public void setExtrlUserAt(String extrlUserAt) {	this.extrlUserAt = extrlUserAt;    }
	public void setFrstRegisterId(String frstRegisterId) {	this.frstRegisterId = frstRegisterId;	}
	public void setFrstRegisterPnttm(String frstRegisterPnttm) {	this.frstRegistPnttm = frstRegisterPnttm;	}
	public void setIdntfcNo(String idntfcNo) {	this.idntfcNo = idntfcNo;    }
	public void setMiddleMbtlNum(String middleMbtlNum) {	this.middleMbtlNum = middleMbtlNum;    }
	public void setMiddleTelno(String middleTelno) {	this.middleTelno = middleTelno;    }
	public void setNcrdId(String ncrdId) {	this.ncrdId = ncrdId;    }
	public void setNcrdNm(String ncrdNm) {	this.ncrdNm = ncrdNm;	}
	public void setOfcpsNm(String ofcpsNm) {	this.ofcpsNm = ofcpsNm;    }
	public void setOthbcAt(String othbcAt) {	this.othbcAt = othbcAt;    }
}
