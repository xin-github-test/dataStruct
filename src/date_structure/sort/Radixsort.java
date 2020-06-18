package date_structure.sort;


//基数排序 123毫秒 ，比快速排序都更快，而且是稳定的排序，使用的是空间换时间的方式，所以占内存很大，并且如果数据中右负数的话，就不能用这个方法了，需要变化一下

public class Radixsort {
    public static void main(String[] args) {
        int[] arr = new int[80000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();
        Radix(arr );
        long end = System.currentTimeMillis();

        System.out.println("消耗的时间为：" + (end - start) + "毫秒！");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void Radix(int [] arr) {

        //找到数组中的最大的一个数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        //求出最大位数的位数
        int maxlen = (max + "").length();
        //二维数组白哦是包含10个一维数组
        //使用的是空间换时间
        int[][] bucket = new int[10][arr.length];
        //为了定义每个桶中到底存放了多少个数据，需要定义一个一维数组来记录
        int[] bucketEle = new int[10];

        for (int k = 0; k < maxlen; k++) {

             int tem = (int) Math.pow(10,k);
            for (int i = 0; i < arr.length; i++) {
                int digitalEle = arr[i] / tem % 10;
                bucket[digitalEle][bucketEle[digitalEle]] = arr[i];
                bucketEle[digitalEle]++;
            }
            int index = 0;
            for (int i = 0; i < bucketEle.length; i++) {
                if (bucketEle[i] != 0) {
                    for (int j = 0; j < bucketEle[i]; j++) {
                        arr[index++] = bucket[i][j];

                    }
                }
                //注意：每次排完一次后需要将bucketEle里面的元素清空
                bucketEle[i] = 0;
            }


        }
    }
}
