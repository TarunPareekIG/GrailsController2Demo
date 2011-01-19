package filters

class SecurityFilters {

    def filters = {
        /*all(controller:'*', action:'*') {
            before = {
                println "------Before into the ${controllerName} and action : ${actionName}---params:${params}"
            }
            after = {
                println "------After into the ${controllerName} and action : ${actionName}---params:${params}"
            }
            afterView = {
                println "------AfterView into the ${controllerName} and action : ${actionName}---params:${params}"
            }
        }*/

        loginCheck(controller:'*',action:'*'){
            before = {
                if(!session.user && controllerName!='user'){
                    //Redirect for Login
                    flash.loginMessage="User has Not been Logged In"
                    if (!params.targetUri) {
                        println "-------------Forward URI----${request.forwardURI.toString()}"
                        println "-------------Context Path----${request.contextPath.toString()}"
                        String targetUri = request.forwardURI.toString() - request.contextPath.toString()
                        if (!(targetUri == null || targetUri == "/"))
                            params.targetUri = targetUri
                        println params.targetUri
                    }
                    redirect(controller: 'user', action: 'index');
                    return false;
                }
            }
        }

        notUserController(controller:'user',invert:true){
            before={
                if(session?.user){
                    println "---------------User Logged In Is ${session?.user?.username}------------------"
                }else{
                    println "session time out"
                }
            }
        }
    }
    
}
