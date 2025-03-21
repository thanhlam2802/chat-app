<script setup>
import { ref, watch, onMounted } from "vue";
import axios from "axios";
import ItemUser from "../components/ItemUser.vue";

const props = defineProps({
  user: Object,
});

const emit = defineEmits(["clickStatus", "messagesFetched"]);
const messages = ref([]);
const img = ref("");
const users = ref([]);
const isClick = ref(false);
const activeIndex = ref(null);
let socket = null;

const connectWebSocket = (userId, roomId) => {
  if (!userId || !roomId) {
    console.warn("Thiếu userId hoặc roomId! Không thể kết nối WebSocket.");
    return;
  }

  // Tạo URL kết nối WebSocket có chứa userId và roomId
  const websocketUrl = `ws://localhost:8080/ws-chat?userId=${userId}&roomId=${roomId}`;
  socket = new WebSocket(websocketUrl);

  // Khi kết nối thành công
  socket.onopen = () => {
    console.log("Kết nối WebSocket thành công đến:", websocketUrl);
  };

  // Xử lý sự kiện nhận tin nhắn từ server
  socket.onmessage = (event) => {
    const data = JSON.parse(event.data);
    console.log("Nhận tin nhắn từ server:", data);

    // Cập nhật danh sách tin nhắn khi nhận được
    messages.value.push(data);
  };

  socket.onerror = (error) => {
    console.error("Lỗi WebSocket:", error);
  };

  socket.onclose = () => {
    console.log("Kết nối WebSocket đã đóng.");
  };
};

const fetchUsers = async (userId) => {
  try {
    if (!userId) {
      console.error("User ID không tồn tại!");
      return;
    }
    const response = await axios.get(`http://localhost:8080/api/friends/${userId}`);
    users.value = response.data;
    console.log("Danh sách bạn bè:", users.value);
  } catch (error) {
    console.error("Lỗi khi lấy danh sách bạn bè:", error);
  }
};

const fetchMessages = (roomId, userInfor) => {
  if (!roomId) {
    console.warn("Room ID không tồn tại!");
    return;
  }
  
  fetch(`http://localhost:8080/api/messages/${roomId}`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error(`Lỗi HTTP! Status: ${response.status}`);
      }
      return response.json();
    })
    .then((data) => {
      console.log("Danh sách tin nhắn nhận được:", data);
      messages.value = data;

      emit("messagesFetched", {
        messages: messages.value,
        nameroom: userInfor.name,
        avt: userInfor.avt,
        isClick: true,
      });

      emit("clickStatus", true);
    })
    .catch((error) => {
      console.error("Lỗi khi lấy tin nhắn:", error);
    });
};

watch(
  () => props.user,
  async (newUser) => {
    console.log("User mới:", newUser);
    if (newUser && newUser.avt) {
      img.value = "/images/" + newUser.avt;
    }
    if (newUser && newUser.id) {
      await fetchUsers(newUser.id);
    }
  },
  { immediate: true }
);

onMounted(() => {
  if (props.user?.id) {
    fetchUsers(props.user.id);
  }
});
</script>

<template>
  <div class="flex h-screen">
    <div class="flex-1 bg-white p-4">
      <div class="flex items-center justify-between mb-4">
        <h1 class="text-2xl font-bold">Đoạn chat</h1>
      </div>

      <div class="relative mb-4">
        <input
          class="w-full p-2 pl-10 rounded-full bg-gray-100 border border-gray-300 focus:outline-none"
          placeholder="Tìm kiếm trên chat-app"
          type="text"
        />
      </div>

      <div class="space-y-4">
        <ItemUser
          v-for="(userData, index) in users"
          :key="userData?.user?.id"
          :avatar="userData?.user?.type === undefined ? '/images/' + userData?.user?.avt : '/images/group.png'"
          :name="userData?.user?.name"
          :time="userData?.latestMessage?.thoiGian ? new Date(userData?.latestMessage?.thoiGian).toLocaleString('vi-VN') : 'Không có thời gian'"
          :message="userData?.latestMessage?.noiDung || 'Không có tin nhắn'"
          :size="userData?.user?.type !== undefined ? userData?.user?.members?.length : null"
          :class="{'active-item': index === activeIndex}"
          @click="() => {
            activeIndex = index;
            if (userData?.latestMessage?.idRoom && props.user?.id) {
              connectWebSocket(props.user.id, userData.latestMessage.idRoom);
              fetchMessages(userData.latestMessage.idRoom, {
                name: userData?.user?.name,
                avt: userData?.user?.type === undefined ? '/images/' + userData?.user?.avt : '/images/group.png'
              });
            } else {
              console.warn('Không thể tải tin nhắn do thiếu idRoom hoặc userId');
            }
          }"
        />
      </div>
    </div>
  </div>
</template>

<style scoped>
.active-item {
  background-color: #f0f0f0;
}
</style>
