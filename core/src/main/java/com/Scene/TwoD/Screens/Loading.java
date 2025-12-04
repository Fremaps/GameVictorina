package com.Scene.TwoD.Screens;

import com.Scene.TwoD.Factory.*;
import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class Loading implements Screen {
    private ProgressBar bar;
    private GameCore game;
    private StageFactory stage;
    private Skin skin;
    private float progressLoad = 0;
    private InputFactory input;
    public Loading(GameCore game) {
        this.game = game;
        input = new InputFactory(game);
    }
    @Override
    public void show() {

        stage = new StageFactory(game);

        skin = new Skin();
        skin.addRegions(new TextureAtlas(Gdx.files.internal("UI/progressBar/progressBar.atlas")));
        skin.load(Gdx.files.internal("UI/progressBar/progressBar.json"));

        requestAssets();
        createProgressBar();

    }

    @Override
    public void render(float delta) {
        progressLoad = MathUtils.lerp(progressLoad,game.getAssetManager().getProgress(),0.1f);
        Gdx.gl.glClearColor(0.25f,0.25f,0.25f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        stage.getStage().draw();




    }

    @Override
    public void resize(int width, int height) {
        stage.getStage().getViewport().update(width, height,true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
    public void update(float delta) {
        stage.getStage().getViewport().apply();
        stage.getStage().act();

        bar.setValue(progressLoad);
        if( game.getAssetManager().update() && progressLoad >= 0.99) {
            game.setScreen(game.getMain());
        }
    }
    public void createProgressBar() {
        bar = new ProgressBar(0,1,0.0001f,false,skin);
        stage.getTable().add(bar).expand().padTop(50).padLeft(75).padRight(75).grow();
    }
    public void requestAssets() {
        game.getAssetManager().load("UI/button/Final-UI.atlas",TextureAtlas.class);
        game.getAssetManager().load("UI/background/Background.atlas",TextureAtlas.class);

    }


    @Override
    public void hide() {
        stage.getStage().clear();
    }

    @Override
    public void dispose() {
        stage.getStage().dispose();


    }
}
