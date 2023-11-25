package demo;

import java.util.logging.Logger;

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

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      SingletonLazy appInstance = SingletonLazy.getInstance();
      log.info(" ----------------------------------------------------- ");
      log.info(" >> appInstance LAZY: " + appInstance);
    }
  }
}
