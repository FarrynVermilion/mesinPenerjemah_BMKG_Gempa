/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mesinpenerjemah;

import com.opencsv.*;
import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author edelweiss
 */
public class MesinPenerjemah extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    Database dbsetting;
    String driver,database,user,pass,userLogin;
    String[] tokenTdkAbai;
    ArrayList<String> tanya = new ArrayList<>();
    ArrayList<String> pelengkap = new ArrayList<>();
    ArrayList<String> keterangan = new ArrayList<>();
    ArrayList<String> atribut = new ArrayList<>();
    ArrayList<String> operator = new ArrayList<>();
    ArrayList<String> wilayah = new ArrayList<>();
    
    public MesinPenerjemah() {
        try{
            String basePath = new File("").getAbsolutePath();
            BufferedReader fileToken = new BufferedReader(new FileReader(basePath+"/token.csv"));
            CSVReader csvToken = new CSVReader(fileToken);
            boolean x=false;
            while ((tokenTdkAbai= csvToken.readNext()) != null) { 
                if(x==false){
                    x=true;
                    continue;
                }
                tanya.add(tokenTdkAbai[0]);
                pelengkap.add(tokenTdkAbai[1]);
                keterangan.add(tokenTdkAbai[2]);
                atribut.add(tokenTdkAbai[3]);
                operator.add(tokenTdkAbai[4]);
                wilayah.add(tokenTdkAbai[5]);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        tanya.removeAll((Collections.singletonList("")));
        pelengkap.removeAll((Collections.singletonList("")));
        keterangan.removeAll((Collections.singletonList("")));
        atribut.removeAll((Collections.singletonList("")));
        operator.removeAll((Collections.singletonList("")));
        wilayah.removeAll((Collections.singletonList("")));
        
        replace(tanya);
        replace(pelengkap);
        replace(keterangan);
        replace(atribut);
        replace(operator);
        replace(wilayah);
        

        
        initComponents();
        dbsetting = new Database();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");

        table.setModel(tblModel);
        setDefaultTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        kalimat = new javax.swing.JTextArea();
        btn_scanner = new javax.swing.JButton();
        btn_token = new javax.swing.JButton();
        btn_parsing = new javax.swing.JButton();
        btn_proses = new javax.swing.JButton();
        btn_bersih = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        result_parse1 = new javax.swing.JLabel();
        result_parse2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Structure = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        SQL_Result = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUERRY BAHASA INDONESIA UNTUK DETEKSI GEMPA TERKINI");

        jLabel2.setText("Input Kalimat");

        kalimat.setColumns(20);
        kalimat.setRows(5);
        kalimat.setText("Masukan Kalimat");
        jScrollPane1.setViewportView(kalimat);

        btn_scanner.setText("Scanner");
        btn_scanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_scannerActionPerformed(evt);
            }
        });

        btn_token.setText("Token");
        btn_token.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tokenActionPerformed(evt);
            }
        });

        btn_parsing.setText("Parsing");
        btn_parsing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_parsingActionPerformed(evt);
            }
        });

        btn_proses.setText("Proses");
        btn_proses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prosesActionPerformed(evt);
            }
        });

        btn_bersih.setText("Bersih");
        btn_bersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bersihActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Index", "Kata", "Token", "Parsing"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table);

        result_parse1.setText("Hasil Struktur :");
        result_parse1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        result_parse2.setText("Hasil SQL      :");
        result_parse2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        Structure.setEditable(false);
        Structure.setColumns(20);
        Structure.setRows(5);
        Structure.setText("Struktur kalimat");
        jScrollPane3.setViewportView(Structure);

        SQL_Result.setEditable(false);
        SQL_Result.setColumns(20);
        SQL_Result.setRows(5);
        SQL_Result.setText("Hasil SQL");
        jScrollPane4.setViewportView(SQL_Result);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_scanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_token, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_parsing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_proses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_bersih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(result_parse2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(result_parse1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_scanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_token, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_parsing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_proses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_bersih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(result_parse1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(result_parse2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_scannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_scannerActionPerformed
        // TODO add your handling code here:
        String[] a=  kalimat.getText().replaceAll("[. , ; ? /]"," ").split(" ");
        if (a.length<5){
            Structure.setText("Kata kurang dari 5");
        }else{
            tblModel.setRowCount(0);
            String[] dummy={"","","",""};
            int i=0;
            for(String b:a){
                tblModel.addRow(dummy);
                tblModel.setValueAt(i+1, i,0);
                tblModel.setValueAt(b.toLowerCase(), i,1);
                i++;
            }
        }        
    }//GEN-LAST:event_btn_scannerActionPerformed

    private void btn_tokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tokenActionPerformed
        // TODO add your handling code here:
        int i = table.getRowCount();
        for(int x=0;x<i;x++){
            String res;
            String compare =tblModel.getValueAt(x, 1).toString();
            if(tanya.contains(compare)
                    ||pelengkap.contains(compare)
                    ||keterangan.contains(compare)
                    ||atribut.contains(compare)
                    ||operator.contains(compare)
                    ||wilayah.contains(compare)
                    ){
                    res="1";
            }else{
                res="0";
            }            
            tblModel.setValueAt(res,x,2);
        }
    }//GEN-LAST:event_btn_tokenActionPerformed

    private void btn_parsingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_parsingActionPerformed
        // TODO add your handling code here:
        HashMap<String, Integer> lokasiKata = new HashMap<>();
        HashMap<String, ArrayList<String>> jenisKata = new HashMap<>();
        
        jenisKata.put("tanya", new ArrayList<String>());
        jenisKata.put("pelengkap", new ArrayList<String>());
        jenisKata.put("keterangan", new ArrayList<String>());
        jenisKata.put("atribut", new ArrayList<String>());
        jenisKata.put("operator", new ArrayList<String>());
        jenisKata.put("wilayah", new ArrayList<String>());
        
        for(int x=0;x<table.getRowCount();x++){
            if(tblModel.getValueAt(x, 2).toString().equals("1")){
                String Value;
                String compare =tblModel.getValueAt(x, 1).toString();
                if(tanya.contains(compare)){
                    Value = "tanya";
                }else if(pelengkap.contains(compare)){
                    Value="pelengkap";
                }else if(keterangan.contains(compare)){
                    Value="keterangan";
                }else if(atribut.contains(compare)){
                    Value="atribut";
                }else if(operator.contains(compare)){
                    Value="operator";
                }else if(wilayah.contains(compare)){
                    Value="wilayah";
                }else if (cekAngka(compare)){
                    Value="data";
                }else{Value="?";}
                tblModel.setValueAt(Value, x, 3);
                ArrayList<String> a = jenisKata.get(Value);
                a.add(compare);
                jenisKata.put(Value,a);
                lokasiKata.put(compare,x+1);
            }
        }
        
        if(jenisKata.get("tanya").contains("tampilkan")
                &&Integer.parseInt(tblModel.getValueAt(lokasiKata.get("tampilkan"), 2).toString())==1){
            Structure.setText("Aturan 1");
            ArrayList<String> Array=jenisKata.get("atribut");
            if(jenisKata.get("atribut").size()==0&&jenisKata.get("operator").contains("seluruh")&&jenisKata.get("pelengkap").contains("field") && lokasiKata.get("seluruh")+1==lokasiKata.get("field")){
              TipeQuery1();
            }else{
              TipeQuery2(jenisKata.get("atribut"));   
            }
        }
        else if((!jenisKata.get("wilayah").isEmpty())
                &&(jenisKata.get("pelengkap").contains("posisi")
                ||jenisKata.get("pelengkap").contains("diposisi")
                ||jenisKata.get("atribut").contains("lintang")
                ||jenisKata.get("atribut").contains("bujur")
                ||jenisKata.get("atribut").contains("koordinat"))
                ){
            Structure.setText("Aturan 2");            
            if((jenisKata.get("atribut").contains("koordinat"))
                    ||(jenisKata.get("atribut").contains("bujur")&&jenisKata.get("atribut").contains("lintang"))){
                TipeQuery3(jenisKata.get("wilayah"),"all");
            }else if(jenisKata.get("atribut").contains("bujur")){
                System.out.println("bujur");
                TipeQuery3(jenisKata.get("wilayah"),"bujur");
            }else if(jenisKata.get("atribut").contains("lintang")){
                TipeQuery3(jenisKata.get("wilayah"),"lintang");
                System.out.println("lintang");
            }
        }
        else if((!jenisKata.get("wilayah").isEmpty() && jenisKata.get("tanya").contains("apakah")) && jenisKata.get("keterangan").contains("berpotensi")){
            Structure.setText("Aturan 4");
            TipeQuery5(jenisKata.get("wilayah"));
        }
        else if (!jenisKata.get("wilayah").isEmpty() && tanya.contains("kapan")){
            Structure.setText("Aturan 3");
            TipeQuery4(jenisKata.get("wilayah"));
        }
        else{
            Structure.setText("Tidak ada aturan ditemukan");
            SQL_Result.setText("Aturan yang tersedia \nAturan 1 \tTampilan \nAturan 2 \tDiposisi\nAturan 3 \tKapan\nAturan 4 \tApa");
        }
        
    }//GEN-LAST:event_btn_parsingActionPerformed
    
        public void TipeQuery1(){
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM Data_Gempa_Terkini";
            ResultSet res = stt.executeQuery(SQL);
            
            String Hasil ="";
            while(res.next()){
                for(int x = 1;x<=11;x++){
                    Hasil += res.getString(x)+"\t";
                }
                Hasil+="\n";
            }
            SQL_Result.setText(Hasil);
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }
    
        public void TipeQuery2(ArrayList<String> Atribut){
        try{
            if(Atribut.contains("koordinat")){
                Atribut.remove("koordinat");
                Atribut.add("lintang");
                Atribut.add("bujur");
            }
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT ";
            for(int x=0;x<Atribut.size();x++){
                if(x==Atribut.size()-1){
                    SQL+=Atribut.get(x);
                }else{
                    SQL+=Atribut.get(x)+",";
                }
            }
            SQL +=" from Data_Gempa_Terkini ";
            ResultSet res = stt.executeQuery(SQL);
            String Hasil="";
            while(res.next()){
                for(String str:Atribut){
                    Hasil+=str+" "+res.getString(str);
                }
                Hasil+="\n";
            }
            //menampilkan dalam text area
            SQL_Result.setText(Hasil);
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }
    public void TipeQuery3(ArrayList<String> Wilayah, String Request){
        try{
            String[] querry;
            if(Request.equals("all")){
                querry=new String[2];
                querry[0]="bujur";
                querry[1]="lintang";
            }else{
                querry=new String[1];
                querry[0]=Request;
            }
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT ";
            for(int x=0;x<querry.length;x++){
                if(x==querry.length-1){
                    SQL+=querry[x];
                }else{
                    SQL+=querry[x]+",";
                } 
            }
            SQL +=" from Data_Gempa_Terkini  WHERE ";
            for(int x=0;x<Wilayah.size();x++){
                if(x==0){
                    SQL+="Wilayah LIKE '%"+Wilayah.get(x)+"%' ";
                }else{
                    SQL+=" OR Wilayah LIKE '%"+Wilayah.get(x)+"%'";
                }
            }
            
            ResultSet res = stt.executeQuery(SQL);
            String Hasil="";
            while(res.next()){
                for(String str:querry){
                    Hasil+=str+" "+res.getString(str);
                }
                Hasil+="\n";
            }
            //menampilkan dalam text area
            SQL_Result.setText(Hasil);
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }
    public void TipeQuery4(ArrayList<String> Wilayah){
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT Datetime";
            SQL +=" from Data_Gempa_Terkini WHERE ";
            for(int x=0;x<Wilayah.size();x++){
                if(x==0){
                    SQL+="Wilayah LIKE '%"+Wilayah.get(x)+"%' ";
                }else{
                    SQL+=" OR Wilayah LIKE '%"+Wilayah.get(x)+"%'";
                }
            }
            ResultSet res = stt.executeQuery(SQL);
            String Hasil="";
            while(res.next()){
                Hasil+="\n" + res.getString("Datetime");
            }
            
            //menampilkan dalam text area
            SQL_Result.setText(Hasil);
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }
    public void TipeQuery5(ArrayList<String> Wilayah){
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT Potensi";
            SQL +=" from Data_Gempa_Terkini WHERE ";
            for(int x=0;x<Wilayah.size();x++){
                if(x==0){
                    SQL+="Wilayah LIKE '%"+Wilayah.get(x)+"%' ";
                }else{
                    SQL+=" OR Wilayah LIKE '%"+Wilayah.get(x)+"%'";
                }
            }
            ResultSet res = stt.executeQuery(SQL);
            String Hasil="";
            while(res.next()){
                Hasil+="\n" + res.getString("Potensi");
            }
            
            //menampilkan dalam text area
            SQL_Result.setText(Hasil);
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }
        
    private void btn_prosesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prosesActionPerformed
        // TODO add your handling code here:
        Structure.getText();
    }//GEN-LAST:event_btn_prosesActionPerformed

    private void btn_bersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bersihActionPerformed
        // TODO add your handling code here:
        tblModel.setRowCount(0);
        Structure.setText("Hasil structure");
        SQL_Result.setText("");
    }//GEN-LAST:event_btn_bersihActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MesinPenerjemah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MesinPenerjemah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MesinPenerjemah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MesinPenerjemah.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MesinPenerjemah().setVisible(true);
            }
        });
    }
    public void setDefaultTable(){
        String stat = "";
        String[] data = new String[4];
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM Data_Gempa_Terkini";
            ResultSet res = stt.executeQuery(SQL);
            
            while(res.next()){
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                tblModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }catch(Exception exc){
            System.err.println(exc.getMessage());
        }
    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
        return new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"Index", "Kata", "Token", "Parsing"}
        ){
          boolean[] canEdit = new boolean[]{
            false, false, false, false
          }; 
          public boolean isCellEditable(int rowIndex, int columnIndex){
              return canEdit[columnIndex];
          }
       };
   }
         
    public static void replace(List<String> strings){
        ListIterator<String> iterator = strings.listIterator();
        while (iterator.hasNext())
        {
            iterator.set(iterator.next().toLowerCase().trim());
        }
    }
    
    public static boolean cekAngka(String str) { 
        try {  
            Double.parseDouble(str);  
            return true;
        }catch(NumberFormatException e){  
            return false;  
        }  
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea SQL_Result;
    private javax.swing.JTextArea Structure;
    private javax.swing.JButton btn_bersih;
    private javax.swing.JButton btn_parsing;
    private javax.swing.JButton btn_proses;
    private javax.swing.JButton btn_scanner;
    private javax.swing.JButton btn_token;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea kalimat;
    private javax.swing.JLabel result_parse1;
    private javax.swing.JLabel result_parse2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
}
