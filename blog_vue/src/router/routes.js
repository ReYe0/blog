const routes = [
    {
        name: 'homePage',
        path: '/',
        component: () => import('@/pages/HomePage')
    },
    {
        name: 'writeArticle',
        path: '/writeArticle',
        component: () => import('@/admin/pages/WriteArticle')
    },
    // {
    //     name: 'EmojiExtension',
    //     path: '/a',
    //     component: () => import('@/components/EmojiExtension')
    // },
    
    
];

export default routes
