const routes = [
    {
        name: 'blogHOme',
        path: '/',
        component: () => import('@/pages/BlogHome'),
        meta: { title:'sdf' }
    },
    {
        path: '/:pathMatch(.*)*',
        component: () => import('@/pages/PageNotFound'),
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
    {
        name: 'ArchiveDetails',
        path: '/archive/:year/:month',
        props: true,
        component: () => import('@/pages/archive/ArchiveDetails')
    },
    {
        name: 'ArchiveList',
        path: '/archive',
        props: true,
        component: () => import('@/pages/archive/ArchiveList')
    },
    {
        name: 'CategoryList',
        path: '/category',
        component: () => import('@/pages/category/CategoryList')
    },
    {
        name: 'CategoryDetails',
        path: '/category/:id',
        props: true,
        component: () => import('@/pages/category/CategoryDetails')
    },
    {
        name: 'TagList',
        path: '/tag',
        component: () => import('@/pages/tag/TagList')
    },
    {
        name: 'TagDetails',
        path: '/tag/:id',
        props: true,
        component: () => import('@/pages/tag/TagDetails')
    },
    
];

export default routes
