<script setup>
import AVT  from '../components/Avt.vue';
import MessageItem from "../components/MessageItem.vue"; 
import Banner from "../components/Banner.vue"
import { nextTick } from 'vue';
import { ref } from 'vue';
import axios from 'axios';
import { onMounted } from 'vue';

const messageSender = ref([]);

defineProps({
  messages: Array,
  nameroom: String,
  avt: String,
  isClick: Boolean,
  user: Object,

});


</script>
<template >
  
  <div  v-if="isClick" class="w-[80%]  p-4 border-b border-gray-200">
   <div class="flex justify-between">
    <AVT :src="avt" size="md"/>
    <div class="ml-3">
      <div class="font-semibold">{{nameroom}}</div>
      <div class="text-sm text-gray-500">Đang hoạt động</div>
    </div>
    <div class="ml-auto flex items-center space-x-4">
      <i class="fas fa-phone text-purple-600 text-xl"> </i>
      <i class="fas fa-video text-purple-600 text-xl"> </i>
      <i class="fas fa-info-circle text-purple-600 text-xl"> </i>
    </div>
    </div>
    <!-- Main Content -->
    <div v-if="messages.length === 0" class="h-[85%] flex flex-col items-center  justify-center flex-grow overflow-scroll snap-y">
      <AVT :src="avt" size="xl"/>
      <!-- noi dung tin nhan -->
      <div class="mt-4 text-center">
        <div class="font-semibold text-lg">{{ nameroom }}</div>
        <div class="text-gray-500">Các bạn là bạn bè trên Facebook</div>
        <div class="text-gray-500">Sống tại Bạc Liêu (thành phố)</div>
      </div>
      
    </div>
    <div v-else class="h-[85%] flex flex-col  flex-grow overflow-scroll snap-y">
      <MessageItem
      v-for="(message, index) in messages"
      :key="index"
      :message="message"
      :isCurrentUser="message.idNguoiGui === user.id"
      />
      
    </div>
    <!-- Footer -->
    <form>
      <div class="flex p-4 border-t border-gray-200 ">
        <i class="fas fa-plus-circle text-blue-600 text-2xl"> </i>
        <i class="fas fa-image text-blue-600 text-2xl ml-4"> </i>
        <i class="fas fa-sticky-note text-blue-600 text-2xl ml-4"> </i>
        <i class="fas fa-gift text-blue-600 text-2xl ml-4"> </i>
        <div class="flex-grow ml-4">
          <input v-model="messageSender"
            class="w-full p-2 border border-gray-300 rounded-full"
            placeholder="Aa"
            type="text"
          />
        </div>

        <i  v-if = "!messageSender" class="fas fa-thumbs-up text-blue-600 text-2xl ml-4"> </i>
        <i v-else class="fas fa-paper-plane text-blue-600 text-2xl ml-4"></i>
      </div>
    </form>
  </div>
  <div  v-else class="w-[80%] p-1 ">
    <Banner/>
  </div>


</template>

