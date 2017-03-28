evalDC:: ((String,String)->Bool)->((String,String)->Bool)->((String,String)->[(String,String)])->([Bool]->Bool)->(String,String)->Bool
evalDC isBase base split join x y| isBase x y= base x y
                                | otherwise = join (map ( evalDC isBase base split join x) (split y ))
                                
                                
isBase:: (String,String)->Bool
isBase (p,t) = (p.length >=t.length)


base :: (String,String)->Bool
base (p,t) | (p.length == t.length) = iguales(p,t)
            | otherwise =False

split:: (String,String)-> [(String,String)]
split (p,t) = [(b,t),(c,t),(,t)]

      where [a = (p.length)/2, b = (take a p),c=(drop a p],d=(take ((t.length-1)*2)(drop (p.length - (t.length-1))) p )

join :: [Bool]->Bool
join [] = False
join x:xs = x || join xs
