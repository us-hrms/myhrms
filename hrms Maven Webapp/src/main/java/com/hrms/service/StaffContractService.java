package com.hrms.service;

import java.util.List;

import com.hrms.entity.StaffContract;

public interface StaffContractService {
	   /**
	    * ����Ա����ͬ
	    * @param staffContract
	    * @return
	    */
	   Boolean saveStaffContract(StaffContract staffContract);
	   /**
	    * ����Ա����ͬ
	    * @param staffContract
	    * @return
	    */
	   Boolean updateStaffContract(StaffContract staffContract);
	   /**
	    * ɾ��Ա����ͬ
	    * @param staffContract
	    * @return
	    */
	   Boolean deleteStaffContract(StaffContract staffContract);
	   /**
	    * ��ѯ����Ա����ͬ
	    * @return
	    */
	   List<StaffContract> getStaffContracts();
	   /** 
        * ����������ѯԱ����ͬ
        */
	   List<StaffContract>  getStaffContracts(StaffContract staffContract);
	   /**
	    * ����id��ѯ����Ա����ͬ
	    * @param id
	    * @return
	    */
	   StaffContract getStaffContract(StaffContract id);
	   
}
