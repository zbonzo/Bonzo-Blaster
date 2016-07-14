package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Zac on 7/13/2016.
 */
public class Spaceship {
    private static final float SHOT_Y_CONSTANT = 190;
    protected final ShotManager shotManager;

    protected AnimatedSprite spaceshipSprite;
    protected AnimatedSprite spaceshipShotSprite;
    private float SHIP_SPEED = 300;
    private float timeSinceLastShot;

    public Spaceship(AnimatedSprite spaceshipSprite, AnimatedSprite spaceshipShotSprite) {

        this.spaceshipSprite = spaceshipSprite;
        this.shotManager = new ShotManager(spaceshipShotSprite);
        this.spaceshipShotSprite = spaceshipShotSprite;

    }




    public void fireShot(float x) {
        System.out.println("I'm charging my laser beams");
          if(shotManager.canFireShot()){
              System.out.println("I can fire a shot)");
              AnimatedSprite newShot = new AnimatedSprite(spaceshipShotSprite);
              Shot shot = new Shot(newShot);

              shot.sprite.setPosition(x, SHOT_Y_CONSTANT);
              shot.sprite.setVelocity(new Vector2(0,shot.SHOT_SPEED));

              shotManager.add(newShot);
              timeSinceLastShot = 0f;
          }
    }


}
