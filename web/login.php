<?php
include('config.php')
if($_SERVER['REQUEST_METHOD'] == "POST"){
    $email = $_POST['email'];
	$password = $_POST['password'];
	$params = array(
        'email' => $email,
    );
    $sql = file_get_contents('login.sql');
    $statement = $database->prepare($sql);
    $users = $statement->execute($params);
    if($users != null){
        foreach ($person as $users){
            if(password_verify($password, $person['password'])){
                $user = $person;
                $loggedin = true;
            }
        }
    }
 }
?>

