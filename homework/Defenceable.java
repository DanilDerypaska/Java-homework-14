package homework;

import java.util.Map;
public interface Defenceable {

    void defence(int attackPoints);

    default Map<String, Integer> calculateDefence (Map<String, Integer> points) {

        Integer attackPoints = points.get("ATTACK_POINTS");
        Integer defenceLevel = points.get("DEFENCE_LEVEL");
        Integer livePoints = points.get("LIVE_POINTS");

        if (attackPoints <= defenceLevel) {
            defenceLevel = defenceLevel - attackPoints;
            points.put("DEFENCE_LEVEL", defenceLevel);
        } else {
            int rest = attackPoints - defenceLevel;
            defenceLevel = 0;
            livePoints = Math.max(livePoints - rest, 0);
        }

        points.put("DEFENCE_LEVEL",defenceLevel);
        points.put("LIVE_POINTS",livePoints);

        return points;

    }

}
