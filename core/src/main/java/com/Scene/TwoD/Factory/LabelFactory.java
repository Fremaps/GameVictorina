package com.Scene.TwoD.Factory;


import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

public class LabelFactory {
    private Label label;
    private Skin skin;
    private boolean isWrap;
    private String namespace;
    public LabelFactory(Skin skin) {
        this.skin = skin;


    }
    public Label createLabel(String namespace) {
        Label label = new Label(namespace,skin);
       label.setWrap(true);
        label.setAlignment(Align.center);
        return label;
    }
   public void setWrap() {
        label.setWrap(!label.getWrap());
   }
   public void setAlignment(int align) {
        label.setAlignment(align);
   }
   public void setText(String namespace) {
        label.setText(namespace);
   }
   public void setStyle(String style) {
        label.setStyle( new Label(namespace,skin,style).getStyle());
   }
}
