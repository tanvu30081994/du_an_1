package MDIView;

import DAO.CauHoiDAO;
import DAO.DeThiDAO;
import Model.CauHoi;
import Model.ThanhVien;
import Model.TraLoi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author xuant
 */
public class TestReading extends javax.swing.JPanel {

    /**
     * Creates new form TestReading
     */
    //tạo list chứa danh sách câu hỏi
    List<CauHoi> list = new ArrayList<>();

    //tạo list chứa danh sách câu trả lời
    List<TraLoi> listAnswer = new ArrayList<>();

    //tạo mảng form câu hỏi
    QuestionForm qf[] = new QuestionForm[40];

    int index = 0;

    TestDisplay testDp;

    String level = "";

    int examID;

    ThanhVien member;

    //tạo biến lưu thời gian còn lại
    int thoiGian;

    JDesktopPane jDesktopPane;

    public TestReading(TestDisplay testDisplay, String capDo, ThanhVien tv, JDesktopPane jdk) {
        initComponents();
        testDp = testDisplay;
        level = capDo;
        member = tv;
        jDesktopPane = jdk;
        //gọi hàm đổ câu hỏi
        fillQuestion();
        //gọi hàm hiển thị thời gian
        setTime();
        //gọi hàm thêm sự kiên cho 4 nút
        addEvent();

        mark();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblTime = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        tbpQuestion = new javax.swing.JTabbedPane();
        lblCount = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 0));
        setPreferredSize(new java.awt.Dimension(777, 517));

        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Alarm.png"))); // NOI18N
        lblTime.setText("Time");

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next_1.png"))); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnPre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/prev.png"))); // NOI18N
        btnPre.setText("Prev");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });

        btnFinish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/finish.png"))); // NOI18N
        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        lblCount.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblCount.setForeground(new java.awt.Color(255, 255, 255));
        lblCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCount.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbpQuestion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 291, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(btnPre)
                .addGap(37, 37, 37)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnFinish)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFinish, btnNext, btnPre});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCount)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbpQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnFinish, btnNext, btnPre});

    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
            if (index == 39) {
                index = -1;
            }
            index++;
            tbpQuestion.setSelectedComponent(qf[index]);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        try {
            if (index == 0) {
                index = 40;
            }
            index--;
            tbpQuestion.setSelectedComponent(qf[index]);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        try {
            List<Integer> listIntegers = check();
            if (listIntegers.size() != 0) {
                Object[] mes = {"Okie đợi làm nốt", "Chịu thôi k biết làm"};
                int option = JOptionPane.showOptionDialog(null, "Bạn chưa làm các câu\n" + listIntegers.toString(), "Notice!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, mes, mes[0]);
                if (option == 1) {
                    getAnswer();
                    TestListening testListening = new TestListening(examID, listAnswer, member, testDp, thoiGian, jDesktopPane);
                    testDp.getTbpTest().removeAll();
                    testDp.getTbpTest().addTab(level + "- Listening", testListening);
                }
                if (option == 0) {
                    return;
                }
            } else {
                Object[] mes = {"Đúng vậy", "Khoan đã"};
                int option = JOptionPane.showOptionDialog(null, "Bạn chắc chắn chuyển sang phần nghe?", "Notice!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, mes, mes[0]);
                if (option == 0) {
                    getAnswer();
                    TestListening testListening = new TestListening(examID, listAnswer, member, testDp, thoiGian, jDesktopPane);
                    testDp.getTbpTest().removeAll();
                    testDp.getTbpTest().addTab(level + "- Listening", testListening);
                }
                if (option == 1) {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    //hàm hiển thị thời gian
    private void setTime() {

        Timer timer = new Timer(1000, new ActionListener() {
            //lấy thời gian của đề thi
            int time = DeThiDAO.getTime(examID);
            //tính toán giờ, phút, giây
            int hours = time / 3600;
            int minutes = (time - hours * 3600) / 60;
            int seconds = time - hours * 3600 - minutes * 60;

            String h = "", m = "", s = "";

            @Override
            public void actionPerformed(ActionEvent ae) {
                //hiển thị giờ
                if (hours < 10) {
                    h = "0" + hours;
                } else {
                    h = String.valueOf(hours);
                }
                //hiển thị phút
                if (minutes < 10) {
                    m = "0" + minutes;
                } else {
                    m = String.valueOf(minutes);
                }
                //hiển thị giây
                if (seconds < 10) {
                    s = "0" + seconds;
                } else {
                    s = String.valueOf(seconds);
                }
                String show = String.format("%s:%s:%s s", h, m, s);
                lblTime.setText(show);
                if (seconds == 0) {
                    seconds = 59;
                    if (minutes == 0) {
                        minutes = 59;
                        hours--;
                    } else {
                        minutes--;
                    }
                } else {
                    seconds--;
                }
                time--;
                thoiGian = time;
            }
        });
        timer.start();
    }
//    hàm đổ câu hỏi lên form

    private void fillQuestion() {
        //lấy mã đề thi ngẫu nhiên của cấp độ
        int maDT = CauHoiDAO.getExamId(level);
        if (maDT == -1) {
            JOptionPane.showMessageDialog(this, "Kho đề thi đang trống, vui lòng quay lại sau!");
            return;
        }
        examID = maDT;
        //lấy danh sách câu hỏi
        list = CauHoiDAO.selectReading(maDT);
        //lấy mã câu hỏi và đáp án đúng
        for (CauHoi ch : list) {
            TraLoi tl = new TraLoi();
            tl.setDapAnDung(ch.getDapAnDung());
            tl.setMaCH(ch.getMaCH());
            listAnswer.add(tl);
        }
        for (int i = 0; i < qf.length; i++) {
            qf[i] = new QuestionForm(list.get(i));
            tbpQuestion.addTab(String.valueOf(i + 1), qf[i]);
        }
        lblCount.setText("Question " + (index + 1) + " of " + list.size());
    }

    private void addEvent() {
        tbpQuestion.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                index = tbpQuestion.getSelectedIndex();
                lblCount.setText("Question " + (index + 1) + " of " + list.size());
            }
        });
    }

    private void mark() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<Integer> list = check();
                for (int i = 0; i < qf.length; i++) {
                    boolean flag = false;
                    for (int j = 0; j < list.size(); j++) {
                        if (i == list.get(j) - 1) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        tbpQuestion = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, qf[i]);
                        tbpQuestion.setTitleAt(i, "[" + (i + 1) + "]");
                    }else{
                        tbpQuestion = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, qf[i]);
                        tbpQuestion.setTitleAt(i, String.valueOf(i + 1));
                    }
                }
            }
        });
        timer.start();
    }

    //hàm lấy câu trả lời
    private void getAnswer() {
        for (int i = 0; i < list.size(); i++) {
            List<String> listAns = new ArrayList<>();
            switch (list.get(i).getMaLCH()) {
                case 1:
                    String s1 = "";
                    try {
                        s1 = qf[i].getBg().getSelection().getActionCommand();
                    } catch (Exception e) {
                        s1 = "Chưa chọn";
                    }
                    listAns.add(s1);
                    break;
                case 2:
                    for (JCheckBox jc : qf[i].getChk()) {
                        if (jc.isSelected()) {
                            listAns.add(jc.getActionCommand().trim());
                        }
                    }
                    if (listAns.size() == 0) {
                        listAns.add("Chưa chọn");
                    }
                    break;
                case 3:
                    String s3 = "";
                    if (qf[i].getTxt().getText().trim().length() == 0) {
                        s3 = "Chưa chọn";
                    } else {
                        s3 = qf[i].getTxt().getText().trim();
                    }
                    listAns.add(s3);
                    break;
                default:
                    break;

            }
            listAnswer.get(i).setDapAnChon(listAns.toString());
        }
    }

    //hàm kiểm tra các câu chưa làm
    private List<Integer> check() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < qf.length; i++) {
            int flag = qf[i].getLoaiCH();
            switch (flag) {
                case 1:
                    if (qf[i].getBg().getSelection() == null) {
                        list.add(i + 1);
                    }
                    break;
                case 2:
                    boolean res = true;
                    for (JCheckBox jc : qf[i].getChk()) {
                        if (jc.isSelected()) {
                            res = false;
                            break;
                        }
                    }
                    if (res) {
                        list.add(i + 1);
                    }
                    break;
                case 3:
                    if (qf[i].getTxt().getText().trim().length() == 0) {
                        list.add(i + 1);
                    }
                    break;
                default:
                    break;
            }
        }
        return list;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTabbedPane tbpQuestion;
    // End of variables declaration//GEN-END:variables
}
