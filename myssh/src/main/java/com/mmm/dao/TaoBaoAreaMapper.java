package com.mmm.dao;

import com.mmm.model.TaoBaoArea;

public interface TaoBaoAreaMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaoBaoArea record);

    int insertSelective(TaoBaoArea record);

    TaoBaoArea selectByPrimaryKey(String id);

    TaoBaoArea selectTaoBaoAreaByIp(String ip);
    TaoBaoArea selectTaoBaoAreaByIp2(String ip);

    int updateByPrimaryKeySelective(TaoBaoArea record);

    int updateByPrimaryKey(TaoBaoArea record);
}