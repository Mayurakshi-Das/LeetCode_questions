class Solution {
    public int[][] merge(int[][] intervals) {
        //sorting based on start timing
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1; i< intervals.length; i++){
            //overlapping condition
            if(intervals[i][0] <= prev[1]){
                //merge intervals
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
            else{
                //no overlapping
                merged.add(prev);
                prev = intervals[i];
            }
        }
        //add last interval
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}