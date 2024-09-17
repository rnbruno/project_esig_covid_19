<template>
    <!-- <h2>Teste..</h2> -->
    <div class="card col-10 offset-1">
        <div class="card-body row">
            <h3 class="col-5"> Vacination List</h3>
        </div>
        <div class="table-responsive small">
            <!-- <table class="table table-striped table-sm">
                <thead>
                    <tr>
                        <th class="text-center" scope="col">#</th>
                        <th scope="col">C&oacute;d.</th>
                        <th scope="col">Sócio</th>
                        <th scope="col">Empresa de</th>
                        <th scope="col">Telefone</th>
                        <th class="text-center" scope="col text-center">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-if="listVacinations.length === 0">
                        <td colspan="6" class="text-center">No data available</td>
                    </tr>
                    <tr v-for="(listVacination, index) in listVacinations" :key="index">
                        <td class="text-center">
                            <div class="badge text-bg-secondary">{{ index + 1 }}</div>
                        </td>
                        <td class="text-center">{{ listVacination.id
                            }}
                        </td>
                        <td class="text-center">{{ listVacination.id
                            }}
                        </td>
                        <td class="text-center">{{ listVacination.id
                            }}
                        </td>
                        <td class="text-center">{{ listVacination.id
                            }}
                        </td>
                        <td class="text-center">{{ listVacination.id
                            }}
                        </td>
                    </tr>

                </tbody>
            </table> -->
            <TotalVacinationTime/>
        </div>
    </div>

</template>

<script>
import { ref, reactive, inject, onMounted, watch } from "vue";
// import CryptoJS from 'crypto-js';
// import { useForm } from '@inertiajs/vue3';
// import { router } from '@inertiajs/vue3';
import Swal from "sweetalert2";
import axios from 'axios';

import TotalVacinationTime from "./grafics/TotalVacinationTime.vue";

export default {
    name: 'ListVacination',
    props: ['isVisible', 'title', 'initialInputValue', 'initialInputValue2', 'initialInputValue3', 'options', 'initialOption',],

    components: {
        TotalVacinationTime,
    },
    data() {
        //   const user = JSON.parse(localStorage.getItem("user"));
        const RegisterFormEmpresas = reactive({
            name: "",
            phone: "",
            email: "",
            password: "",
            password2: "",
            hiddenEmpresas: 1,
            confirmation: false,
        });
        const isModalOpen = ref(false);
        const selectedOption = ref(null); // Armazena o valor selecionado

        onMounted(() => {
            // loadSocios();
        });

        return {
            modalTitle: '',
            showModal: false,
            showModalAdd: false,
            showModalAtt: false,
            isModalVisible: false,
            modalTitleAdd: '',
            modalTitleAtt: '',
            modalType: '',
            modalTypeAtt: '',
            modalName: '',
            modalInput: Array,
            modalButton: Array,
            modalAtribuir_: Array,
            currentPageTitle: 'Título da Página Atual', // Defina a propriedade aqui
            modalInputValue: '',
            modalInputValue2: '',
            modalInputValue3: '',
            modalInitialOption: 1,
            marcacaoId_: '',
            isModalOpen,
            sociosEmpresas: [],
            
        };
    },
    setup() {
        const listVacinations = ref([]); // Defina uma referência para os sócios

        // Exemplo de como popular `socios` (você pode substituir com sua chamada de API ou dados reais)
        const fetchListVacinations = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/vacinations/all'); // Assumindo que você busca os sócios via API
                listVacinations.value = response.data; // Preencha `socios` com os dados da API
            } catch (error) {
                console.error('Erro ao buscar sócios:', error);
            }
        };

        const userId = ref(null);

        onMounted(() => {
            fetchListVacinations(); // Chama a função de busca quando o componente é montado
        });

        onMounted(async () => {

        });

        return {
            fetchListVacinations,
            listVacinations
        };
    },
    created() {
       
    },

    methods: {

    },
    mounted() {

    },
}
</script>
<style scoped>
/* Seus estilos aqui */
text-justify {
    text-align: justify;
}

.line-through {
    text-decoration: line-through;
}
</style>