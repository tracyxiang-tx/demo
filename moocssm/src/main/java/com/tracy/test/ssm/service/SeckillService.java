package com.tracy.test.ssm.service;

import java.util.List;

import com.tracy.test.ssm.dto.Exposer;
import com.tracy.test.ssm.dto.SeckillExecution;
import com.tracy.test.ssm.entity.Seckill;
import com.tracy.test.ssm.exception.RepeatKillException;
import com.tracy.test.ssm.exception.SeckillCloseException;
import com.tracy.test.ssm.exception.SeckillException;

public interface SeckillService {

	List<Seckill> getSeckillList();
	
	Seckill getById(long seckillId);
	
	/**
	 * 秒杀开启时输出秒杀接口地址，
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀操作
	 * @param seckillId
	 * @param userphone
	 * @param md5
	 */
	SeckillExecution excuteSeckill(long seckillId, long userphone, String md5);

	/**
	 * 执行秒杀操作 by 存储过程
	 * @param seckillId
	 * @param userphone
	 * @param md5
	 */
	SeckillExecution excuteSeckillProcedure(long seckillId, long userphone, String md5)
		throws SeckillException, RepeatKillException, SeckillCloseException;
}
