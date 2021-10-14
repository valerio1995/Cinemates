<?php
require_once('CommentDAOMySQL.php');
$commentDAOMySQL = new CommentDAOMySQL();
$response = $commentDAOMySQL->saveComment($_POST['idList'],$_POST['idComment'],$_POST['writer'],$_POST['text'], $_POST['numberLikes'],$_POST['numberNoLikes']);
?>