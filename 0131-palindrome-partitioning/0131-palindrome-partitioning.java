import java.util.ArrayList;
import java.util.List;

class Solution {
   
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if(s.equals("")){
            res.add(new ArrayList<>());
            return res;
        }
        for(int i = 0; i < s.length(); i++){
            if(isPalin(i+1,s)){
              
            for(List<String> list : partition(s.substring(i+1))){
                list.add(0,s.substring(0,i+1));
                res.add(list);
            }
            }
        }
        return res;
    }

    private boolean isPalin(int index, String s){
        for(int i = 0; i < index/2; i++){
            if(s.charAt(i) != s.charAt(index-i-1)){
                return false;
            }
        }
        return true;
        }

    }
