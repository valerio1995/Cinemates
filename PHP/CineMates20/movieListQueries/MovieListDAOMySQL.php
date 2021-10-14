<?php
require_once('DbConnection.php');

class MovieListDAOMySQL extends DbConnection{
        public function getFavouriteList($usernamePOST){
                $conn = $this->OpenCon();
                $username = $conn->real_escape_string($usernamePOST);
                $sth = $conn->query("SELECT * FROM MovieLists WHERE usernameOwner = '$username' AND typeList = 'Preferiti'");
                $rows = array();
                while($r = $sth->fetch_assoc()){
                    $rows[] = $r;
                }
                $this->CloseCon($conn);
                return $rows;
        } //end getFavouriteList

        public function getToSeeList($usernamePOST){
            $conn = $this->OpenCon();
            $username = $conn->real_escape_string($usernamePOST);
            $sth = $conn->query("SELECT * FROM MovieLists WHERE usernameOwner = '$username' AND typeList = 'Da vedere'");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
         } //end getToSeeList

         public function getMovieListObject($idListPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $sth = $conn->query("SELECT * FROM MovieLists WHERE idList = $idList");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
         } //end getMovieListObject

         public function updateMovieListObject($idListPOST,$numberLikesPOST,$numberNoLikesPOST,$totalRatingPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $numberLikes = $conn->real_escape_string($numberLikesPOST);
            $numberLikes = intval($numberLikes);
            $numberNoLikes = $conn->real_escape_string($numberNoLikesPOST);
            $numberNoLikes = intval($numberNoLikes);
            $totalRating = $conn->real_escape_string($totalRatingPOST);
            $totalRating = intval($totalRating);
            $sth = $conn->query("UPDATE MovieLists SET numberLikes = $numberLikes, numberNoLikes = $numberNoLikes, totalRating = $totalRating WHERE idList = $idList;");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
         } //end updateMovieListObject

         public function addQuickOpinionToMovieList($usernamePOST,$idListPOST,$opinionPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $username = $conn->real_escape_string($usernamePOST);
            $opinion = $conn->real_escape_string($opinionPOST);	
            $sth = $conn->query("INSERT INTO QuickOpinionsToLists VALUES('$username',$idList,$opinion);");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
         } //end addQuickOpinionToMovieList

         public function getAllRates($idListPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $sth = $conn->query("SELECT rate FROM Rates WHERE idList = $idList");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
         } //end getAllRates

         public function addRateToMovieList($usernamePOST,$idListPOST,$ratePOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $username = $conn->real_escape_string($usernamePOST);
            $rate = $conn->real_escape_string($ratePOST);	
            $sth = $conn->query("INSERT INTO Rates VALUES('$username',$idList,$rate);");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
         } //end addRateToMovieList

         public function getUserRate($usernamePOST,$idListPOST){
            $conn = $this->OpenCon();
            $username = $conn->real_escape_string($usernamePOST);
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $sth = $conn->query("SELECT rate FROM Rates WHERE username = '$username' AND idList = $idList");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
         } //end getUserRate

         public function updateUserQuickOpinionToList($usernamePOST,$idListPOST,$opinionPOST){
            $conn = $this->OpenCon();
            $username = $conn->real_escape_string($usernamePOST);
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $opinion = $conn->real_escape_string($opinionPOST);
            $sth = $conn->query("UPDATE QuickOpinionsToLists SET opinion = $opinion WHERE username = '$username' AND idList = $idList;");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
         } //end updateUserQuickOpinionToList

         public function updateUserRate($usernamePOST,$idListPOST,$ratePOST){
            $conn = $this->OpenCon();
            $username = $conn->real_escape_string($usernamePOST);
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $rate = $conn->real_escape_string($ratePOST);
            $rate = intval($rate);
            $sth = $conn->query("UPDATE Rates SET rate = $rate WHERE username = '$username' AND idList = $idList;");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
         } //end updateUserRate

         public function getUserQuickOpinionToMovieList($usernamePOST,$idListPOST){
            $conn = $this->OpenCon();
            $username = $conn->real_escape_string($usernamePOST);
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $sth = $conn->query("SELECT opinion FROM QuickOpinionsToLists WHERE username = '$username' AND idList = $idList");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
         } //end getUserQuickOpinionToMovieList

} //end class
?>