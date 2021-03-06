/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchCatalog.java
 *
 * Created on 18 Des 13, 4:57:02
 */
package gutenbergcatalogproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Anonymous
 */
public class SearchCatalog extends javax.swing.JFrame {

    String key;
    String file;
    String strLine, strings = "";
    boolean start = false;
    String Author = null, Title = null, No = null;
    LinkList theList = new LinkList();

    /** Creates new form SearchCatalog */
    public SearchCatalog() {

        this.setTitle("Search Catalog Gutenberg Project V.1");

        Exit = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        file = ("C:/Users/Anonymous/Documents/NetBeansProjects/GutenbergCatalogProject/src/gutenbergcatalogproject/GUTINDEX.ALL");
        try {
            if (file != null) {
                BufferedReader br = new BufferedReader(new FileReader(new File(file)));
                //Read File Line By Line
                while ((strLine = br.readLine()) != null) {
                    if (strLine.equals("TITLE and AUTHOR                                                     ETEXT NO.")) {
                        start = true;
                        continue;
                    }
                    if (strLine.equalsIgnoreCase("<==End of GUTINDEX.ALL==>")) {
                        break;
                    }
                    if (start) {
                        if (strLine.length() != 0) {
                            // split the line on your splitter(s)
                            String[] splitted1 = strLine.split("[ ]{3,}"); // here [ ]{2,} is used as the delimiter
                            if (splitted1.length > 1) {
                                No = splitted1[1];
                            }
                            strings = strings + splitted1[0];
                        } else {
                            String Properties = "";
                            if (strings.length() != 0) {
                                String[] splitted2 = strings.split(", by ");
                                if (splitted2.length > 1) {
                                    int index = splitted2[1].indexOf("["); //mencari posisi karakter [
                                    if (index >= 0) {       //jika ketemu, ada propertiesnya
                                        Author = splitted2[1].substring(0, index);  //ambil string dari index 0 sebanyak index
                                        String properties;
                                        properties = splitted2[1].substring(index).replaceAll("//]", ""); //ambil string di mulai dari index
                                        String[] tmp = properties.split("\\[");
                                        for(int i = 1; i < tmp.length; i++){
                                            Properties += "- " + tmp[i] + "---";    //split berdasarkan ---
                                        }
                                    } else {
                                        Author = splitted2[1];
                                    }
                                }
                                Title = splitted2[0];
                                theList.insertFirst(Author, Title, No, Properties);
                            }

                            strings = "";
                            Author = "";
                            Title = "";
                            No = "";
                        }
                    }
                }
            }
        } catch (Exception e) {
            for (StackTraceElement i : e.getStackTrace()) {
                System.err.println(i.toString());
            }
            JOptionPane.showMessageDialog(Output, "Error: " + e);
        }
//        JOptionPane.showMessageDialog(Output, "Data Has Been Inserted");

        initComponents();
        this.setLocationRelativeTo(null);

    }

    public String Output() {
        return key;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        Search = new javax.swing.JButton();
        Output = new java.awt.List();
        Exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        InputText = new java.awt.TextField();
        label1 = new java.awt.Label();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Search.setText("Search");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Output.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OutputActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        jLabel1.setText("Input Author, Title or Number :");

        InputText.setText("");
        InputText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTextActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        label1.setText("Search Catalog Gutenberg V.1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Catalog");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel4.setText("Gutenberg");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Project");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gutenbergcatalogproject/icon.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        jLabel6.setText("by 116120148 | 116120146");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Exit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Output, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(InputText, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(InputText, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(Search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_ExitActionPerformed

    private void InputTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTextActionPerformed
        searchAction();

    }//GEN-LAST:event_InputTextActionPerformed

    private void OutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OutputActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_OutputActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        searchAction();
}//GEN-LAST:event_SearchActionPerformed

    void searchAction(){
        // TODO add your handling code here:
        Output.clear();
        //        if(InputText.getText()!=null){
        key = InputText.getText();
        //        }
        // make new list
        // insert four items

        Link current = theList.first;    // start at beginning of list
        boolean found = false;
        while (current != null && key != null) {
            if (current.Author.contains(key) || current.No.contains(key) || current.Title.contains(key)) {
                System.out.println(theList.displayLink(current));
                String[] str = theList.displayLink(current).split("---");
                found = true;
                for (int i = 0; i < str.length; i++) {
                    Output.add(str[i]);
                }
                Output.add("");   //ngasih enter untuk baris berikutnya
            }
            current = current.next;  // move to next link
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Catalog Not Found");
//                break;
        }
        JOptionPane.showMessageDialog(null, "Search Finished");
        //        if (current == null) {
        //            JOptionPane.showMessageDialog(InputText, "Catalog Not Found");
        //        }
        System.out.println("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SearchCatalog().setVisible(true);
            }
        });


    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private java.awt.TextField InputText;
    private java.awt.List Output;
    private javax.swing.JButton Search;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
