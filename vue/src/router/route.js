
const isAuthenticated = () => {
    const token = localStorage.getItem('authToken');
    return !!token;
}

const getToken = () => {
    const token = localStorage.getItem('jwt_token');
    const expirationTime = localStorage.getItem('jwt_token_expiration');

    if (!token || !expirationTime) {
        return null; // Não existe token ou timestamp de expiração
    }

    const currentTime = new Date().getTime();

    if (currentTime > expirationTime) {
        // O token expirou
        localStorage.removeItem('jwt_token');
        localStorage.removeItem('jwt_token_expiration');
        return null;
    }

    return token; // O token ainda é válido
}

function auth(to, from, next) {
    const token_verification = getToken();
    const loggIn = JSON.parse(localStorage.getItem('loggedIn'));
    // localStorage.setItem('user', JSON.stringify(updatedUser));
    const logusergIn = JSON.parse(localStorage.getItem('user'));
    if (loggIn && isAuthenticated && token_verification) {
        next()
    }else{
        if (to.name == 'login'){
            next({name: 'login'});
        }else if (to.name == 'logout'){
            next({name: 'logout'});
        }else{
           next({name: 'layout'});
        }
    }
}

import { createRouter, createWebHistory } from 'vue-router';
import Home from "../layouts/Guest.vue";
import Welcome from '../layouts/Welcome.vue'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import AuthenticatedLayout from '../layouts/Authenticated.vue';
import InserirData from '../layouts/insertData/InserirData.vue'

const routes = [

    {
        path: '/',
        name: 'layout',
        component: Home,
    },
    { path: '/welcome', component: Welcome },
    {
        path: '/login',
        name: 'login',
        component: Login,

    },
    {
        path: '/register',
        name: 'register',
        component: Register,

    },
    {
        component: AuthenticatedLayout,
        beforeEnter: auth,
        children: [
            {
                path: '/authenticated',
                name: 'inserirData',
                component: InserirData,
                meta: { title: 'inserirData', }
            },
        ]

    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
