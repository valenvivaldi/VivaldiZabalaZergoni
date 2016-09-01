Program CallToC;
Var x:integer; external name 'y';
Procedure inc_x; external name 'inc_y';

{$L libreriainc.a}

begin { programa principal }
{a}
{wer}
x := 1;
inc_x;
writeln('x=',x)
end.	