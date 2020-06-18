package date_structure.Queue;

public class ArrQueue {
    public static void main(String[] args) {

    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;  //指向队列头的前一个位置
        rear = -1;

    }
    public boolean isFull(){
        if(this.rear == this.maxSize - 1){
            System.out.println("队列已满！");
            return true;
        }
        return false;
    }
    public boolean isNull(){
         if(this.front == this.rear)
         {
             System.out.println("队列为空！");
             return true;
         }
         return false;
    }
    public void addQueue(int num){
        if(!isFull()) {
            arr[++rear] = num;
        }
    }
    public int getQueue(){
        if(!isNull()){
            return arr[++front];
        }
        return 0;
    }
    public void showQueue(){
        if(!isNull()){
            for (int i = front + 1; i < rear + 1 ; i++) {
                System.out.println(arr[i]);
            }
        }
    }
    public int headQueue(){
        if(!isNull()){
        int i = front + 1;
        return arr[i];}
        return 0;
    }
    public int tailQueue(){
        if(isNull()){
            int i =rear;
        return arr[i];}
        return 0;
    }


}

class LoopArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public LoopArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;  //指向队列头的前一个位置
        rear = 0;

    }
    public boolean isFull(){
        if((this.rear+1)%maxSize == this.front){
            System.out.println("队列已满！");
            return true;
        }
        return false;
    }
    public boolean isNull(){
         if(this.front == this.rear)
         {
             System.out.println("队列为空！");
             return true;
         }
         return false;
    }
    public void addQueue(int num){
        if(!isFull()) {
            arr[rear] = num;
            rear = (rear+1)%maxSize;
        }
    }
    public int getQueue(){
        if(!isNull()){
            int  i = arr[front];
            front = (front+1)%maxSize;
            return i;
        }
        return 0;
    }
    public void showQueue(){
        if(!isNull()){
            for (int i = front ; i <front+count() ; i++) {
                System.out.println(arr[i%maxSize]);
            }
        }
    }
    public int headQueue(){
        if(!isNull()){

        return arr[front];}
        return 0;
    }
    public int tailQueue(){
        if(isNull()){
            int i =rear-1;
        return arr[i];}
        return 0;
    }
    public int count(){
        return (rear-front+maxSize)%maxSize;
    }


}