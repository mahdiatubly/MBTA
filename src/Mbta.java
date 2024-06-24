import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Mbta {

    public static int stopsBetweenStations(String c1, String s1, String c2, String s2){

        String[] green = {
                "Government Center",
                "Park Street",
                "Boylston",
                "Arlington",
                "Copley",
                "Hynes",
                "Kenmore"
        };
        String[] red = {
                "South Station",
                "Park Street",
                "Kendall",
                "Central",
                "Harvard",
                "Porter",
                "Davis",
                "Alewife"
        };
        String[] orange = {
                "North Station",
                "Haymarket",
                "Park Street",
                "State",
                "Downtown Crossing",
                "Chinatown",
                "Back Bay",
                "Forest Hills"
        };
        Map<String, String[]> stationsMap = new HashMap<>();
        stationsMap.put("Red", red );
        stationsMap.put("Green", green );
        stationsMap.put("Orange", orange );
        if (stationsMap.get(c1) == null || stationsMap.get(c2) == null){
            return -1;
        }

        if (c1 == c2){
            int s1Idx = -1;
            int s2Idx = -1;
            for (int i = 0; i < stationsMap.get(c1).length; i++){
                if (stationsMap.get(c1)[i] == s1){
                    s1Idx = i;
                }
                if (stationsMap.get(c1)[i] == s2){
                    s2Idx = i;
                }
            }
            if (s1Idx == -1 || s2Idx == -1) {
                return -1;
            }
            int diff = s1Idx - s2Idx;
            if (diff> 0) {
                return diff;
            } else {
                return diff * -1;
            }

        } else {
            int diff1 = 0;
            int mainStationIdx = 0;
            int s1Idx = -1;
            for (int i = 0; i < stationsMap.get(c1).length; i++){
                if (stationsMap.get(c1)[i] == s1){
                    s1Idx = i;
                }
                if (stationsMap.get(c1)[i] == "Park Street"){
                    mainStationIdx = i;
                }
            }
            diff1 = mainStationIdx - s1Idx;
            if (diff1 < 0) {
                diff1 = diff1* -1;
            }

            int diff2 = 0;
            int mainStationIdx2 = 0;
            int s2Idx = -1;
            for (int i = 0; i < stationsMap.get(c2).length; i++){
                if (stationsMap.get(c2)[i] == s2){
                    s2Idx = i;
                }
                if (stationsMap.get(c2)[i] == "Park Street"){
                    mainStationIdx2 = i;
                }
            }

            if (s1Idx == -1 || s2Idx == -1) {
                return -1;
            }

            diff2 = mainStationIdx2 - s2Idx;
            if (diff2 < 0) {
                diff2 = diff2* -1;
            }
            return diff1 + diff2;

        }
    }
}
