package homework;

import java.util.HashMap;
import java.util.Map;

public class Gnome extends Warrior implements Attackable, Defenceable{

    private static final String LIVE_POINTS ="LIVE_POINTS";
    private int livePoints;


    public Gnome(int livePoints) {
        this.livePoints = livePoints;
    }

    @Override
    public int attack() {
        return forceLevel;
    }

    @Override
    public void defence(int attackPoints) {
        Map<String, Integer> points = new HashMap<>();
        points.put("ATTACK_POINTS",attackPoints);
        points.put("DEFENCE_LEVEL",defenceLevel);
        points.put(LIVE_POINTS,livePoints);

        Map<String, Integer> pointsMap = calculateDefence(points);

        livePoints = pointsMap.get(LIVE_POINTS);

        changeHealthState(livePoints);
    }

    @Override
    public String toString() {
        return "Gnome{" +
                "healthState=" + healthState +
                ", livePoints=" + livePoints +
                ", defenceLevel=" + defenceLevel +
                ", forceLevel=" + forceLevel +
                '}';
    }
}
