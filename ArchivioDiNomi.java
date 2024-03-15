import java.util.Scanner;
public class ArchivioDiNomi{
    public static void main (String[]args){
        Scanner in = new Scanner (System.in);
        int conta=0,scelta,cepostaperte;
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
                    if (conta==100){
                        System.out.println("\033[31m"+"Impossibile inserire altre parole: 100 / 100  occupati."+"\033[0m");
                    }else {
                        conta++;
                        System.out.println("Inserire la parola da inserire:");
                        String p = in.nextLine();
                        aggiunta(parole, p, conta);
                    }
                    break;
                case 2:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else{
                        System.out.println("Inserire la stringa da cancellare");
                        String scancella=in.nextLine();
                        if (ricerca(parole,scancella,conta)>=0){
                            conta--;
                            cancellazioneSingola(parole,conta,scancella);
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
                        cepostaperte=ricerca(parole,sricerca,conta);
                        if (cepostaperte>=0){
                            System.out.println("Il termine "+sricerca+" è presente in posizione "+(cepostaperte+1));
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
                            if (!isgiaPresente(parole,i)){
                                System.out.println("La stringa "+parole[i]+" è presente in quantità "+contaRipetizioni(parole,i,conta));
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
                        if (ricerca(parole,sricerca,conta)>=0){
                            System.out.println("Inserire la parola con cui modificare: "+sricerca);
                            String smodifica=in.nextLine();
                            modificaDellaPalabra(parole,sricerca,smodifica,conta);
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
                            System.out.print(stampa(parole,i)+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 7:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else {
                        System.out.println("Il nome più lungo in lista è: "+maximus(parole,conta));
                        System.out.println("Il nome più corto in lista è: "+minimus(parole,conta));
                    }
                    break;
                case 8:
                    if (conta==0)
                        System.out.println("Inserire almeno un valore prima");
                    else {
                        System.out.println("Inserire la stringa da cancellare");
                        String scancella=in.nextLine();
                        if (ricerca(parole,scancella,conta)>=0){
                            conta=cancellazioneMultipla(parole,conta,scancella);
                        }
                        else
                            System.out.println("Non abbiamo ritrovato il termine "+scancella+" nella lista.");
                    }
                    break;
                case 9:
                    System.out.println("Coming soon");
                    break;
                case 0:
                    System.out.println("Adioss");
                    break;
                default:
                    System.out.println("Inserire uno dei valori specificati");
            }
        }while (scelta!=0);
    }
    private static void aggiunta (String [] parole, String p, int conta){
        parole[conta-1]=p;
    }
    private static String stampa (String [] parole, int i){
        return parole[i];
    }
    private static void cancellazioneSingola (String [] parole, int conta, String scancella){
        int posizione=0;
        for (int i=0;i<conta+1;i++){          //+1 per complementare  alla decrementazione principalmente
            if (scancella.equals(parole[i])){
                posizione=i;
                break;
            }
        }
        for (int i=posizione;i<conta;i++){
            parole[i]=parole[i+1];
        }
    }
    private static int cancellazioneMultipla (String [] parole, int conta, String scancella){
            int occorrenze=0,posizione;
            for (int s=0;s<conta+1;s++) {
                if (scancella.equals(parole[s])) {
                    posizione = s;
                    occorrenze++;
                    for (int l = posizione; l < conta; l++) {
                        parole[l] = parole[l + 1];
                    }
                }
            }
            conta-=occorrenze;
            return conta;
    }
    private static int ricerca (String [] parole, String ricerca, int conta){
        int posiziones=-1;
        for (int i=0;i<conta;i++){
            if (ricerca.equals(parole[i])){
                posiziones=i;
                break;
            }
        }
        return posiziones;
    }
    private static boolean isgiaPresente (String [] parole, int i){
        boolean presente=false;
        for (int p=i-1;p>=0;p--){
            if (parole[i].equals(parole[p])){
                presente=true;
                break;
            }
        }
        return presente;
    }
    private static int contaRipetizioni (String [] parole, int i, int conta){
        int ripetizioni=1;
        for (int p=i+1;p<conta;p++){
            if (parole[i].equals(parole[p])){
                ripetizioni++;
            }
        }
        return ripetizioni;
    }
    private static void modificaDellaPalabra (String [] parole, String ricerca, String modifica, int conta){
        for (int i=0;i<conta;i++){
            if (ricerca.equals(parole[i])){
                parole[i]=modifica;
                break;
            }
        }
    }
    private static String maximus (String [] parole, int conta){
        String max=parole[0];
        for (int i=0;i<conta;i++){
            if (max.length()<parole[i].length()){
                max=parole[i];
            }
        }
        return max;
    }
    private static String minimus (String [] parole, int conta){
        String min=parole[0];
        for (int i=0;i<conta;i++){
            if (min.length()>parole[i].length()){
                min=parole[i];
            }
        }
        return min;
    }
}
