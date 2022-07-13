package com.study;

import com.study.entity.Blog;
import com.study.mapper.BlogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BlogSpringbootApplicationTests {

	@Autowired
	private BlogMapper blogMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void test1(){
		List<Blog> blog = blogMapper.selectList(null);
		blog.forEach(System.out::println);
	}

}
