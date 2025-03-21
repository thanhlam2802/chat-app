<template>
  <div class="w-[75%] border-b border-gray-200 p-5">
    <div class="grid grid-cols-3 gap-4">
      <div v-for="map in users" :key="map.user.id" class="bg-gray-900 text-white p-4 rounded-lg shadow-md">
        <div class="flex items-center justify-between">
          <div class="flex items-center space-x-3">
            <img class="w-12 h-12 rounded-full border-2 border-red-500" :src="`/images/${map.user.avt}`" alt="Avatar" />
            <div>
              <p class="font-semibold">{{ map.user.name }}</p>
              <p class="text-gray-400 text-sm">Người lạ</p>
            </div>
          </div>
          <i class="fa-solid fa-comments text-gray-400"></i>
        </div>

        <a v-if="map.relationship == null" class="mt-3 block text-center w-full bg-gray-700 text-white py-2 rounded-lg hover:bg-gray-600 transition" @click="adfriend(map.user.id)"> 
          Kết bạn
        </a>
        <p v-else-if="map.relationship.status == false && map.relationship.gui == user.id" class="mt-3 block text-center w-full bg-gray-700 text-white py-2 rounded-lg hover:bg-gray-600 transition" > Đang chờ 
          kết bạn
        </p>
        <p @click="accecpt(map.relationship.id)" v-else-if="map.relationship.status == false && map.relationship.nhan == user.id" class="mt-3 block text-center w-full bg-gray-700 text-white py-2 rounded-lg hover:bg-gray-600 transition" > Chấp nhận
        </p>
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
    adfriend (id){
      console.log("lấy id"+id);
      
      fetch(`http://localhost:8080/api/addFriend/${id}`, {
        method: "GET",
        credentials: "include",
      });
      alert("Đã gửi lời mời !")
      window.location.href = 'http://localhost:5173/chat';
    },
    accecpt(id){
      fetch(`http://localhost:8080/api/accecpt/${id}`, {
        method: "GET",
        credentials: "include",
      });
      alert("Đã kết bạn !")
      window.location.href = 'http://localhost:5173/chat';
     
    }
  },
};
</script>
