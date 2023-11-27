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

# Ví dụ [07.ChainOfResponsibility]
==============================================================

**Ý tưởng: Gửi 1 yêu cầu qua một chuỗi các Handler cho đến khi nào nó được xử lý thì thôi**<br/>

**Tham khảo**
- https://gpcoder.com/4665-huong-dan-java-design-pattern-chain-of-responsibility/
- https://viblo.asia/p/chain-of-responsibility-design-pattern-tro-thu-dac-luc-cua-developers-yMnKMBNDZ7P

**Ví dụ Chain of Responsibility Pattern với ứng dụng LeaveRequest:**<br/>
- Nghỉ <= 3 days: có thể được approve bởi Supervisor
- Nghỉ <= 5 days: có thể được approve bởi DeliveryManager
- Nghỉ > 5 days: cần approve bởi Director


**Mã nguồn tham khảo**
```shell
public abstract class Approver {

  Logger log = LoggerFactory.getLogger(getClass());

  protected Approver nextApprover;

  public void approveLeave(LeaveRequest request) {
    log.info("[Approver] :: Checking permission for " + this.getClass().getSimpleName());
    if (this.canApprove(request.getDays())) {
      log.info("[Approver] :: GOOD, leave request can be approved by " + this.getClass().getSimpleName());
      this.doApproving(request);
    } else if (nextApprover != null) {
      nextApprover.approveLeave(request);
    }
  }
```

```shell
public class LeaveRequestWorkFlow {
  public static Approver getApprover() {
    Approver supervisor = new Supervisor();   // 1st
    Approver manager = new DeliveryManager(); // 2nd
    Approver director = new Director();       // 3rd

    supervisor.setNext(manager);
    manager.setNext(director);

    return supervisor;
  }
}

--------------------------------------------------------------------------------

log.info(" >> Start Apps for Chain of Responsibility Pattern ... ");
log.info(" ------------------------------------------------------------------------------");
Approver mainApprover = LeaveRequestWorkFlow.getApprover();

log.info(" ---------------------------------------------");
mainApprover.approveLeave(new LeaveRequest(2));

log.info(" ---------------------------------------------");
mainApprover.approveLeave(new LeaveRequest(5));

log.info(" ---------------------------------------------");
mainApprover.approveLeave(new LeaveRequest(7));

---------------------------------------------------------------------------------

> Task :MainApp.main()
15:23:29.346 [main] INFO  -  >> Start Apps for Chain of Responsibility Pattern ... 
15:23:29.350 [main] INFO  -  ------------------------------------------------------------------------------
15:23:29.352 [main] INFO  -  ---------------------------------------------
15:23:29.354 [main] INFO  - [Approver] :: Checking permission for Supervisor
15:23:29.354 [main] INFO  - [Approver] :: GOOD, leave request can be approved by Supervisor
15:23:29.361 [main] INFO  - [Supervisor] :: Leave request approved for 2 days by Supervisor
15:23:29.361 [main] INFO  -  ---------------------------------------------
15:23:29.361 [main] INFO  - [Approver] :: Checking permission for Supervisor
15:23:29.361 [main] INFO  - [Approver] :: Checking permission for DeliveryManager
15:23:29.361 [main] INFO  - [Approver] :: GOOD, leave request can be approved by DeliveryManager
15:23:29.362 [main] INFO  - [DeliveryManager] :: Leave request approved for 5 days by Delivery Manager
15:23:29.363 [main] INFO  -  ---------------------------------------------
15:23:29.363 [main] INFO  - [Approver] :: Checking permission for Supervisor
15:23:29.364 [main] INFO  - [Approver] :: Checking permission for DeliveryManager
15:23:29.364 [main] INFO  - [Approver] :: Checking permission for Director
15:23:29.364 [main] INFO  - [Approver] :: GOOD, leave request can be approved by Director
15:23:29.364 [main] INFO  - [Director] :: Leave request approved for 7 days by Director
15:23:29.364 [main] INFO  -  ------------ FINISH -------------

```