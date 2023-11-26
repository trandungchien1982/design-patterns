package demo.facade_pattern.facade;

import demo.facade_pattern.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShopFacade {
  private static final ShopFacade INSTANCE = new ShopFacade();

  Logger log = LoggerFactory.getLogger(getClass());

  private AccountService accountService;
  private PaymentService paymentService;
  private ShippingService shippingService;
  private EmailService emailService;
  private SmsService smsService;

  private ShopFacade() {
    accountService = new AccountService();
    paymentService = new PaymentService();
    shippingService = new ShippingService();
    emailService = new EmailService();
    smsService = new SmsService();
  }

  public static ShopFacade getInstance() {
    return INSTANCE;
  }

  public void buyProductByCashWithFreeShipping(String email) {
    log.info("[ShopFacade] :: Buy product by Cash with FreeShipping, email: " + email);
    accountService.getAccount(email);
    paymentService.paymentByCash();
    shippingService.freeShipping();
    emailService.sendMail(email);
    log.info("[ShopFacade] :: Buy product by Cash with FreeShipping => DONE");
  }

  public void buyProductByPaypalWithStandardShipping(String email, String mobilePhone) {
    log.info("[ShopFacade] :: Buy product by Paypal with Standard Shipping, email: " + email + ", mobilePhone: " + mobilePhone);
    accountService.getAccount(email);
    paymentService.paymentByPaypal();
    shippingService.standardShipping();
    emailService.sendMail(email);
    smsService.sendSMS(mobilePhone);
    log.info("[ShopFacade] :: Buy product by Paypal ... => DONE");
  }
}
