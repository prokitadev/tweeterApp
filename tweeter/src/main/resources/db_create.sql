create database tweeter;
use tweeter;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
create table if not exists `t_posts`(
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`create_timestamp` timestamp NOT NULL,
`modify_timestamp` timestamp,
`delete_timestamp` timestamp,
`userId` bigint NOT NULL,
`text` varchar(299),
`public` boolean NOT NULL,
`type` enum('post', 'comment') NOT NULL,
`parentId` bigint,
constraint `post_to_user` foreign key (`userId`) references `t_users` (`id`)
);

create table if not exists `t_users`(
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`create_timestamp` timestamp NOT NULL,
`login` varchar(55) unique NOT NULL,
`password` varchar(55) NOT NULL,
`role` enum ('user', 'admin', 'moderator', 'observer'),
`user_descriptionId` bigint NOT NULL
);

create table if not exists `t_user_descriptions`(
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`create_timestamp` timestamp NOT NULL,
`name` varchar(55),
`surname` varchar(55),
`email_address` varchar(55),
`date_of_birth` date,
`userId` bigint NOT NULL
);

create table if not exists `t_actions`(
`id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
`create_timestamp` timestamp NOT NULL,
`type` enum ('blocked', 'banned', 'deleted') NOT NULL,
`expire_timestamp` timestamp,
`userId` bigint,
`postId` bigint,
`admin_userId` bigint NOT NULL,
constraint `action_to_user` foreign key (`userId`) references `t_users` (`id`),
constraint `action_to_post` foreign key (`postId`) references `t_posts` (`id`),
constraint `action_to_admin_user` foreign key (`admin_userId`) references `t_users` (`id`)
);


select * from t_posts;




insert into t_users (id, create_timestamp, login, password, role, user_descriptionId)
values (1, now(), 'MariuszTest', 'MariuszPass', 'user', 1);
insert into t_users (id, create_timestamp, login, password, role, user_descriptionId)
values (2, now(), 'DamianAdmin', 'DamianPass', 'admin', 2);
insert into t_users (id, create_timestamp, login, password, role, user_descriptionId)
values (3, now(), 'MarysiaTest', 'MarysiaPass', 'user', 3);

insert into t_user_descriptions (id, create_timestamp, name, surname, email_address, date_of_birth, userId)
values (1, now(), 'Mariusz', 'Kowalski', 'Mariusz@dzimejl.com', '1986-05-03',  1);
insert into t_user_descriptions (id, create_timestamp, name, surname, email_address, date_of_birth, userId)
values (2, now(), 'Damian', 'Kamukowski', 'damian@tweeter.com', '1994-12-12',  2);
insert into t_user_descriptions (id, create_timestamp, name, surname, email_address, date_of_birth, userId)
values (3, now(), 'Maria', 'Kowalska', 'Maria@int-eria.pl', '1988-07-07',  3);

insert into t_posts
values (1, now(), null, null, 1, 'To jest pierwszy post na tym tweeterze', true, 'post', null);
insert into t_posts
values (2, now(), null, null, 3, 'To jest pierwszy post Marysi na tym tweeterze', true, 'post', null);
insert into t_posts
values (3, now(), null, null, 3, 'A to jest komentarz Marysi do postu Damiana', true, 'comment', 1);

select * from t_actions;

insert into t_actions
values (1, now(), 'blocked', now()+1, 1, null, 2);

select * from t_users u join t_user_descriptions ud on u.user_descriptionId = ud.Id;