<?php  
    if (isset($_POST["email"])&& isset($_POST["pswd"])){
        $file_contents = file_get_contents('http://localhost/Projects/web/NetworkSolutions/INVALID.html');
        eval('?>' . $file_contents);
         $firstname=$_POST["first_name"];
                $lastname=$_POST["last_name"];
                $usernamegen = $firstname[0] . $lastname[0]; 
        echo "<div style='position:absolute;z-index: 999;background-color: #7fdabb;margin-left: 30%;margin-top: 20%;height: 3%;width: 40%;border-radius: .25rem;'>
                <p align='center' style='margin-top:1%;margin-left:5%'><font face='arial' color='#000000'>Thank you for ordering you can login with your username  <b>|$usernamegen|</b> and your choosen password.</font></p>
                <br> 
                </div>";      
        $account_type =$_POST["choose"];;
        $price ="0";
        $service ="0";
        if ($account_type=='Corporate'){
            $account_type="Corporate";
            $price=="24000";
            $service=="250G";
        }elseif ($account_type=='Gaming'){
            $account_type="Gaming";
            $price="68000"; 
            $service="450G"; 
        }
        elseif ($account_type=='Fiber'){
            $account_type="Fiber";
            $price="38000";
            $service="300G";
        }
        
        $password=$_POST["pswd"];
        $email=$_POST["email"];

        $db_connect=mysqli_connect("localhost","root","cS[I5f*lbdc4!D26","Clients");   
        $query="insert into users_accounts values('$usernamegen','$email','$password','$account_type','2-1-2023','$service','0','$price');";
        mysqli_query($db_connect,$query)or die(mysqli_error($db_connect));  
        mysqli_close($db_connect); 
    }
    
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Inquire</title>

    <!--CSS Rule-->
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!--CSS Style-->
    <link rel="stylesheet" href="http://localhost/Projects/web/NetworkSolutions/CSS/header.css">
    <link rel="stylesheet" href="http://localhost/Projects/web/NetworkSolutions/CSS/home.css">
    <link rel="stylesheet" href="http://localhost/Projects/web/NetworkSolutions/CSS/Contact.css">
    <link rel="stylesheet" href="https://unpkg.com/aos@next/dist/aos.css" />

</head>

<body> 
    <!--Inquire Page Navigation-->
    <div>
        <!--Inquire Page TITLE-->
        <h1 data-aos="fade-up" class="center_text">Inquire</h1> 
        <!--Home Page Link-->
        <a href="http://localhost/Projects/web/NetworkSolutions/home.html">
            <p class="hometext">
                <img style="width:21%" src="http://localhost/Projects/web/NetworkSolutions/img/home.png">
                home/
            </p>
        </a>

        <!--Inquire Page Link-->
        <a href="http://localhost/Projects/web/NetworkSolutions/php/Inquire.php">
            <p class="aftershlash">
                <font color="#ff0000">Inquire</font>
            </p>
        </a>
        <!--Inquire img-->
        <img style="width: 100%;" src="http://localhost/Projects/web/NetworkSolutions/img/inquire.png"></img>
        
    </div>
    
    <!--Get in touch form-->
    <form class="getintouch" method="post" action="Inquire.php"> 
        <div data-aos-delay="500" data-aos="fade-up">
            <br> 
            <br> 
            <br> 
            <br> 
            <br> 
            <br> 
            <br> 
            <br>
            <!--Form title-->
            <h1 align="center">Your Details</h1>
            <table style="width:80%;" cellspacing="20" class="getintouch_formtable" border="0">
                <tr>
                    <td>
                        <div data-aos="fade-up">
                            <p>
                                <font size="2" color="#777777">First Name</font>
                                <font size="2" color="red"> *</font>
                            </p>
                            <input class="theme-input-style" type="text" name="first_name" required>
                        </div>
                    </td>
                    <td>
                        <div data-aos="fade-up">
                            <p>
                                <font size="2" color="#777777">Last Name</font>
                                <font size="2" color="red"> *</font>
                            </p>
                            <input class="theme-input-style" type="text" name="last_name" required>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div data-aos="fade-up">
                            <p>
                                <font size="2" color="#777777">Email address</font>
                                <font size="2" color="red"> *</font>
                            </p>
                            <input class="theme-input-style" type="email" name="email" required>
                        </div>
                    </td>
                    <td>
                        <div data-aos="fade-up">
                            <p>
                                <font size="2" color="#777777">Phone</font>
                                <font size="2" color="red"> *</font>
                            </p>
                            <input class="theme-input-style" type="text" name="phone" required>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div data-aos="fade-up">
                            <p>
                                <font size="2" color="#777777">password</font>
                                <font size="2" color="red"> *</font>
                            </p>
                            <input class="theme-input-style" type="password" name="pswd" required>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div data-aos="fade-up">
                            <h1>Choose your plan</h1>
                            <br>
                            <div data-aos="fade-up">
                                <input type="radio" name="choose" value="Corporate">
                                    <font style="margin-left:5px" face="helvetica, arial"color="#202e39">
                                        <strong>Corporate SME Services SME Microwave SME 8MB 500GB LIMIT</strong>
                                    </font>
                                <br>
                                <input style="margin-top:5px;" name="choose" type="radio"  value="Gaming">
                                    <font style="margin-left:5px" face="helvetica, arial" color="#202e39">
                                        <strong>Gaming DSL 8MB Speed 400GB 8MB Speed 400GB Monthly</strong>
                                    </font>
                                <br>
                                <input style="margin-top:5px;" name="choose" type="radio" value="Fiber">
                                    <font style="margin-left:2px" face="helvetica, arial" color="#202e39">
                                        <strong>Residential DSL 4MB Speed 50GB 4MB Speed 100GB LIMIT</strong>
                                    </font>
                                <br>
                                <br>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td align="center" colspan="3">
                        <button data-aos="fade-up"type="submit" name="create" class="btn">Create account</button> 
                    </td>
                </tr>
            </table> 
        </div>
    </form> 

    <!--making the page larger-->
    <br> 
    <br> 
    <br> 
    <br> 
    <br> 
    <br> 
    <br> 
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br> 
    <!-- Available services area--> 
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
            AOS.init({
                duration: 1000
            });
    </script>
</body>  
</html>