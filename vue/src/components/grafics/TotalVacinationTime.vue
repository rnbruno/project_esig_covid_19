<template>
    <div>
        <!-- Bootstrap Nav Tabs -->
        <ul class="nav nav-tabs" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="total-vaccinations-tab" data-bs-toggle="tab" href="#total-vaccinations"
                    role="tab" aria-controls="total-vaccinations" title="Total de Vacinações ao Longo do Tempo"
                    aria-selected="true">Total de Vacinações</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="daily-vaccinations-tab" data-bs-toggle="tab" href="#daily-vaccinations"
                    role="tab" aria-controls="daily-vaccinations" title="Vacinações Diárias"
                    aria-selected="false">Vacinações Diárias</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="month-vaccinations-tab" data-bs-toggle="tab" href="#month-vaccinations"
                    role="tab" aria-controls="month-vaccinations" title="Vacinações Diárias"
                    aria-selected="false">Vacinações por Mês</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="yeahTotal-vaccinations-tab" data-bs-toggle="tab" href="#yeahTotal-vaccinations"
                    role="tab" aria-controls="yeahTotal-vaccinations" title="Vacinações Diárias"
                    aria-selected="false">Total por Países</a>
            </li>
            <!-- Adicione mais abas se necessário -->
        </ul>
        <div class="tab-content" id="myTabContent">
            <div class="tab-pane fade show active" id="total-vaccinations" role="tabpanel"
                aria-labelledby="total-vaccinations-tab">
                <div ref="plotElement1" class="plot-container"></div>
            </div>
            <div class="tab-pane fade" id="daily-vaccinations" role="tabpanel" aria-labelledby="daily-vaccinations-tab">
                <div ref="plotElement2" class="plot-container"></div>
            </div>
            <div class="tab-pane fade" id="month-vaccinations" role="tabpanel" aria-labelledby="month-vaccinations-tab">
                <div ref="plotElement3" class="plot-container"></div>
            </div>
            <div class="tab-pane fade" id="yeahTotal-vaccinations" role="tabpanel"
                aria-labelledby="yeahTotal-vaccinations-tab">
                <div ref="plotElement4" class="plot-container"></div>
            </div>
            <!-- Adicione mais conteúdos de abas se necessário -->
        </div>
    </div>
</template>

<script>
import { ref, reactive, inject, onMounted, watch } from "vue";
import Plotly from 'plotly.js-dist';
import axios from 'axios';

