package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.CultivateStaff;

public interface CultivateStaffService {
	    /**
	     * ����
	     */
		Boolean updateCultivateStaff(CultivateStaff cultivateStaff);
	   /**
	    * ɾ��
	    */
		Boolean deleteCultivateStaff(CultivateStaff cultivateStaff);
	   /**
	    * ����ID��ѯ
	    */
		CultivateStaff getCultivateStaff(Serializable id);
	   /**
	    * ��ѯȫ��
	    * @return
	    */
	   List<CultivateStaff> getCultivateStaffs();
       /**
        * ��������ѯ
        */
	   List<CultivateStaff> getCultivateStaffs(CultivateStaff cultivateStaff);
}
