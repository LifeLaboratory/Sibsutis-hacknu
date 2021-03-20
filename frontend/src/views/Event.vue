<template>
  <div>
    <div v-if="eventObject">
      <h2>{{eventObject.name}}</h2>
      <b>{{eventObject.eventType}}</b>
      <p>{{eventObject.description}}</p>
    </div>
  </div>
</template>

<script>
import {getEvent} from "../api/event";

export default {
  name: "Event",
  data() {
    return {
      eventObject: null
    }
  },
  async created() {
    this.eventObject = await getEvent(this.$route.params.eventId)
    console.log(this.eventObject)
  }
}
</script>

<style scoped>

</style>