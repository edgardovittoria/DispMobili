<?php
  //$input=readline();
  $filename="\users\Edgardo Vittoria\desktop\php\input.txt";
  $handle=fopen($filename,"r");
  $input=fread($handle, filesize($filename));
  fclose($handle);
  print($input."\n\n");
  $boh=str_word_count($input,1);
  $parole=array_count_values($boh);
  ksort($parole);
  arsort($parole);
  print_r($parole);
 ?>
