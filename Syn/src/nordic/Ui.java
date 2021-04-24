package nordic;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ui {
	
	private JFrame 			jWindow 	= new JFrame();
	private JTextArea 		jTextArea 	= new JTextArea();
	private JScrollPane		sCroll		= new JScrollPane(jTextArea);
	private JLabel 			lCount 		= new JLabel();
	private JFileChooser	jFileOpen	= new JFileChooser();
	private JMenuBar		jMenuBar	= new JMenuBar();
	private JMenu			jMenuFile	= new JMenu("File");
	private JMenuItem		jmItemOpen	= new JMenuItem("Open");
	private JMenuItem		jmItemSave	= new JMenuItem("Save");
	private JMenuItem		jmItemClear	= new JMenuItem("Clear");
	private JMenuItem		jmItemCount	= new JMenuItem("10000");
	
	private Font			font		= new Font("Courier New",Font.BOLD,18);
	private Color			bgDark		= new Color(25, 29, 31);
	private Color			fColor		= new Color(240,240,240);
	
	private String path = "nulo";
	private Path			pathFile	= Paths.get(path);
	private String textOpened;
	
	
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
		pathFile = Paths.get(path);
		System.out.println("loaded path: "+this.path);
		System.out.println("loaded paths: "+pathFile);
	}

	public String getOpnedFile() {
		try {
		byte[] text = Files.readAllBytes(pathFile);
		this.textOpened = new String(text);
		}catch(Exception e) {}
		return textOpened;
	}
	
	
	
	
	public Ui() {
		
		ui();
		
		jmItemOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				uiChooser();
			
			}});
	}
	
	private void ui() {
		// window size
		jWindow.setTitle("Syn");
		jWindow.setLayout(null);
		jWindow.setSize(700,700);
		jWindow.setVisible(true);
		jWindow.setResizable(false);
		jWindow.setLocationRelativeTo(null);
		jWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//add
		jWindow.setJMenuBar(jMenuBar);
		jWindow.add(sCroll);
		
		//bounds
		sCroll.setBounds(0,0,701,701);

		
		// menuBar
		jMenuBar.add(jMenuFile);
		jMenuBar.add(jmItemCount);
		jMenuFile.add(jmItemOpen);
		jMenuFile.add(jmItemSave);
		jMenuFile.add(jmItemClear);

		//features
		jTextArea.setLineWrap(true);
		jTextArea.setFont(font);
		//color
		jWindow.setBackground(bgDark);
		jTextArea.setBackground(bgDark);
		jTextArea.setForeground(fColor);
		
	}


	private void uiChooser() {
		int opt = jFileOpen.showOpenDialog(jWindow);
		if(opt == jFileOpen.APPROVE_OPTION) {
			setPath(jFileOpen.getSelectedFile().toString());
			jTextArea.setText(getOpnedFile());
		}else if(opt == jFileOpen.CANCEL_OPTION) {
			
		}
	}
	
	

}
