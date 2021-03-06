package com.icloud.framework.aop;

import java.util.Random;

import com.icloud.framework.aop.TransactionalRetryAnnotation;

public class TransactionalBean {
	@TransactionalRetryAnnotation
	public void transactionalOp() throws com.ibatis.common.jdbc.exception.NestedSQLException{
		System.out.println("begin");
		Random rand = new Random();
		if(rand.nextInt(5) < 5)
			throw new com.ibatis.common.jdbc.exception.NestedSQLException("exception");
		System.out.println("end");
	}
}
