package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Model.Expression.Expression;
import Model.Statement.AssignStatement;
import Model.Statement.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JDialog dial;
	private JTextField textFieldVarible;
	private Statement statement;
	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
	private Expression exp;

	public Expression getExp() {
		return exp;
	}

	public void setExp(Expression exp) {
		this.exp = exp;
	}

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AssignDialog dialog = new AssignDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AssignDialog(Frame parentFrame)
	{
		super(parentFrame,"Add an assign statement",true);
		dial=this;
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textFieldVarible = new JTextField();
			textFieldVarible.setBounds(20, 90, 86, 20);
			contentPanel.add(textFieldVarible);
			textFieldVarible.setColumns(10);
		}
		{
			JLabel lblInputVariable = new JLabel("input Variable");
			lblInputVariable.setBounds(10, 29, 200, 50);
			contentPanel.add(lblInputVariable);
		}
		{
			JButton btnCreateExpression = new JButton("Create Expression");
			btnCreateExpression.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Expression ex;
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(contentPanel);
					dialog.setVisible(true);
					exp =dialog.getExpression();
				}
			});
			btnCreateExpression.setBounds(9, 147, 146, 23);
			contentPanel.add(btnCreateExpression);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						AssignStatement as = new AssignStatement();
						as.setVar(textFieldVarible.getText());
						as.setE(exp);
						setStatement(as);
						dial.dispose();
						
					}
				});
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
	public AssignDialog() {
		super(new Frame(),"Add an assign statement",true);
		dial=this;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textFieldVarible = new JTextField();
			textFieldVarible.setBounds(20, 90, 86, 20);
			contentPanel.add(textFieldVarible);
			textFieldVarible.setColumns(10);
		}
		{
			JLabel lblInputVariable = new JLabel("input Variable");
			lblInputVariable.setBounds(10, 29, 200, 50);
			contentPanel.add(lblInputVariable);
		}
		{
			JButton btnCreateExpression = new JButton("Create Expression");
			btnCreateExpression.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Expression ex;
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(contentPanel);
					dialog.setModal(true);
					dialog.setVisible(true);
					setExp(dialog.getExpression());
				}
			});
			btnCreateExpression.setBounds(9, 147, 146, 23);
			contentPanel.add(btnCreateExpression);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						AssignStatement as = new AssignStatement();
						as.setVar(textFieldVarible.getText());
						as.setE(getExp());
						setStatement(as);
						dial.dispose();
						
					}
				});
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

}
