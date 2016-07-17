package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.RandomXS128;

import java.util.Random;

/**
 * Created by Zac on 7/15/2016.
 */
public class ArtificialIntelligence {
    private static final float MINIMUM_TIME_BETWEEN_MOVEMENTS = .2f;
    private final Spaceship spaceship;
    private int moveY = 2;
    private int moveSpeed = 150;
    private static int AICount = 0;
    private int AIID;
    private static RandomXS128 random = new RandomXS128(System.currentTimeMillis());
    private float timeSinceLastMove =0f;


    public ArtificialIntelligence(Spaceship spaceship) {
        this.spaceship = spaceship;
        this.AIID = AICount++;
    }

    public void takeAction(){

        if(shouldChangeDirection()){
            if(canChangeDirection()) {

                changeDirection();
            }
        }

        if(shouldFire()){

            spaceship.fireShot(spaceship.spaceshipSprite.getX());
        }
        spaceship.spaceshipSprite.move(moveSpeed,0,moveY);
        timeSinceLastMove += Gdx.graphics.getDeltaTime();
    }

    private boolean canChangeDirection() {
        return timeSinceLastMove > MINIMUM_TIME_BETWEEN_MOVEMENTS;
    }

    private boolean shouldFire() {

        return random.nextInt(51) == 0;
    }

    private void changeDirection() {
        moveY *= -1;
    }

    private boolean shouldChangeDirection() {

        return random.nextInt(21) == 0;


    }
}
