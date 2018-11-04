# 如何配置webapp和Servlet

1. 下载tomcat
2. 下载maven
3. 设置tomcat和maven的系统变量
4. 在IDEA中新建一个maven项目
5. 在IDEA中新建一个JAVA EE项目，或者添加一个JAVA EE模块，注意添加数据库连接、Servlet、JSP、WebApp库和框架
6. 在运行/调试配置中配置Tomcat，包括端口、tomcat路径、要打开的浏览器等
7. 注意添加servlet-api.jar、tomcat-api.jar到外部库
8. 注意检查项目的Artifact，如果没有，则需要从模块创建（Web Application:Exploded/Achieve），以生成war包。
8. 在web目录下编辑index.html或index.asp，编译好后将class文件放到web/WEB-INF/classes目录下。
9. 在src文件夹中新建java类，继承自servlet相关的类和接口(`GenericServlet`,`HttpServlet`)，重载实现相关方法。
10. 编辑web/WEB-INF目录下的web.xml文件，指定servlet映射和欢迎页，示例如下。

```xml
    <servlet>
        <!--Servlet名称-->
        <servlet-name>HelloWorld</servlet-name>
        <!--完整的类名-->
        <servlet-class>tests.HelloWorld</servlet-class>
    </servlet>

    <servlet-mapping>
        <!--Servlet名称-->
        <servlet-name>HelloWorld</servlet-name>
        <!--对外访问的虚拟路径-->
        <url-pattern>/hello-world</url-pattern>
    </servlet-mapping>

    <!--首页列表-->
    <welcome-file-list>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.jsp</welcome-file>
    </welcome-file-list>
```

11. 构建好项目后，直接运行index.html或index.jsp，
12. 不需要手动启动tomcat服务器，且需要确保是关闭的。停止运行则表示与服务器断开连接。
13. 此后会直接打开欢迎页。
