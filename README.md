Spring Metadata Test
====================

Try to quantify the overhead of different ways of registering Spring beans, especially component scanning.


```
[component-scan|configuration|bean-definition|supplier] [wait|exit]
```

```
-XX:+UseSerialGC -Xmx64m
```

Ideas
-----

`@ImportSelector`

```java
@Configuration
@Import(MyImportSelector.class)
public class MyConfig {

}
```


