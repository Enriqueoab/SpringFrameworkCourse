# SpringFrameworkCourse

Complete Spring course

# Some important/common Spring annotations

If we are working in the default project structure the default scan of classes and components needed to run our application is going tobe able of "see" all the resources to launch it, otherwise if we have a different project file tree or a external component we have to use the annotation below ,in our main class, to scan other packages:

```ruby
@ComponentScan(basePackages{"java.package.of.a.external.class","some.other.component"})
```

The "ComponentScan" annotation is not the best option in large applications so, we can achive the same ,scan externals components, through java configuration rather than the component annotation. What this configuration annotation does is point to spring where to look for configuration parameters, this configuration class is going to define different beans.

In the example below we removed the Service tag of our service classes and in our configuration class we create the beans that we are going to use to get these classes:

```ruby
    
package keep.learning.dependencyinjection.config;

@Configuration
public class MyApplicationCongig {

    @Bean
    ServiceClassExample1 serviceClassExample1() {

        return new PerviceClassExample1;
    }

    @Bean
    ServiceClassExample2 serviceClassExample2() {

        return new PerviceClassExample2;
    }
}

```

The next annotation [@Primary], is needed when we have more than one bean of the same type. When we have differents languages but we are using different beans of the same type. This annotation can be use in a class or in a method and, as we saw before, we can have this implementation in a configuration class the annotation would be the same in a class:

```ruby
    
package keep.learning.dependencyinjection.config;

@Configuration
public class MyApplicationCongig {

    //As we can not have the same name for a method in java we have to override the name of the method
    // and give to the bean a specific name @Bean("primaryService")
    @Profile("ES")
    @Bean("primaryService")
    PrimarySpanishService primarySpanishService() {

        return new PrimarySpanishService();
    }

    @Profile({"EN","default"})
    @Bean
    PrimaryEnglishService primaryService() {

        return new PrimaryEnglishService();
    }

    @Primary
    @Bean
    PrimaryBaseService primaryBaseService() {

        return new PrimaryBaseService();
    }
}

```
