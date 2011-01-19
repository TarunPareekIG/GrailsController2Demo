package com.demo

class User {
    String name
    String email
    Date dateOfBirth
    String address
    Integer phone
    Integer zip

    static constraints = {
        name(blank:false,nullable:false)
        email(email:true,blank:false,nullable:false)
        dateOfBirth(min:new Date(),nullable:true)
        address(nullable: true)
        phone(nullable:true)
        zip(nullable:true)
    }
}
