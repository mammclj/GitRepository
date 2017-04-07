package com.mmm.dao;

public interface BaseMapper<T> {
	int deleteByPrimaryKey(Object id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
