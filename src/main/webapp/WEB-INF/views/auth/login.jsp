<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form:form servletRelativeAction="/login">
            <div>
                <label>				
                    User
                    <input type='text' name='username' value=''>
                </label>
            </div>
            <div>
                <label>Password
                    <input type='password' name='password'/>
                </label>
            </div>
            <div>
                <input name="submit" type="submit" value="Login"/>
            </div>
        </table>
    </form:form>
</body>
</html>
