<?php
putenv('PYTHONPATH=/Library/Frameworks/Python.framework/Versions/2.7/lib/python2.7/site-packages');
exec("touch /Applications/XAMPP/htdocs/android_connect/1.txt");
exec("chmod 777 /Applications/XAMPP/htdocs/android_connect/1.txt");
$result= exec("/Library/Frameworks/Python.framework/Versions/2.7/bin/python /Applications/XAMPP/htdocs/android_connect/test.py 2>&1",$result);
#var_dump($result);
echo $result;
?>
