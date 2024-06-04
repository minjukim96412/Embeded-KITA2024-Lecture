package javabasic.jdbc.tastyRestaurant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class TastyRestaurantListGUI extends JFrame {
    private JPanel northPanel, southPanel, eastPanel;
    private JTable table;
    private JLabel lilabel;
    private JButton insertButton, deleteButton, updateButton;
    private List<TastyRestaurant> tastyList;

    public TastyRestaurantListGUI() {
        super("List");
        super.setResizable(true);
        setSize(1300, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.WHITE);

        Color backgroundColor = new Color(255, 240, 250);

        northPanel = new JPanel(new BorderLayout());
        northPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        northPanel.setBackground(Color.WHITE);
        add(northPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        northPanel.add(buttonPanel, BorderLayout.WEST);

        insertButton = new JButton("등록");
        insertButton.setForeground(Color.BLACK);
        insertButton.setBackground(backgroundColor);

        deleteButton = new JButton("삭제");
        deleteButton.setForeground(Color.BLACK);
        deleteButton.setBackground(backgroundColor);

        updateButton = new JButton("새로고침");
        updateButton.setForeground(Color.BLACK);
        updateButton.setBackground(backgroundColor);

        buttonPanel.add(insertButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(Color.WHITE);

        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("검색");
        
        southPanel = new JPanel(new BorderLayout());
        southPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        southPanel.setBackground(Color.WHITE);
        add(southPanel, BorderLayout.CENTER);

        lilabel = new JLabel("맛집 리스트");
        lilabel.setBackground(Color.WHITE);
        lilabel.setFont(new Font("휴먼편지체", Font.BOLD, 50));
        lilabel.setHorizontalAlignment(SwingConstants.CENTER);
        lilabel.setPreferredSize(new Dimension(300, 60));
        northPanel.add(lilabel, BorderLayout.NORTH);

        Object[][] rowData = {};
        String[] namelist = { "번호", "식당이름", "카테고리", "주소", "주요메뉴", "메뉴가격", "점수(5점 만점)", "한줄평", "등록일" };
        
        DefaultTableModel dmt = new DefaultTableModel(rowData, namelist);
        table = new JTable(dmt);
        table.setFont(new Font("돋움", Font.PLAIN, 15));

        table.setBackground(backgroundColor);
        Font headerFont = new Font("함초롬돋움", Font.BOLD, 18);
        table.getTableHeader().setBackground(backgroundColor);
        table.getTableHeader().setFont(headerFont);
        table.setRowHeight(30);
        table.setBackground(Color.WHITE);
        table.setIntercellSpacing(new Dimension(0, 0));
        JScrollPane scrollPane = new JScrollPane(table);
        southPanel.add(scrollPane, BorderLayout.CENTER);

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TastyRestaurantGUI.main(null);
                dispose();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                if (!searchText.isEmpty()) {
                    filterTable(searchText);
                } else {
                    resetTable();
                }
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        northPanel.add(buttonPanel, BorderLayout.WEST);
        northPanel.add(searchPanel, BorderLayout.EAST);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
//                int selectedRow = table.getSelectedRow();
//                if (selectedRow >= 0 && selectedRow < popupShownArray.length) {
//                    popupShownArray[selectedRow] = false;
//                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TastyRestaurantListGUI().setVisible(true);
            }
        });

        refreshTastyList(); // GUI 생성 시 맛집 리스트를 초기화합니다.
        setVisible(true);
    }

    private void refreshTastyList() {
        try {
            TastyRestaurantDAO trd = new TastyRestaurantDAO();
            tastyList = trd.listTasty();
            displayTastyList();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void displayTastyList() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // 테이블의 모든 행을 삭제합니다.

        for (TastyRestaurant tastyRestaurant : tastyList) {
            model.addRow(new Object[]{
                    tastyRestaurant.getTid(),
                    tastyRestaurant.getRestaurant_name(),
                    tastyRestaurant.getFood_category(),
                    tastyRestaurant.getRestaurant_ip(),
                    tastyRestaurant.getRestaurant_menu(),
                    tastyRestaurant.getMenu_price(),
                    tastyRestaurant.getRestaurant_score(),
                    tastyRestaurant.getRestaurant_review(),
                    tastyRestaurant.getTregdate()
            });
        }
    }

    private void filterTable(String searchText) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        RowFilter<TableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
        sorter.setRowFilter(rowFilter);
    }

    private void resetTable() {
        table.setRowSorter(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new TastyRestaurantListGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}