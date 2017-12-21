
<?php
$server_name = "localhost";
$mysql_user = "root";
$mysql_pass = "";
$db_name = "MonVoix";

$con = new mysqli($server_name, $mysql_user, $mysql_pass, $db_name);
// Check connection
if (!$con) {
  echo "connection error".mysqli_connect_error();
} 


else
{
echo "database connection successful";
}
?>