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

# Ví dụ [06.Adapter]
==============================================================

**Ý tưởng: Chuyển đổi interface/class giữa các lớp khác nhau để chúng hoạt động tương thích với nhau**<br/>

**Tham khảo**
- https://gpcoder.com/4483-huong-dan-java-design-pattern-adapter/
- https://viblo.asia/p/adapter-design-pattern-tro-thu-dac-luc-cua-developers-Az45bqYQlxY

**Ví dụ Translation minh hoạ Adapter Pattern:**<br/>
- Vietnamese gửi đi 1 message đến cho Japanese và mong đợi bên kia sẽ hiểu được message.
- Bản thân Japanese chỉ hiểu được Japanese language.
- Do vậy, ta sẽ cần 1 Adatper để chuyển đổi VN Language sang JP Language trước khi gửi qua cho Japanese
- Thay vì gọi jpAdaptee.receive(msg) thì ta sẽ bọc JapaneseAdaptee bên trong một Adapter và gọi adapter.receive(msg). 
Phần còn lại để Adapter lo :)


**Mã nguồn tham khảo**
```shell
public class TranslatorAdapter implements VietnameseTarget {
  Logger log = LoggerFactory.getLogger(getClass());

  private JapaneseAdaptee jpAdaptee;

  public TranslatorAdapter(JapaneseAdaptee jpAdaptee) {
    this.jpAdaptee = jpAdaptee;
  }

  @Override
  public void send(String words) {
    log.info("[TranslatorAdapter] :: Reading Words: " + words);
    String jpWords = this.translate(words);

    log.info("[TranslatorAdapter] :: Sending JP Words: " + jpWords);
    jpAdaptee.receive(jpWords);
  }

  private String translate(String vnWords) {
    log.info("[TranslatorAdapter] :: Translated! the VN words: " + vnWords);
    return vnWords + "[こんにちは]";
  }
```

```shell
log.info(" >> Start Apps for Adapter Pattern ... ");
log.info(" ------------------------------------------------------------------------------");
VietnameseTarget client = new TranslatorAdapter(new JapaneseAdaptee());

String vnWords = "Xin chào!";
log.info("[Client] :: Try to send words: " + vnWords);
client.send(vnWords);

--------------------------------------------------------------------------------

> Task :MainApp.main()
12:41:29.085 [main] INFO  -  >> Start Apps for Adapter Pattern ... 
12:41:29.090 [main] INFO  -  ------------------------------------------------------------------------------
12:41:29.093 [main] INFO  - [Client] :: Try to send words: Xin chào!
12:41:29.093 [main] INFO  - [TranslatorAdapter] :: Reading Words: Xin chào!
12:41:29.093 [main] INFO  - [TranslatorAdapter] :: Translated! the VN words: Xin chào!
12:41:29.094 [main] INFO  - [TranslatorAdapter] :: Sending JP Words: Xin chào![こんにちは]
12:41:29.095 [main] INFO  - [JapaneseAdaptee] :: Retrieving words from Adapter ... Xin chào![こんにちは]
12:41:29.096 [main] INFO  - [JapaneseAdaptee] :: Try to process next step with words: Xin chào![こんにちは]
12:41:29.097 [main] INFO  -  ------------ FINISH -------------

```