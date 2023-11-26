# Design Patterns
Series về tìm hiểu 23 Design Patterns GoF/ Demo thực tế<br/>
Mỗi nhánh trong Repo sẽ là 1 ví dụ/ giải pháp/ cho 1 Design Pattern cụ thể<br/>

# Môi trường phát triển
- JDK 8/ 11 hoặc 17

# Build Tools sử dụng
- Maven + Gradle
- Intelij IDEA

# Folder liên quan trên Windows
```
D:\Projects\design-patterns
```

==============================================================

# Ví dụ [05.Facade]
==============================================================

**Ý tưởng: Ẩn đi sự phức tạp của hệ thống con bên trong và đưa ra những phương thức dễ sử dụng cho UserClients**<br/>
**Có thể xem đây là 1 service đặc biệt để gom logic phức tạp của hệ thống vào các hàm đơn giản**

**Tham khảo**
- https://gpcoder.com/4604-huong-dan-java-design-pattern-facade/
- https://viblo.asia/p/facade-design-pattern-tro-thu-dac-luc-cua-developers-924lJBLNlPM

**Tạo 1 `ShopFacade` để cung cấp dịch vụ mua hàng :**<br/>
- Có nhiều dịch vụ con bên trong, bao gồm `AccountService`, `PaymentService`, `ShippingService`, `EmailService`, `SMSService`
- `ShopFacade` cung cấp phương thức mua hàng bằng tiền mặt, thanh toán online, ...
- Mỗi phương thức mua hàng sẽ kèm theo gọi các dịch vụ tương ứng, vd như `EmailService`, `SMSService`
- ClientUsers khi mua hàng chỉ quan tâm đến việc gọi ShopFacade, bỏ qua sự phức tạp khi phải triệu hồi 1 loạt các dịch vụ khác

**Mã nguồn tham khảo**
```shell
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
```

**Kết quả thực thi**
```shell
log.info(" >> Start Apps for Facade Pattern ... ");
log.info(" ------------------------------------------------------------------------------");
ShopFacade.getInstance().buyProductByCashWithFreeShipping("contact@gpcoder.com");

log.info(" ------------------------------------------------------------------------------");
ShopFacade.getInstance().buyProductByPaypalWithStandardShipping(
    "gpcodervn@gmail.com", "0988.999.999");
log.info(" ------------ FINISH -------------");

---------------------------------------------------------------------------------------------------

> Task :MainApp.main()
22:34:23.556 [main] INFO  -  >> Start Apps for Facade Pattern ... 
22:34:23.560 [main] INFO  -  ------------------------------------------------------------------------------
22:34:23.564 [main] INFO  - [ShopFacade] :: Buy product by Cash with FreeShipping, email: contact@gpcoder.com
22:34:23.566 [main] INFO  - [AccountService] :: Getting the account of contact@gpcoder.com
22:34:23.566 [main] INFO  - [PaymentService] :: Payment by cash
22:34:23.566 [main] INFO  - [ShippingService] :: Free Shipping
22:34:23.566 [main] INFO  - [EmailService] :: Sending an email to contact@gpcoder.com
22:34:23.566 [main] INFO  - [ShopFacade] :: Buy product by Cash with FreeShipping => DONE
22:34:23.566 [main] INFO  -  ------------------------------------------------------------------------------
22:34:23.572 [main] INFO  - [ShopFacade] :: Buy product by Paypal with Standard Shipping, email: gpcodervn@gmail.com, mobilePhone: 0988.999.999
22:34:23.573 [main] INFO  - [AccountService] :: Getting the account of gpcodervn@gmail.com
22:34:23.573 [main] INFO  - [PaymentService] :: Payment by Paypal
22:34:23.573 [main] INFO  - [ShippingService] :: Standard Shipping
22:34:23.573 [main] INFO  - [EmailService] :: Sending an email to gpcodervn@gmail.com
22:34:23.575 [main] INFO  - [SMSService] :: Sending an mesage to 0988.999.999
22:34:23.575 [main] INFO  - [ShopFacade] :: Buy product by Paypal ... => DONE
22:34:23.575 [main] INFO  -  ------------ FINISH -------------

```
