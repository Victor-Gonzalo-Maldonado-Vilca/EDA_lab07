import java.util.*;
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.frequency++;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.frequency > 0;
    }

    public String replaceWords(String text, String replacement) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (search(word)) {
                result.append(replacement).append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    public List<String> getTopKFrequentWords(int k) {
        // Usamos un mapa para almacenar las frecuencias de las palabras
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        collectWords(root, "", wordFrequencyMap);

        // Convertimos el mapa a una lista de entradas y ordenamos por frecuencia
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordFrequencyMap.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        // Obtenemos las primeras k palabras más frecuentes
        List<String> topKWords = new ArrayList<>();
        for (int i = 0; i < k && i < entries.size(); i++) {
            topKWords.add(entries.get(i).getKey());
        }

        return topKWords;
    }

    private void collectWords(TrieNode node, String prefix, Map<String, Integer> wordFrequencyMap) {
        if (node == null) {
            return;
        }
        if (node.frequency > 0) {
            wordFrequencyMap.put(prefix, node.frequency);
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            collectWords(entry.getValue(), prefix + entry.getKey(), wordFrequencyMap);
        }
        
    }
}