1.创建对应的数据库表
Enum类：
申请信息表(ApplicationsStatus)的状态，申请中、申请通过、申请不通过
咨询消息表(ConsultationMessagesType)的类型，留学顾问、移民律师、签证官员
帖子表(ForumPostsType)的类型，签证、移民、留学
移民(ImmigrationType)的类型，技术移民、投资移民、家庭团聚
人员(OccupationType)的类型，学生、社会人员
签证(VisaType)的类型，旅游签证、留学签证、工作签证、探亲签证、申根签证
NORMAL_USER(0,"普通用户"),
STUDY_ABROAD_CONSULTANT(1,"留学顾问"),
IMMIGRATION_LAWYER(2,"移民律师"),
VISA_OFFICER(3,"签证官员"),
SUPER_ADMINISTRATOR(4,"超级管理员");

### 第三天：完成律师、律师咨询、签证官员、签证咨询、留学顾问表的增删改查
1. 完成留学顾问表的增删改查
2. 完成律师表的增删改查
3. 完成签证官员的增删改查
4. 但是并未对接口进行测试