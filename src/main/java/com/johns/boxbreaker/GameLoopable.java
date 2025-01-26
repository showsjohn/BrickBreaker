package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameLoopable {


    public boolean isDestroyed();
    public void destroy();
    public void create();

    public default void render(SpriteBatch spriteBatch)
    {
        input();
        logic();
        draw(spriteBatch);
    }
    public void input();

    public void logic();

    public void draw(SpriteBatch spriteBatch);
}
