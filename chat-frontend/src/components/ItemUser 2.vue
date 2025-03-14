<script setup>
import Avatar from './Avt.vue';

const props = defineProps({
  avatar: String,
  name: String,
  time: String,
  message: String,
});
</script>

<template>
  <div class="flex items-center space-x-4 p-2 hover:bg-gray-100 rounded-lg cursor-pointer">
    <Avatar :src="avatar || 'https://via.placeholder.com/40'" size="md" />
    <div class="flex-1">
      <div class="flex justify-between">
        <span class="font-bold mr-3">{{ name || 'Nguyen Minh Phuong' }}</span>
        <span class="text-gray-500 text-sm">{{ time || '31 tuần' }}</span>
      </div>
      <p class="text-gray-500 truncate">{{ message || 'Nếu bạn k lấy nhá...' }}</p>
    </div>
    <i class="fas fa-ellipsis-h text-gray-500"></i>
  </div>
</template>
