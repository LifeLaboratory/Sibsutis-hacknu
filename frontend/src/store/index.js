import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const profileStore = {
  actions: {
  },
  mutations: {
    updateProfile(state, { profile, isOrganization }) {
      state.profile = profile
      state.isOrganization = isOrganization
    }
  },
  state: {
    profile: null,
    isOrganization: null
  },
  getters: {
    userProfile(state) {
      return state.isOrganization ? null : state.profile
    },
    organizationProfile(state) {
      return state.isOrganization ? state.profile : null
    },
    isUser(state) {
      return !state.isOrganization
    },
    isOrganization(state) {
      return state.isOrganization
    }
  }
}

export default new Vuex.Store({
  modules: {
    profileStore
  }
})
