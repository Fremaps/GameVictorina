package com.Scene.TwoD.Screens;

import com.Scene.TwoD.Factory.FontFactory;
import com.Scene.TwoD.Factory.SkinFactory;
import com.Scene.TwoD.Factory.StageFactory;
import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Disclaimer implements Screen {
    private GameCore game;
    private StageFactory stageFactory;
    private FontFactory fontFactory;
    private Image image;
    private SkinFactory skin;
    private BitmapFont bitmapFont;
    public Disclaimer(GameCore game) {
        this.game = game;
    }
    @Override
    public void show() {
        stageFactory = new StageFactory(game);
        fontFactory = new FontFactory();
        bitmapFont = fontFactory.fontCache(128);
        bitmapFont.getData().setScale(0.3f);

        Texture texture = new Texture(Gdx.files.internal("UI/discleimer/Discleimer.png"));
        image = new Image(texture);

        stageFactory.getTable().add(image).expand().grow();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stageFactory.getStage().draw();
        update(delta);
        input();
    }
    public void update(float delta) {
        stageFactory.getStage().act();
    }
    public void input() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
            game.setScreen(game.getMain());
        }
    }

    @Override
    public void resize(int width, int height) {
        stageFactory.getStage().getViewport().update(width,height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stageFactory.getStage().clear();
    }

    @Override
    public void dispose() {

    }
}
