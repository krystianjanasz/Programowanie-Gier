package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Player extends Rectangle {

    Texture texture;

    public Player(Texture texture) {
        this.texture = texture;
        this.x=50;
        this.y=50;
        this.height=24;
        this.width=24;
    }

    public Texture getTexture() {
        return texture;
    }
    public void update(float delta)
    {
        if(Gdx.input.isKeyPressed(Input.Keys.W) && this.y<720-24)
        {
            if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
            {
                this.y+=400*delta;
            }
            else
            {
                this.y+=200*delta;
            }

        }
        if(Gdx.input.isKeyPressed(Input.Keys.S) && this.y>0)
        {

            if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
            {
                this.y-=400*delta;
            }
            else
            {
                this.y-=200*delta;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A) && this.x>0)
        {

            if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
            {
                this.x-=400*delta;
            }
            else
            {
                this.x-=200*delta;
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D) && this.x<1280-24)
        {
            if(Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT))
            {
                this.x+=400*delta;
            }
            else
            {
                this.x+=200*delta;
            }
        }
    }

    public double getX()
    {
        return this.x;
    }
}
