<script setup>
import { ref, watch } from 'vue';
import Sidebar from '../views/Sidebar.vue';
import Content from '../views/Content.vue';
import controlFriend from "../components/controlFriend.vue";
import viewFriend from "../components/viewFriend.vue";
import viewNotFriend from "../components/viewNotFriend.vue";
const props = defineProps({
  user: Object,
});

const messages = ref([]);
const nameroom = ref("");  
const avt = ref("");  
const isClick = ref(false);
const img = ref("");
const ContentCPN = ref(Content);
const SidebarCPN = ref(Sidebar);

watch(() => props.user, async (newUser) => {
  console.log("User mới:", newUser);
  if (newUser && newUser.avt) {
    img.value = '/images/' + newUser.avt;
  }
}, { immediate: true });

const logout = () => {
  console.log("Chạy logout");
  fetch("http://localhost:8080/api/logout", {
    method: "GET",
    credentials: "include",
  });
  window.location.href = "http://localhost:5173";
};

const handleClickStatus = (status) => {
  isClick.value = status;  
};

const handleMessagesFetched = (newMessages) => {
  console.log("Tin nhắn mới nhận:", newMessages);
  messages.value = newMessages.messages;
  nameroom.value = newMessages.nameroom; 
  avt.value = newMessages.avt; 
};

// Hàm thay đổi component khi click vào button
const changeComponent = (content, sidebar) => {
  ContentCPN.value = content;
  SidebarCPN.value = sidebar;
};
const updateContent = (newContent) =>{
    if (newContent =='viewNotFriend'){
      ContentCPN.value = viewNotFriend;
    }else  if (newContent =='viewFriend'){
      ContentCPN.value = viewFriend;
    }
  }
</script>

<template>
  <div class="flex h-screen w-full bg-gray-100">
    <!-- Sidebar menu -->
    <div class="flex flex-col items-center justify-between">
      <div class="w-16 flex flex-col items-center py-4 space-y-1">
        <button
          @click="changeComponent(Content, Sidebar)"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fas fa-comment-dots text-xl text-gray-600"></i>
        </button>

        <button 
          @click="changeComponent(viewFriend, controlFriend)"
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
      
      <div>
        <div class="w-12 overflow-hidden h-12 flex items-center my-3 justify-center rounded-full hover:bg-red-500 hover:text-white transition">
          <img v-if="img" class="w-full" :src="img" alt="Avatar" />
        </div>

        <a
          @click.prevent="logout"
          class="w-12 mb-3 block h-12 flex items-center justify-center border-2 border-gray-600 rounded-full hover:bg-red-500 hover:text-white transition"
        >
          <i class="fa-solid fa-right-from-bracket"></i>
        </a>
      </div>
    </div>







    <!-- Sidebar động -->
    <component :is="SidebarCPN" :user="user" @clickStatus="handleClickStatus" @messages-fetched="handleMessagesFetched" @updateContent="updateContent"/>

    <!-- Content động -->
    <component 
      :is="ContentCPN" 
      :user="user" 
      :messages="messages" 
      :nameroom="nameroom" 
      :avt="avt" 
      :isClick="isClick" 
    />
  </div>
</template>

