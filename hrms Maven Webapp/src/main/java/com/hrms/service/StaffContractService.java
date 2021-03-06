package com.hrms.service;

import java.util.List;

import com.hrms.entity.StaffContract;
import com.hrms.page.Page;

public interface StaffContractService {
	   /**
	    * 保存员工合同
	    * @param staffContract
	    * @return
	    */
	   Boolean saveStaffContract(StaffContract staffContract);
	   /**
	    * 更新员工合同
	    * @param staffContract
	    * @return
	    */
	   Boolean updateStaffContract(StaffContract staffContract);
	   /**
	    * 删除员工合同
	    * @param staffContract
	    * @return
	    */
	   Boolean deleteStaffContract(StaffContract staffContract);
	   /**
	    * 查询所有员工合同
	    * @return
	    */
	   List<StaffContract> getStaffContracts();
	   List<StaffContract> getStaffContracts(Page page);
	   /** 
        * 根据条件查询员工合同
        */
	   List<StaffContract>  getStaffContracts(StaffContract staffContract);
	   List<StaffContract>  getStaffContracts(StaffContract staffContract,Page page);
	   /**
	    * 根据id查询单个员工合同
	    * @param id
	    * @return
	    */
	   StaffContract getStaffContract(StaffContract id);
	   
}
