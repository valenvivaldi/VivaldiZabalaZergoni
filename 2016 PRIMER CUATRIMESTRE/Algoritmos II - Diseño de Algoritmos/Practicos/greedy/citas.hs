obtenerCitasHoy :: String->[(String,String,Float,Float,Int)]->[(String,String,Float,Float,Int)]->[(String,String,Float,Float,Int)]
obtenerCitasHoy x xs [] = xs
obtenerCitasHoy x xs ((a,b,c,d,e):ys) | (a==x) &&(compatible xs (a,b,c,d,e)) = obtenerCitasHoy x (xs++[(a,b,c,d,e)]) ys
										| otherwise =obtenerCitasHoy x xs ys



compatible :: [(String,String,Float,Float,Int)] -> (String,String,Float,Float,Int)-> Bool
compatible [] a = True
compatible ((a,b,c,d,e):xs) (w,x,y,z,h) | (y>d) ||(c>z) = compatible xs (w,x,y,z,h)
									| otherwise = False






s
