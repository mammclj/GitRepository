package com.mmm.dao;

import com.mmm.model.TaoBaoArea;

public interface TaoBaoAreaMapper extends BaseMapper<TaoBaoArea> {
	TaoBaoArea selectTaoBaoAreaByIp(String ip);
    TaoBaoArea selectTaoBaoAreaByIp2(String ip);
}