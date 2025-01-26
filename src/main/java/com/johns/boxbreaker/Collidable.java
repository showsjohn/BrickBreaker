package com.johns.boxbreaker;

public interface Collidable {

    boolean hasCollided(Collidable collidable);
    void handleCollision(Collidable collidable);
}