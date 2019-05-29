package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

import java.awt.*;
import java.math.*;

public class Guard extends Rectangle {
    public enum stany{
        PATROL,
        POSCIG,
        POWROT,
        ODPOCZYNEK
    }
    Texture texture;
    boolean wGore;
    int patrols;
    stany stans;
    float timeHelper;
    int czasRelaksu;


    public Guard(Texture texture) {
        this.texture = texture;
        this.x=1000;
        this.y=300;
        this.height=24;
        this.width=24;
        wGore=true;
        stans=stany.PATROL;
        patrols=0;
        czasRelaksu=0;
    }


    public Texture getTexture() {
        return texture;
    }

    public void update(float delta,double playerX, double playerY)
    {
        if(Math.sqrt(Math.pow(this.x-playerX,2.0)+Math.pow(this.y-playerY,2.0))<=200 && stans!=stany.ODPOCZYNEK)
        {
            stans=stany.POSCIG;
        }
        else if(Math.sqrt(Math.pow(this.x-playerX,2.0)+Math.pow(this.y-playerY,2.0))>200 && stans==stany.POSCIG)
        {
            stans=stany.POWROT;
        }
        if(this.x==1000 && this.y==300 && stans==stany.POWROT)
        {
            stans=stany.PATROL;
        }
        if(patrols==4)
        {
            stans=stany.ODPOCZYNEK;
        }
        if(czasRelaksu==4)
        {
            patrols=0;
            czasRelaksu=0;
            stans=stany.POWROT;
        }


        if(stans==stany.PATROL)
        {
            Patrol(delta);
        }
        else if(stans==stany.POSCIG)
        {
            Poscig(delta,playerX,playerY);
        }
        else if(stans==stany.POWROT)
        {
            Powrot(delta);
        }
        else if(stans==stany.ODPOCZYNEK)
        {
            Odpoczynek(delta);
            timeHelper+=delta;
            if(timeHelper>1)
            {
                //System.out.println("tik");
                timeHelper=0;
                czasRelaksu++;
            }
        }
    }
    void Patrol(float delta)
    {
        if(this.y<=100)
            wGore=true;
        else if(this.y>=600)
        {
            wGore=false;
            patrols++;
            //System.out.println(patrols);
        }


        if(wGore)
            this.y+=200*delta;
        else
            this.y-=200*delta;

    }
    void Poscig(float delta,double playerX,double playerY)
    {
        if(playerX<this.x)
        {
            this.x-=200*delta;
        }
        else if(playerX>this.x)
        {
            this.x+=200*delta;
        }
        if(playerY<this.y)
        {
            this.y-=200*delta;
        }
        else if(playerY>this.y)
        {
            this.y+=200*delta;
        }
    }
    void Powrot(float delta)
    {
        if(this.x<1000)
            this.x+=300*delta;
        else if(this.x>1000)
            this.x-=300*delta;
        if(this.y<300)
            this.y+=300*delta;
        else if(this.y>300)
            this.y-=300*delta;
    }
    void Odpoczynek(float delta)
    {
        if(this.x<1200)
            this.x+=300*delta;
        else if(this.x>1200)
            this.x-=300*delta;
        if(this.y<300)
            this.y+=300*delta;
        else if(this.y>300)
            this.y-=300*delta;

    }
}
