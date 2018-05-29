/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 6
 */

import java.util.LinkedList;
import java.util.Queue;

public class MazeGraph extends Graph {
    private int width;
    public MazeGraph(final boolean[][] maze) {
        // Create a graph from two-dimensional maze matrix.
        super(maze.length * maze[0].length);
        // Graph built
        width = maze[0].length;
        // We will need that int later
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (!maze[i][j]) {
                    continue;
                    // this is not a viable edge, so skip it
                } else {
                    if (i + 1 < maze.length && maze[i + 1][j]) {
                        addEdge(width * i + j, width * (i + 1) + j);
                    }
                    if (i - 1 >= 0 && maze[i - 1][j]) {
                        addEdge(width * i + j, width * (i - 1) + j);
                    }
                    if (j + 1 < maze.length && maze[i][j + 1]) {
                        addEdge(width * i + j, width * i + (j + 1));
                    }
                    if (j - 1 >= 0 && maze[i][j - 1]) {
                        addEdge(width * i + j, width * i + (j - 1));
                    }
                }
                // all directions checked, edges set, maze built
            }
        }
    }
    public static void printPath (final boolean[][] maze,
            final LinkedList<Pair<Integer, Integer>> path) {
        // Print maze where for location which is accessible print "x", but
        // for one which is not - "o"; for locations which are part of the path
        // print "*"
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (path.contains(new Pair<Integer, Integer> (i, j))) {
                    System.out.print("*");
                }
                // this is only for finding the path
                if (maze[i][j]) {
                    System.out.print("x");
                } else if (!maze[i][j]) {
                    System.out.print("o");
                }
            }
            System.out.println();
        }
    }
    public final LinkedList<Pair<Integer, Integer>> findPath (final Pair<Integer, Integer> startingPosition,
                final Pair<Integer, Integer> targetPosition) {
        // Find a path from starting to the tartget position in a maze and
        // return it.
        final int start = width * startingPosition.getFirst() + startingPosition.getSecond();
        final int end = width * targetPosition.getFirst() + targetPosition.getSecond();
        // these two ints are for the pair, makes things easier
        final boolean[] color = new boolean[adj.length];
        // this was from bfs on Graph.java.  didn't feel like changing the name
        final int[] lv426 = new int[V];
        // the array telling us what the clear path is.  Get the reference?
        final Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = true;
        while (!q.isEmpty()) {
            final int u = q.poll();
            if (u == end) {
                break;
            }
            for (int i : adj[u]) {
                if (!color[i]) {
                    color[i] = true;
                    q.add(i);
                    lv426[i] = u;
                }
            }
        }
        // bfs used to find the clear path.  lv426 holds the path
        final LinkedList<Pair<Integer, Integer>> z = new LinkedList<Pair<Integer, Integer>>();
        // the linked list that will return the path.
        int reach = end;
        // the int that tells us how much we have to do it. Another reference to sci-fi.
        while (reach != start) {
            final int x = reach % width;
            final int y = (int) (reach / width);
            // the x and y coordinates of the graph, obviously.
            final Pair<Integer, Integer> meridian = new Pair<Integer, Integer> (y, x);
            // the coordinates converted to an acceptible form.  Yet another reference.
            z.add(meridian);
            reach = lv426[reach];
        }
        // the linked list is almost complete.
        final int x = reach % width;
        final int y = (int) (reach / width);
        final Pair<Integer, Integer> meridian = new Pair<Integer, Integer> (y, x);
        z.add(meridian);
        // had to do it again so that the start was added.
        return z;
    }
}