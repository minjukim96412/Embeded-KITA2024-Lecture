package javabasic.jdbc.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javabasic.jdbc.ConnectionUtil;

public class StudentMain {

   Connection conn;
   Statement stmt;
   PreparedStatement ps;
   ResultSet rs;

   public StudentMain() {
      conn = ConnectionUtil.getConnection();
   }

   public static void main(String[] args) {

      StudentMain sm = new StudentMain();

      // 1. 테이블, 시퀀스 쿼리문 생성
      String studentSql = sm.createStudentSql();
      String subjectSql = sm.createSubjectSql();
      String studentSequenceSql = sm.createStudentSequenceSql();
      String subjectSequenceSql = sm.createSubjectSequenceSql();
      String joinSql = sm.createJoinSql();

      try {
         // 2. 각 테이블,시퀀스 생성
         sm.createTableOrSequence(subjectSql);
         sm.createTableOrSequence(studentSql);
         sm.createTableOrSequence(studentSequenceSql);
         sm.createTableOrSequence(subjectSequenceSql);

         // 3. 과목 등록
         String[] subjectArr = { "국어", "영어", "수학", "과학", "역사" };
         int subjectArrLen = subjectArr.length;
         
         for (int i = 0; i < subjectArrLen; i++) {
            Subject subject = new Subject(0, subjectArr[i]);
            sm.insertSubject(subject);
         }

         // 4. 학생 등록
         String[][] studentArr = { { "홍길동", "20", "M" }, { "김길순", "30", "F" }, { "최길동", "40", "M" },
               { "박길순", "50", "F" }, { "유길동", "60", "M" } };
         int[][] studentSubArr = { {1,2,3}, {1,2}, {2,3}, {1,3}, {1,2,3,4} };
         
         List<Subject> subjectList = new ArrayList<Subject>();
         int studentArrLen = studentArr.length;
         
         for (int i = 0; i < studentArrLen; i++) {
            int studentSubArrLen = studentSubArr[i].length;
            for (int j = 0; j < studentSubArrLen; j++) {
               subjectList.add(new Subject(studentSubArr[i][j], ""));
            }
            Student student = new Student(0, studentArr[i][0], Integer.parseInt(studentArr[i][1]), studentArr[i][2],
                  subjectList);
            sm.insertStudent(student);
            subjectList.clear();
         }
         
         // 5. 학생과목 결과 출력
         sm.joinStudentSubject(joinSql);
         
         
      } catch (SQLException sqle) {
         sqle.printStackTrace();
      }

   }

//   // 과목 테이블 쿼리문 생성
//   private String createSubjectSql() {
//      StringBuilder sb = new StringBuilder();
//      sb.append(" create table subject(");
//      sb.append(" subno number primary key,");
//      sb.append(" subname varchar2(20)");
//      sb.append(")");
//      return sb.toString();
//   }
//
//   // 학생 테이블 쿼리문 생성
//   private String createStudentSql() {
//      StringBuilder sb = new StringBuilder();
//      sb.append(" create table student( ");
//      sb.append(" sno number primary key, ");
//      sb.append(" sname varchar2(20), ");
//      sb.append(" sage number, ");
//      sb.append(" sgender char(1), ");
//      sb.append(" subno number, ");
//      sb.append(" foreign key (subno) references subject(subno) ");
//      sb.append(")");
//      return sb.toString();
//   }

   // 과목 시퀀스 생성
   private String createSubjectSequenceSql() {
      return " create sequence subject_seq";
   }

   // 학생 시퀀스 생성
   private String createStudentSequenceSql() {
      return " create sequence student_seq";
   }

   

   // 테이블,시퀀스 생성 함수
   private void createTableOrSequence(String sql) throws SQLException {
      stmt = conn.createStatement();
      stmt.execute(sql);
   }

   // 과목 등록 함수
   private int insertSubject(Subject subject) throws SQLException {
      String sql = " insert into subject values(subject_seq.nextval, ?) ";
      ps = conn.prepareStatement(sql);
      ps.setString(1, subject.getSubName());
      return ps.executeUpdate();
   }

   // 학생 등록 함수
   private void insertStudent(Student student) throws SQLException {
      for (Subject subject : student.getSubjectList()) {
         String sql = " insert into student values(student_seq.nextval, ?, ?, ?, ?) ";
         ps = conn.prepareStatement(sql);
         ps.setString(1, student.getSname());
         ps.setInt(2, student.getSage());
         ps.setString(3, student.getSgender());
         ps.setInt(4, subject.getSubNo());
         ps.executeUpdate();
      }
   }
   
   
// 학생과목 쿼리문 생성
   private String createJoinSql() {
      StringBuilder sb = new StringBuilder();
      sb.append(" select s.sno sno, s.sname sname, s.sage sage, s.sgender sgender,");
      sb.append(" sub.subno subno, sub.subname subname");
      sb.append(" from student s, subject sub");
      sb.append(" where s.subno = sub.subno");
      return sb.toString();
   }
   
   // 학생과목 조인 출력 함수
   private void joinStudentSubject(String sql) throws SQLException {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      Student student;
      for (int i = 0; i < student.getSubjectList().size(); i++) {
		List<Subject> subList = null;
		int subjectListSize = student.get(i).getSubjectList().size();
		subList = new ArrayList<Subject>();
		for (int j = 0; j < subList.size(); j++) {
			rs.next();
			 subList.add(new Subject(rs.getInt("SUBNO"), rs.getString("SUBNAME")));
		}
		student = new Student(
	               rs.getInt("sno"),
	               rs.getString("sname"),
	               rs.getInt("sage"),
	               rs.getString("sgender"),
	               subList
	               );
         System.out.println(student.toString());
      }
   }
   ResultSet getJoinedResultSet() throws SQLException{
	   StringBuilder sb = new StringBuilder();
	      sb.append(" select s.sno sno, s.sname sname, s.sage sage, s.sgender sgender,");
	      sb.append(" sub.subno subno, sub.subname subname");
	      sb.append(" from student s, subject sub");
	      sb.append(" where s.subno = sub.subno");
	      String joinSql = sb.toString();
	      
	      Statement stmt = this.conn.createStatement();
	      return stmt.executeQuery(joinSql);
   }
}