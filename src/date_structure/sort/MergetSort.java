package date_structure.sort;

public class MergetSort {
    //归并排序的时间是31毫秒0
    public static void main(String [] args){
        int[] arr = new int[80000];
        int[] tem = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();
        Mergetsort(arr,0,arr.length-1,tem);
        long end = System.currentTimeMillis();

        System.out.println("消耗的时间为：" + (end - start) + "毫秒！");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    //合并的方法：分治的思想，先分后合
    public static void Mergetsort(int [] arr, int left, int right,int [] tem){
        if(left < right){
            int mid = (left + right)/2;
            //向左递归分解
            Mergetsort(arr,left,mid,tem);
            //向右递归分解
            Mergetsort(arr, mid + 1, right, tem);
            Merget(arr,left,right,mid,tem);
        }
    }

    /**
     *
     * @param arr :排序的原始数组
     * @param left：左边有序序列的初始索引
     * @param right：右边的索引
     * @param mid：中间索引
     * @param tem：临时的数组，用于存放排序好的数组
     */
    public static void Merget(int [] arr, int left, int right, int mid, int [] tem){
     int i = left;//左边有序序列的初始索引
       int j = mid + 1;//右边有序序列的初始索引
       int t = 0; //临时数组的初始索引

        //（一）把左右两边的有序的数组填充到临时的数组当中，直到俩边的有序序列有一边处理完成为止
             while (i <= mid && j <= right){
                 if(arr[i] <= arr[j]){
                     tem[t] = arr[i];
                     t++;
                     i++;
                 }else{
                     tem[t] = arr[j];
                     t++;
                     j++;
                 }
             }

        //（二）把有剩余的数组的后面的数据全部以此拷贝到临时的数组当中
           while(i <= mid) {//左边的数组有剩余

            tem[t] = arr[i];
            t++;
            i++;
           }
           while(j <= right ){//右边的数组有剩余
               tem[t] = arr[j];
               t++;
               j++;
           }

        //（三）将tem中的元素全部导入到arr中
         t = 0;
           int teml = left;

           while(teml <= right){
               arr[teml] = tem[t];
               t++;
               teml++;
           }

    }
}
