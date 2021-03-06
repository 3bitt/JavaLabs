import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Dimension;





public class Pakowacz {

	private JFrame frame;
	

	private JPanel MenuPanel;
	private JPanel ZipPanel;
	private JPanel UnzipPanel;
	
	/////////  Menu buttons /////////
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	//////// Zip buttons ////////
	private JButton ZipAddbtn;
	private JButton ZipZipbtn;
	private JButton ZipSaveTobtn;
	private JButton ZipBackbtn;
	
	private JTextArea ZipTextArea;
	private JScrollPane scrollPane;
	
	List<File> files = new ArrayList<File>();

	
	
	//////// Unzip buttons ///////
	private JButton btnSelectArch;
	private JButton btnUnzipTo;
	private JButton UnzipBackbtn;
	private JButton UnzipProceedbtn;
	
	private JTextField UnzipSelectText;
	private JTextField UnzipToText;
	
	
	final JFileChooser fc = new JFileChooser();
	private JTextField ZipSaveToText;
	
	/////////// ZIP SaveTo variable ///////////
	String dest = new String();
	
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pakowacz window = new Pakowacz();
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
	public Pakowacz() {
		initialize();
		initAction();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	 private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setTitle("Jack the Ripper & Zipper");

		
				///////////// MENU Panel ////////////////
		
		MenuPanel = new JPanel();
		MenuPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(MenuPanel, "name_1859242952208");
		MenuPanel.setLayout(null);
		MenuPanel.setVisible(true);
		
		
		ZipPanel = new JPanel();
		ZipPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(ZipPanel, "name_1861604193657");
		ZipPanel.setLayout(null);
		ZipPanel.setVisible(false);
		
		UnzipPanel = new JPanel();
		UnzipPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(UnzipPanel, "name_1931822328656");
		UnzipPanel.setLayout(null);
		UnzipPanel.setVisible(false);

		
		btnNewButton = new JButton("Zip Files");		
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setMargin(new Insets(2, 8, 2, 14));
		btnNewButton.setIconTextGap(6);
		btnNewButton.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/Download_16x16.png")));
		btnNewButton.setBounds(51, 63, 117, 53);
		MenuPanel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Unzip Files");			
		btnNewButton_1.setBackground(new Color(176, 196, 222));
		btnNewButton_1.setMargin(new Insets(2, 8, 2, 14));
		btnNewButton_1.setIconTextGap(6);
		btnNewButton_1.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/Upload_16x16.png")));
		btnNewButton_1.setBounds(270, 63, 127, 53);
		MenuPanel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Exit");		
		btnNewButton_2.setBackground(new Color(255, 222, 173));
		btnNewButton_2.setIconTextGap(7);
		btnNewButton_2.setMargin(new Insets(2, 0, 2, 14));
		btnNewButton_2.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Delete_132746.png")));
		btnNewButton_2.setBounds(164, 198, 117, 25);
		MenuPanel.add(btnNewButton_2);
		
		
		///////////// //////////////////		ZIP Panel       ////////////////
		
		
		
		ZipAddbtn = new JButton("Add files");
		ZipAddbtn.setBackground(Color.LIGHT_GRAY);
		ZipAddbtn.setIconTextGap(7);
		ZipAddbtn.setMargin(new Insets(2, 2, 2, 14));
		ZipAddbtn.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Create_132699.png")));
		ZipAddbtn.setBounds(319, 38, 117, 25);
		ZipPanel.add(ZipAddbtn);
		
		
		ZipZipbtn = new JButton("Zip");
		ZipZipbtn.setBackground(new Color(175, 238, 238));
		ZipZipbtn.setIconTextGap(10);
		ZipZipbtn.setMargin(new Insets(2, 2, 2, 14));
		ZipZipbtn.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Apply_132742.png")));
		ZipZipbtn.setEnabled(false);			
		ZipZipbtn.setBounds(319, 270, 117, 25);
		ZipPanel.add(ZipZipbtn);
		
		
		ZipBackbtn = new JButton("Back");
		ZipBackbtn.setBackground(new Color(255, 222, 173));
		ZipBackbtn.setMargin(new Insets(2, 4, 2, 14));
		ZipBackbtn.setIconTextGap(7);
		ZipBackbtn.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Redo_132718.png")));
		ZipBackbtn.setBounds(12, 270, 117, 25);
		ZipPanel.add(ZipBackbtn);
		
		ZipSaveTobtn = new JButton("Save to...");		
		ZipSaveTobtn.setBackground(Color.LIGHT_GRAY);
		ZipSaveTobtn.setMargin(new Insets(2, 2, 2, 14));
		ZipSaveTobtn.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Folder_132707.png")));
		ZipSaveTobtn.setBounds(319, 193, 117, 25);
		ZipPanel.add(ZipSaveTobtn);
		
		
		ZipSaveToText = new JTextField();
		ZipSaveToText.setBackground(Color.LIGHT_GRAY);
		ZipSaveToText.setEditable(false);
		ZipSaveToText.setBounds(12, 196, 295, 19);
		ZipPanel.add(ZipSaveToText);
		ZipSaveToText.setColumns(10);
		
		ZipTextArea = new JTextArea();
		ZipTextArea.setBackground(Color.LIGHT_GRAY);
		ZipTextArea.setRows(20);
		ZipTextArea.setColumns(1);
		ZipTextArea.setEditable(false);
		ZipTextArea.setBounds(12, 12, 295, 136);
		
		
		scrollPane = new JScrollPane(ZipTextArea);
		scrollPane.setBounds(12, 27, 295, 136);
		ZipPanel.add(scrollPane);
		
		JLabel lblDestination = new JLabel("Destination:");
		lblDestination.setBounds(12, 180, 95, 15);
		ZipPanel.add(lblDestination);
		
		JLabel lblFiles = new JLabel("Files:");
		lblFiles.setBounds(12, 12, 70, 15);
		ZipPanel.add(lblFiles);
		
		
		
				///////////// 	///////////////////			UNZIP Panel ///////////////
		
		
		
		btnSelectArch = new JButton("Archive");
		btnSelectArch.setBackground(Color.LIGHT_GRAY);
		btnSelectArch.setMargin(new Insets(2, 0, 2, 20));
		btnSelectArch.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/BeOS_Zip_archive.png")));
		btnSelectArch.setPreferredSize(new Dimension(125, 25));
		btnSelectArch.setBounds(12, 30, 146, 25);
		UnzipPanel.add(btnSelectArch);
		
		UnzipSelectText = new JTextField();
		UnzipSelectText.setBackground(Color.LIGHT_GRAY);
		UnzipSelectText.setEditable(false);
		UnzipSelectText.setBounds(168, 33, 268, 19);
		UnzipPanel.add(UnzipSelectText);
		UnzipSelectText.setColumns(10);
		
		
		btnUnzipTo = new JButton("Unzip to...");
		btnUnzipTo.setBackground(Color.LIGHT_GRAY);
		btnUnzipTo.setMargin(new Insets(2, 4, 2, 14));
		btnUnzipTo.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Folder_132707.png")));
		btnUnzipTo.setBounds(12, 130, 136, 25);
		UnzipPanel.add(btnUnzipTo);
		
		UnzipProceedbtn = new JButton("Unzip");
		UnzipProceedbtn.setBackground(new Color(175, 238, 238));
		UnzipProceedbtn.setMargin(new Insets(2, 2, 2, 14));
		UnzipProceedbtn.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Apply_132742.png")));
		UnzipProceedbtn.setBounds(281, 215, 117, 25);
		UnzipProceedbtn.setEnabled(false);
		UnzipPanel.add(UnzipProceedbtn);
		
		UnzipToText = new JTextField();
		UnzipToText.setBackground(Color.LIGHT_GRAY);
		UnzipToText.setEditable(false);
		UnzipToText.setBounds(158, 133, 278, 19);
		UnzipPanel.add(UnzipToText);
		UnzipToText.setColumns(10);
		
		
		UnzipBackbtn = new JButton("Back");
		UnzipBackbtn.setBackground(new Color(255, 222, 173));
		UnzipBackbtn.setMargin(new Insets(2, 2, 2, 14));
		UnzipBackbtn.setIcon(new ImageIcon(Pakowacz.class.getResource("/lib/if_Redo_132718.png")));
		UnzipBackbtn.setBounds(26, 215, 117, 25);
		UnzipPanel.add(UnzipBackbtn);
		
		JLabel lblZipFile = new JLabel("Zip file:");
		lblZipFile.setBounds(168, 12, 70, 15);
		UnzipPanel.add(lblZipFile);
		
		JLabel lblDestination_1 = new JLabel("Destination:");
		lblDestination_1.setBounds(162, 111, 100, 15);
		UnzipPanel.add(lblDestination_1);
	 	}
	
	 
private void initAction() {	
	
															////////////// Menu Panel Buttons
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ZipPanel.setVisible(true);
			MenuPanel.setVisible(false);
			if (ZipTextArea.getCaretPosition() != 0 && ZipSaveToText.getCaretPosition() != 0) {
				ZipZipbtn.setEnabled(true);
			} else {
				ZipZipbtn.setEnabled(false);
			}			
		}
	});
		
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			UnzipPanel.setVisible(true);
			MenuPanel.setVisible(false);
		}
	});
		
	btnNewButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(-1);
		}
	});
	
	
	////////////////////////////        ZIP         ////////////////////////  ZIP Action Buttons
	
	
	ZipAddbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setDialogTitle("Select files to ZIP");
			fc.setMultiSelectionEnabled(true);
						
			try {		
			
			int returnVal = fc.showOpenDialog(null);
			
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
		    		            
		            for (File file : fc.getSelectedFiles()) {
		            	files.add(file);
		            	ZipTextArea.append(file.getAbsolutePath() + "\n");		            	
		            }			 
				}			 
			} catch (Exception error) {
				 
				 JOptionPane.showMessageDialog(null, error.getMessage());		            
			 }	
			 
			/* ZIP aktywny tylko jesli podano pliki i miejsce docelowe */
			 if (ZipTextArea.getCaretPosition() != 0 && ZipSaveToText.getCaretPosition() != 0) {
					ZipZipbtn.setEnabled(true);
				} else {
					ZipZipbtn.setEnabled(false);
				}			
		}
	});	
	
	ZipSaveTobtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			
			int returnVal = fc.showOpenDialog(null);
			
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					dest = fc.getSelectedFile().getPath() + "/Zipped.zip";
					ZipSaveToText.setText(dest);					
				};
				
				/* ZIP aktywny tylko jesli podano pliki i miejsce docelowe */				
				if (ZipTextArea.getCaretPosition() != 0 && ZipSaveToText.getCaretPosition() != 0) {
					ZipZipbtn.setEnabled(true);
				} else {
					ZipZipbtn.setEnabled(false);
				}		
		}
	});
		
	
	ZipZipbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {		
			
			byte[] buffer = new byte[1024];		
			
			try {				
			
			FileOutputStream zip = new FileOutputStream(dest);
			ZipOutputStream out = new ZipOutputStream(zip);			
					for (File fil : files) {
			        	
			            File plik = new File(fil.getAbsolutePath());
			            FileInputStream fis = new FileInputStream(plik);
			            out.putNextEntry(new ZipEntry(plik.getName()));
			            
			            int len;
			
			            while ((len = fis.read(buffer)) > 0) {
			                out.write(buffer, 0, len);
			            }			         
			            
			            out.closeEntry();			
			            fis.close();
			        }					
			        out.close();
			        
			} catch (IOException ioex) {
				
				System.out.println("Blad zipowania" + ioex);
			}			
			        System.out.println("Utworzono archiwum zip");
			    }
		});
		
	
	ZipBackbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			files.clear();
			ZipSaveToText.setText(null);
			ZipTextArea.setText(null);
			MenuPanel.setVisible(true);
			ZipPanel.setVisible(false);
		}
	});
	
	
	///////////////////////////////    UNZIP      ///////////////////////////   UNZIP Action Buttons
	
	
	
	
	btnSelectArch.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {		
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ZIP Files", "zip");
			fc.setAcceptAllFileFilterUsed(false);
			fc.setFileFilter(filter);
			int returnVal = fc.showOpenDialog(null);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				UnzipSelectText.setText(fc.getSelectedFile().toString());
			}		
			
			 if (UnzipSelectText.getCaretPosition() != 0 && UnzipToText.getCaretPosition() != 0) {
					UnzipProceedbtn.setEnabled(true);
				} else {
					UnzipProceedbtn.setEnabled(false);
				}
			
		}
	});
	
	btnUnzipTo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(null);
			
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				UnzipToText.setText(fc.getSelectedFile().toString());				
			}	
			
			if (UnzipSelectText.getCaretPosition() != 0 && UnzipToText.getCaretPosition() != 0) {
				UnzipProceedbtn.setEnabled(true);
			} else {
				UnzipProceedbtn.setEnabled(false);
			}
		}
	});
	
	
	UnzipProceedbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
		String destination = UnzipToText.getText();
		String zipFile = UnzipSelectText.getText();
		
		byte[] buffer = new byte[1024];
		
		try {
			
			ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry ze = zipIn.getNextEntry();
			
			while (ze != null) {
				
				File newFile = new File(destination + File.separator + ze.getName());
				
				FileOutputStream fos = new FileOutputStream(newFile);
				
				int len;
				
				while ((len = zipIn.read(buffer)) > 0){
					fos.write(buffer, 0, len);					
				}
				
				fos.close();
				ze = zipIn.getNextEntry();
			}
			zipIn.closeEntry();
			zipIn.close();
			
			System.out.println("Archiwum rozpakowane");
			
		} catch (IOException ioe) {
			System.out.println("Błąd przy rozpakowywaniu" + ioe);
		}
		
			
		}
	});
	
	
	
	UnzipBackbtn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			fc.resetChoosableFileFilters();
			UnzipSelectText.setText(null);
			UnzipToText.setText(null);
			MenuPanel.setVisible(true);
			UnzipPanel.setVisible(false);
		}
	});
	
	
	}
}