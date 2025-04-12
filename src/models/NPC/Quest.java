package models.NPC;

import java.util.Objects;

public class Quest {
    private boolean activated = false;
    private boolean completed = false;
    private int level;
    private Objects requestedObjects;
    private Objects rewards;
    private String startMassage;
    private String completeMassage;

    public Quest(boolean activated, boolean completed, int level, Objects requestedObjects, Objects rewards,
            String startMassage, String completeMassage) {
        this.activated = activated;
        this.completed = completed;
        this.level = level;
        this.requestedObjects = requestedObjects;
        this.rewards = rewards;
        this.startMassage = startMassage;
        this.completeMassage = completeMassage;
    }
    
    public boolean isActivated() {
        return activated;
    }
    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public Objects getRequestedObjects() {
        return requestedObjects;
    }
    public void setRequestedObjects(Objects requestedObjects) {
        this.requestedObjects = requestedObjects;
    }
    public Objects getRewards() {
        return rewards;
    }
    public void setRewards(Objects rewards) {
        this.rewards = rewards;
    }
    public String getStartMassage() {
        return startMassage;
    }
    public void setStartMassage(String startMassage) {
        this.startMassage = startMassage;
    }
    public String getCompleteMassage() {
        return completeMassage;
    }
    public void setCompleteMassage(String completeMassage) {
        this.completeMassage = completeMassage;
    }
}
