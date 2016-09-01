local X in
   local Y in
      X= person(name:'George' age:26)/*Si poniamos 25 nos tiraba error por el X=Y...Le pusimos 26 y anda porque unifica*/
      Y= person(name:'George' age:26)
      X=Y      
      {Browse Y}
   end            
 /*  {Browse Y}Me dice que y no esta declarada porque Y no esta en el ambiente*/
end