package date_structure.select;


/**
 * 插值查找的注意事项：对于数据量较大，关键字分布比较均匀的情况下的查找表来说，采用该方法会比较块，对于不均匀的情况下，该方法不一定比折半好
 */
//插值查找法：本质就是二分查找法，只不过在其基础上加上了对于mid的查找的限制，使得其更容易的接近需要找的值，自适应的确定mid的值
//公式: mid = low + ((value - arr(low))/(arr(high) - arr(low)))*(high - low)
//增加其查找的速度
public class  insertSelect {
    public static void main(String[] args) {
            int [] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;

        }
        System.out.println(insertSelect(arr, 0, arr.length - 1, 100));

    }
    public static int insertSelect(int []arr, int left, int right, int value){

        //后面的判断必须得要，因为当value的值很大的时候，利用上面的公式求mid的时候arr可能会越界
         if(left > right || value < arr[0] || value > arr[arr.length-1]){
             return -1;
         }
         //求出mid
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midvalue = arr[mid];
        if(value > midvalue){

            return  insertSelect(arr,mid+1,right,value);
        }else if(value < midvalue){ //向左递归
            return  insertSelect(arr,left,mid-1,value);
        }else {
            return mid;
        }
    }
}
