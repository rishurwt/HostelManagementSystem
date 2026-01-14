package com.knmodi.HostelManagementSystem.dao.impl;

import com.knmodi.HostelManagementSystem.dao.StudentDAO;
import com.knmodi.HostelManagementSystem.model.Student;
import com.knmodi.HostelManagementSystem.util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public int save(Student studentdata) {
        int insertedRows = 0;
        String sql = "INSERT INTO student (student_id, student_name, gender, contact, address, room_id, admission_date, status, hostel_id) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setInt(1, studentdata.getStudentId());
                    ps.setString(2, studentdata.getStudentname());
                    ps.setString(3, studentdata.getGender());
                    ps.setString(4, studentdata.getContact());
                    ps.setString(5, studentdata.getAddress());
                    ps.setInt(6, studentdata.getRoomid());
                    ps.setString(7, studentdata.getAdmissiondate());
                    ps.setString(8, studentdata.getStatus());
                    ps.setInt(9, studentdata.getHostelid());

                    insertedRows = ps.executeUpdate();
                }
            }
        } catch (SQLException sqe) {
            System.out.println("Error saving student: " + sqe.getMessage());
        }
        return insertedRows;
    }

    @Override
    public void delete(int stud_id) {
        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                // Deleting from child tables first to avoid Foreign Key errors
                deleteFromTable(con, "complaints", stud_id);
                deleteFromTable(con, "visitors", stud_id);
                deleteFromTable(con, "attendance", stud_id);
                deleteFromTable(con, "fees", stud_id);
                
                // Finally delete student
                deleteFromTable(con, "student", stud_id);
                System.out.println("Student and related data deleted.");
            }
        } catch (SQLException sqe) {
            System.out.println("Error deleting student: " + sqe.getMessage());
        }
    }

    // Helper method to avoid repeating code
    private void deleteFromTable(Connection con, String tableName, int studentId) throws SQLException {
        String sql = "DELETE FROM " + tableName + " WHERE student_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.executeUpdate();
        }
    }

    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> StudentList = new ArrayList<>();
        String sqlQuery = "SELECT student_id, student_name, gender, contact, address, room_id, admission_date, status, hostel_id FROM student";

        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                try (Statement stmt = con.createStatement();
                     ResultSet result = stmt.executeQuery(sqlQuery)) {
                    while (result.next()) {
                        StudentList.add(mapResultSetToStudent(result));
                    }
                }
            }
        } catch (SQLException sqe) {
            System.out.println(sqe);
        }
        return StudentList;
    }

    @Override
    public ArrayList<Student> findOne(int stu_id) {
        ArrayList<Student> StudentList = new ArrayList<>();
        String sqlQuery = "SELECT student_id, student_name, gender, contact, address, room_id, admission_date, status, hostel_id FROM student WHERE student_id = ?";

        try (Connection con = DataBaseUtil.establishConnection()) {
            if (con != null) {
                try (PreparedStatement pstmt = con.prepareStatement(sqlQuery)) {
                    pstmt.setInt(1, stu_id);
                    try (ResultSet result = pstmt.executeQuery()) {
                        while (result.next()) {
                            StudentList.add(mapResultSetToStudent(result));
                        }
                    }
                }
            }
        } catch (SQLException sqe) {
            System.out.println(sqe);
        }
        return StudentList;
    }

    private Student mapResultSetToStudent(ResultSet result) throws SQLException {
        Student student = new Student();
        student.setStudentId(result.getInt(1));
        student.setStudentname(result.getString(2));
        student.setGender(result.getString(3));
        student.setContact(result.getString(4));
        student.setAddress(result.getString(5));
        student.setRoomid(result.getInt(6));
        student.setAdmissiondate(result.getString(7));
        student.setStatus(result.getString(8));
        student.setHostelid(result.getInt(9));
        return student;
    }
}