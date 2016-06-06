select nombre_programa, count(frecuencia) 
from ciudad_de_los_niños.aporta
where frecuencia='Mensual'
group by nombre_programa 
