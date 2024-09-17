<template>
    <div>
        <div class=" py-3 my-4 bg-white">
            <div>Bem vindo ao Sistema <a class="font">{{ systemName }}</a><p></p></div>
        </div>
    </div>

</template>
<script>
export default {
    name: 'Welcome',
    data() {
        return {

        systemName: import.meta.env.VITE_NAME_SISTEMA,
        systemName2: import.meta.env.VITE_NAME_SISTEMA_2,
        }
    },
}
</script>