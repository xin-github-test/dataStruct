package date_structure.sort;
//120毫秒
public class quickSort {
    public static void main(String [] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        quick(arr,0,arr.length-1);
        long end = System.currentTimeMillis();

        System.out.println("消耗的时间为：" + (end - start) + "毫秒！");
        /*for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }*/
    }

    public static void quick(int[] arr,int left, int right){
        int l = left;
        int r = right;
        int tem = 0;
        int pivot = arr[(left + right)/2];
        while(l < r){
            while(arr[l] < pivot){
                l++;
            }
            while(arr[r] > pivot){
                r--;
            }
            if(l >= r){
                break;
            }
            tem = arr[l];
            arr[l] = arr[r];
            arr[r] = tem;
            if(arr[l] == pivot){
                r--;
            }
           if(arr[r] == pivot){
                l++;
            }

        }
        if(l == r){
               l++;
               r--;
           }
           if (left < r){
               quick(arr,left,r);
           }
           if (right > l){
               quick(arr,l,right);
           }

    }
}
