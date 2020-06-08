class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        for(String s:equations){
            if(s.charAt(1)=='='){
                union(parent, s.charAt(0)-'a', s.charAt(3)-'a');
            }
        }
        for(String s:equations){
            if(s.charAt(1)=='!'){
                int p1 = find(parent, s.charAt(0)-'a');
                int p2 = find(parent, s.charAt(3)-'a');
                if(p1==p2){
                    return false;
                }
            }
        }
        return true;

    }
    public void union(int[]parent,int index1,int index2){
        parent[find(parent, index1)] = find(parent, index2);
    }
    public int find(int[] parent,int index){
        while(parent[index]!=index){
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
}