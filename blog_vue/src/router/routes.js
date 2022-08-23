const routes = [
    {
        name: 'blogHOme',
        path: '/',
        component: () => import('@/pages/BlogHome'),
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
    {
        name: 'BlogFooter',
        path: '/d',
        component: () => import('@/components/BlogFooter')
    },
    {
        name: 'BlogDetail',
        path: '/article/:id',
        props: true,
        component: () => import('@/pages/BlogDetail')
    },
    
];

export default routes
