-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(128) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL COMMENT '密码',
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL COMMENT '支持的授权方式',
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL COMMENT 'access_token有效期（单位秒）',
  `refresh_token_validity` int(11) DEFAULT NULL COMMENT 'refresh_token有效期（单位秒）',
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='oauth2的client表';

DROP table if exists `oauth_approvals`;
CREATE TABLE oauth_approvals
(
  userid varchar(256), -- 登录的用户名
  clientid varchar(256), -- 客户端ID
  scope varchar(256), -- 申请的权限
  status varchar(10), -- 状态（Approve或Deny）
  expiresat timestamp, -- 过期时间
  lastmodifiedat timestamp default current_timestamp,-- 最终修改时间
  primary key (userid)
) engine=InnoDB default charset =utf8mb4 comment ='oauth2 app授权表';

INSERT INTO `oauth_client_details`
VALUES ('gateway', null, 'gateway-secret', 'app', 'authorization_code,password,refresh_token', null, null, '28800', null, null, null);