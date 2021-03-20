<template>
  <div>
    <img :src="avatarUrl" alt="Profile Image">
    <h3>{{name}}</h3>
  </div>
</template>

<script>
export default {
  name: "ProfileBaseInfo",
  props: {
    name: String,
    avatarUrl: String
  }
}
</script>

<style scoped>

</style>