import java.util.ArrayList;
import java.util.List;

public class LC_211 {
    class WordDictionary {
        private WordDictionary[] sons;
        private boolean isWord;
        /** Initialize your data structure here. */
        public WordDictionary() {
            sons = new WordDictionary[26];
            for(WordDictionary son : sons) {
                son = null;
            }
            isWord = false;
        }

        public void addWord(String word) {
            int len = word.length();
            WordDictionary node = this;
            for(int i = 0; i < len; i++) {
                char cur = word.charAt(i);
                if(node.sons[cur - 'a'] == null) {
                    node.sons[cur - 'a'] = new WordDictionary();
                }
                node = node.sons[cur - 'a'];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            return search(this, word, 0);
        }

        private boolean search(WordDictionary cur, String word, int index) {
            if(index == word.length()) {
                return cur.isWord;
            }
            char c = word.charAt(index);
            if(c == '.') {
                for(WordDictionary son : cur.sons) {
                    if(son != null && search(son, word, index + 1)) {
                        return true;
                    }
                }
                return false;
            }else {
                WordDictionary temp = cur.sons[c-'a'];
                return temp != null && search(temp, word, index + 1);
            }
        }
    }
}