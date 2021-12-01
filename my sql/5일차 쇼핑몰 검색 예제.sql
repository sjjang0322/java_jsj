/*
-- 카테고리 추가
insert into category(ca_main,ca_sub)
	values('아우터','점퍼'),('아우터','코트'),('상의','티셔츠'),('상의','블라우스/셔츠'),('하의','데님'),('하의','팬츠'),('하의','스커트');
*/
/*
insert into goods 
values(1, '아크 폭스터 패딩', 159000, '패딩입니다', 1),
(2, '엘비아 앙모코트', 229000, '앙모코트입니다', 2),
(3, '클로 다운후드', 99000, '다운 후드입니다', 3),
(4, '파코 레이어드탑', 43000, '탑', 4),
(5, '기모 와이드 데님 팬츠', 43000, '팬츠', 5),
(6, '롤스 버튼 팬츠', 36000, '팬츠', 6)
;

SELECT * FROM shoppingmall.goods;
*/
/*
-- 아이디가 abc123, 비밀번호가 abc123, 이름은 홍길동, 폰번호는 010-1234-5678, 성별은 남자,
-- 주소는 청주시, 우편번호는 1234, 주소 상세는 그린컴퓨터 학원인 회원이 가입을 했다.
insert into member
	value('abc123','abc123','홍길동','010-1234-5678','남자','1');
select * from shoppingmall.member;

insert into address
	values(1,null,'청주시',1234,'그린컴퓨터학원');
select * from shoppingmall.address;
*/
/*
-- 아크 폭스터 패딩이 크기가 s, 색상은 화이트인 제품이 10개 입고 되었다
insert into shoppingmall.option
	values(1,'화이트','s',10,1);
select * from shoppingmall.option;
*/
-- abc123 회원이 아크 폭스터 패딩을 화이트 색상에 s 사이즈를 1개 구매했다
-- order에 insert
/*
insert into shoppingmall.order
	values(1,'abc123',1,now(),1,159000,'결제완료');
update `option` set op_stock = op_stock - 1 where op_num = 1;

select*from shoppingmall.order;

*/

-- abc123 회원이 주문하 아크 폭스터 패딩에 리뷰를 작성
select * from review;
insert into review values(1,'패딩 좋아요', '따뜻하고 좋아요', now(), 5, 1, 'abc123');



-- 분류가 아우터인 모든 제품을 확인

select*from category;
select gd_name from shoppingmall.goods
 join category on ca_num = gd_ca_num
 where ca_main = '아우터';
 
-- 분류가 아우터이고 구매 가능한 모든 제품을 확인
select gd_name as '구매가능한 아우터' from shoppingmall.goods
 join category on ca_num = gd_ca_num
 join `option` on gd_num = op_gd_num
 where ca_main = '아우터' and op_stock > 0;

-- 분류가 아우터이고, 가장 많이 팔린 제품 4가지를 확인
select * from `order`;
select goods.* from goods
	join `option` on gd_num = op_gd_num
    join `order` on op_num = or_op_num
    join category on ca_num = gd_ca_num
    where ca_main = '아우터' and or_state != '주문 취소' and or_state != '환불'
    group by gd_name
    order by sum(or_amount) desc
    limit 4;
    
-- 등록된 아우터 제품의 전체 제품의 갯수를 확인
select count(*) as '아우터 제품의 가짓수' from goods
	join category on ca_num = gd_ca_num
    where ca_main = '아우터';


-- 등록된 아우터 제품을 10개씩 화면에 출력할 때 2페이지에 해당하는 제품을 확인
select goods.* from goods
	join category on ca_num = gd_ca_num
    where ca_main = '아우터'
    limit 10,10;
    
-- abc123 회원이 주문한 횟수
select count(*) as 'abc123회원이 주문한 횟수' from `order`
	where or_me_id = 'abc123';


-- abc123 회원의 상반기 사용 금액
select sum(or_total_price) as 'abc123회원의 상반기 사용금액' from `order`
	where or_me_id = 'abc123' and or_date < 2021-07-01 and or_date >= 2021-01-01 and or_state != '주문 취소' and or_state != '환불';

-- 아크폭스터 패딩에 달린 리뷰들을 확인
select review.* from review
	join goods on re_gd_num = gd_num
    where gd_name = '아크 폭스터 패딩';