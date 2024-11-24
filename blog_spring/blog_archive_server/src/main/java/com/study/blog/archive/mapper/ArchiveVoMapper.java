package com.study.blog.archive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.blog.archive.vo.ArchiveVo;
import com.study.blog.entity.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 20:05
 */
@Repository
public interface ArchiveVoMapper extends BaseMapper<ArchiveVo> {

    /**
     * 获取年份
     * @author 二爷
     * @E-mail 1299461580@qq.com
     * @date 2022/9/18 20:14
     * @param  start
     * @param  pageSize
     * @return java.util.List<com.study.entity.vo.ArchiveVo>
     */
    @Select("select DISTINCT date_format(create_time, '%Y') as year from tb_blog as a order by year desc")
    List<ArchiveVo> selectYearList();
    /**
     * 获取每一种归档的
     * @author 二爷
     * @E-mail 1299461580@qq.com
     * @date 2022/9/18 19:39
     * @param  start 归档偏移量
     * @param  pageSize 每一页的归档数量
     * @return java.util.List<com.study.entity.vo.ArchiveVo> 每一种归档的文章数量
     */
    @Select("select a.id as id, a.title as title, a.view_count as viewCount, a.thumbnail as thumbnail,a.create_time as createTime from tb_blog as a order by a.create_time desc limit #{start}, #{pageSize}")
    List<Blog> selectArchiveList(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
}
