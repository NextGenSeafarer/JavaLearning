package lesson0.Basics.TEST.MyTable;

import java.util.Random;

public class TvOnWall extends Thread {
    private String tvName;
    private int inches;
    private boolean isTvOn;
    private static boolean isNeedToConnectViaHDMI;
    private static int channel = 1;
    private Random random = new Random();

    public TvOnWall(String tvName, int inches) {
        this.tvName = tvName;
        this.inches = inches;
        this.isTvOn = true;
        System.out.println("\nTV is on!");
        this.start();

    }

    public void changeChannelUp() {
        while (random.nextInt(0, 3) != 2) {
            channel++;
            System.out.printf("\n*Click*\nChannel changed to: %d", channel);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Ok, enough!");
            }
        }

    }

    public void changeChannelDown() {
        while (random.nextInt(0, 3) != 2) {
            if (channel > 1) {
                channel--;
            } else {
                channel = 109 - channel;
            }
            System.out.printf("\n*Click*\nChannel changed to: %d", channel);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Ok, enough!");
            }
        }
    }

    public static void connectViaHDMI(Laptop laptop) {
        isNeedToConnectViaHDMI = true;
        System.out.printf("\nTV is connected to %s via HDMI", laptop.getLaptopName());
    }


    @Override
    public void run() {
        changeChannelUp();
        changeChannelDown();

    }


}
