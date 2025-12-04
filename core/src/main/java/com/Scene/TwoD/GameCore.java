package com.Scene.TwoD;

import com.Scene.TwoD.Factory.EndingFactory;
import com.Scene.TwoD.Factory.KeyFactory;
import com.Scene.TwoD.Screens.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameCore extends Game {
    private Loading loading;
    private Victorina victorina;
    private Main main;
    private Result result;
    private KeyFactory keyFactory;
    private Disclaimer disclaimer;
    private OrthographicCamera camera;
    public AssetManager assetManager;
    private BitmapFont font;
    private int width,height;


    public KeyFactory getKeyFactory() {
        return keyFactory;
    }

    public void setKeyFactory(KeyFactory keyFactory) {
        this.keyFactory = keyFactory;
    }

    @Override
    public void create() {

        width = Gdx.graphics.getWidth()/2;
        height = Gdx.graphics.getHeight()/2;
        camera = new OrthographicCamera(width,height);
        assetManager = new AssetManager();
        loading = new Loading(this);
        victorina = new Victorina(this);
        main = new Main(this);
        result = new Result(this);
        disclaimer = new Disclaimer(this);
        keyFactory = new KeyFactory();
        setScreen(loading);

    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        assetManager.dispose();
        font.dispose();

    }

    public Loading getLoading() {
        return loading;
    }



    public Main getMain() {
        return main;
    }

    public Result getEnd() {
        return result;
    }
    public Result getResult() {
        return result;
    }

    public Victorina getVictorina() {
        return victorina;
    }

    public Disclaimer getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(Disclaimer disclaimer) {
        this.disclaimer = disclaimer;
    }

    public int getWidth() {
        return ConstantParameter.WIDTH;
    }

    public int getHeight() {
        return ConstantParameter.HEIGHT;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public BitmapFont getFont() {
        return font;
    }

    public void setFont(BitmapFont font) {
        this.font = font;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
}
