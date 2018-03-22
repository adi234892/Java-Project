package sanchay;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

public class CustomerService extends javax.swing.JFrame implements ActionListener,ItemListener{
    Connection con;
    PreparedStatement stmt;
    Statement st;
    ResultSet rs;
     ImageIcon img,sear;
    String url="update Customer_details set";
    int a=0,b=0,ctr=0,c=0,d=0;

    
    public CustomerService() {
        initComponents();
        this.setLocationRelativeTo(null);
        update.addActionListener(this);
        reset.addActionListener(this);
        s_name.addItemListener(this);
        f_name.addItemListener(this);
        nom_name.addItemListener(this);
        cont_no.addItemListener(this);
        submit.addActionListener(this);
          img=new ImageIcon(new ImageIcon(getClass().getResource("update2.jfif")).getImage().getScaledInstance(update_pic.getWidth(),update_pic.getHeight(),Image.SCALE_DEFAULT));
        update_pic.setIcon(img);
        sear=new ImageIcon(new ImageIcon(getClass().getResource("search.jfif")).getImage().getScaledInstance(search_pic.getWidth(),search_pic.getHeight(),Image.SCALE_DEFAULT));
        search_pic.setIcon(sear);
        img=new ImageIcon(getClass().getResource("sanchay2.jfif"));
        this.setIconImage(img.getImage());
    }
    @Override
    public void itemStateChanged(ItemEvent p)
    {
      JCheckBox ch=(JCheckBox)p.getItem();
      if(ch.isSelected())  
      { 
        if(ctr==0)
        {
            url=url+" ";
            ctr++;
        }    
        else
            url=url+",";
        if(s_name.getModel().isPressed())
        {
                url=url+"name=?";
                tf_c_name.setEditable(true);
                a=ctr;
                ctr++; 
        } 
        else if(f_name.getModel().isPressed())
        {
            url=url+"father_husband_name=?";
            tf_f_name.setEditable(true);
            b=ctr;
            ctr++;
        }
        else if(nom_name.getModel().isPressed())
        {
            url=url+"nominee_name=?";
            tf_nom_name.setEditable(true);
            c=ctr;
            ctr++;
            
        }
        else if(cont_no.getModel().isPressed())
        {
            url=url+"cont_no=?";
            tf_cont_no.setEditable(true);
            d=ctr;
            ctr++;
        }
            
        }
      else
      {
          refresh();
      }
    }
      public void refresh()
    {
        tf_c_name.setEditable(false);
        tf_f_name.setEditable(false);
        tf_cont_no.setEditable(false);
        tf_nom_name.setEditable(false);
        tf_c_name.setText("");
        tf_f_name.setText("");
        tf_cont_no.setText("");
        tf_nom_name.setText("");
        acc_no.setText("");
        url="update customer_details set";
        s_name.setSelected(false);
        f_name.setSelected(false);
        nom_name.setSelected(false);
        cont_no.setSelected(false);
        a=b=c=d=ctr=0;
    } 
    @Override
      public void actionPerformed(ActionEvent e) 
      {
            try
            {    
                con=ConnDB.conLink();
                if(e.getSource()==update)
                {
                    if(a==0&&b==0&&c==0&&d==0)
                    {    
                            JOptionPane.showMessageDialog(this,"select any field to update","Selection problem",JOptionPane.ERROR_MESSAGE);
                            System.exit(0);
                    }
                        url=url+" where account_no=?";
               
                        stmt=con.prepareStatement(url);
                        if(a>0)
                            stmt.setString(a,tf_c_name.getText());
                        if(b>0)
                            stmt.setString(b, tf_f_name.getText());
                        if(c>0)
                            stmt.setString(c,tf_nom_name.getText());
                        if(d>0)
                            stmt.setInt(d,Integer.parseInt(tf_cont_no.getText()));       
                        stmt.setString(ctr,up_acc_no.getText());
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(this,"Record updated successfully","Record updation",JOptionPane.INFORMATION_MESSAGE); 
                } 
                else if(e.getSource()==reset)
                {
                    refresh();
                }    
              
                else
                {
                    stmt=con.prepareStatement("select * from customer_details where account_no=?");
                    stmt.setInt(1,Integer.parseInt(tf_acc.getText()));
                    rs=stmt.executeQuery();
                    rs.next();
                    new CustomerRecord(rs).setVisible(true);
                }    
                
            }
            catch(Exception p)
            {
                JOptionPane.showMessageDialog(this,"record not updated/search","Record updation/search",JOptionPane.ERROR_MESSAGE);
            }
      }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        s_acc = new javax.swing.JLabel();
        tf_acc = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        search_pic = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        s_name = new javax.swing.JCheckBox();
        tf_c_name = new javax.swing.JTextField();
        f_name = new javax.swing.JCheckBox();
        tf_f_name = new javax.swing.JTextField();
        tf_nom_name = new javax.swing.JTextField();
        nom_name = new javax.swing.JCheckBox();
        tf_cont_no = new javax.swing.JTextField();
        cont_no = new javax.swing.JCheckBox();
        acc_no = new javax.swing.JLabel();
        up_acc_no = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        update_pic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        s_acc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s_acc.setText("Account No.");

        submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submit.setForeground(new java.awt.Color(0, 153, 0));
        submit.setText("Submit");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(search_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(s_acc, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_acc, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(search_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s_acc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_acc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Search", jPanel2);

        s_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        s_name.setText("Name");

        tf_c_name.setEditable(false);
        tf_c_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_c_nameActionPerformed(evt);
            }
        });

        f_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        f_name.setText("Father's/Husband Name");

        tf_f_name.setEditable(false);

        tf_nom_name.setEditable(false);

        nom_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nom_name.setText("Nominee Name");

        tf_cont_no.setEditable(false);

        cont_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cont_no.setText("Contact No");

        acc_no.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acc_no.setText("Account_No");

        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(0, 153, 0));
        update.setText("Update");

        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(153, 0, 0));
        reset.setText("Reset");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s_name, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tf_cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(update)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tf_f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(reset)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(update_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(up_acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(update_pic, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(up_acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update)
                    .addComponent(reset))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Update", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_c_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_c_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_c_nameActionPerformed

   
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_no;
    private javax.swing.JCheckBox cont_no;
    private javax.swing.JCheckBox f_name;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JCheckBox nom_name;
    private javax.swing.JButton reset;
    private javax.swing.JLabel s_acc;
    private javax.swing.JCheckBox s_name;
    private javax.swing.JLabel search_pic;
    private javax.swing.JButton submit;
    private javax.swing.JTextField tf_acc;
    private javax.swing.JTextField tf_c_name;
    private javax.swing.JTextField tf_cont_no;
    private javax.swing.JTextField tf_f_name;
    private javax.swing.JTextField tf_nom_name;
    private javax.swing.JTextField up_acc_no;
    private javax.swing.JButton update;
    private javax.swing.JLabel update_pic;
    // End of variables declaration//GEN-END:variables
}
