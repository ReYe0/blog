<template>
  <div id="container">
    <el-row  :gutter="rowGutter">
      
      <el-col :span="18" >
        <el-card shadow="never">
          <template #header>
            <div>
              <span style="color:#1685a9;">{{ $t("nav.logo") }}</span>
              <span class="erye-blog">{{$t("home.total")}}<span style="color:#f2711c;font-size:24px;">99</span>{{$t("home.page")}}</span>
            </div>
          </template>
            <div class="blog-content" v-for="blog in 3" :key="blog">
                  <div class="description-content">
                    <div class="blog_title">操作系统之虚拟内存总结</div>
                    <div class="blog_description">S摘要： 前言 操作系统为每个进程提供了一个假象：它拥有属于自己的大量的私有内存，可以有巨大的连续地址空间放入自己的代码和数据。用户程序中…</div>
                    <div class="blog_bottom">
                      <div class="blog_date">
                      tcefrep  2021-01-27 04:00 8435 10
                    </div>
                    <div class="blog_note">
                      <span v-for="item in 3" :key="item">
                        <el-tag type="success" style="margin-left:5px;">标签{{item}}</el-tag>
                      </span>
                    </div>
                    </div>
                    
                  </div>
                  
                  <div class="blog_img">
                    <a href="">
                    <img src="https://img1.baidu.com/it/u=1966616150,2146512490&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1660410000&t=708532ea9be6f9400a22bb41a77ed1cd" alt="">
                    </a>
            </div>
            </div>
        </el-card>
      </el-col>
      <el-col :span="6" >
        <el-card shadow="never" class="side-content">
          <MyCard/>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import MyCard from '@/components/MyCard'
export default {
  name: "HomePage",
  props: {
    msg: String,
  },
  components: {
    MyCard
  },
  data(){
    return{
      rowGutter:20
    }
  },
  mounted(){
    let _this = this;
window.addEventListener("resize", function () {
  let scale = window.devicePixelRatio;
  let width = document.documentElement.clientWidth * scale;
  if (width > 900 * scale) {
    _this.rowGutter = 20;
  }else{
    _this.rowGutter = 0;
  }
});
  },
  methods: {
    test() {
      this.$http.get("/sdfsdf");
    },
  },
};
</script>
<style>

.erye-blog{
  margin-left:72%;font-size:14px;
}
.el-card__body{
  padding-top: 0;
}
.blog-content{
    margin-top: 15px;
    cursor: pointer;
    padding-bottom: 20px;
    position: relative;
    border-bottom: 1px solid rgba(34,36,38,.15);
}
.description-content{
    display: inline-block;
    width: 70%;
    flex-direction: column;
    vertical-align: middle;
    cursor: pointer;
}
.blog_title{
    cursor: pointer;
    font-weight: 700;
    /* height: 50px; */
    margin-bottom: 20px;
}
.blog_description{
    cursor: pointer;
    margin-bottom: 16px;
    font-weight: 300;
}
.blog_bottom{
    cursor: pointer;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    align-items: stretch;
    padding: 0;
    margin: -1rem;
}
.blog_date{
    cursor: pointer;
    padding-top: 14px;
    padding-left: 5px;
    width: 55%;
}
.blog_note{
    cursor: pointer;
    vertical-align: middle;
    padding-top: 14px;
    width: 40%;
    text-align: right;
}
.blog_img{
    display: inline-block;
    width:30%;
    vertical-align: middle;
}
.blog_img img{
    max-width: 100%;
    border-radius: 3%;
}
@media screen and (max-width: 900px) {
  .erye-blog{
    margin-left: 40%;
  }
    .side-content {
        display: none;
    }

    .el-col-18{
      max-width: 100%;
      flex: none;
  }
  .description-content{
    width: 100%;
    position: relative;
    top:200px;
  }
  .blog_description{
    margin: 0;
  }
  .blog_title{
    margin-bottom: 10px;
  }
  .blog_bottom{
    margin: 0;
  }
  .blog_date{
    width: 100%;
    position: relative;
    top: 25px;
  }
  .blog_note{
    width: 100%;
    text-align: left;
    position: relative;
    top: -40px;
  }
  .blog_img{
    width: 100%;
    height: 100%;
    overflow: hidden;
    position: relative;
    top:-190px;
  }
  .blog_img img{
    max-width: 100%;
    border-radius: 3%;
}
}


</style>
