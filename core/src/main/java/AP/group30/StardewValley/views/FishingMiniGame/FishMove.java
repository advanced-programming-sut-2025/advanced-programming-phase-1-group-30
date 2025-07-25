package AP.group30.StardewValley.views.FishingMiniGame;

import com.badlogic.gdx.math.MathUtils;

public interface FishMove {
    float update(FishState state, float delta);

    FishMove COS_SOFT = (s, delta) -> {
        s.time +=delta;
        float range = (s.maxY - s.minY - s.size);
        float center = s.minY;
        float speed = 0.5f;
        float normalizedCos = (-MathUtils.cos(s.time * speed) + 1f) / 2f;
        s.y = center + normalizedCos * range;

        return s.y;
    };

    FishMove COS_HARD = (s, delta) -> {
        s.time +=delta;
        float range = (s.maxY - s.minY - s.size);
        float center = s.minY;
        float speed = 1f;
        float normalizedCos = (-MathUtils.cos(s.time * speed) + 1f) / 2f;
        s.y = center + normalizedCos * range;

        return s.y;
    };

    FishMove EASE_TO_TARGET = (s, delta) -> {
        if (Math.abs(s.y - s.targetY) < 2f ||
            s.targetY == 0f) {
            s.targetY = MathUtils.random(s.minY, s.maxY - s.size);
        }

        float speed = 1f;
        s.y += (s.targetY - s.y) * speed * delta;
        s.y = MathUtils.clamp(s.y, s.minY, s.maxY - s.size);

        return s.y;
    };

    FishMove ZIGZAG = (s, delta) -> {
        s.time +=delta;
        float period = 1f;
        float phase = (s.time % period) / period;
        float speed = 250f;

        if (phase < 0.5f) s.vy = speed;
        else s.vy = -speed;

        s.y += s.vy * delta;
        s.y = MathUtils.clamp(s.y, s.minY, s.maxY - s.size);

        return s.y;
    };

    FishMove JITTER = (s, delta) -> {
        float amp = 40f;
        s.y += MathUtils.random(-amp, amp) * delta * 10f;
        s.y = MathUtils.clamp(s.y, s.minY, s.maxY - s.size);

        return s.y;
    };

    FishMove BOUNCE = (s, delta) -> {
        float gravity = -400f;
        float bounce = 250f;

        s.vy += gravity * delta;
        s.y += s.vy * delta;

        if (s.y < s.minY) {
            s.y = s.minY;
            s.vy = bounce;
        } else if (s.y > s.maxY - s.size) {
            s.y = s.maxY - s.size;
            s.vy = -bounce;
        }

        return s.y;
    };
}
