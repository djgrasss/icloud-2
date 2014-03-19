package com.travelzen.framework.thrift.client.balancing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WjThriftClient<I, C extends I> extends PooledClient<I> {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private boolean framed = false;
	private String host = null;
	private int port = -1;
	private long soTimeout;
	private String name;

	private int maxIdleConnections = 100;

	public WjThriftClient(String host, int port, boolean framed,
			long soTimeout, String name, Class<C> clazz) {
		super(clazz);
		this.host = host;
		this.port = port;
		this.framed = framed;
		this.soTimeout = soTimeout;
		this.name = name;
	}

	public WjThriftClient(String host, int port, boolean framed, Class<C> clazz) {
		this(host, port, framed, 5000, clazz.getName(), clazz);
	}

	public WjThriftClient(String host, int port, Class<C> clazz) {
		this(host, port, false, 5000, clazz.getName(), clazz);
	}

	@Override
	public ThriftConnection<I> createConnection() {
		try {
			// log.debug("create connection for host:{} on port:{}", host,
			// port);
			return new ThriftConnection<I>(host, port, framed, type);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return null;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " (host = " + host + ", port = "
				+ port + ")";
	}
}