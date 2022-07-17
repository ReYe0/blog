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
    
    
];

export default routes
