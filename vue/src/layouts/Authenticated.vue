<template>
    <div class="min-h-screen bg-gray-100">
        <div class="container">
            <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
                <a class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
                    <router-link :to="{ name: 'layout' }" class="nav-item">
                        <span class="fs-4">COVID-19 WEB</span>
                    </router-link>
                </a>
                <div class="text-center">
                    <div>Hi, {{ user.name }}</div>
                    <div class="text-sm text-gray-500">{{ user.email }}</div>
                    <div class="text-sm text-gray-500">{{ user.nameType }}</div>
                </div>

                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="#" class="nav-link">
                            <router-link :to="{ name: 'inserirData' }" class="nav-item">
                                Home
                            </router-link></a>
                    </li>
                </ul>
                <button @click="logout" type="button"
                    class="item_button inline-flex items-center px-4 py-2 bg-gray-800 border border-transparent  font-semibold text-xs text-white uppercase tracking-widest hover:bg-gray-700 active:bg-gray-900 focus:outline-none focus:border-gray-900 focus:shadow-outline-gray transition ease-in-out duration-150 ml-4"
                    :class="{ 'opacity-25': processing }" :disabled="processing">
                    Log out
                </button>
            </header>
        </div>
      
        <!-- Page Content -->
        <main class="banner_sstema">
            <AdicionarItem />
            <div class="py-12">
                <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
                    <div class="overflow-hidden shadow-sm sm:rounded-lg">
                        <div class="p-6 border-b">
                            <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</template>

<script>
import useAuth from "../composables/auth.js";
import AdicionarItem from '../layouts/insertData/InserirData.vue'

export default {
    data() {
        return {
            logoUrl: '/img/quadro_logo_societario.png ', // Caminho relativo a partir da pasta public
            showDropdown: false,
            errors: {
                name: "",
            }, // Armazena os erros de validação
            user: {
                name: "Bruno",
            }
        }
    },
    components: {
        AdicionarItem,
    },
    setup() {
        const { user, processing, logout } = useAuth()

        return { user, processing, logout }
    },
    computed: {
        currentPageTitle() {
            return this.$route.meta.title;
        }
    },
    methods: {
        getMetaTitle(routeName) {
            const route = this.$router.resolve({ name: routeName });
            return route.route.meta.title || 'Default Title'; // Retorna o título ou um título padrão
        }
    }
}
</script>
<style>
.item_button {
    background-color: #3E5C8C;
    /* Azul Cobalto */
    padding: 15px;
    text-align: center;
}

nav a {
    color: #D4D9E0;
    /* Prata Suave */
    margin: 0 15px;
    text-decoration: none;
    font-weight: bold;
}


</style>