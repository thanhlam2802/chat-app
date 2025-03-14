<script setup>
import ItemUser from '../components/ItemUser.vue';

import { ref, watch } from 'vue';

const props = defineProps({
  user: Object,
});

const img = ref('');
watch(() =>props.user, function (newUser) {
  console.log("watch"+props.user);
  
  if (newUser) {
    img.value = '/images/' + newUser.avt;

  }
}, { immediate: true });

import axios from 'axios';
import { onMounted } from 'vue';
const users = ref([]);
const fetchchUsers = async () =>{
  try {
    const userId = "67ca664cdba853068a93a5df";
    const response = await axios.get(`http://localhost:8080/api/friends/${userId}`);
    users.value = response.data;
    } catch (error) {
      console.error(error);
      }

}
onMounted(fetchchUsers);

</script>

const logout = ()=>{
  console.log("chạy log out");
  
  fetch('http://localhost:8080/api/logout', {
      method: 'GET',
      credentials: 'include',
    });
    window.location.href = 'http://localhost:5173';
}

</script>
<template>
  <div class="flex  h-screen">
    <!-- Sidebar -->
    <form action="#" method="POST" class="flex flex-col items-center justify-between">
      <div class="w-16 flex flex-col items-center py-4 space-y-1">
        <button
          type="submit"
          name="action"
          value="chat"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fas fa-comment-dots text-xl text-gray-600"></i>
        </button>

        <button
          type="submit"
          name="action"
          value="users"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fa-solid fa-user-group text-gray-600"></i>
        </button>

        <button
          type="submit"
          name="action"
          value="messages"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fas fa-comments text-xl text-gray-600"></i>
        </button>

        <button
          type="submit"
          name="action"
          value="delete"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-red-500 hover:text-white transition"
        >
          <i class="fas fa-trash-alt text-xl text-gray-600"></i>
        </button>
        
      </div>
      <div class="">
          <div class="w-12 overflow-hidden h-12 flex items-center my-3 justify-center rounded-full hover:bg-red-500 hover:text-white transition">
            <img v-if="img" class="w-full" :src="img" alt="Avatar" />
          </div>

          <a  @click.prevent="logout"
            class="w-12 mb-3 block h-12 flex items-center justify-center border-2 border-gray-600 rounded-full hover:bg-red-500 hover:text-white transition"
          >
            <i class="fa-solid fa-right-from-bracket"></i>
          </a>
        </div>
    </form>
    <!-- Main Content -->
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
        <ItemUser v-for="userData in users"
      :key="userData.user.id.date"
      :avatar="userData.user.avt"
      :name="userData.user.name"
      :time="new Date(userData.latestMessage.thoiGian).toLocaleString('vi-VN')"
      :message="userData.latestMessage.noiDung"
      ></ItemUser>
    </div>
  </div>
  </div>
  
</template>
