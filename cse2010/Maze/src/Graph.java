/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 6
 */

import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;



public class Graph {


    protected int V; // number of vertices
    protected int E; // number of edges
    protected ArrayList<Integer>[] adj; // adjacency list representation

    @SuppressWarnings("unchecked")
    public Graph (int V) {
        // constructor
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }
    public int V () {
        return V;
    }
    public int E () {
        return E;
    }
    // Perform Bread-First search and return a graph representing it.
    public final Graph bfs (final int s) {
        final boolean[] color = new boolean[adj.length];
        final Graph x = new Graph(V);
        final Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        color[s] = true;
        while (!q.isEmpty()) {
            final int u = q.poll();
            for (int i : adj[u]) {
                if (!color[i]) {
                    color[i] = true;
                    q.add(i);
                    x.addEdge(u, i);
                }
            }
        }
        return x;
    }
    // Perform Depth-First search and return a graph representing it.
    public final Graph dfs(final int s){
    	final boolean[] color = new boolean[adj.length];
        final Graph x = new Graph(V);
        final Stack<Integer> st = new Stack<Integer>();
        st.push(s);
        color[s] = true;
        final int[] rex = new int[adj.length];
        while (!st.isEmpty()) {
            final int u = st.pop();
            if (rex[u] != u) {
            	x.addEdge(u, rex[u]);
            }
            for (int i : adj[u]) {
                if (!color[i]) {
                    color[i] = true;
                    st.push(i);
                    rex[i] = u;
                } else if (st.contains(i)) {
                	rex[i] = u;
                }
            }
            
        }
        return x;
    }
    public final void addEdge (final int v, final int w) {
        // add edge between vertex v and vertex w
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public final ArrayList<Integer> adj (final int v) {
        return adj[v];
    }

    @Override
    public final String toString () {
        final StringBuilder s = new StringBuilder();
        final String NEWLINE = System.getProperty("line.separator");
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
            }
        return s.toString();
    }
/**Override equals methods for graphs: compare number of edges,
 * vertices and the
 * * adjacency lists correspondence. Nothing to implement here
 * ( will be used for grading) * */

    @Override
    public final boolean equals (final Object other) {
        if (!(other instanceof Graph)) {
            return false;
        }

        final Graph that = (Graph) other;

        boolean isAdjSame = true;
// iterate over adjacency list to check if they are the same
        try {
            for (int i = 0; i < Math.max(this.adj.length, that.adj.length); i++) {
                // sort so that order doesn’t matter
                Collections.sort(this.adj[i]);
                Collections.sort(that.adj[i]);
                for (int j = 0; j < Math.max(this.adj[i].size(), that.adj[i].size()); j++) {
                    if
                        (this.adj[i].get(j) != that.adj[i].get(j)) {
                            isAdjSame = false; // once at least one is found there is no need to continue
                            break;
                    }
                } if (!isAdjSame) break;
            }


        } catch (final ArrayIndexOutOfBoundsException e) {
            isAdjSame = false;
        }
        // if graphs are the same all should match
        return this.V == (that.V) && this.E == (that.E) && isAdjSame;
    }
}
