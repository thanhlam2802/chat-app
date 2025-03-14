<script setup>
import avt  from '../components/Avt.vue';
import { ref } from 'vue';
import axios from 'axios';
import { onMounted } from 'vue';


</script>
<template>
  <div class="w-[80%] p-4 border-b border-gray-200">
   <avt/>
    <div class="ml-3">
      <div class="font-semibold">Phan Thịnh</div>
      <div class="text-sm text-gray-500">Đang hoạt động</div>
    </div>
    <div class="ml-auto flex items-center space-x-4">
      <i class="fas fa-phone text-purple-600 text-xl"> </i>
      <i class="fas fa-video text-purple-600 text-xl"> </i>
      <i class="fas fa-info-circle text-purple-600 text-xl"> </i>
    </div>
    <!-- Main Content -->
    <div class="h-[75%] flex flex-col items-center justify-center flex-grow overflow-scroll snap-y">
      <img
        alt="Profile picture of Phan Thịnh"
        class="rounded-full w-24 h-24"
        height="100"
        src="https://storage.googleapis.com/a1aa/image/TN8ftwySmFyfEvSI8g7pcTAwsP8A2UDjGSd4hDreaWQ.jpg"
        width="100"
      />
      <!-- noi dung tin nhan -->
      <div class="mt-4 text-center">
        <div class="font-semibold text-lg">Phan Thịnh</div>
        <div class="text-gray-500">Các bạn là bạn bè trên Facebook</div>
        <div class="text-gray-500">Sống tại Bạc Liêu (thành phố)</div>
      </div>
      
    </div>
    <!-- Footer -->
    <form>
      <div class="flex  p-4 border-t border-gray-200 ">
        <i class="fas fa-plus-circle text-blue-600 text-2xl"> </i>
        <i class="fas fa-image text-blue-600 text-2xl ml-4"> </i>
        <i class="fas fa-sticky-note text-blue-600 text-2xl ml-4"> </i>
        <i class="fas fa-gift text-blue-600 text-2xl ml-4"> </i>
        <div class="flex-grow ml-4">
          <input
            class="w-full p-2 border border-gray-300 rounded-full"
            placeholder="Aa"
            type="text"
          />
        </div>
        <i class="fas fa-thumbs-up text-blue-600 text-2xl ml-4"> </i>
      </div>
    </form>
  </div>
</template>
