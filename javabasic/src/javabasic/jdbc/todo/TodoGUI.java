package javabasic.jdbc.todo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TodoGUI extends JFrame{

	TodoLogic todoLogic;
	
	public TodoGUI() {
		todoLogic = new TodoLogic();
		init();
	}
	
	public static void main(String[] args) {
		new TodoGUI();
		
		
	}
	
	//어플리케이션 초기화 메소드
	private void init() {
		
		//리스트 화면 설정
		Panel listPanel = new Panel(new FlowLayout());
		
		List<Todo> todoList = null;
		try {
		todoList = todoLogic.listTodo();
		for (Todo todo : todoList) {
			
		Panel rowPanel = new Panel(new FlowLayout());
		JLabel todoContent = new JLabel(todo.getTdcontent());
		JLabel todoRegdate = new JLabel(todo.getTdregdate().toString());
		JButton deleteBoutton = new JButton("삭제");
		
		deleteBoutton.setActionCommand("" + todo.getTdid());
		
		deleteBoutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
//				System.out.println(ae.getActionCommand()); 
					Todo todo = new Todo(Integer.parseInt(ae.getActionCommand()), null, null,null);
					try {
						todoLogic.deleteTodo(todo);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		rowPanel.add(todoContent);
		rowPanel.add(todoRegdate);
		rowPanel.add(deleteBoutton);
		listPanel.add(rowPanel);
		JScrollPane scrollPane = new JScrollPane(listPanel);
		add(scrollPane, BorderLayout.CENTER);
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}

		//입력 화면 설정
		Panel writePanel = new Panel(new BorderLayout());
		JTextField todoTextField = new JTextField(20);
		JButton writeButton = new JButton("등록");
		writeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				String tfText = todoTextField.getText();
				if (tfText != null && !tfText.trim().equals("")) {
					
					Todo todo = new Todo(0, tfText, null, null);
				try {
					todoLogic.writeTodo(todo);
					} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}
			}
		});
		
		
		writePanel.add(todoTextField, BorderLayout.CENTER);
		writePanel.add(writeButton, BorderLayout.EAST);
		
		
		//전체 화면설정
		this.setTitle(":::java Todo App:::");
		this.setLayout(new BorderLayout());
		this.setSize(400,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(listPanel, BorderLayout.CENTER);
		this.add(writePanel, BorderLayout.SOUTH);

		//화면이 보이게 설정
		this.setVisible(true);
	}
	
}
