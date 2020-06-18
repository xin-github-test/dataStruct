package date_structure.sort;

public class SelectSort {
   //80000个数5.7秒
    public static void main(String[] args) {
     /*int[] arr = new int[]{1,4,7,0,3,1,7,5};
     select(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }*/
          int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*80000);
        }

        long start = System.currentTimeMillis();
        select(arr);
        long end = System.currentTimeMillis();

        System.out.println("消耗的时间为："+(end - start)+"毫秒！");

    }



    public static void select(int[] arr){
        int tem;
        for (int i = 0; i < arr.length - 1; i++) {

                int index = i;
                int min = arr[i];
            for (int j = i+1; j < arr.length ; j++) {

                if(arr[j] < min){
                     index = j;
                     min = arr[j];
                }
            }
             if(index != i){
                 arr[index] = arr[i];
                 arr[i] = min;
             }
        }
    }
}
