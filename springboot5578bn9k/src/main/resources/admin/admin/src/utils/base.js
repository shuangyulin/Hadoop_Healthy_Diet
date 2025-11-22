const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot5578bn9k/",
            name: "springboot5578bn9k",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot5578bn9k/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Hadoop的健康饮食推荐系统的设计与实现"
        } 
    }
}
export default base
