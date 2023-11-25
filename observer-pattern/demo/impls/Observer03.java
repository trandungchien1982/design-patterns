package demo.impls;

import demo.base.Observer;
import demo.main.MainApp;

import java.util.logging.Logger;

public class Observer03 implements Observer {

  Logger log = Logger.getLogger(MainApp.class.getName());

  @Override
  public void consume(String message) {
    log.info(" >> Consume message on Observer03, message: " + message);
  }
}