<?php
require_once('UserDAOMySQL.php');
$userDAOMySQL = new UserDAOMySQL();
$response = $userDAOMySQL->getFriends($_POST['username']);
print json_encode($response);
?>
