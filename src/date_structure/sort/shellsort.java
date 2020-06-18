package date_structure.sort;
//其实希尔排序只是将前面的简单插入排序的一个升级版，只是在其前提上加上了一个分组，使得其的最坏的情况得以缓解
public class shellsort {
    public static void main(String[] args) {
      /*int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
      Shell(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }*/
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }

        long start = System.currentTimeMillis();
        Shell1(arr);
        long end = System.currentTimeMillis();

        System.out.println("消耗的时间为："+(end - start)+"毫秒！");
        /*for (int i = 0; i < arr.length ;i++) {
            System.out.println(arr[i]);

        }*/
    }
 //希尔排序：将一组数据分为设定好的组数，然后将每组进行冒泡排序，将每组都都排好序 17430毫秒
    public static void Shell(int[] arr){
       int tem = 0;
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {


            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        tem = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = tem;
                    }
                }

            }
        }
    }
    //36毫秒,使用的是加强版的直接插入排序
    public static void Shell1(int [] arr){

        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }

                arr[j] = temp;
            }

        }
    }
}
