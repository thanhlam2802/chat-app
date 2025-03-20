<template>
  <div class="w-[75%] border-b border-gray-200 p-5">
    <div class="grid grid-cols-3 gap-4">
      <div v-for="us in users"  class="bg-gray-900 text-white p-4 rounded-lg shadow-md">
        <div class="flex items-center justify-between">
          <div class="flex items-center space-x-3">
            <img class="w-12 h-12 rounded-full border-2 border-red-500" :src="`/images/${us.user.avt}`" alt="Avatar" />
            <div>
              <p class="font-semibold">{{ us.user.name }}</p>
              <p class="text-gray-400 text-sm">{{us.mutualFr}}</p>
            </div>
          </div>
          <i class="fa-solid fa-comments text-gray-400"></i>
        </div>
        <button class="mt-3 w-full bg-gray-700 text-white py-2 rounded-lg hover:bg-gray-600 transition">
          Nhắn tin
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
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
        const response = await axios.get(`http://localhost:8080/api/listfriends/${userId}`);
        this.users = response.data;
        console.log("Danh sách bạn bè:", this.users);
      } catch (error) {
        console.error("Lỗi khi lấy danh sách bạn bè:", error);
      }
    },
  },
  mounted() {
    if (this.user && this.user.id) {
      this.fetchUsers(this.user.id);
    } else {
      console.error("Không có thông tin user!");
    }
  }
};
</script>
