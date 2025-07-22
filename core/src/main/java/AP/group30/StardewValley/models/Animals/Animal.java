package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.Barn;
import AP.group30.StardewValley.models.Buildings.BuildingsInfo;
import AP.group30.StardewValley.models.Buildings.Coop;
import AP.group30.StardewValley.models.Buildings.RanchCosts;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Maps.Tile;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Animal {
    private int price;
    private String name;
    private int friendship;
    private boolean fedToday;
    private boolean petToday;
    private boolean productReady;
    private RanchCosts type;
    private float x;
    private float y;
    private Coop coop;
    private Barn barn;
    private boolean isOut = false;
    private float targetX, targetY;
    private float speed = 50f;
    private boolean moveHorizontalFirst;
    private BitmapFont font = GameAssetManager.assetManager.get(GameAssetManager.skin).getFont("font");

    protected float minX, maxX, minY, maxY;
    private boolean hovered;
    private Rectangle rect;
    private boolean changedFeedState = false;


    protected Animation<TextureRegion> walkUp, walkDown, walkLeft, walkRight;
    protected TextureRegion idleFront;      // single frame for petting
    protected float stateTime = 0f;

    public enum State {
        WANDERING,
        EATING,
        PETTING
    }

    protected State state = State.WANDERING;
    protected float eatTimer = 0f;
    protected float nextEatDelay = 0f;    // time until the next eating bout
    protected Animation<TextureRegion> eatAnimation;

    // Current state
    protected Direction direction = Direction.SOUTH;
    protected boolean isNearPlayer = false;

    // Petting threshold (pixels)
    private static final float PET_RANGE = 40f;

    /** Call this once after loading your directional animations and idleFront. */
    public void initAnimations(TextureRegion[] upFrames,
                               TextureRegion[] downFrames,
                               TextureRegion[] leftFrames,
                               TextureRegion[] rightFrames,
                               TextureRegion[] eatingFrames,
                               TextureRegion idleFrontFrame) {
        walkUp    = new Animation<TextureRegion>(0.2f, upFrames);
        walkDown  = new Animation<TextureRegion>(0.2f, downFrames);
        walkLeft  = new Animation<TextureRegion>(0.2f, leftFrames);
        walkRight = new Animation<TextureRegion>(0.2f, rightFrames);
        eatAnimation = new Animation<TextureRegion>(0.4f, eatingFrames);
        walkUp.setPlayMode(Animation.PlayMode.LOOP);
        walkDown.setPlayMode(Animation.PlayMode.LOOP);
        walkLeft.setPlayMode(Animation.PlayMode.LOOP);
        walkRight.setPlayMode(Animation.PlayMode.LOOP);
        idleFront = idleFrontFrame;
        scheduleNextEat();  // pick when the animal will first eat
    }
    private void scheduleNextEat() {
        // e.g. between 5 and 15 seconds until next eat
        nextEatDelay = MathUtils.random(15f, 25f);
    }

    public Animal(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y, RanchCosts type) {
        this.price = price;
        this.name = name;
        this.friendship = friendship;
        this.fedToday = fedToday;
        this.petToday = petToday;
        this.productReady = false;
        this.x = Gdx.graphics.getWidth() / 2f;
        this.y = Gdx.graphics.getHeight() / 2f;
        this.type = type;
        this.targetX = x;
        this.targetY = y;

        if (type.getRequiredBuilding().equals(BuildingsInfo.Barn)) {
            minX = 700; maxX = 1380; minY = 360; maxY = 610;
        } else if (type.getRequiredBuilding().equals(BuildingsInfo.Coop)) {
            minX = 500; maxX = 1380; minY = 360; maxY = 610;
        }
        this.rect = new Rectangle(x, y, 50, 50); // Default rectangle size
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getFriendship() {
        return friendship;
    }
    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }
    public boolean isFedToday() {
        return fedToday;
    }
    public void setFedToday(boolean fedToday) {
        this.fedToday = fedToday;
    }
    public boolean isPetToday() {
        return petToday;
    }
    public void setPetToday(boolean petToday) {
        this.petToday = petToday;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }

    public boolean isProductReady() {
        return productReady;
    }

    public void setProductReady(boolean productReady) {
        this.productReady = productReady;
    }

    public void produceProduct() {
    }
    public void collectProduct() {
    }

    public RanchCosts getType() {
        return type;
    }

    public Coop getCoop() {
        return coop;
    }

    public void setCoop(Coop coop) {
        this.coop = coop;
    }

    public Barn getBarn() {
        return barn;
    }

    public void setBarn(Barn barn) {
        this.barn = barn;
    }
    public String name(Animal animal) {
        switch (animal.getType()) {
            case CHICKEN -> {
                return "Chicken";
            }
            case DUCK -> {
                return "Duck";
            }
            case SHEEP -> {
                return "Sheep";
            }
            case PIG -> {
                return "Pig";
            }
            case GOAT -> {
                return "Goat";
            }
            case RABBIT -> {
                return "Rabbit";
            }
            case COW -> {
                return "Cow";
            }
            case DINOSAUR -> {
                return "Dinosaur";
            }
        }
        return "";
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public float getFirstX() {
        return targetX;
    }

    public void setFirstX(int firstX) {
        this.targetX = firstX;
    }

    public float getFirstY() {
        return targetY;
    }

    public void setFirstY(int firstY) {
        this.targetY = firstY;
    }

    public void update(float delta, float playerX, float playerY) {
        stateTime += delta;

        // 1) Petting has highest priority
        float dist = Vector2.dst(x, y, playerX, playerY);
        if (dist < PET_RANGE && !changedFeedState) {
            state = State.PETTING;
            direction = Direction.SOUTH;
            stateTime = 0f;
            App.getCurrentGame().getCurrentPlayer().setNearbyAnimal(this);
            return;
        }

        // 2) Eating state
        if (state == State.EATING) {
            eatTimer -= delta;
            if (eatTimer <= 0f) {
                // Done eating → go back to wandering
                state = State.WANDERING;
                changedFeedState = false;
                scheduleNextEat();
                pickRandomTarget();
            }
            return; // while eating, don't wander
        }

        // 3) If not yet time to eat, countdown until next eating
        nextEatDelay -= delta;
        if (nextEatDelay <= 0f) {
            // start eating
            state = State.EATING;
            eatTimer = MathUtils.random(2f, 5f); // eat for 2–5 seconds
            stateTime = 0f;
            return;
        }

        // 4) Wandering logic (straight-line movement)
        if (state == State.WANDERING) {
            float dx = targetX - x;
            float dy = targetY - y;

            // if both axes are “close enough,” pick a new target
            if (Math.abs(dx) < 2f && Math.abs(dy) < 2f) {
                pickRandomTarget();
                return;
            }

            float move = speed * delta;
            float moveX = 0, moveY = 0;

            if (moveHorizontalFirst) {
                // Move in X until you're within epsilon, then switch to Y
                if (Math.abs(dx) >= 2f) {
                    moveX = Math.signum(dx) * move;
                    direction = dx > 0 ? Direction.EAST : Direction.WEST;
                } else {
                    // now finish vertical
                    moveY = Math.signum(dy) * move;
                    direction = dy > 0 ? Direction.NORTH : Direction.SOUTH;
                }
            } else {
                // Vertical first
                if (Math.abs(dy) >= 2f) {
                    moveY = Math.signum(dy) * move;
                    direction = dy > 0 ? Direction.NORTH : Direction.SOUTH;
                } else {
                    // then horizontal
                    moveX = Math.signum(dx) * move;
                    direction = dx > 0 ? Direction.EAST : Direction.WEST;
                }
            }

            x += moveX;
            y += moveY;
        }
    }


    public void render(SpriteBatch batch) {
        TextureRegion frame = null;
        switch (state) {
            case PETTING:
                frame = idleFront;
                break;
            case EATING:
                frame = eatAnimation.getKeyFrame(stateTime, true);
                break;
            case WANDERING:
            default:
                switch (direction) {
                    case NORTH:    frame = walkUp.getKeyFrame(stateTime, true); break;
                    case SOUTH:  frame = walkDown.getKeyFrame(stateTime, true); break;
                    case WEST:   frame = walkLeft.getKeyFrame(stateTime, true); break;
                    case EAST:  frame = walkRight.getKeyFrame(stateTime, true); break;
                }
        }
        batch.draw(frame, x, y, frame.getRegionWidth() * 2.5f, frame.getRegionHeight() * 2.5f);
        if (hovered) {
            font.getData().setScale(0.4f);
            font.setColor(Color.WHITE);
            font.draw(batch, "name: " + name, x + 10, y + 87);
            font.draw(batch, "friendship: " + friendship, x + 10, y + 75);
            font.draw(batch, fedToday ? "fed today" : "not fed today", x + 10, y + 63);
            font.draw(batch, petToday ? "petted today" : "not petted today", x + 10, y + 51);
            font.draw(batch, productReady ? "product ready" : "product not ready", x + 10, y + 39);
            font.getData().setScale(1f);
        }
    }

    private void pickRandomTarget() {
        if (barn == null) {
            if (isOut) {
                targetX = MathUtils.random(coop.getStartX() * 32, coop.getStartX() * 32 + coop.getWidth() * 32);
                targetY = MathUtils.random((60 - coop.getStartY()) * 32 + coop.getHeight() * 32, coop.getStartY() * 32);
            }
        } else if (coop == null) {
            if (isOut) {
                targetX = MathUtils.random(barn.getStartX() * 32, barn.getStartX() * 32 + barn.getWidth() * 32);
                targetY = MathUtils.random((60 - barn.getStartY()) * 32 + barn.getHeight() * 32, barn.getStartX() * 32);
            }
        } else {
            targetX = MathUtils.random(minX, maxX);
            targetY = MathUtils.random(minY, maxY);
        }
        // decide once—don’t change until this target is reached
        float dx = Math.abs(targetX - x);
        float dy = Math.abs(targetY - y);
        moveHorizontalFirst = dx >= dy;
    }

    public void pet() {
        petToday = true;
        friendship = (Math.min(friendship + 15, 1000));
        GameMenu.printResult("Animal petted successfully!");
    }

    public void feed() {
        if (App.getCurrentGame().getCurrentPlayer().getWield().getName().equals("hay")) {
            Item hay = Item.findItemByName("hay", App.getCurrentGame().getCurrentPlayer().getBackPack().getItems());
            if (hay != null && hay.getCount() > 0) {
                hay.setCount(hay.getCount() - 1);
                fedToday = true;
                friendship = (Math.min(friendship + 10, 1000));
                GameMenu.printResult("Animal fed successfully!");
                state = State.EATING;
                eatTimer = 6f;
                changedFeedState = true;
            } else {
                GameMenu.printResult("Not enough hay!");
            }
        }
    }

    public void shepherdAnimals(){
        Player player = App.getCurrentGame().getCurrentPlayer();
        Tile[][] tiles = player.getMap().getTiles();
        Weather w = App.getCurrentGame().getCurrentWeather();
        if (!this.isOut()) {
            if (w.equals(Weather.RAIN) || w.equals(Weather.SNOW) || w.equals(Weather.STORM)) {
                GameMenu.printResult("Weather is not great for sheperding animal!");
                return;
            }
            this.setFedToday(true);
            this.setOut(true);
            this.setFriendship(Math.min(this.getFriendship() + 8, 1000));
            state = State.WANDERING;
            if (barn == null) {
                x = coop.getStartX() * 32; y = coop.getStartY() * 32;
            } else if (coop == null) {
                x = barn.getStartX() * 32; y = barn.getStartY() * 32;
            }
            GameMenu.printResult("Animal is out!");
        } else {
            isOut = false;
            GameMenu.printResult("Animal back to safety!");
            x = Gdx.graphics.getWidth() / 2f;
            y = Gdx.graphics.getHeight() / 2f;
        }
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    public boolean isHovered() {
        return hovered;
    }

    public Rectangle getRect() {
        rect.setPosition(x, y);
        return rect;
    }
}
