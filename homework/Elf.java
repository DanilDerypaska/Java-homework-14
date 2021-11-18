package homework;

import java.util.HashMap;
import java.util.Map;

public class Elf extends Warrior implements Attackable, Defenceable {

    private static final String LIVE_POINTS ="LIVE_POINTS";
    private int livePoints;

    public Elf(int livePoints) {
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
        return "Elf{" +
                "healthState=" + healthState +
                ", livePoints=" + livePoints +
                ", defenceLevel=" + defenceLevel +
                ", forceLevel=" + forceLevel +
                '}';
    }
}
