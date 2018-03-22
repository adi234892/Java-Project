package sanchay;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Target extends javax.swing.JFrame implements ActionListener{
 Connection con;   
 PreparedStatement stmt;
 ResultSet rs;
  
    public Target() throws Exception {
        
        initComponents();
         ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("collection.jfif")).getImage().getScaledInstance(emp_pic.getWidth(),emp_pic.getHeight(),Image.SCALE_DEFAULT));
        emp_pic.setIcon(img);
        img=new ImageIcon(getClass().getResource("sanchay2.jfif"));
        this.setIconImage(img.getImage());
        submit.addActionListener(this);
        reset.addActionListener(this);
        
    }
    public void refresh()
    {
        emp_id.setText("");
        tf_name.setText("");
    }
 @Override
    public void actionPerformed(ActionEvent e){
        try
        {       if(e.getSource()==submit){
                    con=ConnDB.conLink();
                    stmt=con.prepareStatement("select employee_name from employee_details where employee_id=?");
                    stmt.setString(1,emp_id.getText());
                    rs=stmt.executeQuery();
                    if(rs.next())
                    {    
                    tf_name.setText(rs.getString(1));
                    stmt=con.prepareStatement("insert into target_details values(?,?,?,?,?,?,?,?,?)");
                    stmt.setString(1,emp_id.getText());
                    stmt.setString(2,tf_name.getText());
                    stmt.setString(3,(String)month.getSelectedItem());
                    stmt.setInt(4,Integer.parseInt(tf_sav_amt.getText()));
                    stmt.setInt(5,Integer.parseInt(tf_fd_amt.getText()));
                    stmt.setInt(6,Integer.parseInt(tf_loan_amt.getText()));
                    stmt.setInt(7,Integer.parseInt(tf_rd_amt.getText()));
                    stmt.setInt(8,Integer.parseInt(tf_tar.getText()));
                    stmt.setInt(9,Integer.parseInt(tf_tot_coll.getText()));
                    stmt.executeUpdate();
                               JOptionPane.showMessageDialog(this,"Successfully record inserted","employee target Details",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this,"Employee id not found!");
                        emp_id.setText("");
                        emp_id.requestFocus();
                    }    
             }
             else
                           refresh();
        }
        catch(Exception p){
                    JOptionPane.showMessageDialog(this,"Error in connection","Recurring deposite Details",JOptionPane.ERROR_MESSAGE);

        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_loan_amt = new javax.swing.JTextField();
        tf_rd_amt = new javax.swing.JTextField();
        tf_tot_coll = new javax.swing.JTextField();
        emp_id = new javax.swing.JTextField();
        tf_tar = new javax.swing.JTextField();
        tf_name = new javax.swing.JTextField();
        tf_sav_amt = new javax.swing.JTextField();
        e_name = new javax.swing.JLabel();
        e_month_name = new javax.swing.JLabel();
        e_sav_amt = new javax.swing.JLabel();
        e_loan_amt = new javax.swing.JLabel();
        e_rd_amt = new javax.swing.JLabel();
        e_tot_coll = new javax.swing.JLabel();
        e_tar = new javax.swing.JLabel();
        e_id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        e_rd_amt1 = new javax.swing.JLabel();
        tf_fd_amt = new javax.swing.JTextField();
        month = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        emp_pic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tf_name.setEditable(false);

        e_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_name.setText("Employee Name");

        e_month_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_month_name.setText("Month Name");

        e_sav_amt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_sav_amt.setText("Saving Amount");

        e_loan_amt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_loan_amt.setText("Loan Amount");

        e_rd_amt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_rd_amt.setText("RD Amount");

        e_tot_coll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_tot_coll.setText("Total Collection");

        e_tar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_tar.setText("Target");

        e_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_id.setText("Employee Id");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Employee Target Details");

        submit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submit.setForeground(new java.awt.Color(0, 153, 0));
        submit.setText("Submit");

        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(153, 0, 0));
        reset.setText("Reset");

        e_rd_amt1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_rd_amt1.setText("FD Amount");

        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emp_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e_id)
                            .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e_month_name))
                        .addGap(18, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emp_id)
                            .addComponent(tf_name)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(e_sav_amt)
                            .addComponent(e_loan_amt)
                            .addComponent(e_rd_amt)
                            .addComponent(e_tot_coll)
                            .addComponent(e_tar)
                            .addComponent(e_rd_amt1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(submit)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(reset)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tf_sav_amt)
                                    .addComponent(tf_rd_amt, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tf_tar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_tot_coll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_fd_amt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_loan_amt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {e_id, e_loan_amt, e_month_name, e_name, e_rd_amt, e_sav_amt, e_tar, e_tot_coll});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tf_fd_amt, tf_tot_coll});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(emp_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_id)
                    .addComponent(emp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_name, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_month_name)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_sav_amt)
                    .addComponent(tf_sav_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_loan_amt)
                    .addComponent(tf_loan_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_rd_amt)
                    .addComponent(tf_rd_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_rd_amt1)
                    .addComponent(tf_fd_amt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_tot_coll)
                    .addComponent(tf_tot_coll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_tar)
                    .addComponent(tf_tar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit)
                    .addComponent(reset))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {emp_id, tf_fd_amt, tf_loan_amt, tf_name, tf_rd_amt, tf_sav_amt, tf_tar, tf_tot_coll});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {e_id, e_loan_amt, e_month_name, e_name, e_rd_amt, e_sav_amt, e_tar, e_tot_coll});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel e_id;
    private javax.swing.JLabel e_loan_amt;
    private javax.swing.JLabel e_month_name;
    private javax.swing.JLabel e_name;
    private javax.swing.JLabel e_rd_amt;
    private javax.swing.JLabel e_rd_amt1;
    private javax.swing.JLabel e_sav_amt;
    private javax.swing.JLabel e_tar;
    private javax.swing.JLabel e_tot_coll;
    private javax.swing.JTextField emp_id;
    private javax.swing.JLabel emp_pic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox month;
    private javax.swing.JButton reset;
    private javax.swing.JButton submit;
    private javax.swing.JTextField tf_fd_amt;
    private javax.swing.JTextField tf_loan_amt;
    private javax.swing.JTextField tf_name;
    private javax.swing.JTextField tf_rd_amt;
    private javax.swing.JTextField tf_sav_amt;
    private javax.swing.JTextField tf_tar;
    private javax.swing.JTextField tf_tot_coll;
    // End of variables declaration//GEN-END:variables
}
