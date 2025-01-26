package com.johns.boxbreaker;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Gdx;
import java.util.Random;

public class Ball extends SpriteGameObject implements Collidable {

    float deltaY;
    float deltaX;
    int speedY;

    public Ball(String path) {
        super(path);
        scaleFactor = 8f;
        sprite.setOrigin(0,0);
        sprite.setSize(7,7);
        sprite.setScale(scaleFactor);
        sprite.setPosition(300,300);
        sprite.setRegion(128,9,7,7);
        speed = 600f;

        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(5);

        deltaX = 1;
        deltaY = 1;
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
        sprite.translateX(speed * deltaX * deltaTime);
        sprite.translateY(-speed * deltaY  * deltaTime);

        if (sprite.getX() < 0) {
            deltaX = -deltaX;
            sprite.setX(0); // Correct position to prevent it from going out of bounds
        } else if (sprite.getX() + (sprite.getWidth() * scaleFactor) > Gdx.graphics.getWidth()) {
            deltaX = -deltaX;
            sprite.setX(Gdx.graphics.getWidth() - (sprite.getWidth() * scaleFactor)); // Correct position
        }

// Check vertical boundaries
        if (sprite.getY() < 0) {
            deltaY = -deltaY;
            sprite.setY(0); // Correct position
        } else if (sprite.getY() + (sprite.getHeight() * scaleFactor) > Gdx.graphics.getHeight()) {
            deltaY = -deltaY;
            sprite.setY(Gdx.graphics.getHeight() - (sprite.getWidth() * scaleFactor)); // Correct position
        }

    }

    @Override
    public boolean hasCollided(Collidable collidable) {
        boundingBox = sprite.getBoundingRectangle();
        if (collidable instanceof Brick)
        {
            if (boundingBox.overlaps(((Brick) collidable).boundingBox))
            {
                //System.out.println("COLLISION!");
                handleCollision(collidable);
            }
        }

        if (collidable instanceof Paddle)
        {
            if (boundingBox.overlaps(((Paddle) collidable).boundingBox))
            {
                //System.out.println("COLLISION!");
                handleCollision(collidable);
            }
        }

        return false;
    }

    @Override
    public void handleCollision(Collidable collidable) {
        Rectangle ballBounds = sprite.getBoundingRectangle();
        if(collidable instanceof Brick)
        {
            System.out.println("bricked");
            Rectangle objectBounds = ((Brick) collidable).sprite.getBoundingRectangle();

            float overlapX = Math.min(
                    ballBounds.x + ballBounds.width - objectBounds.x, // Ball's right edge vs object's left edge
                    objectBounds.x + objectBounds.width - ballBounds.x // Object's right edge vs ball's left edge
            );
            float overlapY = Math.min(
                    ballBounds.y + ballBounds.height - objectBounds.y, // Ball's top edge vs object's bottom edge
                    objectBounds.y + objectBounds.height - ballBounds.y // Object's top edge vs ball's bottom edge
            );

            if (overlapX < overlapY) {
                deltaX = -deltaX; // Reverse horizontal direction
            } else {
                deltaY = -deltaY; // Reverse vertical direction
            }

        }

        if (collidable instanceof Paddle) {
            System.out.println("paddled");

            deltaY = -deltaY;
        }



    }
}
