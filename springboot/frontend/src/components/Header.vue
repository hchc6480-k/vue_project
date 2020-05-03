<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="info">
            <b-navbar-brand router to="/">Main</b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
            <b-navbar-nav>
                <b-nav-item href="#">Link</b-nav-item>
                <b-nav-item href="#" disabled>Disabled</b-nav-item>
            </b-navbar-nav>

            <!-- Right aligned nav items -->
            <b-navbar-nav class="ml-auto">
                <b-nav-form>
                <b-form-input size="sm" class="mr-sm-2" placeholder="Search"></b-form-input>
                <b-button size="sm" class="my-2 my-sm-0" type="submit">Search</b-button>
                </b-nav-form>
                <!--
                <b-nav-item-dropdown text="Lang" right>
                <b-dropdown-item href="#">EN</b-dropdown-item>
                <b-dropdown-item href="#">ES</b-dropdown-item>
                <b-dropdown-item href="#">RU</b-dropdown-item>
                <b-dropdown-item href="#">FA</b-dropdown-item>
                </b-nav-item-dropdown>
                -->
                <b-nav-item-dropdown right>
                <!-- Using 'button-content' slot -->
                <template  v-slot:button-content>
                    <em>{{user_id}}</em>
                </template>
                <b-dropdown-item v-if="isLogin" @click="logOut()">LogOut</b-dropdown-item>                
                <b-dropdown-item v-else @click="login()">LogIn</b-dropdown-item>
                <b-dropdown-item v-if="isLogin === false" router to="/usr/regist">Regist</b-dropdown-item>
                </b-nav-item-dropdown>
            </b-navbar-nav>
            </b-collapse>
        </b-navbar>
        </div>
</template>

<script>
import axios from 'axios'
import {mapState} from 'vuex'

export default {
    name : 'MainHeader',    
    data() {
        return {
            //token: localStorage.getItem('token')
            //name: '',
            //id : this.$store.state.user_id,              
        }
    },
    //computed:내용 변경 감지 mapState: store에 저장되있는 값 배열로 리턴
    computed: {        
       ...mapState(['isLogin','user_id'])
    }, 
    created () {                
        /*
        if(localStorage.token != '' && localStorage.token != undefined){            
                axios.post('http://localhost:5000/usr/userInfo',null,{
                    params:{
                        token: localStorage.token
                    }
                })
                .then(function (response) {     
                    console.log(response);
                    this.$store.commit('setUserInfo',response);            
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                })
        }
        */
    },    
    methods: {
        login(){
            this.$router.push({path:'/login'});
        },
        logOut() {            
            this.$store.commit('logOut');
            location.reload();
            //this.$router.push({path:'/'});
        },
        updateVariable(){
            alert('실행됨');            
            this.token = localStorage.token;
        },
        
    }
}
</script>
