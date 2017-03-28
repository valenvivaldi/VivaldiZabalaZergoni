local X in
   X=1
   local P in
      P=proc{$Y}
	   local P in
	      local A in
		 P=proc{$Z} Z=10 end
		 {P A}
		 local T in
		    T=A+Y
		    {Browse T}
		  end
	      end
	   end
	end
      {P X}
   end

end