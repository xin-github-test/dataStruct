package date_structure.digui;

public class Queen8 {
    //定义一个Max说明有多少个皇后
    public int Max = 8;
    public int Sum = 0;
    //定义一个数组，索引表示行，元素值代表列
    int [] arr = new int[Max];
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.Sum);
    }

    //放置第n个皇后，感觉可能只找了一个答案，但是每个check里面都有一个for循环，只要没有结束，就会一直递归下去，直到return，就返回上一层的for，
      //直到所有的for都执行完毕
    public void check(int n){
        if(n == Max){
            //如果进来说明之前8个皇后都放好了，直接打印结束
            printArr(arr);
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < Max; i++) {
            arr[n] = i;
            if(judge(n)){
                check(n+1); //进入后说明不冲突，继续放下一个
            }
            //冲突的话就会返回到for进行移位，将位置后移一个
        }
    }
    //n表示第n个皇后
    public boolean judge(int n){
        //当前皇后和之前的皇后进行判断，看位置是否合法
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }

    public void printArr(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        Sum++;
    }

}
