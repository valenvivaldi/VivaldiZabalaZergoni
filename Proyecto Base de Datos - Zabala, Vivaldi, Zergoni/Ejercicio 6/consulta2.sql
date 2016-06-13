select dni, n_y_ap as "nombre y apellido",ocupacion,cuil_cuit as "cuil/cuit"
from (select dni,ocupacion,cuil_cuit from donante natural join aporta group by dni having COUNT(nombre_programa)>2) as don_ac
natural join persona;
