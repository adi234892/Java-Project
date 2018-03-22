package sanchay;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class EntryForm extends javax.swing.JFrame implements ActionListener{
     ImageIcon img;
    public EntryForm() {
        initComponents();
        services.addActionListener(this);
        entry.addActionListener(this);
        logout.addActionListener(this);
        img=new ImageIcon(new ImageIcon(getClass().getResource("sanchay3.png")).getImage().getScaledInstance(entry_pic.getWidth(),entry_pic.getHeight(),Image.SCALE_DEFAULT));
        entry_pic.setIcon(img);
    }
     @Override
    public void actionPerformed(ActionEvent p){
        try
        {
            if(p.getSource()==services)
            {
                new MainWin().setVisible(true);
            }
            else if(p.getSource()==entry)
            {
                new MainWin2().setVisible(true);
            }
            else
            {
                dispose();
            }
        }
        catch(Exception e)
                {
                    
                }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entry_pic = new javax.swing.JLabel();
        services = new javax.swing.JButton();
        entry = new javax.swing.JButton();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        services.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        services.setForeground(new java.awt.Color(204, 204, 0));
        services.setText("Services");

        entry.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        entry.setForeground(new java.awt.Color(0, 204, 204));
        entry.setText("Entry");

        logout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logout.setForeground(new java.awt.Color(153, 0, 0));
        logout.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(entry_pic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(services)
                        .addGap(44, 44, 44)
                        .addComponent(entry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(logout)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(entry_pic, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(services)
                    .addComponent(entry)
                    .addComponent(logout))
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entry;
    private javax.swing.JLabel entry_pic;
    private javax.swing.JButton logout;
    private javax.swing.JButton services;
    // End of variables declaration//GEN-END:variables
}
