export default {
	baseUrl: 'http://localhost:8080/springboot5578bn9k/',
	name: '/springboot5578bn9k',
	indexNav: [
		{
			name: '营养成份',
			url: '/index/eshianyycf',
		},
		{
			name: '菜品信息',
			url: '/index/caipinxinxi',
		},
		{
			name: '社区交流',
			url: '/index/forum'
		}, 
		{
			name: '消息推送',
			url: '/index/news'
		},
		{
			name: '反馈建议',
			url: '/index/messages'
		},
	],
	cateList: [
		{
			name: '社区交流',
			refTable: 'forumtype',
			refColumn: 'typename',
		},
		{
			name: '消息推送',
			refTable: 'newstype',
			refColumn: 'typename',
		},
	]
}
