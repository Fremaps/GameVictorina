package com.Scene.TwoD.Factory;


import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.video.VideoPlayer;
import com.badlogic.gdx.video.VideoPlayerCreator;
import com.badlogic.gdx.video.scenes.scene2d.VideoActor;


import java.io.FileNotFoundException;
import java.util.List;


public class EndingFactory {

    private VideoPlayer player;
    private VideoActor actor;
    private boolean isTrueEnding;
    public EndingFactory(FileHandle video,boolean isTrueEnding) throws FileNotFoundException {
        this.isTrueEnding = isTrueEnding;
        player = VideoPlayerCreator.createVideoPlayer();
        try {
            player.load(video);

            player.setVolume(0.8f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        actor = new VideoActor(player);
    }
    public void runPlayer() {
        player.play();
    }
    public VideoPlayer getVideo() {
        return player;
    }
    public VideoActor getVideoActor() {
        return actor;
    }

    public boolean isTrueEnding() {
        return isTrueEnding;
    }
}
