package com.study.blog.common;

public class SystemConstants {
    /**
     * 文章是正常发布状态
     */
    public static final Boolean BLOG_STATUS_NORMAL = true;

    /**
     * 文章是草稿状态
     */
    public static final String BLOG_STATUS_Draft = "1";

    /**
     * 目录是正常发布状态
     */
    public static final String CATEGORY_STATUS_NORMAL = "0";

    /**
     * 友链是审核通过状态
     */
    public static final String LINK_STATUS_PASS = "0";

    /**
     * 根节点评论
     */
    public static final Long COMMENT_ROOT = -1L;

    /**
     * Redis 用户 id 的前奏
     */
    public static final String REDIS_USER_ID_PREFIX = "bloglogin:";

    /**
     * 用户类型为管理员
     */
    public static final String ADMIN_USER = "1";
}
