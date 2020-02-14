# generator-test    dalefe_Web快速生成平台
启动方式
- 单元测试方式：启动方式为BaseTask类中的getBean方法；
- 项目启动，端口8080
- 代码生成访问接口：index返回表名
- 勾选表名访问getBean接口，生成成功即结束
- 目前生成的接口为getBeanName,findListBeanName,insertBeanName,updateBeanName,deleteBeanName
### 一、 将项目整合为SpringBoot项目，为下一步前端搭建做准备；
- 整合两个小项目，将完整的过程与完备的配置整合；
- 大致确定架构，后续根据业务扩充完善；
### 二、 模板业务进度
- Entity已测试成功，下一步将实现Dao模板的设计；
- Dao已测试成功，下一步将设计Mapper模板；
- Mapper已测试成功，下一步将进行service接口设计；
- Service模板完成，测试成功，移除接口——实现模式，下一步直接设计Controller模板及前端的设计；
- controller模板完成，测试成功，下一步将进行前端模板的设计；
### 三、 生成代码整合
- 修改了Mapper文件必须手动移动的bug，可在JAVA目录直接加载
- 修改了Controller模板中的小bug
- 修改了Mapper模板中的返回值，修改为全类名
- 修改了resource拦截ftl模板的bug，前台调用任务生成代码成功
### 四、 前后端联调
- 修改了前后端数据传输的格式
- 修改了一些模板中的bug
- id不可修改，在插入时由后台UUID生成
- 添加跨域@CrossOrigin
- 修改了表头信息的bug
- 增加了目录库不存在即创建功能