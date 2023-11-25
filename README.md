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

# Ví dụ [03.Observer]
==============================================================

**Tham khảo**
- https://viblo.asia/p/design-pattern-observer-V3m5WO8W5O7
- https://www.digitalocean.com/community/tutorials/observer-design-pattern-in-java

**Mô hình tương đồng với cơ chế Pub/Sub với Topic <=> Subject :**<br/>
- Topic/Subject là nơi chứa liên kết đến các Subscribers
- Mỗi khi topic raise lên 1 message thì các subscribers sẽ consume message đó và có xử lý tương ứng<br/>
  (được mô tả trong Subscriber)
```shell
public interface Observer {
  public void consume(String message);
}


public class SubjectTopic {

  private List<Observer> observers = new LinkedList<>();
  public void attach(Observer observer) {
    observers.add(observer);
  }
  public void detach(Observer observer) {
    observers.remove(observer);
  }
  public void publish(String message) {
    for(Observer observer : observers) {
      observer.consume(message);
    }
  }
}

-------------------------------------------------------------------------------

Nov 25, 2023 10:45:33 PM demo.main.MainApp main
INFO:  >> Start Apps for Observer ... 
Nov 25, 2023 10:45:33 PM demo.impls.Observer01 consume
INFO:  >> Consume message on Observer01, message: The message 01 from Topic ... 
Nov 25, 2023 10:45:33 PM demo.impls.Observer02 consume
INFO:  >> Consume message on Observer02, message: The message 01 from Topic ... 
Nov 25, 2023 10:45:33 PM demo.impls.Observer03 consume
INFO:  >> Consume message on Observer03, message: The message 01 from Topic ... 
Nov 25, 2023 10:45:33 PM demo.main.MainApp main
INFO:  ------------- Remove subscriber02 out of list of subscribers ---------- 
Nov 25, 2023 10:45:33 PM demo.impls.Observer01 consume
INFO:  >> Consume message on Observer01, message: New message IX from Topic ... 
Nov 25, 2023 10:45:33 PM demo.impls.Observer03 consume
INFO:  >> Consume message on Observer03, message: New message IX from Topic ... 
Nov 25, 2023 10:45:33 PM demo.main.MainApp main
INFO:  ------------ FINISH -------------

```
