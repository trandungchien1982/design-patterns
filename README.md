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

# Ví dụ [04.Builder]
==============================================================

**Tham khảo**
- https://gpcoder.com/4434-huong-dan-java-design-pattern-builder/
- https://www.baeldung.com/java-builder-pattern-freebuilder
- https://www.javastackflow.com/2022/09/how-to-use-builder-design-pattern-with.html
- https://www.baeldung.com/lombok-builder

**Sử dụng Builder Pattern với việc chia nhỏ setter methods bên trong Builder :**<br/>
- Các methods setter option sẽ được gọi linh động lúc tạo instance mới
- Mỗi lần gọi setter option nối tiếp thì sẽ trả về Object Builder để xử lý tiếp
- Khi hoàn tất Builder Object, ta sẽ gọi method build() của Builder để tạo Object thực tế.

**Tạo BankAccount dựa vào BankAccountBuilder**
```shell
log.info(" >> Start Apps for Builder Pattern ... ");

BankAccount account1 = new BankAccount.BankAccountBuilder("name1", "MobileNumber01")
    .withAddress("The Address 01")
    .withEmail("email01@test.com")
    .wantNewsletter(true)
    .build();

BankAccount account2 = new BankAccount.BankAccountBuilder("name2", "MobileNumber02")
    .build();

BankAccount account3 = new BankAccount.BankAccountBuilder("name3", "MobileNumber03")
    .withAddress("The Address 03")
    .wantMobileBanking(true)
    .build();

log.info("[MainApp] :: The account1: " + account1);
log.info("[MainApp] :: The account2: " + account2);
log.info("[MainApp] :: The account3: " + account3);

------------------------------------------------------------------------------------------

> Task :MainApp.main()
10:21:01.934 [main] INFO  -  >> Start Apps for Builder Pattern ... 
10:21:01.938 [main] INFO  - -------------------------------------------------------------
10:21:01.939 [main] INFO  - [BankAccountBuilder] :: Setting name/accountNumber
10:21:01.939 [main] INFO  - [BankAccountBuilder] :: Setting address
10:21:01.939 [main] INFO  - [BankAccountBuilder] :: Setting email
10:21:01.939 [main] INFO  - [BankAccountBuilder] :: Setting newsletter
10:21:01.939 [main] INFO  - [BankAccountBuilder] :: Try to build concrete Bank Account object: ... 
10:21:01.940 [main] INFO  - -------------------------------------------------------------
10:21:01.940 [main] INFO  - [BankAccountBuilder] :: Setting name/accountNumber
10:21:01.940 [main] INFO  - [BankAccountBuilder] :: Try to build concrete Bank Account object: ... 
10:21:01.940 [main] INFO  - -------------------------------------------------------------
10:21:01.940 [main] INFO  - [BankAccountBuilder] :: Setting name/accountNumber
10:21:01.940 [main] INFO  - [BankAccountBuilder] :: Setting address
10:21:01.940 [main] INFO  - [BankAccountBuilder] :: Setting mobileBanking
10:21:01.940 [main] INFO  - [BankAccountBuilder] :: Try to build concrete Bank Account object: ... 
10:21:01.974 [main] INFO  - [MainApp] :: The account1: BankAccount [name=name1, accountNumber=MobileNumber01, address=The Address 01, email=email01@test.com, newsletter=true, mobileBanking=false]
10:21:01.974 [main] INFO  - [MainApp] :: The account2: BankAccount [name=name2, accountNumber=MobileNumber02, address=null, email=null, newsletter=false, mobileBanking=false]
10:21:01.974 [main] INFO  - [MainApp] :: The account3: BankAccount [name=name3, accountNumber=MobileNumber03, address=The Address 03, email=null, newsletter=false, mobileBanking=true]
10:21:01.974 [main] INFO  -  ------------ FINISH -------------

```


**Apply Builder Pattern bằng cách sử dụng annotation `@FreeBuilder`**<br/>
(Dựa vào dependency: `https://mvnrepository.com/artifact/org.inferred/freebuilder`)
```shell
@FreeBuilder
public interface Employee {
 
    String name();
    int age();
    String department();
    
    class Builder extends Employee_Builder {
    }
```

**Apply Builder Pattern bằng cách sử dụng annotation `@Builder` trong Lombok**<br/>
(Dựa vào dependency: https://mvnrepository.com/artifact/org.projectlombok/lombok, version 1.18.30)
```shell
@Builder
public class Widget {
  private String name;
  private Date birthday;
  private int age;
}
```

**Ứng dụng thực tế**
- Sử dụng trong khai báo của Spring Security
```shell
UserDetails user = User
    .withUsername("user")
    .password("$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
    .roles("USER_ROLE")
    .build();
```