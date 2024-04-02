import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return Collections.emptyList();
        String[] phoneLetters = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        backtracking(digits,phoneLetters,res,"");
        return res;
    }
    private void backtracking(String digits, String[] phoneLetters, List<String> res , String temp){
        if(digits.isEmpty()) res.add(temp);
        else {
            String letters = phoneLetters[digits.charAt(0)-'2'];
            for(char c : letters.toCharArray()){
                backtracking(digits.substring(1),phoneLetters,res,temp+c);
            }
        }

    }
}