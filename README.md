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

# Ví dụ [08.Prototype]
==============================================================

**Ý tưởng: Tạo object mới bằng cách nhân bản từ 1 Object Template mẫu có sẵn thay vì xây dựng nó từ đầu**<br/>

**Tham khảo**
- https://gpcoder.com/4413-huong-dan-java-design-pattern-prototype/
- https://viblo.asia/p/prototype-design-pattern-tro-thu-dac-luc-cua-developers-GrLZDBQO5k0
- https://viblo.asia/p/gioi-thieu-ve-prototype-design-pattern-aWj53Bmwl6m

**Ví dụ về nhân bản Computer:**<br/>
- Lớp Computer impements Cloneable và có 1 bản cài đặt chuẩn 
- Với mỗi Computer mới, ta chỉ cần custom lại `setOthers()`
