<?php
require_once('UserDAOMySQL.php');
$userDAOMySQL = new UserDAOMySQL();
$response = $userDAOMySQL->getAllUsers();
print json_encode($response);
?>
