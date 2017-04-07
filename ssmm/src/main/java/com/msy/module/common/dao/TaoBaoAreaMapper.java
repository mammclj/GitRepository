package com.msy.module.common.dao;

import com.msy.module.common.model.TaoBaoArea;

public interface TaoBaoAreaMapper extends BaseMapper<TaoBaoArea> {
	TaoBaoArea selectTaoBaoAreaByIp(String ip);
    TaoBaoArea selectTaoBaoAreaByIp2(String ip);
}