insert into Project_Type values (1,'사이드 프로젝트');
insert into Project_Field values (2,'미술');
insert into Recruit (name,status,leader,start_date,end_date,created_at,content,info,field_seq,type_seq) values ('미술 작품 거래 차트 서비스','모집 중',1,'2023-04-19','2023-11-25','2023-04-01','소개 투자 붐이된 시대에 투자할 곳을 많이 찾고 있었습니다.','미술 작품 거래 차트 서비스 만들겁니다',2,1);
insert into Recruit (name,status,leader,start_date,end_date,created_at,content,info,field_seq,type_seq) values ('미술품 판매 플랫폼','모집 중',1,'2023-04-18','2023-11-29','2023-04-02','미술품 판매는 자본이 됩니다.','미술 작품을 직접 판매합시다',2,1);
insert into Keep (recruit_seq,member_seq) values (1,1);
insert into Keep (recruit_seq,member_seq) values (1,2);
insert into Keep (recruit_seq,member_seq) values (1,3);
insert into Keep (recruit_seq,member_seq) values (2,1);
insert into Position_Genre (position_genre_seq,name) values (1,'BackEnd');
insert into Position_Genre (position_genre_seq,name) values (2,'FrontEnd');
insert into Position_Genre (position_genre_seq,name) values (3,'Designer');
insert into Position_Genre (position_genre_seq,name) values (4,'Marketer');
insert into Position (position_seq,name,position_genre_seq) values (1,'웹 서버',1);
insert into Position (position_seq,name,position_genre_seq) values (2,'IOS',2);
insert into Position (position_seq,name,position_genre_seq) values (3,'UI/UX 디자인',3);
insert into Position (position_seq,name,position_genre_seq) values (4,'사업기획',4);
insert into Recruit_Position_Count (recruit_seq,position_seq,count) values (1,1,2);
insert into Recruit_Position_Count (recruit_seq,position_seq,count) values (1,2,1);
insert into Recruit_Position_Count (recruit_seq,position_seq,count) values (1,3,1);
insert into Recruit_Position_Apply (member_seq,is_accept,recruit_seq,position_seq) values (1,'수락',1,1);
insert into Recruit_Position_Apply (member_seq,is_accept,recruit_seq,position_seq) values (2,'대기',1,1);
insert into Recruit_Position_Apply (member_seq,is_accept,recruit_seq,position_seq) values (3,'수락',1,2);


