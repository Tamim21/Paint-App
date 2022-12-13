
package com.mycompany.pnt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;

/**
 *
 * @author Tamim
 */
public class Triangle extends ImShape implements Moveable , Shape,Cloneable{
private Point p2;
private Point p3;
private Vertex[] v = new Vertex[3];

    @Override
    public Vertex[] getV() {
        return v;
    }
 
public Triangle(Point p1,Point p2, Point p3 ){
    setPosition(p1);
    this.p2 = p2;
    this.p3 = p3;
    setColor(Color.BLACK);
    setFillColor(Color.BLACK);
    v[0] = new Vertex(new Point(p1.x-5, p1.y-5));
    v[1] = new Vertex(new Point(p2.x-5, p2.y-5));
    v[2] = new Vertex(new Point(p3.x-5, p3.y-5));
    v[0].setDraggingPoint(new Point(p1.x-5, p1.y-5));
    v[1].setDraggingPoint(new Point(p2.x-5, p2.y-5));
    v[2].setDraggingPoint(new Point(p3.x-5, p3.y-5));
    
}

    @Override
    public void draw(Graphics canvas) {
    if(isIsVisible()==true) for(Vertex vs:v) vs.draw(canvas);
    canvas.setColor(getColor());
    canvas.drawPolygon(new int[] {getPosition().x, p2.x, p3.x}, new int[] {getPosition().y,p2.y, p3.y}, 3);
    canvas.setColor(getFillColor());
    canvas.fillPolygon(new int[] {getPosition().x, p2.x, p3.x}, new int[] {getPosition().y,p2.y, p3.y}, 3);
    }
    
    private float area(int x1, int y1, int x2, int y2, int x3, int y3){
        return (float) Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }

    @Override
    public boolean contains(Point point) {
        Point p1 = getPosition();
        float Area = area(p1.x,p1.y,p2.x,p2.y,p3.x,p3.y);
        float A1 = area(point.x,point.y,p2.x,p2.y,p3.x,p3.y);
        float A2 = area(p1.x,p1.y,point.x,point.y,p3.x,p3.y);
        float A3 = area(p1.x,p1.y,p2.x,p2.y,point.x,point.y);
        if(Area == A1+A2+A3) {
            return true;
        }
        return false;
    }
@Override
    public Object copy() throws CloneNotSupportedException {
        Triangle l = (Triangle) super.clone();
        l.v = new Vertex[3];
        for(int i = 0;i<3;i++){
            l.v[i] = (Vertex)  v[i].copy();
        }
        System.out.println(l.getV().equals(v));
        /*l.getV()[0].setPosition(new Point(v[0].getPosition().x,v[0].getPosition().y));
        l.getV()[1].setPosition(new Point(v[1].getPosition().x,v[1].getPosition().y));
        l.getV()[2].setPosition(new Point(v[2].getPosition().x,v[2].getPosition().y));
        l.getV()[0].setDraggingPoint(new Point(v[0].getDraggingPoint().x,v[0].getDraggingPoint().y));
        l.getV()[1].setDraggingPoint(new Point(v[1].getDraggingPoint().x,v[1].getDraggingPoint().y));
        l.getV()[2].setDraggingPoint(new Point(v[2].getDraggingPoint().x,v[2].getDraggingPoint().y));*/
        return l;
    }
    
    @Override
    public void moveTo(Point point) {
    int cx = (-getDraggingPoint().x+point.x);
    int cy = (-getDraggingPoint().y+point.y);
    Point c = new Point(cx,cy);
    setPosition(new Point(cx+getPosition().x,cy+getPosition().y));
    this.p2 = new Point(cx+p2.x,cy+p2.y);
    this.p3 = new Point(cx+p3.x,cy+p3.y);
    v[0].moveTo(new Point(getPosition().x-5, getPosition().y-5));
    v[1].moveTo(new Point(p2.x-5, p2.y-5));
    v[2].moveTo(new Point(p3.x-5, p3.y-5));
    }
    @Override
    public void resize(Point p)
    {
     if(v[0].contains(p))setPosition(v[0].getPosition());
     else if(v[1].contains(p)) p2 = v[1].getPosition();
     else if(v[2].contains(p)) p3 = v[2].getPosition();
    }
    }