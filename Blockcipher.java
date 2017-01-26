/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockcipher;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

/**
 *
 * @author owner
 */
public class Blockcipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String[] a=new String[96];
        int j=32;
        int k1=50000;
        int k2=2000;
           //  System.out.println(k0);
           String input="hi welcome";
           


   
String prefix="test-";


        Random random = new Random( 56743793 );



        int x,y = 0;

       

        //image block size in pixels, 1 is 1px, use smaller values for 

        //greater granularity

        int PIX_SIZE = 5;



        //image size in pixel blocks

        int X = 1;

        int Y = 1;



        BufferedImage bi = new BufferedImage( PIX_SIZE * X, PIX_SIZE * Y, 

                                              BufferedImage.TYPE_3BYTE_BGR );

        Graphics2D g=(Graphics2D)bi.getGraphics();

        String filename =  prefix + "img.jpg";
 String filename1 =  "img1.jpg";




        for( int i =0; i < X; i++ ){



            for( j =0; j < Y; j++ ){



                x = i * PIX_SIZE;

                y = j * PIX_SIZE;



               //this is a writing condition, my choice here is purely random

               // just to generate some pattern

               // this condition  

             
               if(i%2==0 && i%3==0)
                     g.setColor(Color.red);
               else
                     g.setColor(Color.blue);
               //fil the rectangles with the pixel blocks in chosen color

               g.fillRect( y, x , PIX_SIZE , PIX_SIZE );

        

            }//end for j

        

        }//end for i

        

        g.dispose();



        saveToFile( bi, new File( filename ) ); 

        //return filename;


 


 

}//end class 

    public static void saveToFile( BufferedImage img, File file ) throws IOException {

        

        ImageWriter writer = null;

        java.util.Iterator iter = ImageIO.getImageWritersByFormatName("jpg");

        

        if( iter.hasNext() ){

            writer = (ImageWriter)iter.next();

        }

        

        ImageOutputStream ios = ImageIO.createImageOutputStream( file );

        writer.setOutput(ios);



        ImageWriteParam param = new JPEGImageWriteParam( java.util.Locale.getDefault() );

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;

        param.setCompressionQuality(0.98f);



        writer.write(null, new IIOImage( img, null, null ), param);

 }    


}

