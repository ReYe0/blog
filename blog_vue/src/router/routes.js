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
    {
        name: 'BlogHeader',
        path: '/b',
        component: () => import('@/components/BlogHeader')
    },
    {
        name: 'MyNavigation',
        path: '/c',
        component: () => import('@/components/MyNavigation')
    },
    
    
];

export default routes
