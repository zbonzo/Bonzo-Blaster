package com.zac.bonzoblaster;

import java.util.Random;

/**
 * Created by Zac on 7/15/2016.
 */
public class ArtificialIntelligence {
    private final Spaceship spaceship;
    private int moveY;
    private int moveSpeed = 150;

    public ArtificialIntelligence(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public void takeAction(){
        if(shouldChangeDirection()){
            changeDirection();
        }

        if(shouldFire()){
            spaceship.fireShot(spaceship.spaceshipSprite.getX());
        }
        spaceship.spaceshipSprite.move(0,moveY,moveSpeed);
    }

    private boolean shouldFire() {
        Random random = new Random();
        return random.nextInt(51) == 0;
    }

    private void changeDirection() {
        moveY *= -1;
    }

    private boolean shouldChangeDirection() {
        Random random = new Random();
        return random.nextInt(21) == 0;


    }
}
