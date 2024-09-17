// import { createApp } from 'vue'
// import './style.css'
// // Importação do componente FontAwesomeIcon
// // import '@fortawesome/fontawesome-svg-core/styles.css';

// // import { FontAwesomeIcon } from '../node_modules/@fortawesome/vue-fontawesome';
// import { onMounted} from 'vue'
// import App from './App.vue'

// const app = createApp({
//     // setup() {
//     //     const { getUser } = useAuth()
//     //     onMounted(getUser)
//     // }
// });

// // app.component('font-awesome-icon', FontAwesomeIcon);
// // // app.use(router)
// // // app.use(VueSweetalert2)
// // // app.use(library)
// // app.use(FontAwesomeIcon)
// // // app.use(vuetify)
// // // app.use(abilitiesPlugin, ability)
// // // app.component('Pagination', LaravelVuePagination)
// // // app.use(InertiaProgress);
// app.mount('#app')
// import '../node_modules/bootstrap/dist/css/bootstrap.min.css'; // Importa os estilos CSS do Bootstrap

// import Alpine from 'alpinejs';
// window.Alpine = Alpine;
// Alpine.start();
import { createApp } from 'vue';
import './style.css';
// import VueSweetalert2 from "node_modules/vue-sweetalert2";

// Importação do componente FontAwesomeIcon
// import '../node_modules/@fortawesome/vue-fontawesome/src/index';

import App from './App.vue';  // Certifique-se de que esse arquivo contém o template ou render function
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import 'bootstrap';

import router from './router/route.js';
import Alpine from 'alpinejs';

// Inicialize o Alpine.js

window.Alpine = Alpine;
Alpine.start();
import * as LaravelVuePagination from 'laravel-vue-pagination';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';

const app = createApp(App);  // Passe o App.vue diretamente para o createApp
import 'sweetalert2/dist/sweetalert2.min.css';
app.component('Pagination', LaravelVuePagination)
app.use(router);
import VueSweetalert2 from 'vue-sweetalert2';
app.use(VueSweetalert2);
app.component('font-awesome-icon', FontAwesomeIcon);
app.use(FontAwesomeIcon);
app.mount('#app');