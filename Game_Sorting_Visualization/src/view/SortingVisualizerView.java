package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SortingVisualizerController;
import model.SortingVisualizerModel;

public class SortingVisualizerView extends JFrame{
	public SortingVisualizerModel model;
	public JPanel controllerPanel;
	public JButton jButton_ChonThuatToan;
	public JComboBox<String> jComboBox_ThuatToan;
	public JButton jButton_ChayThuatToan;
	public JLabel jLabel_ChonThuatToan;
	public JLabel jLabel_DoThi;
	public JPanel jPanel_HienThiThanh;
	public JButton jButton_Random;
	private JButton jButton_HienThiThuatToan;

	
	public SortingVisualizerView() {
		this.model = new SortingVisualizerModel();
		this.init();
	}
	private void init() {
		this.setTitle("Sorting Visualizer");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		Font font_1 = new Font("Times New Roman", Font.BOLD, 40);
		
		SortingVisualizerController controller = new SortingVisualizerController(this, model);
		
		//hiển thị đồ thị
		jPanel_HienThiThanh = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawArray(g);
			}
		};
		jPanel_HienThiThanh.setLayout(new BorderLayout());
		jLabel_DoThi = new JLabel("Vui lòng ấn vào Random!", JLabel.CENTER);
		jLabel_DoThi.setFont(font_1);
		jLabel_DoThi.setForeground(Color.black);
		jPanel_HienThiThanh.setBackground(new Color(255, 234, 204));
		jPanel_HienThiThanh.add(jLabel_DoThi, BorderLayout.CENTER);
		this.add(jPanel_HienThiThanh, BorderLayout.CENTER);
		
		
		//tạo thanh điều khiển
		String[] thuatToanSapXep = {"BubbleSort", "SelectionSort", "InsertionSort", "MergeSort", "QuickSort"};
		controllerPanel = new JPanel();
		controllerPanel.setLayout(new GridLayout(1, 4));
		controllerPanel.setBackground(new Color(255, 234, 204)); 
		
		jComboBox_ThuatToan = new JComboBox<String>(thuatToanSapXep);
		jComboBox_ThuatToan.setFont(font);
		
		
		jButton_ChayThuatToan = new JButton("Start");
		jButton_ChayThuatToan.setForeground(Color.black);
		jButton_ChayThuatToan.setBackground(new Color(34, 177, 76)); 
		jButton_ChayThuatToan.addActionListener(controller);
		jButton_ChayThuatToan.setFont(font);
		
		jButton_Random = new JButton("Random");
		jButton_Random.setBackground(new Color(34, 177, 76)); 
		jButton_Random.setForeground(Color.black);
		jButton_Random.addActionListener(controller);
		jButton_Random.setFont(font);
		
		jLabel_ChonThuatToan = new JLabel("Chọn Thuật Toán:");
		jLabel_ChonThuatToan.setFont(font);
		jLabel_ChonThuatToan.setForeground(Color.black);
		
		jButton_HienThiThuatToan = new JButton("View");
		jButton_HienThiThuatToan.setFont(font);
		jButton_HienThiThuatToan.setBackground(new Color(34, 177, 76));
		jButton_HienThiThuatToan.setForeground(Color.black);
		jButton_HienThiThuatToan.addActionListener(controller);
		
		
		controllerPanel.add(jLabel_ChonThuatToan);
		controllerPanel.add(jComboBox_ThuatToan);
		controllerPanel.add(jButton_HienThiThuatToan);
		controllerPanel.add(jButton_ChayThuatToan);
		controllerPanel.add(jButton_Random);
		this.add(controllerPanel, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	public void drawArray(Graphics g) {
	    int[] array = this.model.getArray();
	    if (array == null || array.length == 0) return;

	    int panelWidth = jPanel_HienThiThanh.getWidth();
	    int panelHeight = jPanel_HienThiThanh.getHeight();

	    // Tính chiều rộng mỗi cột sao cho 12 cột tràn hết panel
	    int barWidth = panelWidth / array.length;

	    // Tìm giá trị lớn nhất trong mảng để tỷ lệ hóa chiều cao
	    int maxValue = 280; // Giá trị tối đa cố định từ 50 đến 200

	    // Thiết lập font để vẽ số
	    g.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    g.setColor(new Color(0, 191, 255));

	    // Vẽ các cột và số
	    for (int i = 0; i < array.length; i++) {
	        int barHeight = (int) ((double) array[i] / maxValue * panelHeight);
	        int x = i * barWidth;
	        int y = panelHeight - barHeight;
	        
	        
	        if(i == this.model.getIndex1()) {
	        	g.setColor(new Color(255, 55, 55));
	        }else if(i == this.model.getIndex2()) {
	        	g.setColor(new Color(255, 255, 55));
	        }else {
	        	g.setColor(new Color(0, 191, 255));
	        }
	        
	        // Vẽ cột
	        g.fillRect(x, y, barWidth - 2, barHeight);

	        // Vẽ số ngay trên đầu cột
	        g.setColor(Color.BLACK); // Đổi màu để số dễ đọc
	        String value = String.valueOf(array[i]);
	        int textWidth = g.getFontMetrics().stringWidth(value);
	        int textX = x + (barWidth - textWidth) / 2; // Canh giữa cột
	        int textY = y - 5; // Vẽ ngay phía trên cột
	        g.drawString(value, textX, textY);

	        // Đổi màu lại cho cột
	        g.setColor(new Color(0, 191, 255));
	    }
	}
	public void CreateRandom() {
		jPanel_HienThiThanh.remove(jLabel_DoThi);
		jPanel_HienThiThanh.repaint();
	}
	public void UpdateView() {
		jPanel_HienThiThanh.repaint();
	}
}
