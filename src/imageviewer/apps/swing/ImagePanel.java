package imageviewer.apps.swing;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageDisplay{

    private BufferedImage bitmap;
    private Image image;
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0, 0, getWidth(), getHeight());
        if(bitmap == null) return;
        Bounds b = new Bounds();
        g.drawImage(bitmap, b.x(), b.y(), b.width(), b.height(), null);
    }
    
    @Override
    public void display(Image image){
        this.image = image;
        load();
        repaint();
    }
    
    public Image currentImage(){
        return image;
    }
    
    private void load(){
        try{
            this.bitmap = ImageIO.read(new File(image.getName()));
        } catch(IOException e){
            this.bitmap = null;
            System.out.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Image getImage() {
        return image;
    }
    
    private class Bounds {

        private final int iw;
        private final int ih;
        private final double ir;
        private final int pw;
        private final int ph;
        private final double pr;
        
        public Bounds() {
            iw = bitmap.getWidth();
            ih = bitmap.getHeight();
            ir = (double) iw / ih;
            pw = getWidth();
            ph = getHeight();
            pr = (double) pw / ph;
        }
        
        public int x(){
            return (pw - width()) / 2;
        }
        
        public int y(){
            return (pw - height()) / 2;
        }
        
        public int width(){
            return ir < pr ? (int) ((double) iw * ph / ih) : pw;
        }
        
        public int height(){
            return ir < pr ? ph : (int) ((double) pw * ih / iw);
        }
    }
}
