<html>

    <head> <title>Variab1e  x </title>
    </head>
    <?php
    /*$columns = 20;
    $rows = 12;
    $totalSeats = $columns * $rows;
    
    $ticketCost = 3.75;
    $totalRevenu = $totalSeats * $ticketCost;
    
    $buildingCost = 300;
    $profit = $totalRevenu - $buildingCost;
    
    print("Total number of seats are : $totalSeats <br>");
    print("Total revenu is : $totalRevenu$ <br>");
    print("Total profit : $profit$");
    */
  
    $date = " 12/25/ 2002    ";
    $month = substr($date, 0, 3);
    $day = substr ($date, 4, 2) ;
    print ("Month=$month <br> Day=$day <br>") ;
    
    $beforetrim=strlen($date);
    $trim=trim($date);
    $aftertrim=strlen($trim);
    print ("before trim=$beforetrim <br> after trim=$aftertrim") ;
    

?>


</html>