<?php
require_once('CommentDAOMySQL.php');
$commentDAOMySQL = new CommentDAOMySQL();
$response = $commentDAOMySQL->updateUserQuickOpinionToComment($_POST['username'],$_POST['idList'],$_POST['idComment'], $_POST['opinion']);
print json_encode($response);
?>