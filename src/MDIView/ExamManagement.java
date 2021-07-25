package MDIView;

import View.*;
import DAO.CapDoDAO;
import DAO.CauHoiDAO;
import DAO.DeThiDAO;
import DAO.FormDAO;
import DAO.NhomCauHoiDAO;
import Model.CapDo;
import Model.CauHoi;
import Model.DeThi;
import Model.NhomCauHoi;
import java.beans.PropertyVetoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author xuant
 */
public class ExamManagement extends javax.swing.JPanel {

    DefaultTableModel model;

    TableRowSorter<TableModel> rowSorter = null;

    JDesktopPane jDesktopPane;

    int index = - 1;

    public ExamManagement(JDesktopPane jdk) {
        initComponents();
        model = (DefaultTableModel) tblExam.getModel();
        jDesktopPane = jdk;
        //gọi hàm đổ dữ liệu lên cbo Level
        fillCboLevel();
        //gọi hàm đổ dữ liệu lên cbo nhóm câu hỏi
        fillCboType();

        //gọi hàm cho sự kiện search
        search();
    }

    //hàm đổ dữ liệu lên combobox cấp độ
    private void fillCboLevel() {
        cboLevel.removeAllItems();
        List<CapDo> listLevel = CapDoDAO.selectAll();
        for (CapDo cd : listLevel) {
            cboLevel.addItem(cd.getTenCD());
        }
    }

    //hàm đổ dữ liệu lên combobox đề thi theo cấp độ
    private void fillCboExam() {
        String capDo = String.valueOf(cboLevel.getSelectedItem());
        List<DeThi> listExam = DeThiDAO.selectByLevel(capDo);
        cboExam.removeAllItems();
        for (DeThi dt : listExam) {
            cboExam.addItem(dt.getTenDT());
        }
    }

    //hàm đổ danh sách nhóm câu hỏi lên cbo
    private void fillCboType() {
        List<NhomCauHoi> listType = NhomCauHoiDAO.selectAll();
        cboType.removeAllItems();
        for (NhomCauHoi nch : listType) {
            cboType.addItem(nch.getTenNCH());
        }
    }

    //hàm đổ câu hỏi
    private void fillTable() {
        String tenDT = String.valueOf(cboExam.getSelectedItem());
        String tenNCH = String.valueOf(cboType.getSelectedItem());
        //lấy về ds câu hỏi
        List<CauHoi> list = CauHoiDAO.getList(tenDT, tenNCH);
        //đổ lên bảng
        model.setRowCount(0);
        for (CauHoi item : list) {
            model.addRow(new Object[]{
                item.getMaCH(), item.getNoiDungCH(), item.getDapAnA(), item.getDapAnB(),
                item.getDapAnC(), item.getDapAnD(), item.getDapAnDung(), item.getCapDo(), CauHoiDAO.getTenLCH(item.getMaLCH())
            });
        }
    }

    //hàm search
    private void search() {
        rowSorter = new TableRowSorter<>(model);
        tblExam.setRowSorter(rowSorter);
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = txtSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cboLevel = new javax.swing.JComboBox<>();
        cboExam = new javax.swing.JComboBox<>();
        cboType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAddExam = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExam = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(750, 630));
        setMinimumSize(new java.awt.Dimension(750, 630));
        setPreferredSize(new java.awt.Dimension(770, 626));

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Level");

        cboLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLevelItemStateChanged(evt);
            }
        });

        cboExam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboExam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboExamItemStateChanged(evt);
            }
        });

        cboType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTypeItemStateChanged(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Đề thi");

        jLabel2.setText("Nhóm câu hỏi");

        txtSearch.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.setText("Search...");
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(204, 0, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baseline_add_black_24dp.png"))); // NOI18N
        btnAdd.setText("Thêm câu hỏi");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(204, 0, 0));
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baseline_update_black_24dp.png"))); // NOI18N
        btnUpdate.setText("Sửa câu hỏi");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baseline_delete_black_24dp.png"))); // NOI18N
        btnDelete.setText("Xóa câu hỏi");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAddExam.setBackground(new java.awt.Color(204, 0, 0));
        btnAddExam.setForeground(new java.awt.Color(255, 255, 255));
        btnAddExam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Add.png"))); // NOI18N
        btnAddExam.setText("Thêm đề thi");
        btnAddExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddExamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(111, 111, 111))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboLevel, 0, 169, Short.MAX_VALUE)
                    .addComponent(btnAddExam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(34, 34, 34)
                        .addComponent(btnUpdate)
                        .addGap(41, 41, 41)
                        .addComponent(btnDelete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cboExam, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(398, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cboExam, cboLevel, cboType});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnAddExam, btnDelete, btnUpdate});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboExam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)))
                    .addComponent(btnAddExam, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboExam, cboLevel, cboType});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnAddExam, btnDelete, btnUpdate});

        tblExam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã câu hỏi", "Nội dung", "Đáp án A", "Đáp án B", "Đáp án C", "Đáp án D", "Đáp án đúng", "Cấp độ", "Loại câu hỏi"
            }
        ));
        tblExam.setRowHeight(26);
        tblExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblExam);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboLevelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLevelItemStateChanged
        fillCboExam();

    }//GEN-LAST:event_cboLevelItemStateChanged

    private void cboTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTypeItemStateChanged
        //đổ bảng
        fillTable();
    }//GEN-LAST:event_cboTypeItemStateChanged

    private void cboExamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboExamItemStateChanged
        //đổ bảng
        fillTable();
    }//GEN-LAST:event_cboExamItemStateChanged

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        txtSearch.setText(null);
    }//GEN-LAST:event_txtSearchMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int maDT = DeThiDAO.getID(String.valueOf(cboExam.getSelectedItem()));
        int maNCH = String.valueOf(cboType.getSelectedItem()).equals("Reading") ? 1 : 2;
        NewQuestion newQuestion = new NewQuestion(maDT, maNCH);
        newQuestion.setVisible(true);
        jDesktopPane.add(newQuestion);
        FormDAO.centerJIF(jDesktopPane, newQuestion);
        try {
            newQuestion.setSelected(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (index == - 1) {
            return;
        } else {
            int ans = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa chưa?");
            if (ans != JOptionPane.YES_OPTION) {
                return;
            } else {
                try {
                    int maCH = Integer.parseInt(String.valueOf(model.getValueAt(index, 0)));
                    CauHoiDAO.delete(maCH);
                    JOptionPane.showMessageDialog(this, "Xóa câu hỏi thành công!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Xóa câu hỏi thất bại!");
                    return;
                }
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblExamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExamMouseClicked
        index = tblExam.getSelectedRow();
    }//GEN-LAST:event_tblExamMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (index == -1) {
                return;
            } else {
                int maCH = Integer.parseInt(String.valueOf(model.getValueAt(index, 0)));
                CauHoi cauHoi = CauHoiDAO.getCauHoi(maCH);
                NewQuestion newQuestion = new NewQuestion(cauHoi);
                newQuestion.setVisible(true);
                jDesktopPane.add(newQuestion);
                FormDAO.centerJIF(jDesktopPane, newQuestion);
                try {
                    newQuestion.setSelected(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnAddExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddExamActionPerformed
       AddNewExam adn = new AddNewExam();
        jDesktopPane.add(adn);
        FormDAO.centerJIF(jDesktopPane, adn);
        try {
            adn.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(ExamManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddExamActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddExam;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboExam;
    private javax.swing.JComboBox<String> cboLevel;
    private javax.swing.JComboBox<String> cboType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblExam;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
