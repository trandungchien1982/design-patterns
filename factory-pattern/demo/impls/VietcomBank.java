package demo.impls;

import demo.base.Bank;

public class VietcomBank implements Bank {

  public VietcomBank() {}

  @Override
  public String getBankName() {
    return "Vietcombank";
  }
}