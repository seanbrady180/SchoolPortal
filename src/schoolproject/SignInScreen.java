/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import static schoolproject.SchoolProject.keyValue;
import static schoolproject.SchoolProject.setKey;
import sun.misc.BASE64Encoder;

/**
 *
 * @author seanb
 */
final class SignInScreen extends javax.swing.JFrame {

    private final String DB_URL = "jdbc:mysql://schoolportal.ck4ehi6goau1.eu-west-1.rds.amazonaws.com:3306/SchoolPortal";
    private byte[] salt = {'K', 'a', 'O', 'p', '3', 'T', 'T', 'O', 'I', 'M', 'b', 'l', '9', 'n', 'A', 'o', 'D', 'u', 'd', 'C', 'Q', 'p', 'C', 'a', 'E', '6', 'z', 'H', 'j', 'F', 'p', 'z'};
    private String accountType;
    private Properties prop = new Properties();
    private InputStream input = null;
    private String encryptedData;
    private char[] decryptedData;
    private static SecretKeySpec schoolNumber;
    private String username;
    private String dbusername;
    private char[] password;
    private static byte[] key;
    private char[] convertedChar;
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet results;
    private ResultSet results2;
    private String encryptedPW;
    private String dbPassword;
    private adminMainMenu adminMainMenu = new adminMainMenu();
    private ParentMainMenu parentMainMenu = new ParentMainMenu();
    private TeacherMainMenu teacherMainMenu = new TeacherMainMenu();
    
    
  
    

    void Type(String type) {
        this.accountType = type;
    }

