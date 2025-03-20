<template>
  <div class="w-[75%] border-b border-gray-200 p-5">
    <div class="grid grid-cols-3 gap-4">
      <div v-for="us in users" :key="us.id" class="bg-gray-900 text-white p-4 rounded-lg shadow-md">
        <div class="flex items-center justify-between">
          <div class="flex items-center space-x-3">
            <img class="w-12 h-12 rounded-full border-2 border-red-500" :src="`/images/${us.avt}`" alt="Avatar" />
            <div>
              <p class="font-semibold">{{ us.name }}</p>
              <p class="text-gray-400 text-sm">Người lạ</p>
            </div>
          </div>
          <i class="fa-solid fa-comments text-gray-400"></i>
        </div>
        <button class="mt-3 w-full bg-gray-700 text-white py-2 rounded-lg hover:bg-gray-600 transition">
          Kết bạn
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ViewNotFriend",
  props: {
    user: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      users: [],
    };
  },
  watch: {
    user: {
      immediate: true,
      handler(newVal) {
        if (newVal && newVal.id) {
          this.fetchUsers(newVal.id);
        } else {
          console.error("Không có thông tin user!");
        }
      },
    },
  },
  methods: {
    async fetchUsers(userId) {
      try {
        if (!userId) {
          console.error("User ID không tồn tại!");
          return;
        }
        const response = await axios.get(`http://localhost:8080/api/listNotFriends/${userId}`);
        this.users = response.data;
        console.log("Danh sách không phải bạn bè:", this.users);
      } catch (error) {
        console.error("Lỗi khi lấy danh sách không bạn bè:", error);
      }
    },
  },
};
</script>
