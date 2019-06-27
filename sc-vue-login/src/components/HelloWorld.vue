<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h3>Login</h3>
    <form action="http://192.168.0.231:8088/sc-auth/login" method="post">
      <input name="username" type="text"/>
      <input name="password" type="password"/>
      <input type="submit" />
    </form>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
