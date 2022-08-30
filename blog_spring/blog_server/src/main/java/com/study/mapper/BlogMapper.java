package com.study.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.entity.Blog;
import com.study.entity.vo.BlogListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//在对应的Mapper 接口上 基础基本的 BaseMapper<T> T是对应的pojo类
@Repository //告诉容器你是持久层的 @Repository是spring提供的注释，能够将该类注册成Bean
public interface BlogMapper extends BaseMapper<Blog> {
    // 所有的crud编写完成
//    @Select("SELECT tc.name as categoryName,tb.id as id,tb.title as title,tb.thumbnail as thumbnail ,tb.summary as summary ,tb.view_count  as viewCount,tb.create_time as create_time \n" +
//            "FROM tb_blog tb ,tb_category tc where tc.id = tb.category_id ")
//    Page<BlogListVo> getBlogListVo(Page<BlogListVo> Page);

    @Select("SELECT tc.name as categoryName,tb.id as id,tb.title as title,tb.thumbnail as thumbnail ,tb.summary as summary ,tb.view_count  as viewCount,tb.create_time as create_time \n" +
            "FROM tb_blog tb ,tb_category tc where tb.status = #{status} order by tb.is_top,tb.create_time asc")
    IPage<BlogListVo> getBlogListVo(IPage<BlogListVo> Page,@Param("status") Boolean status);

}
