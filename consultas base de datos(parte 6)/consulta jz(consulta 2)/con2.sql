select dni,ocupacion,cuil_cuit
from donante natural join aporta
group by dni
having COUNT(nombre_programa)>2;