    ;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        backgroundPanel = new javax.swing.JPanel();
        popUp = new javax.swing.JPanel();
        okBT = new javax.swing.JButton();
        warningTxt = new javax.swing.JTextField();
        errorTxt = new javax.swing.JTextField();
        logoLabel = new javax.swing.JLabel();
        logoTF = new javax.swing.JTextField();
        userNameTxt = new javax.swing.JTextField();
        userNameTF = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        passwordPF = new javax.swing.JPasswordField();
        signInBT = new javax.swing.JButton();
        backBT = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1000, 1000));

        backgroundPanel.setBackground(new java.awt.Color(250, 228, 188));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(1000, 1000));
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        popUp.setBackground(new java.awt.Color(65, 147, 211));

        okBT.setBackground(new java.awt.Color(250, 228, 188));
        okBT.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        okBT.setText("OK");
        okBT.setBorder(null);
        okBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBTActionPerformed(evt);
            }
        });

        warningTxt.setEditable(false);
        warningTxt.setBackground(new java.awt.Color(65, 147, 211));
        warningTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 30)); // NOI18N
        warningTxt.setForeground(new java.awt.Color(255, 255, 255));
        warningTxt.setText("Incorrect Credentials Entered");
        warningTxt.setToolTipText("");
        warningTxt.setBorder(null);
        warningTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warningTxtActionPerformed(evt);
            }
        });

        errorTxt.setEditable(false);
        errorTxt.setBackground(new java.awt.Color(65, 147, 211));
        errorTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        errorTxt.setForeground(new java.awt.Color(204, 0, 0));
        errorTxt.setText("Error Sigining In");
        errorTxt.setBorder(null);
        errorTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout popUpLayout = new javax.swing.GroupLayout(popUp);
        popUp.setLayout(popUpLayout);
        popUpLayout.setHorizontalGroup(
            popUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(popUpLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(popUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popUpLayout.createSequentialGroup()
                        .addComponent(okBT, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popUpLayout.createSequentialGroup()
                        .addComponent(warningTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(popUpLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(errorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        popUpLayout.setVerticalGroup(
            popUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, popUpLayout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(errorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(warningTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(okBT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        backgroundPanel.add(popUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 420, 420));

        logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/SchoolPortalIcon.png"))); // NOI18N
        backgroundPanel.add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 200, 200));

        logoTF.setEditable(false);
        logoTF.setBackground(new java.awt.Color(250, 228, 188));
        logoTF.setFont(new java.awt.Font("Tw Cen MT", 0, 50)); // NOI18N
        logoTF.setForeground(new java.awt.Color(65, 147, 211));
        logoTF.setText("School Portal");
        logoTF.setBorder(null);
        logoTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoTFActionPerformed(evt);
            }
        });
        backgroundPanel.add(logoTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 260, -1));

        userNameTxt.setEditable(false);
        userNameTxt.setBackground(new java.awt.Color(250, 228, 188));
        userNameTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        userNameTxt.setText("Username:");
        userNameTxt.setBorder(null);
        userNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTxtActionPerformed(evt);
            }
        });
        backgroundPanel.add(userNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        userNameTF.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        userNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTFActionPerformed(evt);
            }
        });
        backgroundPanel.add(userNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 310, 50));

        passwordTxt.setEditable(false);
        passwordTxt.setBackground(new java.awt.Color(250, 228, 188));
        passwordTxt.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        passwordTxt.setText("Password:");
        passwordTxt.setBorder(null);
        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        backgroundPanel.add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, -1, -1));

        passwordPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordPFActionPerformed(evt);
            }
        });
        backgroundPanel.add(passwordPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 630, 310, 50));

        signInBT.setBackground(new java.awt.Color(65, 147, 211));
        signInBT.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        signInBT.setForeground(new java.awt.Color(255, 255, 255));
        signInBT.setText("Sign In");
        signInBT.setBorder(null);
        signInBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBTActionPerformed(evt);
            }
        });
        backgroundPanel.add(signInBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 740, 260, 90));

        backBT.setBackground(new java.awt.Color(250, 228, 188));
        backBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/backBT.png"))); // NOI18N
        backBT.setBorder(null);
        backBT.setOpaque(false);
        backBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTActionPerformed(evt);
            }
        });
        backgroundPanel.add(backBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoTFActionPerformed

    private void userNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTxtActionPerformed

    private void userNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTFActionPerformed

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtActionPerformed

    private void passwordPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordPFActionPerformed

    private void signInBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBTActionPerformed
        verifyCredentials();
        System.out.println(accountType);
    }//GEN-LAST:event_signInBTActionPerformed

    private void backBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTActionPerformed
        this.setVisible(false);
        new LoadScreen().setVisible(true);
    }//GEN-LAST:event_backBTActionPerformed

    private void okBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBTActionPerformed
        // TODO add your handling code here:
        popUp.setVisible(false);
    }//GEN-LAST:event_okBTActionPerformed

    private void warningTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warningTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warningTxtActionPerformed

    private void errorTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_errorTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBT;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JTextField errorTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JTextField logoTF;
    private javax.swing.JButton okBT;
    private javax.swing.JPasswordField passwordPF;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JPanel popUp;
    private javax.swing.JButton signInBT;
    private javax.swing.JTextField userNameTF;
    private javax.swing.JTextField userNameTxt;
    private javax.swing.JTextField warningTxt;
    // End of variables declaration//GEN-END:variables
    
    
      /**
     * Creates new form SignIn
     */
    public SignInScreen() {
        initComponents();
        popUp.setVisible(false);
    }
    
    private Boolean verifyCredentials() {
        
        String encryptedData;
        if (accountType.equals("admin")) {
            try {

                //Gets details from properties file
                input = new FileInputStream("config.properties");
                prop.load(input);
                dbusername = prop.getProperty("adminusername");
                encryptedData = prop.getProperty("adminpw");
                decryptedData = decrypt(encryptedData);

            } catch (FileNotFoundException ex) {
                //Logger.getLogger(SignInScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {

            }

        } else if (accountType.equals("teacher")) {
            try {

                //Gets details from properties file
                input = new FileInputStream("config.properties");
                prop.load(input);
                dbusername = prop.getProperty("tusername");
                encryptedData = prop.getProperty("tpassword");
                decryptedData = decrypt(encryptedData);

            } catch (FileNotFoundException ex) {
                //Logger.getLogger(SignInScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {

            }
        } else {
            try {

                //Gets details from properties file
                input = new FileInputStream("config.properties");
                prop.load(input);
                dbusername = prop.getProperty("pusername");
                encryptedData = prop.getProperty("ppassword");
                decryptedData = decrypt(encryptedData);

            } catch (FileNotFoundException ex) {
                //Logger.getLogger(SignInScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {

            }
        }

        try {

            //get data from fields
            username = userNameTF.getText();
            password = passwordPF.getPassword();

            //hash the user password
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, 3, 256);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            encryptedPW = new BASE64Encoder().encode(res);
            password = null;

            //connect to database
        } catch (InvalidKeySpecException ex) {

        } catch (NoSuchAlgorithmException ex) {

        }

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, dbusername, new String(decryptedData));
            
           
            String query = "SELECT Username FROM AdminAccounts WHERE Username = ? ";
            String query2 = "SELECT Password FROM AdminAccounts WHERE Username = ? ";
            
            try{
            PreparedStatement pstmt = conn.prepareStatement(query);
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt.setString(1, username);
            pstmt2.setString(1, username);
           
            conn.setAutoCommit(false);
            
                 results = pstmt.executeQuery();
                 while(results.next()){
                    System.out.println(results.getString("Username"));
                 }
                 
                 results2 = pstmt2.executeQuery();
                 while(results2.next()){
                    dbPassword= results2.getString("Password");
                    System.out.println(results2.getString("Password"));
                 }
                 
                
                conn.commit();
            }catch(SQLException e){
                System.out.println(e);
                conn.rollback();
            }
            conn.close();

        } catch (ClassNotFoundException ex) { 
            
        } catch (SQLException ex) {
            
        }
        
        
        if(dbPassword.equals(encryptedPW) && accountType.equals("admin")){
             this.setVisible(false);
             adminMainMenu.setVisible(true);
             adminMainMenu.Username(username);
             
             
        }else if(dbPassword.equals(encryptedPW) && accountType.equals("teacher")){
            
            this.setVisible(false);
            teacherMainMenu.setVisible(true);
        }else if(dbPassword.equals(encryptedPW) && accountType.equals("parent")){
            
            this.setVisible(false);
            parentMainMenu.setVisible(true);
        }else{
            popUp.setVisible(true);
        }

        return true;
    }

    private char[] decrypt(String encryptedData) {
        String schoolPostcode = "LdU6_UF}?Z3Pnwa3";
        schoolPostCodeGen(schoolPostcode);

        try {
            Cipher c = Cipher.getInstance("AES/ECB/PKCS5Padding");
            c.init(Cipher.DECRYPT_MODE, schoolNumber);
            c.doFinal(Base64.getDecoder().decode(encryptedData));
            byte[] convertedByte = c.doFinal(Base64.getDecoder().decode(encryptedData));
            convertedChar = new char[convertedByte.length];
            for (int i = 0; i < convertedByte.length; i++) {
                convertedChar[i] = (char) convertedByte[i];
            }
        } catch (NoSuchAlgorithmException ex) {

        } catch (NoSuchPaddingException ex) {

        } catch (InvalidKeyException ex) {

        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(SignInScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(SignInScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return convertedChar;
    }

    private void schoolPostCodeGen(String postCode) {
        MessageDigest sha = null;
        try {
            key = postCode.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            schoolNumber = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
