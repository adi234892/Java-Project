package sanchay;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRecord extends javax.swing.JFrame {

    public CustomerRecord(ResultSet rs1) throws SQLException {
        initComponents();
        jtext.append("Customer name:"+rs1.getString(1));
        jtext.append("\nFather/Husband name:"+rs1.getString(2));
        jtext.append("\nTemp add:"+rs1.getString(3));
        jtext.append("\nParm add:"+rs1.getString(4));
        jtext.append("\nQualification:"+rs1.getString(5));
        jtext.append("\nOccupation:"+rs1.getString(6));
        jtext.append("\nNominee Name:"+rs1.getString(7));
        jtext.append("\nNominee Relation:"+rs1.getString(8));
        jtext.append("\nAccount no:"+rs1.getInt(9));
        jtext.append("\ncont no:"+rs1.getInt(10));
        jtext.append("\nDate of birth:"+rs1.getDate(11));
        jtext.append("\nId proof:"+rs1.getString(12));
        jtext.append("\nGender:"+rs1.getString(13));
        jtext.append("\nFD:"+rs1.getString(14));
        jtext.append("\nRD:"+rs1.getString(15));
        jtext.append("\nLoan:"+rs1.getString(16));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtext = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtext.setColumns(20);
        jtext.setRows(5);
        jScrollPane1.setViewportView(jtext);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jtext;
    // End of variables declaration//GEN-END:variables
}
