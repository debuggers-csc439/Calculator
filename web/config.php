<?php
$user = 'debuggers';
$password = 'Debuggers@349';
$database = new PDO('mysql:host=198.71.225.51:3306;dbname=db_bmi', $user, $password);
session_start();
$current_uri = basename($_SERVER['REQUEST_URI']);
if(isset($_SESSION['customerID']))
  $loggedin = true;
else
  $loggedin = false;
?>