const routes = [
    {
        name: 'homePage',
        path: '/',
        component: () => import('@/pages/HomePage'),
        meta: { title:'sdf' }
    },
    {
        name: 'writeArticle',
        path: '/writeArticle',
        component: () => import('@/admin/pages/WriteArticle')
    },
    // { // 表情扩展，以后在弄
    //     name: 'EmojiExtension',
    //     path: '/a',
    //     component: () => import('@/components/EmojiExtension')
    // },
    
    
];

export default routes
