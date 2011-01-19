package com.demo

class Login {
    String username
    String password

    static belongsTo = [user:User]

    static constraints = {
        username(blank:false,nullable:false,size:5..50,unique:true)
        password(blank:false,nullable:false,size:6..15)
        user(nullable:false)
    }
}
