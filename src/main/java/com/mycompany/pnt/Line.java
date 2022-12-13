    package com.mycompany.pnt;

    import java.awt.Color;
    import java.awt.Graphics;
    import java.awt.Point;

    /**
     *
     * @author Tamim
     */
    public class Line extends ImShape implements Moveable , Shape{
        private Point pt2;
        private Vertex[] v;

    public Point getPt2() {
        return pt2;
    }

    public void setPt2(Point pt2) {
        this.pt2 = pt2;
    }

    @Override
    public Vertex[] getV() {
        return v;
    }
        
        public Line(Point pt1,Point pt2){
            v = new Vertex[2];
            v[0] = new Vertex(new Point(pt1.x, pt1.y));
            v[1] = new Vertex(new Point(pt2.x, pt2.y));
            setPosition(v[0].getPosition());
            this.pt2 = v[1].getPosition();
            setColor(Color.BLACK);
            
            
        }
        @Override
        public void draw(Graphics canvas){
            if(isIsVisible()==true) for(Vertex vs:v) vs.draw(canvas);
            canvas.setColor(getColor());
            canvas.drawLine(getPosition().x, getPosition().y, pt2.x, pt2.y);
        }
        private double distance(int x1,int x2,int y1,int y2){
            return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        }
        @Override
        public boolean contains(Point point) {

        if(distance(getPosition().x,point.x,getPosition().y,point.y)+distance(point.x,pt2.x,point.y,pt2.y)==distance(getPosition().x,pt2.x,getPosition().y,pt2.y)){
                return true;}
            return false;
        }

        @Override
        public void moveTo(Point point) {
            int cx = (-getDraggingPoint().x+point.x);
            int cy = (-getDraggingPoint().y+point.y);
            Point c = new Point(cx,cy);
            setPosition(new Point(cx+getPosition().x,cy+getPosition().y));
            this.pt2 = new Point(cx+pt2.x,cy+pt2.y);
            v[0].moveTo(new Point(getPosition().x-5, getPosition().y-5));
            v[1].moveTo(new Point(pt2.x-5, pt2.y-5));
        }
    @Override
    public Object copy() throws CloneNotSupportedException {
        Line l = (Line) super.clone();
        l.v = new Vertex[2];
        for(int i = 0;i<2;i++) l.v[i] = (Vertex)  v[i].copy();
        System.out.println(l.getV().equals(v));
        return l;
    }
    @Override
    public void resize(Point p)
    {
     if(v[0].contains(p))setPosition(v[0].getPosition());
     else if(v[1].contains(p)) pt2 = v[1].getPosition();
    }
    }