package lesson0.Basics.TEST.MyTable;

public class TableMain {
    public static void main(String[] args) throws InterruptedException {

        Thread laptop = new Thread(new Laptop("Asus TufGaming", 4, 16, 512, "Nvidia 1660Ti"));
        laptop.start();
        laptop.join();
        TvOnWall tv = new TvOnWall("LG", 65);
        tv.join();
        Tablet tablet = new Tablet("Xiaomi tab 5","Java basic course");


    }
}
