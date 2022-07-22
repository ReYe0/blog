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
    {
        name: 'myHeader',
        path: '/myHeader',
        component: () => import('@/components/Myheader')
    },
    
    
];

export default routes
