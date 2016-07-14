package com.zac.bonzoblaster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Zac on 7/13/2016.
 */
public class GameScreen implements Screen {

    final BonzoBlaster game;
    private final AnimatedSprite spaceshipShotSprite;

    //    public static final int SCREEN_HEIGHT = 1000;
    //SpriteBatch batch;
    private AnimatedSprite spaceshipSprite;
    private Texture background;
    private OrthographicCamera camera;
    private Spaceship playerSpaceship;

    private ShotManager shotManager;
    private Music gameMusic;
    //private Enemy enemy;


//    private CollisionManager collisionManager;

//    private boolean isGameOver = false;

    public GameScreen(BonzoBlaster game) {
    this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000,600);

        //batch = new SpriteBatch();
        //batch = game.batch;

        background = new Texture(Gdx.files.internal("spacebackground.png"));
        Texture spaceshipTexture = new Texture(Gdx.files.internal("spritesheet.png"));

        Texture spaceshipShotTexture = new Texture(Gdx.files.internal("pewpew.png"));


        spaceshipSprite = new AnimatedSprite(spaceshipTexture,2,2);
        spaceshipShotSprite = new AnimatedSprite(spaceshipShotTexture,2,2);

        playerSpaceship = new Spaceship(spaceshipSprite,spaceshipShotSprite);
        playerSpaceship.spaceshipSprite.setPosition(Gdx.graphics.getWidth()/2,0);


//        Texture enemyShotTexture = new Texture(Gdx.files.internal("enemyshotsheet.png"));
//        shotManager = new ShotManager(shotTexture, enemyShotTexture);
//
//        Texture enemyTexture = new Texture(Gdx.files.internal("enemysheet.png"));
//        enemy = new Enemy(enemyTexture, shotManager);


//        collisionManager = new CollisionManager(spaceshipAnimated,enemy,shotManager);

        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("bgmusic.wav"));
        gameMusic.setVolume(.25f);
        gameMusic.setLooping(true);
        gameMusic.play();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        game.batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        playerSpaceship.spaceshipSprite.draw(game.batch);

        int accelY = (int) Gdx.input.getAccelerometerY();

        playerSpaceship.spaceshipSprite.move(200,0,accelY);
        playerSpaceship.shotManager.update();
        playerSpaceship.shotManager.draw(game.batch);

        if(Gdx.input.isTouched()){
            System.out.println("I'm being touched");
            playerSpaceship.fireShot(playerSpaceship.spaceshipSprite.getX());
        }

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        game.batch.dispose();
        background.dispose();

    }
}
