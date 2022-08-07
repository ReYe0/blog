package com.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.entity.Blog;
import com.study.entity.Files;
import com.study.mapper.BlogMapper;
import com.study.mapper.FilesMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogSpringbootApplicationTests {

	@Autowired
	private BlogMapper blogMapper;

	@Autowired
	private FilesMapper filesMapper;
	@Test
	void contextLoads() {
	}

	@Test
	void test1(){
		QueryWrapper<Files> filesQueryWrapper = new QueryWrapper<>();
		filesQueryWrapper.eq("md5", 1);
		Files files = filesMapper.selectOne(filesQueryWrapper);
//		List<Blog> blog = blogMapper.selectList(null);
//		blog.forEach(System.out::println);
		System.out.println(files);
	}

}
