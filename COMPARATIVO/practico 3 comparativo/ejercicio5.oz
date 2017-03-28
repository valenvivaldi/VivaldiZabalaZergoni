local X in
   local Y in
      X=1
      {Number.'+' 2 X Y}
      local T in
	 {Value.'>' X Y T}
	 if T then
	    {Browse X}
	 else
	    {Browse Y}
	 end
      end
   end
end