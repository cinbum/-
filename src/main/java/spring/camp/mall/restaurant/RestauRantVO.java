package spring.camp.mall.restaurant;

import org.apache.commons.lang3.builder.ToStringBuilder;

// VO(Value Object)
public class RestauRantVO {
	private String rNum;
	private String rType;
	private String rName;
	private String rAddr;
	private String rAddr2;
	private String rPhone;
	private String rMenu;
	private String rMenu2;
	private String rPric;
	private String rPric2;
	private String rVisit;
	private String rGrade;
	private String rNote;
	private String fileName;
	private String filePath;

	// VO의 getter()와 setter() 메소드를 생성 
	public String getrNum() { 	return rNum;    } 
	public String getrType() { 	return rType;    } 
	public String getrName() {	return rName;	}
	public String getrAddr() {	return rAddr;	}
	public String getrAddr2() {	return rAddr2;	}
	public String getrPhone() { 	return rPhone;    } 
	public String getrMenu() { 	return rMenu;    } 
	public String getrMenu2() { 	return rMenu2;    } 
	public String getrPric() { 	return rPric;    } 
	public String getrPric2() { 	return rPric2;    } 
	public String getrVisit() { 	return rVisit;    } 
	public String getrGrade() {	return rGrade;	}
	public String getrNote() {	return rNote;	}
	public String getfileName() {	return fileName; }
	public String getfilePath() {	return filePath;}



	public void setrNum(String rNum) {	this.rNum = rNum;    }
	public void setrType(String rType) {	this.rType = rType;    }
	public void setrName(String rName) {	this.rName = rName;	}
	public void setrAddr(String rAddr) {	this.rAddr = rAddr;	}
	public void setrAddr2(String rAddr2) {	this.rAddr2 = rAddr2;	}
	public void setrPhone(String rPhone) {	this.rPhone = rPhone;    }
	public void setrMenu(String rMenu) {	this.rMenu = rMenu;    }
	public void setrMenu2(String rMenu2) {	this.rMenu2 = rMenu2;    }
	public void setrPric(String rPric) {	this.rPric = rPric;    }
	public void setrPric2(String rPric2) {	this.rPric2 = rPric2;    }
	public void setrVisit(String rVisit) {	this.rVisit = rVisit;    }
	public void setrGrade(String rGrade) {	this.rGrade = rGrade;	}
	public void setrNote(String rNote) {	this.rNote = rNote;	}
	public void setfileName(String fileName) {	this.fileName = fileName;	}
	public void setfilePath(String filePath) {	this.filePath = filePath;	}	
	
	@Override
	public String toString() {return ToStringBuilder.reflectionToString(this);}
	
}