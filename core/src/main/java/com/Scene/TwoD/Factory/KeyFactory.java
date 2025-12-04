package com.Scene.TwoD.Factory;

import com.Scene.TwoD.Object.IdentificationVideo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;


import java.io.FileNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class KeyFactory {
    Map<String, IdentificationVideo> keysEnds;
   List<Character> partKey;
    String key;
    EndingFactory endingFactory;
    public KeyFactory() {
        keysEnds = new HashMap<>();
        partKey = new ArrayList<>();
        keysEnds.put("AAAAAAA", new IdentificationVideo(Gdx.files.internal("videos/turb.webm"),false));
        keysEnds.put("BBBACCA", new IdentificationVideo(Gdx.files.internal("videos/ytr81sonya69e07d.webm"),false));
        keysEnds.put("BBBBBBB", new IdentificationVideo(Gdx.files.internal("videos/CoreGameplay.webm"),false));
        keysEnds.put("BCCCCCC", new IdentificationVideo(Gdx.files.internal("videos/0817 (1).webm"),true)); //финальная
    }
    public void acceptKeyPart(char part) {
        partKey.add(part);
    }
    public void deleteKeyPart() {
        partKey.remove(partKey.size()-1);
    }
    public void playEnd() {
        key = partKey.stream().map(String ::valueOf).collect(Collectors.joining());
        if(keysEnds.get(key) !=null) {
            try {
               endingFactory = new EndingFactory(keysEnds.get(key).getFileHandle(),keysEnds.get(key).isTrueEnding());
                partKey.clear();
            }
                catch (FileNotFoundException ex) {
                    ex.getStackTrace();
                }
        }
            else {
                try {

                  endingFactory =  new EndingFactory(Gdx.files.internal("videos/final.webm"),false);

                  partKey.clear();

                }
                        catch(FileNotFoundException ex) {
                            ex.getStackTrace();
                    }
        }
    }
    public EndingFactory getEndingFactory() {
        return endingFactory;
    }
    public String getKey() {
        return key;
    }
}
