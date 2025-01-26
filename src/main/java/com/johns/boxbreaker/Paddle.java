package com.johns.boxbreaker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends SpriteGameObject{
    public Paddle(String path) {
        super(path);
        sprite.setOrigin(0,0);
        sprite.setRegion(0,7,32,9);
        sprite.setSize(32,9);
        sprite.setScale(8f);
        sprite.setPosition(0,100);

    }

    @Override
    public void create()
    {
        speed = 6f;
    }

    @Override
    public void input() {
        sprite.setX(Gdx.input.getX());

        if(sprite.getX() < 0)
        {
            sprite.setX(0);
        }

        if(sprite.getX() > 1920 - (sprite.getWidth() * 8f))
        {
            sprite.setX(1920 -sprite.getWidth() * 8f);
        }

    }

    public void logic() {
        super.logic();
    }

}
