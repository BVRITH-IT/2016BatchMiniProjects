
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
                    <h3></h3>
                </div>
                <div id="menu">
                    <center>
                        <p class="first current_page_item"><a href="index.jsp"><span style="border: 3px solid black;display:block; padding: 5px">Home</span></a>
                            <p><span style="border: 3px solid black; padding: 5px;display:block"><a href="ownerLogin.jsp">Data Owner</span></a>
                                <p><span style="border: 3px solid black; padding: 5px;display:block"><a href="consumerLogin.jsp">Data Consumer</span></a>
                                    <p><span style="border: 3px solid black; padding: 5px;display:block"><a href="domainLogin.jsp">Admin</span></a></p>
                                <p><span style="border: 3px solid black; padding: 5px;display:block"><a href="registration.jsp">Registration</span></a>
                                    <p><span style="border: 3px solid black; padding: 5px;display:block"><a href="cloudLogin.jsp">Cloud</span></a>

                                </center>
                    <br class="clearfix" />
                </div>
            </div>
            <div style="margin-top: -70px;margin-left: 150px;text-align: absolute;color:white;font-weight:bold">
              
                <center><h2>     CIPHER TEXT POLICY ATTRIBUTE BASED ENCRYPTION</h2></center>
                
                
                <p style="color: white;border-style:double; border-width: 15px;"></p>
                 <div style="background-image: url('images/h1.jpg');height: 400px;width: 650px;margin-left: 120px">
                    </div>
               
            <div id="h">
            </div>
                
            <div id="inner">
                <%if (request.getParameter("msg") != null) {
                        out.println(request.getParameter("msg"));
                    }%>
               

            </div>

        </div>

    </body>
                    
</html>