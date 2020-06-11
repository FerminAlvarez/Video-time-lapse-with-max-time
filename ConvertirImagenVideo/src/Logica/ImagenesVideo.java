package Logica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import org.jcodec.javase.api.awt.AWTSequenceEncoder;


/**
	 *
	 * @author Fermin
	 */

public class ImagenesVideo {
		
		public static void convertir(Double tiempo, File[] archivos, JLabel labelFPS, JLabel labelTiempo, JLabel labelCantidad,JLabel labelFin ) {
			try {		    
				
		    	Integer framesToEncode = archivos.length;
		    	System.out.println("Cantidad imagenes: "+archivos.length);
		    	int FPS = (int) (framesToEncode/tiempo);
		    	
		    	labelFPS.setText("FPS: "+FPS);
		    	labelTiempo.setText("Tiempo: "+tiempo.toString());
		    	labelCantidad.setText("Cantidad de imagenes: "+framesToEncode.toString());
		    	
		    	//Generamos el video con la ruta nombre y cantidad de fps.
		    	AWTSequenceEncoder enc=  AWTSequenceEncoder.createSequenceEncoder(new File("video.mp4"), FPS);
		 		
		    	
		    	for (int i = 0; i<framesToEncode; i++) {
		    		//Por cada imagen seleccionada la codificamos al video.
		    		BufferedImage img = ImageIO.read(new File(archivos[i].getAbsolutePath()));
		    		enc.encodeImage(img);
		    	}
		    	
		    	//cerramos el video
		    	enc.finish();
		    	labelFin.setText("EL VÍDEO YA ESTÁ LISTO");
			} catch (IOException e) {
				labelFin.setText("HA OCURRIDO UN ERROR");
			}
		}
		
}

