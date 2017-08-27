-- ��ɱִ�еĴ洢����
DELIMITER $$ -- console ; ת��Ϊ $$
-- ����洢����
-- ����: in�������; out�������
-- row_count(): ������һ���޸�����sql(insert,delete,update)��Ӱ������
-- row_count(): 0:δ�޸����� >0:��ʾ�޸ĵ����� <0:��ʾsql����/δִ���޸�sql
CREATE PROCEDURE `seckill`.`execute_seckill`
	(in v_seckill_id BIGINT, in v_phone BIGINT,
		in v_kill_time TIMESTAMP, out r_result INT)
	BEGIN
		DECLARE insert_count INT DEFAULT 0;
		START TRANSACTION;
		INSERT IGNORE INTO success_killed
			(seckill_id,user_phone,create_time) 
		 VALUES(v_seckill_id,v_phone,v_kill_time);
		SELECT ROW_COUNT() INTO insert_count;
		IF(insert_count = 0 ) THEN
			ROLLBACK;
			SET r_result = -1;
		ELSEIF (insert_count < 0) THEN
			ROLLBACK;
			SET r_result = -2;
		ELSE 
			UPDATE seckill
			SET number = number - 1
			WHERE seckill_id = v_seckill_id
				AND end_time > v_kill_time
				AND start_time < v_kill_time
				AND number > 0;
			SELECT ROW_COUNT() INTO insert_count;
			IF (insert_count = 0) THEN 
				ROLLBACK;
				SET r_result = 0;
			ELSEIF (insert_count < 0) THEN
			ROLLBACK;
			SET r_result = -2;
			ELSE
				COMMIT;
				SET r_result = 1;
			END IF;
		END IF;
	END;
$$
-- �洢���̶������

DELIMITER ;

set @r_result=-3;
-- ִ�д洢����
call execute_seckill(1003,26374897263,now(),@r_result);

-- ��ȡ���
select @r_result;

-- �洢����
-- 1.�洢�����Ż��������м������е�ʱ��
-- 2.��Ҫ���������洢����
-- 3.�򵥵��߼�����Ӧ�ô洢����
-- 4.QPS:һ����ɱ��6000/qps
