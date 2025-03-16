<script setup>
import { ref } from 'vue';
import Sidebar from '../views/Sidebar.vue';
import Content from '../views/Content.vue';

const props = defineProps({
  user: Object,
});

const messages = ref([]);
const nameroom = ref("");  
const avt = ref("");  
const isClick = ref(false);


const handleClickStatus = (status) => {
  isClick.value = status;  
};

const handleMessagesFetched = (newMessages) => {
  console.log("Tin nhắn mới nhận:", newMessages);
  messages.value = newMessages.messages;
  nameroom.value = newMessages.nameroom; 
  avt.value = newMessages.avt; 
};
</script>

<template>
  <div class="flex h-screen w-full bg-gray-100">
    <Sidebar :user="user" @clickStatus="handleClickStatus" @messages-fetched="handleMessagesFetched" />
    <Content 
      :user="user" 
      :messages="messages" 
      :nameroom="nameroom" 
      :avt="avt" 
      :isClick="isClick" 
    />
  </div>
</template>
