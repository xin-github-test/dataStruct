package date_structure.digui;

/**
 *
 * 迷宫的路径问题和取决的策略有关，然后将所有的路径都走一遍，然后从中找出最短路径
 */
public class MIGong {
    public static void main(String[] args) {
        int [][] MG = new int[8][7];

        //用1代表墙，上下全部置为1 左右置为1
        for (int i = 0; i < 7; i++) {
            MG[0][i] = 1;
            MG[7][i] = 1;
            MG[i+1][0] = 1;
            MG[i+1][6] = 1;
        }
            MG[3][1] = 1;
            MG[3][2] = 1;
        setWay(MG,1,1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(MG[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 0表示该点没有走过，1表示为墙，2表示通路可以走，3表示该点已经走过，不通
     * 走的时候需要先确定一个策略，比如先走下，再右，再上，再左，走不通就继续回溯
     * @param map  地图
     * @param i    开始的地址的横坐标
     * @param j    来时的地址的纵坐标
     * @return     到达map[6][5]的位置就返回true
     */
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){
                map[i][j] = 2;
                if(setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if(setWay(map,i,j-1)){
                    return true;
                }else{
                    map[i][j] = 3;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
