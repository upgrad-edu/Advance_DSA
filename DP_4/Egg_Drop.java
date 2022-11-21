class Egg_Drop {
 
    static int max(int a, int b)
    {
        if (a>b) 
            return a;
        else
            return b;
    }
 
    static int eggDrop(int eggs, int floor)
    {
        
        int eggFloor[][] = new int[eggs + 1][floor + 1];
        int res;
        int i, j, x;
 
        for (i = 1; i <= eggs; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }
 
        for (j = 1; j <= floor; j++)
            eggFloor[1][j] = j;
 
        for (i = 2; i <= eggs; i++) {
            for (j = 2; j <= floor; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;
                for (x = 1; x <= j; x++) {
                    res = 1 + max(
                                  eggFloor[i - 1][x - 1],
                                  eggFloor[i][j - x]);
                    if (res < eggFloor[i][j])
                        eggFloor[i][j] = res;
                }
            }
        }
 
        return eggFloor[eggs][floor];
    }
 
    public static void main(String args[])
    {
        int eggs = 4, floor = 12;
        System.out.println("Minimum number of trials in worst"
                           + " case with "
                           + eggs + "  eggs and "
                           + floor + " floors is " + eggDrop(eggs, floor));
    }
}