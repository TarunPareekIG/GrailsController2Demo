package com.demo

class UserController {
    def errorService

    def index = {render(view: 'userSignup') }

    def createProfileUsingImplicitConstructor = {
        //Example For Data Binding
        println "----------create profile------params------" + params
        User user = new User(params);

        //Error Handling using branching and hasError() method
        if (!user.hasErrors() && user.save(flush: true)) {
            render(view: 'userSignup')
        } else {
            //Error Deciphering
            println "   "
            println "Error Occured:"
            println "No. of Errors:" + user.errors.getErrorCount()
            println "   "
            println "List of Field Errors"
            user.errors.getFieldErrors().each {
                println "-----${it.code}:::::::::::${it.field}:::::::::::${it.rejectedValue}"
            }
            println "   "
            println "-------------------------------ALL ERRORS----------------------------"
            user.errors.allErrors.each {
                println "-----${it.code}"
            }
            render(view: 'userSignup', model: [user: user, params: params, userErrors: user.errors])
        }
    }

    def updateProfileUsingProperties = {
        //Example For Data Binding
        println "----------create profile------params------" + params
        if (session?.userDataBinding) {
            User user = User.get(session?.userDataBinding?.user?.id)
            user.properties = params

            //Error Handling using branching and hasError() method
            if (!user.hasErrors() && user.save(flush: true)) {
                render(view: 'userSignup')
            } else {
                //Error Deciphering
                errorService.decipherErrors(user);
                render(view: 'userSignup', model: [userProperties: user, params: params, userErrors: user.errors])
            }
        }else{
            flash.loginMessage="Please Create user and Login first using Multiple Domain Object Tab to update Profile"
            render(view: 'userSignup', model: [params: params])
        }
    }

    def createProfileUsingBindDataMethod = {
        //Example For Data Binding
        println "----------create profile------params------" + params
        User user = new User();

        //Exclude Specified Fields and Bind all other fields
        /*bindData(user,params,[exclude:['name','address']]);*/

        //Include Bind Only Specified Fields
        bindData(user, params, [include: ['name', 'email']])

        //Error Handling using branching and hasError() method
        if (!user.hasErrors() && user.save(flush: true)) {
            render(view: 'userSignup')
        } else {
            //Error Deciphering
            errorService.decipherErrors(user);
            render(view: 'userSignup', model: [userBindData: user, params: params, userErrors: user.errors])
        }
    }

    def signUpUsingMultipleDomainObject = {
        //Example For Data Binding
        println "----------signup------params------" + params
        User user = new User(params['user']);

        //Error Handling using branching and hasError() method
        if (!user.hasErrors() && user.save(flush: true)) {
            params.login['user'] = user
            println "----------login------params------" + params
            Login loginUserInfo = new Login(params['login'])
            //Error Deciphering Login
            if (loginUserInfo.hasErrors()) {
                user.delete();
                errorService.decipherErrors(loginUserInfo)
                render(view: 'userSignup', model: [loginInfo: loginUserInfo, params: params])
            } else {
                loginUserInfo.save(flush: true)
                session?.userDataBinding=loginUserInfo
                render(view: 'userSignup')
            }
        } else {
            //Error Deciphering User
            errorService.decipherErrors(user)
            render(view: 'userSignup', model: [userMultipleDomain: user, params: params])
        }
    }

    //COMMAND OBJECT
    def loginUsingCommandObject = {LoginCommand cmd ->
        println "---------Command Object------------" + cmd
        if (!cmd.validate() && cmd.hasErrors()) {
            println "----Invalid Command Object----" + errorService.decipherErrors(cmd)
            render(view: 'userSignup', model: [loginUserInfoCO: cmd])
            return;
        }
        println "---------CommandObject1-----------" + cmd
        UserLogin loginUserInfo = new UserLogin();
        loginUserInfo.properties = cmd;
        loginUserInfo.save(flush: true)
        if (loginUserInfo.hasErrors()) {
            errorService.decipherErrors(loginUserInfo);
        } else {
            session.user = loginUserInfo
            println "------User Logged In-----------"
        }
        render(view: 'userSignup', model: [loginUserInfoCO: session?.user])
    }

    def logout = {
        session?.user = null;
        render(view: 'userSignup')
    }
}
