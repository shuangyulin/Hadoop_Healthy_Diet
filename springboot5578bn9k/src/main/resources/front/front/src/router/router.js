import VueRouter from 'vue-router'
//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Messages from '../pages/messages/list'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import eshianyycfList from '../pages/eshianyycf/list'
import eshianyycfDetail from '../pages/eshianyycf/detail'
import eshianyycfAdd from '../pages/eshianyycf/add'
import caipinleixingList from '../pages/caipinleixing/list'
import caipinleixingDetail from '../pages/caipinleixing/detail'
import caipinleixingAdd from '../pages/caipinleixing/add'
import caipinxinxiList from '../pages/caipinxinxi/list'
import caipinxinxiDetail from '../pages/caipinxinxi/detail'
import caipinxinxiAdd from '../pages/caipinxinxi/add'
import yinshijiluList from '../pages/yinshijilu/list'
import yinshijiluDetail from '../pages/yinshijilu/detail'
import yinshijiluAdd from '../pages/yinshijilu/add'
import forumtypeList from '../pages/forumtype/list'
import forumtypeDetail from '../pages/forumtype/detail'
import forumtypeAdd from '../pages/forumtype/add'
import forumreportList from '../pages/forumreport/list'
import forumreportDetail from '../pages/forumreport/detail'
import forumreportAdd from '../pages/forumreport/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import popupremindList from '../pages/popupremind/list'
import popupremindDetail from '../pages/popupremind/detail'
import popupremindAdd from '../pages/popupremind/add'
import smsregistercodeList from '../pages/smsregistercode/list'
import smsregistercodeDetail from '../pages/smsregistercode/detail'
import smsregistercodeAdd from '../pages/smsregistercode/add'
import discusscaipinxinxiList from '../pages/discusscaipinxinxi/list'
import discusscaipinxinxiDetail from '../pages/discusscaipinxinxi/detail'
import discusscaipinxinxiAdd from '../pages/discusscaipinxinxi/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'messages',
					component: Messages
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'eshianyycf',
					component: eshianyycfList
				},
				{
					path: 'eshianyycfDetail',
					component: eshianyycfDetail
				},
				{
					path: 'eshianyycfAdd',
					component: eshianyycfAdd
				},
				{
					path: 'caipinleixing',
					component: caipinleixingList
				},
				{
					path: 'caipinleixingDetail',
					component: caipinleixingDetail
				},
				{
					path: 'caipinleixingAdd',
					component: caipinleixingAdd
				},
				{
					path: 'caipinxinxi',
					component: caipinxinxiList
				},
				{
					path: 'caipinxinxiDetail',
					component: caipinxinxiDetail
				},
				{
					path: 'caipinxinxiAdd',
					component: caipinxinxiAdd
				},
				{
					path: 'yinshijilu',
					component: yinshijiluList
				},
				{
					path: 'yinshijiluDetail',
					component: yinshijiluDetail
				},
				{
					path: 'yinshijiluAdd',
					component: yinshijiluAdd
				},
				{
					path: 'forumtype',
					component: forumtypeList
				},
				{
					path: 'forumtypeDetail',
					component: forumtypeDetail
				},
				{
					path: 'forumtypeAdd',
					component: forumtypeAdd
				},
				{
					path: 'forumreport',
					component: forumreportList
				},
				{
					path: 'forumreportDetail',
					component: forumreportDetail
				},
				{
					path: 'forumreportAdd',
					component: forumreportAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'popupremind',
					component: popupremindList
				},
				{
					path: 'popupremindDetail',
					component: popupremindDetail
				},
				{
					path: 'popupremindAdd',
					component: popupremindAdd
				},
				{
					path: 'smsregistercode',
					component: smsregistercodeList
				},
				{
					path: 'smsregistercodeDetail',
					component: smsregistercodeDetail
				},
				{
					path: 'smsregistercodeAdd',
					component: smsregistercodeAdd
				},
				{
					path: 'discusscaipinxinxi',
					component: discusscaipinxinxiList
				},
				{
					path: 'discusscaipinxinxiDetail',
					component: discusscaipinxinxiDetail
				},
				{
					path: 'discusscaipinxinxiAdd',
					component: discusscaipinxinxiAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
