<?php
    $db_connect=mysqli_connect("http://localhost/phpmyadmin/","root","","Clients");
?>

<html>
    <table width="50%" align="center" border="1" cellspacing="0" cellpadding="10">
        <tr>
            <td>
                <h1> Lost/Found Items </h1>
                <p> please fill out your claim </p>
                <form method="post" action="test.php">
                    <p>Student name:  <input type="text" name="name"></p> 
                    <p>Email Address: <input type="mail" name="Address"></p> 
                    <p>I Found: <input type="radio" name="found">  
                     Lost: <input type="radio" name="lost"></p> 
                    <textarea rows="10" cols="60" name="describe" placeholder="write a message "></textarea>
                    <p>At the campus: <select name="location">
                        <option value="entrance">entrance</option>
                        <option value="caffeteria">caffeteria</option>
                        <option value="computer lab">computer lab</option>
                    </select></p> 
                    <input type="submit" name="submit">
                    <input type="reset">
                    <input type="button" name="Diplay" Value="Display">
                </form>      
            </td>
        </tr>
        
    </table>
</html>