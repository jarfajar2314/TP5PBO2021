/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulgame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Muhammad Fajar
 */
public class Enemies extends GameObject{
    int speed;
    public Enemies(int x, int y, ID id){
        super(x, y, id);
       
        speed = 5;
    }

    @Override
    public void tick() {
        x += vel_x;
        y += vel_y;
        
        x = Game.clamp(x, 0, Game.WIDTH - 60);
        y = Game.clamp(y, 0, Game.HEIGHT - 80);
    }
    
    // Fungsi untuk membuat enemy mengejar player
    public void move(int pX, int pY){
        //System.out.println("Move from " + String.valueOf(x) + "," + String.valueOf(y) + " To : " + String.valueOf(pX) + "," + String.valueOf(pY));
        int diffX = pX - x;
        int diffY = pY - y;

        float angle = (float)Math.atan2(diffY, diffX);

        x += speed * Math.cos(angle);
        y += speed * Math.sin(angle);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.decode("#e5e6e7"));
        g.fillRect(x, y, 50, 50);
    }
}
