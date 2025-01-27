package com.johns.boxbreaker;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Main implements ApplicationListener {
    public static GameStateManager gameStateManager;
    SpriteBatch spriteBatch;
    FitViewport viewport;
    boolean gameOn = false;
    Texture startGame;

    @Override
    public void create() {

        spriteBatch = new SpriteBatch();


        // Create GameState and GameStateManager and set the current GameState
        gameStateManager = new GameStateManager();
        PlayingState playingState = new PlayingState();
        gameStateManager.AddGameState("PlayingState", playingState);
        gameStateManager.SwitchTo("PlayingState");
        gameStateManager.create();

        startGame = new Texture(Gdx.files.internal("assets/sprites/message.png"));
    }

    @Override
    public void resize(int width, int height) {
        gameStateManager.resize(width, height); // true centers the camera
    }


    @Override
    public void render() {
        // organize code into three methods

        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
        {
            Gdx.app.exit();
        }

        if (!gameOn)
        {
            spriteBatch.begin();
            spriteBatch.draw(startGame, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            spriteBatch.end();
        }

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER))
        {
            gameOn = true;
        }




        if(gameOn)
        {
            gameStateManager.render(spriteBatch);
        }


    }


    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void dispose() {}
}
