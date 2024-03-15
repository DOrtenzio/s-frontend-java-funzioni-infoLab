import java.util.Scanner;
public class ArchivioDiNomi{
    public static void main (String[]args){
        Scanner in = new Scanner (System.in);
        int conta=0,multipli,scelta;
        String [] parole=new String[100];
        do{
            System.out.println ("Scegli una tra le opzioni proposte:");
            System.out.println ("1 - Aggiunta di un nome;");
            System.out.println ("2 - Cancellazione del singolo nome;");
            System.out.println ("3 - Ricerca sequenziale di un nome;");
            System.out.println ("4 - Visualizza nomi ripetuti con numero ripetizioni;");
            System.out.println ("5 - Modifica di un nome;");
            System.out.println ("6 - Visualizzazione di tutti i nomi presenti;");
            System.out.println ("7 - Ricerca del nome più lungo e più corto;");
            System.out.println ("8 - Cancellazione di tutte le occorrenze di un nome;");
            System.out.println ("0 - Uscita ");
            scelta = in.nextInt();
            in.nextLine();
            switch (scelta){
                case 1:
                    conta++;
                    System.out.println("Inserire la parola da inserire:");
                    String p=in.nextLine();
                    parole=isAggiunta(parole,p,conta);
                    break;
                case 2:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else{
                        System.out.println("Inserire la stringa da cancellare");
                        String scancella=in.nextLine();
                        if (isRicerca(parole,scancella,conta)){
                            conta--;
                            parole=isCancellazioneSingola(parole,conta,scancella);
                        }
                        else
                            System.out.println("Non abbiamo ritrovato il termine "+scancella+" nella lista.");
                    }
                    break;
                case 3:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else{
                        System.out.println("Inserire la stringa da ricercare");
                        String sricerca=in.nextLine();
                        if (isRicerca(parole,sricerca,conta)){
                            System.out.println("Il termine "+sricerca+" è presente");
                        }
                        else
                            System.out.println("Non abbiamo ritrovato il termine "+sricerca+" nella lista.");
                    }
                    break;
                case 4:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else {
                        for (int i=0;i<conta;i++){
                            if (!isGiaPresente(parole,i)){
                                System.out.println("La stringa "+parole[i]+" è presente in quantità "+isRipetizioni(parole,i,conta));
                            }
                        }
                    }
                    break;
                case 5:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else{
                        System.out.println("Inserire la stringa da ricercare per modificare");
                        String sricerca=in.nextLine();
                        if (isRicerca(parole,sricerca,conta)){
                            System.out.println("Inserire la parola con cui modificare: "+sricerca);
                            String smodifica=in.nextLine();
                            parole=isModifica(parole,sricerca,smodifica,conta);
                        }
                        else
                            System.out.println("Non abbiamo ritrovato il termine "+sricerca+" nella lista.");
                    }
                    break;
                case 6:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else{
                        for (int i=0;i<conta;i++){
                            System.out.print(isStampa(parole,i)+" ");
                        }
                        System.out.println();
                    }
                    break;
                
                case 9:
                    System.out.println("Coming soon");
                    break;
                case 0:
                    System.out.println("Ciao");
                    break;
                default:
                    System.out.println("Inserire uno dei valori specificati");
            }
        }while (scelta!=0);
    }
    private static String [] isAggiunta (String [] parole, String p, int conta){
        parole[conta-1]=p;
        return parole;
    }
    private static String isStampa (String [] parole, int i){
        String s=parole[i];
        return s;
    }
    private static String [] isCancellazioneSingola (String [] parole, int conta, String scancella){
        int posizione=0;
        for (int i=0;i<conta+1;i++){ //+1 per complementare  alla decrementazione principalmente
            if (scancella.equals(parole[i])){
                posizione=i;
                break;
            }
        }
        for (int i=posizione;i<conta;i++){
          parole[i]=parole[i+1];
        }
        return parole;
    }
    private static String [] isCancellazioneMultipla (String [] parole, int conta, String scancella){
        for (int i=0;i<conta;i++){
            if (scancella.equals(parole[i])){
                for (int p=i;p<conta;p++){
                    parole[p]=parole[p+1];
                }
            }
        }
        return parole;
    }
    private static int isContaCancellazioneMultipla (String [] parole, int conta, String scancella){
        int contacancellate=0;
        for (int i=0;i<conta;i++){
            if (scancella.equals(parole[i])){
                contacancellate++;
            }
        }
        return contacancellate;
    }
    private static boolean isRicerca (String [] parole, String ricerca, int conta){
        boolean presente=false;
        for (int i=0;i<conta;i++){
            if (ricerca.equals(parole[i])){
                presente=true;
                break;
            }
        }
        return presente;
    }
    private static boolean isGiaPresente (String [] parole, int i){
        boolean presente=false;
        for (int p=i-1;p>=0;p--){
            if (parole[i].equals(parole[p])){
                presente=true;
                break;
            }
        }
        return presente;
    }
    private static int isRipetizioni (String [] parole, int i, int conta){
        int ripetizioni=1;
        for (int p=i+1;p<conta;p++){
            if (parole[i].equals(parole[p])){
                ripetizioni++;
            }
        }
        return ripetizioni;
    }
    private static String [] isModifica (String [] parole, String ricerca,String modifica, int conta){
        for (int i=0;i<conta;i++){
            if (ricerca.equals(parole[i])){
                parole[i]=modifica;
                break;
            }
        }
        return parole;
    }
    private static String isMaximus (String [] parole, int conta){
        String max=parole[0];
        for (int i=0;i<conta;i++){
            if (max.length()<parole[i].length()){
                max=parole[i];
            }
        }
        return max;
    }
    private static String isMinimus (String [] parole, int conta){
        String min=parole[0];
        for (int i=0;i<conta;i++){
            if (min.length()>parole[i].length()){
                min=parole[i];
            }
        }
        return min;
    }
}
