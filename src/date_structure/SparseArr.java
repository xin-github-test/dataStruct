package date_structure;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 稀疏矩阵
 */
public class SparseArr {

    //创建一个二维数组  0 :表示没有棋子  1：表示黑子  2表示白子
     private static int[][] chessArr = new int[11][11];

    public static void main(String[] args) {

          chessArr[1][2] = 1;
          chessArr[2][3] = 2;
          //输出
        for (int i = 0; i <chessArr.length ; i++) {
            for (int j = 0; j <chessArr[0].length ; j++) {
                System.out.print(chessArr[i][j]);
            }
            System.out.println();
        }
        //遍历，获得非0元素的个数，判断是否可以用稀疏数组
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        //创建稀疏数组

        int[][] parseArr = new int[sum+1][3];
        //第一行的前俩列表示数组的行列数,第三列代表非0元素的个数
        parseArr[0][0] = chessArr.length;
        parseArr[0][1] = chessArr[0].length;
        parseArr[0][2] = sum;

        //遍历数组将非0的值放入稀疏数组中
        int num = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j] != 0){
                    parseArr[num][0] = i;
                    parseArr[num][1] = j;
                    parseArr[num][2] = chessArr[i][j];
                    num++;
                }
            }
        }

        //输出稀疏数组
        for (int i = 0; i < parseArr.length; i++) {
            System.out.println(parseArr[i][0]+"  "+parseArr[i][1]+"  "+parseArr[i][2]);
        }
        //将稀疏数组恢复成原数组
        int[][] ck = new int[parseArr[0][0]][parseArr[0][1]];
        for (int i = 1; i < parseArr.length; i++) {
            ck[parseArr[i][0]][parseArr[i][1]] = parseArr[i][2];
        }
        for (int[] row :
                ck) {
            for (int date :
                    row) {
                System.out.print(date+"  ");
            }
            System.out.println();
        }
        //写入文件
        writeFile("d:","date",parseArr);
        //输出文件
        int[][] res = readFile("date");
        for (int[] row :
                res) {
            for (int date
                    :row
                 ) {
                System.out.print(date+"   ");
            }
            System.out.println();
        }



    }
    public static void writeFile(String path,String filename,int [][] content){

        String filepath = path + File.separator + filename+".txt";
        File file = new File(filepath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            //读取原文的内容
            try {
                FileOutputStream out = new FileOutputStream(file);

                StringBuffer sb = new StringBuffer();


                sb.append("row   col   value"+System.lineSeparator());
                for (int[] row :
                        content) {
                    for (int date :
                            row) {

                        sb.append(date+"   ");
                    }
                    sb.append(System.lineSeparator());
                }
                out.write(sb.toString().getBytes());

                  out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }



    }
    public static int[][] readFile(String filename)
    {
        String filepath = "d:"+File.separator+filename+".txt";
        try {
            FileInputStream input = new FileInputStream(filepath);
            InputStreamReader read = new InputStreamReader(input);
            BufferedReader br = new BufferedReader(read);
             String tem= "";
            List<int[]> list = new ArrayList<>();
             StringBuffer sb = new StringBuffer();
            for (int i = 0;(tem=br.readLine())!=null; i++) {
                if(i != 0)
                {
                    int[] s = Arrays.stream(tem.split("   ")).mapToInt(Integer::parseInt).toArray();

                    list.add(s);
                }
            }
            int [][] res = new int[list.size()][3];
            int num = 0;
            for (int[] s :
                    list) {
                for (int i = 0; i < s.length; i++) {

                   res[num][i] = s[i];
                }

               num++;
            }
            br.close();
            read.close();
            input.close();

            return res;

        } catch (Exception e) {
            e.printStackTrace();
        }

         return null;
    }



}
