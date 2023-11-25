package demo.main;

import demo.base.BankType;
import demo.factory.BankFactory;

import java.util.logging.Logger;

public class MainApp {

  static Logger log = Logger.getLogger(MainApp.class.getName());

  public static void main(String[] args) {
    log.info(" >> Start Apps ... ");
    log.info(" ... Bank 1: " + BankFactory.createBank(BankType.ACB));
    log.info(" ... Bank 2: " + BankFactory.createBank(BankType.TPB));
    log.info(" ... Bank 3: " + BankFactory.createBank(BankType.VCB));
    log.info(" ------------ FINISH -------------");
  }


}