<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>User Signup</title>
      <script type="text/javascript">
          jQuery(document).ready(function(){
              jQuery("#demoTab").tabs();
          })
      </script>
  </head>
  <body>
      <h1>BootCamp Topic: Grails Controller - II</h1>
      <h1>Topic to be discussed:</h1>
      <div id="demoTab" style="width:95%;">
          <ul>
              <li><a href="#fileUpload">File Upload</a></li>
          </ul>
          <div id="fileUpload" style="width:95%;">
              <h1>File Upload Demos</h1>
              ${flash.uploadMessage}
              <g:render template="fileUpload"/>
          </div>
      </div>
  </body>
</html>