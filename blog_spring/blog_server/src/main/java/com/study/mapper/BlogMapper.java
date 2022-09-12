package com.study.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.entity.Blog;
import com.study.entity.vo.BlogBackListVo;
import com.study.entity.vo.BlogListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//在对应的Mapper 接口上 基础基本的 BaseMapper<T> T是对应的pojo类
@Repository //告诉容器你是持久层的 @Repository是spring提供的注释，能够将该类注册成Bean
public interface BlogMapper extends BaseMapper<Blog> {
    // 所有的crud编写完成
//    @Select("SELECT tc.name as categoryName,tb.id as id,tb.title as title,tb.thumbnail as thumbnail ,tb.summary as summary ,tb.view_count  as viewCount,tb.create_time as create_time \n" +
//            "FROM tb_blog tb ,tb_category tc where tc.id = tb.category_id ")
//    Page<BlogListVo> getBlogListVo(Page<BlogListVo> Page);

    @Select("SELECT  tb.id as id,tb.is_top as isTop,tc.name as categoryName, tb.title as title,tb.thumbnail as thumbnail ,tb.summary as summary ,tb.view_count  as viewCount,tb.create_time as create_time FROM tb_blog tb left join tb_category tc  on tc.id = tb.category_id   where tb.status = #{status}  order by tb.is_top desc,tb.create_time desc")
    IPage<BlogListVo> getBlogListVo(IPage<BlogListVo> Page,@Param("status") Boolean status);

    @Select("select DISTINCT tb.id,tb.thumbnail,tb.title,tc.name as categoryName,tbt.blog_type as blogType,tb.is_top as isTop,tb.view_count as viewCount,tb.status ,tb.create_time as createTime\n" +
            "from tb_blog tb left join tb_category tc on tc.id = tb.category_id \n" +
            "left join tb_blog_type tbt on tb.blog_type_id = tbt.id\n" +
            "left join  tb_blog_tag tag on tag.blog_id = tb.id \n" +
            "where tag.tag_id like  concat('%',#{tagId},'%')  and tbt.id like  concat('%',#{blogTypeId},'%') \n" +
            "and tb.category_id like  concat('%',#{categoryId},'%') and tb.title like  concat('%',#{title},'%') order by tb.create_time desc")
    IPage<BlogBackListVo> getBlogBackListVo(IPage<BlogBackListVo> Page, @Param("blogTypeId") String blogTypeId,@Param("categoryId") String categoryId,@Param("tagId") String tagId,@Param("title") String title);

}
