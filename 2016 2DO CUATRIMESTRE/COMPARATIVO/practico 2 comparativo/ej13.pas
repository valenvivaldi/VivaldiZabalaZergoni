Program experimento;

Var a:integer;

begin
	a:=0;
	while (a>-1)do
		begin
		a:=a+1;
		writeln(a);
		end;



end.     //el ultimo numero positivo es el 32767 y luego pasa al -32768

		//el 32767 se escribe como 15 unos .. entonces como se necesita un digito mas para el signo
		// podemos ver que usa 16bits para los enteros