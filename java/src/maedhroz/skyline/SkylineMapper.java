package maedhroz.skyline;

import java.util.LinkedList;
import java.util.List;

public class SkylineMapper {

    public static List<Integer> silhouette(Building[] buildings) {
        int max = 0;

        for (Building building : buildings) {
            if (building.getRight() > max) {
                max = building.getRight();
            }
        }

        int[] heights = new int[max+2];
        
	for (Building building : buildings) {
            for (int i = building.getLeft(); i < building.getRight(); i++) {
                heights[i] = Math.max(heights[i], building.getHeight());
            }
        }

        List<Integer> silhouette = new LinkedList<Integer>();
        
	for (int i = 0; i < heights.length - 1; i++) {
            if (heights[i] != heights[i + 1]) {
                silhouette.add(i + 1);
                silhouette.add(heights[i + 1]);
            }
        }

        return silhouette;
    }
}
