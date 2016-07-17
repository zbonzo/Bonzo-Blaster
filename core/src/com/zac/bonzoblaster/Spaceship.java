package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Zac on 7/13/2016.
 */
public class Spaceship {
    private final int horizontalShotModifier;
    private float SHOT_X_CONSTANT;
    private float SHOT_Y_CONSTANT;
    protected final ShotManager shotManager;

    protected AnimatedSprite spaceshipSprite;
    protected AnimatedSprite spaceshipShotSprite;
    private float SHIP_SPEED = 300;
    private Sound laser = Gdx.audio.newSound(Gdx.files.internal("pew.wav"));
    private Sound explosion = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));
    protected int spaceShipID = 0;
    private static int spaceShipCounter;
    private PlayerType playerType;

    protected ArtificialIntelligence enemyAI;

    public Spaceship(AnimatedSprite spaceshipSprite, AnimatedSprite spaceshipShotSprite, PlayerType playerCharacter) {

        this.spaceshipSprite = spaceshipSprite;
        this.shotManager = new ShotManager(spaceshipShotSprite);
        this.spaceshipShotSprite = spaceshipShotSprite;
        this.horizontalShotModifier = playerCharacter.horizontalModifier;
        this.SHOT_X_CONSTANT = playerCharacter.verticalOffset;
        this.SHOT_Y_CONSTANT = playerCharacter.horizontalOffset;
        this.playerType = playerCharacter;


        this.spaceShipID = spaceShipCounter++;
        if(playerCharacter == PlayerType.NON_PLAYER_CHARACTER){
            enemyAI = new ArtificialIntelligence(this);
        }
    }




    public void fireShot(float x) {

          if(shotManager.canFireShot()){

              AnimatedSprite newShot = new AnimatedSprite(spaceshipShotSprite, horizontalShotModifier);
              Shot shot = new Shot(newShot);

              shot.sprite.setPosition(x + SHOT_X_CONSTANT, SHOT_Y_CONSTANT);
              shot.sprite.setVelocity(new Vector2(0,shot.SHOT_SPEED* horizontalShotModifier));


              shotManager.add(shot);

              laser.play();

          }

    }

    public void hit(Spaceship spaceship) {
        spaceship.spaceshipSprite.setDead(true);
        explosion.play();

        if(playerType == PlayerType.NON_PLAYER_CHARACTER){
            //Do NPC Death
        }else if(playerType == PlayerType.PLAYER_CHARACTER){
            //Do PC Death
        }

    }




}
