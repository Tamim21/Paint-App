package com.mycompany.pnt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.abs;

/**
 *
 * @author Tamim
 */
public class Circle extends ImShape implements Moveable , Shape{
    private int radiush;
    private int radiusw;
    private Vertex[] v = new Vertex[4];
    @Override
    public Vertex[] getV() {
        return v;
    }
    
    
    public Circle(Point pt,int radiusw,int radiush){
        this.radiusw = 2*radiusw;
        this.radiush = 2*radiush;
        setPosition(new Point (pt.x,pt.y));
        setFillColor(Color.BLACK);
        setColor(Color.BLACK);
        v[0] = new Vertex(new Point(pt.x, pt.y));
        v[1] = new Vertex(new Point(pt.x+radiusw/2, pt.y));
        v[2] = new Vertex(new Point(pt.x, pt.y+radiush/2));
        v[3] = new Vertex(new Point(pt.x+radiusw/2, pt.y+radiush/2));
    }
    @Override
    public void draw(Graphics canvas){
        if(isIsVisible()==true) for(Vertex vs:v) vs.draw(canvas);
        canvas.setColor(getColor());
        canvas.drawOval(getPosition().x, getPosition().y,radiusw,radiush);
        canvas.setColor(getFillColor());
        canvas.fillOval(getPosition().x, getPosition().y,radiusw,radiush); 
    }

    @Override
    public boolean contains(Point p) {
        int ox = getPosition().x+radiusw/2;
        int oy = getPosition().y+radiush/2;
        double nrx = (double)abs(-ox+p.x);
        double nry = (double)abs(-oy+p.y);
        double cx = (double)((nrx*nrx)/((radiusw/2)*(radiusw/2)));
        double cy = (double)((nry*nry)/((radiush/2)*(radiush/2)));
        if(cx+cy <=1) {
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
        v[1].moveTo(new Point(getPosition().x+radiusw-5, getPosition().y-5));
        v[2].moveTo(new Point(getPosition().x-5, getPosition().y+radiush-5));
        v[3].moveTo(new Point(getPosition().x+radiusw-5, getPosition().y+radiush-5));
    }
    @Override
    public void resize(Point p)
    {
     
     if(v[0].contains(p)){
     int dx = -getPosition().x+p.x;
     int dy = -getPosition().y+p.y;
     setPosition(new Point(getPosition().x+dx,getPosition().y+dy));
     radiusw =  Math.abs(dx-radiusw);
     radiush  = Math.abs(dy-radiush);
     v[1].setPosition(new Point(v[1].getPosition().x,v[1].getPosition().y+dy)); 
     v[2].setPosition(new Point(v[2].getPosition().x+dx,v[2].getPosition().y)); 
     }else if(v[1].contains(p)){
     int dx = -getPosition().x+p.x+radiusw;
     int dy = -getPosition().y+p.y;
     setPosition(new Point(getPosition().x,getPosition().y+dy));
     v[0].setPosition(new Point(v[0].getPosition().x,v[0].getPosition().y+dy)); 
     v[1].setPosition(new Point(radiusw+v[0].getPosition().x+5,v[0].getPosition().y-5));
     radiusw =  Math.abs(dx-radiusw);
     radiush  = Math.abs(dy-radiush); 
     v[3].setPosition(new Point(radiusw+v[2].getPosition().x,v[3].getPosition().y)); 
    }else if(v[2].contains(p)){
     int dx = -getPosition().x+p.x;
     int dy = -getPosition().y+p.y+radiush;
     setPosition(new Point(getPosition().x+dx,getPosition().y));
     v[0].setPosition(new Point(v[0].getPosition().x+dx,v[0].getPosition().y)); 
     v[2].setPosition(new Point(v[0].getPosition().x-5,v[0].getPosition().y+radiush+5));
     radiusw =  Math.abs(dx-radiusw);
     radiush  = Math.abs(dy-radiush); 
     v[3].setPosition(new Point(v[2].getPosition().x+radiusw,v[2].getPosition().y));
    }else if(v[3].contains(p)){
     int dx = -getPosition().x+p.x-radiusw;
     int dy = -getPosition().y+p.y-radiush;
     radiusw = Math.abs(dx+radiusw);
     radiush  = Math.abs(dy+radiush); 
     v[3].setPosition(new Point(v[3].getPosition().x+dx,v[3].getPosition().y+dy-5));
     v[2].setPosition(new Point(v[3].getPosition().x-radiusw-5,v[3].getPosition().y));
     v[1].setPosition(new Point(v[3].getPosition().x-5,v[3].getPosition().y-radiush));   
    }
    }

    
}
