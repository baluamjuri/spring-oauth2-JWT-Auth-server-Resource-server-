
insert into abv_user(username, password, salt) values('john', 'john', 'john');

insert into abv_role(role_name, is_active) values('ADMIN',true);
insert into abv_role(role_name, is_active) values('MANAGER',true);
insert into abv_role(role_name, is_active) values('TEAM_LEAD',true);
insert into abv_role(role_name, is_active) values('TEAM_MEMBER',true);

insert into abv_user_role(user_id, role_id) values(1,1);