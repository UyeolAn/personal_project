--학생
CREATE TABLE students 
(
  student_id NUMBER NOT NULL 
, student_email VARCHAR2(50) NOT NULL
, student_password VARCHAR2(512) NOT NULL
, student_name VARCHAR2(30) NOT NULL
, student_birth DATE NOT NULL
, student_tel VARCHAR2(20)
, enter_date DATE DEFAULT SYSDATE
, status VARCHAR2(20) NOT NULL
         CHECK (status IN ('NONE', 'SCHEDULED', 'INCLASS', 'FINISH', 'FAIL'))
, lecture_id NUMBER

, CONSTRAINT students_student_id_pk PRIMARY KEY (student_id)
, CONSTRAINT students_student_email_uk UNIQUE (student_email)
, CONSTRAINT students_lecture_id_fk FOREIGN KEY (lecture_id)
             REFERENCES lectures(lecture_id)
);

COMMENT ON COLUMN students.student_id IS '학생 식별번호';
COMMENT ON COLUMN students.student_email IS '학생 이메일';
COMMENT ON COLUMN students.student_password IS '학생 비밀번호';
COMMENT ON COLUMN students.student_name IS '학생 이름';
COMMENT ON COLUMN students.student_birth IS '학생 생년월일';
COMMENT ON COLUMN students.student_tel IS '학생 연락처';
COMMENT ON COLUMN students.enter_date IS '회원가입 날짜';
COMMENT ON COLUMN students.status IS '상태정보';
COMMENT ON COLUMN students.lecture_id IS '신청 강의 ID';





--강의
CREATE TABLE lectures 
(
  lecture_id NUMBER NOT NULL 
, lecture_name VARCHAR2(30) NOT NULL
, lecture_discription VARCHAR2(100)
, lecture_start_date DATE
, lecture_end_date DATE
, num_students NUMBER DEFAULT 0 NOT NULL
, max_num_students NUMBER DEFAULT 22 NOT NULL
, is_started CHAR(1) DEFAULT 'N' NOT NULL CHECK (is_started IN ('Y', 'N')) 

, CONSTRAINT lectures_lecture_id_pk PRIMARY KEY (lecture_id)
, CONSTRAINT lectures_lecture_name_uk UNIQUE (lecture_name)
);

COMMENT ON COLUMN lectures.lecture_id IS '강의 식별번호';
COMMENT ON COLUMN lectures.lecture_name IS '강의 이름';
COMMENT ON COLUMN lectures.lecture_discription IS '강의 설명';
COMMENT ON COLUMN lectures.lecture_start_date IS '강의 시작일';
COMMENT ON COLUMN lectures.lecture_end_date IS '강의 종료일';
COMMENT ON COLUMN lectures.num_students IS '인원수';
COMMENT ON COLUMN lectures.max_num_students IS '최대 인원수';
COMMENT ON COLUMN lectures.is_started IS '시작여부';





--강사
CREATE TABLE teachers 
(
  teacher_id NUMBER NOT NULL 
, teacher_name VARCHAR2(30) NOT NULL
, teacher_email VARCHAR2(50) NOT NULL
, teacher_info VARCHAR2(100)
, teacher_hire_date DATE DEFAULT SYSDATE NOT NULL
, lecture_id NUMBER

, CONSTRAINT teachers_teacher_id_pk PRIMARY KEY (teacher_id)
, CONSTRAINT teachers_teacher_email_uk UNIQUE (teacher_email)
, CONSTRAINT teachers_lecture_id_fk FOREIGN KEY (lecture_id)
             REFERENCES lectures(lecture_id)
);

COMMENT ON COLUMN teachers.teacher_id IS '강사 식별번호';
COMMENT ON COLUMN teachers.teacher_name IS '강사 이름';
COMMENT ON COLUMN teachers.teacher_email IS '강사 이메일';
COMMENT ON COLUMN teachers.teacher_info IS '강사 정보';
COMMENT ON COLUMN teachers.teacher_hire_date IS '강사 고용일';
COMMENT ON COLUMN teachers.lecture_id IS '담당 강의 ID';





--관리자
CREATE TABLE staffs 
(
  staff_id NUMBER NOT NULL 
, staff_email VARCHAR2(50) NOT NULL
, staff_password VARCHAR2(512) NOT NULL
, staff_name VARCHAR2(30)
, staff_hire_date DATE DEFAULT SYSDATE NOT NULL
, is_master CHAR(1) DEFAULT 'N' NOT NULL CHECK (is_master IN ('Y', 'N'))

, CONSTRAINT staffs_staff_id_pk PRIMARY KEY (staff_id)
, CONSTRAINT staffs_staff_email_uk UNIQUE (staff_email)
);

COMMENT ON COLUMN staffs.staff_id IS '관리자 식별번호';
COMMENT ON COLUMN staffs.staff_email IS '관리자 이메일';
COMMENT ON COLUMN staffs.staff_password IS '관리자 비밀번호';
COMMENT ON COLUMN staffs.staff_name IS '관리자 이름';
COMMENT ON COLUMN staffs.staff_hire_date IS '관리자 고용일';
COMMENT ON COLUMN staffs.is_master IS '관리자 직원 여부';





--수강신청
CREATE TABLE enrollments 
(
  enrollment_id NUMBER NOT NULL 
, enrollment_date DATE DEFAULT SYSDATE NOT NULL
, is_enrolled CHAR(1) DEFAULT 'N' NOT NULL CHECK (is_enrolled IN ('Y', 'N')) 
, student_id NUMBER
, lecture_id NUMBER

, CONSTRAINT enrollments_enrollment_id_pk PRIMARY KEY (enrollment_id)
, CONSTRAINT enrollments_student_id_fk FOREIGN KEY (student_id)
             REFERENCES students(student_id)
, CONSTRAINT enrollments_lecture_id_fk FOREIGN KEY (lecture_id)
             REFERENCES lectures(lecture_id)
);

COMMENT ON COLUMN enrollments.enrollment_id IS '수강신청 식별번호';
COMMENT ON COLUMN enrollments.enrollment_date IS '수강신청 날짜';
COMMENT ON COLUMN enrollments.is_enrolled IS '수강신청 완료여부';
COMMENT ON COLUMN enrollments.student_id IS '신청 학생 ID';
COMMENT ON COLUMN enrollments.lecture_id IS '신청 강의 ID';