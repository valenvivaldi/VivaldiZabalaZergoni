local X in
   X=1
   local P in
      P=proc {$Y}
	     {Browse Y}
	   {Browse X} /*Aca X seria una variable libre!!!!!!!!!*/
	 
	end
      local X in
	 X=2
	 {P X}
      end
    end
end