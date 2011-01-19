%{--Decipher Error On View--}%
<g:hasErrors bean="${userProperties}">
    <div class="errors">
        <g:renderErrors bean="${userProperties}" as="list"/>
    </div>
</g:hasErrors>


%{--ImplicitConstructorExample--}%
<g:form controller="user" action="updateProfileUsingProperties" name="userSignup1">
    <h3>Profile:</h3>
    <span>Name:</span><input type="text" name="name" value="${params?.name}"><br/>
    <span>Date of Birth:</span><input type="text" name="dateOfBirth" value="${params?.dateOfBirth}"><br/>
    <span>Email:</span><input type="text" name="email" value="${params?.email}"><br/>
    <span>Address:</span><input type="text" name="address" value="${params?.address}"><br/>
    <span>Phone:</span><input type="text" name="phone" value="${params?.phone}"><br/>
    <span>Zip:</span><input type="text" name="zip" value="${params?.zip}"><br/>
    <input type="submit" name="submit" name="submit1">
</g:form>