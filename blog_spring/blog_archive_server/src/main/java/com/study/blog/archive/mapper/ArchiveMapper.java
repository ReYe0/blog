package com.study.archive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.archive.vo.ArchiveCountVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: blog
 * @Author: 二爷
 * @E-mail: 1299461580@qq.com
 * @Date: 2022/9/18 19:29
 */
@Repository
public interface ArchiveMapper extends BaseMapper<ArchiveCountVo> {
    /**
     * 获取归档总数
     * @author 二爷
     * @E-mail 1299461580@qq.com
     * @date 2022/9/18 19:32
     * @param
     * @return java.lang.Long 归档的总数
     */
    @Select(" select count(*) from (select count(*) from tb_blog group by date_format(create_time, '%Y/%c')) as t")
    Long selectArchiveTotalCount();

    /**
     * 获取每一种归档文章的数量
     * @author 二爷
     * @E-mail 1299461580@qq.com
     * @date 2022/9/18 19:34 
     * @param  start
     * @param  pageSize
     * @return java.util.List<com.study.entity.vo.ArchiveCountVo> 每一种归档的文章数量
     */
    @Select("select date_format(create_time, '%Y/%c') as date, count(*) as count\n" +
            "        from tb_blog\n" +
            "        group by date\n" +
            "        order by date\n" +
            "                desc\n" +
            "        limit #{start},#{pageSize};")
    List<ArchiveCountVo> selectArchiveCount(@Param("start") Integer start, @Param("pageSize") Integer pageSize);



}
