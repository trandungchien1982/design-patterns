# Design Patterns
Series về tìm hiểu 23 Design Patterns GoF/ Demo thực tế<br/>
Mỗi nhánh trong Repo sẽ là 1 ví dụ/ giải pháp/ cho 1 Design Pattern cụ thể<br/>

# Môi trường phát triển
- JDK 8/ 11 hoặc 17

# Build Tools sử dụng
- Maven + Gradle
- Intelij IDEA

# Folder liên quan trên Windows
```
D:\Projects\design-patterns
```

==============================================================

# Ví dụ [01.Singleton]
==============================================================

**Tham khảo**
- https://viblo.asia/p/hoc-singleton-pattern-trong-5-phut-4P856goOKY3
- https://gpcoder.com/4190-huong-dan-java-design-pattern-singleton/
- https://www.baeldung.com/spring-boot-singleton-vs-beans

**Tạo Singleton dạng Eager (instance được khởi tạo ngay từ đầu):**<br/>
```shell
public class SingletonEager {
  private static SingletonEager instance = new SingletonEager();

  static Logger log = Logger.getLogger(SingletonEager.class.getName());

  // Prevent initialization directly
  private SingletonEager() {}

  public static SingletonEager getInstance() {
    return instance;
  }
  ......................................................
```


**Tạo Singleton dạng Lazy (khi gọi tới thì mới khởi tạo instance):**<br/>
```shell
public class SingletonLazy {
  private static SingletonLazy instance = new SingletonLazy();

  static Logger log = Logger.getLogger(SingletonLazy.class.getName());

  // Prevent initialization directly
  private SingletonLazy() {}

  public static SingletonLazy getInstance() {
    if (instance == null) {
      instance = new SingletonLazy();
    }
    return instance;
  }
  ........................................................
```

**Tạo Singleton dạng Lazy+ThreadSafe (xử lý đa luồng):**<br/>
```shell
public class SingletonThreadSafe {
  private static SingletonThreadSafe instance = null;

  static Logger log = Logger.getLogger(SingletonThreadSafe.class.getName());

  // Prevent initialization directly
  private SingletonThreadSafe() {}

  public static SingletonThreadSafe getInstance() {
    if (instance == null) {
      log.info(" ... The instance == null, thread: " + Thread.currentThread().getName());

      // Some stuffs before initialization
      doSomeStuffs();

      // Synchronize the initialization of instance only
      synchronized(SingletonThreadSafe.class) {
        if (instance == null) {
          instance = new SingletonThreadSafe();
          log.info(" >> Init new instance for ThreadSafe, instance: " + instance + ", thread: " + Thread.currentThread().getName());
        }
      }
    }
    return instance;
  }

...........................................................................................

Nov 25, 2023 6:19:12 PM demo.SingletonThreadSafe lambda$static$0
INFO:  >> Start Thread 01, thread: Thread-0
Nov 25, 2023 6:19:12 PM demo.SingletonThreadSafe getInstance
INFO:  ... The instance == null, thread: Thread-0
Nov 25, 2023 6:19:13 PM demo.SingletonThreadSafe getInstance
INFO:  ... The instance == null, thread: main
Nov 25, 2023 6:19:14 PM demo.SingletonThreadSafe getInstance
INFO:  >> Init new instance for ThreadSafe, instance: demo.SingletonThreadSafe@d058a25, thread: Thread-0
Nov 25, 2023 6:19:14 PM demo.SingletonThreadSafe lambda$static$0
INFO:  ----------------------------------------------------- 
Nov 25, 2023 6:19:14 PM demo.SingletonThreadSafe lambda$static$0
INFO:  >> appInstance ThreadSafe: demo.SingletonThreadSafe@d058a25, thread: Thread-0
Nov 25, 2023 6:19:15 PM demo.SingletonThreadSafe main
INFO:  -------------------Index 0 -------------- 
Nov 25, 2023 6:19:15 PM demo.SingletonThreadSafe main
INFO:  >> appInstance ThreadSafe: demo.SingletonThreadSafe@d058a25, thread: main
Nov 25, 2023 6:19:16 PM demo.SingletonThreadSafe main
INFO:  -------------------Index 1 -------------- 
Nov 25, 2023 6:19:16 PM demo.SingletonThreadSafe main
INFO:  >> appInstance ThreadSafe: demo.SingletonThreadSafe@d058a25, thread: main
Nov 25, 2023 6:19:17 PM demo.SingletonThreadSafe main
INFO:  -------------------Index 2 -------------- 
Nov 25, 2023 6:19:17 PM demo.SingletonThreadSafe main
INFO:  >> appInstance ThreadSafe: demo.SingletonThreadSafe@d058a25, thread: main

```