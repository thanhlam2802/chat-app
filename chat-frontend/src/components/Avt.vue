<script setup>
import { computed } from 'vue';

const props = defineProps({
  src: String,
  size: {
    type: String,
    default: 'md', 
  },
});


const sizeClasses = computed(() => {
  const sizes = {
    sm: 'w-8 h-8',
    md: 'w-12 h-12',
    lg: 'w-16 h-16',
    xl: 'w-20 h-20',
  };
  return sizes[props.size] || sizes.md;
});
</script>

<template>
  <div :class="['rounded-full overflow-hidden border-2 border-gray-300', sizeClasses]">
    <img src="https://cafebiz.cafebizcdn.vn/162123310254002176/2023/10/25/395209126-7098402140171579-3912294698631496411-n-5168-1698218521013-16982185211191625182965.jpg" alt="Avatar" class="w-full h-full object-cover" />
  </div>
</template>
