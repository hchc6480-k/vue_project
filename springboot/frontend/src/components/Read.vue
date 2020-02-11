<template>
    <div>
        <b-table striped hover :items="rows" :fields="fields"></b-table>
        <b-button @click="write">{{message}}</b-button>        
    </div>    
</template>
<script>
import data from '@/data'
//import axios from 'axios'

export default {
    name: 'Read',
    data() {
        message:'글쓰기';
        data:'';
        
        return{
            message:'글쓰기',
            rows:data
        }
        
    },
    created () {
        this.$http.get('http://localhost:5000/api/test')
        .then(res => {
            console.log(res);            
        })
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
        }
    }
}
</script>