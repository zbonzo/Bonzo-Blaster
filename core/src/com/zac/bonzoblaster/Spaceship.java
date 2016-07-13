package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Zac on 7/13/2016.
 */
public class Spaceship {
    private Vector2 velocity;
    protected Sprite sprite;
    private float SHIP_SPEED = 300f;

    public Spaceship(Sprite spaceshipSprite, int i, int i1) {

        this.sprite = spaceshipSprite;

    }

    public void move(int accelY) {

        velocity = new Vector2(SHIP_SPEED * accelY, 0);
        int xMovement = (int) (velocity.x * Gdx.graphics.getDeltaTime());
        int yMovement = (int) (velocity.y * Gdx.graphics.getDeltaTime());
        sprite.setPosition(sprite.getX() + xMovement, sprite.getY() + yMovement);

        if(sprite.getX() < 0){
            sprite.setX(0);
            //velocity.x = 0;
        }

        if(sprite.getX() + sprite.getWidth() > Gdx.graphics.getWidth()){
            sprite.setX(Gdx.graphics.getWidth() - sprite.getWidth());
            //velocity.x = 0;
        }

    }


}
