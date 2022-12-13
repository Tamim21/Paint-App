package com.mycompany.pnt;

import java.awt.Point;

abstract public class ImShape implements Shape, Moveable,Cloneable{
 private java.awt.Point Position;
 private java.awt.Point draggingPoint;
 private int color;
 private int fColor;
 private boolean isVisible = false;
 
@Override
public void setPosition(java.awt.Point position){
    this.Position = new Point(position);
}
 @Override
 public java.awt.Point getPosition(){
    return this.Position;
}
@Override
public void setDraggingPoint(java.awt.Point position){
    this.draggingPoint =  new Point(position);
}
 @Override
 public java.awt.Point getDraggingPoint(){
    return this.draggingPoint;
}
 @Override
 public void setColor(java.awt.Color color){
    this.color = color.getRGB();
}
 @Override
 public java.awt.Color getColor(){
    return new java.awt.Color(this.color);
}
 @Override
 public void setFillColor(java.awt.Color color){
    this.fColor = color.getRGB();
}   
 @Override
 public java.awt.Color getFillColor(){
     return new java.awt.Color(this.fColor);
}
 @Override
 public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
 @Override
 public void hide(Vertex[] v) {
     for(Vertex vs:v){
        vs.setColor(java.awt.Color.WHITE);
        vs.setFillColor(java.awt.Color.WHITE);
    }
    setIsVisible(false);
    System.out.println("HIDE" +!isIsVisible());
 }
    @Override
    public void show(Vertex[] v) {
        for(Vertex vs:v){
        vs.setColor(java.awt.Color.BLACK);
        vs.setFillColor(java.awt.Color.BLACK);
    }
        setIsVisible(true);
        System.out.println("SHOW" + isIsVisible());
        
    }
    @Override
    public boolean isIsVisible(){
        return isVisible;
    }
 
}
