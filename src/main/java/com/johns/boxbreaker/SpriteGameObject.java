package com.johns.boxbreaker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SpriteGameObject extends BaseGameObject implements GameLoopable
{
    Sprite sprite;
    public SpriteGameObject(String path)
    {
        sprite = new Sprite(new Texture(path));
        sprite.setSize(1,1);
    }

    @Override
    public void create()
    {

    }

    @Override
    public void input() {

    }

    @Override
    public void logic() {
        super.logic();
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

}
