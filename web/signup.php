<?php
$user = 'debuggers';
$password = 'Debuggers@349';
$database = new PDO('mysql:host=198.71.225.51:3306;dbname=db_bmi', $user, $password);
if($_SERVER['REQUEST_METHOD'] == "POST"){
    $name = $_POST['name'];
    $email = $_POST['email'];
    $password = $_POST['password'];
    $params = array(
        'name' => $name,
        'email' => $email,
        'password' => $password
    );
    $sql = file_get_contents('signup.sql');
    $statement = $database->prepare($sql);
    $statement->execute($params);
}
?>