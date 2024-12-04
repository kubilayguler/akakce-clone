<template>
    <div class="outer-container">
      <div class="inner-container">
        <h4 class="pb-3"><font-awesome-icon icon="user-secret" /> Admin Panel</h4>
        <div v-if="!isAuthenticated" class="login-panel">
          <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" v-model="username">
          </div>
          <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" v-model="password">
          </div>
          <button class="btn btn-gray" @click="login">Login</button>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
  
  export default {
    name: 'LoginPanel',
    components: {
      FontAwesomeIcon
    },
    data() {
      return {
        username: '',
        password: '',
        isAuthenticated: false,
      };
    },
    methods: {
      login() {
        const validUsername = 'admin';
        const validPassword = '123';
        if (this.username === validUsername && this.password === validPassword) {
          this.isAuthenticated = true;
          this.$emit('authenticated'); // Emit an event to notify parent component
        } else {
          alert('Invalid username or password');
        }
      },
    }
  }
  </script>
  
  <style scoped>
  .outer-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: var(--bg-custom, #1a1a1a);
  }
  
  .form-group:focus-within label {
    opacity: 0%;
    transition: 0.4s;
  }
  
  .form-group:focus-within input {
    border-color: rgb(165, 255, 143);
    transition: 0.2s;
  }
  
  .inner-container {
    background-color: #1f1f1f;
    color: rgb(165, 255, 143);
    padding: 1rem;
    border: 1px solid rgb(165, 255, 143);
    text-align: center;
    width: 100%;
    max-width: 400px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
  
  .login-panel {
    display: flex;
    flex-direction: column;
    gap: 1rem;
  }
  
  .form-group {
    position: relative;
    margin-bottom: 1.5rem;
  }
  
  label {
    position: absolute;
    top: -0.75rem;
    left: 0;
    background: #1f1f1f;
    padding: 0 0.25rem;
    font-size: 0.85rem;
  }
  
  input {
    width: 100%;
    padding: 0.5rem;
    background-color: transparent;
    border: 1px solid white;
    color: white;
  }
  
  input:focus {
    outline: none;
    border-color: lightgray;
  }
  
  .btn-gray {
    background-color: rgb(78, 78, 78);
    color: white;
    border: none;
    padding: 0.75rem;
    cursor: pointer;
    font-weight: 600;
  }
  
  .btn-gray:hover {
    background-color: rgb(63, 224, 58);
    color: #1f1f1f;
  }
  </style>
  