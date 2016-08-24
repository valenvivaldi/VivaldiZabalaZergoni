package framework;
/**
 * Title:        BreadthFirstSearch<p>
 * Description:  Class BreadthFirstSearch implements a depth-first search strategy
                 which can be used with any instance of AbstractSearchProblem. <p>
 * Copyright:    Copyright (c) Nazareno Aguirre 2003,2010<p>
 * Company:      None<p>
 * @author Nazareno Aguirre
 * @version 0.3
 */


import java.util.*; // necessary due to the use of lists.

public class BreadthFirstEngine<S extends State> extends AbstractSearchEngine<S> {
	
    private List<S> visited; // used to store the visited states
    private List<S> path; // used to store the path to the success.
    
	
	/** 
	 * Constructor for class BreadthFirstSearch.  
	 * @pre. true.
	 * @post. Lists visited and path are initialised as empty.
	 */	
    public BreadthFirstEngine() {
		super();
		visited = new LinkedList<S>();
		path = new LinkedList<S>();
    }
	
	/** 
	 * Constructor for class BreadthFirstSearch.
	 * @param p is the search problem associated with the engine
	 * being created.
	 * @pre. p!=null.
	 * @post. A reference to p is stored in field problem. Lists visited and
	 * path are initialised as empty.
	 */	
    public BreadthFirstEngine(AbstractSearchProblem<S> p) {		
		super(p);
		visited = new LinkedList<S>();
		path = new LinkedList<S>();
    }
	
	
	/** 
	 * Starts the search for successful states for problem, following a 
	 * depth-first strategy.
	 * @return true iff a successful state is found.
	 * @pre. problem!=null.
	 * @post. the search is performed, the visited are stored in
	 * list visited, the path in list path, and true is returned iff a       
     * successfull state is found.	 
	 */
    public boolean performSearch() {
        
		// first, we initialise the data structures for the search
		visited = new LinkedList<S>();
		// we get the initial state
        S initialState = problem.initialState();
		
		// now we call a recursive method implementing depth-first
		boolean resultSearch = BreadthFirst(initialState);
		return resultSearch;
		
    } // end of method performSearch
	
	/** 
	 * Method that performs the search implementing a depth-first visit 
	 * recursively.
	 * @return true iff a successful state is found.
	 * @pre. problem!=null.
	 * @post. the search is performed, the visited are stored in
	 * list visited, the path in list path, and true is returned iff a       
     * successfull state is found.	 
	 */	
	private boolean BreadthFirst(S s) {	
		if (!visited.contains(s)) {
			visited.add( s); // we add s to the list of visited   
            if (problem.success(s)) {
				
				path.add(s); // we add the success state to the path
				return true;
				
				
			} // end then branch
			else {
				boolean found;
				LinkedList<S> cola = new LinkedList<S>();
				cola.add(s);
				visited.add(s);
				while(cola.size()!=0){
					S aux = cola.poll();
					visited.add(aux);
					if (problem.success(aux)){
						return true;


					}else{
						List<S> sucesoresAux = problem.getSuccessors(aux);
						cola.addAll(sucesoresAux);

					}


				}
				return false;

			}    
	    }
	    return false;
    }     
	
	/** 
	 * Returns the path to a previously calculated successful state for problem.
	 * @return the list of nodes corresponding to the path from the root to
	 * the successful node.
	 * @pre. performSearch() has been executed and finished successfully.
	 * @post. the path to the found success node is returned.  
	 */	
    public List<S> getPath() {
        return path;
    } // end of getPath()
    
	
	/** 
	 * Reports information regarding a previously executed search.   
	 * @pre. performSearch() has been executed and finished.
	 * @post. A report regarding the search is printed to standard output.
	 * This report consists of the length of the path obtained, and the number
	 * of visited states.
	 */    
	public void report() {
        System.out.println("Length of path to state when search finished: "+path.size());
		System.out.println("Number of visited when search finished: "+visited.size());
		
    } // end of report()
	

	
} // end of class DepthFirst
