select * from user_tables;

--멤버 테이블
create table member(
	memId varchar(50) primary key not null,
	memPw varchar(50) not null,
	memNickname varchar(50) not null,
	memPic varchar(200) not null,
	memfollowee int default 0,
	memfollower int default 0
);

--멤버 테이블 테스트 값 삽입
insert into member(memId, memPw, memNickname, memPic) values('test', '1234', '테스트', 'zzang1.jpg');
insert into member(memId, memPw, memNickname, memPic) values('admin', '1234', '관리자', 'zzang2.jpg');
insert into member(memId, memPw, memNickname, memPic) values('smalltimo', '1234', '작은티모', 'zzang3.jpg');
insert into member(memId, memPw, memNickname, memPic) values('bigtimo', '1234', '큰티모', 'zzang1.jpg');
select * from member;
drop table member;

--팔로우 테이블
create table follow(
	fid int primary key,
	follower varchar(20) not null,
	followee varchar(20) not null,
	foreign key (follower) references member(memId) on delete cascade,
	foreign key (followee) references member(memId) on delete cascade
);
insert into follow values((select nvl(max(fid),0)+1 from follow),'test','admin');
select * from follow;
drop table follow;

insert into follow values((select nvl(max(fid),0)+1 from follow),'test','smalltimo');
delete from follow where follower='smalltimo' and followee='smalltimo';

-- 게시판 테이블
create table board(
	bid int primary key,
	memId varchar(20) not null,
	pic varchar(300) not null,
	writer varchar(100) not null,
	content varchar(200) not null,
	rpcnt int default 0,
	bdate timestamp default sysdate
);
insert into board(bid, memId, pic, writer, content) values(1, 'test', 'zzang1.jpg', '갱플랭크', '귤귤');
insert into board(bid, memId, pic, writer, content) values(2, 'bigtimo', 'zzang2.jpg', '큰 티모', '글글2');
insert into board(bid, memId, pic, writer, content) values(3, 'smalltimo', 'zzang3.jpg', '작은 티모', '글글3');
insert into board(bid, memId, pic, writer, content) values(4, 'admin', 'zzang1.jpg', '관리자', '글글4');

select * from board;
drop table board;

delete board where bid=5 and memId='test1';


-- 댓글 테이블
create table reply(
	rid int primary key,
	bid int not null,
	memNickname varchar(20) not null,
	msg varchar(200) not null,
	rdate timestamp default sysdate,
	foreign key (bid) references board(bid) on delete cascade
);
select * from reply;
select * from reply where bid=5 order by rid desc;


--2개만 뽑아내기
select * from (select * from reply where bid=5 order by rid desc) where rownum <=2;


insert into reply (rid,bid,memNickname,msg) values((select nvl(max(rid),0)+1 from reply),1,'큰티모','들어가라 쫌')
drop table reply;
