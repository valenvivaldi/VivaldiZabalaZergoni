
Foo = spawn(fun() -> receive 
  {From, foo} -> 
    From ! {self(), bar}, 
    io:format("foo done~n") 
  end 
end).

Bar = spawn(fun() -> receive 
  {From, bar} -> 
    From ! {self(), foo}, 
    io:format("bar done~n") 
  end 
end)
