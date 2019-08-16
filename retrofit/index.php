<?php
class User {
	public $Nom;
	public $Prenom;
	public $Age;
 
	function __construct( $nom,$prenom, $age ) {
		$this->Nom = $nom;
		$this->Prenom = $prenom;
		$this->Age = $age;
    }
}
?>
<?php
   $url="mysql:host=localhost;dbname=a_retrofit";
    $dbuser="root";
    $dbpw="";
    try {
        $bdcon=new PDO($url,$dbuser,$dbpw);
        $bdcon->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
        $cmd=$bdcon->prepare("select * from student");
        $data=array();
        $cmd->execute();
        $out="";
        $line;
        while ($line =$cmd->fetchObject()) {
            $st = new User($line->nom,$line->prenom,$line->age);
            // $out.="{Nom:"."$line->nom".", Prenom:"."$line->prenom".", Age:"." $line->age"."},";
            $out=$st;
        }
        
    //new stdClass()
    } 
    catch (Exception $ex) {
        $out=$ex->getMessage();
    }
    echo json_encode($out);
?>