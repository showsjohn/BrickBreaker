package com.johns.boxbreaker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseGameObject implements GameLoopable
{
    float speed;
    float deltaTime;
    boolean isDestroyed = false;

    @Override
    public boolean isDestroyed() {
        return isDestroyed;
    }

    @Override
    public void destroy()
    {
        isDestroyed = true;
    }

    @Override
    public void create() {

    }

    @Override
    public void input() {

    }

    @Override
    public void logic() {
        deltaTime = Gdx.graphics.getDeltaTime();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {

    }
}
