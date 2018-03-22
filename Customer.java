package sanchay;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class Customer extends javax.swing.JFrame implements ActionListener{
     Connection con;   
     PreparedStatement stmt;
     String str2;
     ImageIcon img;
     long c;
     String msg="";
    public Customer() {
        initComponents();
        img=new ImageIcon(new ImageIcon(getClass().getResource("sanchay.jpg")).getImage().getScaledInstance(cus_sanchay.getWidth(),cus_sanchay.getHeight(),Image.SCALE_DEFAULT));
        cus_sanchay.setIcon(img);
        img=new ImageIcon(getClass().getResource("sanchay2.jfif"));
        this.setIconImage(img.getImage());
        ButtonGroup bg=new ButtonGroup();
        ButtonGroup gender=new ButtonGroup();
        bg.add(adhar);
        bg.add(voter);
        bg.add(dl);
        gender.add(male);
        gender.add(female);
        submit.addActionListener(this);
        reset.addActionListener(this);
         try
        {
             con=ConnDB.conLink();      
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select account_no from automatic");
             rs.next();
             c=rs.getInt(1);    
             c++;
            str2=""+c;
            if(str2.length()<=10)
               tf_acc.setText(str2);
            else
                JOptionPane.showMessageDialog(rootPane, female);
        }   
        catch(Exception p){}
      
            
    }
     @Override
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource()==submit){
           con=ConnDB.conLink();
           char ch;
           byte i;
           String str,fname,nname,rname;
           str=tf_c_name.getText().toUpperCase();
           fname=tf_f_name.getText().toUpperCase();
           nname=tf_nom_name.getText().toUpperCase();
           rname=tf_nom_rel.getText().toUpperCase();
           String cont = tf_cont_no.getText();
           for(i=0;i<str.length();i++)
           {
               ch=str.charAt(i);
               if(!(ch>=65&&ch<=90 || ch==13))
               {
                   msg="\nName must be alphabetic only!";
                   break;
               }
           } 
            for(i=0;i<fname.length();i++)
           {
               ch=fname.charAt(i);
               if(!(ch>=65&&ch<=90 || ch==13))
               {
                   msg="\nfather/Husband Name must be alphabetic only!";
                   break;
               }
           } 
            for(i=0;i<nname.length();i++)
           {
               ch=nname.charAt(i);
               if(!(ch>=65&&ch<=90 || ch==13))
               {
                   msg="\nNominee Name must be alphabetic only!";
                   break;
               }
           } 
            for(i=0;i<rname.length();i++)
           {
               ch=rname.charAt(i);
               if(!(ch>=65&&ch<=90 || ch==13))
               {
                   msg="\nNominee Relation must be alphabetic only!";
                   break;
               }
           } 
            for(i=0;i<cont.length();i++)
           {
                ch=cont.charAt(i);
               if(!(ch>=48&&ch<=57 || ch==13))
               {
                   msg="\nConatct no. must be number only!";
                   System.out.print(ch);
                   break;
               }
           } 
           
           if(msg.length()!=0)
               JOptionPane.showMessageDialog(this, msg);
           else
           {    
           stmt=con.prepareStatement("insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           if(adhar.isSelected())
               stmt.setString(12,adhar.getText());
           else if(voter.isSelected())
               stmt.setString(12,voter.getText());
           else 
               stmt.setString(12,dl.getText());
           if(male.isSelected())
               stmt.setString(13,male.getText());
           else if(female.isSelected())
               stmt.setString(13,female.getText());
           if(fd.isSelected())
                stmt.setString(14,fd.getText());
           else
               stmt.setString(14,null);
            if(rd.isSelected())
                stmt.setString(15,rd.getText());
           else
               stmt.setString(15,null);
             if(loan.isSelected())
                stmt.setString(16,loan.getText());
           else
               stmt.setString(16,null);
               
                      stmt.setString(1,tf_c_name.getText());
                      stmt.setString(2,tf_f_name.getText());
                      stmt.setString(3,tf_temp_add.getText());
                      stmt.setString(4,tf_par_add.getText());
                      stmt.setString(5,tf_quali.getText());
                      stmt.setString(6,tf_occup.getText());
                      stmt.setString(7,tf_nom_name.getText());
                      stmt.setString(8,tf_nom_rel.getText());
                      stmt.setInt(9,Integer.parseInt(tf_acc.getText()));
                      stmt.setString(10,tf_cont_no.getText()); 
                      stmt.setDate(11,new java.sql.Date(d_o_b.getDate().getTime()));   
                      stmt.executeUpdate();
                      stmt=con.prepareStatement("update automatic set account_no=?");
                      stmt.setLong(1,c);
                      stmt.executeUpdate();
                      JOptionPane.showMessageDialog(this,"Successfully record inserted","Customer_details",JOptionPane.INFORMATION_MESSAGE);
         }
            }
            else 
            {
                tf_c_name.setText("");
                tf_f_name.setText("");
                tf_temp_add.setText("");
                tf_par_add.setText("");
                tf_quali.setText("");
                tf_occup.setText("");
                tf_nom_name.setText("");
                tf_nom_rel.setText("");
                tf_cont_no.setText("");    
            }
        }
        catch(Exception p){
             JOptionPane.showMessageDialog(this,"Error in connection","customer_details",JOptionPane.ERROR_MESSAGE);
        
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_f_name = new javax.swing.JTextField();
        tf_c_name = new javax.swing.JTextField();
        tf_quali = new javax.swing.JTextField();
        tf_nom_name = new javax.swing.JTextField();
        tf_occup = new javax.swing.JTextField();
        tf_acc = new javax.swing.JTextField();
        tf_nom_rel = new javax.swing.JTextField();
        tf_cont_no = new javax.swing.JTextField();
        c_name = new javax.swing.JLabel();
        par_add = new javax.swing.JLabel();
        temp_add = new javax.swing.JLabel();
        c_fath_husb = new javax.swing.JLabel();
        c_nom_name = new javax.swing.JLabel();
        c_occup = new javax.swing.JLabel();
        c_quali = new javax.swing.JLabel();
        c_dob = new javax.swing.JLabel();
        acc_mode = new javax.swing.JLabel();
        id_p = new javax.swing.JLabel();
        c_nom_rel = new javax.swing.JLabel();
        acc_no = new javax.swing.JLabel();
        cont_no = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_temp_add = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tf_par_add = new javax.swing.JTextArea();
        reset = new javax.swing.JButton();
        fd = new javax.swing.JCheckBox();
        rd = new javax.swing.JCheckBox();
        loan = new javax.swing.JCheckBox();
        c_dob1 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        tf_acc1 = new javax.swing.JTextField();
        acc_no1 = new javax.swing.JLabel();
        d_o_b = new org.jdesktop.swingx.JXDatePicker();
        adhar = new javax.swing.JRadioButton();
        voter = new javax.swing.JRadioButton();
        dl = new javax.swing.JRadioButton();
        cus_sanchay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tf_f_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_f_nameActionPerformed(evt);
            }
        });

        tf_acc.setEditable(false);

        c_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_name.setText("Name");

        par_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        par_add.setText("Temporary Address");

        temp_add.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        temp_add.setText("Parmanent Address");

        c_fath_husb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_fath_husb.setText("Father's/Husband Name");

        c_nom_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_nom_name.setText("Nominee Name");

        c_occup.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_occup.setText("Occupation");

        c_quali.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_quali.setText("Qualification");

        c_dob.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_dob.setText("DOB");

        acc_mode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acc_mode.setText("Account Mode");

        id_p.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id_p.setText("Id proof");

        c_nom_rel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_nom_rel.setText("Nominee Relation");

        acc_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acc_no.setText("Account No.");

        cont_no.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cont_no.setText("Contact No.");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Customer Details");
        jLabel1.setToolTipText("");

        submit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        submit.setForeground(new java.awt.Color(0, 153, 0));
        submit.setText("Submit");

        tf_temp_add.setColumns(20);
        tf_temp_add.setRows(5);
        jScrollPane1.setViewportView(tf_temp_add);

        tf_par_add.setColumns(20);
        tf_par_add.setRows(5);
        jScrollPane2.setViewportView(tf_par_add);

        reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(153, 0, 0));
        reset.setText("Reset");

        fd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fd.setText("FD");

        rd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rd.setText("RD");

        loan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        loan.setText("Loan");

        c_dob1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_dob1.setText("Gender");

        male.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        male.setText("Male");

        female.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        female.setText("Female");

        tf_acc1.setEditable(false);
        tf_acc1.setText("SAVING");

        acc_no1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        acc_no1.setText("Account Type");

        adhar.setText("Adhar card");

        voter.setText("Voter Id");

        dl.setText("Driving licence");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(temp_add, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(c_dob1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(male)
                                    .addGap(58, 58, 58)
                                    .addComponent(female))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(c_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(c_quali, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_quali)
                                        .addComponent(d_o_b, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c_fath_husb, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(110, 110, 110)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tf_f_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(par_add, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(submit)
                        .addGap(64, 64, 64)
                        .addComponent(reset)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(c_occup, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(110, 110, 110)
                                    .addComponent(tf_occup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(c_nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(110, 110, 110)
                                    .addComponent(tf_nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(c_nom_rel, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(110, 110, 110)
                                    .addComponent(tf_nom_rel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(110, 110, 110)
                                    .addComponent(tf_acc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(id_p, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(adhar)
                                    .addGap(24, 24, 24)
                                    .addComponent(voter))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(acc_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(110, 110, 110)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dl)
                                        .addComponent(tf_acc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(acc_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(fd)
                                    .addGap(59, 59, 59)
                                    .addComponent(rd)
                                    .addGap(53, 53, 53)
                                    .addComponent(loan))))
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(cus_sanchay, javax.swing.GroupLayout.PREFERRED_SIZE, 852, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tf_acc, tf_acc1, tf_f_name, tf_nom_name, tf_nom_rel, tf_occup, tf_quali});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cus_sanchay, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_fath_husb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_f_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(par_add, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(temp_add, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_occup, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_occup, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(c_nom_name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nom_rel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(c_nom_rel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_acc)
                            .addComponent(acc_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(acc_no1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_acc1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(id_p, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adhar)
                            .addComponent(voter)
                            .addComponent(dl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(acc_mode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fd)
                            .addComponent(rd)
                            .addComponent(loan))
                        .addGap(12, 12, 12)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(d_o_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(female)
                                .addComponent(male))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tf_quali, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(c_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(c_dob1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(c_quali, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_cont_no, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submit)
                            .addComponent(reset))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {tf_acc, tf_f_name, tf_nom_name, tf_nom_rel, tf_quali});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_f_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_f_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_f_nameActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acc_mode;
    private javax.swing.JLabel acc_no;
    private javax.swing.JLabel acc_no1;
    private javax.swing.JRadioButton adhar;
    private javax.swing.JLabel c_dob;
    private javax.swing.JLabel c_dob1;
    private javax.swing.JLabel c_fath_husb;
    private javax.swing.JLabel c_name;
    private javax.swing.JLabel c_nom_name;
    private javax.swing.JLabel c_nom_rel;
    private javax.swing.JLabel c_occup;
    private javax.swing.JLabel c_quali;
    private javax.swing.JLabel cont_no;
    private javax.swing.JLabel cus_sanchay;
    private org.jdesktop.swingx.JXDatePicker d_o_b;
    private javax.swing.JRadioButton dl;
    private javax.swing.JCheckBox fd;
    private javax.swing.JRadioButton female;
    private javax.swing.JLabel id_p;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox loan;
    private javax.swing.JRadioButton male;
    private javax.swing.JLabel par_add;
    private javax.swing.JCheckBox rd;
    private javax.swing.JButton reset;
    private javax.swing.JButton submit;
    private javax.swing.JLabel temp_add;
    private javax.swing.JTextField tf_acc;
    private javax.swing.JTextField tf_acc1;
    private javax.swing.JTextField tf_c_name;
    private javax.swing.JTextField tf_cont_no;
    private javax.swing.JTextField tf_f_name;
    private javax.swing.JTextField tf_nom_name;
    private javax.swing.JTextField tf_nom_rel;
    private javax.swing.JTextField tf_occup;
    private javax.swing.JTextArea tf_par_add;
    private javax.swing.JTextField tf_quali;
    private javax.swing.JTextArea tf_temp_add;
    private javax.swing.JRadioButton voter;
    // End of variables declaration//GEN-END:variables
}
