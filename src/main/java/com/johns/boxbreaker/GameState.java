package com.johns.boxbreaker;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;


public abstract class GameState {
    protected GameObjectList gameObjectList;
    protected StretchViewport viewport;


    protected GameState()
    {

    }

    public void create() {
        gameObjectList = new GameObjectList();
        viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    public void resize(int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }



    public void input()
    {
        gameObjectList.input();
    }


    public void logic()
    {   ;
        gameObjectList.logic();
    }


    public void draw(SpriteBatch spriteBatch) {
    }

}
