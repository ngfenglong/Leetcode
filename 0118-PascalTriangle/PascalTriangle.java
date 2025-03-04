import java.util.*;

class PascalTriangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            // 1,2,4,
            
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            
            for(int i = 1; i <= numRows; i++){
                List<Integer> list = new ArrayList<>();
                for(int j = 0; j < i; j++){
                    if(j == 0 || j == i - 1){
                        list.add(1);
                    }
                    else{
                        list.add(ans.get(i - 2).get(j-1) + ans.get(i - 2).get(j));
                    }
                }
                ans.add(list);
            }
            return ans;
        }
    }
}
