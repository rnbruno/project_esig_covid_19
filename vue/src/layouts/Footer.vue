<template>
    <div class="container">
        <footer class="footer d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
            <div class="col-md-4 d-flex align-items-center">
                <a href="/" class="mb-3 me-2 mb-md-0 text-body-secondary text-decoration-none lh-1">
                    <svg class="bi" width="30" height="24">
                        <use xlink:href="#bootstrap" />
                    </svg>
                </a>
                <span class="mb-3 mb-md-0 text-body-secondary">&copy; 2024 Company, Inc</span>
            </div>

            <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
                <li class="ms-3">
                    <a class="text-body-secondary" href="#">
                        <i class="fab fa-twitter" style="font-size: 24px;"></i>
                    </a>
                </li>
                <li class="ms-3">
                    <a class="text-body-secondary" href="#">
                        <i class="fab fa-instagram" style="font-size: 24px;"></i>
                    </a>
                </li>
                <li class="ms-3">
                    <a class="text-body-" href="#">
                        <i class="fa-brands fa-facebook-f"></i>
                    </a>
                </li>
            </ul>

        </footer>
    </div>
</template>

<script>
export default {
    name: 'Footer',
    data() {
        return {
            systemNameInc: import.meta.env.VITE_NAME_SISTEMA_INC,
        }
    },

}
</script>
<style>
.footer {
    background-color: rgb(132, 158, 183) !important;
    ;
    /* font-weight: bold; */
}
</style>