package S006_BinarySearch;
import java.util.Arrays;
//https://leetcode.com/problems/magnetic-force-between-two-balls/
public class P017_LC1552_MagneticForceBWBalls {
    public static void main(String[] args){
        //call from here...
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;

        int minForce = 1;
        int maxForce = position[n - 1] - position[0];

        int answer = 1;

        // LINEAR SEARCH — check all forces
        for (int force = minForce; force <= maxForce; force++) {
            if (canPlace(force, position, m)) {
                answer = force;    // store last valid force
            } else {
                break;             // when it fails once, all larger forces fail too
            }
        }

        return answer;
    }

    private static boolean canPlace(int force, int[] pos, int m) {
        int balls = 1;
        int last = pos[0];

        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - last >= force) {
                balls++;
                last = pos[i];
            }
            if (balls == m) return true;
        }
        return false;
    }


    //Approach 2 - using binary search approach
    public static int maxDistanceUsingBinarySearch(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int minForce = 1;
        int maxForce = position[n-1] - position[0];

        while(minForce <= maxForce){
            int potentialForce = minForce + (maxForce - minForce)/2;
            if(canPlace(potentialForce, position, m))
                minForce = potentialForce + 1;
            else
                maxForce = potentialForce - 1;
        }

        return maxForce;
    }
}
