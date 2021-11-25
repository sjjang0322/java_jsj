-- 단가가 3000원 이상 6000원 이하인 제품들을 확인
select 제품명 from 제품
	where 단가 < 6000 and 단가 > 3000;

select * from 제품;

-- between : A 이상 B 이하일 때 사용
select 제품명 from 제품
	where 단가 between 3000 and 6000;

-- in : 여러 값 중 하나를 만족하는 경우
-- 제조업체가 대한식품 또는 민국푸드인 제품들을 확인
select * from 제품  where 제조업체 = '대한식품' or 제조업체 = '민국푸드' order by  제조업체;
select * from 제품  where 제조업체 in('대한식품', '민국푸드') order by  제조업체;

-- 등급이 silver 또는 gold인 회원의 아이디를 확인
select 고객아이디 from 고객 where 등급 in('silver','gold');

-- 등급이 silver 또는 gole인 회원이 주문한 제품명을 확인
select distinct 고객이름, 등급, 제품명 from 주문
	join 제품 on 제품번호 = 주문제품
    join 고객 on 고객아이디 = 주문고객
    where 등급 in('silver','gold');
    
-- 가격이 2600원 이상인 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품
	where 단가 >= 2600;
    
-- 서브쿼리 : 쿼리문 안에 들어가 있는 쿼리
-- select () from () [where ()];
-- 쿵떡파이의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품
	where 단가 >= (select 단가 from 제품 where 제품명='쿵떡파이');
    
-- 그냥만두의 가격보다 크거나 같고 또는 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품 
	where 단가 >= (select 단가 from 제품 where 제품명='그냥만두') and
    단가 >= (select 단가 from 제품 where 제품명='얼큰라면')
    order by 제조업체;
select 제품명, 단가 from 제품
	where 단가 >= (select max(단가) from 제품 where 제품명 in ('얼큰라면', '그냥만두'));

-- all() : 전부를 만족하는 경우들만 확인. AND
select 제품명, 단가 from 제품
	where 단가 >= all(select 단가 from 제품 where 제품명 in ('얼큰라면', '그냥만두'));
    
-- any() : 하나이상 만족하는 경우들만 확인. OR
-- 그냥만두의 가격보다 크거나 같거나 얼큰라면의 가격보다 크거나 같은 제품의 제품명과 단가를 확인
select 제품명, 단가 from 제품 
	where 단가 >= (select 단가 from 제품 where 제품명='그냥만두') or
    단가 >= (select 단가 from 제품 where 제품명='얼큰라면')
    order by 제조업체;
select 제품명, 단가 from 제품
	where 단가 >= any(select 단가 from 제품 where 제품명 in ('얼큰라면', '그냥만두'));
select 제품명, 단가 from 제품
	where 단가 >= (select min(단가) from 제품 where 제품명 in ('얼큰라면', '그냥만두'));

-- group by : where절 다음에 나와야 함, order by 앞에 와야함, 같은 그뤂끼리 묶어줌
-- gruop by는 distict처럼 보일 수 있다.
select * from 제품 group by 제조업체;
select distinct 제조업체 from 제품  제조업체;

-- 대한식품에서 만든 제품 개수 확인
select 제조업체, count(*) from 제품 group by 제조업체;
    
-- 한번 이상 주문한 고객별 주문한 주문 횟수
select 주문고객, count(*) as '주문 횟수' from 주문 group by 주문고객;

-- 한번 이상 주문한 고객별 고객의 총 주문 개수
select 주문고객, sum(수량) as '총주문개수' from 주문 group by 주문고객;

-- 한번 이상 주문한 고객별 고객의 총 주문 금액을 확인
select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
	join 제품 on 제품번호 = 주문제품
	group by 주문고객
    order by `총 주문 금액`;


-- 한번 이상 주문한 고객중 총 주문 금액이 100000원 이상인 고객 확인
-- where 절에는 group by로 작업한 집약함수를 이용한 조건을 걸 수 없다
-- having 절은 group by로 작업한 내용에 조건을 걸어줄 때 사용
select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
	join 제품 on 제품번호 = 주문제품
	group by 주문고객
	having `총 주문 금액` >= 100000
    order by `총 주문 금액`;
select 주문고객, sum(수량*단가) as '총 주문 금액' from 주문 
	join 제품 on 제품번호 = 주문제품
	group by 주문고객
	having sum(수량*단가) >= 100000
    order by `총 주문 금액` ASC;
    
    
-- 제품별 주문한 제품 번호와 주문 수량(제품의 누적 주문량), 제조업체을 확인
select 제품번호, sum(수량) as '누적 주문량', 제조업체 from 주문 
	join 제품 on 제품번호 = 주문제품
    group by 주문제품
    order by 제조업체;
    
-- 제조업체별 가장 많이 팔린 제품을 제조업체, 제품번호, 주문수량을 확인
select 제품번호, max(`누적 주문량`) as '최고 판매량' , 제조업체 from (select 제품번호, sum(수량) as '누적 주문량', 제조업체 from 주문 
				join 제품 on 제품번호 = 주문제품
				group by 주문제품
				order by 제조업체) as `제품별 판매량`
	group by 제조업체;
    
-- with rollup : 부분 총합을 구해줌
select 주문제품, 주문고객, sum(수량) from 주문
	group by 주문제품, 주문고객
    with rollup;
    
-- limit : 검색 결과의 갯수를 제한할때 사용
-- limit 정수1 : 정수1개만큼 결과를 보여줌
-- limit 번지, 정수1 : 번지부터 정수1개의 결과를 보여줌
select * from 주문 limit 5;		-- 처음 5개
-- 한번에 주문내역을 확인할 수 있는 갯수가 5개인 경우로, 1페이지에 해당
select * from 주문 limit 0,5;	-- 0번지부터 5개
-- 한번에 주문내역을 확인할 수 있는 갯수가 5개인 경우로, 2페이지에 해당
select * from 주문 limit 5,5;	-- 5번지부터 5개
-- 한번에 주문내역을 확인할 수 있는 갯수가 5개인 경우로, 3페이지에 해당
select * from 주문 limit 10,5;	-- 10번지부터 5개  5*(3-1) : 한페이지에 보여지는 갯수 * (페이지번호 - 1)

-- 가장 많은 금액을 사용한 고객 아이디를 확인
select 주문고객 as `최고금액사용자` from (select 주문고객, sum(수량*단가) as 구매금액 from 주문
	join 제품 on 주문제품 = 제품번호
    group by 주문고객) as `고객별 사용금액`    
    order by 구매금액 desc
    limit 1;
    
-- 가장 많은 제품 개수를 구매한 고객 아이디를 확인
select 주문고객 as `최고수량구매자` from (select 주문고객, sum(수량) as 구매총량 from 주문
	group by 주문고객
    order by 구매총량 desc) as `고객별 구매총량`
    limit 1;

-- 20대가 구매한 제품 목록을 확인
select 주문제품, 주문고객, 나이 from 주문
	join 고객 on 고객아이디 = 주문고객
    where 나이 between 20 and 29;

-- 20대가 가장 많이 구매한 제품을 확인
select 제품명 as `20대가 가장 많이 구매한 제품` from (select 제품명, sum(수량) as `구매총량` from 주문
	join 고객 on 고객아이디 = 주문고객
    join 제품 on 제품번호 = 주문제품
    where 나이 between 20 and 29
    group by 주문제품
    order by 구매총량 desc) as `20대가 주문한 제품목록`
    limit 1;
