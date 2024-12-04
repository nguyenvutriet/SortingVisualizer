package model;

import java.util.Random;

import view.SortingVisualizerView;

public class SortingVisualizerModel {
	private int[] array;
	private Runnable onUpdate;
	private int index1 = -1;
	private int index2 = -1;
	public int getIndex1() {
		return index1;
	}
	public void setIndex1(int index1) {
		this.index1 = index1;
	}
	public int getIndex2() {
		return index2;
	}
	public void setIndex2(int index2) {
		this.index2 = index2;
	}
	public SortingVisualizerModel() {
		this.array = new int[12];
	}
	public void createRandom() {
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(200) + 1; 
		}	
	}
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}
	public void BubbleSort() {
		new Thread(() -> {
			try {
				for (int i = 0; i < array.length - 1; i++) {
					int noibot = 0;
					for (int j = 0; j < array.length - i - 1; j++) {
						setHighlight(noibot, j + 1);
						notifyUpdate();
	                    Thread.sleep(300);
						if (array[j] > array[j + 1]) {
							int temp = array[j];
							array[j] = array[j + 1];
							array[j + 1] = temp;
							noibot = j + 1;
							setHighlight(noibot, -1);
							notifyUpdate();
							Thread.sleep(300); 
						}else {
							noibot = j + 1;
						}
					}
				}
				for(int t = 0; t < array.length; t++) {
					setHighlight(t, -1);
					notifyUpdate();
					Thread.sleep(50);
				}
				setHighlight(-1, -1);
				notifyUpdate();
				//Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	public void SelectionSort() {
		new Thread(() -> {
			try {
				for (int i = 0; i < array.length - 1; i++) {
					int minIndex = i;
					setHighlight(i, i+1);
					notifyUpdate();
					Thread.sleep(300);
					for (int j = i + 1; j < array.length; j++) {
						if (array[j] < array[minIndex]) {
							minIndex = j;
							setHighlight(i, minIndex);
							notifyUpdate();
							Thread.sleep(300);
						}
					} 
					//Hoán đổi giá trị
					int temp = array[minIndex];
					array[minIndex] = array[i];
					array[i] = temp;
					setHighlight(minIndex, -1);
					notifyUpdate();
					Thread.sleep(300);
					
				}
				for(int t = 0; t < array.length; t++) {
					setHighlight(t, -1);
					notifyUpdate();
					Thread.sleep(50);
				}
				setHighlight(-1, -1);
				notifyUpdate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
	public void InsertionSort() {
		new Thread(() -> {
			try {
				for(int i = 1; i < array.length; ++i) {
					int key = array[i];
					int j = i - 1;
					setHighlight(i, j);
					notifyUpdate();
					Thread.sleep(300); 
					while(j >= 0) {
						if(j == i-1) {
							setHighlight(i, j);
							notifyUpdate();
							Thread.sleep(300); 
						}
						else {
							setHighlight(-1, j);
							notifyUpdate();
							Thread.sleep(300); 
						}
						if(array[j] > key) {
							array[j + 1] = array[j];
							setHighlight(-1, j+1);
							notifyUpdate();
							Thread.sleep(300); 
							j = j - 1;
						}else {
							break;
						}
					}
					array[j + 1] = key;
					setHighlight(j+1, -1);
					notifyUpdate();
					Thread.sleep(300);
				}
				for(int t = 0; t < array.length; t++) {
					setHighlight(t, -1);
					notifyUpdate();
					Thread.sleep(50);
				}
				setHighlight(-1, -1);
				notifyUpdate();
				Thread.sleep(300);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
	}
	public void MergeSort(int left, int right) {
		new Thread(() ->  {
			try {
				mergeSort(left, right);
				for(int t = 0; t < array.length; t++) {
					setHighlight(t, -1);
					notifyUpdate();
					Thread.sleep(50);
				}
				setHighlight(-1, -1);
				notifyUpdate();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private void mergeSort(int left, int right) throws InterruptedException {
		if (left < right) {
	        int middle = (left + right) / 2;

	        mergeSort(left, middle);
	        mergeSort(middle + 1, right);

	        Merge(left, middle, right);
	    }
		
	}
	public void Merge(int left, int middle, int right) throws InterruptedException {
		int n1 = middle - left + 1;
		int n2 = right - middle;
		
		int[] L =  new int[n1];
		int[] R = new int[n2];
		
		for(int i = 0; i < n1; ++i) {
			L[i] = array[left + i];
		}
		for(int j = 0; j < n2; ++j) {
			R[j] = array[middle + 1 + j];
		}
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
		    setHighlight(k, -1); 
		    notifyUpdate();
		    Thread.sleep(300);

		    if (L[i] <= R[j]) {
		        array[k] = L[i];
		        i++;
		    } else {
		        array[k] = R[j];
		        j++;
		    }
		    k++;
		    notifyUpdate(); 
		    Thread.sleep(300);
		}
		while(i < n1) {
			array[k] = L[i];
			setHighlight(k, -1);
			notifyUpdate();
			Thread.sleep(300);
			i++;
			k++;
			notifyUpdate();
			Thread.sleep(300);
			
		}
		
		while(j < n2) {
			array[k] = R[j];
			setHighlight(k, -1);
			notifyUpdate();
			Thread.sleep(300);
			j++;
			k++;
			notifyUpdate();
			Thread.sleep(300);
			
		}
	}
	public void QuickSort(int low, int high) {
		new Thread(() -> {
			try {
				quickSort(low, high);
				for(int t = 0; t < array.length; t++) {
					setHighlight(t, -1);
					notifyUpdate();
					Thread.sleep(50);
				}
				setHighlight(-1, -1);
				notifyUpdate();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}).start();
		
	}
	private void quickSort(int low, int high) throws InterruptedException {
		if(low < high) {
			
			int pi = partition(low, high);
			
			quickSort(low, pi - 1);
			quickSort(pi + 1, high);
		}
	}
	public int partition(int low, int high) throws InterruptedException {
		int pivot = array[high];
		setHighlight(high, -1);
        notifyUpdate();
        Thread.sleep(300);
		int i = (low - 1);
		for(int j = low; j < high; j++) {
			if(array[j] <= pivot) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				setHighlight(high, i);
	            notifyUpdate();
	            Thread.sleep(300);
			}
		}
		int temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		setHighlight(i + 1, -1);
	    notifyUpdate();
	    Thread.sleep(300);
	    return i + 1;
	}
	public void setOnUpdate(Runnable onUpdate) {
	    this.onUpdate = onUpdate;
	}

	private void notifyUpdate() {
	    if (onUpdate != null) {
	        onUpdate.run();
	    }
	}
	public void setHighlight(int index1, int index2) {
	    this.index1 = index1;
	    this.index2 = index2;
	    notifyUpdate(); 
	}
}
