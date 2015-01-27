package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Expression.ArithExpression;
import Model.Expression.ConstExpression;
import Model.Expression.Expression;
import Model.Expression.VarExpression;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExpressionUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldConstant;
	JDialog dial;
	private JTextField textFieldVariable;
	private JTextField textFieldOperand;
	Expression expression;
	protected Expression expLeft;
	protected Expression expRight;

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ExpressionUI dialog = new ExpressionUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExpressionUI() {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		dial =this;
		contentPanel.setLayout(null);
		{
			JLabel lblConstant = new JLabel("Constant");
			lblConstant.setBounds(10, 6, 71, 50);
			contentPanel.add(lblConstant);
		}
		{
			textFieldConstant = new JTextField();
			textFieldConstant.setBounds(10, 67, 86, 20);
			contentPanel.add(textFieldConstant);
			textFieldConstant.setColumns(10);
		}
		{
			JButton btnSubmitConstant = new JButton("submit");
			btnSubmitConstant.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ConstExpression cx = new ConstExpression(Integer.valueOf(textFieldConstant.getText()));
					expression=cx;
					dial.dispose();
				}
			});
			btnSubmitConstant.setBounds(7, 168, 89, 23);
			contentPanel.add(btnSubmitConstant);
		}
		{
			JLabel lblVariable = new JLabel("Variable");
			lblVariable.setBounds(143, 6, 86, 50);
			contentPanel.add(lblVariable);
		}
		{
			textFieldVariable = new JTextField();
			textFieldVariable.setBounds(143, 67, 86, 20);
			contentPanel.add(textFieldVariable);
			textFieldVariable.setColumns(10);
		}
		{
			JButton btnSubmitVariable = new JButton("submit");
			btnSubmitVariable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VarExpression ve = new VarExpression(String.valueOf(textFieldVariable.getText()));
					expression=ve;
					dial.dispose();
				}
			});
			btnSubmitVariable.setBounds(143, 168, 89, 23);
			contentPanel.add(btnSubmitVariable);
		}
		{
			textFieldOperand = new JTextField();
			textFieldOperand.setBounds(303, 81, 86, 20);
			contentPanel.add(textFieldOperand);
			textFieldOperand.setColumns(10);
		}
		{
			final JButton btnLeft = new JButton("left expression");
			btnLeft.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(contentPanel);
					dialog.setModal(true);
					dialog.setVisible(true);
					 expLeft =dialog.getExpression();
				}
			});
			
			btnLeft.setBounds(293, 47, 131, 23);
			contentPanel.add(btnLeft);
		}
		{
			JLabel lblArithmetic = new JLabel("Arithmetic");
			lblArithmetic.setBounds(293, 11, 75, 26);
			contentPanel.add(lblArithmetic);
		}
		{
			final JButton btnRightExpression = new JButton("right expression");
			btnRightExpression.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ExpressionUI dialog = new ExpressionUI();
					dialog.setLocationRelativeTo(contentPanel);
					dialog.setModal(true);
					dialog.setVisible(true);
					 expRight =dialog.getExpression();
				}
			});
			btnRightExpression.setBounds(300, 112, 124, 23);
			contentPanel.add(btnRightExpression);
		}
		{
			JButton btnSubmitArithmetic = new JButton("submit");
			btnSubmitArithmetic.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					ArithExpression ae = new ArithExpression();
					
					ae.setL(expLeft);
					
					ae.setOp(textFieldOperand.getText().charAt(0));
					
					ae.setR(expRight);
					
					expression=ae;
					dial.dispose();
				}
			});
			btnSubmitArithmetic.setBounds(300, 168, 89, 23);
			contentPanel.add(btnSubmitArithmetic);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
		}
	}

}
