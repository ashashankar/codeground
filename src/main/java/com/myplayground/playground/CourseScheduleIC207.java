import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CourseScheduleIC207 {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0 ; i<numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
        }
        HashSet<Integer> visited = new HashSet<>();
        for (int i=0 ; i<numCourses; i++) {
            if (!dfs(adj, i, visited)) return false;

        }

        return true;
    }

    public boolean dfs(List<List<Integer>> adj, int course, HashSet<Integer> visited) {
        if(visited.contains(course)) return false;
        if (adj.get(course).size() == 0) return true;

        visited.add(course);
        for (int i=0; i<adj.get(course).size(); i++) {
            boolean flag = dfs(adj, adj.get(course).get(i), visited);
            if (!flag) return false;
            visited.remove(course);
            adj.set(i, new ArrayList<Integer>());
        }

        return true;
    }
}
