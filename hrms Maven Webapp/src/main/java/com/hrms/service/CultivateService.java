package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.Certificate;
import com.hrms.entity.Cultivate;
import com.hrms.page.Page;

public interface CultivateService {
	
	Boolean updateCultivate(Cultivate cultivate);
	
	Boolean deleteCultivate(Cultivate cultivate);
	
	Cultivate getCultivate(Serializable id);

    List<Cultivate> getCultivates();
    List<Cultivate> getCultivates(Page page);
    
    List<Cultivate> getCultivates(Cultivate cultivate);
    List<Cultivate> getCultivates(Cultivate cultivate,Page page);
    List<Cultivate> getCultivates(Cultivate cultivate,Certificate certificate,Page page);
}
