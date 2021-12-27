/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package THISINH;

import CLASS.CauHoi;
import Connector.Connector;
import ADMIN.FormDangNhap;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class FormThi extends javax.swing.JFrame implements Runnable {

    private static int tic = 0;
    private static int sec = 0;
    private static int min = 14;

    private boolean Run_Time = false;
    private static Thread runtimer;

    public Connector cnn = new Connector();

    public int cauhoiso = 0;
    public ArrayList<CauHoi> dscauhoi = new ArrayList<CauHoi>();
    public ArrayList<String> cauhoi = new ArrayList<String>();
    public String[] cauhoi2 = new String[20];
    FormDangNhap jdangnhap = new FormDangNhap();
    public String cmt = "";

    public FormThi() {
        initComponents();
        setLocationRelativeTo(null);  
        dscauhoi = cnn.getDataCauHoi();
        ArrayList<CauHoi> dscauhoi1 = new ArrayList<CauHoi>();
        for (CauHoi ch1 : dscauhoi) {
            if (Integer.parseInt(ch1.getMaCauHoi().trim()) < 11) {
                dscauhoi1.add(ch1);
            }
        }
        Collections.shuffle(dscauhoi1);
        ArrayList<CauHoi> dscauhoi2 = new ArrayList<CauHoi>();
        for (CauHoi ch2 : dscauhoi) {
            if (Integer.parseInt(ch2.getMaCauHoi().trim()) < 16 && Integer.parseInt(ch2.getMaCauHoi().trim()) > 10) {
                dscauhoi2.add(ch2);
            }
        }
        Collections.shuffle(dscauhoi2);

        ArrayList<CauHoi> dscauhoi3 = new ArrayList<CauHoi>();
        for (CauHoi ch3 : dscauhoi) {
            if (Integer.parseInt(ch3.getMaCauHoi().trim()) < 21 && Integer.parseInt(ch3.getMaCauHoi().trim()) > 15) {
                dscauhoi3.add(ch3);
            }
        }
        Collections.shuffle(dscauhoi3);

        dscauhoi.clear();
        dscauhoi.addAll(dscauhoi1);
        dscauhoi.addAll(dscauhoi2);
        dscauhoi.addAll(dscauhoi3);
        showCauHoi(dscauhoi.get(cauhoiso));
        run();
        Run_Time = true;
        runtimer = new Thread(this);
        runtimer.start();

    }

    //Đồng hồ thời gian
    public void run() {
        try {

            while (Run_Time) {

                tic++;
                if (tic == 100) {
                    sec -= 1;
                    tic = 0;
                    if (sec < 0) {
                        sec = 59;
                    } else if (sec == 0) {
                        if (min == 0) {
                            jsec.setText(String.valueOf(sec));
                            JOptionPane.showMessageDialog(rootPane, "Hết giờ làm bài");
                            jHoanThanhBaiThiActionPerformed(null);
                            break;
                        } else {
                            min -= 1;
                        }
                    }
                }
                jsec.setText(String.valueOf(sec));
                jmin.setText(String.valueOf(min));

                Thread.sleep(10);

            }
        } catch (Exception e) {
            e.printStackTrace();

            return;
        }

    }

    public void showCauHoi(CauHoi cauHoi) {
        jDapAn4.setVisible(true);
        jLabel1.setText("Câu  " + (cauhoiso + 1));
        jLabel4.setText("Câu " + (cauhoiso + 1) + " : ");
        jLabel2.setText(cauHoi.getCauHoi());
        // bỏ check rdb
        jDapAn1.setSelected(false);
        jDapAn2.setSelected(false);
        jDapAn3.setSelected(false);
        jDapAn4.setSelected(false);
        if (Integer.parseInt(cauHoi.getMaCauHoi().trim()) < 11) {

            jPanel1.setVisible(false);
            jDapAn1.setText(cauHoi.getDapAn1());
            jDapAn2.setText(cauHoi.getDapAn2());
            // dap an 3 không tồn tại thì ẩn rdbDapAn3
            if (cauHoi.getDapAn3().trim().equals("")) {
                jDapAn3.setVisible(false);
            } else {
                jDapAn3.setVisible(true);
                jDapAn3.setText(cauHoi.getDapAn3());
            }
            // tương tự 3 
            if (cauHoi.getDapAn4().trim().equals("")) {
                jDapAn4.setVisible(false);
            } else {
                jDapAn4.setVisible(true);
                jDapAn4.setText(cauHoi.getDapAn4());
            }

            jlbl1.setVisible(false);
            jlbl2.setVisible(false);
            jlbl3.setVisible(false);

        } else if (Integer.parseInt(cauHoi.getMaCauHoi().trim()) < 16) {
            jPanel1.setVisible(true);
            // hiện pb
            jlbl1.setVisible(true);
            jlbl2.setVisible(true);
            jlbl3.setVisible(true);

            // ẩn rdbDapAn4
            jDapAn4.setVisible(false);

            jDapAn1.setText("1");
            jDapAn2.setText("2");
            jDapAn3.setText("3");
            jlbl1.setText("1");
            jlbl2.setText("2");
            jlbl3.setText("3");
            Image img1 = new ImageIcon(this.getClass().getResource("Image/" + cauHoi.getMaCauHoi().trim() + ".1.png")).getImage();
            jlbl1.setIcon(new ImageIcon(img1.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

            Image img2 = new ImageIcon(this.getClass().getResource("Image/" + cauHoi.getMaCauHoi().trim() + ".2.png")).getImage();
            jlbl2.setIcon(new ImageIcon(img2.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

            Image img3 = new ImageIcon(this.getClass().getResource("Image/" + cauHoi.getMaCauHoi().trim() + ".3.png")).getImage();
            jlbl3.setIcon(new ImageIcon(img3.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));

        } else {
            jlbl2.setText("");
            jPanel1.setVisible(true);
            // hiện pb câu hỏi
            jlbl1.setVisible(false);
            jlbl2.setVisible(true);
            jlbl2.setText("");
            jlbl3.setVisible(false);
            jDapAn1.setText(cauHoi.getDapAn1());
            jDapAn2.setText(cauHoi.getDapAn2());
            // dap an 3 không tồn tại thì ẩn rdbDapAn3
            if (cauHoi.getDapAn3().trim().equals("")) {
                jDapAn3.setVisible(false);
            } else {
                jDapAn3.setVisible(true);
                jDapAn3.setText(cauHoi.getDapAn3());
            }
            // tương tự 3 
            if (cauHoi.getDapAn4().trim().equals("")) {
                jDapAn4.setVisible(false);
            } else {
                jDapAn4.setVisible(true);
                jDapAn4.setText(cauHoi.getDapAn4());
            }
            // ẩn picture box
            //   jLabel2.setVisible(true);

            Image img4 = new ImageIcon(this.getClass().getResource("Image/" + cauHoi.getMaCauHoi().trim() + ".png")).getImage();
            jlbl2.setIcon(new ImageIcon(img4.getScaledInstance(300, 100, Image.SCALE_DEFAULT)));
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jDapAn1 = new javax.swing.JRadioButton();
        jDapAn2 = new javax.swing.JRadioButton();
        jDapAn3 = new javax.swing.JRadioButton();
        jDapAn4 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlbl1 = new javax.swing.JLabel();
        jlbl2 = new javax.swing.JLabel();
        jlbl3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jmin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jsec = new javax.swing.JLabel();
        jCauTruoc = new javax.swing.JButton();
        jCauSau = new javax.swing.JButton();
        jLamLai = new javax.swing.JButton();
        jHoanThanhBaiThi = new javax.swing.JButton();
        jThoat = new javax.swing.JButton();

        jLabel8.setText("jLabel8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 51));
        setLocation(new java.awt.Point(300, 300));

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));

        jDapAn1.setText("Đáp án 1");
        jDapAn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDapAn1ActionPerformed(evt);
            }
        });

        jDapAn2.setText("Đáp án 2");
        jDapAn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDapAn2ActionPerformed(evt);
            }
        });

        jDapAn3.setText("Đáp án 3");
        jDapAn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDapAn3ActionPerformed(evt);
            }
        });

        jDapAn4.setText("Đáp án 4");
        jDapAn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDapAn4ActionPerformed(evt);
            }
        });

        jLabel4.setText("Câu  ");

        jLabel2.setText("Câu Hỏi : ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jlbl1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlbl2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlbl3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jlbl1)
                .addGap(180, 180, 180)
                .addComponent(jlbl2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                .addComponent(jlbl3)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl1)
                    .addComponent(jlbl2)
                    .addComponent(jlbl3))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jLabel3.setText("/ 20");

        jLabel1.setText("Câu : ");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconButton/delivery.png"))); // NOI18N
        jLabel5.setText("Thi Bằng Lái Xe Máy Hạng A1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jDapAn1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDapAn4)
                            .addComponent(jDapAn3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDapAn2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jDapAn1)
                        .addGap(18, 18, 18)
                        .addComponent(jDapAn2)
                        .addGap(18, 18, 18)
                        .addComponent(jDapAn3)
                        .addGap(18, 18, 18)
                        .addComponent(jDapAn4)
                        .addContainerGap(116, Short.MAX_VALUE))))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconButton/history.png"))); // NOI18N
        jLabel9.setText("Thời gian còn lại");

        jmin.setForeground(new java.awt.Color(255, 0, 0));
        jmin.setText("0");

        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setText(":");

        jsec.setForeground(new java.awt.Color(255, 0, 0));
        jsec.setText("0");

        jCauTruoc.setBackground(new java.awt.Color(0, 204, 0));
        jCauTruoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconButton/arrow.png"))); // NOI18N
        jCauTruoc.setText("Câu trước");
        jCauTruoc.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCauTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCauTruocActionPerformed(evt);
            }
        });

        jCauSau.setBackground(new java.awt.Color(0, 204, 0));
        jCauSau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconButton/arrow1.png"))); // NOI18N
        jCauSau.setText("Câu sau");
        jCauSau.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCauSau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCauSauActionPerformed(evt);
            }
        });

        jLamLai.setBackground(new java.awt.Color(0, 204, 0));
        jLamLai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconButton/music-and-multimedia.png"))); // NOI18N
        jLamLai.setText("Làm Lại");
        jLamLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLamLaiActionPerformed(evt);
            }
        });

        jHoanThanhBaiThi.setBackground(new java.awt.Color(0, 204, 0));
        jHoanThanhBaiThi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconButton/tick.png"))); // NOI18N
        jHoanThanhBaiThi.setText("Hoàn Thành Bài Thi");
        jHoanThanhBaiThi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHoanThanhBaiThiActionPerformed(evt);
            }
        });

        jThoat.setBackground(new java.awt.Color(0, 204, 0));
        jThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconButton/exit.png"))); // NOI18N
        jThoat.setText("Thoát");
        jThoat.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLamLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCauTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jmin)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsec))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(321, 321, 321)
                        .addComponent(jHoanThanhBaiThi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(323, 323, 323)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCauSau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jCauSau)
                                .addComponent(jLabel9)
                                .addComponent(jmin)
                                .addComponent(jsec)
                                .addComponent(jLabel6))
                            .addComponent(jCauTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLamLai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jHoanThanhBaiThi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLamLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLamLaiActionPerformed

        FormThi FF = new FormThi();
        FF.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLamLaiActionPerformed

    private void jThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jThoatActionPerformed

        int n = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát chương trình không", "Exit", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            jdangnhap.setVisible(true);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jThoatActionPerformed

    private void jCauSauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCauSauActionPerformed
        try {
            cauhoiso += 1;
            showCauHoi(dscauhoi.get(cauhoiso));
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Không thể chuyển về câu sau");
        }
    }//GEN-LAST:event_jCauSauActionPerformed

    private void jCauTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCauTruocActionPerformed
        try {
            cauhoiso -= 1;
            showCauHoi(dscauhoi.get(cauhoiso));

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Không thể chuyển về câu trước");
        }
    }//GEN-LAST:event_jCauTruocActionPerformed

    private void jDapAn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDapAn1ActionPerformed
        cauhoi.add(cauhoiso, "1");

        if (cauhoi2[cauhoiso] == null) {
            cauhoi2[cauhoiso] = "1";
        } else {
            cauhoi2[cauhoiso] += "1";
        }
    }//GEN-LAST:event_jDapAn1ActionPerformed

    private void jDapAn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDapAn2ActionPerformed
        cauhoi.add(cauhoiso, "2");

        if (cauhoi2[cauhoiso] == null) {
            cauhoi2[cauhoiso] = "2";
        } else {
            cauhoi2[cauhoiso] += "2";
        }
    }//GEN-LAST:event_jDapAn2ActionPerformed

    private void jDapAn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDapAn3ActionPerformed
        cauhoi.add(cauhoiso, "3");

        if (cauhoi2[cauhoiso] == null) {
            cauhoi2[cauhoiso] = "3";
        } else {
            cauhoi2[cauhoiso] += "3";
        }
    }//GEN-LAST:event_jDapAn3ActionPerformed

    private void jDapAn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDapAn4ActionPerformed
        cauhoi.add(cauhoiso, "4");

        if (cauhoi2[cauhoiso] == null) {
            cauhoi2[cauhoiso] = "4";
        } else {
            cauhoi2[cauhoiso] += "4";
        }
    }//GEN-LAST:event_jDapAn4ActionPerformed

    private void jHoanThanhBaiThiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHoanThanhBaiThiActionPerformed
        int diem = 0;
        String ketqua;
        for (int i = 0; i < 20; i++) {
            if (dscauhoi.get(i).getDapAnDung().trim().equals(cauhoi2[i])) {
                diem++;
            }
        }
        // Cap nhat diem sau khi nop bai

        String query = "Update THISINH set DIEM = " + diem + " where SOCMT = '" + cmt + "'";
        cnn.UpdateData(query);
        
        if (diem < 16) {
            ketqua = "Không đạt";
        } else {
            ketqua = "Đạt";
        }
        String sql = "Update THISINH set KETQUA = '"+ketqua+"' where SOCMT = '" + cmt + "'";
        cnn.UpdateData(sql);

        JOptionPane.showMessageDialog(this, "Số điểm của bạn là: " + diem);
        JOptionPane.showMessageDialog(this, "KẾt quả : " + ketqua);
        runtimer.stop();
        jHoanThanhBaiThi.setVisible(false);
    }//GEN-LAST:event_jHoanThanhBaiThiActionPerformed

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
            java.util.logging.Logger.getLogger(FormThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormThi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCauSau;
    private javax.swing.JButton jCauTruoc;
    private javax.swing.JRadioButton jDapAn1;
    private javax.swing.JRadioButton jDapAn2;
    private javax.swing.JRadioButton jDapAn3;
    private javax.swing.JRadioButton jDapAn4;
    private javax.swing.JButton jHoanThanhBaiThi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLamLai;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jThoat;
    private javax.swing.JLabel jlbl1;
    private javax.swing.JLabel jlbl2;
    private javax.swing.JLabel jlbl3;
    private javax.swing.JLabel jmin;
    private javax.swing.JLabel jsec;
    // End of variables declaration//GEN-END:variables

}
