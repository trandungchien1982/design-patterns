package demo;

import java.util.logging.Logger;

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

  private static void doSomeStuffs() {
    try {
      Thread.sleep(2000);
    } catch (Exception ex) {}
  }

  private static void doSomeStuffs01() {
    try {
      Thread.sleep(1000);
    } catch (Exception ex) {}
  }

  public static void main(String[] args) {

    thread01.start();

    for (int i = 0; i < 3; i++) {
      doSomeStuffs01();
      SingletonThreadSafe appInstance = SingletonThreadSafe.getInstance();
      log.info(String.format(" -------------------Index %d -------------- ", i));
      log.info(" >> appInstance ThreadSafe: " + appInstance + ", thread: " + Thread.currentThread().getName());
    }
  }

  static Thread thread01 = new Thread(() -> {
    log.info(" >> Start Thread 01, thread: " + Thread.currentThread().getName());
    SingletonThreadSafe appInstance = SingletonThreadSafe.getInstance();
    log.info(" ----------------------------------------------------- ");
    log.info(" >> appInstance ThreadSafe: " + appInstance + ", thread: " + Thread.currentThread().getName());
  });
}
