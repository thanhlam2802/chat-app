<script setup>
import { ref, onMounted } from 'vue';
const userLog = ref(null);

fetch('http://localhost:8080/api/info-user',
         {
            method: 'GET',
             credentials: 'include',
        })
            .then(res => res.json())
            .then(data =>{
              userLog.value =data;
              
              
            })
            .catch(err => console.error('Error:', err));
</script>


<template>
      <router-view :user="userLog" />
</template>