<?php

class Persona {

	//attributi
	private $nome;
	private $cognome;
	private $sesso;
	private $nascita;
	private $residenza;
	private $CF;

	//metodi
	public function __construct($n,$c,$s, Data $nasc, Comune $r) {
		$this->nome = $n;
		$this->cognome = $c;
		$this->sesso = $s;
		$this->nascita = $nasc;
		$this->residenza = $r;
		$this->CF = "da calcolare";
	}

	public function getNome() {
		return $this->nome;
	}
	public function getCognome() {
		return $this->cognome;
	}
	public function getSesso() {
		return $this->sesso;
	}
	public function getData() {
		return $this->nascita;
	}
	public function getComune() {
		return $this->residenza;
	}
	public function getCF() {
		return $this->CF;
	}
	public function setCF($codfis) {
		$this->CF = $codfis;
	}
}

class Comune {

	//attributi
	private $nome;
	private $provincia;
	private $codice;
	//public $dati; //????

	public function __construct($n,$p,$c) {
		$this->nome = $n;
		$this->provincia = $p;
		$this->codice = $c;
	}
	//metodi
	public function setNome($n) {
		$this->nome = $n;
	}
	public function setProv($p) {
		$this->provincia = $p;
	}
	public function setCodice($c) {
		$this->codice = $c;
	}
	public function getNome() {
		return $this->nome;
	}
	public function getProv() {
		return $this->provincia;
	}
	public function getCodice() {
		return $this->codice;
	}
}

class CodFiscale {

	//metodi
	private function calcCogn($c) {
		$x = 0;
		$lettere = str_split($c);
		$vocals = array("a","e","i","o","u","A","E","I","O","U");
		for($i = 0,$j = 0; $i<strlen($c) && $j<3;$i++) {
			if(!in_array($lettere[$i],$vocals)){
				$cons[] = $lettere[$i];
				$j++;
			}
			else{
				$aeiou[] = $lettere[$i];
			}
			while($j<3 && $i == strlen($c) - 1){
				$cons[] = $aeiou[$x];
				$x++;
				$j++;
			}
		}
		$ccc = implode("",$cons);
		return $ccc;
	}
	private function calcNome($n) {
		$x = 0;
		$lettere = str_split($n);//converto la stringa $n in un array
		$vocals = array("a","e","i","o","u","A","E","I","O","U");//costruisco un array di vocali
		for($i = 0 , $j = 0;  $i<strlen($n) && $j<4; $i++) {
			if(!in_array($lettere[$i],$vocals) && $j!=1){//$j deve essere diverso da 1 perchè del nome devo prendere la 1' la 3' e la 4' consonante
				$cons[] = $lettere[$i];
				$j++;
			}
			else if(!in_array($lettere[$i],$vocals)){//ulteriore controllo che mi permette di saltare la 2' consonante e memorizzarla
				$consesclusa[] = $lettere[$i];
				$j++;
			}
			else{
				$aeiou[] = $lettere[$i];
			}
			while($j<4 && $i == strlen($n) - 1){
				if(!empty($consesclusa)){
				$cons[] = $consesclusa[0];
				$j++;
				unset($consesclusa[0]);
				}
				else{
					$cons[] = $aeiou[$x];
					$x++;
					$j++;
				}
				if(strlen($n)==2){
					$cons[] = "x";
					$j = $j+2;
				}
				if(strlen($n)==1){
					$cons[] = "xx";
					$j = $j+3;
				}

			}
		}
		$nnn = implode("",$cons);
		return $nnn;
	}
	private function calcAnno(Data $a) {
		$trimmed = substr($a->getAnno(),2);
		return $trimmed;
	}
	private function calcMese(Data $d) {
		if($d->getMese() == 1)
			return "A";
		if($d->getMese() == 2)
			return "B";
		if($d->getMese() == 3)
			return "C";
		if($d->getMese() == 4)
			return "D";
		if($d->getMese() == 5)
			return "E";
		if($d->getMese() == 6)
			return "H";
		if($d->getMese() == 7)
			return "L";
		if($d->getMese() == 8)
			return "M";
		if($d->getMese() == 9)
			return "P";
		if($d->getMese() == 10)
			return "R";
		if($d->getMese() == 11)
			return "S";
		if($d->getMese() == 12)
			return "T";
	}
	private function calcGiorno(Data $d, $sex) {
		if($sex == "F")
			return $d->getGiorno() + 40;
		else
			return $d->getGiorno();
	}
	private function calcComune(Comune $c) {
		return $c->getCodice();
	}
	private function calcUltimo(array $check) {
		return "X";
	}
	public function calcoloCF(Persona $pers) {
		if(strlen($pers->getCognome())==3){
			$lettere = str_split($pers->getCognome());
			$cf[] = $lettere[0];
			$cf[] = $lettere[1];
			$cf[] = $lettere[2];
			$cf[] = $this->calcNome($pers->getNome());
			$cf[] = $this->calcAnno($pers->getData());
			$cf[] = $this->calcMese($pers->getData());
			$cf[] = $this->calcGiorno($pers->getData(),$pers->getSesso());
			$cf[] = $this->calcComune($pers->getComune());
			$cf[] = $this->calcUltimo($cf);
			$CFfinale = implode("",$cf);
			return $CFfinale;
		}
		if(strlen($pers->getCognome())==3){
			$lettere = str_split($pers->getCognome());
			$cf[] = $lettere[0];
			$cf[] = $lettere[1];
			$cf[] = $lettere[2];
			$cf[] = $this->calcNome($pers->getNome());
			$cf[] = $this->calcAnno($pers->getData());
			$cf[] = $this->calcMese($pers->getData());
			$cf[] = $this->calcGiorno($pers->getData(),$pers->getSesso());
			$cf[] = $this->calcComune($pers->getComune());
			$cf[] = $this->calcUltimo($cf);
			$CFfinale = implode("",$cf);
			return $CFfinale;
		}
		if(strlen($pers->getCognome())==2){
			$lettere = str_split($pers->getCognome());
			$cf[] = $lettere[0];
			$cf[] = $lettere[1];
			$cf[] = "X";
			$cf[] = $this->calcNome($pers->getNome());
			$cf[] = $this->calcAnno($pers->getData());
			$cf[] = $this->calcMese($pers->getData());
			$cf[] = $this->calcGiorno($pers->getData(),$pers->getSesso());
			$cf[] = $this->calcComune($pers->getComune());
			$cf[] = $this->calcUltimo($cf);
			$CFfinale = implode("",$cf);
			return $CFfinale;
		}
		if(strlen($pers->getCognome())==1){
			$lettere = str_split($pers->getCognome());
			$cf[] = $lettere[0];
			$cf[] = "XX";
			$cf[] = $this->calcNome($pers->getNome());
			$cf[] = $this->calcAnno($pers->getData());
			$cf[] = $this->calcMese($pers->getData());
			$cf[] = $this->calcGiorno($pers->getData(),$pers->getSesso());
			$cf[] = $this->calcComune($pers->getComune());
			$cf[] = $this->calcUltimo($cf);
			$CFfinale = implode("",$cf);
			return $CFfinale;
		}
		else{
		$cf[] = $this->calcCogn($pers->getCognome());
		$cf[] = $this->calcNome($pers->getNome());
		$cf[] = $this->calcAnno($pers->getData());
		$cf[] = $this->calcMese($pers->getData());
		$cf[] = $this->calcGiorno($pers->getData(),$pers->getSesso());
		$cf[] = $this->calcComune($pers->getComune());
		$cf[] = $this->calcUltimo($cf);
		$CFfinale = implode("",$cf);
		return $CFfinale;
	}
	}
}

