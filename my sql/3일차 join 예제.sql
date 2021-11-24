-- 컴퓨터 개론을 강의하는 교수님 교수번호를 확인하는 쿼리문을 작성하세요.
select le_pr_num from subject
	inner join lecture
		on le_su_num = su_num
    where su_title = '컴퓨터 개론';
select le_pr_num from subject
	join lecture
		on le_su_num = su_num
    where su_title = '컴퓨터 개론';
    
-- 컴퓨터 개론 3분반 강의를 듣는 학생들의 명단을 확인하는 쿼리를 작성하세요.
-- 컴퓨터 개론 3분반 강의를 수강하는 학생들의 명단을 확인하는 쿼리를 작성하세요.
-- 수강테이블
select * from course;
select st_name from course
	join student
		on co_st_num = st_num
    join subject
		on su_num = co_su_num
    where su_class_num = '3' and  su_title = '컴퓨터 개론';
    
-- 2021160123 학번인 홍길동 학생이 수강한 모든 과목명을 확인하는 쿼리를 작성하세요.
select su_title from course
	join subject
		on su_num = co_su_num
    join student
		on co_st_num = st_num
    where st_num = 2021160123 and st_name = '홍길동';

-- 이순신 교수님의 강의를 듣는 학생들 명단을 확인하는 쿼리를 작성하세요.
select st_name from lecture
	join professor
		on pr_num = le_pr_num
    join course
		on le_su_num = co_su_num
	join student
		on st_num = co_st_num
	where pr_name = '이순신';


    


