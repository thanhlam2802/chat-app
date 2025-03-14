<template>
    <div class="flex h-screen w-full bg-gray-100">
      <Sidebar :user="user" />
      <Content />
    </div>
  </template>
  
  <script setup>
  import Sidebar from '../views/Sidebar.vue';
  import Content from '../views/Content.vue';
  
  defineProps({
    user: Object,
  });
  </script>
  