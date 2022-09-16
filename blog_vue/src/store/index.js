import { createStore } from "vuex";
import { getAdminInfo } from '../api/user'
import { getArticleCount } from '../api/article'
import { getCategoryCountList } from '../api/category'
import { getTagCountList } from '../api/tag'
import { getUserInfo } from "../utils/storage"
import tagsView from '@/store/tagsView'

// 管理员
let adminAbout = {
	namespaced: true,
	state: {
		adminInfo: {
			nickName: "test",
			signature: "",
			avatar: require("@/assets/image/avatar.jpg"),
			githubUrl: "https://github.com/zhiyiYo",
		},
		articleCountInfo: {
			article: 0,
			category: 0,
			tag: 0,
		},
		isAdmin: getUserInfo() ? getUserInfo().isAdmin : false
	},
	actions: {
		getAdminInfo(context) {
			return new Promise((resolve) => {
				getAdminInfo().then(data => {
					context.commit('updateAdminInfo', data)
					resolve(data)
				})
			})
		},
		getArticleCount(context) {
			return new Promise((resolve) => {
				getArticleCount().then(data => {
					context.commit('updateArticleCountInfo', data)
					resolve(data)
				})
			})
		},
	},
	mutations: {
		updateAdminInfo(state, adminInfo) {
			Object.assign(state.adminInfo, adminInfo)
		},
		updateArticleCountInfo(state, articleCountInfo) {
			Object.assign(state.articleCountInfo, articleCountInfo)
		},
		updateIsAdmin(state) {
			state.isAdmin = getUserInfo() ? getUserInfo().isAdmin : false
		}
	},
}


// 网站
let websiteAbout = {
	namespaced: true,
	state: {
		startDate: "2022-08-01"
	},
	actions: {},
	mutations: {},
}


// 分类
let categoryAbout = {
	namespaced: true,
	state: {
		categoryCounts: []
	},
	actions: {
		getCategoryCounts(context) {
			return new Promise((resolve) => {
				getCategoryCountList().then(res => {
					context.commit('updateCategoryCounts', res.data.data)
					resolve()
				})
			})
		}
	},
	mutations: {
		updateCategoryCounts(state, data) {
			state.categoryCounts = data
		}
	}
}

// 标签
let tagAbout = {
	namespaced: true,
	state: {
		tagCounts: []
	},
	actions: {
		getTagCounts(context) {
			return new Promise((resolve) => {
				getTagCountList().then(data => {
					context.commit('updateTagCounts', data)
					resolve()
				})
			})
		}
	},
	mutations: {
		updateTagCounts(state, data) {
			state.tagCounts = data
		}
	}
}
// 路由显示
let currentPathName = {
	namespaced:true,
	state: {
        currentPathName: ''
    },
    mutations: {
        setPath (state) {
            state.currentPathName = localStorage.getItem("currentPathName")
        },
        logout() {
            // 清空缓存
            localStorage.removeItem("staff")
            localStorage.removeItem("menus")
            router.push("/login")

            // 重置路由
            resetRouter()
        }
    }
}
export default createStore({
	modules: { adminAbout, websiteAbout,categoryAbout,tagAbout,currentPathName,tagsView },
});
