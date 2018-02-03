package com.hyq.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.PunishmentReward;
import com.hrms.service.PunishmentRewardService;

public class PunishmentRewardServiceTest {

	static PunishmentRewardService prs;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		prs = context.getBean(PunishmentRewardService.class);
	}
//	@Test
	public void testGetPunishmentRewards() {
		List<PunishmentReward> list = prs.getPunishmentRewards();
		for (PunishmentReward punishmentReward : list) {
			System.out.println(punishmentReward.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}

}
