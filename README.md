### Get the list of classes during startup
$ cut -d: -f4 < t.txt | cut -d] -f2 > startup-classes.txt

### Notes
| Component | Note 1 | Note 2 | Note 3 |
| --- | --- | --- | --- |
| ApplicationListener | ApplicationStartingEvent |   |   |
| ApplicationListener | ApplicationEnvironmentPreparedEvent |   |   |
| ApplicationContextInitializer | Runtime setup spring profile<br>loading extra properties file | [https://www.logicbig.com/tutorials/spring-framework/spring-core/tests-context-initializer.html]<br>[https://www.java-success.com/spring-loading-properties-files-with-applicationcontextinitializer/]   |   |
| ApplicationListener | ApplicationContextInitializedEvent |   |   |
| ApplicationListener | ApplicationPreparedEvent |   |   |
| ImportSelector | @Import<br>@EnableBlahBlah | [https://www.logicbig.com/tutorials/spring-framework/spring-core/import-selector.html]<br>[https://gist.github.com/bijukunjummen/08f73cb7b3055d65a729]<br>[https://gorkemgok.com/enable-annotations-for-better-spring-libraries-5a467a028e06]  |   |
| DeferredImportSelector |     | [https://www.logicbig.com/tutorials/spring-framework/spring-core/deferred-import-selector.html]<br>[https://www.cnblogs.com/xfeiyun/p/15675230.html]  |   |
| ImportBeanDefinitionRegistrar |     | [https://www.logicbig.com/tutorials/spring-framework/spring-core/import-bean-registrar.html]<br>[https://segmentfault.com/a/1190000040585229]  |   |
| BeanDefinitionRegistryPostProcessor's postProcessBeanDefinitionRegistry |     | [https://www.logicbig.com/tutorials/spring-framework/spring-core/bean-definition.html]  |   |
| BeanDefinitionRegistryPostProcessor's postPrcessBeanFactory |     |   |   |
| BeanFactoryPostProcessor |     | [https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-beanfactorypostprocessor.html]  |   |
| BeanPostProcessor postProcessBeforeInitialization  for bean 1187779195|     | [https://djcodes.wordpress.com/frameworks/core-spring-basics/core-spring-beanpostprocessor-beanfactorypostprocessor/]<br>[https://www.logicbig.com/tutorials/spring-framework/spring-boot/custom-configuration-properties-binding.html]  |   |
| @PostConstruct for BeanA 1187779195|     |   |   |
| BeanPostProcessor postProcessAfterInitialization for bean 1187779195|     |   |   |
| @Bean within @Configuration for beanA 1752856108  |     |   |   |
| BeanPostProcessor postProcessBeforeInitialization for bean 1752856108 |     |   |   |
| @PostConstruct for BeanA 1752856108 |     |   |   |
| BeanPostProcessor postProcessAfterInitialization  for bean 1752856108 |     |   |   |
| ApplicationListener | ApplicationStartedEvent |   |   |
| ApplicationListener | ApplicationReadyEvent |   |   |

```
* ApplicationContextInitializer

What is an ApplicationContextInitializer. It is essentially code that gets executed before the Spring application context gets completely created. A good use case for using an ApplicationContextInitializer would be to set a Spring environment profile programmatically

* ImportSelector 

can be used for dynamic configuration selection rather than static @Profile based selection.
Spring framework itself uses ImportSelector at many places to ease the configuration burden on the client side, for example @EnableAsync, @EnableScheduling etc

@Import annotation can also be configured with an ImportSelector implementation to select @Configuration classes programmatically, based on some selection criteria

* DeferredImportSelector 

It extends ImportSelector.

The configuration class directly registered with the application context given preference over imported one. That means a bean of type T, configured in the main configuration will be used instead of a bean of the same type T from imported configuration. That applies to ImportSelector as well. On the other hand, DeferredImportSelector applies after all other configuration beans have been processed.

DeferredImportSelector applies configuration after all @Configuration beans have been processed.

* ImportBeanDefinitionRegistrar 
This Interface is to be implemented by types that register additional bean definitions when processing @Configuration classes. 

An implementation can be specified with @Import so that additional objects can be registered as Spring beans during configuration time. 


我们要自己写一个组件，我们要自己管理我们的组件，使用自己的注解管自己的Bean。 这时候ImportBeanDefinitionRegistrar就登场了！

我们要求把某个包下的类都加到容器、另外呢，我还要加一个自定义注解，只有在这个包下加了自定义注解的才能被加到容器！

* BeanDefinitionRegistryPostProcessor

Implementation of BeanDefinitionRegistryPostProcessor can be used to register objects as Spring beans programmatically.

This is a sub-interface of BeanFactoryPostProcessor (last example). It allows for the registration of bean definitions. It's method postProcessBeanDefinitionRegistry is called before BeanFactoryPostProcessor#postProcessBeanFactory. This interface is more focused on the BeanDefinition registration rather than general purpose BeanFactoryPostProcessor.

* BeanFactoryPostProcessor 

BeanFactoryPostProcessor is an extension point to customize configuration metadata. This example registers a new BeanDefinition with beanFactory. 

allows client code to customize bean definitions. The method BeanFactoryPostProcessor.postProcessBeanFactory is called by Spring startup process just after all bean definitions have been loaded, but no beans have been instantiated yet. 

A BeanFactoryPostProcessor lets you modify the actual bean definition instead of the instance as it’s created. The PropertyResourceConfigurer and PropertyPlaceholderConfigurer are two very useful BeanFactoryPostProcessors.  Creatinng out custom Factory post processor:

* BeanPostProcessor 

gives you a chance to process an instance of a bean created by the IoC container after it’s instantiation and then again after the initialization lifecycle event has occurred on the instance. BeanPostProcessor and any beans they depend on are instantiated before any other beans in the container. After they are instantiated and ordered, they are used to process all the other beans as they are instantiated by the IoC container. Spring’s different AOP proxies for caching, transactions, etc. are all applied by BeanPostProcessors.


This converter should be registered as a Spring Bean and should also be annotated with @ConfigurationPropertiesBinding which is a Qualifier annotation. The ConfigurationPropertiesBindingPostProcessor is responsible to bind all external properties to the beans annotated with @ConfigurationProperties. This BeanPostProcessor also detects custom converters (besides the default ones) annotated with @ConfigurationPropertiesBinding for type conversion.
```

### Articles
* Further read
  * https://xinchen.blog.csdn.net/article/details/105061662?spm=1001.2014.3001.5502 
  * https://segmentfault.com/u/lenve/articles?sort=newest
  * https://www.cnblogs.com/dongguangming/category/1688134.html 

* Auto-configuration in Spring Boot 
  * https://segmentfault.com/a/1190000043859515

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


### Articles
* https://blog.csdn.net/qq1049545450/article/details/112957659?spm=1001.2014.3001.5502
* https://blog.csdn.net/qq1049545450/article/details/112977838 (contains a nice start up diagram)
* https://blog.csdn.net/qq1049545450/article/details/113104783

* https://blog.csdn.net/qq1049545450/article/details/113247619?spm=1001.2101.3001.6650.6&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-6-113247619-blog-121534204.235%5Ev38%5Epc_relevant_sort_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-6-113247619-blog-121534204.235%5Ev38%5Epc_relevant_sort_base3&utm_relevant_index=11

* https://blog.csdn.net/yiding123/article/details/121534204
* https://blog.csdn.net/yiding124/article/details/121475769?spm=1001.2014.3001.5502

* how spring work: https://blog.csdn.net/dong19891210/article/details/106324879?spm=1001.2014.3001.5502
* how import works: https://blog.csdn.net/dong19891210/article/details/106346447 (good)
* enable: https://blog.csdn.net/dong19891210/article/details/105931356
* create bean: https://blog.csdn.net/dong19891210/article/details/105798650

* how enableautoconfiguration works: https://www.javadevjournal.com/spring-boot/how-spring-boot-auto-configuration-works/

* how spring boot auto configuration works: https://dzone.com/articles/how-springboot-autoconfiguration-magic-works
* Very good - Spring Boot - How auto configuration works? https://www.logicbig.com/tutorials/spring-framework/spring-boot/auto-config-mechanism.html

* how spring boot works: https://www.marcobehler.com/guides/spring-boot-autoconfiguration
* how spring security: https://www.marcobehler.com/guides/spring-security
* how oauth: https://www.marcobehler.com/guides/spring-security-oauth2 

---
* How spring boot auto configuration works: https://thepracticaldeveloper.com/spring-boot-autoconfiguration/ (good)

*
  * SpringBoot扩展点之EnvironmentPostProcessor: https://blog.csdn.net/dong19891210/article/details/106436364?spm=1001.2101.3001.6650.5&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-5-106436364-blog-121534204.235%5Ev38%5Epc_relevant_sort_base3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-5-106436364-blog-121534204.235%5Ev38%5Epc_relevant_sort_base3&utm_relevant_index=10
  * Spring boot如何工作 https://blog.csdn.net/dong19891210/article/details/106324879?spm=1001.2014.3001.5502

## logicbig examples
* https://www.logicbig.com/how-to/spring-framework.html
* https://www.logicbig.com/how-to/spring-boot.html
* https://www.logicbig.com/tutorials/spring-framework/spring-boot.html
* https://www.logicbig.com/tutorials/spring-framework.html
  * https://www.logicbig.com/tutorials/spring-framework/spring-core.html
    * https://www.logicbig.com/tutorials/spring-framework/spring-core/alias-for-annotation.html
    * https://www.logicbig.com/tutorials/spring-framework/spring-core/import-bean-registrar.html
    * https://www.logicbig.com/tutorials/spring-framework/spring-core/deferred-import-selector.html
    * https://www.logicbig.com/tutorials/spring-framework/spring-core/import-selector.html
    * https://www.logicbig.com/tutorials/spring-framework/spring-core/bean-definition.html
* how auto configuration works: https://www.logicbig.com/tutorials/spring-framework/spring-boot/auto-config-mechanism.html
* why all methods will return the same instance at multiple calls : https://www.logicbig.com/tutorials/spring-framework/spring-core/java-config.html
### ImportBeanDefinitionRegistrar Examples
* https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-importbeandefinitionregistrar.html
* https://github.com/mbhave/non-magic-demo.git
### ImportSelector
* https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-importselector.html
