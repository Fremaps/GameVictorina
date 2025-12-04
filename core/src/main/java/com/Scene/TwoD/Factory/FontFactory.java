package com.Scene.TwoD.Factory;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;


import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    FreeTypeFontGenerator generator;
    Map<Integer, BitmapFont> fonts;
    String textFontCharactersSet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
    public FontFactory(){
        generator = new FreeTypeFontGenerator(Gdx.files.internal("font/Determination_RUS.ttf"));
        fonts = new HashMap<>();
    }
    public BitmapFont fontCache(int size) {
        if(!fonts.containsKey(size) ) {
            FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
            parameter.borderColor = Color.BLACK;
            parameter.borderWidth = 6;
            parameter.characters = textFontCharactersSet;
            parameter.size = size;
            fonts.put(size,generator.generateFont(parameter));
        }
        return fonts.get(size);
    }
    public void dispose() {
        for(BitmapFont font : fonts.values()) {
            font.dispose();
        }
        generator.dispose();
    }

}
