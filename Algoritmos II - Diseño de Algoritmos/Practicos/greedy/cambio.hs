
obtenerCambio:: Int->[(Int,Int)]->[Int]
obtenerCambio x [] =[]
obtenerCambio 0 ((y,z):ys) =[]
obtenerCambio x ((y,0):ys) =obtenerCambio x ys 
obtenerCambio x ((y,z):ys) | (x>=y) = [y]++obtenerCambio (x-y) ((y,z-1):ys)
						|(x<y)   = obtenerCambio x ys
