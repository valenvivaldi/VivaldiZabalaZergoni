program ej1p8;

Type DiaSemana=(DOM,LUN,MAR,MIE,JUE,VIE,SAB);


var s : Set of DiaSemana;
a: integer absolute s; //declaro una variable entera "a" que es la direccion de s.. entonces a tiene la misma direccion de memoria de s PERO a es entera
B: String absolute s;

begin
	s:=[SAB];
	writeln(a);
end.