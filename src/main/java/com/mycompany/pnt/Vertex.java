package com.mycompany.pnt;

import java.awt.Graphics;
import java.awt.Point;
/**
 *
 * @author Tamim
 */
public class Vertex extends ImShape implements Moveable , Shape{
    
    public Vertex(Point point){
        setPosition(new Point(point.x-5,point.y-5));
        setColor(java.awt.Color.BLACK);
        setFillColor(java.awt.Color.BLACK);
        /*setColor(java.awt.Color.BLACK);
        setFillColor(java.awt.Color.BLACK);*/
        
    }

    @Override
    public Object copy() throws CloneNotSupportedException {
        Vertex l = (Vertex) super.clone();
        Point d = new Point(getDraggingPoint().x,getDraggingPoint().y);
        Point p = new Point(getPosition().x,getPosition().y);
        l.setPosition(p);
        l.setDraggingPoint(d);
        return l;
    }
    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(getColor());
        canvas.drawRect(getPosition().x, getPosition().y,10,10);
        canvas.setColor(getFillColor());
        canvas.fillRect(getPosition().x+1, getPosition().y, 10, 10);    
    }

    @Override
    public boolean contains(Point point) {
        int x2 = getPosition().x+10;
        int y2 = getPosition().y+10;
        if(point.x>=getPosition().x && point.y>=getPosition().y && point.x<=x2 && point.y<=y2) {
            setDraggingPoint(point);
            return true;
        }
        return false;
       
    }

    @Override
    public void moveTo(Point point) {
        setPosition(point);
    }

    @Override
    public void resize(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vertex[] getV() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}