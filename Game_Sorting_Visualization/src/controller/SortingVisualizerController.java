package controller;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.SortingVisualizerModel;
import view.SortingVisualizerView;

public class SortingVisualizerController implements ActionListener{
	private SortingVisualizerView view;
	private JFrame jframe_windown = new JFrame();
	private JTextArea jTextArea = new JTextArea();
	private JFrame jFrame_Attitude = new JFrame();
	private JTextArea jTextArea_Attitude = new JTextArea();
	private SortingVisualizerModel model;
	
	public SortingVisualizerController(SortingVisualizerView view, SortingVisualizerModel model) {
		this.view = view;
		this.model = model;
		this.model.setOnUpdate(() -> view.UpdateView());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if(button.equals("Random")) {
			this.model.createRandom();
			this.view.CreateRandom();
			jTextArea_Attitude.setText("");
			String text = "Mảng ban đầu: ";
			for(int i = 0; i < this.model.getArray().length; i++) {
				text += this.model.getArray()[i] + "  ";
			}
			attitude(text);
		}else if(button.equals("View")){
			String luachon = view.jComboBox_ThuatToan.getSelectedItem().toString();
			if(luachon.equals("BubbleSort")) {
				int wedght = 400;
				int height = 270;
				int size = 20;
				String title = "Thuật Toán BubbleSort";
				String thuattoan = 
						"for (int i = 0; i < array.length - 1; i++) {\n"
						+ "    for (int j = 0; j < array.length - i - 1; j++) {\n"
						+ "        if (array[j] > array[j + 1]) {\n"
						+ "            int temp = array[j];\n"
						+ "            array[j] = array[j + 1];\n"
						+ "            array[j + 1] = temp;\n"
						+ "        }\n"
						+ "    }\n"
						+ "}\n";
				ThuatToan(title, thuattoan, wedght, height, size);
			}else if(luachon.equals("SelectionSort")) {
				int wedght = 370;
				int height = 320;
				int size = 20;
				String title = "Thuật Toán SelectionSort";
				String thuattoan = 
						"for (int i = 0; i < array.length - 1; i++) {\n"
						+ "    int minIndex = i;\n"
						+ "    for (int j = i + 1; j < array.length; j++) {\n"
						+ "        if (array[j] < array[minIndex]) {\n"
						+ "            minIndex = j;\n"
						+ "        }\n"
						+ "    }\n"
						+ "    int temp = array[minIndex];\n"
						+ "    array[minIndex] = array[i];\n"
						+ "    array[i] = temp;\n"
						+ "}\n";
				ThuatToan(title, thuattoan, wedght, height, size);
			}else if(luachon.equals("InsertionSort")) {
				int wedght = 310;
				int height = 270;
				int size = 20;
				String title = "Thuật toán InsertionSort";
				String thuattoan = 
						"for (int i = 1; i < array.length; ++i) {\n"
						+ "    int key = array[i];\n"
						+ "    int j = i - 1;\n"
						+ "    while (j >= 0 && arr[j] > key) {\n"
						+ "        array[j + 1] = array[j];\n"
						+ "        j = j - 1;\n"
						+ "    }\n"
						+ "    array[j + 1] = key;\n"
						+ "}";
				ThuatToan(title, thuattoan, wedght, height, size);
			}else if(luachon.equals("MergeSort")) {
				int wedght = 350;
				int height = 680;
				int size = 13;
				String title = "Thuật toán MergeSort";
				String thuattoan = 
						"public static void mergeSort(int[] arr, int left, int right) {\n"
						+ "    if (left < right) {\n"
						+ "        int middle = (left + right) / 2;\n"
						+ "        mergeSort(arr, left, middle);\n"
						+ "        mergeSort(arr, middle + 1, right);\n"
						+ "        merge(arr, left, middle, right);\n"
						+ "    }\n"
						+ "}\n"
						+ "public static void merge(int[] arr, int left, int middle, int right) {\n"
						+ "    int n1 = middle - left + 1;\n"
						+ "    int n2 = right - middle;\n"
						+ "    int[] L = new int[n1];\n"
						+ "    int[] R = new int[n2];\n"
						+ "    for (int i = 0; i < n1; ++i)\n"
						+ "        L[i] = arr[left + i];\n"
						+ "    for (int j = 0; j < n2; ++j)\n"
						+ "        R[j] = arr[middle + 1 + j];\n"
						+ "    int i = 0, j = 0;\n"
						+ "    int k = left;\n"
						+ "    while (i < n1 && j < n2) {\n"
						+ "        if (L[i] <= R[j]) {\n"
						+ "            arr[k] = L[i];\n"
						+ "            i++;\n"
						+ "        } else {\n"
						+ "            arr[k] = R[j];\n"
						+ "            j++;\n"
						+ "        }\n"
						+ "        k++\n"
						+ "    }\n"
						+ "    while (i < n1) {\n"
						+ "        arr[k] = L[i];\n"
						+ "        i++;\n"
						+ "        k++\n"
						+ "    }\n"
						+ "    while (j < n2) {\n"
						+ "        arr[k] = R[j];\n"
						+ "        j++\n"
						+ "        k++\n"
						+ "    }\n"
						+ "}\n";
				ThuatToan(title, thuattoan, wedght, height, size);
			}else if(luachon.equals("QuickSort")) {
				int wedght = 350;
				int height = 400;
				int size = 13;
				String title = "Thuật Toán QuickSort";
				String thuattoan = 
					"public static void quickSort(int[] arr, int low, int high) {\n"
					+ "    if (low < high) {\n"
					+ "        int pi = partition(arr, low, high);\n"
					+ "        quickSort(arr, low, pi - 1);\n"
					+ "        quickSort(arr, pi + 1, high);\n"
					+ "    }\n"
					+ "}\n"
					+ "public static int partition(int[] arr, int low, int high) {\n"
					+ "    int pivot = arr[high];\n"
					+ "    int i = (low - 1);\n"
					+ "    for (int j = low; j < high; j++) {\n"
					+ "        if (arr[j] <= pivot) {\n"
					+ "            i++;\n"
					+ "            int temp = arr[i];\n"
					+ "            arr[i] = arr[j];\r\n"
					+ "            arr[j] = temp;\n"
					+ "    }\n"
					+ "    int temp = arr[i + 1];\n"
					+ "    arr[i + 1] = arr[high];\n"
					+ "    arr[high] = temp;\n"
					+ "    return i + 1;\n"
					+ "}\n";
				ThuatToan(title, thuattoan, wedght, height, size);
			}
		}else if(button.equals("Start")) {
			new Thread(() -> {
				try {
					String luachon = view.jComboBox_ThuatToan.getSelectedItem().toString();
					String text = "Đang chạy thuật toán: " + luachon;
					attitude(text);
					if(luachon.equals("BubbleSort")) {
						this.model.BubbleSort();
						Thread.sleep(29800);
						String text_end = "Kết thúc thuật toán!\nMảng sau khi sắp xếp:\n";
						for(int i = 0; i < this.model.getArray().length; i++) {
							text_end += this.model.getArray()[i] + "  ";
						}
						attitude(text_end);
					}else if(luachon.equals("SelectionSort")) {
						this.model.SelectionSort();
						Thread.sleep(12000);
						String text_end = "Kết thúc thuật toán!\nMảng sau khi sắp xếp:\n";
						for(int i = 0; i < this.model.getArray().length; i++) {
							text_end += this.model.getArray()[i] + "  ";
						}
						attitude(text_end);
					}else if(luachon.equals("InsertionSort")) {
						this.model.InsertionSort();
						Thread.sleep(30800);
						String text_end = "Kết thúc thuật toán!\nMảng sau khi sắp xếp:\n";
						for(int i = 0; i < this.model.getArray().length; i++) {
							text_end += this.model.getArray()[i] + "  ";
						}
						attitude(text_end);
					}else if(luachon.equals("MergeSort")) {
						this.model.MergeSort(0, this.model.getArray().length - 1);
						Thread.sleep(27000);
						String text_end = "Kết thúc thuật toán!\nMảng sau khi sắp xếp:\n";
						for(int i = 0; i < this.model.getArray().length; i++) {
							text_end += this.view.model.getArray()[i] + "  ";
						}
						attitude(text_end);
					}else if(luachon.equals("QuickSort")) {
						this.model.QuickSort(0, this.view.model.getArray().length - 1);
						Thread.sleep(12000);
						String text_end = "Kết thúc thuật toán!\nMảng sau khi sắp xếp:\n";
						for(int i = 0; i < this.view.model.getArray().length; i++) {
							text_end += this.view.model.getArray()[i] + "  ";
						}
						attitude(text_end);
					}
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}).start();
		}
	}
	public void attitude(String text) {
		jFrame_Attitude.setTitle("Attitude");
		jFrame_Attitude.setSize(460, 200);
		jFrame_Attitude.setLocation(5, 100);
		jFrame_Attitude.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		String textnew = "";
		if(jTextArea_Attitude.getText() != null) {
			textnew = jTextArea_Attitude.getText() + "\n" + text;
		}else {
			textnew = text;
		}
		jTextArea_Attitude.setText(textnew);
		jTextArea_Attitude.setFocusable(false);
		jTextArea_Attitude.setEditable(false);
		jTextArea_Attitude.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		jFrame_Attitude.add(jTextArea_Attitude);
		jFrame_Attitude.setVisible(true);
		
	}
	public void ThuatToan(String title, String thuattoan, int widght, int height, int size) {
		jframe_windown.setTitle(title);
		jframe_windown.setSize(widght, height);
		jframe_windown.setLocation(1150, 100);
		jframe_windown.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jTextArea.setText(thuattoan);
		jTextArea.setFocusable(false);
		jTextArea.setEditable(false);
		jTextArea.setFont(new Font("Times New Roman", Font.PLAIN , size));
		jframe_windown.add(jTextArea);
		jframe_windown.setVisible(true);
	}
	
}
