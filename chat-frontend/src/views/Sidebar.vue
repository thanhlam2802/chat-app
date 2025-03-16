<template>
  <div class="flex h-screen">
    <!-- Sidebar -->

    <div class="flex-1 bg-white p-4">
      <!-- Header -->
      <div class="flex items-center justify-between mb-4">
        <h1 class="text-2xl font-bold">Đoạn chat</h1>
        <i class="fas fa-edit text-xl text-gray-600"> </i>
      </div>

      <!-- Search Bar -->
      <div class="relative mb-4">
        <input
          class="w-full p-2 pl-10 rounded-full bg-gray-100 border border-gray-300 focus:outline-none"
          placeholder="Tìm kiếm trên chat-app"
          type="text"
        />
        <i class="fas fa-search absolute left-3 top-2.5 text-gray-500"> </i>
      </div>

      <!-- Chat List -->
      <div class="space-y-4">
        <ItemUser
          v-for="userData in users"
          :key="userData?.user?.id"
          :avatar="userData?.user?.type === undefined ? '/images/'+userData?.user?.avt : '/images/group.png'"
          :name="userData?.user?.name"
          :time="userData?.latestMessage?.thoiGian 
            ? new Date(userData?.latestMessage?.thoiGian).toLocaleString('vi-VN', { hour: '2-digit', minute: '2-digit' })  
            : 'Không có thời gian'"
          :message="userData?.latestMessage?.noiDung || 'Không có tin nhắn'"
          :size="userData?.user?.type !== undefined ? userData?.user?.members?.length : null"
        />
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import ItemUser from "../components/ItemUser.vue";

export default {
  components: {
    ItemUser,
  },
  props: {
    user: Object,
  },
  data() {
    return {
      users: [],
    };
  },
  methods: {
    async fetchUsers(userId) {
      try {
        if (!userId) {
          console.error("User ID không tồn tại!");
          return;
        }
        const response = await axios.get(`http://localhost:8080/api/friends/${userId}`);
        this.users = response.data;
        console.log("Danh sách bạn bè:", this.users);
      } catch (error) {
        console.error("Lỗi khi lấy danh sách bạn bè:", error);
      }
    },
  },
  watch: {
    user: {
      handler(newUser) {
        if (newUser?.id) {
          this.fetchUsers(newUser.id);
        }
      },
      immediate: true,
    },
  },
};
</script>
