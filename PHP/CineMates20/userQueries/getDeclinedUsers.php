<?php
require_once('UserDAOMySQL.php');
$userDAOMySQL = new UserDAOMySQL();
$response = $userDAOMySQL->getDeclinedUsers($_POST['username']);
print json_encode($response);
?>