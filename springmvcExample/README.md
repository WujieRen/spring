# referenece:
1. Document：
  - ①https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/htmlsingle/
  - ②springmvc-demo\referenceFile\课程九_SpringMVC+MyBatis高级框架技术.pdf
  - ③process_3：https://blog.csdn.net/jsu_9207/article/details/51271799
  - ④process_3.5：https://www.baidu.com/link?url=_QlTe2O95llrgr1xrqTcFJ624ySCvZL_oyVJSO_dT4ktbP6X1ObTVEUZ9H-NivoEMkqdYSA6qR25CGsYO6mIqq&wd=&eqid=b92a891b000588d1000000065af15314
  - ⑤process_3.15：https://blog.csdn.net/u012660464/article/details/53434331
2. Video：
  - ①http://tpcsc.ibeifeng.com/Job/Job/CourseDetail?id=80339a27-8244-4208-88bd-db5e0e60c49c&productId=d9d5a153-cb44-4361-9729-8ce7ebd2a41f&studyPlanArrangeId=a311a331-5810-40d5-bc3f-aabe1da9b267

# process:
1. 了解Spring MVC架构以及请求流程
2. 环境搭建
  - referenceFile_环境搭建.md：https://juejin.im/post/5a66ed0c51882573282192a6
  - ①关于<context-param>：如果不给值，默认为applicationContext.xml，找不到则报错。
  - ②关于<servlet>：
    ```xml
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <!--其中<param-value>**.xml</param-value> 这里可以使用多种写法-->
        <!--1、不写,使用默认值:/WEB-INF/<servlet-name>-servlet.xml-->
        <!--2、<param-value>/WEB-INF/classes/dispatcher-servlet.xml</param-value>-->
        <!--3、<param-value>classpath*:dispatcher-servlet.xml</param-value>-->
        <!--4、多个值用逗号分隔-->
        <!--<param-value>classpath:spring/dispatcher-servlet.xml</param-value>-->
    </init-param>
    ```    
