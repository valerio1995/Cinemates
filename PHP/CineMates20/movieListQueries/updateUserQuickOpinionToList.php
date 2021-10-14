<?php
require_once('MovieListDAOMySQL.php');
$movieListDAOMySQL = new MovieListDAOMySQL();
$response = $movieListDAOMySQL->updateUserQuickOpinionToList($_POST['username'],$_POST['idList'],$_POST['opinion']);
print json_encode($response);
?>