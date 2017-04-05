package com.mmm.utils.database;

public class DynamicDataSourceHolder {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * @Description: 设置数据源类型 
	 * @param dataSourceType 数据库类型
	 * @return void 
	 * @throws
	 */
	public static void setDataSource(String dataSource) {
		contextHolder.set(dataSource);
	}

	/**
	 * @Description: 获取数据源类型
	 *  @param 
	 *  @return String 
	 *  @throws
	 */
	public static String getDataSource() {
		return contextHolder.get();
	}

	/**
	 * @Description: 清除数据源类型 
	 * @param 
	 * @return void 
	 * @throws
	 */
	public static void clearDataSource() {
		contextHolder.remove();
	}
}
