<%-- 
    Document   : ventanaUsuario
    Created on : 9/06/2020, 03:18:10 PM
    Author     : arcangelmarinp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido!
        <jsp:useBean id="validUsuario" scope="session" class="com.udea.ws.Empleado" />
        <jsp:getProperty name="validUsuario" property="nombres" />
        </h1>
        
        <form action="SRegistra" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>DNI:</td>
                        <td><input type="text" name="txtDni" value="" /></td>
                    </tr>
                    <tr>
                        <td>CONTRASEÑA:</td>
                        <td><input type="password" name="txtPass" value="" /></td>
                    </tr>
                    <tr>
                        <td>APELLIDO:</td>
                        <td><input type="text" name="txtApellidos" value="" /></td>
                    </tr>
                    <tr>
                        <td>NOMBRES:</td>
                        <td><input type="text" name="txtNombres" value="" /></td>
                    </tr>
                    <tr>
                        <td>PRIVILEGIOS</td>
                        <td><select name="cboPrivilegio">
                                <option value="Gerente">GERENTE</option>
                                <option value="Ingeniero">INGENIERO</option>
                                <option value="Recepcion">RECEPCION</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Registrar" name="btnResgistrar" /></td>
                        
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
