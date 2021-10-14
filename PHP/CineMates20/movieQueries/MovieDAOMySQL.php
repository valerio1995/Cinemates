<?php
require_once('DbConnection.php');

class MovieDAOMySQL extends DbConnection{
        public function getAllMovies($idListPOST){
                $conn = $this->OpenCon();
                $idList = $conn->real_escape_string($idListPOST);
                $sth = $conn->query("SELECT * FROM Movies WHERE idList = '$idList'");
                $rows = array();
                while($r = $sth->fetch_assoc()){
                    $rows[] = $r;
                }
                $this->CloseCon($conn);
                return $rows;
        } //end getAllMovies

        public function deleteMovie($idListPOST,$titlePOST,$directorPOST,$releaseDatePOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $title = $conn->real_escape_string($titlePOST);
            $director = $conn->real_escape_string($directorPOST);	
            $releaseDate = $conn->real_escape_string($releaseDatePOST);		
            $sth = $conn->query("DELETE FROM Movies WHERE idList = $idList AND title = '$title' AND director = '$director' AND releaseDate = '$releaseDate';");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
        } //end deleteMovie

        public function saveMovie($idListPOST,$titlePOST,$directorPOST,$releaseDatePOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $title = $conn->real_escape_string($titlePOST);
            $director = $conn->real_escape_string($directorPOST);	
            $releaseDate = date('Y-m-d', strtotime($releaseDatePOST));	
            $sth = $conn->query("INSERT INTO Movies VALUES($idList,'$title','$director','$releaseDate');");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
        } //end saveMovie
} //end class
?>