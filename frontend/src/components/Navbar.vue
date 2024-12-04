<template>
  <nav v-if="navbarVisible" class="navbar navbar-expand-sm bg-dark navbar-dark fixed-bottom d-flex justify-content-center"
    style="height: 70px; width: 500px; border-top-left-radius: 60px; border-top-right-radius: 60px; left: 50%; transform: translateX(-50%);">
    <router-link to="/" class="navbar-brand fw-bold" :class="{ 'active': $route.path === '/' }">
      <font-awesome-icon icon="home" />
      Home
    </router-link>
    <router-link to="/dashboard" class="navbar-brand fw-bold" :class="{ 'active': $route.path === '/dashboard' }">
      <font-awesome-icon icon="user" />
      Dashboard
    </router-link>
   
  </nav>
  <button @click="toggleNavbarVisibility" class="btn btn-success btn-sm "
      style="position: fixed; width: 40px; height: 40px; bottom: 10px; right: 20px;">
      <font-awesome-icon :icon="navbarVisible ? 'eye' : 'eye-slash'" />

    </button>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

export default {
  name: 'Navbar',
  components: {
    FontAwesomeIcon
  },
  data() {
    return {
      navbarVisible: true  // Initial visibility state
    };
  },
  methods: {
    toggleNavbarVisibility() {
      this.navbarVisible = !this.navbarVisible;  // Toggle visibility
    }
  }
}
</script>

<style scoped>
.navbar-brand {
  font-size: 1.25rem;
  color: rgb(136, 136, 136);
  padding: 0 15px;
  transition: 0.3s;
}


.navbar-brand:hover {
  color: rgb(255, 255, 255);
  font-size: 1.4rem;
}

.navbar-brand.active {
  color: rgb(162, 255, 134);
  font-size: 1.4rem;
}
</style>