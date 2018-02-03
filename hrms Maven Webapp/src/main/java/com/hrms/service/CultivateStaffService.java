package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.CultivateStaff;

public interface CultivateStaffService {
	    /**
	     * 更新
	     */
		Boolean updateCultivateStaff(CultivateStaff cultivateStaff);
	   /**
	    * 删除
	    */
		Boolean deleteCultivateStaff(CultivateStaff cultivateStaff);
	   /**
	    * 根据ID查询
	    */
		CultivateStaff getCultivateStaff(Serializable id);
	   /**
	    * 查询全部
	    * @return
	    */
	   List<CultivateStaff> getCultivateStaffs();
       /**
        * 按条件查询
        */
	   List<CultivateStaff> getCultivateStaffs(CultivateStaff cultivateStaff);
}
