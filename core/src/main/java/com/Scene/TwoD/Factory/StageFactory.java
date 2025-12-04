package com.Scene.TwoD.Factory;

import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ExtendViewport;


import java.util.HashMap;
import java.util.Map;

public class StageFactory {
    private GameCore game;
    private Stage stage;
    private Table table;
    private Map<Integer,Table> listTable;
    public StageFactory(GameCore game) {
        listTable = new HashMap<>();
        stage = new Stage(new ExtendViewport(game.getWidth(),game.getHeight(),game.getCamera()));
        Gdx.input.setInputProcessor(stage);
        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
    }

    public Stage getStage() {
        return stage;
    }
    public Table getTable() {
        return table;
    }

}
