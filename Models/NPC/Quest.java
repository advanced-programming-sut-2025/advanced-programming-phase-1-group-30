package NPC;

import java.util.ArrayList;
import java.util.Objects;

public class Quest {
    private boolean activated = false;
    private boolean completed = false;
    private int level;
    private Objects requestedObjects;
    private Objects rewards;
    private String startMassage;
    private String completeMassage;
}
