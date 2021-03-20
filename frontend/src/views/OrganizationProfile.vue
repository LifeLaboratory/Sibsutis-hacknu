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
import {mapGetters, mapMutations} from 'vuex';

export default {
  name: "OrganizationProfile",
  components: {
    ProfileBaseInfo
  },
  computed: {
    ...mapGetters({
      organizationProfile: 'organizationProfile'
    })
  },
  methods: {
    ...mapMutations({
      updateOrganizationProfile: 'updateProfile'
    })
  },
  async created() {
    const organizationId = this.$route.params.organizationId  || this.userProfile.organizationId
    const profile = await getOrganizationProfile(organizationId, null)
    this.updateOrganizationProfile({
      profile,
      isOrganization: true
    })
    console.log(this.$route.params.organizationId)
    console.log(this.organizationProfile)
  }
}
</script>

<style scoped>

</style>