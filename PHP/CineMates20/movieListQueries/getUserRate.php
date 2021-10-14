<?php
require_once('MovieListDAOMySQL.php');
$movieListDAOMySQL = new MovieListDAOMySQL();
$response = $movieListDAOMySQL->getUserRate($_POST['username'],$_POST['idList']);
print json_encode($response);
?>