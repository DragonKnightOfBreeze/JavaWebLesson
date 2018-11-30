# 创建数据库表

```mysql
use JavaWebLesson;
drop table if exists User;
create table User(
	id varchar(30) primary key ,
	name varchar(30) not null ,
	password varchar(32) not null 
);
insert into User(id,name,password) values
('admin','administrator','admin');

```

# 程序实现思路

* login.html：提供用户的登录表单，可以输入用户id和密码
* login_check.jsp：登录检查页，根据表单提交过来的id和密码就行数据库验证，成功跳转到登录成功页，否则跳转到登录失败页
* login_success.jsp：登录成功页，表示欢迎信息
* login_failure.html：登录失败页，提示用户输入错误，并提供重新登录的超链接
