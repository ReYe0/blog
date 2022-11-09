import request from '../utils/request'

/**
 * 获取热门文章
 * @returns promise
 */
function getHotBlogList() {
    return request.get('/blog/hotBlogList')
}


/**
 * 获取文章总数统计
 */
function getBlogCount() {
    return request.get('/blog/count')
}


/**
 * 获取发表的文章
 * @param {number} pageNum 当前页码
 * @param {number} pageSize 每一页的文章数
 * @param {number} categoryId 文章所属分类，可以不传
 * @param {number} tagId 文章的标签，可以不传
 * @param {string} date 文章的发表日期，格式为 `yyyy/MM`，比如 `2021/1` 或 `2021/02`，可以不传
 * @returns promise
 */
function getPostBlogList(pageNum, pageSize, categoryId, tagId, date) {
    let params = { pageNum, pageSize, categoryId, tagId, date }

    return request({
        url: '/blog/blogList',
        params,
    })
}


/**
 * 获取文章详情
 * @param {number} id 文章 id
 * @returns promise
 */
function getBlogDetails(id) {
    return request.get('/blog/' + id)
}


/**
 * 更新文章阅读数
 * @param {number} id 文章 id
 * @returns promise
 */
function updateViewCount(id) {
    return request({
        url: "/blog/updateViewCount/" + id,
        method: "put",
    })
}


/**
 * 获取上一篇和下一篇博客
 * @param {number} id 文章 id
 * @returns promise
 */
function getPreviousNextBlog(id) {
    return request.get("/blog/previousNextBlog/" + id)
}


/**
 * 添加文章
 * @param {object} blog 文章
 * @returns promise
 */
function addBlog(blog) {
    return request({
        url: "/blog",
        method: "post",
        data: blog,
        needAuthentication: true
    })
}

/**
 * 编辑文章
 * @param {object} blog 文章
 * @returns promise
 */
function editBlog(blog) {
    return request({
        url: "/blog",
        method: "put",
        data: blog,
        needAuthentication: true
    })
}


export {
    getHotBlogList,
    getBlogCount,
    getPostBlogList,
    getBlogDetails,
    updateViewCount,
    getPreviousNextBlog,
    addBlog,
    editBlog
}