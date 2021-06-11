package com.krutika.domain;

public class Student {
	public Student(String sname, int sno, String sadd) {
		super();
		this.sname = sname;
		this.sno = sno;
		this.sadd = sadd;
	}
	private  String sname;
	private  int sno;
	private  String sadd;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	@Override
	public String toString() {
		return "Student Details\n-------- \nName:" + sname + ",\nNo: " + sno + ",\nAddress: " + sadd + "\n--------";
	}
	
	
	
}
