package javabasic.jdbc.tastyRestaurant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javabasic.jdbc.ConnectionUtil;

public class TastyRestaurantListGUI extends JFrame {

	private static final long serialVersionUID = 1123875425456L;
    private JPanel northPanel, southPanel; 
    private JTable table, table2;
    private JLabel lilabel;
    private JButton insertButton, deleteButton;

    public TastyRestaurantListGUI() throws SQLException {
        super("List");
        super.setResizable(true);
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        northPanel = new JPanel(new BorderLayout());
        northPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        add(northPanel, BorderLayout.NORTH);

        
        southPanel = new JPanel(new BorderLayout());
        southPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(southPanel, BorderLayout.CENTER); // Changed to CENTER

        lilabel = new JLabel("맛집  리스트");
        lilabel.setFont(new Font("돋움", Font.BOLD, 50));
        lilabel.setHorizontalAlignment(SwingConstants.CENTER);
        lilabel.setPreferredSize(new Dimension(300, 60));
        northPanel.add(lilabel, BorderLayout.NORTH);

        insertButton = new JButton("등록");
        insertButton.setForeground(Color.BLACK);
        northPanel.add(insertButton, BorderLayout.WEST);

        Object[][] rowData = {};
        String[] columnNames = { "TID", "RESTAURANT_NAME", "FOOD_CATEGORY", "RESTAURANT_IP", "RESTAURANT_MENU",
                "MENU_PRICE", "RESTAURANT_SCORE", "RESTAURANT_REVIEW", "TREGDATE" };

        String[] namelist = { "번호", "식당이름", "카테고리", "주소", "주요메뉴", "메뉴가격", "점수(5점 만점)", "한줄평", "등록일" };
        DefaultTableModel dmt2 = new DefaultTableModel(new Object[0][], namelist);
       
        table2 = new JTable(dmt2);
        table2.setFont(new Font("gothic", Font.PLAIN, 50));
        JTableHeader table2Header = table2.getTableHeader();
        table2Header.setPreferredSize(new Dimension(30, 30));
        Font headerFont = new Font("gothic", Font.BOLD, 18); // 원하는 폰트, 스타일, 크기로 설정
        table2.getTableHeader().setFont(headerFont);
        
        table2.setIntercellSpacing(new Dimension(0, 0));
        JScrollPane table2ScrollPane = new JScrollPane(table2);
        table2ScrollPane.setPreferredSize(new Dimension(30, 30)); // 원하는 크기로 조정
        southPanel.add(table2ScrollPane, BorderLayout.NORTH); // Changed to CENTER

        DefaultTableModel dmt = new DefaultTableModel(rowData, columnNames);
        table = new JTable(dmt);
        table.setFont(new Font("돋움", Font.PLAIN, 15));
        table.setRowHeight(20);
        table.setIntercellSpacing(new Dimension(0, 0)); // 간격 없애기
        JScrollPane scrollPane = new JScrollPane(table);
        southPanel.add(scrollPane, BorderLayout.CENTER); // Changed to CENTER

        List<TastyRestaurant> tastyList = null;
        TastyRestaurantDAO trd = new TastyRestaurantDAO();
        tastyList = trd.listTasty();
        if (tastyList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "저장된 맛집정보가 없습니다.");
            dispose(); 
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (TastyRestaurant tastyRestaurant : tastyList) {
            Vector<Object> rowData1 = new Vector<Object>();
            rowData1.add(tastyRestaurant.getTid());
            rowData1.add(tastyRestaurant.getRestaurant_name());
            rowData1.add(tastyRestaurant.getFood_category());
            rowData1.add(tastyRestaurant.getRestaurant_ip());
            rowData1.add(tastyRestaurant.getRestaurant_menu());
            rowData1.add(tastyRestaurant.getMenu_price());
            rowData1.add(tastyRestaurant.getRestaurant_score());
            rowData1.add(tastyRestaurant.getRestaurant_review());
            rowData1.add(tastyRestaurant.getTregdate());
            model.addRow(rowData1);
        }

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TastyRestaurantGUI.main(null);
                dispose();
            }
        });

        // 테이블 수정
        Connection conn;
        conn = ConnectionUtil.getConnection();

        table.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();

                int id = (int) model.getValueAt(row, 0);

                String columnName = model.getColumnName(column);
                Object newData = model.getValueAt(row, column);

                try {
                    String updateQuery = "UPDATE TASTY_RESTAURANT_LIST SET " + columnName + " = ? WHERE tid = ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);

                    preparedStatement.setObject(1, newData);
                    preparedStatement.setInt(2, id);
                    preparedStatement.executeUpdate();

                } catch (SQLException ex) {
                    ex.printStackTrace(); 
                }
            }
        });
        
        deleteButton = new JButton("삭제");
        deleteButton.setForeground(Color.BLACK);
        northPanel.add(deleteButton, BorderLayout.EAST);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // 한 번의 클릭 감지
                    final int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) { // 선택된 행이 있는지 확인
                        ActionListener deleteListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    int choice = JOptionPane.showConfirmDialog(null,
                                            "선택한 리스트를 정말로 삭제 하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
                                    if (choice == JOptionPane.YES_OPTION) {
                                        TastyRestaurantDAO td = new TastyRestaurantDAO();
                                        int id = (int) model.getValueAt(selectedRow, 0); // 선택된 행의 ID 가져오기

                                        TastyRestaurant tastyRestaurant = new TastyRestaurant(id, null, null, null, null, 0,
                                                0.0, null, null);
                                        td = new TastyRestaurantDAO();
                                        td.deleteTasty(tastyRestaurant);
                                        model.removeRow(selectedRow); // 모델에서 선택된 행 삭제
                                    }
                                    // 액션 리스너 제거
                                    deleteButton.removeActionListener(this);
                                } catch (SQLException e1) {
                                	
                                }
                            }
                        };
                        deleteButton.addActionListener(deleteListener);
                    } else {
                        
                    }
                }
            }
        });


    }// TastyRestraintListGUI

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new TastyRestaurantListGUI().setVisible(true);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

}// JFrame
