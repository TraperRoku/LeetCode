class WordDictionary {

    TrieNode trieNode;
    class TrieNode{
        private char val;
        private boolean isWord =false;
        TrieNode[] letters ;
        TrieNode(){};
        TrieNode(char x){
            TrieNode trieNode = new TrieNode();
            this.val = x;
            letters = new TrieNode[26]; //a-z;
        }
    }

    public WordDictionary() {
        trieNode = new TrieNode();
        trieNode.letters = new TrieNode[26];
    }

    public void addWord(String word) {
        TrieNode root = trieNode;
        for(int i = 0; i < word.length();i++){
        char x = word.charAt(i);
        if(root.letters[x-'a'] == null) {
            root.letters[x-'a'] = new TrieNode(x);
        }
        root = root.letters[x-'a'];
    }
        root.isWord=true;
    }

    public boolean search(String word) {
    return searchHelper(word,trieNode);
    }

    private boolean searchHelper(String word, TrieNode root) {
    for(int i = 0; i < word.length(); i++){
        char x = word.charAt(i);
        if(x == '.'){
            for(TrieNode temp : root.letters){
                if(temp != null && searchHelper(word.substring(i+1),temp)) {
                    return true;
                }
            }
            return false;
        }
        if(root.letters[x-'a'] == null) return false;
        root = root.letters[x-'a'];
    }
    return root.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */