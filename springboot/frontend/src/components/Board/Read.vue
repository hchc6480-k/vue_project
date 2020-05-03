<template>
    <div>
        <b-table striped hover :items="rows"></b-table>
        <b-button @click="write">{{message}}</b-button>        
    </div>    
</template>
<script>
//import data from '@/data'
//import axios from 'axios'

export default {
    name: 'Read',    
    data() {
        message:'글쓰기'
        return{
            message:'글쓰기',
            rows:null
        }
        
    },
    created(){
        if(localStorage.token != '' && localStorage.token != undefined){        
            this.$emit('updateVariable');
        }
    },
    mounted() {
        this.boardlist()
    },
    methods:{
        write() {
            this.$router.push({
                path: 'create'
            })
        },
        detail(index) {
            this.$router.push({
                name: 'Detail',
                params: {
                    contentId: index
                }
            })
        },
        boardlist(){
            this.$http.get('http://localhost:5000/api/board')
            .then(res => {
                //console.log(res.data.list);
                this.rows = res.data.list            
            })
        }
    }
}
</script>