import java.util.List;
import java.util.ArrayList;
public class LabGraph2<T> extends AbstractGraph2<T> {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //create the clone graph will return.
        LabGraph2<T> cloneGraph = new LabGraph2<>();
        for(Vertex<T> vertex : vertices){
            cloneGraph.addVertex(vertex.value);
            for (Edge<T> edge : vertex.edges)
                cloneGraph.addEdge(edge.from.value , edge.to.value);
        }
        return cloneGraph;
    }

    @Override
    public void removeVertex(T deger) {
        //silinecek vertex i al.
        Vertex<T> vertex = verticesMap.get(deger);
        for(Edge<T> edge : vertex.edges){
            if (edge.to.value.equals(deger))
                vertex.edges.remove(edge);
        }
        vertices.remove(vertex);
    }

    @Override
    public List<T> topologicalSort() {
        List<T> returnList = new ArrayList<>();
        try{
            LabGraph2<T> cloneGraph = (LabGraph2<T>) clone();
            for(int i=0;i<vertices.size();i++){
                for(Vertex<T> willDelete : cloneGraph.vertices){
                    if(cloneGraph.inDegree(willDelete.value) == 0){
                        cloneGraph.removeVertex(willDelete.value);
                        returnList.add(willDelete.value);
                        break;
                    }
                }
            }
         }
        catch(CloneNotSupportedException exc){}
        return returnList;
    }
}
