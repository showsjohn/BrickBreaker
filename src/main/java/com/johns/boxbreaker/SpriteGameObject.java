package com.johns.boxbreaker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class SpriteGameObject extends BaseGameObject implements GameLoopable
{
    Sprite sprite;
    Rectangle boundingBox;
    float scaleFactor;
    public SpriteGameObject(String path)
    {
        sprite = new Sprite(new Texture(Gdx.files.internal(path)));
        sprite.setSize(1,1);
        boundingBox = sprite.getBoundingRectangle();
        scaleFactor = 1;
    }

    public void setPosition(float x, float y)
    {
        sprite.setPosition(x, y);
    }

    public  Vector2 getPosition()
    {
        return new Vector2(this.sprite.getX(), this.sprite.getY());
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
