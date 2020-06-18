package date_structure.select;

import java.util.Arrays;

//斐波那契查找算法：前提数组是有序的
//斐波那契数列原理：就是改变了mid的取值方式和前面的一样
public class FibonacciSelect {
    static int maxsize = 20;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(fibonacci(arr, 4));
    }
   //斐波那契查找算法的实现
    //公式：mid = F(k-1)-1;
    public static int fibonacci(int arr[], int value){
         int low = 0;
         int high = arr.length-1;
         int k = 0; //存放斐波那契的下标
         int mid = 0;//存放mid的值
         int[] F = FI();
        while (high > F[k] - 1) {
             k++;
        }
       //获得F(k)的值，但是F(k)的值可能比数组的长度要大，因此需要构造一个新的数组，将其指向arr[]
        int[] tem = Arrays.copyOf(arr,F[k]); //如果F(K)的长度比arr的长度大的话，多余的会用0填充

        //但是实际上我们需要将后面的数字都填充arr[high],所以进行下一步的操作
        for (int i = high + 1; i < tem.length; i++) {
               tem[i] = arr[high];
        }
        //查找我们需要的数字
        while(low <= high){
             mid = low + F[k - 1] - 1;
             if (value < tem[mid]) {//继续向左查找
                  high = mid - 1;
                  k--;
              }else if( value > tem[mid]){//向右查找
                 low = mid +1;

                 k -= 2;
             }else {
                 if(mid <= high){
                     return mid;
                 }else {
                     return high;
                 }

             }
        }

         return 0;
    }

    //得到一个斐波那契数列,非递归的方法得到一个斐波那契数列
    public static int[] FI(){
       int[] fi =new int[maxsize];
       fi[0] = 1;
       fi[1] = 1;
        for (int j = 2; j < maxsize; j++) {
            fi[j] = fi[j-1] + fi [j-2];
        }
        return fi;
     }

}
