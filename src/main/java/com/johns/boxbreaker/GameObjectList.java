package com.johns.boxbreaker;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameObjectList {
    List<GameLoopable> objectList;
    CollisionManager collisionManager;

    public GameObjectList()
    {
        objectList = new ArrayList<>();
        collisionManager = new CollisionManager();
    }


    public void Add(GameLoopable obj)
    {
        objectList.add(obj);
        if(obj instanceof Collidable)
        {
            collisionManager.add((Collidable)obj);
        }
    }

    public void Remove(GameLoopable obj)
    {
        objectList.remove(obj);
        if(obj instanceof Collidable)
        {
            collisionManager.remove((Collidable)obj);
        }
    }

    public void create()
    {
        for (GameLoopable obj: objectList)
        {
            obj.create();
        }
    }


    public void input() {
        for (GameLoopable obj: objectList)
        {
            obj.input();
        }
    }


    public void logic() {
        for (GameLoopable obj: objectList)
        {
            obj.logic();
        }
        collisionManager.logic();
        removeDestroyed();
    }


    public void draw(SpriteBatch spriteBatch) {
        for (GameLoopable obj: objectList)
        {
            obj.draw(spriteBatch);
        }
    }

    protected void removeDestroyed() {
        // Page 252 of "Core Java For The Impatient"

        objectList.removeIf(obj ->
        {
            if (obj.isDestroyed())
            {
                collisionManager.remove((Collidable) obj);
                return true;
            }
            return false;
        });
    }

}
