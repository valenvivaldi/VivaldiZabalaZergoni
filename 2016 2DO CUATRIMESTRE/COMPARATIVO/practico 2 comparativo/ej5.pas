Program p;

type A = record 
		x:integer;
		end;

type B = record    // porque un tipo se llama  A y el otro B  ya te dice que son distintos.. por lo que usar una equivalencia de tipos por nombre!!!!
		//y:integer;
		x:integer;
		end;

var
	primero:A;
	segundo:B;
begin
	
	primero:=segundo;
	if (primero=segundo) then writeln('son equivalentes (?');
end.