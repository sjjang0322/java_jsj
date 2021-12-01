-- cgv 강남 지점에서 12월 1일 상영 시간표를 확인
select sc_num, mo_title, mg_ge_name, mo_runtime, mo_date, sc_option, th_name, sc_room_num, sc_total_seat, sc_date, sc_time, sc_seat from schedule
	join movie on sc_mo_num = mo_num
    join theater on th_num = sc_th_num
    join movie_genre on mo_num = mg_mo_num
	where th_name = 'CGV강남' and sc_date = '2021-12-01';
    
-- abc123회원이 12월 1일 21:20분 1관에서 하는 영화 듄을 A1,A2 두자리를 예매했다. 이때 실행 되는 쿼리문을 작성

-- 1. 예메에 데이터 추가
insert into ticketing select 1, 'abc123', sc_num from `schedule` where sc_date = '2021-12-01' and sc_time = '21:20' and sc_room_num = 1;
-- 2. 예메리스트에 데이터 추가
insert into ticketing_list value (1, 1, 1);
insert into ticketing_list value (2, 1, 2);
-- 3. 상영시간 정보를 수정
UPDATE `cgv`.`schedule` SET `sc_seat` = `sc_seat`- (select count(*) from ticketing_list join ticketing on tk_num = tl_tk_num where tk_num = 1) WHERE (`sc_num` = '2');


select * from `schedule`;
select * from ticketing;
select * from seat;
select * from ticketing_list;


-- CGV강남, 12월1일 21:20분 1관에서 하는 영화에서 예매 가능한 좌석을 확인
select st_name from `schedule`
	join seat on st_room_num = sc_room_num
    join theater on th_num = st_th_num
    left join ticketing_list on tl_st_num = st_num
	where sc_date = '2021-12-1' and sc_time = '21:20' and sc_room_num = 1 and tl_num is null and th_name = 'CGV강남';
    
-- CGV강남점 1관의 전체 좌석 정보
select th_name, st_room_num, st_name from seat 
	join theater on th_num = st_th_num 
    where th_name = 'CGV강남' and st_room_num = 1;

-- CGV강남, 12월1일 21:20분 1관에서 하는 영화 예매 내역
select * from ticketing_list
	join ticketing on tl_tk_num = tk_num
    join `schedule` on tk_sc_num = sc_num
    where sc_th_num = 1 and sc_room_num = 1 and sc_date = '2021-12-01' and sc_time = '21:20';

-- 예약 가능한 좌석 확인
select * from seat left
	join(select *from ticketing_list
			join ticketing on tl_tk_num = tk_num
			where tk_sc_num = 2)
		as tl 
	on st_num = tl_st_num
    where st_th_num = 1 and st_room_num = 1 and tl_num is null;
    
    
select * from seat;