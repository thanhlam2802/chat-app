<script setup>
import ItemUser from '../components/ItemUser.vue'
</script>

<template>
  <div class="flex  h-screen">
    <!-- Sidebar -->
    <form action="#" method="POST">
      <div class="w-16 flex flex-col items-center py-4 space-y-1">
        <button
          type="submit"
          name="action"
          value="chat"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fas fa-comment-dots text-xl text-gray-600"></i>
        </button>

        <button
          type="submit"
          name="action"
          value="users"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fa-solid fa-user-group text-gray-600"></i>
        </button>

        <button
          type="submit"
          name="action"
          value="messages"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fas fa-comments text-xl text-gray-600"></i>
        </button>

        <button
          type="submit"
          name="action"
          value="delete"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-red-500 hover:text-white transition"
        >
          <i class="fas fa-trash-alt text-xl text-gray-600"></i>
        </button>
      </div>
    </form>
    <!-- Main Content -->
    <div class="flex-1 bg-white p-4">
      <!-- Header -->
      <div class="flex items-center justify-between mb-4">
        <h1 class="text-2xl font-bold">Đoạn chat</h1>
        <i class="fas fa-edit text-xl text-gray-600"> </i>
      </div>
      <!-- Search Bar -->
      <div class="relative mb-4">
        <input
          class="w-full p-2 pl-10 rounded-full bg-gray-100 border border-gray-300 focus:outline-none"
          placeholder="Tìm kiếm trên chat-app"
          type="text"
        />
        <i class="fas fa-search absolute left-3 top-2.5 text-gray-500"> </i>
      </div>
      <!-- Chat List -->
      <div class="space-y-4">
        <ItemUser></ItemUser>
        <ItemUser></ItemUser>
      </div>
    </div>
  </div>
  
</template>