3. demo
  - 3.1 根据控制器Bean的名字将控制器映射到URL
    - BeanNameUrlHandlerMapping
    - SimpleUrlHandlerMapping
    - ControllerClassNameHandlerMapping
    - DefaultAnnotationHandlerMapping——弃用，改为将请求映射使用@RequestMapping注解的控制器和控制方法
        ```xml
        <!-- 记得开启业务组建Annotation -->
        <context:component-scan base-package="com.example.controller"/>
        ``` 
  - 3.2 视图解析器
    - 将逻辑视图的名字与jsp页面进行匹配
    - InternalResourceViewResolver
       - 在web应用程序的war文件中查找视图模板，视图模板的路径根据加完前缀和后缀的逻辑视图名称来确定
       - prefix
       - suffix
       >【这里可以对比参考pdf中的MVC框架模型来理解。这里用了注解就不用用ModelAndView了，更简便。】    
       
  - 3.3 参数传递
    - ①@RequestParam：必须传
    - ②直接通过方法参数传值：可传可不传
  - 3.4 在上个例子的基础上，将参数显示在页面上
    - ①Map<String, Object>【一般不用】
    - ②Model【常用】
  - 3.5 使用SpringMVC实现用户列表
    - User
    - HashMap
    - @RequestMapping(value="/userlist", method=RequestMethod.GET)
  - 3.6 新增用户功能
    - Get
    - Post
    - 在<sf:form>中给定modelAttribute属性时需要增加“ model.addAttribute(new User());”【重点是思路】
    - 字符乱码控制：
        ```xml
        <filter>
            <filter-name>encodingFilter</filter-name>
            <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
            <init-param>
                <param-name>encoding</param-name>
                <param-value>utf-8</param-value>
            </init-param>
        </filter>
        <filter-mapping>
            <filter-name>encodingFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
        ```        
  - 3.7 用户详情展示
    - 错误1：Type Status Report Description The origin server did not find a current representation for the target resource or is not willing to disclose that one exists.
      - 解析：该错误说明没有找到与给定路径对应的view，一般来说要么是路径出错，要么是请求方式不对。——反正是从访问不到正确网页这个角度去思考就对了。
    - 错误2：Model object must not be null
      - 解析：该错误是model.addAttribute或者别的方法参数出现了null类型。说明参数传递过程中或获取时出现了错误。
      - 注意点：
          ```java
          //REST风格访问参数形式、从REST风格的URL中获取参数的方式：
          @RequestMapping(value = "/{username}/show", method = RequestMethod.GET)
          public String show(@PathVariable String username, Model model) {
                User user = users.get(username);
                model.addAttribute("user", user);
                return "user/show";
          }
          ```         
  - 3.8 用户修改
    - ①注意由GET修改完数据后用POST提交时：
      - URL与逻辑视图的映射要加"redirect:"；
      - 且redirect后要跟全路径。
  - 3.9 用户删除
  - 3.10 SpringMVC验证_JSR-303  
    - 引包：
        ```
        <!-- 数据验证 -->
        <dependency>
          <groupId>org.hibernate</groupId>
          <artifactId>hibernate-validator</artifactId>
          <version>5.0.2.Final</version>
        </dependency>
        <dependency>
          <groupId>javax.validation</groupId>
          <artifactId>validation-api</artifactId>
          <version>2.0.1.Final</version>
        </dependency>
        ``` 
    - 添加约束：@NotNull
    - 验证：方法参数加@Valid
    - 消息绑定：BindingResult
    - 消息提示：<sf:errors path="username"/>
      - 问题：不生效。
      - 原因：没有引入hibernate包。
      - 解决：  
        - https://www.oschina.net/question/2617851_2271229  
        - http://www.mkyong.com/spring-mvc/spring-3-mvc-and-jsr303-valid-example/
  - 3.11 局部异常处理
    - 创建异常类
    - 在需要的地方抛出
    - 定义@ExceptionHandler(SelfException.class)
      - 方法中的参数就是捕获的异常对象
      - 方法中定义对错误如何进行处理
  - 3.12 全局异常
    ```
    <bean class="org.springframework.web.servlet.handler.SimpleMappingExceptionResolver">
                    <property name="exceptionMappings">
                        <props>
                            <prop key="UserException">inc/error</prop>
                            <!--<prop key="UserException">inc/error</prop>-->
                        </props>
                    </property>
                </bean>
    ```        
  - 3.13 数据保存到session
    - 第一种：直接用HttpSession
    - 第二种：用@SessionAttributes({"curUser"})
  - 3.14 静态资源处理
    - .xml：<mvc:resources mapping="/statics/**" location="/WEB-INF/statics/" />
    - .jsp：<link rel="stylesheet" type="text/css" href="/statics/css/style.css" />
  - 3.15 单文件上传
    - reference: https://blog.csdn.net/u012660464/article/details/53434331
    - 添加maven依赖和.xml解析器
        ```
        <!-- 文件上传 -->
        <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" >
            <property name="maxUploadSize" value="1024000000"/>
            <property name="defaultEncoding" value="UTF-8" />
            <property name="resolveLazily" value="true" />
        </bean>
        ```     
    - 添加文件域
    - 增加属性enctype
    - 方法上添加参数
    - 文件上传
  - 3.16多文件上传
    - @RequestParam("photo") MultipartFile[] photoes
    - 注意排除文件为空的情况：if (photo.isEmpty()) continue;
  - 3.17返回json数据
    - 引包
    - @ResponseBody


# 从零开始实现spring（一）最简单的IOC
1. web编程：jsp + servlet -> SSH -> SSM（实现分布式架构，前后分离）
2. applicationContext.xml中的bean的本质是什么呢？
  - 简单说，就是从xml文件中读取到bean的定义，spring的bean工厂基于此定义进行bean的创建和装配。然后我们就能轻松地通过getBean()获得实例化的对象，再进一步抽象，就是将一段字符串转化为一个对象实例。
  - 熟悉反射的人可能就能想到了，这不挺像类的反射么，给出类路径获取Class，再使用newInstance获取对象。
  - 没错Spring的对象创建就是大量的使用了反射的方式。
3. demo：一个简单的IOC



