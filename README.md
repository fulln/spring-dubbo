# spring-dubbo
 a simple dubbo demo
 - 包含common,login,security,service,Mongo,web 项目
    - common项目
        - 包含基础的core项目 util类和redis类，配置文件config项目包含数据源的配置,zookeeper配置，api接口项目
    - login项目
        - 因为我的登录的数据源与service查询的数据源不同，将登录部分单独拿出来做成一个Module
    - security项目
        - 采用spring-security框架 进行页面访问的限制和安全保护，里面包含从数据库进行用户名的验证，用户权限的验证，拦截页面的控制
    - service项目
        - 采用spring+mybatis+Mapper插件+pagehelper插件+redis缓存
    - mongo 项目
        - 采用spring-Mongo的连接 使用MongoTemplate进行对MongoDB的简单的交互
    - web 项目
        - 采用了springmvc框架进行视图控制，包含了登录，查询，拦截后显示的页面，登录失败页面，登录成功主页，前端主要采用的是form+jsp 所以没有写很多东西
         
 说明 
 ---
  该版本还是比较初始的版本，服务提供者为 login service mongo 项目，zookeeper启动统一为各个项目下test文件下main方法启动，zookeeper集群模式，消费者从任一zookeeper进行调用即可访问到所有的接口，由于采用了security，zookeeper必须启动的项目为login项目，不然后台会进行报错。
  需要自行下载的有zookeeper，zookeeper需要集群模式，mongoDB,redis。此处不进行展开
  
 问题
 ---
  在于前端页面技术选型不太行，后续会改成react页面展示。目前没有使用activemq消息控件，没有采用dubbo的监控模式，没有进行jenkings的代码监管，服务没有上云进行远程验证。下个目标进行springcloud的微服务化搭建，任重道远，加油。
