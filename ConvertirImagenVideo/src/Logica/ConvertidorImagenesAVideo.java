package Logica;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class ConvertidorImagenesAVideo {

	private JFrame frame;
	private JTextField textFieldTiempo;
	private JButton btnNewButton_1;
	
	private File[] archivosSeleccionados;
	private JLabel labelFPS;
	private JLabel labelTiempo;
	private JLabel labelCantidad;
	private JLabel labelFin;
	private JButton btnNewButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Interfaz estilo windows.
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ConvertidorImagenesAVideo window = new ConvertidorImagenesAVideo();
					window.frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConvertidorImagenesAVideo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Determine el tiempo que quiere que dure el v\u00EDdeo  (segundos):");
		lblNewLabel.setBounds(0, 0, 434, 14);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldTiempo = new JTextField();
		textFieldTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldTiempo.setBounds(165, 25, 86, 20);
		frame.getContentPane().add(textFieldTiempo);
		textFieldTiempo.setColumns(10);
		
		btnNewButton = new JButton("Convertir");
		
		btnNewButton.setBounds(162, 166, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("Seleccionar archivos");
	
		btnNewButton_1.setBounds(103, 69, 214, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel labelFPS = new JLabel("");
		labelFPS.setHorizontalAlignment(SwingConstants.LEFT);
		labelFPS.setBounds(10, 163, 107, 14);
		frame.getContentPane().add(labelFPS);
		
		JLabel labelTiempo = new JLabel("");
		labelTiempo.setHorizontalAlignment(SwingConstants.LEFT);
		labelTiempo.setBounds(10, 188, 107, 14);
		frame.getContentPane().add(labelTiempo);
		
		JLabel labelCantidad = new JLabel("");
		labelCantidad.setHorizontalAlignment(SwingConstants.LEFT);
		labelCantidad.setBounds(10, 138, 179, 14);
		frame.getContentPane().add(labelCantidad);
		
		JLabel labelFin = new JLabel("");
		labelFin.setHorizontalAlignment(SwingConstants.CENTER);
		labelFin.setBounds(0, 236, 434, 14);
		frame.getContentPane().add(labelFin);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creamos el JFileChooser con ruta por defecto donde está el .jar
				JFileChooser seleccionarArchivos = new JFileChooser(System.getProperty("user.dir"));
				
				//Solo es posible elegir imagenes.
				seleccionarArchivos.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));
				
				//Habilitamos que se puedan elegir multiples archivos.
				seleccionarArchivos.setMultiSelectionEnabled(true);
				seleccionarArchivos.showOpenDialog(null);
				archivosSeleccionados = seleccionarArchivos.getSelectedFiles();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double tiempo = Double.parseDouble(textFieldTiempo.getText());
				ImagenesVideo.convertir(tiempo, archivosSeleccionados, labelFPS, labelTiempo, labelCantidad, labelFin);
			}
			
		});
		
	}
	

}
