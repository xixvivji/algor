
import java.io.*;
import java.util.*;

public class Main {
	  private static int[] sorted;
	    private static int K;
	    private static int count = 0;
	    private static int result = -1;

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int N = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());

	        int[] arr = new int[N];
	        st = new StringTokenizer(br.readLine());
	        for (int i = 0; i < N; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }

	        sorted = new int[N];
	        mergeSort(arr, 0, arr.length - 1);
	        
	        System.out.println(result);
	    }

	    public static void mergeSort(int[] arr, int left, int right) {
	        if (left < right) {
	            int mid = (left + right) / 2;
	            mergeSort(arr, left, mid);
	            mergeSort(arr, mid + 1, right);
	            if (count < K) {
	                merge(arr, left, mid, right);
	            }
	        }
	    }

	
	    public static void merge(int[] arr, int left, int mid, int right) {
	        int l = left;
	        int r = mid + 1;
	        int idx = left;

	        while (l <= mid && r <= right) {
	            if (arr[l] <= arr[r]) {
	                sorted[idx++] = arr[l++];
	            } else {
	                sorted[idx++] = arr[r++];
	            }
	        }

	        if (l > mid) {
	            while (r <= right) {
	                sorted[idx++] = arr[r++];
	            }
	        } else {
	            while (l <= mid) {
	                sorted[idx++] = arr[l++];
	            }
	        }

	        for (int i = left; i <= right; i++) {
	            arr[i] = sorted[i];
	            count++; 
	            if (count == K) { 
	                result = arr[i]; 
	                return;
	            }
	        }
	    }
	}