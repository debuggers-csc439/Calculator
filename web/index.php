<?php
include('config.php');
$loggedin = false;
if($_SERVER['REQUEST_METHOD'] == "POST"){
	if($_POST['submit'] == 'signup'){
		$name = $_POST['name'];
    	$email = $_POST['email'];
		$temp_password = $_POST['password'];
		$password = password_hash($temp_password, PASSWORD_BCRYPT);
    	$params = array(
        	'name' => $name,
        	'email' => $email,
        	'password' => $password
    	);
   		$sql = file_get_contents('signup.sql');
    	$statement = $database->prepare($sql);
		$statement->execute($params);
		
	}
	if($_POST['submit'] == 'login'){
		$email = $_POST['email'];
		$password = $_POST['password'];
		$params = array(
			'email' => $email
		);
		$loggedin = false;
		$sql = file_get_contents('login.sql');
		$statement = $database->prepare($sql);
		$statement->execute($params);
		$users = $statement->fetchAll(PDO::FETCH_ASSOC);
		if(!empty($users)){
			$flag = 0;
			foreach($users as $user){
				if(password_verify($password, $user['password'])){
					$loggedin = true;
					$person = $user;
					$flag = 1;
					$_SESSION['customerID'] =  $person['customerid'];
				}
				if ($flag == 0){
					$denial = "Incorrect Password!";
				}
				
			}
		}
		else{
			$denial = "Incorrect email address, try using a different email address.";
		
		}
	}
}
?>
<!DOCTYPE HTML>
<!--
	Typify by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>BMI Calculator</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<link rel="stylesheet" href="assets/css/main.css" />
		<style>
			.descr{
				color: #ff9933;
			}
			.calc-color{
				color: #ff9933;		
			}
		</style>
	</head>
	<body>
        <!-- Banner -->
            <section id="banner" style="color:black">
                <!--
                echo $_POST['name'];
                echo $_POST['email'];
                echo $_POST['password];
                select * from customers
                This showed everything within the customers table 
        -->		
				<?php if(isset($_SESSION['customerID'])): ?>
                <h2> Hello <?php echo $person['name']; ?>! here's your customized BMI calculator </h2>
				<h2>BMI Calculator</h2>
				<p><strong>BMI</strong> Calculator with added Sign up features to record your health status</p>
				<form action = "logout.php">
				<input name = "submit" type = "submit" value = "logout">
				</form>
		        <?php endif; ?>
				<!--<ul class="actions">
					<li><a href="#" class="button special">Get started</a></li>
				</ul> -->
				<?php if(!isset($_SESSION['customerID'])): ?>
				<h2>BMI Calculator</h2>
				<p><strong>BMI</strong> Calculator with added Sign up features to record your health status</p>
				<div style = "color: black; width : 40%; margin-left: 30%;">
				<form id = "loginform" method = "post" action = "index.php">
					<h3>Login</h3>
                	<Label> Email: </Label>
					<input type = "email" name = "email">
					<Label> Password: </Label>
					<input type = "password" name = "password"><br>
					<input name = "submit" type = "submit" value = "login">
				</form>
				<?php if($flag == 0): ?>
				<p style="color: red; font-size: 14px;"> <?php echo $denial; ?>  </p>
		        <?php endif; ?>
				</div>
		        <?php endif; ?>
			</section>
				
			


			

		<!-- One -->
			<section id="one" class="wrapper special">
				<div class="inner">
					<header class="major">
						<h2> <b> App Features </b> </h2>
					</header>
					<div class="features">
						<div class="feature">
							<h3 class = "descr">Sign up to get full benefits</h3>
							<p>You can sign up to record your personal information </p>
						</div>
						<div class="feature">
							
							<h3 class = "descr">Follow up with your body ratio</h3>
							<p>It always help to regularly check on your bodily statistics</p>
						</div>
						<div class="feature">
							
							<h3 class = "descr">Fitness trainers</h3>
							<p>It's in our best interest to connect you with fitness trainers that can further your level of self satisfacion </p>
						</div>
						<div class="feature">
							
							<h3 class = "descr">Diet Plans</h3>
							<p>We provide you with diet plans in accordance with your BMI ratio</p>
						</div>
						<div class="feature">
							
							<h3 class = "descr">History</h3>
							<p>Display your history of BMI for futrue reference</p>
						</div>
					</div>
				</div>
			</section>
			
			<div id = "calculate" style= "margin-left: 30%; margin-bottom: 40px; width: 40%; background-color:honeydew">
				<h3> <b>Enter your height and weight in feet and pound respectively </b>:<br>Example: weight = 150, height = 5.11</h3>
					<Label>Height</Label>
					<input type = "text" id="height">
					<Label>Weight</Label>
					<input type = "text" id="weight"><br>
				<input type = "button" onclick="myFunction();" value="Calculate!" style = "margin-top: 10px;">
			</div>
			

		<!-- Two -->
			<section id="two" class="wrapper style2 special">
					
				<div class="inner narrow">
					<header>
						<h2>Signup for free!</h2>
					</header>
					<form class="grid-form" method="post" action="index.php">
						<div class="form-control narrow">
							<label for="name">Full Name</label>
							<input name="name" id="name" type="text" required>
						</div>
						<div class="form-control narrow">
							<label for="email">Email</label>
							<input name="email" id="email" type="email" required>
						</div>
						<div class="form-control">
							<label for="password">Password</label>
							<input name="password" id="password" rows="4" type = "password" required>
						</div>
						<ul class="actions">
							<li><input name = "submit" value="signup" type="submit"></li>
						</ul>
					</form>
					<h2> If you already have an account <i><a href="#top">click here</a></i></h2>
				</div>
			</section>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
			<script type="text/javascript" src ="calc.js"></script>
	</body>
</html>