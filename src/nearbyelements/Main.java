package nearbyelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static int[][] multi;

    public static void main(String[] args) {
        multi = new int[][]{
                { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
                { 1, 3, 5, 7 },
                { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
        };

        System.out.println(Arrays.toString(nearby(0, 2, 2)));
        System.out.println(Arrays.toString(nearby(1, 0, 1)));
        System.out.println(Arrays.toString(nearby(1, 3, 5)));

    }



    private static int[] nearby(int x, int y, int range) {
        int fromIndex;
        int toIndex;
        List<Integer> toReturnList = new ArrayList<>();

        if (y == 0) {
            fromIndex = 1;
        }
        else if (y - range < 0) {
            fromIndex = 0;
        } else {
            fromIndex = y - range;
        }

        if (y + range > multi[x].length) {
            toIndex = multi[x].length;
        } else {
            toIndex = y + range;
        }

        for (int i=0; i < multi[x].length; i++) {
            if (i >= fromIndex && i <= toIndex && i!= y) {
                toReturnList.add(multi[x][i]);
            }
        }

        return toReturnList.stream().mapToInt(i -> i).toArray();
    }
}
