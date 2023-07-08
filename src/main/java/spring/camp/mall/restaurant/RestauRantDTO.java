package spring.camp.mall.restaurant;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RestauRantDTO {
  
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
	
	private String searchCnd;
	private String searchWrd;
	
	private int firstIndex = 15;
	private int lastIndex = 1;
	private int pageIndex = 1;
	private int pageSize = 10;
	private int pageUnit = 10;
	private int recordCountPerpage = 0;
	
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
	
	public String getSearchCnd() {return searchCnd;}
	public String getSearchWrd() {return searchWrd;}
	
	public int getFirstIndex() {return firstIndex; }
	public int getLastIndex() {return lastIndex; }
	public int getPageIndex() {return pageIndex; }
	public int getPageSize() {return pageSize; }
	public int getPageUnit() {return pageUnit; }
	public int getRecordCountPerpage() {return recordCountPerpage; }
	
	
	
	
	public void setrNum(String rNum) {	this.rNum = rNum;    }
	public void setrType(String rType) {	this.rType = rType;    }
	public void setrName(String rName) {	this.rName = rName;	}
	public void setrAddr(String rAddr) {	this.rAddr = rAddr;	}
	public void setrAddr2(String rAddr2) {	this.rAddr2 = rAddr2;	}
	public void setrPhone(String rPhone) {	this.rPhone = rPhone;    }
	public void setrMenu(String rMenu) {	this.rMenu = rMenu;    }
	public void setrMenu2(String rMenu2) {	this.rMenu = rMenu2;    }
	public void setrPric(String rPric) {	this.rPric = rPric;    }
	public void setrPric2(String rPric2) {	this.rPric = rPric2;    }
	public void setrVisit(String rVisit) {	this.rVisit = rVisit;    }
	public void setrGrade(String rGrade) {	this.rGrade = rGrade;	}
	public void setrNote(String rNote) {	this.rNote = rNote;	}
	public void setfileName(String fileName) {	this.fileName = fileName;	}
	public void setfilePath(String filePath) {	this.filePath = filePath;	}
	
	
	public void setSearchCnd(String searchCnd) {this.searchCnd = searchCnd;}
	public void setSearchWrd(String searchWrd) {this.searchWrd = searchWrd;}
	
	public void setFirstIndex(int firstIndex) {this.firstIndex = firstIndex; }
	public void setLastIndex(int lastIndex) {this.lastIndex = lastIndex; }
	public void setPageIndex(int pageIndex) {this.pageIndex= pageIndex; }
	public void setPageSize(int pageSize) {this.pageSize = pageSize; }
	public void setPageUnit(int pageUnit) {this.pageUnit = pageUnit; }
	public void setRecordCountPerpage(int recordCountPerpage) 
	{this.recordCountPerpage = recordCountPerpage; }
	
	
	
	@Override
	public String toString() {return ToStringBuilder.reflectionToString(this);}
	
}
