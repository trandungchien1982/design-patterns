package demo.facade_pattern.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShippingService {

  Logger log = LoggerFactory.getLogger(getClass());

  public void freeShipping() {
    log.info("[ShippingService] :: Free Shipping");
  }

  public void standardShipping() {
    log.info("[ShippingService] :: Standard Shipping");
  }

  public void expressShipping() {
    log.info("[ShippingService] :: Express Shipping");
  }

}