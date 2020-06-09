<template>
    <div>
        <b-table striped hover :items="rows"></b-table>
        <!--
        <b-pagination-nav            
            :number-of-pages="total_count"            
            :link-gen="linkGen"                        
            use-router
            ></b-pagination-nav>
        -->
        <div style="padding:10px;">
            <div class="pagination">
                <a @click="boardlist(1)">&laquo;</a>
                <a @click="boardlist(current_range > 1 ? start_page -1 : start_page)">&lt;</a>                            
                <a v-for="index in end_page" @click="boardlist(index)"  v-bind:class="[index == now_page ? 'active' : '']" v-if="index >= start_page && end_page >= index">{{index}}</a>
                <a @click="boardlist(total_page > end_page ? end_page+1 : end_page)">&gt;</a>                      
                <a @click="boardlist(total_page)">&raquo;</a>
            </div>        
            <b-button @click="write" style="float:right;">{{message}}</b-button>                
        </div>
    </div>        
</template>

<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

<script>
//import data from '@/data'
import axios from 'axios'
import Paginate from 'vuejs-paginate'

export default {
    name: 'Read',    
    data() {
        message:'글쓰기'
        return{
            message:'글쓰기',
            rows:null,
            total_count:0, //총 record 계수
            now_page : 1, // 현재 페이지
            paging_count : 5, // ex 1~5 , 6 ~10
            per_list : 2, // 한페이지에 보여줄 record 수
            current_range : 0,  // ex 현재 페이지가 1~5 or 6~10 인지 ..
            start_page : 0, // 현제 페이징 시작 수
            end_page : 0, // 현제 페이징 끝 수
            total_page : 0,  // 총 페이지 수          
        }
        
    },
    created(){
        
    },
    mounted() {
        //this.now_page = this.$route.params.page        
        this.boardlist(this.$route.params.page)
    },
    computed:{
        
    },
    methods:{
        write() {
            this.$router.push({
                path: '/create'
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
        /*
        boardlist(now_page){
            this.$http.get('http://localhost:5000/api/board')
            .then(res => {
                console.log(res.data.list);
                //board_data = res.data.list;
                this.rows = res.data.list;
                this.total_count = res.data.total_count % 2 == 0 ? parseInt(res.data.total_count /2) : parseInt((res.data.total_count /2)+1);                 
                this.now_page = parseInt(res.data.now_page);
                //alert(this.total_count);  
                //alert(this.now_page);         
            })
        },
        */       
        boardlist(pageNum) {            
            axios.get('http://127.0.0.1:5000/api/board',{
               params:{
                page : pageNum
               } 
            }, 
            {                                
                headers: { 'Content-Type': 'application/json' }
            }).then((Response) => {                                                
                this.rows = Response.data.list;
                this.total_count = Response.data.total_count 
                this.now_page = parseInt(Response.data.now_page);                             
                this.paging_count = 5;
                this.current_range = Math.floor(this.now_page/this.paging_count+(this.now_page % this.paging_count > 0 ? 1 : 0));
                this.total_page = Math.floor(this.total_count/this.per_list + (this.total_count%this.per_list > 0 ? 1 : 0)) ;                
                this.end_page = this.current_range * this.paging_count;                
                this.start_page = this.end_page - (this.paging_count -1)
                if(this.end_page > this.total_page){
                    this.end_page = this.total_page
                }                                
                console.log(this.total_page+','+this.current_range+','+this.start_page+','+this.end_page);
            }).catch((ex)=>{
              alert('에러발생');
              console.log(ex);              
            })         
        },
        
        linkGen(page){
            this.$router.push({path:'/read/'+page});
        },
        
    }
}
</script>