package com.mycompany.pnt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
/**
 *
 * @author Tamim
 */
public class Quad extends ImShape implements Moveable , Shape{
    private int length;
    private int width;
    private Vertex[] v = new Vertex[4];
    
    @Override
    public Vertex[] getV() {
        return v;
    }
    
    public Quad(Point pt,int length,int width){
        setPosition(pt);
        this.length = length;
        this.width = width;
        setFillColor(Color.BLACK);
        setColor(Color.BLACK);
        v[0] = new Vertex(new Point(pt.x, pt.y));
        v[1] = new Vertex(new Point(pt.x+length, pt.y));
        v[2] = new Vertex(new Point(pt.x, pt.y+width));
        v[3] = new Vertex(new Point(pt.x+length, pt.y+width));
        
    }
    @Override
    public void draw(Graphics canvas){
        if(isIsVisible()==true) for(Vertex vs:v) vs.draw(canvas); 
        int x = getPosition().x;
        int y = getPosition().y;
        canvas.setColor(getColor());
        canvas.drawRect(getPosition().x, getPosition().y,length,width);
        canvas.setColor(getFillColor());
        canvas.fillRect(getPosition().x+1, getPosition().y+1, length-1, width-1);
    }

    @Override
    public boolean contains(Point point) {
        int x2 = getPosition().x+length;
        int y2 = getPosition().y+width;
        if(point.x>=getPosition().x && point.y>=getPosition().y && point.x<=x2 && point.y<=y2) { 
            return true;
        }
          return false;   
        }

    @Override
    public Object copy() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
      
    

    @Override
    public void moveTo(Point point) {
        int cx = (-getDraggingPoint().x+point.x);
        int cy = (-getDraggingPoint().y+point.y);
        Point c = new Point(cx,cy);
        setPosition(new Point(cx+getPosition().x,cy+getPosition().y));
        v[0].moveTo(new Point(getPosition().x-5, getPosition().y-5));
        v[1].moveTo(new Point(getPosition().x+length-5, getPosition().y-5));
        v[2].moveTo(new Point(getPosition().x-5, getPosition().y+width-5));
        v[3].moveTo(new Point(getPosition().x+length-5,getPosition().y+width-5));
        
    }
    @Override
    public void resize(Point p)
    {
     if(v[0].contains(p)){
     int dx = -getPosition().x+p.x;
     int dy = -getPosition().y+p.y;
     setPosition(new Point(getPosition().x+dx,getPosition().y+dy));
     length =  Math.abs(dx-length);
     width  = Math.abs(dy-width);
     v[1].setPosition(new Point(v[1].getPosition().x,v[1].getPosition().y+dy)); 
     v[2].setPosition(new Point(v[2].getPosition().x+dx,v[2].getPosition().y)); 
     }else if(v[1].contains(p)){
     int dx = -getPosition().x+p.x+length;
     int dy = -getPosition().y+p.y;
     setPosition(new Point(getPosition().x,getPosition().y+dy));
     v[0].setPosition(new Point(v[0].getPosition().x,v[0].getPosition().y+dy)); 
     v[1].setPosition(new Point(length+v[0].getPosition().x+5,v[0].getPosition().y-5));
     length =  Math.abs(dx-length);
     width  = Math.abs(dy-width); 
     v[3].setPosition(new Point(length+v[2].getPosition().x,v[3].getPosition().y)); 
    }else if(v[2].contains(p)){
     int dx = -getPosition().x+p.x;
     int dy = -getPosition().y+p.y+width;
     setPosition(new Point(getPosition().x+dx,getPosition().y));
     v[0].setPosition(new Point(v[0].getPosition().x+dx,v[0].getPosition().y)); 
     v[2].setPosition(new Point(v[0].getPosition().x-5,v[0].getPosition().y+width+5));
     length =  Math.abs(dx-length);
     width  = Math.abs(dy-width); 
     v[3].setPosition(new Point(v[2].getPosition().x+length,v[2].getPosition().y));
     System.out.println("diffX: "+ dx+" diffY: "+ dy);
    System.out.println("NewLEN: "+ length+" NEWW: "+ width);
    }else if(v[3].contains(p)){
     int dx = -getPosition().x+p.x-length;
     int dy = -getPosition().y+p.y-width;
     setPosition(new Point(getPosition().x,getPosition().y));
     length = Math.abs(dx+length);
     width  = Math.abs(dy+width); 
     v[3].setPosition(new Point(v[3].getPosition().x+dx,v[3].getPosition().y+dy-5));
     v[2].setPosition(new Point(v[3].getPosition().x-length-5,v[3].getPosition().y));
     v[1].setPosition(new Point(v[3].getPosition().x-5,v[3].getPosition().y-width));   
    }
    }
}