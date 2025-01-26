package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;


public abstract class GameState implements GameLoopable {
    protected GameObjectList gameObjectList;
    protected FitViewport viewport;
    protected SpriteBatch spriteBatch;

    protected GameState()
    {

    }
    @Override
    public void create() {
        gameObjectList = new GameObjectList();
        viewport = new FitViewport(1920, 1080);
    }


    public void resize(int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }


    @Override
    public void input()
    {
        gameObjectList.input();
    }

    @Override
    public void logic()
    {   ;
        gameObjectList.logic();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {


    }


}
