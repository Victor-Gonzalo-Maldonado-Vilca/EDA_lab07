import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    int frequency;

    public TrieNode() {
        children = new HashMap<>();
        frequency = 0;
    }
}