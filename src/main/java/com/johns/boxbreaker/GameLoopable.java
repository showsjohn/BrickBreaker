package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameLoopable {

    public void input();

    public void update();

    public void draw(SpriteBatch spriteBatch);
}
