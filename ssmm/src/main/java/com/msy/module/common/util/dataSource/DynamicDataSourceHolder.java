package com.msy.module.common.util.dataSource;

public class DynamicDataSourceHolder {
	private static final ThreadLocal<String> dynamicDataSourceHolder = new ThreadLocal<String>();

	/**
	 * @Description: 设置数据源类型 
	 * @param dataSourceType 数据库类型
	 * @return void 
	 * @throws
	 */
	public static void setDataSource(String dataSource) {
		dynamicDataSourceHolder.set(dataSource);
	}

	/**
	 * @Description: 获取数据源类型
	 *  @param 
	 *  @return String 
	 *  @throws
	 */
	public static String getDataSource() {
		return dynamicDataSourceHolder.get();
	}

	/**
	 * @Description: 清除数据源类型 
	 * @param 
	 * @return void 
	 * @throws
	 */
	public static void clearDataSource() {
		dynamicDataSourceHolder.remove();
	}
}