export default {
    name: 'PlotlyChart',
    data() {
        return {
            data: [], data1: [],
            data2: [
                { month: '2021-02', count: 5 },
                { month: '2021-03', count: 8 },
                { month: '2021-04', count: 12 },
                // Suponha que você já recebe esses dados somados da API
            ],
            data4:[],
            plotData1: [
                {
                    x: [],
                    y: [],
                    mode: 'lines+markers',
                    type: 'scatter',
                    name: 'Total de Vacinações ao Longo'
                }
            ],
            plotData2: [
                {
                    x: [],
                    y: [],
                    mode: 'lines+markers',
                    type: 'scatter',
                    name: 'Vacinações Diárias'
                }
            ],
            plotData3: [
                {
                    x: [], // Meses
                    y: [], // Contagem
                    type: 'bar',
                    name: 'Contagem por Mês',
                    // width: 1000.5 // Largura das barras (quanto menor o valor, mais finas as barras)
                }
            ],
            plotData4: [
                {
                    type: 'sunburst',
                    labels: [],  // Nomes dos países
                    parents: [],  // Hierarquia (aqui não há hierarquia adicional)
                    values: [],
                }    // Total de vacinações
            ],
            layout1: {
                title: 'Total de Vacinações ao Longo do Tempo',
                xaxis: { title: 'Data' },
                yaxis: { title: 'Total de Vacinações' }
            },
            layout2: {
                title: 'Vacinações Diárias',
                xaxis: { title: 'Data' },
                yaxis: { title: 'Vacinações Diárias' }
            },
            layout3: {
                title: 'Número de Vacinações por Mês',
                xaxis: {
                    title: 'Mês',
                    tickformat: '%b %Y', // Mostra apenas o mês e o ano no eixo X
                    tickmode: 'array',
                    tickvals: ['2021-02', '2021-03', '2021-04'], // Valores no eixo X
                    ticktext: ['Fev', 'Mar', 'Abr'] // Nomes dos meses para exibir
                },
                yaxis: {
                    title: 'Total de Vacinações'
                },
                bargap: 0.1
            },
            layout4: {
                title: 'Total de Vacinações por País',
                margin: { t: 100, l: 0, r: 0, b: 0 }, // Ajuste conforme necessário
            }
        };
    },
    async mounted() {
        await this.fetchData();
        await this.fetchDataDailyVacination();
        await this.fetchDataMonthVacination();
        await this.prepareData();

        this.renderChart();
    },
    methods: {
        async fetchData() {
            try {
                const response = await axios.get('http://localhost:8080/api/vacinations/dateTotalVacination');
                this.data = response.data; // Preencher `data` com os dados da API
                // Atualizar plotData1 com os dados
                this.plotData1[0].x = this.data.map(d => d.date);
                this.plotData1[0].y = this.data.map(d => d.totalVaccinations);
            } catch (error) {
                console.error('Erro ao buscar dados:', error);
            }
        },
        async fetchDataDailyVacination() {
            try {
                const response = await axios.get('http://localhost:8080/api/vacinations/dateDailyVacination');
                this.data1 = response.data; // Preencher `data` com os dados da API
                // Atualizar plotData1 com os dados
                this.plotData2[0].x = this.data1.map(d => d.date);
                this.plotData2[0].y = this.data1.map(d => d.dailyVaccinations);
            } catch (error) {
                console.error('Erro ao buscar dados:', error);
            }
        },
        async fetchDataMonthVacination() {
            try {
                const response = await axios.get('http://localhost:8080/api/vacinations/dateMonthVacination');
                this.data2 = response.data; // Preencher `data` com os dados da API
                // console.log(this.data);
                // Atualizar plotData1 com os dados
                this.plotData3[0].x = this.data2.map(d => d.monthStart);
                this.plotData3[0].y = this.data2.map(d => d.totalVaccinations);

                // Atualizar os ticks do eixo X
                this.layout3.xaxis.tickvals = this.data2.map(d => d.monthStart);
                this.layout3.xaxis.ticktext = this.data2.map(d => {
                    const [year, month] = d.monthStart.split('-');
                    const date = new Date(year, month - 1); // Ajuste do mês, já que Date usa 0 para Janeiro
                    return `${date.toLocaleString('pt-BR', { month: 'short' })} ${year}`;
                });
            } catch (error) {
                console.error('Erro ao buscar dados:', error);
            }
        },
        async prepareData() {
            // Dados fictícios
            const data = [
                { country: 'USA', totalVaccinations: 500000 },
                { country: 'Canada', totalVaccinations: 200000 },
                { country: 'Mexico', totalVaccinations: 150000 }
            ];
            const response = await axios.get('http://localhost:8080/api/vacinations/dateTotalPerContry');
                this.data4 = response.data; // Preencher `data` com os dados da API
                console.log(this.data);
                // Atualizar plotData1 com os dados
                // this.plotData3[0].x = this.data4.map(d => d.monthStart);
                // this.plotData3[0].y = this.data4.map(d => d.totalVaccinations);

                // Preparar os dados para o gráfico Sunburst
                this.plotData4[0].labels = this.data4.map(d => d.country);
                this.plotData4[0].parents = this.data4.map(() => 'Total de Vacinações <br> por Países'); // Hierarquia vazia para este exemplo
                this.plotData4[0].values = this.data4.map(d => d.totalVaccinations);
        },
        renderChart() {
            Plotly.newPlot(this.$refs.plotElement1, this.plotData1, this.layout1);
            Plotly.newPlot(this.$refs.plotElement2, this.plotData2, this.layout2);
            Plotly.newPlot(this.$refs.plotElement3, this.plotData3, this.layout3);
            Plotly.newPlot(this.$refs.plotElement4, this.plotData4, this.layout4);
        },
        renderCharts() {
            // // Atualizar plotData1
            // this.plotData1[0].x = this.data.map(d => d.date);
            // this.plotData1[0].y = this.data.map(d => d.total_vaccinations);
            // Plotly.newPlot(this.$refs.plotElement1, this.plotData1, this.layout1);

            // Atualizar plotData2
            // this.plotData2[0].x = this.data1.map(d => d.date);
            // this.plotData2[0].y = this.data1.map(d => d.daily_vaccinations);
            // Plotly.newPlot(this.$refs.plotElement2, this.plotData2, this.layout2);
            // this.plotData3[0].x = this.data2.map(item => item.month); // Meses
            // this.plotData3[0].y = this.data2.map(item => item.count);
            // Plotly.newPlot(this.$refs.plotElement3, this.plotData3, this.layout3);
            // Plotly.newPlot(this.$refs.plotElement4, this.plotData4, this.layout4);
        }
    },
    watch: {
        data: 'renderCharts'
    },
    setup() {
        const listdateTotalVacination = ref([]); // Defina uma referência para os sócios

        // Exemplo de como popular `socios` (você pode substituir com sua chamada de API ou dados reais)


        const userId = ref(null);


        onMounted(async () => {

        });

        return {

            listdateTotalVacination
        };
    },
}
</script>

<style>
.plot-container {
    height: 400px;
    /* Ajuste conforme necessário */
}
</style>