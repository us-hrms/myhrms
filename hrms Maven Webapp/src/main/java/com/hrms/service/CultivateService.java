package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.Cultivate;

public interface CultivateService {
	
	Boolean updateCultivate(Cultivate cultivate);
	
	Boolean deleteCultivate(Cultivate cultivate);
	
	Cultivate getCultivate(Serializable id);

    List<Cultivate> getCultivates();
    
    List<Cultivate> getCultivates(Cultivate cultivate);
}
