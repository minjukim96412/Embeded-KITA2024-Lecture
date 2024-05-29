package javabasic.jdbc.tastyRestraint;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TastyRestraintListGUI extends JFrame{
	private JPanel panel;
	private JTable table;
	private JLabel lilabel;
	private JButton logout;
	private DefaultTableModel tModel;
	
	public TastyRestraintListGUI() throws SQLException {
		 super("List");
		 super.setResizable(true);
		 setSize(1300, 800);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 panel = new JPanel(new BorderLayout());
		 panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		 setContentPane(panel);
		 
		 lilabel = new JLabel("맛집  리스트");
		 lilabel.setFont(new Font("Serif", Font.BOLD, 50));
		 lilabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lilabel.setPreferredSize(new Dimension(400, 80));
		 panel.add(lilabel, BorderLayout.NORTH);
		 table = new JTable(tModel);
		  table.setFont(new Font("돋움", Font.PLAIN, 20));
		  table.setRowHeight(30);
		 List<TastyRestraint> tastyList = null;
		 TastyRestraintDAO trd = new TastyRestraintDAO();
		 List<String> member = Arrays.asList("번호", "아이디", "비밀번호", "성명", "성별", "전화번호", "이메일", "생성일");
		 JScrollPane scrollPane = new JScrollPane(table);
		 panel.add(scrollPane, BorderLayout.CENTER);
		 for (String string : member) {
			
		}
		 tModel.addRow(member);
		 
		 
		 
	}//TastyRestraintListGUI
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				new TastyRestraintListGUI().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
}//JFrame
