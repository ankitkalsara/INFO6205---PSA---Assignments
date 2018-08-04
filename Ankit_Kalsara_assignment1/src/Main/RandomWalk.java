package Main;

/**
 *
 * @author Ankit
 */
import java.util.Random;
import java.util.Scanner;

public class RandomWalk {
    private int x = 0;
    private int y = 0;

    private final Random random = new Random();

    private void move(int dx, int dy) {
        // TODO you need to implement this
        // movement of x and movement of y on Axis
        x = x + dx;
        y = y + dy;
    }

    /**
     * Perform a random walk of m steps
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        for (int i = 0; i < m; i++)
            randomMove();
    }

    private void randomMove() {
        // TODO you need to implement this
        // move person randomly from origin of Axis (0,0)
        //generate random number between 0 to 3 and based on the number move the person
        //if number = 0(north), 1(south), 2(east), 3(west) (person will take step of length = 2)
        
        int randomNo = random.nextInt(4);
        
        if     (randomNo==0) { move(0,1);  }
        else if(randomNo==1) { move(0,-1); }
        else if(randomNo==2) { move(1,0);  }
        else                 { move(-1,0); }
    }

    public double distance() {
        // TODO you need to implement this
        //implement pythagoras theorem for x and y
        double distance = 0;
        distance = Math.pow(x, 2) + Math.pow(y,2);
        distance = Math.sqrt(distance);
        return distance;
        //return 0; 
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++){
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance/n ;
    }

    public static void main(String[] args) {
//        if (args.length==0)
//            throw new RuntimeException("Syntax: RandomWalk steps [experiments]");
        //Integer.parseInt(args[0]);
        int m,n;
        //int m = 50;
        //int n = 5;
        //accept the input from user for number of steps and no of experiments
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter number of steps: ");
        int noOfSteps = reader.nextInt();
        System.out.print("Enter number of experiments to run: ");
        int noOfExperiments = reader.nextInt();
        reader.close();
        m = noOfSteps;
        n = noOfExperiments;
        for(int i=1; i<=n;i++){
        double meanDistance = randomWalkMulti(m, n); 
        //System.out.println("Steps=" + m + " Experiment times= " + n + " Distance= " + meanDistance);    
        System.out.println(meanDistance);    
        m = m+10;
        }    
    }
}