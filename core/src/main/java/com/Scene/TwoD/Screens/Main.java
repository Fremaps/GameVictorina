package com.Scene.TwoD.Screens;

import com.Scene.TwoD.Factory.FontFactory;
import com.Scene.TwoD.Factory.SkinFactory;
import com.Scene.TwoD.Factory.StageFactory;
import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.ray3k.tenpatch.TenPatchDrawable;

public class Main implements Screen {
    private GameCore game;
    private StageFactory stage,stageBackground;
    private FontFactory font;
    private BitmapFont bitmapFont;
    private SkinFactory skin,skinBackground;
    private TextButton buttonPlay;
    private TextButton buttonBack;
    private Label.LabelStyle labelStyle;
    private TenPatchDrawable tenPatchDrawable;
    private Image image;
    private Label label;
    private Table table;



    public Main(GameCore game) {
        this.game = game;
    }
    @Override
    public void show() {
        font = new FontFactory();
        bitmapFont = font.fontCache(128);
        bitmapFont.getData().setScale(0.3f);
        stage = new StageFactory(game);

        skin = new SkinFactory(game,"UI/button/Final-UI.json","UI/button/Final-UI.atlas",bitmapFont);
        skinBackground = new SkinFactory(game,"UI/background/Background.json","UI/background/Background.atlas",bitmapFont);
        tenPatchDrawable = skinBackground.getSkin().get("Background", TenPatchDrawable.class);
        tenPatchDrawable.setScale(0.8f);

        image = new Image(tenPatchDrawable);
        image.setScaling(Scaling.stretchX);
        image.setSize(game.getWidth(),game.getHeight());
        labelStyle = new Label.LabelStyle();
        labelStyle.font = font.fontCache(272);
        labelStyle.font.getData().setScale(0.5f);
        label = new Label("Викторина",labelStyle);
        table = new Table();
        table.setFillParent(false);
        createButton();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f,0.25f,0.25f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.getStage().getViewport().apply();
        stage.getStage().draw();
        update(delta);

    }
    public void update(float delta) {

        stage.getStage().act();

    }

    @Override
    public void resize(int width, int height) {

        stage.getStage().getViewport().update(width,height,true);

    }

    @Override
    public void pause() {

    }
    public void createButton() {

            label.addAction(new SequenceAction(Actions.alpha(0), Actions.fadeIn(1f)));
            buttonPlay = new TextButton("              Играть              ", skin.getSkin(), "default");
            buttonPlay.getLabel().setAlignment(Align.center);
            buttonPlay.addAction(new SequenceAction(Actions.alpha(0), Actions.moveBy(0, -20),
                new ParallelAction(Actions.moveBy(0, 20, 1.5f, Interpolation.pow2), Actions.fadeIn(1f, Interpolation.pow2))));
            buttonPlay.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    game.setScreen(game.getVictorina());
                }
            });

            buttonBack = new TextButton("              Выход               ", skin.getSkin(), "default");
            buttonBack.getLabel().setAlignment(Align.center);
            buttonBack.addAction(new SequenceAction(Actions.alpha(0), Actions.moveBy(0, -20),
                new ParallelAction(Actions.moveBy(0, 20, 1.5f, Interpolation.pow2), Actions.fadeIn(1f, Interpolation.pow2))));
            buttonBack.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    Gdx.app.exit();
                }
            });
            table.add(label).expand().center().top();
            stage.getTable().setBackground(image.getDrawable());

            stage.getTable().add(table).fillX().top();
            stage.getTable().row();
            stage.getTable().add(buttonPlay).center().height(120).pad(25).expand();
            stage.getTable().row();
            stage.getTable().add(buttonBack).center().height(120).pad(25);

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

    }
}
