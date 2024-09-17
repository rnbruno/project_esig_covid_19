<template>
    <ul class="nav justify-content-end navbar  text-light">
        <router-link :to="{ name: 'login' }" class="btn">
            Login
        </router-link>
        <router-link :to="{ name: 'register' }" class="btn">
           Register
        </router-link>

    </ul>
    <nav class=" border-b border-gray-100 ">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
            <div class="flex justify-between h-16">
                <div class="flex">
                 
                </div>
                <!-- Other navigation items can go here -->
            </div>
        </div>
    </nav>
</template>

<script>
export default {
    name: 'Navbar',
}
</script>
<style scoped>
/* Optional styles for the header */

/* .hidden {
    background-color: #3E5C8C;
    /* Azul Cobalto */
/* padding: 15px;
    text-align: center;
} */

.nav {
    background-color:  rgb(132, 158, 183) !important;;
    font-weight: bold;
} 


</style>