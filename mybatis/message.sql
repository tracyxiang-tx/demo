CREATE TABLE `message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '����',
  `COMMAND` varchar(16) DEFAULT NULL COMMENT 'ָ������',
  `DESCRIPTION` varchar(32) DEFAULT NULL COMMENT '����',
  `CONTENT` varchar(2048) DEFAULT NULL COMMENT '����',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

INSERT INTO `message` VALUES (1, '�鿴', '��������', '��������');
INSERT INTO `message` VALUES (2, '����', '���ʶ���', '��������н��3000��Ǯ����ǵ÷ֳ���ݣ�һ���������飬һ�ݸ����ˣ�һ�ݸ�Ů������ױƷ���·���һ���������ǳԷ���һ����Ϊͬ�µĸ��ֻ�ɥ��Ȣ�ķ���Ǯ��ʣ�µ�2999��Ǯ����������Ҫ�����κ���');
INSERT INTO `message` VALUES (3, '����', '����ͷ��', '7��17�գ���������һ������298�˵�777�ͻ����ڿ�����������˹�߽�׹�١���ݹ����Ĵ���Ѷ����Ϣ��׹�ٻ���Ϊһ�ܲ���777�ͻ�������Լ280���˿ͺ�15��������Ա��\r\n�ڿ����չܲ������֤ʵ��MH17����׹�١��ڿ���������Ļ�ű�ʾ����һ�����ڶ����Ŀ˵����Ͽձ����䡣�������Ǻ��չ�˾ȷ�ϣ��ù�˾�Ӱ�ķ˹�ص�������¡�µ�MH17����ʧ�������������ÿͻ�ȡ����ϵ�ĵص����ڿ����Ͽա�ͼΪ���ͻ�׹���ֳ���');
INSERT INTO `message` VALUES (4, '����', '��������', '���գ��˳���΢���������Լ�����ٳ���鷨������ͬ��д�Ҹ��������ܴ󡣵˳��Լ����̲�ס�п��ֳ����ϱ��д�ġ��ұ�����д�ġ���������Ҳ���Ҹ��ˡ�');
INSERT INTO `message` VALUES (5, '��Ӱ', '������ӳ��Ƭ', '��������꡷[2]���˵�Ӱ������������Ӱҵ���У�����ɼ�֮ս����������ɭ���ﱴ˹��ִ���� \r\nƬ����ֻ����������ʦ�����������Ϳ�ͨ���»��ƣ��ɶ�����׽����ʵ�֡�\r\n����Ƥ�ء�����������ݴ����(��������ʿ��)��ŵ�������������׿��ʻ���(������˫�ڹ�)�����ס�����ɭ������쳶�(����������)�������ס����������ݶ���̩��(��������ʿ��)��\r\n��Ƭ�ƻ���2014��8��8���ڱ�����ӳ��');
INSERT INTO `message` VALUES (6, '��Ʊ', '�н�����', '��ɶѽ�飬�㲻���н��ģ�');

CREATE TABLE command_content(
 ID int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
 CONTENT varchar(2048),
 COMMAND_ID int(11),
 FOREIGN KEY (COMMAND_ID) REFERENCES command(ID)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE command(
 ID int(11)  PRIMARY KEY NOT NULL AUTO_INCREMENT,
 NAME varchar(16),
 DESCRIPTION varchar(32)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into command values(1,'����','���ʶ���');