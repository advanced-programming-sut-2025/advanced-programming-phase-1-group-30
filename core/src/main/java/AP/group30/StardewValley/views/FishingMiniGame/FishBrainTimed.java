package AP.group30.StardewValley.views.FishingMiniGame;

import com.badlogic.gdx.math.MathUtils;

public class FishBrainTimed {
    private final FishState state;
    private final FishMove[] moves;
    private FishMove currentMove;
    private float timeLeft;

    private float blendFactor = 0f;
    private float oldY;

    public FishBrainTimed(FishState state) {
        this.state = state;
        this.moves = new FishMove[] {
            FishMove.COS_SOFT,
            FishMove.COS_HARD,
            FishMove.EASE_TO_TARGET,
            FishMove.ZIGZAG,
            FishMove.JITTER,
            FishMove.BOUNCE
        };
        pickNext();
    }

    private void pickNext() {
        currentMove = moves[state.random.nextInt(moves.length)];
        timeLeft = MathUtils.random(1f, 2f);
    }

    public float update(float delta) {
        timeLeft -= delta;
        if (timeLeft <= 0) {
            oldY = state.y;
            FishMove nextMove = moves[state.random.nextInt(moves.length)];
            blendFactor = 0f;
            timeLeft = MathUtils.random(1f, 2f);

            currentMove = nextMove;
        }

        float targetY = currentMove.update(state, delta);

        if (blendFactor < 1f) {
            blendFactor += delta;
            state.y = MathUtils.lerp(oldY, targetY, blendFactor);
        } else {
            state.y = targetY;
        }

        return state.y;
    }
}
