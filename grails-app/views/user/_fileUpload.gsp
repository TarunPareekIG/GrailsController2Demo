%{--CommandObjectExample--}%
<g:if test="${session?.user}">
    <h1>Upload To File System</h1>
    <g:form controller="user" action="uploadProfilePicFileSystem" name="fileSystemUpload" enctype="multipart/form-data">
         Upload File:&nbsp;<input type="file" name="myfile"/>
         <input type="submit" name="submitFS">
    </g:form>
    <br/>
    <br/>
    <h1>Upload In Database</h1>
    <g:form controller="user" action="uploadProfilePicDatabase" name="fileSystemUpload" enctype="multipart/form-data">
         Upload File:&nbsp;<input type="file" name="myfile"/>
         <input type="submit" name="submitDB">
    </g:form>
    <br/>
    <br/>
    <h1>Writing Response</h1>
    <img src="${createLink(controller:'user',action:'displayProfilePic')}" width="100" height="100"/>
</g:if>
<g:else>
    Please Login First or Create User from Command Object Tab
</g:else>