<?php
require_once('MovieListDAOMySQL.php');
$movieListDAOMySQL = new MovieListDAOMySQL();
$response = $movieListDAOMySQL->updateUserRate($_POST['username'],$_POST['idList'],$_POST['rate']);
print json_encode($response);
?>