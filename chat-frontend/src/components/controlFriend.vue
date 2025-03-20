
<template>
  <div class="w-[25%] flex-col flex h-screen bg-white px-3">
    <div class="flex justify-between mb-4 p-4  w-full border-gray-300 border-dotted border-b-2">
      <h1 class="text-2xl font-bold">Bạn bè</h1>
      <i class="fa-solid fa-users text-xl text-gray-600"></i>
    </div>
    <div class="flex relative items-center space-x-4 my-1 p-2 hover:bg-gray-100 rounded-lg cursor-pointer"  @click="changeContent('viewFriend')">
      <i class="fa-solid fa-users-between-lines text-gray-500 text-lg mx-4 "></i>
      <div class="flex justify-between">
        <div>
          <span class="font-bold mr-3">Danh sách bạn bè</span>
        </div>
      </div>
    </div>
    <div class="flex relative items-center space-x-4 my-1 p-2 hover:bg-gray-100 rounded-lg cursor-pointer" 
       @click="changeContent('viewNotFriend')"
    >
      
      <i class="fa-solid fa-user-clock  text-gray-500 text-lg mx-4"></i>
      <div class="flex justify-between">
        <div>
          <span class="font-bold mr-3">Bạn có thể biết</span>
        </div>
      </div>
    </div>
    <div class="flex relative items-center space-x-4 my-1 p-2 hover:bg-gray-100 rounded-lg cursor-pointer">
      
      <i class="fa-solid fa-user-check  text-gray-500 text-lg mx-4"></i>
      <div class="flex justify-between">
        <div>
          <span class="font-bold mr-3">Đang hoạt động</span>
        </div>
      </div>
    </div>
    <div class="flex relative items-center space-x-4 my-1 p-2 hover:bg-gray-100 rounded-lg cursor-pointer">
      <i class="fa-solid fa-user-group text-gray-500 text-lg mx-4 "></i>
      <div class="flex justify-between">
        <div>
          <span class="font-bold mr-3">Tạo nhóm chat</span>
        </div>
      </div>
    </div>
  </div>

</template>
  <script setup>
import { defineEmits } from "vue";


const emit = defineEmits(["updateContent"]);

const changeContent = (name) => {
  console.log("gửi yêu cầu chuyển ");
  
  emit("updateContent", name);
};
</script>