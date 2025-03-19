<script setup>
import AVT from "./Avt.vue";
import { ref, watchEffect, toRefs } from "vue";
import { onClickOutside } from "@vueuse/core"; 

const props = defineProps({
  message: Object, 
  isCurrentUser: Boolean, 
});

const { message } = toRefs(props);
const isMenuVisible = ref(false);
const menuRef = ref(null); 
const preview = ref(null);

const isLink = (text) => {
  const urlPattern = /^(https?:\/\/[^\s]+)$/;
  return urlPattern.test(text);
};

const fetchPreview = async (url) => {
  try {
    const response = await fetch(`http://localhost:8080/api/link-preview?url=${encodeURIComponent(url)}`);
    const data = await response.json();

    if (!data || data.error) {
      console.error("Lỗi API:", data.error || "Không có dữ liệu");
      return;
    }

    preview.value = {
      url: data.url,
      title: data.title,
      description: data.description,
      image: data.image,
    };
  } catch (error) {
    console.error("Lỗi khi lấy preview link:", error);
  }
};

const toggleMenu = () => {
  isMenuVisible.value = !isMenuVisible.value;
};

const copyMessage = (messageCopy) => {
  navigator.clipboard.writeText(messageCopy);
  isMenuVisible.value = false;
};

watchEffect(() => {
  if (message.value && isLink(message.value.noiDung)) {
    fetchPreview(message.value.noiDung);
  }
});

onClickOutside(menuRef, () => {
  isMenuVisible.value = false;
});
</script>

<template>
  <div class="flex items-end my-2 group" :class="{ 'justify-end': isCurrentUser, 'justify-start': !isCurrentUser }">
    <AVT v-if="!isCurrentUser" :src="'/images/' + message.avtNguoiGui" size="sm" class="mr-2" />

    <div class="relative flex space-x-2 opacity-0 group-hover:opacity-100 transition-opacity duration-200" 
         :class="{ 'order-first mr-2': isCurrentUser, 'order-last ml-2': !isCurrentUser }">
      <button class="w-6 h-6 bg-white rounded-full flex items-center justify-center shadow">
        <i class="fas fa-quote-right text-gray-600 text-[10px] hover:text-blue-600"></i>
      </button>
      <button class="w-6 h-6 bg-white rounded-full flex items-center justify-center shadow">
        <i class="fas fa-share text-gray-600 text-[10px] hover:text-blue-600"></i>
      </button>
      <button @click="toggleMenu" class="relative w-6 h-6 bg-white rounded-full flex items-center justify-center shadow">
        <i class="fas fa-ellipsis-h text-gray-600 text-[10px] hover:text-blue-600"></i>
      </button>

      <div v-if="isMenuVisible" ref="menuRef"
        class="absolute right-0 top-full mt-1 bg-white rounded-lg shadow-lg z-10 w-max">
        <div class="flex items-center space-x-2 p-2 hover:bg-gray-100 rounded cursor-pointer" @click="copyMessage(message.noiDung)">
          <i class="fas fa-copy text-gray-600"></i>
          <span class="text-sm text-gray-600">Copy tin nhắn</span>
        </div>
      </div>
    </div>

    <div class="p-2 max-w-xs rounded-lg text-sm"
      :class="{'bg-white p-4 rounded-lg shadow text-black': !isCurrentUser, 'bg-blue-500 rounded-lg shadow text-white self-end': isCurrentUser}">
      <div v-if="message">
        <div v-if="isLink(message.noiDung)">
       
          <a :href="message.noiDung" target="_blank" class=" underline">
            {{ message.noiDung }}
          </a>
          
          <div v-if="preview">
            <div class=" m-1 p-3 bg-white rounded-[5px] ">
              <img v-if="preview.image" :src="preview.image" class="w-full h-32 object-cover rounded-t-lg" alt="Preview Image">
            </div>
            <p v-if="preview.title" class="font-bold mt-1">{{ preview.title }}</p>
            <p v-if="preview.description" class="text-gray-600 text-sm">{{ preview.description }}</p>
          </div>
        </div>

        <div v-else>
          <div>{{ message.noiDung }}</div>
        </div>
      </div>
      <div class="text-xs text-black mt-1">
        {{ new Date(message.thoiGian).toLocaleTimeString("vi-VN", { hour: "2-digit", minute: "2-digit", hour12: false }) }}
      </div>
    </div>
  </div>
</template>
