/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 7
 */

public class BellmanFord {
	
	private Graph graph;
	private Integer source;
	private double[] dist;
	private Integer[] predecessor;
	
	/**
	 * Constructor which initializes graph, source, dist and predecessor
	 * arrays
	 * @param g Graph to use
	 * @param source vertex for which calculations have to be performed
	 */
	public BellmanFord(Graph g, int source){
		graph=g;
		this.dist=new double[g.V()];
		this.predecessor = new Integer[g.V()];
		
		for (int i = 0; i < dist.length; i++) {
			this.predecessor[i] = null;
		}
		
		this.source = source;
	}
	
	public double getShortestPath(int to){
		return dist[to];
	}
	
	
	/**
	 * Perform Bellman-Form algorithm.
	 */
	public void findShortestPath(){
		for (int i = 0; i < graph.V(); i++) {
			for (int j = 0; j < graph.V(); j++) {
				for (int k = 0; k < graph.adj(j).size(); k++) {
					relaxEdge(j, k);
				}
			}
		}
	}
	
	
	/**
	 * Relaxation method for Bellman-Ford algorithm
	 * @param u	vertex from
	 * @param v vertex to
	 */
	public void relaxEdge(int u, int v){
		
		if (dist[u] == Double.MIN_VALUE ) return;
		
		if (dist[u] * graph.getWeight(u, v) > dist[v]) {
			dist[v] = dist[u] * graph.getWeight(u, v);
			predecessor[v] = u;
		}
	}


}

