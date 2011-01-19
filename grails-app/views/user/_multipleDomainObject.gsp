%{--ImplicitConstructorExample--}%
<g:form controller="user" action="signUpUsingMultipleDomainObject" name="userSignup1">
    <h3>Profile:</h3>
    %{--Decipher Error On View--}%
    <g:hasErrors bean="${userMultipleDomain}">
        <div class="errors">
            <g:renderErrors bean="${userMultipleDomain}" as="list"/>
        </div>
    </g:hasErrors>
    <span>Name:</span><input type="text" name="user.name" value="${params?.name}"><br/>
    <span>Date of Birth:</span><input type="text" name="user.dateOfBirth" value="${params?.dateOfBirth}"><br/>
    <span>Email:</span><input type="text" name="user.email" value="${params?.email}"><br/>
    <span>Address:</span><input type="text" name="user.address" value="${params?.address}"><br/>
    <span>Phone:</span><input type="text" name="user.phone" value="${params?.phone}"><br/>
    <span>Zip:</span><input type="text" name="user.zip" value="${params?.zip}"><br/>

    <h3>Account Details:</h3>
    <g:hasErrors bean="${loginInfo}">
        <div class="errors">
            <g:renderErrors bean="${loginInfo}" as="list"/>
        </div>
    </g:hasErrors>
    <span>Username:</span><input type="text" name="login.username" value="${params?.'login.username'}"><br/>
    <span>Password:</span><input type="password" name="login.password"><br/>
    <input type="submit" name="submit" name="submit1">
</g:form>