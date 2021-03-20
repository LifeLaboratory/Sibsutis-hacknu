<template>
  <div>
    <ProfileBaseInfo
        v-if="organizationProfile"
        :name="organizationProfile.name"
        :avatar-url="organizationProfile.avatarUrl"/>
  </div>
</template>

<script>
import ProfileBaseInfo from "../components/profile/ProfileBaseInfo";
import {getOrganizationProfile} from "../api/organization";

export default {
  name: "OrganizationProfile",
  components: {
    ProfileBaseInfo
  },
  data() {
    return {
      organizationProfile: null
    }
  },
  async created() {
    this.organizationProfile = await getOrganizationProfile(this.$route.params.id, null)
    console.log(this.$route.params.id)
    console.log(this.organizationProfile)
  }
}
</script>

<style scoped>

</style>