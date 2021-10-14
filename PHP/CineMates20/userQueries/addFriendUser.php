<?php
require_once('UserDAOMySQL.php');
$userDAOMySQL = new UserDAOMySQL();
$response = $userDAOMySQL->addFriendUser($_POST['username'],$_POST['friendUsername']);
print json_encode($response);
?>