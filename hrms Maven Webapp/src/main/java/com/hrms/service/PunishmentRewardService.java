package com.hrms.service;

import java.util.List;

import com.hrms.entity.PunishmentReward;

public interface PunishmentRewardService {
      
	/**
	 * 保存奖罚记录
	 * @param punishmentReward
	 * @return
	 */
	Boolean savePunishmentReward(PunishmentReward punishmentReward);
	/**
	 * 更新奖罚记录
	 * @param punishmentReward
	 * @return
	 */
	Boolean updatePunishmentReward(PunishmentReward punishmentReward);
	/**
	 * 删除奖罚记录
	 * @param punishmentReward
	 * @return
	 */
	Boolean deletePunishmentReward(PunishmentReward punishmentReward);
	/**
	 * 查询全部奖罚记录
	 * @return
	 */
	List<PunishmentReward> getPunishmentRewards();
	/**
	 * 根据条件查询奖罚记录
	 * @param punishmentReward
	 * @return
	 */
	List<PunishmentReward> getPunishmentRewards(PunishmentReward punishmentReward);
	/**
	 * 根据id查询单个奖罚记录
	 * @param id
	 * @return
	 */
	PunishmentReward getPunishmentReward(PunishmentReward id);
}
