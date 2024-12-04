import 'bootstrap/dist/css/bootstrap.min.css'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router/Main'

// Import necessary Font Awesome components and icons
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { fas } from '@fortawesome/free-solid-svg-icons'
import StarRating from 'vue-star-rating';

// Add the imported icons to the library
library.add(fas)

// Create the Vue app instance
createApp(App)
  .use(router)
  .component('font-awesome-icon', FontAwesomeIcon) // Register the FontAwesomeIcon component globally
  .component('star-rating', StarRating)
  .mount('#app')