package com.mycompany.pnt;



import java.awt.Point;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import com.fasterxml.jackson.databind.ObjectMapper;  




public class GUI extends javax.swing.JFrame {
    private CirPro c = new CirPro(this);
    private LPro l = new LPro(this);
    private SqPro s = new SqPro(this);
    private RecPro r = new RecPro(this);
    private int oc=0;
    private int lc=0;
    private int rc=0;
    private int tc=0;

    public int getOc() {
        return oc;
    }

    public void setOc(int oc) {
        this.oc = oc;
    }

    public int getLc() {
        return lc;
    }

    public void setLc(int lc) {
        this.lc = lc;
    }

    public int getRc() {
        return rc;
    }

    public void setRc(int rc) {
        this.rc = rc;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }
    

    public Colorize getClr() {
        return clr;
    }

    public void setClr(Colorize clr) {
        this.clr = clr;
    }
    private Colorize clr = new Colorize(this);
    private TriPro tp = new TriPro(this);
    private Boolean pressedF = false;
    private Boolean pressedV = false;
    private int indexF;
    private int indexV;
    private Point press;

    
    public GUI() {
        initComponents();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        paintPannel1 = new com.mycompany.pnt.PaintPannel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint App");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Circle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Line");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Rectangle");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setText("Colorize");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        paintPannel1.setBackground(new java.awt.Color(255, 255, 255));
        paintPannel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                paintPannel1MouseDragged(evt);
            }
        });
        paintPannel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paintPannel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paintPannel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                paintPannel1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout paintPannel1Layout = new javax.swing.GroupLayout(paintPannel1);
        paintPannel1.setLayout(paintPannel1Layout);
        paintPannel1Layout.setHorizontalGroup(
            paintPannel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        paintPannel1Layout.setVerticalGroup(
            paintPannel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setText("Triangle");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setText("Copy");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Load");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(84, 84, 84)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addComponent(paintPannel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paintPannel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setVisible(false);
c.setVisible(true); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        l.setVisible(true);   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
        r.setVisible(true); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
 if(jComboBox1.getItemCount()==0) 
  JOptionPane.showMessageDialog(null, "There is Nothing to Delete");
 else {int l = jComboBox1.getSelectedIndex();
jComboBox1.removeItemAt(l);
paintPannel1.removeShape(paintPannel1.getShapes()[l]);
paintPannel1.refresh(null);
 }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        clr.getjRadioButton2().setVisible(true);
        clr.getjRadioButton3().setVisible(true);
        clr.setTitle("Colorize");
        if(jComboBox1.getItemCount()==0) 
            JOptionPane.showMessageDialog(null, "There is Nothing to Colorize");
        else{
        this.setVisible(false);
        clr.setVisible(true);
        if(jComboBox1.getSelectedItem().toString().contains("Line"))
        clr.setLine(true);
        else clr.setLine(false);
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         this.setVisible(false);
         tp.setVisible(true);  
    }//GEN-LAST:event_jButton7ActionPerformed

    private void paintPannel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintPannel1MouseClicked
      Point clicked = paintPannel1.getMousePosition();
      Shape []s = paintPannel1.getShapes();
      Shape ss=null;
      int ii=s.length;
      Moveable l;
      boolean flag = false;
        for (int i = 0 ;i<s.length;i++) {
            paintPannel1.getShapes()[i].setIsVisible(false);
            l = (Moveable) s[i];
            if (l.contains(clicked)) {
                ss = s[i];
                ii=i;
                flag = true;
            }
        }
        if(flag){
        paintPannel1.getShapes()[ii].setIsVisible(true);
        paintPannel1.removeShape(s[ii]);
        paintPannel1.addShape(ss);
        String cb= jComboBox1.getItemAt(ii);
        jComboBox1.removeItemAt(ii);
        jComboBox1.addItem(cb);
        jComboBox1.setSelectedIndex(s.length-1);
        }
        paintPannel1.refresh(null);
    }//GEN-LAST:event_paintPannel1MouseClicked

    private void paintPannel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintPannel1MousePressed
     press = evt.getPoint();
      Shape []s = paintPannel1.getShapes();
      int ii=s.length;
      Moveable l;
        for (int i = 0 ;i<s.length;i++) {
            l = (Moveable) s[i];
            if (l.contains(press)) {
                indexF=i;
                pressedF = true; 
            }
            for(int j = 0 ; j<paintPannel1.getShapes()[i].getV().length;j++) {
            if(paintPannel1.getShapes()[i].getV()[j].contains(press) && paintPannel1.getShapes()[i].isIsVisible()){
                indexV = j;
                pressedV = true; 
                pressedF = false;
            }  
        }
        }
        l = (Moveable) s[indexF];
        if(pressedF) l.setDraggingPoint(press);
        if(pressedV) {
            Vertex v = paintPannel1.getShapes()[indexF].getV()[indexV];
            v.setDraggingPoint(press);} 
     
        
    }//GEN-LAST:event_paintPannel1MousePressed
    private void paintPannel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintPannel1MouseReleased
     pressedF = false;
     pressedV = false;
    }//GEN-LAST:event_paintPannel1MouseReleased

    private void paintPannel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paintPannel1MouseDragged
        if(pressedF){
        Moveable l = (Moveable) paintPannel1.getShapes()[indexF];
        l.moveTo(evt.getPoint());
        l.setDraggingPoint(evt.getPoint());
        }
        if(pressedV){
        Shape s =  paintPannel1.getShapes()[paintPannel1.getShapes().length-1];
        s.getV()[indexV].moveTo(evt.getPoint());
        s.getV()[indexV].setDraggingPoint(evt.getPoint());
        Moveable l = (Moveable) paintPannel1.getShapes()[indexF];
        s.resize(evt.getPoint());
        }
        paintPannel1.refresh(null);
    }//GEN-LAST:event_paintPannel1MouseDragged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(jComboBox1.getItemCount()==0) JOptionPane.showMessageDialog(null, "There is Nothing to Copy");
        else{
        Shape copied = null;
        try {
            copied = (Shape) paintPannel1.getShapes()[jComboBox1.getSelectedIndex()].copy();
        } catch (CloneNotSupportedException ex) {}
        paintPannel1.addShape(copied);
        paintPannel1.refresh(null);
        if( copied instanceof Circle) { 
            setOc(getOc()+1);
            jComboBox1.addItem("Circle_" + Integer.toString(getOc()));
        }
        else if( copied instanceof Triangle) { 
            setTc(getTc()+1);
            jComboBox1.addItem("Triangle_" + Integer.toString(getTc()));
            System.out.println(copied.getV()[0].getColor().toString());
        }else if( copied instanceof Quad) {
            setRc(getRc()+1);
            jComboBox1.addItem("Rectangle_" + Integer.toString(getRc()));
        }else if( copied instanceof Line) {
            setLc(getLc()+1);
            jComboBox1.addItem("Line_" + Integer.toString(getLc()));
        }
        
        }   
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFileChooser f = new JFileChooser();
        int t = f.showSaveDialog(this);
        if(t==JFileChooser.APPROVE_OPTION){
        File fl = f.getSelectedFile();
        Shape []s = paintPannel1.getShapes();
        for(Shape ss:s) paintPannel1.removeShape(ss);
        jComboBox1.removeAllItems();
        paintPannel1.refresh(null);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = null;
            try {
                jsonArray = (JSONArray) jsonParser.parse( new FileReader(fl));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ParseException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            Gson g = new Gson();
            setRc(0);
            setLc(0);
            setOc(0);
            setTc(0);
            for(int i =0 ;i<jsonArray.size();i++){
                Object get = jsonArray.get(i);
                String sk = get.toString();
                if(sk.contains("radiush")) {

                paintPannel1.addShape(g.fromJson(sk, Circle.class));
                setOc(getOc()+1);
                jComboBox1.addItem("Circle_"+getOc());
                }
                else if(sk.contains("p3")) {
                paintPannel1.addShape(g.fromJson(sk, Triangle.class));
                setTc(getTc()+1);
                jComboBox1.addItem("Triangle_"+getTc());
                }
                else if(sk.contains("pt2")) {
                paintPannel1.addShape(g.fromJson(sk, Line.class));
                setLc(getLc()+1);
                jComboBox1.addItem("Line_"+getLc());
                }
                else if(sk.contains("length")) {
                paintPannel1.addShape(g.fromJson(sk, Quad.class));
                setRc(getRc()+1);
                jComboBox1.addItem("Rectangle_"+getRc());
                }
            }
            paintPannel1.refresh(null);
         }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser f = new JFileChooser();
        int t = f.showSaveDialog(this);
        if(t==JFileChooser.APPROVE_OPTION){
        File fl = f.getSelectedFile();
        Shape []s = paintPannel1.getShapes();
        Gson gson = new Gson(); 
        String jsonStr = gson.toJson(s);
        try{
        FileWriter fr = new FileWriter(fl);
        fr.write(jsonStr);
        fr.close();
        }catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
        }
        
            

        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    public PaintPannel getPaintPannel(){
        return this.paintPannel1;
    }
    public  JComboBox<String> getComboBox(){
        return this.jComboBox1;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private com.mycompany.pnt.PaintPannel paintPannel1;
    // End of variables declaration//GEN-END:variables
}
