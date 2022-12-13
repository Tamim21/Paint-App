package com.mycompany.pnt;


public interface Shape {
public void setPosition(java.awt.Point position);
public java.awt.Point getPosition();
public void setColor(java.awt.Color color);
public java.awt.Color getColor();
public void setFillColor(java.awt.Color color);
public java.awt.Color getFillColor();
public void draw(java.awt.Graphics canvas);
public Object copy() throws CloneNotSupportedException;
public void resize(java.awt.Point p);
public Vertex[] getV();
public void hide(Vertex[] v);
public void show(Vertex[] v);
public void setIsVisible(boolean isVisible);
public boolean isIsVisible();







}
