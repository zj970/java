/*
 * one.java
 *
 * Created on __DATE__, __TIME__
 */

package add;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class one extends javax.swing.JFrame {

	/** Creates new form one */
	public one() {
		initComponents();
		Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
		int x, y;
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		x = (size.width - 550) / 2;
		y = (size.height - 1000) / 2;
		setLocation(x, y);
		//让程序界面显示在屏幕中央
		setMinimumSize(new Dimension(250, 150));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24));
		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/images/add.png"))); // NOI18N
		jButton1.setText("\u786e\u8ba4");
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				jButton1MouseEntered(evt);
			}
		});
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36));
		jLabel1.setForeground(new java.awt.Color(51, 51, 255));
		jLabel1.setText("\u57fa\u672c\u4fe1\u606f");

		jLabel2.setForeground(new java.awt.Color(255, 51, 51));
		jLabel2.setText("\u7f16\u53f7");

		jLabel3.setForeground(new java.awt.Color(255, 0, 51));
		jLabel3.setText("\u540d\u5b57");

		jLabel4.setForeground(new java.awt.Color(255, 0, 51));
		jLabel4.setText("\u5ba0\u7269\u79cd\u7c7b");

		jLabel5.setForeground(new java.awt.Color(255, 0, 0));
		jLabel5.setText("\u5e74\u9f84");

		jLabel6.setForeground(new java.awt.Color(255, 0, 0));
		jLabel6.setText("\u6027\u522b");

		jLabel7.setForeground(new java.awt.Color(255, 51, 0));
		jLabel7.setText("\u5165\u5e93\u65f6\u95f4");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel2)
												.addComponent(jLabel3)
												.addComponent(jLabel4)
												.addComponent(jLabel5)
												.addComponent(jLabel6)
												.addComponent(jLabel7))
								.addGap(65, 65, 65)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addComponent(
														jTextField1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														115,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField2)
												.addComponent(jTextField3)
												.addComponent(jTextField4)
												.addComponent(jTextField5)
												.addComponent(jTextField6))
								.addGap(486, 486, 486))
				.addGroup(
						layout.createSequentialGroup().addGap(132, 132, 132)
								.addComponent(jLabel1)
								.addContainerGap(291, Short.MAX_VALUE))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(370, Short.MAX_VALUE)
								.addComponent(jButton1).addGap(96, 96, 96)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(jLabel2)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addGap(36, 36,
																		36)
																.addComponent(
																		jTextField1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(43, 43, 43)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField2,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel3))
								.addGap(46, 46, 46)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(
														jTextField3,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel4))
								.addGap(50, 50, 50)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField4,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel5))
								.addGap(46, 46, 46)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField5,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel6))
								.addGap(49, 49, 49)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jTextField6,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel7))
								.addGap(28, 28, 28).addComponent(jButton1)
								.addContainerGap(28, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pet", "root", "admin");
			//3.创建语句
			st = conn.createStatement();
			String a = this.jTextField1.getText();
			String b = this.jTextField2.getText();
			String e = this.jTextField3.getText();
			String f = this.jTextField4.getText();
			String g = this.jTextField5.getText();
			String h = this.jTextField6.getText();

			String sql = "insert into one(编号,名字,宠物种类,年龄,性别,入库时间) values('" + a
					+ "','" + b + "','" + e + "','" + f + "','" + g + "','" + h
					+ "')";

			//4.执行语句
			st.executeUpdate(sql);
			//System.out.println("i=" + i);
			st.executeQuery("select * from one");
			//System.out.print("操作成功!");
			System.out.println("添加成功！");
			JOptionPane.showMessageDialog(null, "添加成功！");
		} catch (Exception e) {
			System.out.print("操作失败!");
			JOptionPane.showMessageDialog(null, "操作失败!");
			e.printStackTrace();
		}
	}

	private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new one().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	// End of variables declaration//GEN-END:variables

}