<template>
  <div>
    <div style="margin: 5px" class="topSelect">
      <el-popconfirm
        confirm-button-text="OK"
        cancel-button-text="No, Thanks"
        title="Are you sure to delete this?"
        class="mySelect"
      >
        <template #reference>
          <el-button type="danger"
            >批量删除 <span style="opacity: 0">k</span
            ><el-icon><Delete /></el-icon
          ></el-button>
        </template>
      </el-popconfirm>

      <el-select 
        placeholder="请选择博客类型"
        v-model="blog.blogTypeId"
        clearable 
        class="mySelect"
      >
      <el-option
      v-for="item in blogTypeList"
      :key="item.id"
      :label="item.blogType"
      :value="item.id"
      />
      </el-select>
      <el-select
        placeholder="请选择分类"
        v-model="blog.categoryId"
        clearable 
        class="mySelect"
      >
      <el-option
        v-for="item in categoryList"
        :key="item.id"
        :label="item.name"
        :value="item.id"
      />
      </el-select>
      <el-select
        placeholder="请选择标签"
        v-model="blog.tagId"
        clearable 
        class="mySelect"
      >
      <el-option
        v-for="item in tagList"
        :key="item.id"
        :label="item.name"
        :value="item.id"
      />
      </el-select>
      <el-input
        style="width: 200px"
        class="mySelect"
        placeholder="请输入博客标题"
        v-model="blog.title"
      ></el-input>
      <el-button class="ml-5" type="primary" @click="getBlogList">查询</el-button>
      <el-button type="warning" @click="reset">重置</el-button>
    </div>

<br>
    <el-table
      :data="tableData"
      stripe
      border
      :header-cell-name="headerBg"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column
        align="center"
        prop="thumbnail"
        label="博客封面"
        width="180"
      >
      <template #default="scope">
        <el-image style="height: 100px" :src="scope.row.thumbnail" fit="contain"/>
      </template>
      </el-table-column>
      <el-table-column align="center" prop="title" label="标题" width="160">
      </el-table-column>
      <el-table-column align="center" prop="categoryName" label="分类" width="100">
      </el-table-column>
      <el-table-column align="center" prop="viewCount" label="浏览量" width="80">
      </el-table-column>
      
      <!-- <el-table-column align="center" prop="phone" label="点赞量" width="80">
      </el-table-column> -->
      <el-table-column align="center" prop="blogType" label="类型" width="120">
      </el-table-column>
      <el-table-column align="center" prop="status" label="是否发布" width="120">
        <template  #default="scope">
            <el-switch v-model="scope.row.status" inline-prompt
    active-text="是"
    inactive-text="否" @click="changeStatus(scope.row.id)"/>
        </template>
      </el-table-column>
      <el-table-column align="center" prop="isTop" label="是否顶置" width="120">
        <template  #default="scope">
            <el-switch v-model="scope.row.isTop" inline-prompt
    active-text="是"
    inactive-text="否" @click="changeIsTop(scope.row.id)"/>
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        prop="createTime"
        label="发布时间"
        width="150"
      >
      <template  #default="scope">
        {{scope.row.createTime.split("T")[0]}}
      </template>
      </el-table-column>
      <el-table-column align="center" label="操作">
        <template  #default="scope">
          <el-button type="success" @click="handleEdit(scope.row)"
            >编辑</el-button>
         <el-popconfirm
    confirm-button-text="Yes"
    cancel-button-text="No"
    :icon="InfoFilled"
    icon-color="#626AEF"
    title="Are you sure to delete this?"
    @confirm="confirmEvent"
    @cancel="cancelEvent"
  >
    <template #reference>
      <el-button type="danger">Delete</el-button>
    </template>
  </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="padding: 10px 0">
     <el-pagination
            layout="prev, pager, next"
            :total="blogTotal"
            :page-size="blog.pageSize"
            v-model:current-page="blog.pageNum"
            id="pagination"
            @current-change="getBlogList"
            v-if="blogTotal > 0"
        >
        </el-pagination>
    </div>
  </div>
