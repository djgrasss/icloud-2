package com.icloud.framework.core.exception;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.icloud.framework.core.common.ReturnCode;

/**
 * instance 函数构造的 BizException 中 设置的是 retMsg 成员变量 BizException 构造函数中的 Object
 * 数组设置的是 objects 成员变量
 */

public class ICloudException extends RuntimeException {

	private static final long serialVersionUID = 430305575267731710L;
	private String retMsg = "";
	private ReturnCode retCode;
	private Object[] objects;

	public static ICloudException instance(String retMsg) {
		return new ICloudException(ReturnCode.ERROR, retMsg);
	}

	public static ICloudException instance(ReturnCode retCode) {
		return new ICloudException(retCode);
	}

	public static ICloudException instance(ReturnCode retCode, String retMsg) {
		return new ICloudException(retCode, retMsg);
	}

	public static ICloudException instance(ReturnCode retCode, String retMsg,
			Throwable thr) {
		return new ICloudException(retCode, retMsg, thr);
	}

	public ICloudException(Throwable thr, Object... objects) {
		this(ReturnCode.ERROR, "", thr, objects);
	}

	public ICloudException(ReturnCode retCode, Throwable thr, Object... objects) {
		this(retCode, "", thr, objects);
	}

	public ICloudException(ReturnCode retCode, String retMsg, Throwable thr,
			Object... objects) {
		super(String.format("[retCode=%s,retMsg=%s]", retCode.getErrorCode(),
				retMsg));
		this.retCode = retCode;
		this.objects = objects;
		this.retMsg = retMsg;
		this.initCause(thr);
	}

	public ICloudException(Object... objects) {
		this(ReturnCode.ERROR, "", objects);
	}

	public ICloudException(ReturnCode retCode, Object... objects) {
		this(retCode, "", objects);
	}

	public ICloudException(ReturnCode retCode, String retMsg, Object... objects) {
		super(String.format("[retCode=%s,retMsg=%s]", retCode.getErrorCode(),
				retMsg));
		this.retCode = retCode;
		this.objects = objects;
		this.retMsg = retMsg;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public ReturnCode getRetCode() {
		return retCode;
	}

	@Override
	public String toString() {
		return String.format("[retCode=%s,retMsg=%s]", retCode.getErrorCode(),
				retMsg);
	}

	@Override
	public String getMessage() {
		return String.format("[retCode=%s,retMsg=%s, objects=%s]",
				this.retCode, this.retMsg, Arrays.deepToString(objects));
	}

	public String getMessage(String format, String separator) {
		return String.format(format, StringUtils.join(objects, separator));
	}

	public String getMessage(String format) {
		return String.format(format, objects);
	}

	/**
	 * 从thr中提取BizException,若提取不到返回thr
	 *
	 * @param thr
	 * @return
	 */
	public static Exception unwrap(Exception e) {
		Throwable cause = e.getCause();
		if (cause != null && cause instanceof ICloudException)
			return (Exception) cause;
		return e;
	}

	/**
	 * 获取原始的消息
	 *
	 * @param e
	 * @return
	 */
	public static String getRawMsg(Exception e) {
		if (e == null)
			return null;
		e = unwrap(e);
		if (e instanceof ICloudException) {
			ICloudException bizException = (ICloudException) e;
			return bizException.getRetMsg();
		} else
			return e.getMessage();
	}
}
