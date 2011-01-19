<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
      <meta name="layout" content="main"/>
      <title>User Signup</title>
      <script type="text/javascript">
          jQuery(document).ready(function(){
              jQuery("#demoTab").tabs();
              jQuery("#dataBinding").tabs();
          })
      </script>
  </head>
  <body>
      <h1>BootCamp Topic: Grails Controller - II</h1>
      ${flash.loginMessage}
      <h1>Topic to be discussed:</h1>
      <div id="demoTab" style="width:95%;">
          <ul>
              <li><a href="#dataBinding">Data Binding</a></li>
              <li><a href="#commandObject">Command Object</a></li>
          </ul>
          <div id="dataBinding" style="width:95%;">
              <h1>Data Binding Demos</h1>
              <ul>
                  <li><a href="#tab1">Implicit Constructor</a></li>
                  <li><a href="#tab2">Using Properties</a></li>
                  <li><a href="#tab3">Bind Data Method</a></li>
                  <li><a href="#tab4">Multiple Domain Object</a></li>
              </ul>
              <div id="tab1" style="border-left:1px solid #000; border-right:1px solid #000; border-bottom:1px solid #000;">
                  <g:render template="implicitConstructor"/>
              </div>
              <div id="tab2" style="border-left:1px solid #000; border-right:1px solid #000; border-bottom:1px solid #000;">
                  <g:render template="properties"/>
              </div>
              <div id="tab3" style="border-left:1px solid #000; border-right:1px solid #000; border-bottom:1px solid #000;">
                  <g:render template="bindDataMethod"/>
              </div>
              <div id="tab4" style="border-left:1px solid #000; border-right:1px solid #000; border-bottom:1px solid #000;">
                  <g:render template="multipleDomainObject"/>
              </div>
          </div>
          <div id="commandObject" style="width:95%;">
              <h1>Command Object Demos</h1>
              ${flash.message}
              <g:render template="commandObject"/>
          </div>
      </div>
  </body>
</html>