package com.frontend.web.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class C3p0ConnUtil {

	private static final String JDBC_DRIVER = "driverClass";
	private static final String JDBC_URL = "jdbcUrl";
	private static final String prefix = "c3p0.";

	private static DataSource ds;

	/**
	 * 初始化连接池代码块
	 */
	static {
		initDBSource();
	}

	/**
	 * 初始化c3p0连接池
	 */
	private static final void initDBSource() {
		Properties c3p0Properties = new Properties();
		try {
			InputStream in = C3p0ConnUtil.class.getClassLoader().getResourceAsStream("c3p0.properties");
			c3p0Properties.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 加载数据库驱动类
		String drverClass = c3p0Properties.getProperty(JDBC_DRIVER);
		if (drverClass != null) {
			try {

				Class.forName(drverClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		// 常规数据库连接属性
		Properties jdbcProperties = new Properties();
		// 连接池配置属性
		Properties c3p0PooledProp = new Properties();
		for (Object key : c3p0Properties.keySet()) {
			String skey = (String) key;
			if (skey.startsWith(prefix)) {
				c3p0PooledProp.put(skey, c3p0Properties.getProperty(skey));
			} else {
				jdbcProperties.put(skey, c3p0Properties.getProperty(skey));
			}
		}
		try {
			// 建立连接池
			DataSource unPooled = DataSources.unpooledDataSource(c3p0Properties.getProperty(JDBC_URL), jdbcProperties);
			ds = DataSources.pooledDataSource(unPooled, c3p0PooledProp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 获取数据库连接对象
	 *
	 * @return数据连接对象
	 * @throws SQLException
	 */
	public static synchronized Connection getConnection() throws SQLException {
		final Connection conn = ds.getConnection();
		// 指定在读取数据时控制共享锁以避免脏读，但数据可在事务结束前更改，从而产生不可重复读取或幻像数据。
		conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		return conn;
	}
}
