package com.tracy.test.ssm.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tracy.test.ssm.dto.Exposer;
import com.tracy.test.ssm.dto.SeckillExecution;
import com.tracy.test.ssm.entity.Seckill;
import com.tracy.test.ssm.exception.RepeatKillException;
import com.tracy.test.ssm.exception.SeckillCloseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml" })
public class SeckillServiceTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private SeckillService seckillService;

	@Test
	public void testGetSeckillList() {
		List<Seckill> seckillList = seckillService.getSeckillList();
		logger.info("list={}", seckillList);
	}

	@Test
	public void testGetById() {
		long seckillId = 1000L;
		Seckill seckill = seckillService.getById(seckillId);
		logger.info("seckill={}", seckill);
	}

	//集成测试代码完整逻辑，注意可重复执行
	@Test
	public void testSeckillLogic() {
		long seckillId = 1000L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()) {
			logger.info("exposer={}", exposer);

			long phone = 64237898L;
			String md5 = exposer.getMd5();

			try {
				SeckillExecution seckillExecution = seckillService.excuteSeckill(
						seckillId, phone, md5);
				logger.info("result={}", seckillExecution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e1) {
				logger.error(e1.getMessage());
			}

		} else {
			//秒杀未开启
			logger.warn("exposer={}", exposer);
		}
		
	}
	
	@Test
	public void excuteSeckillProcedureTest() {
		long seckillId = 1000L;
		long phone = 7532590L;
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()) {
			
			String md5 = exposer.getMd5();
			SeckillExecution seckillExecution = seckillService.excuteSeckillProcedure(seckillId, phone, md5);
			logger.info(seckillExecution.getStateInfo());
			
		}
		
	}

}
