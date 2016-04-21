 
intercala :: a -> [a] -> [[a]]
intercala x [] = [[x]]
intercala x (y:ys) = (x:y:ys) : [y:zs | zs <- intercala x ys]
--------------------
 
permutaciones :: [a] -> [[a]]
permutaciones []     = [[]]
permutaciones (x:xs) = 
    concat [intercala x ys | ys <- permutaciones xs]
 

--permutaciones :: (Ord a) => [a] -> [[a]]
--permutaciones xs = [(a:p) | a <- xs, p <- permutaciones (eliminar a xs)]

--eliminar ::  (Ord a)=> a -> [a]-> [a]
--eliminar a (x:xs) | (a==x) = xs
--		|otherwise = x:(eliminar a xs)
				
				
ordenado :: (Ord a)=> [a] -> Bool
ordenado [] = True
ordenado [x] = True
ordenado (x:y:xs) | (x<=y) = ordenado (y:xs)
				| otherwise = False

subconjuntos :: [a] -> [[a]]
subconjuntos []     = [[]]
subconjuntos (x:xs) = [x:ys | ys <- sub] ++ sub
    where sub = subconjuntos xs  

sublistas::[a]->[[a]]
sublistas []= [[]]
sublistas(x:xs)=[x:ys|ys<-sublistas xs] ++ sublistas xs 

