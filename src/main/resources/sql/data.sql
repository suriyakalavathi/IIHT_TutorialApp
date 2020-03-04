-- add Administrator (in sync with TutorialInit for bCrypt!
insert into user (user_id, name, email, username, password) values (next value for user_seq, 'Admin User', 'admin@cognizant.com', 'admin', 'password');

-- add role "ADMIN" to Administrator
insert into role (role_id, role) values (next value for role_seq, 'ADMIN');
insert into user_role (user_id, role_id) values (current value for user_seq, current value for role_seq);

-- add role "USER" to Administrator
insert into role (role_id, role) values (next value for role_seq, 'USER');
insert into user_role (user_id, role_id) values (current value for user_seq, current value for role_seq);
