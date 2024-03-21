import java.util.Scanner;

public class GestrionaleDiStringhe {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String [] a=new String [100];
        int conta=0; // Indice delle parole inserite
        int scelta;
        String temp;
        do {
            System.out.println("Secegliere tra una delle opzioni proposte:");
            System.out.println("0-Esci");
            System.out.println("1-Aggiunta ordinata di un nome");
            System.out.println("2-Cancellazione del singolo nome");
            System.out.println("3-Ricerca sequenziale di un nome");
            System.out.println("4-Visualizza nomi ripetuti");
            System.out.println("5-Modifica di un nome");
            System.out.println("6-Visualizzazione di tutti i nomi presenti");
            System.out.println("7-Ricerca del nome più lungo e del nome più corto");
            System.out.println("8-Cancellazione di tutte le occorrenze di un nome");
            System.out.println("9-Riordino");
            scelta=in.nextInt();
            in.nextLine();
            switch (scelta){
                case 0:
                    System.out.println("Addios");
                    break;
                case 1:
                    do {
                        System.out.println("Inserire ciò che si vuole aggiungere all'array");
                        temp=in.nextLine();
                        if (temp.isEmpty())
                            System.out.println("Inserire una stringa non vuota");
                        else {
                            if (conta==101)
                                System.out.println("Impossibile eseguire l'azione richiesta, memoria piena.");
                            else
                                conta=aggiungiOrdinato(a, temp, conta);
                        }
                    } while (temp.isEmpty());
                    break;
                case 2:
                    if (conta==0)
                        System.out.println("Impossibile eseguire il comando, memoria vuota");
                    else {
                        do {
                            System.out.println("Inserire ciò che si vuole cancellare dall'array");
                            temp=in.nextLine();
                            if (temp.isEmpty())
                                System.out.println("Non ci possono essere stringa vuote");
                            else {
                                if (isPresente(a,conta,temp)>=0)
                                    conta=cancella(a, temp, conta);
                                else
                                    System.out.println("la stringa inserita non è presente quindi impossibile cancellare");
                            }
                        } while (temp.isEmpty());
                    }
                    break;
                case 3:
                    if (conta==0)
                        System.out.println("Impossibile eseguire il comando, memoria vuota");
                    else {
                        do {
                            System.out.println("Inserire ciò che si vuole cercare nell'array");
                            temp=in.nextLine();
                            if (temp.isEmpty())
                                System.out.println("Non ci possono essere stringa vuote");
                            else {
                                if(isPresente(a,conta,temp)>=0)
                                    System.out.println("E' presente in posizione "+isPresente(a,conta,temp));
                            }
                        } while (temp.isEmpty());
                    }
                    break;
                case 4:
                    if (conta==0)
                        System.out.println("Impossibile eseguire il comando, memoria vuota");
                    else {
                        String [] b=ripezioni(a,conta);
                        for (int i=0;i<conta;i++){
                            if (b[i]==null)
                                break;
                            else
                                System.out.println("La stringa: "+b[i]+" è ripetuta "+b[(conta*2)-1-i]+" volte.");
                        }
                    }
                    break;
                case 5:
                    if (conta==0)
                        System.out.println("Impossibile eseguire il comando, memoria vuota");
                    else {
                        do {
                            System.out.println("Inserire ciò che si vuole cercare nell'array");
                            temp=in.nextLine();
                            if (temp.isEmpty())
                                System.out.println("Non ci possono essere stringa vuote");
                            else {
                                if(isPresente(a,conta,temp)>=0){
                                    System.out.println("Inserire ciò con cui si vuole modificare nell'array");
                                    String temp1=in.nextLine();
                                    modifica(a,conta,temp,temp1);
                                }
                            }
                        } while (temp.isEmpty());
                    }
                    break;
                case 6:
                    System.out.println("L'array contiene: ");
                    System.out.println();
                    for (int i=0;i<conta;i++){
                        System.out.print(visualizza(a,i)+" ");
                    }
                    System.out.println();
                    break;
                case 7:
                    if (conta==0)
                        System.out.println("Impossibile eseguire il comando, memoria vuota");
                    else {
                        System.out.println("la stringa più lunga è: "+max(a,conta));
                        System.out.println("la stringa più corta è: "+min(a,conta));
                    }
                    break;
                case 8:
                    if (conta==0)
                        System.out.println("Impossibile eseguire il comando, memoria vuota");
                    else {
                        do {
                            System.out.println("Inserire ciò che si vuole cancellare dall'array");
                            temp=in.nextLine();
                            if (temp.isEmpty())
                                System.out.println("Non ci possono essere stringa vuote");
                            else {
                                if (isPresente(a,conta,temp)>=0)
                                    conta=cancellaMultiplo(a, temp, conta);
                                else
                                    System.out.println("la stringa inserita non è presente quindi impossibile cancellare");
                            }
                        } while (temp.isEmpty());
                    }
                    break;
                case 9:
                default:
                    System.out.println("Inserire solo valori dati!!");
            }

        } while (scelta!=0);
    }


    //Ordinamento e aggiunta
    private static int aggiungiOrdinato (String [] a, String temp, int conta){
        int posizione=conta;
        for (int i=0;i<conta;i++){
            if (temp.compareToIgnoreCase(a[i])<0){
                posizione=i;
                for (int p=conta;p>i;p--){
                    a[p]=a[p-1];
                }
                break;
            }
        }
        a[posizione]=temp;
        conta++;
        return conta;
    }
    private static int cancella (String [] a, String temp, int conta){
        for (int i=0;i<conta;i++){
            if (temp.equalsIgnoreCase(a[i])){
                for (int p=i;p<conta-1;p++){
                    a[p]=a[p+1];
                }
                break;
            }
        }
        conta--;
        return conta;
    }
    private static int isPresente (String [] a , int conta, String temp){
        int posizione=-1;
        for (int i=0;i<conta;i++){
            if (temp.equalsIgnoreCase(a[i])){
                posizione=i;
                break;
            }
        }
        return posizione;
    }
    private static String [] ripezioni (String [] a , int conta){
        String [] b=new String[conta*2]; //Array dove saranno contenuti tutti i risultati ad esempio pollo
        String [] temp=new String[conta]; //Array di appoggio
        int contatemp=0;

        //Preparo array senza repliche
        boolean isGiaPresente;
        for (int i=0;i<conta;i++){
            isGiaPresente=false;
            for (int p=0;p<contatemp;p++){
                if (a[i].equalsIgnoreCase(temp[p])){
                    isGiaPresente=true;
                    break;
                }
            }
            if (!isGiaPresente){
                temp[contatemp]=a[i];
                contatemp++;
            }
        }

        //Conteggio ed inserimento in array
        int conto;
        for (int y=0;y<contatemp;y++){
            conto=0;
            for (int l=0;l<conta;l++){
                if (temp[y].equalsIgnoreCase(a[l]))
                    conto++;
            }
            b[y]=temp[y];
            b[(conta*2)-y-1]=String.valueOf(conto);
        }
        return b;
    }
    private static void modifica (String [] a , int conta, String temp, String temp1){
        a[isPresente(a,conta,temp)]=temp1;
    }
    private static String visualizza (String [] a , int posicion ){
        return a[posicion];
    }
    private static String max (String [] a , int conta ){
        String max=a[0];
        for (int i=0;i<conta;i++){
            if (max.length()<a[i].length())
                max=a[i];
        }
        return max;
    }
    private static String min (String [] a , int conta ){
        String min=a[0];
        for (int i=0;i<conta;i++){
            if (min.length()>a[i].length())
                min=a[i];
        }
        return min;
    }
    private static int cancellaMultiplo (String [] a, String temp, int conta){
        for (int i=0;i<conta;i++){
            if (temp.equalsIgnoreCase(a[i])){
                for (int p=i;p<conta-1;p++){
                    a[p]=a[p+1];
                }
                i--;
                conta--;
            }
        }
        return conta;
    }
}
