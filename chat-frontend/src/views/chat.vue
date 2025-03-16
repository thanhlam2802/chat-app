<template>
  <div class="flex h-screen w-full bg-gray-100">
    <div  class="flex flex-col items-center justify-between">
      <div class="w-16 flex flex-col items-center py-4 space-y-1">
        <button
          @click="ContentCPN = 'Content',SidebarCPN ='Sidebar'"
          name="action"
          value="chat"
          class="w-12 h-12 flex items-center justify-center rounded hover:bg-gray-300 transition"
        >
          <i class="fas fa-comment-dots text-xl text-gray-600"></i>
        </button>

        <button @click="ContentCPN = 'viewFriend',SidebarCPN ='controlFriend'"

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
      <div class="">
        <div class="w-12 overflow-hidden h-12 flex items-center my-3 justify-center rounded-full hover:bg-red-500 hover:text-white transition">
          <img v-if="img" class="w-full" :src="img" alt="Avatar" />
        </div>

        <a
          @click.prevent="logout"
          class="w-12 mb-3 block h-12 flex items-center justify-center border-2 border-gray-600 rounded-full hover:bg-red-500 hover:text-white transition"
        >
          <i class="fa-solid fa-right-from-bracket"></i>
        </a>
      </div>
    </div>
    <component :is="SidebarCPN" :user="user"></component>
    <component :is="ContentCPN"></component>
  </div>
</template>

<script>
import { ref, watch } from "vue";
import Sidebar from "../views/Sidebar.vue";
import Content from "../views/Content.vue";
import controlFriend from "../components/controlFriend.vue";
import viewFriend from "../components/viewFriend.vue";
export default {
  components: {
    Sidebar,
    Content,
    viewFriend,
    controlFriend,
  },
  props: {
    user: Object,
  },
  data() {
    return {
      img: "",
      SidebarCPN: "Sidebar",
      ContentCPN: "Content",
    };
  },
  watch: {
    user: {
      handler(newUser) {
        console.log("User mới:", newUser);
        if (newUser && newUser.avt) {
          this.img = "/images/" + newUser.avt;
        }
      },
      immediate: true,
    },
  },
  methods: {
    logout() {
      console.log("Chạy logout");
      fetch("http://localhost:8080/api/logout", {
        method: "GET",
        credentials: "include",
      });
      window.location.href = "http://localhost:5173";
    },
  },
};
</script>
