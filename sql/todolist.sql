
create table todolist(

	number int primary key auto_increment,
	daimei varchar(100),
	syosai varchar(100),
	juyodoval varchar(20),
	kigen varchar(100),
	status int

);

insert into todolist(number, daimei, syosai, juyodoval, kigen, status)
values(1, 'テストテスト', 'SQLの確認テストの採点と報告書を作成する。', 'option1', '2015/06/15', 0);

insert into todolist(number, daimei, syosai, juyodoval, kigen, status)
values(2, 'テスト2', 'ゲーム実況見る。', 'option2', '2019/06/27', 1);

insert into todolist(number, daimei, syosai, juyodoval, kigen, status)
values(3, 'テスト3', '本屋寄る。', 'option1', '2019/06/27', 0);


create table user(

	id int primary key auto_increment,
	mail varchar(40),
	pass varchar(255),
	name varchar(20)

);
insert into user(id, mail, pass, name) values(1, "yuichi.sudo@ssie.jp", sha2('0000', 256), "須藤雄一");
insert into user(id, mail, pass, name) values(2, "mail@mail", sha2('0000', 256), "稲田万穂");