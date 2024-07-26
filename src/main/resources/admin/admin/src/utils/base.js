const base = {
    get() {
        return {
            url : "http://localhost:8080/yiqingxinxiguanlixitong/",
            name: "yiqingxinxiguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yiqingxinxiguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "疫情管理系统"
        } 
    }
}
export default base
