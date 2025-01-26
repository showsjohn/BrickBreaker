package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Dictionary;


public abstract class GameState implements GameLoopable {
    protected GameObjectList gameObjectList;
    protected FitViewport viewport;


    protected GameState()
    {

    }
    @Override
    public void create() {
        gameObjectList = new GameObjectList();
        gameObjectList.getClass();
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