</template>
<script>
export default {
  name: "blogList",
  data() {
    return {
        blogTypeList:[],
        categoryList:[],
        tagList:[],
        blog:{
            blogTypeId:"",
            categoryId:"",
            tagId:"",
            title:"",
            pageNum:1,
            pageSize:5,
        },
      tableData: [],
      blogTotal: 0,
      pageNum: 1,
      pageSize: 10,
      staffName: "",
      dialogFormVisible: false,
      form: {
        sex: Boolean,
      },
      multipleSelection: [],
      headerBg: "headerBg",
      roles: [], //角色
      consultClassAll: [],
      consultCityALl: [],
    };
  },
   mounted() {
    this.getBlogTypeList();//加载类型
    this.getTagList();//加载标签
    this.getCategoryList();//加载分类列表
    this.getBlogList();//获取博客列表
   },
  created() {
    //请求分页查询数据
    // this.load();
  },
  methods: {
    changeStatus(id){
        this.$http.get("blog/changeStatus/"+id).then(res=>{
        if(res.data.code === '200'){
            this.$message.success("操作成功！");
        }
       })
    },
    changeIsTop(id){
       this.$http.get("blog/changeIsTop/"+id).then(res=>{
        if(res.data.code === '200'){
            this.$message.success("操作成功！");
        }
       })
    },
    getBlogList(){
        this.$http.post("blog/blogBackList",this.blog).then(res =>{
            this.tableData = res.data.data.blogList
            this.blogTotal = res.data.data.total
        })
    },
    getBlogTypeList(){
      this.$http.get("blogType/getBlogTypeList").then(res =>{
          this.blogTypeList = res.data.data;
      })
    },
     getTagList(){
      this.$http.get("tag/tagList").then(res=>{
        this.tagList = res.data.data;
      })
    },
    getCategoryList(){
      this.$http.get("category/categoryList").then(res =>{
          this.categoryList = res.data.data;
      })
    },
    // 性别文字转换
    getSexText(item) {
      // console.log(this.tableData);
      // console.log(1111111,item[0].sex);
      if (item === true) {
        return "男";
      } else {
        return "女";
      }
    },
    load() {
      //请求分页查询数据
      this.request
        .get("/staff/page", {
          params: {
            pageNum: this.pageNum,
            pageSize: this.pageSize,
            staffName: this.staffName,
          },
        })
        .then((res) => {
          console.log(res);
          this.tableData = res.data.staffList;
          this.total = res.data.total;
          this.consultClassAll = res.data.consultClassAll;
          this.consultCityALl = res.data.consultCityALl;
        });
      let _this = this;
      setTimeout(function () {
        _this.request.get("/role").then((res) => {
          console.log(res);
          _this.roles = res.data;
        });
      }, 50);
    },
    // 重置
    reset() {
      this.staffName = "";
      this.load();
    },
    // 判断是否操作成功
    judge(code) {
      if (code === "200") {
        this.dialogFormVisible = false;
        this.$message.success("操作成功");
        this.load();
      } else {
        this.$message.error("操作失败");
      }
    },
    // 保存
    save() {
      this.request.post("/staff/save", this.form).then((res) => {
        console.log(this.form);
        this.judge(res.code);
      });
    },
    // 批量删除
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    delBatch() {
      let ids = this.multipleSelection.map((v) => v.id); //[{},{},{}][1,2,3]
      console.log(ids, 888);
      this.request.post("/staff/del/batch", ids).then((res) => {
        this.judge(res.code);
      });
    },
    // 新增
    handleAdd() {
      this.dialogFormVisible = true;
      this.form = {};
    },
    // 编辑
    handleEdit(row) {
      this.form = row;
      this.dialogFormVisible = true;
      this.load();
    },
    // 删除
    del(id) {
      this.request.delete("/staff/del/" + id).then((res) => {
        console.log(res);
        this.judge(res.code);
      });
    },
    handleSizeChange(pageSize) {
      console.log(pageSize);
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum);
      this.pageNum = pageNum;
      this.load();
    },
    // 导出文件
    exp() {
      window.open("http://localhost:8001/staff/export");
    },
    //文件导入
    handleExcelImportSuccess() {
      this.$message.success("导入成功");
      this.load();
    },
  },
};
</script>
<style>
.topSelect .mySelect{
    margin: 0 10px;
}
.headerBg {
  background: red !important;
}
</style>
