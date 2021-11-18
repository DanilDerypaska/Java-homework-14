package homework;

import java.util.Random;

public abstract class Warrior {

    protected HealthState healthState = HealthState.GOOD;

    protected int defenceLevel;

    protected int forceLevel;

    public HealthState getHealthState() {
        return healthState;
    }

    public void intDefenceLevel (){

        this.defenceLevel = new Random().nextInt(25);
    }

    public void initForceLevel() {
        this.forceLevel = new Random().nextInt(74);
    }

    protected void changeHealthState(int livePoints) {
        HealthState[] values = HealthState.values();
        for (HealthState value : values ) {
            if(livePoints >= value.getMinLevel() && livePoints <= value.getMaxLevel()) {
                healthState = value;
            }
        }
    }


}
