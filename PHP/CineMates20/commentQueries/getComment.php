<?php
require_once('CommentDAOMySQL.php');
$commentDAOMySQL = new CommentDAOMySQL();
$response = $commentDAOMySQL->getComment($_POST['idList'],$_POST['idComment']);
print json_encode($response);
?>