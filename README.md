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

# Ví dụ [02.Factory]
==============================================================

**Tham khảo**
- https://gpcoder.com/4352-huong-dan-java-design-pattern-factory-method/
- https://refactoring.guru/design-patterns/factory-method
- https://www.digitalocean.com/community/tutorials/factory-design-pattern-in-java

**Ví dụ như tạo 1 Bank dựa trên BankType (VCB / TPB/ ACB), Factory sẽ sản xuất Object theo yêu cầu của parameters :**<br/>
```shell
  public static void main(String[] args) {
    log.info(" >> Start Apps ... ");
    log.info(" ... Bank 1: " + BankFactory.createBank(BankType.ACB));
    log.info(" ... Bank 2: " + BankFactory.createBank(BankType.TPB));
    log.info(" ... Bank 3: " + BankFactory.createBank(BankType.VCB));
    log.info(" ------------ FINISH -------------");
  }
-------------------------------------------------------------------------------

Nov 25, 2023 7:11:20 PM demo.main.MainApp main
INFO:  >> Start Apps ... 
Nov 25, 2023 7:11:21 PM demo.factory.BankFactory createBank
INFO: -------------------------------------------------
Nov 25, 2023 7:11:21 PM demo.factory.BankFactory createBank
INFO:  >> Try to create new Bank with type: ACB
Nov 25, 2023 7:11:21 PM demo.main.MainApp main
INFO:  ... Bank 1: demo.impls.ACBBank@4f3f5b24
Nov 25, 2023 7:11:21 PM demo.factory.BankFactory createBank
INFO: -------------------------------------------------
Nov 25, 2023 7:11:21 PM demo.factory.BankFactory createBank
INFO:  >> Try to create new Bank with type: TPB
Nov 25, 2023 7:11:21 PM demo.main.MainApp main
INFO:  ... Bank 2: demo.impls.TpBank@7b23ec81
Nov 25, 2023 7:11:21 PM demo.factory.BankFactory createBank
INFO: -------------------------------------------------
Nov 25, 2023 7:11:21 PM demo.factory.BankFactory createBank
INFO:  >> Try to create new Bank with type: VCB
Nov 25, 2023 7:11:21 PM demo.main.MainApp main
INFO:  ... Bank 3: demo.impls.VietcomBank@5f184fc6
Nov 25, 2023 7:11:21 PM demo.main.MainApp main
INFO:  ------------ FINISH -------------

```
