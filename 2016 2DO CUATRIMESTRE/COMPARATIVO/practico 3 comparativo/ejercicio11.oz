local Ints in  /* el lazy hace que la Lista se calcule segun uno necesita... Si le hago browse sin pedirle que se calcule hasta x elemento se muestra vacia  */
   fun lazy {Ints N}
      N | {Ints N+1}
   end
   local L in
       L={Ints 1}                                    
     /* L=[e l i s a] Ejercicio desconocido*/
      /*case L of
	 A|B|C|_ then {Browse A+B+C} /*Hago que la lista cargue hasta el 3 elemento*/
      end*/
      {Browse L.2.2.2.2.2.2.2.2.2.2.2.2.1} /*Hago que la lista cargue hasta el elemento 13 ... y luego cuando le hago browse de la lista muestra hasta donde cargo... */   
	 {Browse L}
   end
   
end