package homework;

public enum HealthState {

   GOOD(100,70),
   AVERAGE(69,30),
    POOR(29,1),
    DEAD(0,0);

    private final int maxLevel;
    private final int minLevel;

    HealthState(int maxLevel, int minLevel) {
        this.maxLevel = maxLevel;
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public int getMinLevel() {
        return minLevel;
    }
}
