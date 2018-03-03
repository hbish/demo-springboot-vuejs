<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div>
      <b-btn @click="callRestService()">CALL Spring Boot REST backend service</b-btn>

      <b-alert show>{{ response }}</b-alert>
    </div>
  </div>
</template>

<script>
import {AXIOS} from './http-common'

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      response: [],
      errors: []
    }
  },
  methods: {
    callRestService () {
      AXIOS.get(`api/hello`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.response = response.data
        })
        .catch(e => {
          this.errors.push(e)
        })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
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
