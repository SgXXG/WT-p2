import java.util.ArrayList;

public class Basket {
    private int blueBalls;
    private int ballsWeight;

    public int[] leaveBalls(ArrayList<Ball> ballList){
        int totalWeight = 0;
        int blueCount = 0;

        for (Ball h: ballList) {
            if (h.getColor().equals("blue")){
                blueCount++;
            }
            totalWeight += h.getWeight();
        }

        blueBalls = blueCount;
        ballsWeight = totalWeight;
        int[] result = new int[2];
        result[0] = blueBalls;
        result[1] = ballsWeight;
        return result;
    }
}
