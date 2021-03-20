<template>
  <div>
    <RewardElement v-for="reward of rewardArray"
                   :key="reward.id"
                   :reward="reward"/>
  </div>
</template>

<script>
import RewardElement from "../RewardElement";

export default {
  name: "RewardList",
  components: {RewardElement},
  props: {
    rewardArray: Array
  }
}
</script>

<style scoped>

</style>