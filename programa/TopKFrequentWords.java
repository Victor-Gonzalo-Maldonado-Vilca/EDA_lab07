import java.util.*;

public class TopKFrequentWords {
     public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("will");
        trie.insert("win");
        trie.insert("wish");
        trie.insert("war");
        trie.insert("war");
        trie.insert("war");
        trie.insert("war");
        trie.insert("want");
        trie.insert("warp");
        trie.insert("warp");
        trie.insert("warp");
        trie.insert("want");
        trie.insert("warp");
        trie.insert("wee");
        trie.insert("wee");
        
        System.out.println("Search 'will': " + trie.search("will")); 
        System.out.println("Search 'wee': " + trie.search("wee")); 
        System.out.println("Search 'hi': " + trie.search("hi")); 
        System.out.println("Search 'wanted': " + trie.search("wanted")); 

        String text = "hello";
        String replacedText = trie.replaceWords(text, "warp");
        System.out.println("Replaced Text: " + replacedText); // REPLACED REPLACED REPLACED hola

        List<String> topWords = trie.getTopKFrequentWords(2);
        System.out.println("Top 2 Frequent Words: " + topWords); // [hello, world]
    }
}