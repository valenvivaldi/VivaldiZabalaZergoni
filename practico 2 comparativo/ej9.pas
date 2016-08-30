Program Example;
Var x:integer;
	Function F(a:integer):integer;
		begin
			F:=x*a;
		end;

	Procedure P(y:integer);
		var x:integer;
			z:boolean;
	begin
		x:=2;
		z:= ( y mod 2 = 0);
		if z then
			x:= F(y+1)
		else
			x:=F(y);

		writeln(x);
	end;

	begin{main}
		x:=2;
		P(x);
	end.