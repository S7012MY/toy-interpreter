package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Controller.ToyInterpreter;
import Model.Statement.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class StartGui{

	private JFrame frame;
	private Statement statement;
	private StartGui thisStartGui;
	private final ToyInterpreter ti;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGui window = new StartGui();
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
	public StartGui() {
		initialize();
		thisStartGui=this;
		ti = new ToyInterpreter();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddStatement = new JButton("Add Statement");
		btnAddStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Statement state=thisStartGui.getStatement();
				GUI gui = new GUI(ti);
			
			}
		});
		btnAddStatement.setBounds(134, 49, 141, 23);
		frame.getContentPane().add(btnAddStatement);
		
		JButton btnStepByStep = new JButton("Step by Step");
		btnStepByStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PrintWriter writer = null;
				try {
					writer = new PrintWriter("debug.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				while(true) {
					System.out.println("Aici");
					if (ti.r.getNumProg() == 0) break;
					//System.out.println("after break");
					ti.interpretNext();
					 
					JOptionPane.showConfirmDialog(null,"Next Step \n"+ ti.r.toString());
					writer.write(ti.r.toString());
				}
				JOptionPane.showConfirmDialog(null,"Last step\n" + ti.r.ob.toString());
				writer.write("Program terminated------\n");
				writer.write(ti.r.toString());
				writer.close();
			}
		});
		btnStepByStep.setBounds(132, 153, 143, 23);
		frame.getContentPane().add(btnStepByStep);
		
		JButton btnRunWhole = new JButton("Run whole program");
		btnRunWhole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ti.startInterpreting();
				ti.r.ob.printBuffer();
				JOptionPane.showConfirmDialog(null,ti.r.ob.toString());
			}
		});
		btnRunWhole.setBounds(62, 187, 299, 23);
		frame.getContentPane().add(btnRunWhole);
		
		JButton btnSerializeFromFile = new JButton("serialize to file");
		btnSerializeFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ti.serializeToFile();
			}
		});
		btnSerializeFromFile.setBounds(134, 83, 141, 23);
		frame.getContentPane().add(btnSerializeFromFile);
		
		JButton btnSerializeFromFile_1 = new JButton("serialize from file");
		btnSerializeFromFile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ti.serializeFromFile();
			}
		});
		btnSerializeFromFile_1.setBounds(134, 117, 141, 23);
		frame.getContentPane().add(btnSerializeFromFile_1);
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
