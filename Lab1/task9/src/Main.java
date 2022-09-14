import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Ball ball0 = new Ball("blue", 1);
        Ball ball1 = new Ball("blue", 12);
        Ball ball2 = new Ball("red", 3);
        Ball ball3 = new Ball("blue", 5);
        Ball ball4 = new Ball("white", 6);
        Ball ball5 = new Ball("black", 12);
        Ball ball6 = new Ball("black", 10);

        ArrayList<Ball> ballList= new ArrayList<Ball>();

        ballList.add(ball0);
        ballList.add(ball1);
        ballList.add(ball2);
        ballList.add(ball3);
        ballList.add(ball4);
        ballList.add(ball5);
        ballList.add(ball6);

        Basket basket = new Basket();
        int[] parameters = basket.leaveBalls(ballList);

        int blueCount = parameters[0];
        System.out.println("We have " + blueCount + " blue balls in our basket");
        int ballWeight = parameters[1];
        System.out.println("Total weight of the balls: " + ballWeight);
    }
}
