package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

enum COLOR {grey, green, yellow, orange, red, purple }
public class Brick extends SpriteGameObject{

    COLOR color;

    public Brick(String path, COLOR color) {
        super(path);

        this.color = color;
        sprite.setOrigin(0,0);
        sprite.setSize(32,16);
        sprite.setScale(4f);
        sprite.setPosition(300,300);

        int regionX = 0;
        int regionY = 0;
        switch (color)
        {
            case COLOR.green:
            {
                regionX = 113;
                regionY = 16;
                break;
            }

            case COLOR.red:
            {
                regionX = 113;
                regionY = 64;
                break;
            }

        }

        sprite.setRegion(regionX,regionY,32,16);

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

}
