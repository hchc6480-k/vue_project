<template>
    <!--
    <div>
        <input v-model="writer" placeholder="글쓴이"/>
        <input v-model="title" placeholder="제목"/>
        <textarea v-model="content" placeholder="내용"/>
        <button @click="index !== undefined ? update() : wrtie()">{{index !== undefined ? '수정' : '작성'}}</button>
    </div>
    -->
    <div>
        <b-card bg-variant="light">
            <b-form-group
            label-cols-lg="3"
            label="게시글 작성"
            label-size="lg"
            label-class="font-weight-bold pt-0"
            class="mb-0"
            >
                <b-form-group
                    label-cols-sm="3"
                    label="제목:"
                    label-align-sm="right"
                    label-for="nested-street"
                >
                    <b-form-input id="nested-street" v-model="title"></b-form-input>
                </b-form-group>

                <b-form-group
                    label-cols-sm="3"
                    label="내용:"
                    label-align-sm="right"
                    label-for="nested-city"
                >
                    <b-form-textarea
                    id="textarea"
                    placeholder="게시글 작성..."
                    rows="3"
                    max-rows="6"
                    v-model="content"
                    ></b-form-textarea>
                </b-form-group>

                <b-form-group
                    label-cols-sm="3"
                    label="글쓴이"
                    label-align-sm="right"
                    label-for="nested-state"
                >
                    <b-form-input id="nested-state" v-model="writer" readonly></b-form-input>
                </b-form-group>
            </b-form-group>
            <b-button variant="info" @click="write()">작성</b-button>
        </b-card>
    </div>
</template>
<script>
//import data from '@/data'
import axios from 'axios'
export default {
    name: 'Create',
    data() {
        const index = this.$route.params.contentId;
        return{
            data: {},
            index: index,
            writer: index !== undefined ? data[index].writer : "",
            title: index !== undefined ? data[index].title : "",
            content: index !== undefined ? data[index].content : ""
        }
    },
    created() {
        this.writer = '1234';
    },
    methods: {
        write() {
            this.data.writer = this.writer
            this.data.title = this.title
            this.data.content = this.content
            
            axios.post('http://localhost:5000/api/board/cdboard',null,{
               params:{
                board_title:this.title,
                board_content:this.content,
                user_id:this.writer,
                type:"C" 
               } 
            }, 
            {                                
                headers: { 'Content-Type': 'application/json' }
            }).then((Resopnse) => {
                console.log(Response)
            }).catch((ex)=>{
              console.log(ex);

            })
           
            /*
            this.data.push({
                writer: this.writer,
                title: this.title,
                content: this.content,
            })            
            this.$router.push({
                path:'/'
            })
            */
        },
        update() {
            data[this.index].writer = this.writer
            data[this.index].title = this.title
            data[this.index].content = this.content
            this.$router.push({
                path: '/'
            })
        }
    }
}
</script>