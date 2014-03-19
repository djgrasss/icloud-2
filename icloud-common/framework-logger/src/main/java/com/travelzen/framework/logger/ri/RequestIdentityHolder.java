package com.travelzen.framework.logger.ri;


public class RequestIdentityHolder {

	private static ThreadLocal<String> holder = new ThreadLocal<>();

	public static String get() {
		return holder.get();
	}

	public static void set(String ri) {
		holder.set(ri);
	}

	public static void remove() {
		holder.remove();
	}

}
