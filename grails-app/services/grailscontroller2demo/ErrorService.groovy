package grailscontroller2demo

class ErrorService {
    static transactional = true

    void decipherErrors(def object) {
        //Error Deciphering
        println "   "
        println "Error Occured:"
        println "No. of Errors:" + object.errors.getErrorCount()
        println "   "
        println "List of Field Errors"
        object.errors.getFieldErrors().each {
            println "-----${it.code}:::::::::::${it.field}:::::::::::${it.rejectedValue}"
        }
        println "   "
        println "-------------------------------ALL ERRORS----------------------------"
        object.errors.allErrors.each {
            println "-----${it.code}"
        }
    }
}
