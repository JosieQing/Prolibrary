/*1.试题试卷关联表*/
CREATE TABLE stsjgl
(
  id NUMBER PRIMARY KEY,
  stid NUMBER NOT NULL,
  sjid NUMBER NOT NULL,
  fen NUMBER NOT NULL
)
/*2.试卷*/
create table paper
(  
  id  NUMBER PRIMARY KEY,
  name VARCHAR2(100) not null
)
/*3.科目表*/
create table course
( 
  ID  NUMBER PRIMARY KEY,
  COUSE VARCHAR2(100) not null
)
/*4.题型*/
CREATE TABLE problem_Types
(
  types_id NUMBER PRIMARY KEY,
  types_name Varchar2(50) NOT NULL
)
/*5.试题*/
create table QUESTION
(
  id           NUMBER not null,
  questiontext VARCHAR2(100) not null,
  a            VARCHAR2(100),
  b            VARCHAR2(100),
  c            VARCHAR2(100),
  d            VARCHAR2(100),
  e            VARCHAR2(100),
  boss         NUMBER not null,
  establish    TIMESTAMP(6) not null,
  change       TIMESTAMP(6) not null,
  remark       VARCHAR2(100),
  type_id      NUMBER not null,
  cid          NUMBER not null
)

alter table QUESTION
  add constraint PK_QUESTION primary key (ID)
  using index 


create sequence QUESTION_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 222
increment by 1
cache 20;

/*6.教师基础信息*/
create table TEACHERS
(
  tno      NUMBER not null,
  tname    NVARCHAR2(20) not null,
  tsex     CHAR(2) not null,
  tage     CHAR(4),
  ttel     NVARCHAR2(20),
  hiredate TIMESTAMP(6) not null,
  tremark  NVARCHAR2(200)
)

-- Add comments to the columns 
comment on column TEACHERS.tno
  is '教师工号主键';
comment on column TEACHERS.tname
  is '姓名';
comment on column TEACHERS.tsex
  is '性别';
comment on column TEACHERS.tage
  is '年龄';
comment on column TEACHERS.ttel
  is '联系电话';
comment on column TEACHERS.hiredate
  is '入职时间';
comment on column TEACHERS.tremark
  is '备注';
-- Create/Recreate primary, unique and foreign key constraints 
alter table TEACHERS
  add constraint PRIMARY_KEY_TNO primary key (TNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;
-- Create/Recreate check constraints 
alter table TEACHERS
  add constraint CHECK_TSEX
  check (tsex in('男','女'));

--主键自增
-- Create sequence 
create sequence TEACHER_TNO
minvalue 1001
maxvalue 9999999999999999999999999999
start with 1001
increment by 1
cache 20;

/*7.班级基本信息*/
create table CLASS_SYS
(
  cno        NUMBER not null,
  cname      VARCHAR2(20) not null,
  speciality VARCHAR2(20) not null,
  classnum   NUMBER not null,
  pnum       NUMBER,
  mentor     VARCHAR2(10) not null,
  teacher    VARCHAR2(10) not null,
  start_date TIMESTAMP(6) not null
)

-- Create/Recreate primary, unique and foreign key constraints 
alter table CLASS_SYS
  add constraint CLASS_SYS_PRIMARY_KEY primary key (CNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
/*8.考试*/
create table EXAM_MANAGEMENT
(
  id           NUMBER not null,
  exam_name    VARCHAR2(100),
  remark       VARCHAR2(100),
  paper_name   VARCHAR2(100),
  exam_class   NUMBER,
  total_points NUMBER,
  paper_id     NUMBER,
  total_time   NUMBER,
  start_time   DATE,
  status       NUMBER,
  kszno        NUMBER
)
/*9.主题*/
create table theme
(
  userid   VARCHAR2(100) not null,
  theme    VARCHAR2(100),
  realname VARCHAR2(100) not null
)

-- Create/Recreate primary, unique and foreign key constraints 
alter table theme
  add constraint UID2 primary key (USERID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
/*10.科目表*/
create table COURSE
(
  id    NUMBER not null primary key,
  couse VARCHAR2(40),
)
/*11.用户表*/
create table USER_TABLE
(
  idea       VARCHAR2(40) not null,
  login_name VARCHAR2(200) not null,
  password   VARCHAR2(200) not null,
  s_id       VARCHAR2(40),
  role       VARCHAR2(200) not null,
  remark     VARCHAR2(200),
  t_id       VARCHAR2(40)
)

-- Create/Recreate primary, unique and foreign key constraints 
alter table USER_TABLE
  add constraint ID_PK primary key (IDEA)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

alter table USER_TABLE
  add constraint ACT_DK foreign key (ROLE)
  references character (ID);
alter table USER_TABLE
  add constraint SD_DK foreign key (S_ID)
  references STUDENT (NUM);
alter table USER_TABLE
  add constraint TS_DK foreign key (T_ID)
  references TEACHERS (TNO);
/*12.学生基本信息*/
create table STUDENT
(
  NUM   NUMBER not nullprimary key ,
  name  VARCHAR2(20),
  sex   VARCHAR2(10),
  age   NUMBER,
  cname VARCHAR2(12)
)
-- Create sequence

create sequence STUDENT_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;
/*13.角色*/
create table CHARACTER
(
  id       NUMBER not null,
  role     VARCHAR2(200),
  menu_str VARCHAR2(200)
)
alter table CHARACTER
  add constraint ID primary key (ID)
  using index 
/*14.题型*/
create table PROBLEM_TYPES
(
  types_id   NUMBER not null,
  types_name VARCHAR2(20)
)
-- Create sequence 
create sequence PROBLEM_TYPES_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 41
increment by 1
cache 20;
/*15.客观试题答案表*/
create table answer_kg
(
  kg_id   NUMBER not null,
  kg_answer VARCHAR2(20)
)
alter table answer_kg
  add constraint kg_id primary key (KGID)

/*16.主观试题答案表*/
create table answer_zg
(
  zg_id   NUMBER not null,
  zg_answer VARCHAR2(200)
)
alter table answer_zg
  add constraint zg_id primary key (ZGID)

/*17.主观成绩*/
create table zgcj
(
  stuid   NUMBER not null,
  zg_id VARCHAR2(200),
  exam_id NUMBER,
  score NUMBER
)
/*18.菜单*/
create table MENU
(
  id   NUMBER not null,
  name VARCHAR2(200),
  link VARCHAR2(200)
)
alter table MENU
  add constraint MENU_ID primary key (ID)
  using index 
create sequence CHARACTER_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;
/*19.考试组*/
create table KS_ZU
(
  kszno  NUMBER not null,
  miaosu NVARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table KS_ZU
  add constraint KSZ_EM_KEY primary key (KSZNO)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;









