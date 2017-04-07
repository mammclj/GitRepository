package com.msy.module.common.util.dataSource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Order(1)
public class DataSourceAspect {

	@Before(value = "@annotation(com.msy.module.common.util.dataSource.DataSource)")
	public void before(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Method[] methods = jp.getTarget().getClass().getMethods();
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				DataSource ds = method.getAnnotation(DataSource.class);
				DynamicDataSourceHolder.setDataSource(ds.value());
			}
		}
	}

}