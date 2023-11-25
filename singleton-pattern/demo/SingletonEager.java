package demo;

import java.util.logging.Logger;

public class SingletonEager {
  private static SingletonEager instance = new SingletonEager();

  static Logger log = Logger.getLogger(SingletonEager.class.getName());

  // Prevent initialization directly
  private SingletonEager() {}

  public static SingletonEager getInstance() {
    return instance;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      SingletonEager appInstance = SingletonEager.getInstance();
      log.info(" ----------------------------------------------------- ");
      log.info(" >> appInstance EAGER: " + appInstance);
    }
  }
}
