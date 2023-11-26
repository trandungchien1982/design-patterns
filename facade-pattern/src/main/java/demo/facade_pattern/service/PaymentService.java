package demo.facade_pattern.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentService {

  Logger log = LoggerFactory.getLogger(getClass());

  public void paymentByPaypal() {
    log.info("[PaymentService] :: Payment by Paypal");
  }

  public void paymentByCreditCard() {
    log.info("[PaymentService] :: Payment by Credit Card");
  }

  public void paymentByEbankingAccount() {
    log.info("[PaymentService] :: Payment by E-banking account");
  }

  public void paymentByCash() {
    log.info("[PaymentService] :: Payment by cash");
  }

}