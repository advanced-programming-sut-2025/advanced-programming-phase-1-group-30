package AP.group30.StardewValley.network.MessageClasses;

public class Vote {
    public String targetUsername;
    public String voterUsername;
    public boolean vote;
    public int agree = 0;
    public int voters = 0;
    public boolean finished = false;
    public boolean forceTermination = false;
}
