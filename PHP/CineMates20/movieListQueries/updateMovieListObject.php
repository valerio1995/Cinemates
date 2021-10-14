<?php
require_once('MovieListDAOMySQL.php');
$movieListDAOMySQL = new MovieListDAOMySQL();
$response = $movieListDAOMySQL->updateMovieListObject($_POST['idList'],$_POST['numberLikes'],$_POST['numberNoLikes'],$_POST['totalRating']);
print json_encode($response);
?>