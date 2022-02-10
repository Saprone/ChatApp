<template>  
  <div class="chatroompage">
    <h2>ChatRoom Page</h2> 
    <div class="section">
      <ul>
        <li v-for="user in usernames" :key="user">
          {{ user }} joined
        </li>
      </ul>
    </div>
  </div>
</template> 

<script>
export default {
  name: 'ChatroomPage',
  data: () => {
    return {
      usernames: [] 
    }
  },
  created() {
    this.usernames = this.$route.params.data;
  }
}
</script>

<style scoped>
.chatroompage ul {
  list-style-type: none;
  margin-right: 60px;
}
</style>