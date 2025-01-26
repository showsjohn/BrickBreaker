package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

enum COLOR {grey, green, yellow, orange, red, purple }
public class Brick extends SpriteGameObject implements Collidable{

    COLOR color;
    int hitpoints;
    float hitCoolDown;

    public Brick(String path, COLOR color) {
        super(path);
        scaleFactor = 4f;
        hitpoints = 3;
        this.color = color;
        sprite.setOrigin(0,0);
        sprite.setSize(32,16);
        sprite.setScale(scaleFactor);
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
        //boundingBox = sprite.getBoundingRectangle();

        // to avoid rapid hits on the Brick, a small cooldown period is imposed
        // we use deltaTime to decrement from the hitCoolDown if one is effect (if greater than 0)
        if (hitCoolDown > 0)
        {
            hitCoolDown -= deltaTime;
        }
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
        hitpoints -= 1;
        sprite.setRegion(sprite.getRegionX()+ 32, sprite.getRegionY(),32,16);

        if(hitpoints <=0 )
        {
           isDestroyed = true;
        }

        hitCoolDown = 0.2f;
        System.out.println(hitpoints);
    }
}
