<template>
     <Navbar />
           <nav class="nav border-b border-gray-100">
            <!-- Primary Navigation Menu -->
            <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                <div class=" justify-between h-16">
                    <div class="">
                        <!-- Logo -->
                        <div class="shrink-0 flex items-center">
                            <a href="/">
                                <!-- <img :src="logoUrl" style="width:65px" alt="Logo"> -->
                            </a>
                        </div>
                    </div>
                   
                </div>
            </div>
        </nav>
        <!-- Page Content -->
        <main class="banner_sistema">
            <div class="py-12">
                <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
                    <div class="overflow-hidden shadow-sm sm:rounded-lg">
                        <div class="p-6 border-b">
                            <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
                                <h1>COVID-19 World Vaccination Progress</h1>
                                <p class="fs-5 text-body-secondary"> Daily and Total Vaccination for COVID-19 in the World from Our World in Data</p><p>
                                  Data is collected daily from Our World in Data GitHub repository for covid-19, merged and uploaded. Country level vaccination data is gathered and assembled in one single file. Then, this data file is merged with locations data file to include vaccination sources information. A second file, with manufacturers information, is included.
                                </p>
                                <!-- <HelloWorld msg="" /> -->
                                <ListVacination />
                              </div>
                              
                        </div>
                    </div>
                </div>
            </div>
        </main>

   
    <div class="container text-center">
        <p>Manage all your covid 19 vaccination information in one place.</p>
    </div>

    <Footer />
</template>
<script>
// import { RouterView } from 'vue-router';
import Navbar from './Navbar.vue';
import HelloWorld from '../components/HelloWorld.vue'
import Footer from './Footer.vue';
import ListVacination from '../components/ListVacination.vue';

export default {
    name: 'Guest',
    data() {
        return {
            logoUrl: '/img/quadro_logo_societario.png', // Caminho relativo a partir da pasta public
            bannersistem: '/img/bussiness_modern.jpg',
            showDropdown: false,
            systemName: import.meta.env.VITE_NAME_SISTEMA,
            systemName2: import.meta.env.VITE_NAME_SISTEMA_2,
        }
    },
    components: {
        Navbar,
        HelloWorld,
        Footer,
        ListVacination
    }
}
</script>
<style>


.banner_sistema {
    text-align: center;
    padding: 50px 20px;
    background-image: url('/img/bussiness_modern.jpg'); /* Substitua pelo caminho da sua imagem */
    background-size: cover; /* Faz com que a imagem cubra todo o container */
    background-position: center; /* Centraliza a imagem dentro do container */
    background-repeat: no-repeat; /* Impede a repetição da imagem */
    position: relative; /* Garante que o conteúdo seja posicionado corretamente dentro do container */
}



</style>