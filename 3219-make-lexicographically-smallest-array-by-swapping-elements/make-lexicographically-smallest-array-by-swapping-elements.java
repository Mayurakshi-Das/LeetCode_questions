class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        // Make grps then reassign 
        int n = nums.length; 
        int arr[][] = new int[n][2]; 
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i]; 
            arr[i][1] = i; 
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0])); 

        // Now this is sorted our arr
        List<Integer> idxGrp = new ArrayList<>(); 
        int left = 0; 
        idxGrp.add(arr[0][1]); 
        for(int right = 1; right < n; right++) {
            if(arr[right][0] - arr[right-1][0] <= limit) {
                // part of a grp 
                idxGrp.add(arr[right][1]); 
            } else {
                // Now new grp forms 
                Collections.sort(idxGrp); // sort the indexes 

                // Now in these sorted indexes I have to put the pairs 
                for(int k = 0; k < idxGrp.size(); k++) {
                    nums[idxGrp.get(k)] = arr[left++][0]; 
                }
                // start a new grp 
                idxGrp.clear(); 
                idxGrp.add(arr[right][1]); 
            }
        }

        // last grp 
        Collections.sort(idxGrp); // sort the indexes 

        // Now in these sorted indexes I have to put the pairs 
        for(int k = 0; k < idxGrp.size(); k++) {
            nums[idxGrp.get(k)] = arr[left++][0]; 
        }

        return nums; 
    }
    public int[] lexicographicallySmallestArray1(int[] nums, int limit) {
        // copy adn sort and from grps. this we can do easily. then if any elements belongs to any grp, pick smallest out of it, i.e, available. assign eash grp a unique id. and so on... 
        int arr[] = nums.clone(); 
        int n = nums.length; 
        Arrays.sort(arr); 
        int idx = 1; 
        HashMap<Integer, Deque<Integer>> grp = new HashMap<>(); 
        HashMap<Integer, Integer> grpId = new HashMap<>(); 
        grp.put(idx, new ArrayDeque<>()); 
        grp.get(idx).addLast(arr[0]); 
        grpId.put(arr[0], idx); 
        for(int i = 1; i < n; i++) {
            if(arr[i] - arr[i - 1] <= limit) {
                grp.get(idx).addLast(arr[i]); 
            } else {
                // create a new grp 
                idx++; 
                grp.put(idx, new ArrayDeque<>()); 
                grp.get(idx).addLast(arr[i]); 
            }

            grpId.putIfAbsent(arr[i], idx); 
        }

        // Now of the grp I always have to find the minimum available 
        for(int i = 0; i < n; i++) {
            int id = grpId.get(nums[i]); 
            // Now with this grp find the smallest 
            nums[i] = grp.get(id).pollFirst(); 
        }
        return nums; 
    }
}