package date_structure.select;
//线性查找  普通的查找
public class SeqSelect {
    public static void main(String[] args) {
        int [] arr ={1,9,11,-1,34,89};

    }

    public static int seqSelect(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == value){
                System.out.println("查到了！");
                return i;
            }
        }
        System.out.println("未查到该数！");
      return 0;
    }
}

