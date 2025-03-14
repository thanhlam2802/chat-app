<script setup>
import Avatar from './Avt.vue';

const props = defineProps({
  avatar: String,
  name: String,
  time: String,
  message: String,
  size: Number 
});
console.log("ooooooooooooooooo"+props.avatar);

</script>

<template>
  <div class="flex relative items-center space-x-4 p-2 hover:bg-gray-100 rounded-lg cursor-pointer">
    <Avatar :src="avatar" size="md" />
    <div class="flex-1">
      <div class="flex justify-between">
        <div>
          <span class="font-bold mr-3">{{ name || 'Nguyen Minh Phuong' }}</span>
        </div>
        <span class="text-gray-500 text-sm">{{ time || '31 tuần' }}</span>
      </div>
      <p class="text-gray-500 truncate">{{ message || 'Nếu bạn k lấy nhá...' }}</p>
    </div>
    <i class="fas fa-ellipsis-h text-gray-500"></i>
    <span v-if="size" class="bottom-2 left-6 rounded-full text-center bg-white border-2 border-gray-300 w-[20px] h-[20px] absolute text-red-500 text-sm font-semibold">{{ size }}</span>
  </div>
</template>
