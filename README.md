# generator-test    dalefe_Web快速生成平台  
## 前端项目  
[前端项目:https://gitee.com/Joker1010/CodeGeneratorView/tree/end_code/](https://gitee.com/Joker1010/CodeGeneratorView/tree/end_code/)  
## 一 环境配置
- JDK1.8，MySQL8.0.11，Maven，Vue2.x。
## 二 项目配置
### 1. 数据库配置
- 需修改application和generator两个文件中的数据库配置，其中前者为生成后的源码服务，后者为生成前访问数据库服务，后者还可设置关于项目根目录以及生成后的源码存放路径等有关路径。
### 2. 数据库访问设置
- 修改util包中的MetadataUtil类中的getTableNames中的meta.getTables参数，默认为test数据库，需修改数据库名称。
## 三 启动配置
- 后端端口8080，前端接口9528，前端启动后自动跳转http://localhost:9528/#/CodeGenerator；
- 生成工作完成后需重启后端，需将生成的类文件加载到系统中方可使用，这里关闭了热加载；
- 生成的前端文件不可被访问，需手动移动到前端项目目录下可自动访问。需要注意最后移动Route文件夹下的index.js文件，否则会报错；
- 具体的文件移动目录如下：  
将后端项目Vue文件夹下的文件夹放置在前端src文件夹下的vues文件夹中；  
将后端项目中Api文件夹下的js文件放在前端src文件夹下；  
将后端项目中的route文件夹下的js文件放在前端src文件夹下的router文件夹下，替换原有的js文件；
### 具体的页面展示图如下
- 生成前：  
![生成前的效果图](https://github.com/dalefe/generator-test/blob/master/src/main/resources/images/%E7%94%9F%E6%88%90%E5%89%8D.png)  
- 生成后：  
![生成后的效果图](https://github.com/dalefe/generator-test/blob/master/src/main/resources/images/%E7%94%9F%E6%88%90%E5%90%8E.png)  
- 关于增删改查的操作：  
![添加](https://github.com/dalefe/generator-test/blob/master/src/main/resources/images/%E6%B7%BB%E5%8A%A0.png)  
![修改](https://github.com/dalefe/generator-test/blob/master/src/main/resources/images/%E4%BF%AE%E6%94%B9.png)  
![查询](https://github.com/dalefe/generator-test/blob/master/src/main/resources/images/%E6%9F%A5%E6%89%BE.png)  
![删除](https://github.com/dalefe/generator-test/blob/master/src/main/resources/images/%E5%88%A0%E9%99%A4.png)




