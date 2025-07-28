package AP.group30.StardewValley.views.FishingMiniGame;

import com.badlogic.gdx.math.MathUtils;

public interface FishMove {
    float update(FishState state, float delta);

    FishMove COS_SOFT = (state, delta) -> {
        state.time +=delta;
        float range = (state.maxY - state.minY - state.size);
        float center = state.minY;
        float speed = 0.5f;
        float normalizedCos = (-MathUtils.cos(state.time * speed) + 1f) / 2f;
        state.y = center + normalizedCos * range;

        return state.y;
    };

    FishMove COS_HARD = (state, delta) -> {
        state.time +=delta;
        float range = (state.maxY - state.minY - state.size);
        float center = state.minY;
        float speed = 1f;
        float normalizedCos = (-MathUtils.cos(state.time * speed) + 1f) / 2f;
        state.y = center + normalizedCos * range;

        return state.y;
    };

    FishMove EASE_TO_TARGET = (state, delta) -> {
        if (Math.abs(state.y - state.targetY) < 2f ||
            state.targetY == 0f) {
            state.targetY = MathUtils.random(state.minY, state.maxY - state.size);
        }

        float speed = 1f;
        state.y += (state.targetY - state.y) * speed * delta;
        state.y = MathUtils.clamp(state.y, state.minY, state.maxY - state.size);

        return state.y;
    };

    FishMove ZIGZAG = (state, delta) -> {
        state.time +=delta;
        float period = 1f;
        float phase = (state.time % period) / period;
        float speed = 250f;

        if (phase < 0.5f) state.ySpeed = speed;
        else state.ySpeed = -speed;

        state.y += state.ySpeed * delta;
        state.y = MathUtils.clamp(state.y, state.minY, state.maxY - state.size);

        return state.y;
    };

    FishMove JITTER = (state, delta) -> {
        float amp = 40f;
        state.y += MathUtils.random(-amp, amp) * delta * 10f;
        state.y = MathUtils.clamp(state.y, state.minY, state.maxY - state.size);

        return state.y;
    };

    FishMove BOUNCE = (state, delta) -> {
        float gravity = -400f;
        float bounce = 250f;

        state.ySpeed += gravity * delta;
        state.y += state.ySpeed * delta;

        if (state.y < state.minY) {
            state.y = state.minY;
            state.ySpeed = bounce;
        } else if (state.y > state.maxY - state.size) {
            state.y = state.maxY - state.size;
            state.ySpeed = -bounce;
        }

        return state.y;
    };
}
