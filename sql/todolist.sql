
create table todolist(

	number int primary key auto_increment,
	daimei varchar(100),
	syosai varchar(100),
	juyodoval varchar(20),
	kigen date

);

insert into todolist(number, daimei, syosai, juyodoval, kigen)
values(1, '�e�X�g�e�X�g', 'SQL�̊m�F�e�X�g�̍̓_�ƕ񍐏����쐬����B', 'option1', '2015/06/15');

insert into todolist(number, daimei, syosai, juyodoval, kigen)
values(2, '�e�X�g2', '�Q�[����������B', 'option2', '2019/06/27');

insert into todolist(number, daimei, syosai, juyodoval, kigen)
values(3, '�e�X�g3', '�{�����B', 'option1', '2019/06/27');