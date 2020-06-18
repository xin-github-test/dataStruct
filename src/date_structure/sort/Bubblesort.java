package date_structure.sort;

/**
 * 冒泡排序
 */
public class Bubblesort {
  //80000个数20多秒
    public static void main(String[] args) {
       int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
             arr[i] = (int) (Math.random()*80000);
        }
        long start = System.currentTimeMillis();
        Bubblesort.Bubble(arr);
        long end = System.currentTimeMillis();
        System.out.println("花费了"+(end - start)+"毫秒");

    }


    public static void Bubble(int arr[]){
        int len = arr.length;
        boolean flag = false;
        for (int i = 0; i <len - 1; i++) {
            for (int j = 0; j < len - i -1 ; j++) {
                  if(arr[j] > arr[j+1]){
                      flag = true;
                      int tem;
                      tem = arr[j];
                      arr[j] = arr[j+1];
                      arr[j+1] = tem;
                  }

            }
            if(!flag){
                break;
            }else {
                flag = false;
            }
        }
    }



}
