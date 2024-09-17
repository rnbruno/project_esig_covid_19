<template>
    <div>
        <div class="bg-white">
            <section class="text-center container">
                <div class="row py-lg-5">
                    <div class="col-md-11 mx-auto">
                        <h1 class="fw-light">Welcome to the COVID 19 csv input system</h1>
                        <div class="card lead text-body-secondary" style="width: 70rem;">
                            <div class="card-header">
                                Add a .cv in the button below
                            </div>
                            <div>

                                <!-- <div>
                                    <button type="button" class="btn btn-primary my-2" @click="sendMessage">Add .cv</button>
                                </div> -->
                                <div class="mb-3">
                                    <label for="formFile" class="form-label">Add .cv</label>
                                    <input class="form-control" type="file" id="formFile" @change="handleFileUpload"
                                        accept=".csv">
                                </div>
                                <button class="btn btn-primary" @click="submitData">Enviar para o Banco de
                                    Dados</button>

                                <div v-if="errorMessage">{{ errorMessage }}</div>
                                <!-- <p>
                                    <a href="#" class="btn btn-primary my-2">Main call to action</a>
                                    <a href="#" class="btn btn-secondary my-2">Secondary action</a>
                                </p> -->
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </div>
    </div>

</template>
<script>
import Papa from 'papaparse'; // Biblioteca para processar CSV
import { insertData } from '../../service/AddItemData.js'
import Swal from 'sweetalert2';
import axios from 'axios';

export default {
    name: 'InserirData',
    data() {
        return {
            csvData: null, // Armazenar os dados do CSV
            errorMessage: '',
            systemName: import.meta.env.VITE_NAME_SISTEMA,
            systemName2: import.meta.env.VITE_NAME_SISTEMA_2,
        }
    },
    methods: {
        handleFileUpload(event) {
            const file = event.target.files[0];

            if (file) {
                // Usar FileReader para ler o arquivo CSV
                const reader = new FileReader();
                reader.onload = (e) => {
                    const csvContent = e.target.result;

                    // Usar PapaParse para converter CSV em um array de objetos
                    Papa.parse(csvContent, {
                        header: true, // Se a primeira linha do CSV contém cabeçalhos
                        complete: (results) => {
                            // const transformedData = transformData(results.data);
                            // this.csvData = transformedData; //
                            const transformedData = transformData(results.data);
                            // this.csvData = transformedData.slice(1000, 1100);
                            this.csvData = transformedData;
                            console.log('CSV Data:', this.csvData)
                            // Atualizar o alerta de carregamento após o processamento do CSV
                            Swal.close(); // Fechar o alerta de carregamento se estiver aberto
                        },
                        error: (error) => {
                            Swal.fire({
                                title: 'Erro ao processar o CSV.',
                                text: 'Error reading CSV:', error,
                                icon: 'error',
                                confirmButtonText: 'OK'
                            });
                        },
                    });
                };
                reader.readAsText(file); // Lê o arquivo como texto
            }
        },

        async submitData() {
            // Verificar se os dados do CSV foram carregados
            if (!this.csvData || this.csvData.length === 0) {
                Swal.fire({
                    title: 'Nenhum arquivo carregado!',
                    text: 'Por favor, carregue um arquivo CSV antes de enviar.',
                    icon: 'warning',
                    confirmButtonText: 'OK'
                });
                return;
            }

            try {
                const loadingSwal = Swal.fire({
                    title: 'Enviando...',
                    text: 'Aguarde enquanto enviamos os dados para o servidor.',
                    didOpen: () => {
                        Swal.showLoading(); // Mostra o ícone de carregamento
                    },
                    allowOutsideClick: false,
                    allowEscapeKey: true,
                    showConfirmButton: false
                });
                // Faça a requisição para enviar os dados para o backend (API)
                const response = await axios.post('http://localhost:8080/api/vacinations/bulk', this.csvData);
                // Mostrar o alerta de carregamento enquanto os dados estão sendo enviados
                
                // Fechar o alerta de carregamento
                await loadingSwal.close();// Verificar se a requisição foi bem-sucedida
                if (response.status === 200) {
                    await loadingSwal.close();
                    Swal.fire({
                        title: 'Sucesso!',
                        text: 'Dados enviados com sucesso!',
                        icon: 'success',
                        confirmButtonText: 'OK'
                    });
                } else {
                    Swal.fire({
                        title: 'Erro!',
                        text: 'Erro ao enviar os dados para o servidor.',
                        icon: 'error',
                        confirmButtonText: 'OK'
                    });
                }
                await loadingSwal.close();
            } catch (error) {
                Swal.fire({
                    title: 'Erro!',
                    text: `Erro ao conectar com o servidor: ${error.message}`,
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
                console.error('Error:', error);
            }
        }

    },
}
// Função para transformar as chaves dos objetos
function transformKeys(obj) {
    const newObj = {};
    Object.keys(obj).forEach(key => {
        // Transformar de snake_case para camelCase
        const newKey = key.replace(/_([a-z])/g, g => g[1].toUpperCase());
        newObj[newKey] = obj[key];
    });
    return newObj;
}

// Função para transformar um array de dados
function transformData(data) {
    return data.map(item => transformKeys(item));
}
</script>