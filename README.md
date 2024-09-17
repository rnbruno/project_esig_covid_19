
# SpringBoot e VueJs - Painel de Vacinação Covid 19

<h1 align="center">Hi 👋, I'm Bruno Matias</h1>
<h3 align="center">I'm work Full Stack developer with more 4 years of experience, specializing in PHP, Laravel10+, Vue3, Inertia, SQL Server, MySQL, JavaScript, and Bootstrap, you possess a wide range of skills and expertise in software development.</h3>

- 🔭 I’m currently working on **Painel de Vacinação Covid 19**

- 📫 How to reach me **brunosmatias@gmail.com**

- 📊 Learn about the corporate framework system of companies on the website How to reach me **Repositorio**


<h3 >Olá seja bem vindo a documentação deste projeto.</h3>

<h4>Recursos e bibliotecas utilizadas.</h4>

Autenticação
- JWT: autenticação de usuário e API por secret keys
- Axios: para atender as solicitações de POST via API nas funções do VUE3
DATABASE
- Postgree:12 na porta 5433:5432
- Spring Bootstrap, Java 11
- Dbeaver: para acessar o banco 

- O projeto atual já tem como base outro projeto start no git hub https://github.com/sxflynn/sideprojectstarter.

O que o projeto start me disponibilizou:
- docker-compose.yml
    containners
    -
    spring boot - Vue3 - Postgree

Vue3:
    O ambiente - o arquivo vite para realizar as configurações

Springboot: 
    A lógica: controller/ model e view
    -Classes de User e Authentication + JWT
Postgre: 
    Configurações básicas

O que desenvolvi:
FRONTEND
- Bibliotecas

    Fontawesome; Ploply, Alpine.js, bootstrap, d3color, papaparse,sweetalert,vue-router, axios
- Routes: Criar rotas para usuário autenticado e/ou não
- API: Na tela inicial temos 4 chamadas para API buscando os dados para plotagem;
- Gráficos: Na tela sem autenticação temos o caminho / que chama a pagina inicial da página web COVID 19 Vaccination. Temos um nab tab para navegar entre os quatro (4) gráficos padrões, dois (2) de linha, um (1) de barra e um (1) de rosca;
- Login e Register:

BACKEND

Implementamos algumas classes como:

    MODEL
    Vacination: responsável pela lógica da tabela vinda de OURWOLRDINDATA. Variaveis GETrs e SETrs;

    ABSTRAÇÃO DE DADOS create(), read(), update(), e delete
    Interface de Vacination
    Dao - Lógica de acesso de dados

    CONTROLLER
        api
        /all
        /api/vacinations/dateTotalPerContry
        /api/vacinations/dateMonthVacination
        /api/vacinations/dateDailyVacination
        /api/vacinations/bulk
        /login
        /register

Registro de API no Swaggerhub
https://app.swaggerhub.com/apis/BRUNOSMATIAS/API_COVID_19_ESIG/1.0.0

1. Instalar o Docker/Docker Compose no sistema
2. Na pasta - docker compose up --build
3. Executando do VSCode - extensões - Java, SpringBoot, Vue


PAGES CRIADAS
- Register empresa;
- Confirmação de email: info.
- Login;
- Home - com gráficos;
- Inserção de CSV - IN LOGIN;


Para mais informações 
- 📫 How to reach me **brunosmatias@gmail.com**



