
package mutual_exclusion_implementation;
import java.util.Random;
public class Mutual_Exclusion_Implementation {
    
    static PadLock criticalSection;
    public static void main(String[] args) {
        criticalSection = PadLock.Open;
        ProcessThread process1 = new ProcessThread(1);
        ProcessThread process2 = new ProcessThread(2);
        ProcessThread process3 = new ProcessThread(3);
        
        System.out.println("JAVA IMPLEMENTATION OF MUTUAL EXCLUSION");
        System.out.println("Fullname: \tADEYEMI ADEDOYIN SIMEON");
        System.out.println("Matric Number: \t(209188)");
        System.out.println("Course: \tCSC747 (Operating System)");
        System.out.println("--------------------------------------\n");
        process1.start();
        process2.start();
        process3.start();
        
    }
    
    public static class ProcessThread extends Thread {
        private final int Pid, max;
        int counter = 1;
        public ProcessThread(int Pid){
             this.Pid = Pid;
             Random rand = new Random();
             this.max = rand.nextInt(20) + 1;
        }
     
        @Override
        public void run(){
            
            while(true){
//               System.out.println("Process " + Pid + 
//                            " : Other Codes: " + (++counter));
               while(criticalSection == PadLock.Open){
                    synchronized(this){
                        criticalSection = PadLock.Locked;
                        System.out.println("Process " + Pid + 
                            " : in critical section");
                        for(int i=1; i <= 5; i++){
                            System.out.println("Process " + Pid + " : " + 
                                    i + " * " + max + " = " + (i * max));
                        }
                        criticalSection = PadLock.Open;  //leave critical section
                        System.out.println("Process " + Pid + 
                                " : Leaving critical section");
                     }
                    
                       //for(int j = 1; j <=10; j++){
                       //     System.out.println("Process " + Pid + 
                       //         " : Other Codes: " + j);
                       // }
                    
               }
           }
       }
    }

}

