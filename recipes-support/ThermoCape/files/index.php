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

   if ( isset ( $_GET['heat1Button'] ) ) {
     shell_exec( 'heat1_on.sh' );
   }
   if ( isset ( $_GET['heat2Button'] ) ) {
     shell_exec( 'heat2_on.sh' );
   }
   if ( isset ( $_GET['cool1Button'] ) ) {
     shell_exec( 'cool1_on.sh' );
   }
   if ( isset ( $_GET['cool2Button'] ) ) {
     shell_exec( 'cool2_on.sh' );
   }
   if ( isset ( $_GET['humButton'] ) ) {
     shell_exec( 'hum_on.sh' );
   }
   if ( isset ( $_GET['offButton'] ) ) {
     shell_exec( 'all_off.sh' );
   }

   if ( isset ( $_POST['HOSTNAME'] ) && isset ( $_POST['SSID'] ) ) {
     $cmd = "connect_to_wifi.sh ";
     $cmd .= $_POST['HOSTNAME'] . " ";
     $cmd .= $_POST['SSID'] . " ";
     $cmd .= $_POST['passPhrase'];
     shell_exec( $cmd );
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
    <input type="submit" value="Heat-1" id="heat1Button" name="heat1Button">
    <input type="submit" value="Heat-2" id="heat2Button" name="heat2Button">
    <input type="submit" value="Cool-1" id="cool1Button" name="cool1Button">
    <input type="submit" value="Cool-2" id="cool2Button" name="cool2Button">
    <input type="submit" value="Humidifier" id="humButton" name="humButton">
    <input type="submit" value="Off" id="offButton" name="offButton">
  </form>

  <p> Connect to Wifi Access Point </p>
  <form action="index.php" method="POST">
    Hostname:        <input type="text" value="" id="hostname" name="HOSTNAME"><br>
    Wifi SSID:       <input type="text" value="" id="wifiSsid" name="SSID"><br>
    Wifi Passphrase: <input type="password" value="" id="wifiPass" name="passPhrase"><br>
    <input type="submit" value="Connect">
  </form>

 </body>
</html>

