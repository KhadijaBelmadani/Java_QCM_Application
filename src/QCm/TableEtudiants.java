package QCm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableEtudiants {
    public String[] columnNames = {"CNE", "UserName", "Filiere", "score"};

    public TableEtudiants() {
		 

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_qcm", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[][] data = new String[100][4];
        int rowCount = 0;
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT CNE, UserName, Filiere, score FROM user_score");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                data[rowCount][0] = resultSet.getString("CNE");
               data[rowCount][1] = resultSet.getString("UserName");
                data[rowCount][2] = resultSet.getString("Filiere");
                data[rowCount][3] = String.valueOf(resultSet.getInt("score"));
                rowCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JFrame frame = new JFrame("Table des étudiants");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setContentPane(panel);
        frame.setVisible(true);

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TableEtudiants();
    }
}
