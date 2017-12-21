<?php
 
 if($_SERVER['REQUEST_METHOD']=='POST'){
 $image = $_POST['image'];
 putenv('PYTHONPATH=/Library/Frameworks/Python.framework/Versions/2.7/lib/python2.7/site-packages');

// require_once('dbConnect.php');
 
// $sql ="SELECT id FROM images ORDER BY id ASC";
 
// $res = mysqli_query($con,$sql);
 
// $id = 0;
 

// $path = "uploads/0.jpeg";
 
// $actualpath = "http://localhost/android_connect/$path";
 
 //$sql = "INSERT INTO images (photo,name) VALUES ('$actualpath','$name')";
 
// if(mysqli_query($con,$sql)){
 $decoded = base64_decode($image);
 file_put_contents('/Applications/XAMPP/xamppfiles/htdocs/android_connect/0.jpeg', $decoded);
//echo "Successfully Uploaded";
// }
//$python = 'python /Users/aishwarya/Desktop/histeq.py';
//echo $python;
// mysqli_close($con);
// }else{
// echo "Error";
$result= exec("python test.py 2>&1",$result);
#var_dump($result);
echo $result;
 }
 ?>