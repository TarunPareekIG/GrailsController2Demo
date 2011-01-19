package com.demo

class UploadFileController {
    //Testing Security Filters

    def index = {
        render(view:'fileUpload')
    }

    //File Upload
    def uploadProfilePicFileSystem={
        //On File System
        UserLogin userLogin=session?.user;
        def f=request.getFile('myfile')
        println "------------"+f
        def fileName="tarunTest1"
        def destDir="/home/tarun/Desktop"
        userLogin.filePath=destDir+'/'+params?.myfile?.getOriginalFilename();
        userLogin.save(flush:true);
        if(!f.empty){
            f.transferTo(new File(destDir,fileName))
            response.sendError(200,'Done');
        }else{
            flash.message="File Cannot be Empty"
            render(view:'fileUpload')
        }
    }

    def uploadProfilePicDatabase={
        //On File System
        UserLogin userLogin=session?.user;
        def f=request.getFile('myfile')
        println "------------"+f
        if (!f.empty) {
            userLogin.profilePic = f.getBytes();
            userLogin.mimeType = f.getContentType()
            userLogin.save(flush: true);
        } else {
            flash.message = "File Cannot be Empty"
            render(view: 'fileUpload')
        }
    }

    def displayProfilePic={
        //Writing Response
        UserLogin userLogin=session?.user
        response.setContentType(userLogin.mimeType)
        response.outputStream << userLogin.profilePic
        response.outputStream.flush()
    }
}
