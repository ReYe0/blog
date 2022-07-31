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
        name: 'helloWorld',
        path: '/a',
        component: () => import('@/components/HelloWorld')
    },
    
    
];

export default routes
