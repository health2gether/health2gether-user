INSERT INTO `user` (`name`, `email`, `phone`, `password`, `status`, `birthday`) VALUES ('flavio', 'flavio@fiap.com', '11999999999', '$2a$12$BFGgbf.8mJAxsI6jFlm/CeggMD/VpSqUj0xTSj.e0btI6XJijmCnm', 'ACTIVE', '1988-04-29');

INSERT INTO `authority` (`name`) VALUES ('ADMIN');
INSERT INTO `authority` (`name`) VALUES ('USER');

INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (1, 1);