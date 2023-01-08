package lesson0.Basics.TEST.MyTable;

public class Tablet {
    private String name;
    private String nameOfTheCourse;
    private int counterForLearning;

    public Tablet(String name, String nameOfTheCourse){
        this.name = name;
        this.nameOfTheCourse = nameOfTheCourse;
        this.counterForLearning = 60;
        countingLearningTime();
    }
    public void countingLearningTime(){
        System.out.println("\nIT's study time!");
        while(counterForLearning >= 0 ){
            try {
                if(counterForLearning==1){
                    System.out.println("\nGood job, take a rest!!");
                    break;
                }
                Thread.sleep(100);
                --counterForLearning;
                System.out.printf("\nYour have remaining: %d min to be best in java",counterForLearning);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }



}
