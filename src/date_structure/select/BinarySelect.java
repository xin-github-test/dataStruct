package date_structure.select;

import java.util.ArrayList;
import java.util.List;

//二分查找,使用的前提是数组本身就是排好序的，如果不是排好序的话会出错
public class BinarySelect {
    public static void main(String[] args) {
        int [] arr ={1,1,1,1,1,89};

        System.out.println(binarySort1(arr, 0, arr.length, 1));
    }
    public static int binarySelect(int [] arr,int left, int right, int value){

        if (left > right){ //当满足这个条件的时候，说明递归已经结束了，直接退出就行了
            return -1;
        }

         int mid = (left + right)/2;
         int midvalue = arr[mid];

         if (value > midvalue){ //向右递归
             return  binarySelect(arr,mid+1,right,value);
         }else if(value < midvalue){ //向左递归
             return  binarySelect(arr,left,mid-1,value);
         }else { //直接找到了，然后直接返回就行了
             return mid ;

         }

    }
    //如果一个数组中有多个相同的值的话，如果还是使用上面的方法，则只会输出一个下标，如果需要找到所有的元素就需要进行改进
    //思路：在找到元素的时候不要直接返回，此时应该继续向左和向右进行递归，将所有的元素都找到
    public static List<Integer> binarySort1(int [] arr,int left, int right, int value){
        if (left > right){ //当满足这个条件的时候，说明递归已经结束了，直接退出就行了
            return null;
        }

        int mid = (left + right)/2;
        int midvalue = arr[mid];

        if (value > midvalue){ //向右递归
            return  binarySort1(arr,mid+1,right,value);
        }else if(value < midvalue){ //向左递归
            return  binarySort1(arr,left,mid-1,value);
        }else {
            List<Integer> list = new ArrayList<>();//创建一个集合用于存放多个值
             //向左扫描，将相等的值放入到集合中去
            int tem = mid - 1;
            while(true){
                if(tem < 0 || arr[tem] != value) //因为数据是有序的，所以相等的数据都在找到的数据的左右相邻的位置
                {
                    break;
                }
                list.add(tem);
                tem -= 1; //tem左移

            }

            //和上面的原理一样，只不过这里是向右扫描，看右边是否右相同的值，并且将其也放入集合中去
              tem = mid + 1;
            while(true){
                if ( tem > arr.length - 1 || arr[tem] != value){
                    break;
                }
                list.add(tem);
                tem += 1;
            }
              list.add(mid);  //最后将原有的数据放入集合中
           return list;
            //return mid ;

        }

    }
}
