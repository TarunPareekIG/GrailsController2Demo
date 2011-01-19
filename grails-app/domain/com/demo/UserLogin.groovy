package com.demo

class UserLogin {
    String username
    String password
    String email
    byte[] profilePic
    String mimeType
    String filePath

    static constraints = {
        username(blank:false,nullable:true,size:5..20)
        password(blank:false,nullable:true,size:4..10)
        email(email:true,nullable:true)
        profilePic(blank:true,nullable:true)
        filePath(blank:true,nullable:true)
        profilePic(maxSize: 5000000,size:0..5000000)
        mimeType(nullable:true,blank:true)
    }
}
