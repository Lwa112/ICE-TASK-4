/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author massi
 */
import javax.swing.*;


public class HospitalFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(HospitalFrame.class.getName());

    /**
     * Creates new form HospitalFrame
     */
    // ---------- Data: parallel arrays that store up to five inspections ----------
    private final int MAX = 5;
    private String[] names = new String[MAX];
    private String[] locations = new String[MAX];
    private int[] years = new int[MAX];
    private int count = 0; // how many inspections are saved so far

// ---------- Controls ----------
    private JTextField txtName = new JTextField();
    private JTextField txtLocation = new JTextField();
    private JComboBox<String> cboYears = new JComboBox<>(
            new String[]{"1 Year", "2 Years", "3 Years", "4 Years", "5 Years"});
    private JButton btnSave = new JButton("SAVE");
    private JButton btnPrint = new JButton("PRINT");
    private JButton btnClear = new JButton("CLEAR");
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> lstOutput = new JList<>(listModel);

    public HospitalFrame() {
        initComponents();
        setTitle("Hospital Inspections");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);   // position components manually
        setSize(420, 520);
        setResizable(false);
        setLocationRelativeTo(null);
        buildUI();
    }

    private void buildUI() {
        // ---------- Labels ----------
        JLabel lblName = new JLabel("Hospital Name:");
        lblName.setBounds(20, 20, 160, 25);
        JLabel lblLocation = new JLabel("Hospital Location:");
        lblLocation.setBounds(20, 65, 160, 25);
        JLabel lblYears = new JLabel("Years since inspection:");
        lblYears.setBounds(20, 110, 160, 25);

        // ---------- Input controls ----------
        txtName.setBounds(190, 20, 190, 25);
        txtLocation.setBounds(190, 65, 190, 25);
        cboYears.setSelectedIndex(2);        // starts on "3 Years" like the sample
        cboYears.setBounds(190, 110, 190, 25);

        // ---------- Buttons ----------
        btnSave.setBounds(190, 155, 190, 30);
        btnPrint.setBounds(40, 400, 150, 30);
        btnClear.setBounds(210, 400, 150, 30);

        // ---------- List box (inside a scroll pane so five records fit) ----------
        JScrollPane scroll = new JScrollPane(lstOutput);
        scroll.setBounds(20, 200, 360, 185);

        // Add everything to the form
        add(lblName);
        add(txtName);
        add(lblLocation);
        add(txtLocation);
        add(lblYears);
        add(cboYears);
        add(btnSave);
        add(scroll);
        add(btnPrint);
        add(btnClear);

        // ---------- Button events ----------
        btnSave.addActionListener(e -> saveInspection());
        btnPrint.addActionListener(e -> printInspections());
        btnClear.addActionListener(e -> clearControls());

        // ---------- Menu bar: File > Exit, Tools > Save / Print / Clear ----------
        JMenuBar menuBar = new JMenuBar();

        JMenu mnuFile = new JMenu("File");
        JMenuItem miExit = new JMenuItem("Exit");
        miExit.addActionListener(e -> System.exit(0));
        mnuFile.add(miExit);

        JMenu mnuTools = new JMenu("Tools");
        JMenuItem miSave = new JMenuItem("Save");
        JMenuItem miPrint = new JMenuItem("Print");
        JMenuItem miClear = new JMenuItem("Clear");
        // The menu items call the same methods as the buttons
        miSave.addActionListener(e -> saveInspection());
        miPrint.addActionListener(e -> printInspections());
        miClear.addActionListener(e -> clearControls());
        mnuTools.add(miSave);
        mnuTools.add(miPrint);
        mnuTools.add(miClear);

        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);
    }

// Saves the current inputs into the arrays (SAVE button and Tools > Save)
    private void saveInspection() {
        // Stop after five inspections
        if (count >= MAX) {
            JOptionPane.showMessageDialog(this, "Maximum inspection count reached!");
            return;
        }

        String name = txtName.getText().trim();
        String location = txtLocation.getText().trim();

        // Both text fields must be filled in
        if (name.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the hospital name and location.");
            return;
        }

        names[count] = name;
        locations[count] = location;
        years[count] = cboYears.getSelectedIndex() + 1; // index 0 = 1 year, 4 = 5 years
        count++;

        JOptionPane.showMessageDialog(this, "Inspection saved.");
    }

// Prints every saved inspection from the arrays into the list box (PRINT button and Tools > Print)
    private void printInspections() {
        listModel.clear(); // avoids duplicates when Print is clicked again

        for (int i = 0; i < count; i++) {
            listModel.addElement("Hospital Name: " + names[i]);
            listModel.addElement("Hospital Location: " + locations[i]);
            listModel.addElement("Years Since Inspection: " + years[i]
                    + (years[i] == 1 ? " year" : " years"));
            listModel.addElement("********************************");
        }
    }

// Clears the input controls (CLEAR button and Tools > Clear)
    private void clearControls() {
        txtName.setText("");
        txtLocation.setText("");
        cboYears.setSelectedIndex(2);  // back to "3 Years"
        txtName.requestFocus();        // cursor returns to the first field
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
    } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
        logger.log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> new HospitalFrame().setVisible(true));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}