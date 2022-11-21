class Pair
{
    private int count;
    private int index;
 
    Pair(int count, int index)
    {
        this.count = count;
        this.index = index;
    }
 
    Pair() {}
 
    public int getCount() {
        return count;
    }
 
    public int getIndex() {
        return index;
    }
 
    public void setCount(int count) {
        this.count = count;
    }
 
    public void setIndex(int index) {
        this.index = index;
    }
}
 
class K_non_repeating
{
    public static void findFirstKNonRepeating(String str, int k)
    {
        Map<Character, Pair> map = new HashMap<>();
 
        for (int i = 0; i < str.length(); i++)
        {
            Pair pair = map.getOrDefault(str.charAt(i), new Pair());
            pair.setCount(pair.getCount() + 1);
            pair.setIndex(i);
 
            map.put(str.charAt(i), pair);
        }
 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
 
        for (var value: map.values())
        {
            int count = value.getCount();
            int index = value.getIndex();
 
            if (count == 1) {
                pq.add(index);
            }
        }
 
        while (k-- > 0 && !pq.isEmpty())
        {
            System.out.print(str.charAt(pq.poll()) + " ");
        }
    }

}