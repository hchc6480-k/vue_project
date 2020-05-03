<template>
    <div style="padding:20px; margin:auto; width:80%;">
        <h1>Login</h1>
        <form @submit.prevent="signup">
            <b-form-group label="Enter your user id">
                <b-form-input type="text" v-model="uid"></b-form-input>
            </b-form-group>
            <b-form-group label="Enter your password">
                <b-form-input type="password" v-model="password"></b-form-input>
            </b-form-group>
            <!--
            <b-form-group label="Enter your position">
                <b-select v-model="position" :options="positionOptions"></b-select>
            </b-form-group>
            <b-form-group label="Enter your role">
                <b-select v-model="role" :options="roleOptions"></b-select>
            </b-form-group>
            -->
            <b-button size="lg" variant="success" type="submit" style="width:30%;">Signup</b-button>
        </form>
    </div>
</template> 

<style scoped>
    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }

    .btn-lg {
        width: 100%;
    }
</style>

<script>
import axios from 'axios'

export default {
    name:'LoginForm',
    
    data(){
        return {
            uid:null,
            password:null            
        }
    },
    methods: {
        signup(){
            if(this.uid == null || this.password == null){
                alert('아이디 비밀번호를 입력해 주세요.');
                return false;
            }

            axios.post('http://localhost:5000/usr/LoginChk',null,{
               params:{                
                user_id:this.uid,
                pwd:this.password                 
               } 
            }, 
            {                                
                headers: { 'Content-Type': 'application/json' }
            }).then(res => {
                if(res.data.state == "200"){       
                    console.log(res.data);             
                    this.$store.commit('loginToken',res.data);
                    alert('로그인 성공');
                    this.$router.push({path:'/'});
                }else{
                    alert('아이디 비번을 확인하세요.');
                }
                //console.log(res.data)
            }).catch((ex)=>{
              console.log(ex);

            })

        }
    },
}
</script>

