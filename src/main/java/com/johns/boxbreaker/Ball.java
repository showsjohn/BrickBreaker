package com.johns.boxbreaker;

import java.util.Random;

public class Ball extends SpriteGameObject {

    int deltaY;
    int deltaX;
    int speedY;

    public Ball(String path) {
        super(path);

        sprite.setOrigin(0,0);
        sprite.setSize(7,7);
        sprite.setScale(8f);
        sprite.setPosition(300,300);
        sprite.setRegion(128,9,7,7);
        speed = 300f;

        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(5);

        deltaX = 0;
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

        if(sprite.getX() < 0 || sprite.getX() + 56 > 1920)
        {
            deltaX = -deltaX;
        }

        if(sprite.getY() + 56 > 1080 || sprite.getY() < 0)
        {
            deltaY = -deltaY;
        }




    }
}
