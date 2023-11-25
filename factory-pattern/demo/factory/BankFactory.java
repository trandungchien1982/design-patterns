package demo.factory;

import demo.base.Bank;
import demo.base.BankType;
import demo.impls.ACBBank;
import demo.impls.TpBank;
import demo.impls.VietcomBank;
import demo.main.MainApp;

import java.util.logging.Logger;

public class BankFactory {

  static Logger log = Logger.getLogger(MainApp.class.getName());

  private BankFactory() {}

  public static final Bank createBank(BankType bankType) {
    log.info("-------------------------------------------------");
    log.info(" >> Try to create new Bank with type: " + bankType);

    switch (bankType) {
      case VCB: return new VietcomBank();
      case ACB: return new ACBBank();
      case TPB: return new TpBank();
    }

    return null;
  }
}
