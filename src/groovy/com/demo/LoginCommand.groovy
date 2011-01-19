package com.demo

class LoginCommand {
    String username
    String password
    String email
    String confirmPassword

    static constraints={
        username(validator:{val,obj->
            if(UserLogin.findByUsername(obj.username)!=null){
                return "Username Already Taken"
            }
        })
        confirmPassword(blank:false,nullable:false,validator:{val, obj->
            if(obj.password!=val){
                return "Password Mis-Match"
            }
        });
    }
}
