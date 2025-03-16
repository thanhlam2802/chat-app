<script setup>
import AVT from "./Avt.vue";

defineProps({
  message: Object, 
  isCurrentUser: Boolean, 
});

</script>

<template>
  <div class="flex items-end my-2" :class="{ 'justify-end': isCurrentUser, 'justify-start': !isCurrentUser }">
    <AVT v-if="!isCurrentUser" :src="'/images/' + message.avtNguoiGui" size="sm" class="mr-2" />
    <div class="p-2 max-w-xs rounded-lg text-sm"
      :class="{'bg-white p-4 rounded-lg shadow text-black': !isCurrentUser, 'bg-blue-500 rounded-lg shadow text-white self-end': isCurrentUser}">
      <div>{{ message.noiDung }}</div>
      <div class="text-xs text-black mt-1">
        {{ new Date(message.thoiGian).toLocaleTimeString("vi-VN", { hour: "2-digit", minute: "2-digit", hour12: false }) }}
     </div>

    </div>
  </div>
</template>
