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
import {mapGetters, mapMutations} from 'vuex';

export default {
  name: "UserProfile",
  components: {
    RewardList,
    ProfileBaseInfo
  },
  data() {
    return {
      rewardList: null
    }
  },
  computed: {
    ...mapGetters({
      userProfile: 'userProfile'
    })
  },
  methods: {
    ...mapMutations({
      updateUserProfile: 'updateProfile'
    })
  },
  async created() {
    const userId = this.$route.params.userId || this.userProfile.id
    const profile = await getUserProfile(userId)
    this.updateUserProfile({
      profile,
      isOrganization: false
    })
    this.rewardList = await getUserRewardList(this.userProfile.id)
    console.log(this.userProfile)
    console.log(this.rewardList)
  }
}
</script>

<style scoped>

</style>