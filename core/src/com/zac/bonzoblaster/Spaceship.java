package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Zac on 7/13/2016.
 */
public class Spaceship {
    private final int shotModifier;
    private float SHOT_Y_CONSTANT;
    protected final ShotManager shotManager;

    protected AnimatedSprite spaceshipSprite;
    protected AnimatedSprite spaceshipShotSprite;
    private float SHIP_SPEED = 300;
    private float timeSinceLastShot;
    private Sound laser = Gdx.audio.newSound(Gdx.files.internal("pew.wav"));

    protected ArtificialIntelligence enemyAI;

    public Spaceship(AnimatedSprite spaceshipSprite, AnimatedSprite spaceshipShotSprite, PlayerType playerCharacter) {

        this.spaceshipSprite = spaceshipSprite;
        this.shotManager = new ShotManager(spaceshipShotSprite);
        this.spaceshipShotSprite = spaceshipShotSprite;
        this.shotModifier = playerCharacter.horizontalModifier;
        this.SHOT_Y_CONSTANT = playerCharacter.horizontalOffset;

        if(playerCharacter == PlayerType.NON_PLAYER_CHARACTER){
            enemyAI = new ArtificialIntelligence(this);
        }
    }




    public void fireShot(float x) {
        System.out.println("I'm charging my laser beams");
          if(shotManager.canFireShot()){
              System.out.println("I can fire a shot)");
              AnimatedSprite newShot = new AnimatedSprite(spaceshipShotSprite);
              Shot shot = new Shot(newShot);

              shot.sprite.setPosition(x + 7, SHOT_Y_CONSTANT);
              shot.sprite.setVelocity(new Vector2(0,shot.SHOT_SPEED*shotModifier));

              shotManager.add(shot);

              laser.play();
              timeSinceLastShot = 0f;
          }
        else{
              System.out.println("I can't shoot");
          }
    }


}
