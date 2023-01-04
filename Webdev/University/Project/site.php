<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!--CSS Style-->
    <link rel="stylesheet"
        href="http://localhost:3000/Webdev/University/Project/header.css">
    <link rel="stylesheet">
    <script src="http://localhost:3000/Webdev/University/Project/login.js"
        defer></script> 
</head>

<body>
    <?php 
        $name = "freddy";
    ?>

    <div style="box-shadow: 0 10px 5px 0 rgba(0, 0, 0, 0.12);" id="header">
        <div id="headinside">
            <div  class="dropdown" data-dropdown>
                <b class="dropdown_button" data-dropdown-button>
                    <?php 
                    print("Welcome $name"); 
                ?></b> </button> 
            </div>
        </div>
    </div>
     
    
</body>


</body>

</html>