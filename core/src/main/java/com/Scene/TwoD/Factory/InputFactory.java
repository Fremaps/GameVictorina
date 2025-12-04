package com.Scene.TwoD.Factory;

import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class InputFactory {
    private GameCore game;
    public InputFactory(GameCore game) {
        this.game = game;
    }
    public void inputProcess() {// доработать механику переключение к предыдущему вопросу
        if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            Gdx.app.exit();
        }

    }
}
