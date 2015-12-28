package Util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.JDesktopPane;

public class BackgroundedDesktopPane extends JDesktopPane
{
    Image img;

    public BackgroundedDesktopPane()
    {
         try
         {
             URL caminho = new java.net.URL(getClass().getResource("/icones/Logotipo.JPG"),"Logotipo.JPG");
             img = javax.imageio.ImageIO.read(caminho);
         }
         catch (Exception e)
         {
             System.out.println("Erro: " + e.getMessage());
         }
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (img != null)
        {
            Dimension dimension = this.getSize();
            int x = (int)(dimension.getWidth() - img.getWidth(this)) / 2;
            int y = (int)(dimension.getHeight() - img.getHeight(this)) / 2;
            g.drawImage(img, x, y, img.getWidth(this), img.getHeight(this), this);
            //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
        else
        {
            g.drawString("Imagem não encontrada", 50, 50);
        }
    }
}
