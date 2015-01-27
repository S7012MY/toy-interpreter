package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import Controller.ToyInterpreter;
import Model.Expression.Expression;
import Model.Statement.CompoundStatement;
import Model.Statement.ForkStatement;
import Model.Statement.IfStatement;
import Model.Statement.LockEnter;
import Model.Statement.LockExit;
import Model.Statement.PrintStatement;
import Model.Statement.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI  {

	private JFrame frame;
	private ToyInterpreter ti;
	private GUI thisGUI;
	Statement statement;
	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
		thisGUI=this;
		//frame.setVisible(true);
	}

	public GUI(ToyInterpreter ti) {
		initialize();
		thisGUI=this;
		this.ti=ti;
		thisGUI.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 531, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewCompoundExp = new JButton("Compound Statement");
		btnNewCompoundExp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompoundStatement is = new CompoundStatement();
				
				StatementDialog dialog2 = new StatementDialog("Compound's FIRST STATEMENT");
				dialog2.setLocationRelativeTo(frame);
				dialog2.setModal(true);
				dialog2.setVisible(true);
				Statement statemen =dialog2.getStatement();
				is.setS1(statemen);
				//System.out.println("Input second statement:");
				//is.setS2(readStatement());
				StatementDialog dialog3 = new StatementDialog("Compound's Second STATEMENT");
				dialog3.setLocationRelativeTo(frame);
				dialog3.setModal(true);
				dialog3.setVisible(true);
				Statement sttemen =dialog3.getStatement();
				is.setS2(sttemen);
				
				ti.addStatement(is,1);
				thisGUI.frame.setVisible(false);
			}
		});
		btnNewCompoundExp.setBounds(31, 73, 147, 23);
		frame.getContentPane().add(btnNewCompoundExp);
		
		JButton btnIfStatement = new JButton("If Statement");
		btnIfStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				IfStatement is = new IfStatement();
				
				ExpressionUI dialog = new ExpressionUI();
				dialog.setLocationRelativeTo(frame);
				dialog.setModal(true);
				dialog.setVisible(true);
				Expression exp =dialog.getExpression();
		
				is.setE(exp);
				
			//	System.out.println("Input first statement:");
				
				StatementDialog dialog2 = new StatementDialog("IF's FIRST STATEMENT");
				dialog2.setLocationRelativeTo(frame);
				dialog2.setModal(true);
				dialog2.setVisible(true);
				Statement statemen =dialog2.getStatement();
				is.setS1(statemen);
				System.out.println("Input second statement:");
				//is.setS2(readStatement());
				StatementDialog dialog3 = new StatementDialog("IF's Secold STATEMENT");
				dialog3.setLocationRelativeTo(frame);
				dialog3.setModal(true);
				dialog3.setVisible(true);
				Statement sttemen =dialog3.getStatement();
				is.setS2(sttemen);
				
				//add if statement
				ti.addStatement(is,1);
			}
		});
		btnIfStatement.setBounds(31, 123, 147, 23);
		frame.getContentPane().add(btnIfStatement);
		
		JButton btnAssignStatement = new JButton("Assign Statement");
		btnAssignStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AssignDialog dialog = new AssignDialog();
				dialog.setLocationRelativeTo(frame);
				dialog.setModal(true);
				dialog.setVisible(true);
				Statement stmt=dialog.getStatement();
				ti.addStatement(stmt,1);
			}
		});
		
		btnAssignStatement.setBounds(293, 73, 147, 23);
		frame.getContentPane().add(btnAssignStatement);
		
		JButton btnPrintStatement = new JButton("Print Statement");
		btnPrintStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExpressionUI dialog = new ExpressionUI();
				dialog.setLocationRelativeTo(frame);
				dialog.setModal(true);
				dialog.setVisible(true);
				Expression exp =dialog.getExpression();
				PrintStatement ps = new PrintStatement();
				//System.out.println("Input expression:");
				ps.setE(exp);
				ti.addStatement(ps,1);
			}
		});
		btnPrintStatement.setBounds(293, 123, 147, 23);
		frame.getContentPane().add(btnPrintStatement);
		JButton btnForkStatement = new JButton("Fork Statement");
		btnForkStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StatementDialog dialog = new StatementDialog("FORK'S STATEMENT");
				ForkStatement st = new ForkStatement();
				dialog.setLocationRelativeTo(frame);
				dialog.setModal(true);
				dialog.setVisible(true);
				Statement s = dialog.getStatement();
				st.setS(s);
				ti.addStatement(st,1);
			}
		});
		btnForkStatement.setBounds(293, 163, 147, 23);
		frame.getContentPane().add(btnForkStatement);
		
		JButton btnLockEnterStatement = new JButton("LockEnter Statement");
		btnLockEnterStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExpressionUI dialog = new ExpressionUI();
				dialog.setLocationRelativeTo(frame);
				dialog.setModal(true);
				dialog.setVisible(true);
				Expression exp =dialog.getExpression();
				LockEnter le = new LockEnter();
				//System.out.println("Input expression:");
				le.setE(exp);
				ti.addStatement(le,1);
			}
		});
		btnLockEnterStatement.setBounds(293, 183, 147, 23);
		frame.getContentPane().add(btnLockEnterStatement);
		
		JButton btnLockExitStatement = new JButton("LockExit Statement");
		btnLockExitStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExpressionUI dialog = new ExpressionUI();
				dialog.setLocationRelativeTo(frame);
				dialog.setModal(true);
				dialog.setVisible(true);
				Expression exp =dialog.getExpression();
				LockExit le = new LockExit();
				//System.out.println("Input expression:");
				le.setE(exp);
				ti.addStatement(le,1);
			}
		});
		btnLockExitStatement.setBounds(293, 203, 147, 23);
		frame.getContentPane().add(btnLockExitStatement);
	}
}
