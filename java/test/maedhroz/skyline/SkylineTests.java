package maedhroz.skyline;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SkylineTests {

    @Test
    public void shouldMapSkylineWithSeparateGroups() {
        Building[] buildings = new Building[] {
            new Building(1, 11, 5),
            new Building(2, 6, 7),
            new Building(3, 13, 9),
            new Building(12, 7, 16),
            new Building(14, 3, 25),
            new Building(19, 18, 22),
            new Building(23, 13, 29),
            new Building(24, 4, 28)
        };

        List<Integer> expectedSkyline = new LinkedList<Integer>();
        expectedSkyline.add(1);
        expectedSkyline.add(11);
        expectedSkyline.add(3);
        expectedSkyline.add(13);
        expectedSkyline.add(9);
        expectedSkyline.add(0);
        expectedSkyline.add(12);
        expectedSkyline.add(7);
        expectedSkyline.add(16);
        expectedSkyline.add(3);
        expectedSkyline.add(19);
        expectedSkyline.add(18);
        expectedSkyline.add(22);
        expectedSkyline.add(3);
        expectedSkyline.add(23);
        expectedSkyline.add(13);
        expectedSkyline.add(29);
        expectedSkyline.add(0);

        List<Integer> actualSkyline = SkylineMapper.silhouette(buildings);

        Assert.assertEquals(expectedSkyline, actualSkyline);
    }

    @Test
    public void shouldMapSkylineWithSingleGroups() {
        Building[] buildings = new Building[] {
            new Building(1, 6, 5),
            new Building(2, 9, 7),
            new Building(6, 5, 9)
        };

        List<Integer> expectedSkyline = new LinkedList<Integer>();
        expectedSkyline.add(1);
        expectedSkyline.add(6);
        expectedSkyline.add(2);
        expectedSkyline.add(9);
        expectedSkyline.add(7);
        expectedSkyline.add(5);
        expectedSkyline.add(9);
        expectedSkyline.add(0);

        List<Integer> actualSkyline = SkylineMapper.silhouette(buildings);

        Assert.assertEquals(expectedSkyline, actualSkyline);
    }

    @Test
    public void shouldMapSkylineWithSingleBuilding() {
        Building[] buildings = new Building[] {
            new Building(1, 11, 5)
        };

        List<Integer> expectedSkyline = new LinkedList<Integer>();
        expectedSkyline.add(1);
        expectedSkyline.add(11);
        expectedSkyline.add(5);
        expectedSkyline.add(0);

        List<Integer> actualSkyline = SkylineMapper.silhouette(buildings);

        Assert.assertEquals(expectedSkyline, actualSkyline);
    }

    @Test
    public void shouldMapSkylineWithEquallyTallBuildings() {
        Building[] buildings = new Building[] {
            new Building(1, 11, 5),
            new Building(3, 11, 8)
        };

        List<Integer> expectedSkyline = new LinkedList<Integer>();
        expectedSkyline.add(1);
        expectedSkyline.add(11);
        expectedSkyline.add(8);
        expectedSkyline.add(0);

        List<Integer> actualSkyline = SkylineMapper.silhouette(buildings);

        Assert.assertEquals(expectedSkyline, actualSkyline);
    }

    @Test
    public void shouldMapSkylineWithEquallyTallOverlappingBuildings() {
        Building[] buildings = new Building[] {
            new Building(1, 11, 8),
            new Building(3, 11, 6)
        };

        List<Integer> expectedSkyline = new LinkedList<Integer>();
        expectedSkyline.add(1);
        expectedSkyline.add(11);
        expectedSkyline.add(8);
        expectedSkyline.add(0);

        List<Integer> actualSkyline = SkylineMapper.silhouette(buildings);

        Assert.assertEquals(expectedSkyline, actualSkyline);
    }

    @Test
    public void shouldMapSkylineWithWideBuildingUnderneath() {
        Building[] buildings = new Building[] {
            new Building(1, 5, 9),
            new Building(3, 10, 7)
        };

        List<Integer> expectedSkyline = new LinkedList<Integer>();
        expectedSkyline.add(1);
        expectedSkyline.add(5);
        expectedSkyline.add(3);
        expectedSkyline.add(10);
        expectedSkyline.add(7);
        expectedSkyline.add(5);
        expectedSkyline.add(9);
        expectedSkyline.add(0);

        List<Integer> actualSkyline = SkylineMapper.silhouette(buildings);

        Assert.assertEquals(expectedSkyline, actualSkyline);
    }
}
