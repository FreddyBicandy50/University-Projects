<?php
    $db_connect=mysqli_connect("localhost","root","root@1120338#7","epiz_34004686_Bns");   
    $username=$_POST["user_name"];
    $password=$_POST["pwd"];
    

    $display_table="select * from users_accounts;";
    $result=mysqli_query($db_connect,$display_table) or die (mysqli_error($db_connect));
    $dbtable = array("username","email","password","account_type","Expiry_date","service","quote","price");
    $user_info = array();
    $found = false;
    while($r=mysqli_fetch_assoc($result)){ 
        if ($r['username']==$username && $r['password'] == $password) {
            for ($i=0;$i<count($dbtable);$i++){
                $user_info[$i]=$r[$dbtable[$i]]; 
            }
        }

    }
    if (empty($user_info)) {
        $file_contents = file_get_contents('http://localhost/Projects/web/NetworkSolutions//INVALID.html');
        eval('?>' . $file_contents);
        echo '<div style="position:absolute;z-index: 999;background-color: #ffbcc6;margin-left: 30%;margin-top: 20%;height: 3%;width: 40%;border-radius: .25rem;">
                <p align="center" style="margin-top:1%;margin-left:5%"><font face="arial" color="#c6001b">Error! Your username or password is incorrect.</font></p>
                <br> 
                </div>';
        
    }else{
        $found = true;
    } 
    $service = $user_info[5];
    $quote = $user_info[6];
    $stojs = json_encode($service);
    $qtojs = json_encode($quote);

    mysqli_close($db_connect);
?>
<html>
    <head>
         <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>
            user panel
        </title>
        <link rel="stylesheet" href="http://localhost/Projects/web/NetworkSolutions/CSS/header.css">
        <link rel="stylesheet" href="http://localhost/Projects/web/NetworkSolutions/CSS/server.css">
    </head>
<body style="background-color:white">
  
    <div style="box-shadow: 0 2px 25px 25px rgba(0, 0, 0, .2);position:aboslute; z-index: 999;" id="header">
        <div id="headinside">
            <div data-aos="fade-left"  class="dropdown" data-dropdown>
                <a id="contact" href="tel:+96179131124" Style="right: 10px;">Call Now+96179131124</a>
                <button class="dropdown_button" data-dropdown-button>
                    <b class="dropdown_button" data-dropdown-button>Welcome <?php  echo $user_info[0]; ?></b> </button> 
                </div> 
            </div>
        </div> 
        
        <p style="position:absolute;margin-top:2%;margin-left:6%">  
        <font size="6px" face="helvetica, arial" color="#929aa8">USER INFO</font> </p>    
        <div class="back_user_info_area">
            <div style="background: rgb(255, 255, 255);" class="user_info_area">
                
                <br> 
                <ul style="margin-left:3%;margin-top:0%">
                    <font face="helvetica, arial" color="#929aa8">
                        <li><b>Username: <span class="phpstyle"><?php print($user_info[0]);?></span></li>
                        <li >Email:<span style="margin-left: 7% ;" class="phpstyle"><?php print($user_info[1]);?></span></li>
                        <li>Service:<b><span style="margin-left: 6% ;" class="phpstyle">3M/<?php print($user_info[5]);?></span></b></li>
                        <li>Expiry Date:<span style="margin-left: 4% ;" class="phpstyle"><?php print($user_info[4]);?></span></li>
                        <li>Price:<span ><?php print($user_info[7]);?>L.L</span></b></li>
                        <div style="position:absolute;z-index:999;margin-left:65%;margin-top:-300px" class="phpstyle">
                            
                               <b><font size="10px" face="helvetica, arial" color="#929aa8">
                                    <?php 
                                        if($found){
                                            $calc=100-(((int)$user_info[5]-(int)$user_info[6])/(int)$user_info[5]*100);
                                            echo ' <div style="background-color:white ; width: 300;height: 50;"> <p> <font size="6px" face="helvetica, arial" color="#929aa8">Monthly usage</font>   </p>   </div>';
                                            echo '<div style="position:absolute;z-index:999;margin-left:-178px;margin-top:90" >'.number_format((float)$calc, 2, '.', '')."%";  
                                        }
                                    ?> </b>
                        </div></b>
                </ul>
                </font>
                <input style="margin-top:-20px;margin-left:1%;width:15%;height:7%;border: 0.1rem rgb(181, 9, 9) solid;" type="button" value="Recharge Now" class="login_btn" onclick="prompt('rechargecode:')">  
                <div id="donutchart"  class="donut">      
                   
            </div>  
            </div> 
        </div>  
                    
          <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">  </script>
                    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.js"> 
                    </script>
                    
                    <script type="text/javascript" >  
                            var service = parseInt(JSON.parse('<?php echo $stojs; ?>'));
                            var quote = parseInt(JSON.parse('<?php echo $qtojs; ?>'));
                             google.charts.load("current", {packages:["corechart"]});
                            google.charts.setOnLoadCallback(drawChart);
                        function drawChart() {
                            var data = google.visualization.arrayToDataTable([ 
                                ['left', 'usage'], 
                                ['Quota', service],
                                ['Usage', quote], 
                            ]);

                            var options = { 
                                pieHole: 0.9,
                            }; 
                            var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
                            chart.draw(data, options);
                        }
                    </script> 
                    
        
        
</body>
</html>