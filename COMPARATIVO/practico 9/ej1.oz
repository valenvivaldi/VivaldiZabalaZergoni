local Counter  in
   class Counter
      attr val
      meth init(V)
	 val := V
      end
      meth inc(V)
	 val := @val + V
      end
      meth show
	 {Browse @val}
      end

      meth get(?V)
	 V=@val
	 
      end	 
   end
   local C X in
      C = {New Counter init(0)}
      {C inc(9)}
      {C show}
      
      {C get(X)}
      {Browse X}
   end
end










