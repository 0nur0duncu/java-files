import java.util.List;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ArrayDeque;
public class LabGraph3<T extends Comparable<T>> extends AbstractGraph3<T> {
    @Override
    public List<T> dfs(T baslangic) {
        Stack<T> stack = new Stack<>();//create stack.
        List<T> visited = new ArrayList<>();//List is abstract so, we cannot use with new.
        stack.push(baslangic);//added starting vertex.
        while(!stack.isEmpty()){//when stack is not empty
            T available = stack.pop();//discard a element.
            if(visited.contains(available))
                continue;
            visited.add(available);//added available to visited list.
            List<T> neighboor = new ArrayList<>();//new list for neighboor.
            for(Edge<T> edge:verticesMap.get(available).edges){//neighboors of available
                neighboor.add(edge.to.value);
            }
            Collections.sort(neighboor);//sorted increasing 
            Collections.reverse(neighboor);//reverse the neighboor
            for(T k:neighboor)//there not exist in visited list the neighboor. 
                if(!visited.contains(k))
                    stack.push(k);
        }
        return visited;
    }
    
    @Override
    public List<T> bfs(T baslangic) {
        ArrayDeque<T> queu = new ArrayDeque<>();//create queue.
        List<T> visited = new ArrayList<>();//List is abstract so, we cannot use with new.
        queu.offer(baslangic);//added starting vertex.
        while(!queu.isEmpty()){//when queu is not empty
            T available = queu.poll();//discard a element.
            if(visited.contains(available))
                continue;
            visited.add(available);//added available to visited list.
            List<T> neighboor = new ArrayList<>();//new list for neighboor.
            for(Edge<T> edge:verticesMap.get(available).edges){//neighboors of available
                neighboor.add(edge.to.value);
            }
            Collections.sort(neighboor);//sorted increasing 
            for(T k:neighboor)//there not exist in visited list the neighboor. 
                if(!visited.contains(k))
                    queu.offer(k);
        }
        return visited;
    }
}
