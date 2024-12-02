public class Vlak implements Runnable{

    private int Id;
    private String nazev;
    private int pocetcestujici;
    private int max;
    private int celkovypocet;

    public Vlak(int id, String nazev, int pocetcestujici,int max) {
        this.Id = id;
        this.nazev = nazev;
        this.pocetcestujici = pocetcestujici;
        this.max = max;
    }



    @Override
    public void run() {
        setPocetcestujici(0);
        for (int i=1;i<=10;i++){
            //Uspání vlaku při každé stanici
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //první stanice
            if (i==1){
                int na=nastup();
                setCelkovypocet(na);
                System.out.println("Vlak "+getId()+" přijel do stanice "+i+". Nastoupilo "+na+" cestujících");
                continue;
            }
            //poslední stanice
            if (i==10){
                vystupall();
                System.out.println(" Vlak dokončil svojí jízdu "+getId());
                continue;
            }
            //2-9 stanice
            int vy=vystup();
            int na=nastup();
            setCelkovypocet(getCelkovypocet()+na);
            System.out.println("Vlak "+getId()+" přijel do stanice "+i+". Vystoupilo zde "+vy+" a nastoupilo "+na+" cestujících");

        }
    }
    protected int nastup(){
//Nastoupení lidí od stanice
        int random= (int) (Math.random()*21);
        if (random+getPocetcestujici()>max){
            int zbytek=random+getPocetcestujici()-max;
            System.out.println("Limit překročen o "+zbytek+" lidí");
            setPocetcestujici(max);
            return zbytek;
        }
        setPocetcestujici(random+getPocetcestujici());
        return random;

    }
    protected int vystup(){
        //Vystoupení lidí od stanice
        int pocet=getPocetcestujici();
        int v = (int)Math.random() * getPocetcestujici();
        setPocetcestujici(pocet-v);
        return pocet-v;
    }
    protected int vystupall(){
        //VYstoupení všech lídí u poslední stanice
        System.out.println("Poslední stanice prosíme vystupte");
        int a=getPocetcestujici();
        setPocetcestujici(0);
        return a;
    }

    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getPocetcestujici() {
        return pocetcestujici;
    }

    public void setPocetcestujici(int pocetcestujici) {
        this.pocetcestujici = pocetcestujici;
    }

    public int getCelkovypocet() {
        return celkovypocet;
    }

    public void setCelkovypocet(int celkovypocet) {
        this.celkovypocet = celkovypocet;
    }
}
