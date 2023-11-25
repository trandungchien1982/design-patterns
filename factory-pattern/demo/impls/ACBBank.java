package demo.impls;

import demo.base.Bank;

public class ACBBank implements Bank {

  @Override
  public String getBankName() {
    return "Asian Commercial Bank";
  }
}