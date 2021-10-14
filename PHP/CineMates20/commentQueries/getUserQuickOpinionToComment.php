<?php
require_once('CommentDAOMySQL.php');
$commentDAOMySQL = new CommentDAOMySQL();
$response = $commentDAOMySQL->getUserQuickOpinionToComment($_POST['username'],$_POST['idList'],$_POST['idComment']);
print json_encode($response);
?>