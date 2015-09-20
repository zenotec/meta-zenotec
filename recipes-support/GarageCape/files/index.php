<html>
 <head>
  <title>ZenHome Garage Cape</title>
 </head>
 <body onload="init_doc()">
 <p>ZenHome Garage Cape</p>

 <script type="text/javascript">
 function init_doc(){
 <?php

   if ( isset ( $_GET['openButton'] ) ) {
     shell_exec( 'open.sh' );
   }
   else {
     if ( isset ( $_GET['closeButton'] ) ) {
       shell_exec( 'close.sh' );
     }
   }

   $output = array();
   $status = -1;
   exec( 'is_open.sh', $output, $status );
   if ( $status == 0 ) {
     echo "document.getElementById('openButton').disabled=true;\n";
     echo "document.getElementById('closeButton').disabled=false;\n";
   }

   $output = array();
   $status = -1;
   exec( 'is_closed.sh', $output, $status );
   if ( $status == 0 ) {
     echo "document.getElementById('openButton').disabled=false;\n";
     echo "document.getElementById('closeButton').disabled=true;\n";
   }

  ?>
  }
  </script>
 
  <form action="index.php" method="GET">
    <input type="submit" value="Open" id="openButton" name="openButton">
    <input type="submit" value="Close" id="closeButton" name="closeButton">
  </form>

 </body>
</html>

