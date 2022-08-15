package com.study.controller;

import com.study.entity.Blog;
import com.study.entity.Files;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

public class BlogControllerTest {

//    @Test
//    void test(){
//        ArrayList list = new ArrayList();
//        list.add(1);
//        ArrayList clone = (ArrayList) list.clone();
//        System.out.println(list);
//        System.out.println(clone);
//        System.out.println(list == clone);
//        list.set(0,2);
//        System.out.println(list);
//        System.out.println(clone);
//        System.out.println(list == clone);
//        Blog blog = new Blog();
//        blog.setId(1l);
////        blog.setContent("hhh");
//        Blog blogClone = blog.clone();
//        System.out.println(blog);
//        System.out.println(blogClone);
//        System.out.println(blog == blogClone);
//        blog.setId(2L);
//        ((Blog) blogClone).setContent("heihei");
//        System.out.println(blog);
//        System.out.println(blogClone);
//        System.out.println(blog.getFiles() ==  blogClone.getFiles());
//        System.out.println(blog == blogClone);
//    }

    @Test
    void test2(){
        Blog blog = new Blog();
        Blog deepClone = null;
        blog.setFiles(new Files());
        try {
            deepClone = blog.deepClone();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(blog == deepClone);
        System.out.println(blog.getFiles() == deepClone.getFiles());
    }
}
