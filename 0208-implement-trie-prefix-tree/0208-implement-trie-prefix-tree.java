class Trie {
TireNode tireNode;

    public Trie() {
    tireNode = new TireNode();
    tireNode.val = ' ';
    }

    public void insert(String word) {
     TireNode root = tireNode;
     for(int i = 0; i < word.length(); i++){
         char x = word.charAt(i);

         if(root.letters[x - 'a'] == null) {
             root.letters[x - 'a'] = new TireNode(x);
         }
         root = root.letters[x-'a'];
     }

     root.isWord = true;
    }

    public boolean search(String word) {
        TireNode root = tireNode;

        for(int i = 0; i < word.length(); i++){
            char x = word.charAt(i);
            if(root.letters[x - 'a'] == null) return false;
            root = root.letters[x - 'a'];
        }
        if(root.isWord == true) return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
    TireNode root = tireNode;

    for(int i = 0; i < prefix.length(); i++ ){
        char x = prefix.charAt(i);

        if(root.letters[x - 'a'] == null )return false;
        root = root.letters[x - 'a'];
    }
    return true;
    }
}

class TireNode{
    char val;
    boolean isWord = false;
    TireNode(){};

    TireNode[] letters = new TireNode[26]; // a-z

    TireNode(char x){
        TireNode tireNode = new TireNode();
        tireNode.val = x;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */