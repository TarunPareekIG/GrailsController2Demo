%{--CommandObjectExample--}%
<g:if test="${session?.user}">
    You'r Logged In As "User : ${session?.user?.username}"---------<g:link controller="user" action="logout">Logout</g:link>
</g:if>
<g:else>
<g:form controller="user" action="loginUsingCommandObject" name="userLogin">
    <h3>User Signup:</h3>
    <g:hasErrors bean="${loginUserInfoCO}">
        <div class="errors">
            <g:renderErrors bean="${loginUserInfoCO}" as="list"/>
        </div>
    </g:hasErrors>
    <span>Username:</span><input type="text" name="username" value="${params?.'username'}"><br/>
    <span>Password:</span><input type="password" name="password"><br/>
    <span>Confirm Password:</span><input type="password" name="confirmPassword"><br/>
    <span>Email:</span><input type="text" name="email"><br/>
    <input type="submit" name="submit" name="submit1">
</g:form>
</g:else>