package MultyThreade;

public class Banka implements Runnable {

    private int hesabBakiye = 0;
    private String name;


    private void setHesabBakiye(int hesabBakiye) {
        this.hesabBakiye = hesabBakiye;
    }

    private int getHesabBakiye() {
        return hesabBakiye;
    }

    Banka(int hesabBakiye, String name) {
        this.hesabBakiye = hesabBakiye;
        this.name = name;
    }

    public Banka() {
    }

    public static void main(String[] args) {

        Banka kasa1 = new Banka(50, "ali");
        Banka kasa2 = new Banka(30, "cem");
        Thread t1 = new Thread(kasa1);
        Thread t2 = new Thread(kasa2);

        t1.start();
       /* try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        t2.start();


    }

    @Override
    public void run() {
        hesapArttir();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void hesapArttir() {

        for (int i = 0; i < 100; i++) {
            setHesabBakiye(this.getHesabBakiye() + i);
            System.out.println(getHesabBakiye() + "  " + getName());
        }


    }


}
