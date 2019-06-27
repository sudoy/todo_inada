
create table todolist(

	number int primary key auto_increment,
	daimei varchar(100),
	syosai varchar(100),
	juyodoval varchar(20),
	kigen date

);

insert into todolist(number, daimei, syosai, juyodoval, kigen)
values(1, 'テストテスト', 'SQLの確認テストの採点と報告書を作成する。', 'option1', '2015/06/15');

insert into todolist(number, daimei, syosai, juyodoval, kigen)
values(2, 'テスト2', 'ゲーム実況見る。', 'option2', '2019/06/27');

insert into todolist(number, daimei, syosai, juyodoval, kigen)
values(3, 'テスト3', '本屋寄る。', 'option1', '2019/06/27');