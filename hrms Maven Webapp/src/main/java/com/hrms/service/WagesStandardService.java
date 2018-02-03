package com.hrms.service;

import java.util.List;

import com.hrms.entity.WagesStandard;

public interface WagesStandardService {
	/**
	 * 保存薪酬
	 * @param wagesStandard
	 * @return
	 */
    Boolean saveWagesStandard(WagesStandard wagesStandard);
    /**
     * 更新薪酬
     * @param wagesStandard
     * @return
     */
    Boolean updateWagesStandard(WagesStandard wagesStandard);
    /**‘
     * 删除薪酬
     * @param wagesStandard
     * @return
     */
    Boolean deleteWagesStandard(WagesStandard wagesStandard);
    /**
     * 查询全部薪酬
     * @return
     */
    List<WagesStandard> getWagesStandards();
    /**
     * 根据条件薪酬
     * @param wagesStandard
     * @return
     */
    List<WagesStandard> getWagesStandards(WagesStandard wagesStandard);
    /**
     * 根据id查询单个薪酬
     * @param id
     * @return
     */
    WagesStandard getWagesStandard(WagesStandard id);
}
