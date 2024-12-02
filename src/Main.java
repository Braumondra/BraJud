import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Kolik chcete max u vlaku 1");
        int kapacita= sc.nextInt();
        Vlak vlak1=new Vlak(1,"Bratislava",0,kapacita);
        System.out.println("Kolik chcete max u vlaku 2");
         kapacita= sc.nextInt();
        Vlak vlak2=new Vlak(2,"Beroun",0,kapacita);
        System.out.println("Kolik chcete max u vlaku 3");
         kapacita= sc.nextInt();
        Vlak vlak3=new Vlak(3,"Praha",0,kapacita);
        System.out.println("Kolik chcete max u vlaku 4");
         kapacita= sc.nextInt();
        Vlak vlak4=new Vlak(4,"Ustí",0,kapacita);



        Thread thvlak1=new Thread(vlak1);
        Thread thvlak2=new Thread(vlak2);
        Thread thvlak3=new Thread(vlak3);
        Thread thvlak4=new Thread(vlak4);

        thvlak1.start();
        thvlak2.start();
        thvlak3.start();
        thvlak4.start();

        try{
            thvlak1.join();
            thvlak2.join();
            thvlak3.join();
            thvlak4.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        int celkem=0;
        celkem+=vlak1.getCelkovypocet()+ vlak2.getCelkovypocet()+ vlak3.getCelkovypocet()+ vlak4.getCelkovypocet();
        System.out.println("Všechny vlaky dokončily jízdu.Celkem přepravily "+celkem+" cestujících");


    }
}