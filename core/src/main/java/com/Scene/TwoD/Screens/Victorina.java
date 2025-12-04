package com.Scene.TwoD.Screens;

import com.Scene.TwoD.Factory.*;
import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;


import java.util.ArrayList;
import java.util.List;

public class Victorina implements Screen {
    private GameCore game;
    private StageFactory stage;
    private SkinFactory skin;
    private FontFactory font;
    private BitmapFont bitmapFont;
    private StageManager stageManager;
    private Table table;
    private AnswerFactory answerFactory;
    private InputFactory inputFactory;
    private KeyFactory keyFactory;
    private LabelFactory labelFactory;

    private List<TextButton> factoryButtonList;
    private List<TextButton> buttonList;
    int idStage;
    int step;
    int answeredQuestions;

    public Victorina(GameCore game) {
        this.game = game;
    }
    @Override
    public void show() {
         idStage =0;
         step = 1;
         answeredQuestions = 0;
        font = new FontFactory();
        bitmapFont = font.fontCache(128);
        bitmapFont.getData().setScale(0.3f);
        stage = new StageFactory(game);
        skin = new SkinFactory(game,"UI/button/Final-UI.json","UI/button/Final-UI.atlas",bitmapFont);
        stageManager = new StageManager();
        keyFactory = game.getKeyFactory();
        table = new Table();
        inputFactory = new InputFactory(game);
        answerFactory = new AnswerFactory(skin.getSkin());
        table.setFillParent(false);
        createUI();


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f,0.25f,0.25f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);
        stage.getStage().draw();
        inputFactory.inputProcess();
    }
    public void update(float delta) {

        stage.getStage().act();
    }

    @Override
    public void resize(int width, int height) {
        stage.getStage().getViewport().update(width,height,true);

    }
    public void createUI() {
        buttonList = new ArrayList<>();
       factoryButtonList = answerFactory.getListAnswerById(idStage);
        Label theme = new Label(stageManager.getStageById(idStage).getTheme(), skin.getSkin(),"default");
        theme.setAlignment(Align.center);

        Label number = new Label(String.valueOf(step ) + "/" + stageManager.getStage().size(), skin.getSkin(),"default");

        Label question = new Label(stageManager.getStageById(idStage).getQuestion(), skin.getSkin(),"default");
        question.setWrap(true);
        question.setAlignment(Align.center);
        TextButton Back = new TextButton("<", skin.getSkin(),"default");





        buttonList.add(factoryButtonList.get(0));


        buttonList.add(factoryButtonList.get(1));


        buttonList.add(factoryButtonList.get(2));


        Back.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event,float x,float y) {
                if( idStage > 0) {
                    idStage--;
                    step--;
                    answeredQuestions --;
                    question.setText(stageManager.getStageById(idStage).getQuestion());
                    theme.setText(stageManager.getStageById(idStage).getTheme());


                        buttonList = answerFactory.updateListAnswer(idStage, buttonList);

                    number.setText(String.valueOf(step ) +"/" + stageManager.getStage().size());
                    keyFactory.deleteKeyPart();
                }
                else {
                    game.setScreen(game.getMain());
                    System.out.println("problem");

                }
            }
        });
        buttonList.get(0).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event,float x,float y) {
                if(answeredQuestions != stageManager.getStage().size() - 1) {
                    System.out.println(answeredQuestions);
                    idStage++;
                    step++;
                    answeredQuestions++;
                    question.setText(stageManager.getStageById(answeredQuestions).getQuestion());
                    theme.setText(stageManager.getStageById(answeredQuestions).getTheme());

                        answerFactory.updateListAnswer(answeredQuestions, buttonList);


                    number.setText(String.valueOf(step) +"/" + stageManager.getStage().size());



                        keyFactory.acceptKeyPart('A');


                }
                else {
                    keyFactory.acceptKeyPart('A');
                    game.setScreen(game.getResult());
                    game.setKeyFactory(keyFactory);
                }
            }
        });
        buttonList.get(1).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event,float x,float y) {
                if(idStage != stageManager.getStage().size() - 1) {

                    idStage++;
                    step++;
                    answeredQuestions++;
                    question.setText(stageManager.getStageById(idStage).getQuestion());
                    theme.setText(stageManager.getStageById(idStage).getTheme());

                        buttonList = answerFactory.updateListAnswer(idStage, buttonList);

                    number.setText(String.valueOf(step) +"/" + stageManager.getStage().size());

                        keyFactory.acceptKeyPart('B');

                }
                else {
                    keyFactory.acceptKeyPart('B');
                    game.setScreen(game.getResult());


                   game.setKeyFactory(keyFactory);
                }
            }
        });
        buttonList.get(2).addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event,float x,float y) {
                if(idStage != stageManager.getStage().size() - 1) {
                    idStage++;
                    step++;
                    answeredQuestions++;
                    question.setText(stageManager.getStageById(idStage).getQuestion());
                    theme.setText(stageManager.getStageById(idStage).getTheme());
                    number.setText(String.valueOf(step) +"/" + stageManager.getStage().size());
                    buttonList = answerFactory.updateListAnswer(idStage, buttonList);


                       game.getKeyFactory().acceptKeyPart('C');

                }
                else {
                    keyFactory.acceptKeyPart('C');
                    game.setScreen(game.getResult());

                    game.setKeyFactory(keyFactory);
                }
            }
        });
        table.add(Back).left();
        table.add(theme).expandX().fillX();
        table.add(number).right();

        stage.getTable().add(table).fillX().top();
        stage.getTable().row();
        stage.getTable().add(question).expand().fill();
        stage.getTable().row();
        stage.getTable().add(buttonList.get(0)).bottom().fillX();
        stage.getTable().row();
        stage.getTable().add(buttonList.get(1)).bottom().fillX();
        stage.getTable().row();
        stage.getTable().add(buttonList.get(2)).bottom().fillX();
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
        font.dispose();
    }
}
