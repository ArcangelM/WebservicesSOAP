<%-- 
    Document   : index
    Created on : 9/06/2020, 02:35:23 PM
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
        <h1 style="text-align: center;">LOGIN USUARIO!</h1>
        <form action="SAutenticacion" method="POST">
            <table border="0" style="margin-left: 28%;">
                <thead>
                    <tr>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>DNI</td>
                        <td><input type="text" name="txtDni" value="" size="45" /></td>
                    </tr>
                    <tr>
                        <td>CONTRASEÑA</td>
                        <td><input type="password" name="txtPass" value="" size="45" /></td>
                    </tr>
                    <tr>
                        <td>PRIVILEGIO</td>
                        <td><select name="cboPrivilegio">
                                <option value="Gerente">Gerente</option>
                                <option value="Ingeniero">Ingeniero</option>
                                <option value="Recepcion">Recepcion</option>
                            </select></td>
                    </tr>
                    <tr>
                        
                        <td><input type="submit" value="INGRESAR" name="btnIngresar" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
