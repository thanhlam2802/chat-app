<script setup>
import { ref, onMounted } from 'vue';
import Sidebar from './views/Sidebar.vue';
import Content from './views/Content.vue';
// const message = ref('');

// const fetchMessage = async () => {
//   try {
//     const response = await fetch('/api/hello');
//     if (!response.ok) throw new Error('Failed to fetch data');
//     const data = await response.text();
//     message.value = data;
//   } catch (error) {
//     console.error('Error:', error);
//     message.value = 'Error fetching data';
//   }
// };

// onMounted(fetchMessage);
</script>

<template>
  <div class="flex h-screen w-full bg-gray-100">
      <Sidebar />
      <Content />
  </div>
</template>