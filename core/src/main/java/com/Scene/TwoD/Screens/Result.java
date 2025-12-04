package com.Scene.TwoD.Screens;

import com.Scene.TwoD.Factory.*;
import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.video.scenes.scene2d.VideoActor;

import java.security.Key;
import java.util.Map;


public class Result implements Screen {
    private GameCore game;
    private StageFactory stage;
    private EndingFactory end;
    private SpriteBatch batch;
    private EndingFactory video;
    private VideoActor actor;
    private BitmapFont bitmapFont;
    private LabelFactory factory;
    private SkinFactory skin;
    private EndingFactory endingFactory;
    private KeyFactory keyFactory;
    private Table topTable;
    private Label label;
    private boolean v = false;
    public Result(GameCore game) {
        this.game = game;
    }
    @Override
    public void show() {
        stage = new StageFactory(game);
        FontFactory font = new FontFactory();
        bitmapFont = font.fontCache(128);
        bitmapFont.getData().setScale(0.4f);
        skin = new SkinFactory(game,"UI/button/Final-UI.json","UI/button/Final-UI.atlas",bitmapFont);
        factory = new LabelFactory(skin.getSkin());

        keyFactory = game.getKeyFactory();
        keyFactory.playEnd();
        endingFactory = keyFactory.getEndingFactory();
        stage.getTable().add(endingFactory.getVideoActor()).expand().fill();
        endingFactory.runPlayer();

        topTable = new Table();
        topTable.setFillParent(false);

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f,0.25f,0.25f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getStage().draw();
        update(delta);




    }
    public void update(float delta) {
        stage.getStage().act();

        if(!endingFactory.getVideo().isPlaying() && !v) {
            label = factory.createLabel("Подсказка");
            label.setWrap(false);

            TextButton buttonBack = new TextButton("<",skin.getSkin());
            buttonBack.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(game.getMain());
                    v=false;
                }
            });

            stage.getTable().clear();

            if(endingFactory.isTrueEnding()) {
                topTable.add(buttonBack).right();
                topTable.add(label).expand().grow();
                stage.getTable().add(topTable).fillX().top();
                stage.getTable().row();
                stage.getTable().add(factory.createLabel("1.ААААААА\n2.Отвечать только правильно\n3.BBBBBBB\n4.BCCCCCC узбеки спят")).expand().fill().bottom();
                stage.getTable().row();
                stage.getTable().add(factory.createLabel("Каноничная концовка")).fillX().bottom();

            }
            else {
                topTable.add(buttonBack).right();
                topTable.add(label).expand().grow();
                stage.getTable().add(topTable).fillX().top();
                stage.getTable().row();
                stage.getTable().add(factory.createLabel("1.1.ААААААА\n2.Отвечать только правильно\n3.BBBBBBB\n4.BCCCCCC узбеки спят")).expand().fill().bottom();
                stage.getTable().row();
                stage.getTable().add(factory.createLabel("Не каноничная концовка")).fillX().bottom();
            }

           v = true;
        }

    }

    @Override
    public void resize(int width, int height) {

        stage.getStage().getViewport().update(width,height,true);
        if(!v) {
            endingFactory.getVideoActor().setHeight(stage.getTable().getHeight());
            endingFactory.getVideoActor().setWidth(stage.getStage().getWidth());
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        stage.getStage().clear();

    }

    @Override
    public void dispose() {
        stage.getStage().dispose();

        end.getVideo().dispose();
    }
}
