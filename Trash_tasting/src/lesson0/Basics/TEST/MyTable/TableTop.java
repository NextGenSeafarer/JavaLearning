package lesson0.Basics.TEST.MyTable;

public class TableTop {


}

class Laptop implements Runnable {
    private String laptopName;
    private int coresAmount;
    private int RAM;
    private int SSDVolume;
    private String videoGraphics;
    private boolean isLaptopExists;
    private boolean isLaptopOn;

    public String getLaptopName() {
        return laptopName;
    }

    public Laptop(String laptopName, int coresAmount, int RAM, int SSDVolume, String videoGraphics) {
        this.laptopName = laptopName;
        this.coresAmount = coresAmount;
        this.RAM = RAM;
        this.SSDVolume = SSDVolume;
        this.videoGraphics = videoGraphics;
        this.isLaptopExists = true;

    }

    public void turnOnLaptop() {
        String laptopIsExisted = isLaptopExists ? "Laptop is identified" : "You don't have a laptop";
        System.out.println(laptopIsExisted);
        System.out.printf("Laptop, %s is on, available RAM: %d, free disk space: %d Gb", laptopName, RAM, SSDVolume - 40);
        isLaptopOn = true;
    }

    public void keyBoardConnect() {
        String keyboardMessage = isLaptopOn ? "\nKeyboard is connected via bluetooth" : "Switch on the laptop!\n";
        System.out.print(keyboardMessage);
    }

    public void mouseConnect() {
        String mouseMessage = isLaptopOn ? "\nMouse is connected via bluetooth" : "Switch on the laptop!\n";
        System.out.print(mouseMessage);
    }

    public void testOfKeyboardAndMouse() {
        try {
            for (int i = 0; i < 7; i++) {
                if (i > 3) {

                    System.out.print("\nTest mouse" + ".".repeat(i));
                    continue;
                }
                System.out.print("\nTest keyboard" + ".".repeat(i));

            }
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        turnOnLaptop();
        mouseConnect();
        keyBoardConnect();
        testOfKeyboardAndMouse();
        TvOnWall.connectViaHDMI(this);
    }
}