class In_Out {

	//metodi
	public function __construct() {;}
	public function getInfo($filename) {
		$contents = file_get_contents($filename);
		return $contents;
	}
	public function printInfo($s, Persona $p) {
		echo "Il codice fiscale associato a ".$p->getNome()." ".$p->getCognome(). " è: ".$s."\n";
	}
}

class Data {

	//attributi
	private $giorno;
	private $mese;
	private $anno;

	//metodi
	public function __construct($g,$m,$a) {
		$this->giorno = $g;
		$this->mese = $m;
		$this->anno = $a;
	}
	public function getGiorno() {
		return $this->giorno;
	}
	public function getMese() {
		return $this->mese;
	}
	public function getAnno() {
		return $this->anno;
	}
}

//main
$io = new In_Out();
$fname = "input.txt";
$info = $io->getInfo($fname);
list($cogn,$nom,$sex,$date,$com,$prov) = explode(";", $info);

//procedimento per associare il giusto codice data provincia e città.
$handle = fopen ("codici_comuni_italiani.txt", "r");//apertura del file a cui viene associato il puntatore handle

while ( !feof( $handle )) {

		$buffer = fgets($handle);   // legge una riga intera da file
		$buffer = rtrim($buffer);   // rimuove carattere di return a fine riga

		list($codice, $comune, $provincia) = explode (";", $buffer);  // divide la stringa in tre rispetto al separatore ; usato nel file

		if ( $provincia == $prov && $comune == $com) {
			 //$i++;
			 $cod=$codice;
		}
}
fclose ($handle);  // chiusura del file puntato da handle

if(empty($cod)){
	print "ERRORE : CONTROLLARE IL FILE DI INPUT \n";
}
else{
	list($gio,$mes,$an) = explode("/", $date);
	$nasc = new Data($gio,$mes,$an);
	$loc = new Comune($com,$prov,$cod);
	$pers = new Persona($nom,$cogn,$sex,$nasc,$loc);
	$calcolo = new CodFiscale();
	$cod_fiscale = $calcolo->calcoloCF($pers);
	$io->printInfo($cod_fiscale, $pers);
}
?>
