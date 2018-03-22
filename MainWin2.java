package sanchay;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
public class MainWin2 extends javax.swing.JFrame implements ActionListener{

    public MainWin2() {
        initComponents();
        ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("services.jfif")).getImage().getScaledInstance(main2_pic.getWidth(),main2_pic.getHeight(),Image.SCALE_DEFAULT));
        main2_pic.setIcon(img);
        img=new ImageIcon(getClass().getResource("sanchay2.jfif"));
        this.setIconImage(img.getImage());
        customer.addActionListener(this);
        employee.addActionListener(this);
        username.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent p)
    {
        try
        {
            if(p.getSource()==customer)
                new CustomerService().setVisible(true);
            else if(p.getSource()==employee)
                new employeeServiceForm().setVisible(true);
            else
                new UserUpdate().setVisible(true);
        }
        catch(Exception e)
        {
            
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main2_pic = new javax.swing.JLabel();
        customer = new javax.swing.JButton();
        employee = new javax.swing.JButton();
        username = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        customer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        customer.setText("Customer Details");

        employee.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        employee.setText("Employee Details");

        username.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        username.setText("Username/Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(main2_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customer)
                        .addGap(35, 35, 35)
                        .addComponent(employee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(username)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main2_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customer)
                    .addComponent(employee)
                    .addComponent(username))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customer;
    private javax.swing.JButton employee;
    private javax.swing.JLabel main2_pic;
    private javax.swing.JButton username;
    // End of variables declaration//GEN-END:variables
}
