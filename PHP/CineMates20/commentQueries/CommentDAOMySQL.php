<?php
require_once('DbConnection.php');

class CommentDAOMySQL extends DbConnection{
        public function saveComment($idListPOST,$idCommentPOST,$writerPOST,$textPOST,$numberLikesPOST,$numberNoLikesPOST){
                $conn = $this->OpenCon();
                $idList = $conn->real_escape_string($idListPOST);
                $idList = intval($idList);
                $idComment = $conn->real_escape_string($idCommentPOST);
                $idComment = intval($idComment);
                $writer = $conn->real_escape_string($writerPOST);
                $text = $conn->real_escape_string($textPOST);
                $numberLikes = $conn->real_escape_string($numberLikesPOST);
                $numberLikes = intval($numberLikes);
                $numberNoLikes = $conn->real_escape_string($numberNoLikesPOST);
                $numberNoLikes = intval($numberNoLikes);
                $sth = $conn->query("INSERT INTO Comments VALUES($idList,$idComment,'$writer','$text',$numberLikes,$numberNoLikes);");
                if($sth){
                    $arr = array('response' => 0);
                }else{
                    $arr = array('response' => 1);
                }
                $this->CloseCon($conn);
                return $arr;
        } //end saveComment

        public function addQuickOpinionToComment($usernamePOST,$idListPOST,$idCommentPOST,$opinionPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $idComment = $conn->real_escape_string($idCommentPOST);
            $idComment = intval($idComment);
            $username = $conn->real_escape_string($usernamePOST);
            $opinion = $conn->real_escape_string($opinionPOST);
            $sth = $conn->query("INSERT INTO QuickOpinionsToComments VALUES('$username',$idList,$idComment,$opinion);");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
        } //end addQuickOpinionToComment

        public function getListComments($idListPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $sth = $conn->query("SELECT * FROM Comments WHERE idList = $idList");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
        } //end getListComments

        public function getUserQuickOpinionToComment($usernamePOST,$idListPOST,$idCommentPOST){
            $conn = $this->OpenCon();
            $username = $conn->real_escape_string($usernamePOST);
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $idComment = $conn->real_escape_string($idCommentPOST);
            $idComment = intval($idComment);
            $sth = $conn->query("SELECT opinion FROM QuickOpinionsToComments WHERE username = '$username' AND idList = $idList AND idComment = $idComment;");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
         } //end getUserQuickOpinionToComment

         public function updateUserQuickOpinionToComment($usernamePOST,$idListPOST,$idCommentPOST,$opinionPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $idComment = $conn->real_escape_string($idCommentPOST);
            $idComment = intval($idComment);
            $username = $conn->real_escape_string($usernamePOST);
            $opinion = $conn->real_escape_string($opinionPOST);
            $sth = $conn->query("UPDATE QuickOpinionsToComments SET opinion = $opinion WHERE username = '$username' AND idList = $idList AND idComment = $idComment;");
            if($sth){
                $arr = array('response' => 0);
            }else{
                $arr = array('response' => 1);
            }
            $this->CloseCon($conn);
            return $arr;
        } //end updateUserQuickOpinionToComment

        public function getComment($idListPOST, $idCommentPOST){
            $conn = $this->OpenCon();
            $idList = $conn->real_escape_string($idListPOST);
            $idList = intval($idList);
            $idComment = $conn->real_escape_string($idCommentPOST);
            $idComment = intval($idComment);
            $sth = $conn->query("SELECT * FROM Comments WHERE idList = $idList AND idComment = $idComment;");
            $rows = array();
            while($r = $sth->fetch_assoc()){
                $rows[] = $r;
            }
            $this->CloseCon($conn);
            return $rows;
        } //end getComment
        
} //end class
?>