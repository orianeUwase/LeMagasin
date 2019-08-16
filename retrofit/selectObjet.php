<?php
 
/*
 * Following code will get single piece details
 * A piece is identified by piece id (pid)
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// check for post data
if (isset($_GET["pid"])) {
    $pid = $_GET['pid'];
 
    // get a piece from piece table
    $result = mysql_query("SELECT *FROM piece WHERE idPiece = $pid");
 
    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {
 
            $result = mysql_fetch_array($result);
 
            $piece = array();
            $piece["pid"] = $result["idPiece"];
            $piece["title"] = $result["title"];
            $piece["description"] = $result["description"];
            $piece["location"] = $result["location"];
            
            // success
            $response["success"] = 1;
 
            // user node
            $response["piece"] = array();
 
            array_push($response["piece"], $piece);
 
            // echoing JSON response
            echo json_encode($response);
        } else {
            // no piece found
            $response["success"] = 0;
            $response["message"] = "No piece found";
 
            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no piece found
        $response["success"] = 0;
        $response["message"] = "No piece found";
 
        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";
 
    // echoing JSON response
    echo json_encode($response);
}
?>