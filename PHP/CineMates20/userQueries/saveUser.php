<?php
require_once('UserDAOMySQL.php');
$userDAOMySQL = new UserDAOMySQL();
$response = $userDAOMySQL->saveUser($_POST['email'],$_POST['password'],$_POST['username'],$_POST['name'],$_POST['surname'],$_POST['gender'],$_POST['birth'],$_POST['country'],$_POST['listVisibility'],$_POST['receptionStatus'],$_POST['commentsStatus']);
print json_encode($response);
?>