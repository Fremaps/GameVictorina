package com.Scene.TwoD.Factory;

import com.Scene.TwoD.GameCore;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class SkinFactory {

    private Skin skin;

    public SkinFactory(GameCore game, String pathJSON, String pathAtlas) {
       this(game,pathJSON,pathAtlas,null);
    }
    public SkinFactory(GameCore game, String pathJSON, String pathAtlas, BitmapFont font) {

        skin = new Skin();
        skin.addRegions(game.getAssetManager().get(pathAtlas));

        skin.add("default-font",font);

        skin.load(Gdx.files.internal(pathJSON));
    }
    public Skin getSkin(){
        return skin;
    }
}
