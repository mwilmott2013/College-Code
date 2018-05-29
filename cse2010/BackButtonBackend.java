import java.util.Stack;

public class BackButtonBackend {
	
	private class URLandTime implements Comparable<URLandTime> {
		private String url;
		private double time;
		public String getUrl () {
			return url;
		}
		public double getTime () {
			return time;
		}
		public URLandTime(final String url_, final double time_) {
			url = url_;
			time = time_;
		}
		public String toString () {
			String result = "url: " + url +" " + "Time: "+time;
			return result;
		}
		@Override
		public int compareTo (final URLandTime o) {
			if (this.time > o.getTime()) {
				return 1;
			} else if (this.time < o.getTime()) {
				return -1;
			}
			return 0;
		}
	}
	SuperStack<URLandTime> visited_past = new SuperStack<URLandTime>();
	Stack<URLandTime> visited_future = new Stack<URLandTime>();
	public final void add (final String url, final double time) {
		// Add information of the currently visited website.
	}
	public final URLandTime back () {
		// Press back button.
	}
	public final URLandTime forward () {
		// Press forward. Move to the next Url.
	}
	public final URLandTime backMostTimeSpent () {
		// Return an instance of URLandTime with the most time spent
		// from the past history. Note, this function does not take into account
		// future history.
	}
	public final String toString () {
		StringBuilder sb = new StringBuilder();
		String result = "Past: " +"\n";
		sb.append(result);
		sb.append("[" +"\n");
		for (URLandTime urLandTime : this.visited_past.getMainStack()) {
			sb.append(urLandTime.toString()+" \n");
		}
		sb.append("]" +"\n");
		result = "Future: " +"\n";
		sb.append(result);
		sb.append("[");
		for (URLandTime urLandTime : this.visited_future) {
			sb.append(urLandTime.toString()+" \n");
		}
		sb.append("]" +"\n");
		return new String(sb);
	}
}