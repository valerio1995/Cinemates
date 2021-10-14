<?php
require_once('CommentDAOMySQL.php');
$commentDAOMySQL = new CommentDAOMySQL();
$response = $commentDAOMySQL->getListComments($_POST['idList']);
print json_encode($response);
?>