class Solution {
    int answer;
    int sum;
    public int solution(int[] nums) {
        
        boolean[] visited = new boolean[nums.length];

       if(answer>0)
        answer=0;
       
        combination(nums, visited,0,3);
        
        return answer;
    }
    public void combination(int[] nums, boolean[] visited, int depth,int out){
        
        if(out == 0){
            sum = 0;
             for(int i = 0; i < visited.length;i++){
                if(visited[i]==true)
                    sum+= nums[i];
             }
            for(int i = 2; i*i <=sum; i++){
                if(sum % i == 0)
                    return;
                }
                    answer++;
                    return ;
            }    
        if(depth == visited.length){
            return;
        }
        
                visited[depth]=true;
                combination(nums,visited,depth+1,out-1);
                visited[depth]=false;
                combination(nums,visited,depth+1,out);
            }
        }