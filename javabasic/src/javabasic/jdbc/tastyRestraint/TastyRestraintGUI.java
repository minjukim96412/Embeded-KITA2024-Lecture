package javabasic.jdbc.tastyRestraint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;




public class TastyRestraintGUI extends JFrame{
	private static final long serialVersionUID = 11248794152L;
	Connection conn;
	CallableStatement cstmt;
	TastyRestraintMain trm = new TastyRestraintMain();
	private JButton insertButton;
	private JButton exitButton;
	private JPanel rPanel;
	private JLabel rLabel;
	private JLabel lrname, lcategory, lip, lmenu, lprice, lscore, lreview;
	private JTextField inputRestraint_name, inputfood_category, inputrestraint_ip;
	private JTextField inputrestraint_menu, inputmenu_price; 
	private JTextField inputrestraint_score, inputrestraint_review;
	
	public TastyRestraintGUI() {
	super("맛집리스트");	
	// 창 크기
		setSize(400, 500);
	// x버튼 누르면 프로그램 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	trm = new TastyRestraintMain();
	String sql = 
			" { call PROC_INSERT_TASTY(?, ?, ?, ?, ?, ?, ?) } ";		
	
	Color backgroundColor = new Color(240, 240, 240);
	// 버튼색
	Color buttonColor = new Color(75, 75, 75);
	// 글자색
	Color textColor = new Color(50, 50, 50);
	// 채팅 텍스트 폰트
	Font textFont = new Font("Malgun Gothic", Font.PLAIN, 14);
	// 버튼 텍스트 폰트
	Font buttonFont = new Font("Malgun Gothic", Font.BOLD, 12);

	 rPanel = new JPanel();
	 rPanel.setLayout(new BorderLayout());
	 setContentPane(rPanel);
		
	rLabel = new JLabel("맛집리스트");
	rLabel.setHorizontalAlignment(SwingConstants.CENTER);
	rPanel.add(rLabel, BorderLayout.NORTH); 
	JPanel main = new JPanel(new GridLayout(7, 2, 10, 10)); 
	
	lrname = new JLabel("식당 이름");
	lrname.setFont(textFont);
	lrname.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(lrname);
    inputRestraint_name = new JTextField();
    main.add(inputRestraint_name);
    
    
    lcategory = new JLabel("종류");
    lcategory.setFont(textFont);
    lcategory.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(lcategory);
    inputfood_category = new JTextField();
    main.add(inputfood_category);

    lip = new JLabel("주소");
    lip.setFont(textFont);
    lip.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(lip);
    inputrestraint_ip = new JTextField();
    main.add(inputrestraint_ip);
    
    lmenu = new JLabel("주요메뉴");
    lmenu.setFont(textFont);
    lmenu.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(lmenu);
    inputrestraint_menu = new JTextField();
    main.add(inputrestraint_menu);
    
    lprice = new JLabel("가격");
    lprice.setFont(textFont);
    lprice.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(lprice);
    inputmenu_price = new JTextField();
    main.add(inputmenu_price); 
    
    lscore = new JLabel("맛 점수");
    lscore.setFont(textFont);
    lscore.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(lscore);
    inputrestraint_score = new JTextField();
    main.add(inputrestraint_score); 
	
    lreview= new JLabel("한줄평");
    lreview.setFont(textFont);
    lreview.setHorizontalAlignment(SwingConstants.CENTER);
    main.add(lreview);
    inputrestraint_review = new JTextField();
    main.add(inputrestraint_review); 
    
	rPanel.add(main, BorderLayout.CENTER);
	JPanel sMain = new JPanel();
    rPanel.add(sMain, BorderLayout.EAST);
    
    
	insertButton = new JButton("등록");
	insertButton.setFont(buttonFont);
	insertButton.setBackground(buttonColor);
	insertButton.setForeground(Color.WHITE);
	rPanel.add(insertButton, BorderLayout.SOUTH);
	
	insertButton.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						trm.cstmt = trm.conn.prepareCall(sql);
						trm.cstmt.setString(1, inputRestraint_name.getText());
						trm.cstmt.setString(2, inputfood_category.getText());
						trm.cstmt.setString(3, inputrestraint_ip.getText());
						trm.cstmt.setString(4, inputrestraint_menu.getText());
						trm.cstmt.setInt(5, Integer.parseInt(inputmenu_price.getText()));
						trm.cstmt.setDouble(6, Double.parseDouble(inputrestraint_score.getText()));
						trm.cstmt.setString(7, inputrestraint_review.getText());
						int result = trm.cstmt.executeUpdate();
						if (result > 0) {
							JOptionPane.showMessageDialog(null, "맛집리스트 등록 완료!");
			                dispose();
			            } else {
			                JOptionPane.showMessageDialog(null, "맛집리스트 등록 실패!");
			                dispose();
			            }
					} catch (SQLException sqle) {
						// TODO Auto-generated catch block
						sqle.printStackTrace();
					}
				}
			}
			
		);
	
	}//TastyRestraintGUI

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new TastyRestraintGUI().setVisible(true);
		});
	}
	
	
	
	
}
