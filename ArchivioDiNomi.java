import java.util.Scanner;
public class ArchivioDiNomi{
  public static void main (String[]args){
    Scanner in = new Scanner (System.in);
    do{
	System.out.println ("Scegli una tra le opzioni proposte:");
	System.out.println ("1 - Aggiunta di un nome;");
	System.out.println ("2 - Cancellazione del singolo nome;");
	System.out.println ("3 - Ricerca sequenziale di un nome;");
	System.out.println ("4 - Visualizza nomi ripetuti con numero ripetizioni;");
	System.out.println ("5 - Modifica di un nome;");
	System.out.println ("6 - Visualizzazione di tutti i nomi presenti;");
	System.out.println ("7 - Ricerca del nome piC9 lungo e piC9 corto;");
	System.out.println ("8 - Cancellazione di tutte le occorrenze di un nome;");
	System.out.println ("0 - Uscita ");
	int scelta = in.nextInt ();
	switch (scelta){
	        case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                        System.out.println("Ciao");
                        break;
                default:
                        System.out.println("Inserire uno dei valori specificati");
	}
      }while (scelta!=0);
    }
    }
