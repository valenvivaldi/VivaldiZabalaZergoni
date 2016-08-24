import Data.List ((\\))

indiana :: Int->[(String,Int)]->[String]
indiana n [] =[]
indiana n [x] =[]
indiana n [(a1,b1),(a2,b2)]= [("Van "++a1++" y "++a2)]


indiana n (xs) = [("van "++s1++(" y ")++s2++"... luego Vuelve "++nombredelmenor)]++ indiana (n-i1-i2) (xs\\[(nombredelmayor,numerodelmayor)])
					
							where 	(nombredelmenor,numerodelmenor)=menordelpar ((s1,i1),(s2,i2));
									(nombredelmayor,numerodelmayor)=mayordelpar ((s1,i1),(s2,i2));
									((s1,i1),(s2,i2))=obtenerParMenor(xs)

--indiana 0 [("Indiana",1),("novia",2),("Padre",4),("Suegro",5)]



obtenerPares:: [(String,Int)]->[((String,Int),(String,Int))]
obtenerPares xs  = [(a,b)|a<-xs,b<-(xs\\[a])]

obtenerParMenor:: [(String,Int)]->((String,Int),(String,Int))
obtenerParMenor xs = dameElMenor a bs
			where (a:bs) = (obtenerPares xs)


dameElMenor::  ((String,Int),(String,Int)) ->[((String,Int),(String,Int))] ->((String,Int),(String,Int))
dameElMenor x [] = x
dameElMenor ((a,b),(c,d)) (((e,f),(g,h)):ys) | (f+h)<(b+d) = dameElMenor ((e,f),(g,h)) ys
					|otherwise = dameElMenor ((a,b),(c,d)) ys



mayordelpar:: ((String,Int),(String,Int)) -> (String,Int)
mayordelpar ((a,b),(c,d)) |b<d = (c,d)
							|otherwise = (a,b)

menordelpar:: ((String,Int),(String,Int)) -> (String,Int)
menordelpar ((a,b),(c,d)) |b>d = (c,d)
							|otherwise = (a,b)
