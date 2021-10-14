<?php
require_once('UserDAOMySQL.php');
$userDAOMySQL = new UserDAOMySQL();
$response = $userDAOMySQL->getUserByEmail($_POST['email']);
print json_encode($response);
?>