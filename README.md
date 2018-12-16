Spring Metadata Test
====================

Try to quantify the overhead of different ways of registering Spring beans, especially component scanning.


```
component-scan wait
```

```
-XX:+UseSerialGC -Xmx64m
-XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining
```

https://stackoverflow.com/questions/33586026/unterstanding-java-printinlining-parameter
http://normanmaurer.me/blog/2014/05/15/Inline-all-the-Things/

