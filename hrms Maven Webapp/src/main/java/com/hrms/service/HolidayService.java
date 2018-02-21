package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.Holiday;
import com.hrms.page.Page;

public interface HolidayService {
	    /**
	     * ����ID��ѯ
	     */
		Holiday getHoliday(Serializable id);
	    /**
	     * ��ѯȫ��
	     */
		List<Holiday> getHolidays();
		List<Holiday> getHolidays(Page page);
	    /**
	     * ��������ѯ
	     */
	    List<Holiday> getHolidays(Holiday holiday);
	    List<Holiday> getHolidays(Holiday holiday,Page page);
	    /**
	     * ����
	     */
	    Boolean updateHoliday(Holiday holiday);
	    /**
	     * ɾ��
	     */
	    Boolean deleteHoliday(Holiday holiday);

}
