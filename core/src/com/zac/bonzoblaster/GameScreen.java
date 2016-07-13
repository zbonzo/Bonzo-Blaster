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

//    public static final int SCREEN_HEIGHT = 1000;
    SpriteBatch batch;
    private Sprite spaceshipSprite;
    private Texture background;
    private OrthographicCamera camera;
    private AnimatedSprite spaceshipAnimated;
   // private ShotManager shotManager;
    private Music gameMusic;
    //private Enemy enemy;


//    private CollisionManager collisionManager;

//    private boolean isGameOver = false;

    public GameScreen(BonzoBlaster game) {
    this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1000,600);

        batch = new SpriteBatch();

        background = new Texture(Gdx.files.internal("spacebackground.png"));
        Texture spaceshipTexture = new Texture(Gdx.files.internal("spritesheet.png"));

        spaceshipSprite = new Sprite(spaceshipTexture);

        spaceshipAnimated = new AnimatedSprite(spaceshipSprite,2,2);
        spaceshipAnimated.setPosition(Gdx.graphics.getWidth()/2,0);

        Texture shotTexture = new Texture(Gdx.files.internal("pewpew.png"));
        Texture enemyShotTexture = new Texture(Gdx.files.internal("enemyshotsheet.png"));
//        shotManager = new ShotManager(shotTexture, enemyShotTexture);

        Texture enemyTexture = new Texture(Gdx.files.internal("enemysheet.png"));
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

        spaceshipAnimated.draw(game.batch);

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

    }
}
