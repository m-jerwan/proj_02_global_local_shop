package models;


import java.util.ArrayList;
import java.util.List;

public class Distance {

//    Simulating distance calculating API connection. Method Class will take any postcode from EH1 to EH15 and return distance;
//    Method can't be customised to multi-City situation. Only works for same postcode area.

    public Distance() {}

    public static List<int[]> setUpDistances(){
        int[] eh1 = {0,	1,	1,	3,	2,	2,	1,	1,	2,	5,	5,	5,	5,	10,	3};
        int[] eh2 = {1,	0,	1,	3,	2,	2,	2,	2,	2,	4,	4,	5,	5,	9,	4};
        int[] eh3 = {1,	1,	0,	3,	2,	2,	2,	2,	2,	4,	4,	5,	5,	9,	4};
        int[] eh4 = {3,	3,	3,	0,	2,	5,	4,	5,	4,	5,	3,	2,	5,	8,	6};
        int[] eh5 = {2,	2,	2,	2,	0,	2,	3,	3,	4,	5,	4,	4,	6,	10,	5};
        int[] eh6 = {2,	2,	2,	5,	2,	0,	2,	2,	3,	6,	6,	6,	7,	11,	3};
        int[] eh7 = {1,	2,	2,	4,	3,	2,	0,	1,	2,	5,	6,	6,	6,	10,	2};
        int[] eh8 = {1,	2,	2,	5,	3,	2,	1,	0,	2,	2,	4,	5,	6,	10,	2};
        int[] eh9 = {2,	2,	2,	4,	4,	3,	2,	2,	0,	2,	4,	5,	4,	8,	3};
        int[] eh10 = {5, 4,	4,	5,	5,	6,	5,	2,	2,	0,	4,	5,	2,	7,	5};
        int[] eh11 = {5, 4,	4,	3,	4,	6,	6,	4,	4,	4,	0,	2,	3,	5,	7};
        int[] eh12 = {5, 5,	5,	2,	4,	6,	6,	5,	5,	5,	2,	0,	5,	6,	8};
        int[] eh13 = {5, 5,	5,	5,	6,	7,	6,	6,	4,	2,	3,	5,	0,	5,	7};
        int[] eh14 = {10, 9, 9,	8,	10,	11,	10,	10,	8,	7,	5,	6,	5,	0,	11};
        int[] eh15 = {3, 4,	4,	6,	5,	3,	2,	2,	3,	5,	7,	8,	7,	11,	0};

        List<int[]> distances = new ArrayList<>();
        distances.add(eh1);
        distances.add(eh2);
        distances.add(eh3);
        distances.add(eh4);
        distances.add(eh5);
        distances.add(eh6);
        distances.add(eh7);
        distances.add(eh8);
        distances.add(eh9);
        distances.add(eh10);
        distances.add(eh11);
        distances.add(eh12);
        distances.add(eh13);
        distances.add(eh14);
        distances.add(eh15);

        return distances;
    }

    public static Integer distanceBetween(String point1, String point2){
//        takes string, cuts first 2 letters ("eh") and parses into Integer to be used in the grid finder
        Integer point1Int = Integer.parseInt(point1.substring(2));
        Integer point2Int = Integer.parseInt(point2.substring(2));

        List<int[]> distances = Distance.setUpDistances() ;
        return distances.get(point1Int-1)[point2Int-1];
    }


}
