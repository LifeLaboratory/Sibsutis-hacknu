<template>
  <div>
    <div v-if="userProfile">
      <ProfileBaseInfo
          :name="userProfile.name + ' ' + userProfile.surname"
          :avatar-url="userProfile.avatarUrl"/>
      <RewardList :reward-array="rewardList"/>
    </div>
  </div>
</template>

<script>
import ProfileBaseInfo from "../components/profile/ProfileBaseInfo";
import RewardList from "../components/profile/RewardList";
import {getUserProfile} from "../api/user";
import {getUserRewardList} from "../api/reward";

export default {
  name: "UserProfile",
  components: {
    RewardList,
    ProfileBaseInfo
  },
  data() {
    return {
      userProfile: null,
      rewardList: null
    }
  },
  async created() {
    this.userProfile = await getUserProfile(this.$route.params.id)
    this.rewardList = await getUserRewardList(this.userProfile.id)
    console.log(this.userProfile)
    console.log(this.rewardList)
  }
}
</script>

<style scoped>

</style>