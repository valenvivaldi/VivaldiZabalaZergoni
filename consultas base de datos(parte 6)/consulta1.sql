select nombre_programa, count(frecuencia) as Total_Aportes_Mensuales
from ciudad_de_los_niños.aporta
where frecuencia='Mensual'
group by nombre_programa 
