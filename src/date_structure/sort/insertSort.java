package date_structure.sort;

public class insertSort {
    //80000个数1.2s
    public static void main(String[] args) {
      /*int[] arr = new int[]{1,4,7,2,5,8,3,6,9};
     inert(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }*/
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*80000);
        }

        long start = System.currentTimeMillis();
        inert(arr);
        long end = System.currentTimeMillis();

        System.out.println("消耗的时间为："+(end - start)+"毫秒！");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void inert(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int indexvalue = arr[i];
            int insertindex = i - 1;

            //当inserindex不越界,且还没有找到插入的位置
            while (insertindex >= 0 && indexvalue < arr[insertindex]) {
                arr[insertindex + 1] = arr[insertindex];//将前面的数后移一位，不用担心值被覆盖，因为该值已经被放入indexvalue中了
                insertindex--;
            }
            //出来的时候说明已经找到插入的位置了，加上一个条件进行优化，如果该数不需要移动的话就不用执行
            if ((insertindex + 1) != i) {
                arr[insertindex + 1] = indexvalue;
            }
            //arr[insertindex + 1] = indexvalue;
        }

    }
}
