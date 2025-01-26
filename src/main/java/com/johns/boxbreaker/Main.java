package com.johns.boxbreaker;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main implements ApplicationListener {
    public static GameStateManager gameStateManager;
    SpriteBatch spriteBatch;
    FitViewport viewport;
    //Sound dropSound;
    //Music music;


    @Override
    public void create() {

        spriteBatch = new SpriteBatch();

        // Create GameState and GameStateManager and set the current GameState
        gameStateManager = new GameStateManager();
        PlayingState playingState = new PlayingState();
        gameStateManager.AddGameState("PlayingState", playingState);
        gameStateManager.SwitchTo("PlayingState");
        gameStateManager.create();
    }

    @Override
    public void resize(int width, int height) {
        gameStateManager.resize(width, height); // true centers the camera
    }


    @Override
    public void render() {
        // organize code into three methods
       gameStateManager.render(spriteBatch);
    }


    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}
}
