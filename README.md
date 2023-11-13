### Get the list of classes during startup
$ cut -d: -f4 < t.txt | cut -d] -f2 > startup-classes.txt


* ImportBeanDefinitionPostRegistrar
  * https://www.jianshu.com/p/357eab9ec916

* Bean Definition
  * https://www.jianshu.com/p/17f116da9a70

* Ways to register bean - good article
  * https://www.cnblogs.com/dongguangming/p/12767135.html
  * https://www.cnblogs.com/dongguangming/p/12792789.html

* Spring中@Import的三种情况 
  * https://www.cnblogs.com/dongguangming/p/12963060.html

* Spring IOC 容器源码分析 
  * https://www.cnblogs.com/dongguangming/p/12738061.html

* Spring AOP 源码解析
  * https://www.javadoop.com/post/spring-aop-source

* Spring MVC
  * https://www.cnblogs.com/dongguangming/p/12624070.html


### Non-magic-demo notes
Application
  --> @MagicApplication
    --> @Configuration
    --> @ComponentScan
    --> @EnableMagicAutoConfiguration
      --> @Import(MagicAutoConfigurationImportSelector.class)
        ==> MagicAutoConfigurationImportSelector.class 
          --> loads MagicConfiguration => load config.MagicConfiguration.imports file
            --> Annotate
              --> MvcConfiguration
                --> @EnableWebMvc
              --> DispatcherServletConfiguration
                --> Create DispatcherServlet bean
              --> TomcatConfiguration
                --> create TomcatServletWebServerFactory bean
                --> Autowired with ServerProperties
                  --> Use port number in ServiceProperties to start tomcat engine
  --> @EnableMagicProperties(ServerProperties.class)
    --> @Import(EnableMagicPropertiesRegistrar.class)
      --> EnableMagicPropertiesRegistrar
        --> Find annotation attributes of EnableMagicProperties.class, which is ServerProperties.class
        --> Register bean of ServerProperties.class (found from the annotation of @EnableMagicProperties)

spring.factories
  --> MagicPropertiesPostProcessor 
    --> load and bind properties from magic.properties

TomcatConfiguration
  --> @ConditionalOnAClass(className = "org.apache.catalina.startup.Tomcat")
    --> ConditionalOnAClass
UndertowConfiguration
  --> @ConditionalOnAClass(className = "io.undertow.Undertow")      
    --> ConditionalOnAClass

PropertyPlaceholderConfiguration