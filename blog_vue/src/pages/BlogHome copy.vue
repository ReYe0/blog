<template>
  <div id="container">
    <el-row  :gutter="rowGutter">
      
      <el-col :span="18" >
        <el-card shadow="never">
          <template #header>
            <div style="height:30px;">
              <div style="color:#1685a9;width:50%;display:block;float:left;line-height:30px; height:30px;text-align:left;">{{ $t("nav.logo") }}</div>
              <div class="erye-blog" >{{$t("home.total")}}<span style="color:#f2711c;font-size:24px;">99</span>{{$t("home.page")}}</div>
            </div>
          </template>
            <div class="blog-content" v-for="blog in 3" :key="blog">
                  <div class="description-content">
                    <div class="blog_title">操作系统之虚拟内存总结胜</div>
                    <div class="blog_description">摘要： 前言 操作系统的大量的私有内存前言 操作系统为每个进程提供了一个假摘要： 前言 操作系统的大量的私有内存前言 操作系统为每个进程提供了一个假摘要： 前言 操作系统的大量的私有内存前言 操作系统为每个进程提供了一个假摘要： 前言 操作系统的大量的私有内存前言 操作系统为每个进程提供了一个假象：它拥有属于自己的大量的私有内存前言 操作系统为每个进程提供了一个假象：它拥有属于自己的大量的私有内存，可以有巨大的连续地址空间放入自己的代码和数据。用户程序中…</div>
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
                      <el-image style="width: 100%; height: 100%;" src="https://img1.baidu.com/it/u=1966616150,2146512490&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1660410000&t=708532ea9be6f9400a22bb41a77ed1cd" fit="fill" />
                    <!-- <img src="https://img1.baidu.com/it/u=1966616150,2146512490&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1660410000&t=708532ea9be6f9400a22bb41a77ed1cd" alt=""> -->
                    </a>
            </div>
            </div>
        </el-card>
      </el-col>
      <el-col :span="6" >
        <el-card shadow="never" class="side-content">
          <AuthorCard/>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
import AuthorCard from '@/components/AuthorCard.vue'
export default {
  name: "BlogHome",
  props: {
    msg: String,
  },
  components: {
    AuthorCard
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
  
  /* margin-left:80%; */
  width:50%;display:block;float:left;height:30px;line-height:24px;text-align:right;
  font-size:14px;
}
.el-card__body{
  padding-top: 0;
}
.blog-content{
    vertical-align: middle;
    height: 200px;
    margin-top: 15px;
    cursor: pointer;
    padding-bottom: 20px;
    position: relative;
    border-bottom: 1px solid  var(--el-menu-border-color);
}
.description-content{
  height: 200px;
    display: inline-block;
    width: 70%;
    cursor: pointer;
}
.blog_title{
    cursor: pointer;
    font-weight: 700;
    /* height: 50px; */
    margin-bottom: 20px;
}
.blog_description{
    height: 150px;
    cursor: pointer;
    margin-bottom: 16px;
    font-weight: 300;
    padding-right: 10px;
    vertical-align: middle;

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
    /* padding-top: 14px; */
    padding-left: 5px;
    width: 55%;
}
.blog_note{
    cursor: pointer;
    vertical-align: middle;
    /* padding-top: 14px; */
    width: 40%;
    text-align: right;
}
.blog_img{
    display: inline-block;
    width:30%;
    /* vertical-align: middle; */
}
.blog_img img{
    max-width: 100%;
    /* max-height: 120px; */
    border-radius: 3%;
}
@media screen and (max-width: 900px) {
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
    top:240px;
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
    position: relative;
    top:-180px;
  }
  .blog_img img{
    max-width: 100%;
    border-radius: 3%;
}
}


</style>
