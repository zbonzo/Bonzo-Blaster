package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Zac on 7/13/2016.
 */
public class AnimatedSprite extends Sprite {
    private final int FRAMES_ROW;
    private final int FRAMES_COL;
    private final Texture texture;
    private int yModifier;

    private Animation animation;
    private TextureRegion[] frames;
    private TextureRegion currentFrame;

    private float stateTime;
    private Vector2 velocity;
    private boolean dead = false;
    //private boolean isDead = false;

    public AnimatedSprite(AnimatedSprite sprite) {

        this(sprite.getTexture(), sprite.FRAMES_ROW, sprite.FRAMES_COL);
    }

    public AnimatedSprite(Texture texture, Integer rows, Integer columns) {
        super(texture, 0, 0, texture.getWidth() / rows, texture.getHeight() / columns);

        this.texture = texture;
        FRAMES_ROW = rows;
        FRAMES_COL = columns;

        TextureRegion[][] temp = TextureRegion.split(texture, texture.getWidth() / FRAMES_COL, texture.getHeight() / FRAMES_ROW);


        frames = new TextureRegion[FRAMES_COL * FRAMES_ROW];
        int index = 0;
        for (int i = 0; i < FRAMES_ROW; i++) {
            for (int j = 0; j < FRAMES_COL; j++) {
                frames[index++] = temp[i][j];
            }
        }


        animation = new Animation(0.1f, frames);
        stateTime = 0f;

    }

    public AnimatedSprite(AnimatedSprite spaceshipShotSprite, int shotModifier) {
        this(spaceshipShotSprite);
        this.yModifier = shotModifier;
    }

    public void draw(Batch batch) {
        stateTime += Gdx.graphics.getDeltaTime();
        currentFrame = animation.getKeyFrame(stateTime, true);

        batch.draw(currentFrame, getX(), getY());

    }

    public void setPosition(float x, float y) {
        super.setPosition(x, y);
    }


    public float getWidth() {
        return super.getWidth() / FRAMES_COL;
    }

    public float getX() {
        return super.getX();
    }



    public float getY() {
        return super.getY();
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(getX(),getY(),getWidth(),getHeight());
    }

    public void setVelocity(Vector2 velocity) {

        this.velocity = velocity;
    }

    public Vector2 getVelocity(){
        return this.velocity;
    }

    public void move(int moveX, int moveY, int speed) {


        velocity = new Vector2(moveX * speed, moveY * speed * yModifier);
        int xMovement = (int) (velocity.x * Gdx.graphics.getDeltaTime());
        int yMovement = (int) (velocity.y * Gdx.graphics.getDeltaTime());
        setPosition(getX() + xMovement, getY() + yMovement);


        if (getX() < 0) {
            setX(0);
        }

        if (getX() + getWidth() > Gdx.graphics.getWidth()) {
            setX(Gdx.graphics.getWidth() - getWidth());

        }


    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
