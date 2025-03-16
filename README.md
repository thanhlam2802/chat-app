# ChatApp - Ứng dụng Chat Real-time

## Giới thiệu
ChatApp là một ứng dụng chat real-time được xây dựng bằng **Spring Boot** và **Vue.js**, hỗ trợ nhắn tin cá nhân và nhóm với các loại tin nhắn văn bản, hình ảnh, file.

## Tính năng chính
- ✅ Nhắn tin 1-1 và nhóm
- ✅ Trạng thái tin nhắn: **Đã gửi, Đã xem**
- ✅ Hỗ trợ tin nhắn **văn bản, hình ảnh, file**
- ✅ **WebSocket** cho chat real-time
- ✅ Giao diện **hiện đại, mượt mà** với Vue.js
- ✅ **Bảo mật** với JWT Authentication (đang phát triển)

## Công nghệ sử dụng
- **Frontend**: Vue.js, Vuex, Tailwind CSS
- **Backend**: Spring Boot, WebSocket, JWT, MongoDB
- **Realtime**: WebSocket, STOMP
- **Lưu trữ file**: AWS S3 / Firebase Storage
- **Triển khai**: Docker, AWS

## Hướng dẫn cài đặt
### Yêu cầu
- Java 17+
- Node.js 18+
- MongoDB 6+
- Maven

### Cài đặt Backend
```bash
git clone https://github.com/your-username/chat-app.git
cd chat-app/backend
mvn clean install
mvn spring-boot:run
```

### Cài đặt Frontend
```bash
cd chat-app/frontend
npm install
npm run dev
```

## API Endpoint chính
| Phương thức | Endpoint | Chức năng |
|------------|---------|----------|
| POST | `/api/auth/login` | Đăng nhập |
| POST | `/api/auth/register` | Đăng ký |
| GET | `/api/messages` | Lấy danh sách tin nhắn |
| POST | `/api/messages` | Gửi tin nhắn |

(Chi tiết hơn có thể để link tài liệu API Swagger)

## Ảnh Demo
<img width="1433" alt="Ảnh màn hình 2025-03-16 lúc 17 01 56" src="https://github.com/user-attachments/assets/66ede996-a962-468a-ae79-b1fa916a0410" />

<img width="1433" alt="Ảnh màn hình 2025-03-16 lúc 17 02 12" src="https://github.com/user-attachments/assets/a77905ef-a363-45df-a00e-75b1014687ac" />


## Đóng góp
👨‍💻 Nếu bạn muốn đóng góp, hãy tạo một **pull request** hoặc mở một **issue**!

## Thành viên thực hiện

🧑‍💻 Võ Lê Thanh Lâm

🧑‍💻 Phan Huỳnh Phúc Khang

