package com;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	TrieNode root = null;
	
	static class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;
		
		public TrieNode() {
			children = new HashMap<Character, TrieNode>();
			endOfWord = false;
		}
	}
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode current = root;
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}
	
	public boolean search(String word) {
		TrieNode current = root;
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) return false;
			current = node;
		}
		return current.endOfWord;
	}
	
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for (int i=0; i<prefix.length(); i++) {
			char ch = prefix.charAt(i);
			TrieNode node = current.children.get(ch);
			if (node == null) return false;
			current = node;
		}
		return true;
	}
	
	public static void main (String args[]) {
		Trie t = new Trie();
		t.insert("Shweta");
		System.out.println(t.search("Shweta"));
		System.out.println(t.startsWith("shw"));
	}
}
