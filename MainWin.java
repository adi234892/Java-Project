package sanchay;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
public class MainWin extends javax.swing.JFrame implements ActionListener{
    public MainWin() {
        initComponents();
        ImageIcon img = new ImageIcon(new ImageIcon(getClass().getResource("co.jfif")).getImage().getScaledInstance(main_pic.getWidth(),main_pic.getHeight(),Image.SCALE_DEFAULT));
        main_pic.setIcon(img);
        ImageIcon img2 = new ImageIcon(new ImageIcon(getClass().getResource("bank.png")).getImage().getScaledInstance(main_pic2.getWidth(),main_pic2.getHeight(),Image.SCALE_DEFAULT));
        main_pic2.setIcon(img2);
        img=new ImageIcon(getClass().getResource("sanchay2.jfif"));
        this.setIconImage(img.getImage());
        c_d.addActionListener(this);
        e_d.addActionListener(this);
        coll_d.addActionListener(this);
        rd.addActionListener(this);
        loan.addActionListener(this);
        s_a.addActionListener(this);
        t_d.addActionListener(this);
        fd.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent p)
    {
        try
        {
            if(p.getSource()==c_d)
                new Customer().setVisible(true);
            else if(p.getSource()==e_d)
                new employee().setVisible(true);
            else if(p.getSource()==coll_d)
                new Collection().setVisible(true);
            else if(p.getSource()==rd)
                new RecurringDeposite().setVisible(true);
            else if(p.getSource()==loan)
                new Loan().setVisible(true);
            else if(p.getSource()==s_a)
                new Saving().setVisible(true);
            else if(p.getSource()==t_d)
                new Target().setVisible(true);
            else
                new FixedDeposite().setVisible(true);
            
        }
        catch(Exception e)
                {
                    
                }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        c_d = new javax.swing.JButton();
        e_d = new javax.swing.JButton();
        t_d = new javax.swing.JButton();
        s_a = new javax.swing.JButton();
        loan = new javax.swing.JButton();
        coll_d = new javax.swing.JButton();
        rd = new javax.swing.JButton();
        fd = new javax.swing.JButton();
        main_pic = new javax.swing.JLabel();
        main_pic2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        c_d.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        c_d.setText("Customer details");

        e_d.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        e_d.setText("Employee details");

        t_d.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        t_d.setText("Target details");

        s_a.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        s_a.setText("Saving Account");

        loan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        loan.setText("Loan");

        coll_d.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        coll_d.setText("Collection Details");

        rd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rd.setText("RD Account");

        fd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fd.setText("FD Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rd)
                        .addGap(34, 34, 34)
                        .addComponent(main_pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(c_d)
                        .addGap(18, 18, 18)
                        .addComponent(e_d)
                        .addGap(18, 18, 18)
                        .addComponent(coll_d)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(s_a)
                        .addGap(45, 45, 45)
                        .addComponent(t_d)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fd)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(main_pic, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_d)
                    .addComponent(e_d)
                    .addComponent(coll_d))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(loan))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(rd))
                    .addComponent(main_pic2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s_a)
                    .addComponent(fd)
                    .addComponent(t_d))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton c_d;
    private javax.swing.JButton coll_d;
    private javax.swing.JButton e_d;
    private javax.swing.JButton fd;
    private javax.swing.JButton loan;
    private javax.swing.JLabel main_pic;
    private javax.swing.JLabel main_pic2;
    private javax.swing.JButton rd;
    private javax.swing.JButton s_a;
    private javax.swing.JButton t_d;
    // End of variables declaration//GEN-END:variables
}
