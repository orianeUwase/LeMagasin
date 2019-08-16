<?php
    $url="mysql:host=localhost;dbname=a_retrofit";
    $dbuser="root";
    $dbpw="";
    $utilUser=$_POST['user'];
    $utilPw=$_POST['pw'];
    try {
        $bdcon=new PDO($url,$dbuser,$dbpw);
        $bdcon->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
        $cmd=$bdcon->prepare("select nom,prenom from student where user=? and password=? ");
        $data=array($utilUser,$utilPw);
        $cmd->execute($data);
        $user = $cmd->fetch(PDO::FETCH_ASSOC);
        $out="";
        
        if($user){
            $status="success";
            $name=$user->nom;
            $out=json_encode(array("response"->$status,"username"->$name));
        }
        else{
            $status="failure";
            $out=json_encode(array("response"->$status));
        }
    
    } 
    catch (Exception $ex) {
        $out=$ex->getMessage();
    }
    echo $out;
?>