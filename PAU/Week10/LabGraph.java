public class LabGraph<T> extends AbstractGraph<T> {

    @Override
    public int outDegree(T deger) {
        if (edges.get(deger) == null)
            return -1;
        return edges.get(deger).size();
    }

    @Override
    public int inDegree(T deger) {
        int countEdges = 0;
        if(edges.get(deger)==null)
            return -1;
        for(Vertex<T> vertex:vertices)
            for(Edge<T> edge:vertex.edges)
                if(edge.to.value.equals(deger))
                    countEdges++;
        return countEdges;
    }
}
