package javabasic.jdbc.tastyRestaurant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;




public class TastyRestaurantGUI extends JFrame {
    private static final long serialVersionUID = 11248794152L;
    Connection conn;
    CallableStatement cstmt;
    TastyRestaurantMain trm = new TastyRestaurantMain();
    private JButton insertButton;
    private JPanel rPanel;
    private JLabel rLabel;
    private JLabel lrname, lcategory, lip, lmenu, lprice, lscore, lreview;
    private JTextField inputRestaurant_name, inputRestaurant_ip, inputRestaurant_menu,
            inputmenu_price, inputRestaurant_score, inputRestaurant_review;
    private JComboBox<String> categoryComboBox;

    public TastyRestaurantGUI() {
        super("맛집리스트");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        trm = new TastyRestaurantMain();
        String sql = "{ call PROC_INSERT_TASTY(?, ?, ?, ?, ?, ?, ?) }";

        Color buttonColor = new Color(75, 75, 75);
        Font textFont = new Font("Malgun Gothic", Font.PLAIN, 14);
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
        inputRestaurant_name = new JTextField();
        main.add(inputRestaurant_name);

        String[] categories = {"분식", "아시안", "한식", "양식", "야식", "기타"}; // 카테고리 목록 배열
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.setBackground(Color.WHITE);

        lcategory = new JLabel("종류");
        lcategory.setFont(textFont);
        lcategory.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(lcategory);
        main.add(categoryComboBox);

        lip = new JLabel("주소");
        lip.setFont(textFont);
        lip.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(lip);
        inputRestaurant_ip = new JTextField();
        main.add(inputRestaurant_ip);

        lmenu = new JLabel("주요메뉴");
        lmenu.setFont(textFont);
        lmenu.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(lmenu);
        inputRestaurant_menu = new JTextField();
        main.add(inputRestaurant_menu);

        lprice = new JLabel("가격");
        lprice.setFont(textFont);
        lprice.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(lprice);
        inputmenu_price = new JTextField();
        main.add(inputmenu_price);

        lscore = new JLabel("맛 점수 (5점 만점)");
        lscore.setFont(textFont);
        lscore.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(lscore);
        inputRestaurant_score = new JTextField();
        main.add(inputRestaurant_score);

        lreview = new JLabel("한줄평");
        lreview.setFont(textFont);
        lreview.setHorizontalAlignment(SwingConstants.CENTER);
        main.add(lreview);
        inputRestaurant_review = new JTextField();
        main.add(inputRestaurant_review);

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
                            trm.cstmt.setString(1, inputRestaurant_name.getText());
                            // 콤보박스에서 선택한 값을 가져옴
                            String selectedCategory = (String) categoryComboBox.getSelectedItem();
                            trm.cstmt.setString(2, selectedCategory);
                            trm.cstmt.setString(3, inputRestaurant_ip.getText());
                            trm.cstmt.setString(4, inputRestaurant_menu.getText());
                            trm.cstmt.setInt(5, Integer.parseInt(inputmenu_price.getText()));
                            trm.cstmt.setDouble(6, Double.parseDouble(inputRestaurant_score.getText()));
                            trm.cstmt.setString(7, inputRestaurant_review.getText());
                            int result = trm.cstmt.executeUpdate();
                            if (result > 0) {
                                JOptionPane.showMessageDialog(null, "맛집리스트 등록 완료!");
                                TastyRestaurantListGUI.main(null);
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(null, "맛집리스트 등록 실패!");
                            }
                        } catch (SQLException sqle) {
                            JOptionPane.showMessageDialog(null, "맛집리스트 등록 실패!\n" + sqle.getMessage());
                            sqle.printStackTrace();
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(null, "가격과 점수에 숫자만 입력 해주세요!(점수에는 0~5점 사이에 점수만 입력가능합니다.)");
                        }
                    }
                });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TastyRestaurantGUI().setVisible(true);
        });
    }
}