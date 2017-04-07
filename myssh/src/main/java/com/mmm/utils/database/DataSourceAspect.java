package com.mmm.utils.database;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class DataSourceAspect {

	private static Logger logger = Logger.getLogger(DataSourceAspect.class);

	public void before(JoinPoint joinPoint) throws NoSuchMethodException, SecurityException {
		if (TransactionSynchronizationManager.isActualTransactionActive()
				&& DynamicDataSourceHolder.getDataSource() != null)
			return;
		// 获取方法签名
		Method declareMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
		Method instanceMethod = joinPoint.getTarget().getClass().getMethod(declareMethod.getName(),declareMethod.getParameterTypes());
		DataSource methodAnnotation = AnnotationUtils.findAnnotation(instanceMethod, DataSource.class);
		if (methodAnnotation == null)
			return;
		if (methodAnnotation != null) {
			DynamicDataSourceHolder.setDataSource(methodAnnotation.value());
		}
	}

	/**
	 * 方法执行完后置空
	 */
	public void after(JoinPoint joinPoint) {
		if (TransactionSynchronizationManager.isActualTransactionActive())
			return;
		if (TransactionSynchronizationManager.isSynchronizationActive())
			TransactionSynchronizationManager.clearSynchronization();
		DynamicDataSourceHolder.setDataSource(null);
	}

}