package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.PositionAdjustment;
import com.hrms.page.Page;

public interface PositionAdjustmentService {
	/**
     * ����ID��ѯ
     */
	PositionAdjustment getPositionAdjustment(Serializable id);
    /**
     * ��ѯȫ��
     */
	List<PositionAdjustment> getPositionAdjustments();
	List<PositionAdjustment> getPositionAdjustments(Page page);
	/**
	 * ����������ѯ
	 */
    List<PositionAdjustment> getPositionAdjustments(PositionAdjustment positionAdjustment);
    List<PositionAdjustment> getPositionAdjustments(PositionAdjustment positionAdjustment,Page page);
    /**
    * ����
    */
    Boolean updatePositionAdjustment(PositionAdjustment positionAdjustment);
    /**
    * ɾ��
    */
    Boolean deletePositionAdjustment(PositionAdjustment positionAdjustment);
}
