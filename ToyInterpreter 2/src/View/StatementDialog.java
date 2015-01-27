package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class StatementDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JDialog thisDialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StatementDialog dialog = new StatementDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StatementDialog() {
		thisDialog =this;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton button = new JButton("Compound Statement");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CompoundStatement is = new CompoundStatement();
					
					StatementDialog dialog2 = new StatementDialog("Compound's FIRST STATEMENT");
					dialog2.setLocationRelativeTo(contentPanel);
					dialog2.setModal(true);
					dialog2.setVisible(true);
					Statement statemen =dialog2.getStatement();
					is.setS1(statemen);
					System.out.println("Input second statement:");
					//is.setS2(readStatement());
					StatementDialog dialog3 = new StatementDialog("Compound's Second STATEMENT");
					dialog3.setLocationRelativeTo(contentPanel);
					dialog3.setModal(true);
					dialog3.setVisible(true);
					Statement sttemen =dialog3.getStatement();
					is.setS2(sttemen);
					setStatement(is);
					thisDialog.dispose();
				}
			});
			button.setBounds(10, 72, 147, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("If Statement");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					IfStatement is = new IfStatement();
					
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(contentPanel);
					dialog.setModal(true);
					dialog.setVisible(true);
					Expression exp =dialog.getExpression();
			
					is.setE(exp);
					
				//	System.out.println("Input first statement:");
					
					StatementDialog dialog2 = new StatementDialog("IF's FIRST STATEMENT");
					dialog2.setLocationRelativeTo(contentPanel);
					dialog2.setModal(true);
					dialog2.setVisible(true);
					Statement statemen =dialog2.getStatement();
					is.setS1(statemen);
					System.out.println("Input second statement:");
					//is.setS2(readStatement());
					StatementDialog dialog3 = new StatementDialog("IF's Secold STATEMENT");
					dialog3.setLocationRelativeTo(contentPanel);
					dialog3.setModal(true);
					dialog3.setVisible(true);
					Statement sttemen =dialog3.getStatement();
					is.setS2(sttemen);
					setStatement(is);
					thisDialog.dispose();
					
				}
			});
			button.setBounds(10, 122, 147, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Assign Statement");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AssignDialog dialog = new AssignDialog();
					dialog.setLocationRelativeTo(contentPanel);
					dialog.setModal(true);
					dialog.setVisible(true);
					Statement stmt=dialog.getStatement();
					setStatement(stmt);
					
					thisDialog.dispose();
				}
			});
			button.setBounds(272, 72, 147, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Print Statement");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(thisDialog);
					dialog.setModal(true);
					dialog.setVisible(true);
					Expression exp =dialog.getExpression();
					PrintStatement ps = new PrintStatement();
					ps.setE(exp);
					setStatement(ps);
					thisDialog.dispose();
				}
			});
			button.setBounds(272, 122, 147, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Fork Statement");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ForkStatement fs = new ForkStatement();
					
					StatementDialog dialog2 = new StatementDialog("FORK's STATEMENT");
					dialog2.setLocationRelativeTo(contentPanel);
					dialog2.setModal(true);
					dialog2.setVisible(true);
					Statement statemen =dialog2.getStatement();
					fs.setS(statemen);
					setStatement(fs);
					thisDialog.dispose();
				}
			});
			button.setBounds(272, 172, 147, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("LockEnter Statement");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(thisDialog);
					dialog.setModal(true);
					dialog.setVisible(true);
					Expression exp =dialog.getExpression();
					LockEnter le = new LockEnter();
					le.setE(exp);
					setStatement(le);
					thisDialog.dispose();
				}
			});
			button.setBounds(272, 192, 147, 23);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("LockExit Statement");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(thisDialog);
					dialog.setModal(true);
					dialog.setVisible(true);
					Expression exp =dialog.getExpression();
					LockExit le = new LockExit();
					le.setE(exp);
					setStatement(le);
					thisDialog.dispose();
				}
			});
			button.setBounds(272, 212, 147, 23);
			contentPanel.add(button);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public StatementDialog(String name) {
		super(new Frame(),name,true);
			thisDialog =this;
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
			{
				JButton button = new JButton("Compound Statement");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CompoundStatement is = new CompoundStatement();
						
						StatementDialog dialog2 = new StatementDialog("Compound's FIRST STATEMENT");
						dialog2.setLocationRelativeTo(contentPanel);
						dialog2.setModal(true);
						dialog2.setVisible(true);
						Statement statemen =dialog2.getStatement();
						is.setS1(statemen);
						System.out.println("Input second statement:");
						//is.setS2(readStatement());
						StatementDialog dialog3 = new StatementDialog("Compound's Second STATEMENT");
						dialog3.setLocationRelativeTo(contentPanel);
						dialog3.setModal(true);
						dialog3.setVisible(true);
						Statement sttemen =dialog3.getStatement();
						is.setS2(sttemen);
						setStatement(is);
						thisDialog.dispose();
					}
				});
				button.setBounds(10, 72, 147, 23);
				contentPanel.add(button);
			}
			{
				JButton button = new JButton("If Statement");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						IfStatement is = new IfStatement();
						
						ExpressionUI dialog = new ExpressionUI();
						dialog.setLocationRelativeTo(contentPanel);
						dialog.setModal(true);
						dialog.setVisible(true);
						Expression exp =dialog.getExpression();
				
						is.setE(exp);
						
					//	System.out.println("Input first statement:");
						
						StatementDialog dialog2 = new StatementDialog("IF's FIRST STATEMENT");
						dialog2.setLocationRelativeTo(contentPanel);
						dialog2.setModal(true);
						dialog2.setVisible(true);
						Statement statemen =dialog2.getStatement();
						is.setS1(statemen);
						System.out.println("Input second statement:");
						//is.setS2(readStatement());
						StatementDialog dialog3 = new StatementDialog("IF's Secold STATEMENT");
						dialog3.setLocationRelativeTo(contentPanel);
						dialog3.setModal(true);
						dialog3.setVisible(true);
						Statement sttemen =dialog3.getStatement();
						is.setS2(sttemen);
						setStatement(is);
						thisDialog.dispose();
						
					}
				});
				button.setBounds(10, 122, 147, 23);
				contentPanel.add(button);
			}
			{
				JButton button = new JButton("Assign Statement");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						AssignDialog dialog = new AssignDialog();
						dialog.setLocationRelativeTo(contentPanel);
						dialog.setModal(true);
						dialog.setVisible(true);
						Statement stmt=dialog.getStatement();
						setStatement(stmt);
						
						thisDialog.dispose();
					}
				});
				button.setBounds(272, 72, 147, 23);
				contentPanel.add(button);
			}
			{
				JButton button = new JButton("Print Statement");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ExpressionUI dialog = new ExpressionUI();
						dialog.setLocationRelativeTo(thisDialog);
						dialog.setModal(true);
						dialog.setVisible(true);
						Expression exp =dialog.getExpression();
						PrintStatement ps = new PrintStatement();
						ps.setE(exp);
						setStatement(ps);
						thisDialog.dispose();
					}
				});
				button.setBounds(272, 122, 147, 23);
				contentPanel.add(button);
			}
			{
				JButton button = new JButton("Fork Statement");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ForkStatement fs = new ForkStatement();
						
						StatementDialog dialog2 = new StatementDialog("FORK's STATEMENT");
						dialog2.setLocationRelativeTo(contentPanel);
						dialog2.setModal(true);
						dialog2.setVisible(true);
						Statement statemen =dialog2.getStatement();
						fs.setS(statemen);
						setStatement(fs);
						thisDialog.dispose();
					}
				});
				button.setBounds(272, 172, 147, 23);
				contentPanel.add(button);
			}
			{
				JButton button = new JButton("LockEnter Statement");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ExpressionUI dialog = new ExpressionUI();
						dialog.setLocationRelativeTo(thisDialog);
						dialog.setModal(true);
						dialog.setVisible(true);
						Expression exp =dialog.getExpression();
						LockEnter le = new LockEnter();
						le.setE(exp);
						setStatement(le);
						thisDialog.dispose();
					}
				});
				button.setBounds(272, 192, 147, 23);
				contentPanel.add(button);
			}
			{
				JButton button = new JButton("LockExit Statement");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ExpressionUI dialog = new ExpressionUI();
						dialog.setLocationRelativeTo(thisDialog);
						dialog.setModal(true);
						dialog.setVisible(true);
						Expression exp =dialog.getExpression();
						LockExit le = new LockExit();
						le.setE(exp);
						setStatement(le);
						thisDialog.dispose();
					}
				});
				button.setBounds(272, 212, 147, 23);
				contentPanel.add(button);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton okButton = new JButton("OK");
					okButton.setActionCommand("OK");
					buttonPane.add(okButton);
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
	Statement statement;

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	

}
