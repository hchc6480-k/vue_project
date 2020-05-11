
<template>
  <b-row>
      <b-col sm="2"></b-col>
      <b-col sm="8">
        <div>
            <b-form>
            <b-form-group
                id="input-group-1"
                label="ID:"
                label-for="input-1"
                description="We'll never share your ID with anyone else."
            >
                <b-form-input
                id="input-1"          
                type="text"
                v-model="user_id"
                required
                placeholder="아이디를 입력하세요."
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-2" label="PassWord:" label-for="input-2">
                <b-form-input
                id="input-2"
                v-model="pwd" 
                required
                type="password"                   
                placeholder="비밀번호를 입력하세요."
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-3" label="Name:" label-for="input-3">
                <b-form-input
                id="input-3" 
                v-model="mbr_nm"
                type="text"         
                required
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4">
                <b-form-checkbox-group id="checkboxes-4">
                <b-form-checkbox v-model="checkbox" value="me">가입동의</b-form-checkbox>
                <!--<b-form-checkbox value="that">Check that out</b-form-checkbox>-->
                </b-form-checkbox-group>
            </b-form-group>

            <b-button id="regist_btn" @click="Regist" variant="primary">가입</b-button>
            <!--<b-button type="reset" variant="danger">Reset</b-button>-->
            </b-form>
            <!--
            <b-card class="mt-3" header="Form Data Result">
            <pre class="m-0">?</pre>
            </b-card>
            -->
        </div>
      </b-col>
      <b-col sm="2"></b-col>
  </b-row>
</template>

<style>    
    #regist_btn{width:150px;}    
</style>

<script>
import axios from 'axios'

export default {
    name:'RegistForm',
    
    data(){
        return {
            user_id:'',
            pwd:'',
            mbr_nm:'',
            checkbox:[]         
        }
    },
    methods: {
        Regist(){            
            if(this.user_id == '' || this.pwd == '' || this.mbr_nm ==''){
                alert('회원정보를 모두 입력해주세요.');
                return false;
            }
            if(this.checkbox==''){
                alert('가입동의가 필요합니다.');
                return false;
            }
            axios.post('http://localhost:5000/usr/registMbr',null,{
               params:{                
                user_id:this.user_id,
                pwd:this.pwd,
                mbr_nm:this.mbr_nm                 
               } 
            }, 
            {                                
                headers: { 'Content-Type': 'application/json' }
            }).then(res => {
                if(res.data.state == "200"){       
                    console.log(res.data);             
                    //this.$store.commit('loginToken',res.data);
                    alert('회원가입 완료!');
                    this.$router.push({path:'/'});
                }else{
                    console.log(res.data);
                    alert('에러발생');
                }
                //console.log(res.data)
            }).catch((ex)=>{
              console.log(ex);

            })

        }
    },
}
</script>

