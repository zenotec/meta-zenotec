<html>
 <head>
  <title>ZenHome Thermo Cape</title>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" >
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style type="text/css">
  body {
    /*background: linear-gradient(90deg, white, gray);*/
    background-color: #eee;
  }

  body, h1, p {
    font-family: "Helvetica Neue", "Segoe UI", Segoe, Helvetica, Arial, "Lucida Grande", sans-serif;
    font-weight: normal;
    margin: 0;
    padding: 0;
    text-align: center;
  }

  .container {
    margin-left:  auto;
    margin-right:  auto;
    margin-top: 177px;
    max-width: 1170px;
    padding-right: 15px;
    padding-left: 15px;
  }

  .row:before, .row:after {
    display: table;
    content: " ";
  }

  h1 {
    font-size: 48px;
    font-weight: 300;
    margin: 0 0 20px 0;
  }

  .lead {
    font-size: 21px;
    font-weight: 200;
    margin-bottom: 20px;
  }

  p {
    margin: 0 0 10px;
  }

  a {
    color: #3282e6;
    text-decoration: none;
  }
  </style>

 </head>
 <body onload="init_doc()">
 <h1>ZenHome Thermo Cape</h1>

 <script type="text/javascript">
 function init_doc(){
 <?php

   if ( isset ( $_GET['openButton'] ) ) {
     shell_exec( 'open_door.sh' );
   }
   else {
     if ( isset ( $_GET['closeButton'] ) ) {
       shell_exec( 'close_door.sh' );
     }
   }

   $output = array();
   $status = -1;
   exec( 'is_door_open.sh', $output, $status );
   if ( $status == 0 ) {
     echo "document.getElementById('openButton').disabled=true;\n";
     echo "document.getElementById('closeButton').disabled=false;\n";
   }

   $output = array();
   $status = -1;
   exec( 'is_door_closed.sh', $output, $status );
   if ( $status == 0 ) {
     echo "document.getElementById('openButton').disabled=false;\n";
     echo "document.getElementById('closeButton').disabled=true;\n";
   }

  ?>
  }
  </script>
 
  <?php

   $output = array();
   $status = -1;
   exec( 'read_temp.sh -f', $output, $status );
   $temp_f = $output[0];

   $output = array();
   $status = -1;
   exec( 'read_temp.sh', $output, $status );
   $temp_c = $output[0];

   echo "<p>Temperature: $temp_f F ($temp_c C)</p>";

   $output = array();
   $status = -1;
   exec( 'read_lux.sh', $output, $status );
   $lux = $output[0];

   echo "<p>Illuminance: $lux LUX</p>"

   ?>

  <form action="index.php" method="GET">
    <input type="submit" value="Open" id="openButton" name="openButton">
    <input type="submit" value="Close" id="closeButton" name="closeButton">
  </form>

 </body>
</html>

