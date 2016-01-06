package com.qd.ftkj.website.result;

public class BaseResult {
	public static final int RESCODE_SUCCESS = 100;
	public static final int RESCODE_FAIL = 101;
	public static final int RESCODE_SESSION_FAIL = 102;
	public static final int RESCODE_PARAM_FAIL = 103;

	public static final String RESULT_SUCCESS = "true";
	public static final String RESULT_FAIL = "false";

	public String result = RESULT_SUCCESS;
	protected int rescode = RESCODE_SUCCESS;
	protected String msg;
	protected String success = RESULT_SUCCESS;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
		setSuccess(result);
	}

	public int getRescode() {
		return rescode;
	}

	public void setRescode(int rescode) {
		this.rescode = rescode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

}
