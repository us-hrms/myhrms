package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.PunishmentReward;
import com.hrms.service.PunishmentRewardService;


@Service
public class PunishmentRewardServiceImpl implements PunishmentRewardService {
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean savePunishmentReward(PunishmentReward punishmentReward) {
		// TODO Auto-generated method stub
		try {
			dao.save(punishmentReward);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updatePunishmentReward(PunishmentReward punishmentReward) {
		// TODO Auto-generated method stub
		try {
			dao.update(punishmentReward);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deletePunishmentReward(PunishmentReward punishmentReward) {
		// TODO Auto-generated method stub
		try {
			dao.delete(punishmentReward);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<PunishmentReward> getPunishmentRewards() {
		// TODO Auto-generated method stub
		return dao.find(new PunishmentReward());
	}

	@Override
	public List<PunishmentReward> getPunishmentRewards(
			PunishmentReward punishmentReward) {
		// TODO Auto-generated method stub
		return dao.find(punishmentReward);
	}

	@Override
	public PunishmentReward getPunishmentReward(PunishmentReward id) {
		// TODO Auto-generated method stub
		return (PunishmentReward) dao.get(PunishmentReward.class, id);
	}
    
}
