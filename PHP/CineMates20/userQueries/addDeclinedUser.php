<?php
require_once('UserDAOMySQL.php');
$userDAOMySQL = new UserDAOMySQL();
$response = $userDAOMySQL->addDeclinedUser($_POST['username'],$_POST['declinedUsername']);
print json_encode($response);
?>