class Job {
   
    char id;
    int deadline, profit;
 
    public Job() {}
 
    public Job(char id, int deadline, int profit)
    {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
 
    void printJobScheduling(ArrayList<Job> arr, int t)
    {
        int n = arr.size();
       
        Collections.sort(arr, (a, b) -> b.profit - a.profit);
 
        boolean result[] = new boolean[t];
 
        char job[] = new char[t];
 
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(t - 1, arr.get(i).deadline - 1); j >= 0; j--) {
                if (result[j] == false) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }
 
        for (char jb : job)
            System.out.print(jb + " ");
        System.out.println();
    }
 
}