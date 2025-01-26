package com.johns.boxbreaker;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends SpriteGameObject implements Collidable {

    BitmapFont font = new BitmapFont();

    public Paddle(String path) {
        super(path);
        scaleFactor = 4f;
        sprite.setOrigin(0,0);
        sprite.setRegion(0,7,32,9);
        sprite.setSize(32,9);
        sprite.setScale(scaleFactor);
        sprite.setPosition(0,100);

    }

    @Override
    public void create()
    {
        speed = 6f;
    }

    @Override
    public void input() {


        float targetX = Math.clamp(Gdx.input.getX(), 0, Gdx.graphics.getWidth() - (sprite.getWidth() * scaleFactor));
        float currentX = sprite.getX();

        sprite.setX(currentX + (targetX - currentX));

    }

    public void logic() {
        super.logic();

        System.out.println(this.sprite.getBoundingRectangle());
    }

    @Override
    public boolean hasCollided(Collidable collidable) {
        boundingBox = sprite.getBoundingRectangle();
        if (collidable instanceof Ball)
        {
            if (boundingBox.overlaps(((Ball) collidable).sprite.getBoundingRectangle()))
            {
                //System.out.println("COLLISION!");
                handleCollision(collidable);
                return true;
            }
        }
        return false;
    }

    @Override
    public void handleCollision(Collidable collidable) {
        System.out.println("COLLISION!");
    }

}
