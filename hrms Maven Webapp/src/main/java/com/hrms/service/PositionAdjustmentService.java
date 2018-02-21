package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.PositionAdjustment;
import com.hrms.page.Page;

public interface PositionAdjustmentService {
	/**
     * 根据ID查询
     */
	PositionAdjustment getPositionAdjustment(Serializable id);
    /**
     * 查询全部
     */
	List<PositionAdjustment> getPositionAdjustments();
	List<PositionAdjustment> getPositionAdjustments(Page page);
	/**
	 * 根据条件查询
	 */
    List<PositionAdjustment> getPositionAdjustments(PositionAdjustment positionAdjustment);
    List<PositionAdjustment> getPositionAdjustments(PositionAdjustment positionAdjustment,Page page);
    /**
    * 更新
    */
    Boolean updatePositionAdjustment(PositionAdjustment positionAdjustment);
    /**
    * 删除
    */
    Boolean deletePositionAdjustment(PositionAdjustment positionAdjustment);
}
