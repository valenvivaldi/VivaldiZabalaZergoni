Program ej2;
var
	x:integer;
	y:integer;

function  inc():integer; 
	begin
		x:=x+1;   //modificamos la variable global.. entonces si se ejecuta dos veces podemos ver que da 3 y luego da 4.. por lo que podriamos 
		inc:=x;   // si en la funcion pasaramos como parametro la x y NO le ponemos VAR el passaje seria por valor y no se modifcara el ambiente
	end;
 	
begin
	x:=2;
	writeln(inc()+inc()); 
end.