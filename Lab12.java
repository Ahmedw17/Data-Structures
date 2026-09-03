public class Lab12 {

    private char[] vertices;
    private int[][] adjMatrix;
    private int numVertices;
    private int maxSize;

    
    public Lab12(int size) {
        maxSize = size;
        vertices = new char[maxSize];
        adjMatrix = new int[maxSize][maxSize];
        numVertices = 0;
    }

    
    public boolean isEmpty() {
        return numVertices == 0;
    }

    
    public boolean isFull() {
        return numVertices == maxSize;
    }

    
    public int findVertex(char v) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] == v)
                return i;
        }
        return -1;
    }

    
    public void addVertex(char v) {
        if (isFull()) {
            System.out.println("addVertex failed- Error: Full Graph!");
            return;
        }

        vertices[numVertices] = v;
        numVertices++;
    }

    
    public void deleteVertex(char v) {
        int index = findVertex(v);

        if (index == -1) {
            System.out.println("deleteVertex failed- Error: Unknown vertex " + v);
            return;
        }

        
        for (int i = index; i < numVertices - 1; i++) {
            vertices[i] = vertices[i + 1];
        }

        
        for (int i = index; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = adjMatrix[i + 1][j];
            }
        }

        
        for (int i = 0; i < numVertices; i++) {
            for (int j = index; j < numVertices - 1; j++) {
                adjMatrix[i][j] = adjMatrix[i][j + 1];
            }
        }

        numVertices--;
    }

   
    public void addEdge(char from, char to) {
        int i = findVertex(from);
        int j = findVertex(to);

        if (i == -1 || j == -1) {
            System.out.println("Error: One or both vertices not found.");
            return;
        }

        adjMatrix[i][j] = 1;
    }

    
    public void deleteEdge(char from, char to) {
        int i = findVertex(from);
        int j = findVertex(to);

        if (i == -1 || j == -1 || adjMatrix[i][j] == 0) {
            System.out.println("deleteEdge failed- Error: There is no edge between (" 
                    + from + ") and (" + to + ") to be deleted.");
            return;
        }

        adjMatrix[i][j] = 0;
    }

    
    public int outdegree(char v) {
        int index = findVertex(v);

        if (index == -1)
            return -1;

        int count = 0;

        for (int j = 0; j < numVertices; j++) {
            if (adjMatrix[index][j] == 1)
                count++;
        }

        return count;
    }

    
    public int indegree(char v) {
        int index = findVertex(v);

        if (index == -1)
            return -1;

        int count = 0;

        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[i][index] == 1)
                count++;
        }

        return count;
    }

   
    public int numberOfEdges() {
        int count = 0;

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] == 1)
                    count++;
            }
        }

        return count;
    }

   
    public void printVertices() {
        System.out.println("*** Graph Vertices ***");

        for (int i = 0; i < numVertices; i++) {
            System.out.println("vertex " + (i + 1) + ": " + vertices[i]);
        }
    }

    
    public void printGraph() {
        System.out.println("\n*** Graph Vertices and their Edges ***\n");

        for (int i = 0; i < numVertices; i++) {

            System.out.print(">> vertex " + (i + 1) + ": " + vertices[i]
                    + " is connected to ");

            boolean hasEdge = false;

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j] == 1) {
                    System.out.print("(" + vertices[j] + ") ");
                    hasEdge = true;
                }
            }

            if (!hasEdge)
                System.out.print("Null");

            System.out.println("\n");
        }
    }

    
    public static void main(String[] args) {

        Lab12 g = new Lab12(4);

        
        g.addVertex('w');
        g.addVertex('x');
        g.addVertex('y');
        g.addVertex('z');

       
        g.addEdge('w', 'x');
        g.addEdge('w', 'y');
        g.addEdge('y', 'z');

        
        g.printVertices();
        g.printGraph();

        
        System.out.println("Number of vertices: " + g.numVertices);
        System.out.println("Number of edges: " + g.numberOfEdges());

        
        System.out.println("\nindeg/outdeg of vertex w: "
                + g.indegree('w') + "/" + g.outdegree('w'));

        System.out.println("indeg/outdeg of vertex z: "
                + g.indegree('z') + "/" + g.outdegree('z'));

        
        g.addVertex('a');

       
        g.deleteEdge('y', 'w');

        
        g.deleteVertex('Z');
    }
}
