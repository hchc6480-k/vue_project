import Vue from 'vue';
import Vuex from 'vuex';


Vue.use(Vuex);

const axios = require('axios');

export const store = new Vuex.Store({
    state : {
        state : '',                
        isLogin : localStorage.token !='' && localStorage.token != undefined ? true:false,
        user_id : localStorage.user_id !='' && localStorage.user_id != undefined ? localStorage.user_id:'Guest',
        mbr_nm : '',        
    },    
    mutations : {
        loginToken: function(state,payload){            
            state.user_id = payload.user_id;
            localStorage.token = payload.token;
            localStorage.user_id = payload.user_id;            
            state.isLogin=true;
        },
        logOut: function(state){
            if(localStorage.token != ''){                
                state.token = '';
                state.user_id = '';
                localStorage.token = '';
                localStorage.user_id = '';
                state.isLogin=false;
                alert('로그아웃 되었습니다.');                
            }
        },
        loginCheck: function(state){
            if(state.token == '' && localStorage.token == ''){
                
            }else{
                console.log(state.token);                
            }
        },
    
    }
})