<template>
  <img :src="reward.avatarUrl" width="48" height="48">
</template>

<script>
export default {
  name: "RewardElement",
  props: {
    reward: Object
  }
}
</script>

<style scoped>

</style>