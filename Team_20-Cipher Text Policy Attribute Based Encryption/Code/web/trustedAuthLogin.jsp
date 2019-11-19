<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <title>Cipher_Text_Policy</title>
     
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="logo">
                   
                </div>
                <div id="menu">
                    <ul>
                        <p  class="first current_page_item"><a href="index.jsp">Home</a></p>
                        <p><a href="trustedAuthLogin.jsp">Trusted Auth</a></p>
                        <p><a href="domainLogin.jsp">Domain Auth</a></p>
                       <p><a href="ownerLogin.jsp">Data Owner</a></p>
                       <p><a href="consumerLogin.jsp">Data Consumer</a></p>                        
                    </ul>
                    <br class="clearfix" />
                </div>
            </div>
            <div id="inner">
                <div id="splash">
                    <%if (request.getParameter("msg") != null) {
                                out.println(request.getParameter("msg"));
                                out.println("");
                            }%>
                            
                            <span style="font-size: 22px;">Trusted Authority Login</span>
                        <form name="" action="TrustedLogin" method="post">
                            <table width="100%">
                                <tr style="height: 40px;"><td>User id:</td><td><input type="text" size="30" style="height: 25px;" id="name_" name="name_"/></td></tr>
                                <tr style="height: 40px;"><td>Password:</td><td><input type="password" size="30" style="height: 25px;" id="password" name="password"/></td></tr>                                
                                                        
                                <tr style="height: 40px;">
                                    <td></td><td><input type="submit" value="Login" style="height: 25px;width: 90px;"/></td></tr>
                                
                            </table>
                        </form>
                </div>
            
            </div>

        </div>

    </body>
</html>