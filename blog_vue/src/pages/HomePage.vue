<template>
  <div style="margin-top: 15px">
    <el-row :gutter="0">
      <el-col :span="12" :offset="3">
        <el-card shadow="never" style="padding-top:0;">
          <template #header>
            <div class="card-header">
              <span style="color:#1685a9;">{{ $t("nav.logo") }}</span>
              <span style="margin-left:72%;font-size:14px;">{{$t("home.total")}}<span style="color:#f2711c;font-size:24px;">99</span>{{$t("home.page")}}</span>
            </div>
          </template>
            <div class="card-header top1" v-for="blog in 5" :key="blog">
                <div class="top2">
                  <div class="right1">
                    <div class="blog_title"><h4>SpringCloud的学习笔记（Eureka、Ribbon、Feign、Hystrix、Zuul）</h4> </div>
                    <div class="blog_description">SpringCloud的学习笔记（Eureka、Ribbon、Feign、Hystrix、Zuul）</div>
                    <!-- <div class="blog_note">标签</div> -->
                    <div class="blog_bottom">
                      <div class="blog_date">
                      tcefrep  2021-01-27 04:00 8435 10
                    </div>
                    <div class="blog_note">

                      <el-tag type="success">标签二</el-tag>
                      <el-tag type="success">标签二</el-tag>
                      <el-tag type="success">标签二</el-tag>
                    </div>
                    </div>
                    
                  </div>
                  
                  <div class="blog_img">
                    <a href="">
                    <img src="https://img1.baidu.com/it/u=1966616150,2146512490&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1660410000&t=708532ea9be6f9400a22bb41a77ed1cd" alt="">
                    </a>
                </div>
              <!-- <el-divider content-position="right"> <el-icon><star-filled /></el-icon></el-divider> -->
            </div>
            </div>
        </el-card>
      </el-col>
      <el-col :span="5" :offset="1">
        <el-card shadow="never"> sdf </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "HomePage",
  props: {
    msg: String,
  },
  components: {},
  methods: {
    test() {
      this.$http.get("/sdfsdf");
    },
  },
};
</script>
<style>

.top1{
      -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    /* color: rgba(0,0,0,.87); */
    cursor: url(https://cdn.jsdelivr.net/gh/sviptzk/HexoStaticFile@latest/Hexo/img/default.cur),default;
    -webkit-box-direction: normal;
    box-sizing: inherit;
    /* padding-top: 1em!important; */
    padding-bottom: 1em!important;
    position: relative;
    font-size: 1rem;
    margin: 1rem;
    background: none transparent;
    border-radius: 0;
    box-shadow: none;
    border: none;
    border-bottom: 1px solid rgba(34,36,38,.15);
    padding-left: 0;
    padding-right: 0;
}
.top2{
      -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    /* color: rgba(0,0,0,.87); */
    cursor: url(https://cdn.jsdelivr.net/gh/sviptzk/HexoStaticFile@latest/Hexo/img/default.cur),default;
    font-size: 1rem;
    box-sizing: inherit;
    display: flex;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
    flex-direction: row;
    flex-wrap: wrap;
    -webkit-box-align: stretch;
    align-items: stretch;
    padding: 0;
    margin-top: -1rem;
    margin-bottom: -1rem;
    margin-left: -1rem;
    margin-right: -1rem;
}
.right1{
      -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    /* color: rgba(0,0,0,.87); */
    font-size: 1rem;
    box-sizing: inherit;
    position: relative;
    display: inline-block;
    padding-left: 1rem;
    padding-right: 1rem;
    padding-top: 1rem;
    padding-bottom: 1rem;
    width: 68.75%!important;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    flex-direction: column;
    vertical-align: middle;
    align-self: center!important;
    cursor: pointer;
}
.blog_title{
      -webkit-text-size-adjust: 100%;
    -webkit-box-direction: normal;
    cursor: pointer;
    box-sizing: inherit;
    border: none;
    margin: calc(2rem - .14285714em) 0 1rem;
    padding: 0 0;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    font-weight: 700;
    line-height: 1.28571429em;
    text-transform: none;
    /* color:#212121; */
    font-size: 16px;
    margin-top: -.14285714em;
}
.blog_description{
      -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    /* color: rgba(0,0,0,.87); */
    font-size: 14px;
    -webkit-box-direction: normal;
    cursor: pointer;
    box-sizing: inherit;
    margin: 0 0 1em;
    margin-bottom: 20px!important;
    letter-spacing: 1px!important;
    line-height: 1.8;
    font-weight: 300!important;
    margin-top: 0;
}
.blog_note{
          -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    /* color: rgba(0,0,0,.87); */
    font-size: 1rem;
    cursor: pointer;
    -webkit-box-direction: normal;
    box-sizing: inherit;
    position: relative;
    display: inline-block;
    padding-left: 1rem;
    padding-right: 1rem;
    vertical-align: top;
    padding-top: 1rem;
    padding-bottom: 1rem;
    width: 32%!important;
    text-align: right;
    align-self: inherit;
}
.blog_date{
         -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    /* color: rgba(0,0,0,.87); */
    font-size: 1rem;
    cursor: pointer;
    -webkit-box-direction: normal;
    box-sizing: inherit;
    position: relative;
    display: inline-block;
    padding-left: 1rem;
    padding-right: 1rem;
    vertical-align: top;
    padding-top: 1rem;
    padding-bottom: 1rem;
    width: 55%!important;
}
.blog_img{
    -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    /* color: rgba(0,0,0,.87); */
    cursor: url(https://cdn.jsdelivr.net/gh/sviptzk/HexoStaticFile@latest/Hexo/img/default.cur),default;
    font-size: 1rem;
    box-sizing: inherit;
    position: relative;
    display: inline-block;
    /* padding-left: 1rem;
    padding-right: 1rem;
    padding-top: 1rem;
    padding-bottom: 1rem; */
    width: 25%!important;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    flex-direction: column;
    vertical-align: middle;
    align-self: center!important;
}
.blog_img img{
      -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    cursor: url(https://cdn.jsdelivr.net/gh/sviptzk/HexoStaticFile@latest/Hexo/img/default.cur),default;
    font-size: 1rem;
    -webkit-box-direction: normal;
    /* color: #4183c4; */
    box-sizing: inherit;
    border: 0;
    position: relative;
    vertical-align: middle;
    max-width: 100%;
    background-color: transparent;
    display: block;
    border-radius: .3125em;
}
.blog_img a{
      -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    cursor: url(https://cdn.jsdelivr.net/gh/sviptzk/HexoStaticFile@latest/Hexo/img/default.cur),default;
    font-size: 1rem;
    -webkit-box-direction: normal;
    box-sizing: inherit;
    background-color: transparent;
    color: #4183c4;
    text-decoration: none;
}
.blog_bottom{
      -webkit-text-size-adjust: 100%;
    font-family: Lato,'Helvetica Neue',Arial,Helvetica,sans-serif;
    line-height: 1.4285em;
    /* color: rgba(0,0,0,.87); */
    font-size: 1rem;
    cursor: pointer;
    box-sizing: inherit;
    display: flex;
    -webkit-box-orient: horizontal;
    -webkit-box-direction: normal;
    flex-direction: row;
    flex-wrap: wrap;
    -webkit-box-align: stretch;
    align-items: stretch;
    padding: 0;
    margin-top: -1rem;
    margin-bottom: -1rem;
    margin-left: -1rem;
    margin-right: -1rem;
}

</style>
