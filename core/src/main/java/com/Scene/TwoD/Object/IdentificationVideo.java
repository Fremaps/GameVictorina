package com.Scene.TwoD.Object;

import com.badlogic.gdx.files.FileHandle;

import java.util.logging.FileHandler;

public class IdentificationVideo {
    private FileHandle fileHandle;
    private boolean isTrueEnding;
    public IdentificationVideo() {

    }
        public IdentificationVideo(FileHandle fileHandle, boolean isTrueEnding) {
            this.fileHandle = fileHandle;
            this.isTrueEnding =  isTrueEnding;
        }

    public boolean isTrueEnding() {
        return isTrueEnding;
    }

    public void setTrueEnding(boolean trueEnding) {
        isTrueEnding = trueEnding;
    }

    public FileHandle getFileHandle() {
        return fileHandle;
    }

    public void setFileHandle(FileHandle fileHandle) {
        this.fileHandle = fileHandle;
    }
}
