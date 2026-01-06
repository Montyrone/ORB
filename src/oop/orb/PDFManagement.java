package oop.orb;
import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.Timer; // For the Timer class
import java.awt.event.ActionEvent; // For the ActionEvent class
import java.text.SimpleDateFormat; // For formatting the time
import java.util.Date; // For getting the current date and time


public class PDFManagement extends javax.swing.JFrame {
    private Connection conn;
    private String fullName;
    private String email;
    private Timer timer;
    
    public PDFManagement(String email, String fullName) {
        this.fullName = fullName;  
        this.email = email;
        initComponents();  // Initialize the components of the JFrame
        connectToDatabase();
        setLocationRelativeTo(null);
        startClock();
        populateTable();
    }
    
    private void startClock() {
        timer = new Timer(1000, (ActionEvent e) -> {
            String currentTime = getCurrentTime();
            jLabel2.setText(currentTime); // Update jLabel2 with the current time
        });
        timer.start(); // Start the timer
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
    
        public List<String> getPdfFileNamesFromDatabase() {
            List<String> fileNames = new ArrayList<>();
            String query = "SELECT filename FROM pdfs";  // Use the correct column name

            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    String fileName = rs.getString("filename"); // Adjust based on actual column name
                    fileNames.add(fileName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return fileNames;
        }
        
    public void populateJListWithPdfFiles() {
        // Get PDF file names from the database
        List<String> fileNames = getPdfFileNamesFromDatabase();

        // Create a DefaultTableModel to hold the file names
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");

        // Add each file name as a new row in the table
        for (String fileName : fileNames) {
            tableModel.addRow(new Object[] {fileName});
        }

        jTable1.setModel(tableModel);
    }
    
    private void connectToDatabase() {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/OrbRegisters?allowPublicKeyRetrieval=true&useSSL=false";
            String dbUser = "root"; // Your database username
            String dbPassword = "yourpassword"; // Your database password
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);  // Establish connection
            System.out.println("Database connected successfully.");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.");
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("00:00:00");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // Set font size
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center-align text
        getContentPane().add(jLabel2);
        jLabel2.setBounds(50, 20, 200, 30); // Set position and size (example)

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("Time");

        jButton3.setText("LOG OUT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/orb/5.png"))); // NOI18N
        jLabel4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/oop/orb/Rafal.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USER");

        jButton1.setText("ADD");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("OPEN");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PDF"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    // File Chooser to select PDF file
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files", "pdf"));

    int result = fileChooser.showOpenDialog(this);
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        // Ensure the file is a PDF
        if (!selectedFile.getName().endsWith(".pdf")) {
            JOptionPane.showMessageDialog(this, "Please select a valid PDF file.", "Invalid File", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get the logged-in user's full name
        String userName = this.fullName;
        if (userName == null || userName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "User information is not available. Please log in.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Check database for PDF limit
        String dbUrl = "jdbc:mysql://localhost:3306/OrbRegisters?useSSL=false";
        String dbUser = "root";
        String dbPassword = "yourpassword";
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Check if the total PDFs stored is less than 10
            String countSql = "SELECT COUNT(*) AS pdf_count FROM pdfs";
            stmt = conn.prepareStatement(countSql);
            ResultSet rs = stmt.executeQuery();

            int pdfCount = 0;
            if (rs.next()) {
                pdfCount = rs.getInt("pdf_count");
            }
            rs.close();
            stmt.close();

            if (pdfCount >= 20) {
                JOptionPane.showMessageDialog(this, "Limit reached! You can only store up to 10 PDFs.", "Limit Reached", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String targetDirectory = "C:\\Notes\\" + this.fullName + "\\"; // Replace with your folder path

            // Create the folder if it doesn't exist
            File targetFolder = new File(targetDirectory);
            if (!targetFolder.exists()) {
                targetFolder.mkdirs();
            }

            // Define the destination file path
            File destinationFile = new File(targetFolder, selectedFile.getName());

            // Copy the selected file to the target folder
            Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Insert the selected PDF into the database (only storing the filename)
            String insertSql = "INSERT INTO pdfs (filename, user_name) VALUES (?, ?)";
            stmt = conn.prepareStatement(insertSql);

            String fileName = selectedFile.getName();

            stmt.setString(1, fileName); // Set the PDF name
            stmt.setString(2, userName); // Set the logged-in user's full name

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "PDF added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Update the interface to display the new PDF
                updatePDFList();
            }

            stmt.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error closing resources: " + ex.getMessage(), "Resource Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        }
    }//GEN-LAST:event_jButton1MouseClicked

    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Get the selected row index
    int selectedRow = jTable1.getSelectedRow();

    // Check if a row is selected
    if (selectedRow != -1) {
        // Get the PDF filename from the first column (assuming the filename is in the first column)
        String selectedItem = (String) jTable1.getValueAt(selectedRow, 0);

        // Construct the file path using the selected item and the folder where the PDFs are stored
        String filePath = "C:/Notes/" + this.fullName + "/" + selectedItem;  // or use \\ if needed
        File file = new File(filePath);

        // Check if the file exists
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);  // Open the file if it exists
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error opening PDF.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "The file does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No item selected.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        LoginMenu loginMenu = new LoginMenu(); // Create a new instance of LoginMenu
        loginMenu.setVisible(true); // Show the login menu
        this.dispose(); // Close the current window (PDFManagement)
    }//GEN-LAST:event_jButton3ActionPerformed

    public void populateTable() {
    String query = "SELECT * FROM pdfs"; // Assuming 'filename' is the column storing PDF names

    // Path to the folder
    String folderPath = "C:/Notes/" + this.fullName + "/";

    try (Connection conn = DBConnect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        // Get the table's model
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Clear any existing rows in the table
        model.setRowCount(0);

        // Add rows from the ResultSet to the table model
        while (rs.next()) {
            String fileName = rs.getString("filename");
            File file = new File(folderPath + fileName); // Construct the full path to the PDF

            // Check if the file exists in the specified folder
            if (file.exists() && file.isFile() && file.getName().endsWith(".pdf")) {
                model.addRow(new Object[]{fileName}); // Add the file to the table if it exists
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
        // Optional: Show a user-friendly error message
        javax.swing.JOptionPane.showMessageDialog(null, "Error fetching data from the database!");
    }
    }
    
   private void updatePDFList() {
        // Path to the folder
        String folderPath = "C:/Notes/" + this.fullName + "/";

        // Create a new DefaultTableModel with a column for filenames
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("File Name");  // Adding a column for file names

        try (Statement stmt = conn.createStatement()) {
            // Query the database to get the list of PDFs
            ResultSet rs = stmt.executeQuery("SELECT filename FROM pdfs");

            // Loop through the result set and add each filename as a new row in the table
            while (rs.next()) {
                String fileName = rs.getString("filename");
                File file = new File(folderPath + fileName); // Construct the full path to the PDF

                // Check if the file exists in the specified folder
                if (file.exists() && file.isFile() && file.getName().endsWith(".pdf")) {
                    tableModel.addRow(new Object[] { fileName });  // Add a new row with the file name
                }
            }

            // Set the table model to the JTable
            jTable1.setModel(tableModel);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while retrieving PDFs.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PDFManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PDFManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PDFManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PDFManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PDFManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
