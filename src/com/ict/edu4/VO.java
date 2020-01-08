package com.ict.edu4;

import java.io.Serializable;

public class VO implements Serializable{

	public static final long serivalVersionUID = 12345L;
	private String msg;
	private int no;
	
	
	public VO() {

	}


	public VO( int no, String msg) {
		super();
		this.msg = msg;
		this.no = no;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public static long getSerivalversionuid() {
		return serivalVersionUID;
	}
	
	
}
