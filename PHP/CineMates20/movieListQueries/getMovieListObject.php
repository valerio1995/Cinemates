<?php
require_once('MovieListDAOMySQL.php');
$movieListDAOMySQL = new MovieListDAOMySQL();
$response = $movieListDAOMySQL->getMovieListObject($_POST['idList']);
print json_encode($response);
?>