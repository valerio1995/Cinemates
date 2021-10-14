<?php
require_once('MovieListDAOMySQL.php');
$movieListDAOMySQL = new MovieListDAOMySQL();
$response = $movieListDAOMySQL->getUserQuickOpinionToMovieList($_POST['username'],$_POST['idList']);
print json_encode($response);
?>