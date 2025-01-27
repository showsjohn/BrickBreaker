package com.johns.boxbreaker;

import java.util.ArrayList;
import java.util.List;

public class CollisionManager
{
    List<Collidable> collidables;

    public CollisionManager()
    {
        collidables = new ArrayList<>();
    }
    public void add(Collidable collidable)
    {
        collidables.add(collidable);
    }

    public void remove(Collidable collidable)
    {
        collidables.remove(collidable);
    }

    public void logic()
    {
        checkCollisions();
    }

    public void checkCollisions()
    {
        /*
        Loop through each object and compare it against the rest of the objects in the list.
        This is a naive approach, but will be used due to time constraints. The simplicity of the project
        means even this quadratic algorithm will be sufficient.
         */
        Collidable first, second;
        for (int i = 0; i < collidables.size(); i++) {
            first = collidables.get(i); // get a reference to the first collidable object to check against others
            for (int j = i + 1; j < collidables.size(); j++) {
                second = collidables.get(j); // the current collidable to be checked against the first

                if (first.hasCollided(second)) // if a collision has occurred:
                {
                    handleCollision(first, second); // then handleCollision

                }

            }
        }
    }

    // method to call handleCollision on the collidables who have collided
    public void handleCollision(Collidable first, Collidable second)
    {
        first.handleCollision(second);
        second.handleCollision(first);
    }

}
