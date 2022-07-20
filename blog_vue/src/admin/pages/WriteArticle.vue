<template>
    <div  style="background-color: rebeccapurple;height: 20px;">
      <!-- <v-md-editor v-model="value" height="600px"></v-md-editor> -->
    </div>
</template>
 
<script>
// import { reactive } from 'vue'
// import {mavonEditor} from 'mavon-editor/src'
// import 'mavon-editor/dist/css/index.css'
// import API from '../utils/axiosInstance'
// import { log } from 'console'
 
//  const formInline = reactive({
//   user: '',
//   region: '',
// })
// const onSubmit = () => {
//   console.log('submit!')
// }

 
export default{
    name: "WriteArticle",
  data () {
    return {
        value: '## 西游记',
        formInline:{
            user:'',
            regin:''
        }
    }
  },
    components:{
        // mavonEditor
    },
    method:{
        onSubmit(){
            console.log('submit!');
            // this.request.get('')
        },
        // change(value, render){
        //     //实时获取转成html的数据
        //     this.html = render
        //     console.log(this.html)
        // },
        // imgAdd(pos, $file){
        //     let form_data = new FormData()
        //     form_data.append('pic', $file)
        //     API({
        //         url:'',
        //         method:'post',
        //         data:form_data
        //     }).then(res=>{
        //         // 用后端返回回来的url替换前端的图片url
        //         this.$refs.md.$img2Url(pos, res.data.url)
        //         // this.$refs.md[0].$img2Url(pos, res.data.url)  有时候会有这种情况
        //     })
        // }
    }
}

</script>
<style>
    /*#editor {*/
    /*    margin: auto;*/
    /*    width: 80%;*/
    /*    height: 580px;*/
    /*}*/
</style>